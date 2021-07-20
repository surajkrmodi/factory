CREATE TABLE `question` (
  `qid` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(500) DEFAULT NULL,
  `uid` int(11) NOT NULL,
  `votes` int(11) DEFAULT NULL,
  PRIMARY KEY (`qid`)
);
CREATE TABLE `answer` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `qid` int(11) DEFAULT NULL,
  `answer` varchar(500) DEFAULT NULL,
  `ans_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`qid`) REFERENCES `question` (`qid`)
);
INSERT INTO
  question(qid, question, uid, votes)
VALUES(101, 'Who invented java', 1001, 0),(102, 'what is earth size', 1002, 3),(103, 'why people eat chalk', 1001, 7);
INSERT INTO
  answer(aid, qid, answer, ans_user_id)
VALUES(201, 101, 'James Gosling', 1002),(202, 102, '6371', 1001),(203, 103, 'For Fun', 1002);