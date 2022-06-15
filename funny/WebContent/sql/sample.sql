-- 회원
INSERT INTO supporter
VALUES (
    'admin', '관리자', 'rhksflwk', '01079797979',  '17023', '경기 용인시 처인구 포곡읍 에버랜드로 199'
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

INSERT INTO board
VALUES (
	(select nvl(max(board_number),0)+1 from board),'admin',to_char(sysdate, 'yyyy.mm.dd hh24:mi'),'[필독] 2022.06 봉사 신청 공지사항','공지공지공지공지공지공지공지공지','공지',default
);
INSERT INTO board
VALUES (
	(select nvl(max(board_number),0)+1 from board),'roEhd',to_char(sysdate, 'yyyy.mm.dd hh24:mi'),'봉사 신청합니다','07/15 15시에 방문하겠습니다. 혹시 같이 봉사가실 분 계시면 댓글 남겨주세요','일반',default
);
INSERT INTO board
VALUES (
	(select nvl(max(board_number),0)+1 from board),'thEhd',to_char(sysdate, 'yyyy.mm.dd hh24:mi'),'날씨가 더워졌네요,,','보호소 아이들 많이 덥겠어요. 여름준비 일손 필요하다고 들었는데 내일(06.11) 오후 6시에 봉사하러가겠습니다','일반',default
);
INSERT INTO board
VALUES (
	(select nvl(max(board_number),0)+1 from board),'akfEhd',to_char(sysdate, 'yyyy.mm.dd hh24:mi'),'안양 사시는 분 중에 이번 주 주말 봉사 같이 가실 분계신가요','봉사 가고싶은데 교통편이 까다롭네요ㅜㅜ','일반',default
);




select * from board where category='공지' order by board_number desc;
