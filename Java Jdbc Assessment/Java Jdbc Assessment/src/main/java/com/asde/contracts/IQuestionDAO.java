package com.asde.contracts;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.asde.beans.Answer;
import com.asde.beans.Question;

public interface IQuestionDAO {
    boolean insertQuestion(Question question) throws SQLException; 
    List<Question> getAllQuestions()  throws SQLException; 
    List<Question> getAllQuestions(int votes)  throws SQLException; 
    Question getQuestion(int questionId)  throws SQLException;
    int upOrDownVoteQuestion(int questionId, boolean incrOrDecr)  throws SQLException; 
    List<Answer> getAnswers(int questionId)  throws SQLException;
    boolean deleteQuestion(int questionId) throws SQLException;
}
