-- tdUser 로 접속

show DATABASES;
use todolist;

CREATE TABLE tbl_todo_list(
	td_seq	BIGINT	AUTO_INCREMENT	PRIMARY KEY,
    td_date		VARCHAR(20) NOT NULL,
    td_time 	VARCHAR(20) NOT NULL,
	td_todo		VARCHAR(200) NOT NULL,
    td_place	VARCHAR(125)
);
delete from tbl_todo_list;


INSERT INTO tbl_todo_list(
	td_date, td_time, td_todo, td_place)
VALUES( '2021-05-23', '12:53:30', '밥먹기', '급식실');

INSERT INTO tbl_todo_list(
	td_date, td_time, td_todo, td_place)
VALUES( '2021-05-24', '10:00:23', '공부하기', '집');

SELECT * FROM tbl_todo_list 
ORDER BY td_date DESC, td_time DESC;


DELETE FROM tbl_todo_list
WHERE td_seq = 4;


-- AUTO INCREMENT 값 초기화
ALTER TABLE tbl_todo_list AUTO_INCREMENT = 0;

-- AUTO INCREMENT 값을 초기화 한 후, 테이블 안의 모든 데이터의 ID값을 재조정하기
ALTER TABLE tbl_todo_list AUTO_INCREMENT=1;
SET @COUNT = 0;
UPDATE tbl_todo_list SET td_seq = @COUNT:=@COUNT+1;
