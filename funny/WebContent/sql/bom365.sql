select * from supporter;
select * from animal;
select * from application;
select * from support_regular;
select * from support_temporary;
select * from board;
select * from board_comment;
select * from volunteer;

-- drop table supporter;
-- drop table animal;
-- drop table application;
-- drop table support_regular;
-- drop table support_temporary;
-- drop table board;
-- drop table board_comment;
-- drop table volunteer;

-- truncate table supporter;
-- truncate table animal;
-- truncate table application;
-- truncate table support_regular;
-- truncate table support_temporary;
-- truncate table board;
-- truncate table board_comment;
-- truncate table volunteer;

 -- 회원
CREATE TABLE supporter (  
	supporter_id				VARCHAR2(20)		CONSTRAINT PK_member PRIMARY KEY,
	supporter_name		VARCHAR2(20)		NOT NULL,
	supporter_password	VARCHAR2(20)		NOT NULL,
	phone_number			VARCHAR2(20)		NOT NULL,
	post_code					VARCHAR2(5)			NOT NULL,
	detailed_address		VARCHAR2(200)		NOT NULL
);

-- 동물
CREATE TABLE animal (   
	animal_number			NUMBER					CONSTRAINT PK_animal PRIMARY KEY,
	supporter_id				VARCHAR2(20),
	animal_name				VARCHAR2(50)		NOT NULL,
	animal_species			VARCHAR2(50)		NOT NULL,
	animal_type				VARCHAR2(50)		NOT NULL,
	animal_gender			VARCHAR2(50)		NOT NULL,
	animal_age				VARCHAR2(50) 		NOT NULL,
	animal_age_num		NUMBER					DEFAULT 0 NOT NULL,
	animal_weight			NUMBER					NOT NULL,
	animal_image			VARCHAR2(200)		NOT NULL,
	isAdoption					VARCHAR2(10)  		DEFAULT 'false' NOT NULL,
	
	CONSTRAINTS FK_supporter_TO_animal FOREIGN KEY (supporter_id) REFERENCES  supporter (supporter_id)
	ON DELETE SET NULL,		-- 입양자가 회원 탈퇴해도 동물데이터 남아있음
	CONSTRAINTS CH_species CHECK (animal_species IN('개','고양이')),		--이 두 가지 외의 분류는 없음
	CONSTRAINTS CH_adoption CHECK (isAdoption IN('true','false'))			--이 두 가지 외의 분류는 없음
);
-- 나이 숫자로 변환
UPDATE animal SET animal_age_num = nvl(substr(animal_age,0, instr(animal_age, '살')-1), 0) +
nvl(
decode(
instr(animal_age,'살'), 0, substr(animal_age, 0, LENGTH(animal_age) -3) ,
decode(LENGTH(substr(animal_age,0 ,instr(animal_age,'살')-1)),
1, substr(animal_age,instr(animal_age, '살')+2,LENGTH(animal_age)-6 ),
2, substr(animal_age,instr(animal_age, '살')+2,LENGTH(animal_age)-7 ))
)
,0)
*0.01;

-- 입양신청서
CREATE TABLE application (	
	application_number	NUMBER					CONSTRAINT application PRIMARY KEY,
	animal_number			NUMBER					NOT NULL,
	supporter_id				VARCHAR2(20),
	application_title			VARCHAR2(100) 	NOT NULL,
	application_content	VARCHAR2(4000)	NOT NULL,
	application_date		VARCHAR2(	20)		NOT NULL,
	
	CONSTRAINTS FK_animal_TO_application FOREIGN KEY (animal_number) REFERENCES  animal (animal_number)
	ON DELETE CASCADE,			-- animal 데이터 삭제시 입양신청내역 삭제
	CONSTRAINTS FK_supporter_TO_application FOREIGN KEY (supporter_id) REFERENCES  supporter (supporter_id)
	ON DELETE SET NULL		-- 신청자가 회원 탈퇴해도 신청서 남아있음
);

-- 정기후원
CREATE TABLE support_regular (
	regular_number			NUMBER					CONSTRAINT support_regular PRIMARY KEY,
	supporter_id				VARCHAR2(20)		NOT NULL,
	regular_amount			NUMBER(10,4)		NOT NULL,
	regular_bank				VARCHAR2(50)		NOT NULL,
	regular_account		VARCHAR2(20)		NOT NULL,
	regular_paymentDate VARCHAR2(20)		NOT NULL,
	regular_date				VARCHAR2(20)		NOT NULL,
	regular_end				VARCHAR2(20)		DEFAULT '진행중' NOT NULL,

	CONSTRAINTS FK_MEMBER_TO_REGULAR FOREIGN KEY (supporter_id) REFERENCES  supporter (supporter_id)
	ON DELETE CASCADE	
);

--일시후원
CREATE TABLE support_temporary (
	temporary_number	NUMBER					CONSTRAINT support_temporary PRIMARY KEY,
	supporter_id				VARCHAR2(20),
	temporary_amount	NUMBER(10,4)		NOT NULL,
	temporary_date			VARCHAR2(20)		NOT NULL,
	
	CONSTRAINTS FK_supporter_TO_temporary FOREIGN KEY (supporter_id) REFERENCES  supporter (supporter_id)
	ON DELETE SET NULL		-- 일시후원자가 회원 탈퇴해도 후원목록 남아있음
);

-- 게시판
CREATE TABLE board (
	board_number			NUMBER					CONSTRAINT board PRIMARY KEY,
	supporter_id				VARCHAR2(20),
	board_date				VARCHAR2(20)		NOT NULL,
	board_title					VARCHAR2(100)		NOT NULL,
	board_content			VARCHAR2(3000)	NOT NULL,
	category						VARCHAR2(20)		NOT NULL,
	board_commentCnt	NUMBER					DEFAULT 0 NOT NULL,
	
	CONSTRAINTS FK_supporter_TO_board FOREIGN KEY (supporter_id) REFERENCES  supporter (supporter_id)
	ON DELETE SET NULL,		-- 작성자가  회원 탈퇴해도 게시글 남아있음
	CONSTRAINTS CH_category CHECK (category IN('일반','공지'))			--이 두 가지 외의 분류는 없음
);

 -- 댓글
CREATE TABLE board_comment (
	comment_number		VARCHAR2(20)		CONSTRAINT board_comment PRIMARY KEY,
	board_number			NUMBER					NOT NULL,
	supporter_id				VARCHAR2(20)		NOT NULL,
	comment_content		VARCHAR2(100)		NOT NULL,
	comment_date			VARCHAR2(20)		NOT NULL,
	
	CONSTRAINTS FK_board_TO_comment FOREIGN KEY (board_number) REFERENCES  board (board_number)
	ON DELETE CASCADE,			-- 게시글 삭제시 댓글 삭제
	CONSTRAINTS FK_supporter_TO_comment FOREIGN KEY (supporter_id) REFERENCES  supporter (supporter_id)
	ON DELETE CASCADE		-- 댓글작성자가 회원 탈퇴시 댓글 삭제
);

-- 봉사신청
CREATE TABLE volunteer (
	volunteer_number		NUMBER					CONSTRAINT volunteer PRIMARY KEY,
	supporter_id				VARCHAR2(20)		NOT NULL,
	volunteer_date			VARCHAR2(20)		NOT NULL,
	volunteer_time			VARCHAR2(20)		NOT NULL,
	
	CONSTRAINTS FK_supporter_TO_volunteer FOREIGN KEY (supporter_id) REFERENCES  supporter (supporter_id)
	ON DELETE CASCADE,		-- 봉사신청자가 회원 탈퇴시 신청 내역 삭제
	CONSTRAINTS CH_time CHECK (volunteer_time IN('오전','오후'))			--이 두 가지 외의 분류는 없음
);
