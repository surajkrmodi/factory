package com.asde.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.asde.beans.Answer;
import com.asde.beans.Question;
import com.asde.contracts.IQuestionDAO;
import com.asde.contracts.IQuestionService;
import com.asde.exception.PropertyFileNotFoundException;
import com.asde.exception.QuestionNotFoundException;
import com.asde.exception.QuestionSQLException;

/**
 * @author Naveen
 * @implNote 1. To build Service Layer for Question Bank 2. This class shall be
 *           considered for testing
 * 
 */
public class QuestionService implements IQuestionService {

	private IQuestionDAO dao;

	/**
	 * @author Naveen
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @implNote this constructor shall load and get the db connection, and DAO
	 *           layer shall have connection object
	 */
	public QuestionService() throws IOException, ClassNotFoundException, SQLException {
		try {
			dao = new QuestionDAO();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (PropertyFileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author <Your Name>
	 * @apiNote Check if all the fields of the question is passed properly with
	 *          below requirement 1. questionId - should be number and value should
	 *          be +ve 2. question - should be string with minimum 20 chars 3. uid -
	 *          should be number and value should be +ve 4. votes - should always be
	 *          zero,
	 * 
	 * @exception SQLException.class
	 */
	@Override
	public boolean insertQuestion(Question question) throws SQLException {
		return false;
	}

	/**
	 * @author <Your Name>
	 * @apiNote This method shall return all the questions which are on the DBMS
	 * 
	 * 
	 *          Refer to IQuestionDAO.List<Question> getAllQuestions() throws
	 *          SQLException;
	 */
	@Override
	public List<Question> getAllQuestions() {
		return null;
	}

	/**
	 * @author <Your Name>
	 * @apiNote This method shall return all the questions which has votes greater
	 *          than the specified number of votes
	 * 
	 *          When there are no questions
	 * @throws SQLException.class
	 * 
	 *                            Refer to IQuestionDAO.List<Question>
	 *                            getAllQuestions(int votes) throws SQLException;
	 */
	@Override
	public List<Question> getAllQuestions(int votes) throws QuestionNotFoundException, QuestionSQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @author <Your Name>
	 * @throws SQLException
	 * @apiNote This method shall return question given valid question id when the
	 *          question is not found throw SQLException
	 * 
	 */
	@Override
	public Question getQuestion(int questionId) throws SQLException {
		return null;
	}

	/**
	 * @author <Your Name>
	 * @apiNote This method shall return number of votest for the question given
	 *          valid question id when the question is not found return 0
	 * 
	 */
	@Override
	public int getVotesForQuestion(int questionId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @author <Your Name>
	 * @apiNote This method shall return list of answers for the given valid
	 *          question id
	 * 
	 *          When there are no question with given id
	 * @throws SQLException
	 * 
	 *                      Refer to IQuestionDAO.List<Answer> getAnswers(int
	 *                      questionId) throws SQLException
	 */
	@Override
	public List<Answer> getAnswers(int questionId) throws SQLException {
		return null;
	}

	/**
	 * @author <Your Name>
	 * @apiNote This method shall return number of votes for the given valid
	 *          question id Refer to IQuestionDAO.int upOrDownVoteQuestion(int
	 *          questionId, boolean incrOrDecr) throws SQLException;
	 * @implNote pass true
	 */
	@Override
	public int upVoteQuestion(int questionId) throws SQLException {
		return 0;
	}

	/**
	 * @author <Your Name>
	 * @apiNote This method shall return number of votes for the given valid
	 *          question id Refer to IQuestionDAO.int upOrDownVoteQuestion(int
	 *          questionId, boolean incrOrDecr) throws SQLException;
	 * @implNote pass false
	 */
	@Override
	public int downVoteQuestion(int questionId) throws SQLException {
		return 0;
	}

	/**
	 * @author <Your Name>
	 * @throws SQLException
	 * @apiNote This method shall delete the specified question with questionId
	 * 
	 *          When Question with ID is not found
	 * @throws SQLException.class
	 * 
	 * @see IQuestionDAO.boolean deleteQuestion(int questionId) throws SQLException;
	 */

	@Override
	public void deleteQuestion(int questionId) throws SQLException {

		// TODO
	}

}
