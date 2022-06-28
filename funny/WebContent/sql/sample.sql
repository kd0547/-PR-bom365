-- 회원--------------------------------------------------------------------------------------------------------------------------------
INSERT INTO supporter
VALUES (
    'admin', '관리자', 'rhksflwk', '01079797979',  '17023', '경기 용인시 처인구 포곡읍 에버랜드로 199'
);
INSERT INTO supporter
VALUES (
    'test', '테스트', '1234', '01011111111', '45352', '상세주소'
);
INSERT INTO supporter
VALUES (
    'roEhd', '김개똥', '1234', '01012345678', '12345', '어딘가로1'
);
INSERT INTO supporter
VALUES (
    'thEhd', '김소똥', '1234', '01098745632', '25896', '어딘가로2'
);
INSERT INTO supporter
VALUES (
    'akfEhd', '김말똥', '1234', '01025632563', '15963', '어딘가로3'
);
INSERT INTO supporter
VALUES (
    'ekfrEhd', '김닭똥', '1234', '01023698515', '21536', '어딘가로4'
);
INSERT INTO supporter
VALUES (
    'toEhd', '김새똥', '1234', '01025436285', '21548', '어딘가로5'
);
INSERT INTO supporter
VALUES (
    'wnlEhd', '김쥐똥', '1234', '01024576138', '35716', '어딘가로6'
);
INSERT INTO supporter
VALUES (
    'gkrEhd', '김학똥', '1234', '01030240532', '75439', '어딘가로7'
);
INSERT INTO supporter
VALUES (
    'RnjdEhd', '김꿩똥', '1234', '01042731005', '71645', '어딘가로8'
);
INSERT INTO supporter
VALUES (
    'qoaEhd', '김뱀똥', '1234', '01024673905', '67842', '어딘가로9'
);
INSERT INTO supporter
VALUES (
    'didEhd', '김양똥', '1234', '01020589672', '45352', '어딘가로10'
);

-- 입양신청 샘플--------------------------------------------------------------------------------------------------------------------------------
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청1','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청2','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청3','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청4','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청6','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청7','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청8','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청9','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청10','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청11','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청12','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청13','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청14','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청15','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청16','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청16','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청17','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청18','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청19','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청20','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청21','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청22','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO application
VALUES (
	(select nvl(max(application_number),0)+1 from application),10,'test','입양신청23','신청신청신청신청신청신청신청신청', to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);

-- 일시후원 샘플--------------------------------------------------------------------------------------------------------------------------------
INSERT INTO support_temporary
VALUES (
	(select nvl(max(temporary_number),0)+1 from support_temporary),'test',10000,to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO support_temporary
VALUES (
	(select nvl(max(temporary_number),0)+1 from support_temporary),'test',10000,to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO support_temporary
VALUES (
	(select nvl(max(temporary_number),0)+1 from support_temporary),'test',10000,to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);
INSERT INTO support_temporary
VALUES (
	(select nvl(max(temporary_number),0)+1 from support_temporary),'test',10000,to_char(sysdate, 'yyyy/mm/dd hh24:mi')
);

	


-- 게시물 샘플--------------------------------------------------------------------------------------------------------------------------------
INSERT INTO board
VALUES (
	(select nvl(max(board_number),0)+1 from board),'admin',to_char(sysdate, 'yyyy/mm/dd hh24:mi'),'2022.06 봄365 공지사항','공지공지공지공지공지공지공지공지','공지',default
);
INSERT INTO board
VALUES (
	(select nvl(max(board_number),0)+1 from board),'roEhd',to_char(sysdate, 'yyyy/mm/dd hh24:mi'),'물품 후원도 가능한가요?','집에 사료가 많아서 후원하려고요','일반',default
);
INSERT INTO board
VALUES (
	(select nvl(max(board_number),0)+1 from board),'thEhd',to_char(sysdate, 'yyyy/mm/dd hh24:mi'),'날씨가 더워졌네요,,','보호소 아이들 많이 덥겠어요. 여름준비 일손 필요하다고 들었는데 조만간 방문 해야겠어요','일반',default
);
INSERT INTO board
VALUES (
	(select nvl(max(board_number),0)+1 from board),'akfEhd',to_char(sysdate, 'yyyy/mm/dd hh24:mi'),'안양 사시는 분 중에 이번 주 주말 봉사 같이 가실 분계신가요','봉사 가고싶은데 교통편이 까다롭네요ㅜㅜ','일반',default
);

-- 마감 샘플--------------------------------------------------------------------------------------------------------------------------------
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'roEhd','2022/07/05','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'thEhd','2022/07/05','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'akfEhd','2022/07/05','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'ekfrEhd','2022/07/05','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'toEhd','2022/07/05','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'wnlEhd','2022/07/05','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'gkrEhd','2022/07/05','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'RnjdEhd','2022/07/05','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'qoaEhd','2022/07/05','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'didEhd','2022/07/05','오전'
);

INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'roEhd','2022/07/05','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'thEhd','2022/07/05','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'akfEhd','2022/07/05','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'ekfrEhd','2022/07/05','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'toEhd','2022/07/05','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'wnlEhd','2022/07/05','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'gkrEhd','2022/07/05','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'RnjdEhd','2022/07/05','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'qoaEhd','2022/07/05','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'didEhd','2022/07/05','오후'
);

-- 오전 마감 샘플--------------------------------------------------------------------------------------------------------------------------------
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'roEhd','2022/07/14','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'thEhd','2022/07/14','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'akfEhd','2022/07/14','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'ekfrEhd','2022/07/14','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'toEhd','2022/07/14','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'wnlEhd','2022/07/14','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'gkrEhd','2022/07/14','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'RnjdEhd','2022/07/14','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'qoaEhd','2022/07/14','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'didEhd','2022/07/14','오전'
);

-- 오후 마감 샘플--------------------------------------------------------------------------------------------------------------------------------
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'roEhd','2022/07/15','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'thEhd','2022/07/15','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'akfEhd','2022/07/15','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'ekfrEhd','2022/07/15','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'toEhd','2022/07/15','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'wnlEhd','2022/07/15','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'gkrEhd','2022/07/15','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'RnjdEhd','2022/07/15','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'qoaEhd','2022/07/15','오후'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'didEhd','2022/07/15','오후'
);

-- 봉사 이전 날짜 샘플--------------------------------------------------------------------------------------------------------------------------------
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'test','2022/04/12','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'test','2022/05/19','오전'
);
INSERT INTO volunteer
VALUES (
	(select nvl(max(volunteer_number),0)+1 from volunteer),'test','2022/06/15','오후'
);