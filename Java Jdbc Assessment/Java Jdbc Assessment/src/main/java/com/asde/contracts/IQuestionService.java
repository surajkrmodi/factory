package com.asde.contracts;

import java.sql.SQLException;
import java.util.List;

import com.asde.beans.Answer;
import com.asde.beans.Question;
import com.asde.exception.QuestionNotFoundException;
import com.asde.exception.QuestionSQLException;

public interface IQuestionService {
    boolean insertQuestion(Question question) throws SQLException; 
    List<Question> getAllQuestions()  throws SQLException; 
    List<Question> getAllQuestions(int votes) throws SQLException, QuestionNotFoundException, QuestionSQLException; 
    Question getQuestion(int questionId) throws SQLException;
    int upVoteQuestion(int questionId) throws SQLException; 
    int downVoteQuestion(int questionId) throws SQLException; 
    int getVotesForQuestion(int questionId) ; 
    List<Answer> getAnswers(int questionId)  throws SQLException;
    void deleteQuestion(int questionId) throws SQLException; 
}
