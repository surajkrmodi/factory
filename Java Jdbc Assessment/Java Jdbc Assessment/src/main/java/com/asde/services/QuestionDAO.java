package com.asde.services;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.asde.beans.Answer;
import com.asde.beans.Question;
import com.asde.contracts.IQuestionDAO;
import com.asde.exception.PropertyFileNotFoundException;
import com.asde.util.CommonUtil;
import com.asde.util.DBUtil;

/**
 * @author <Your Name>
 * @implSpec To build DAO Layer for Question Bank
 */
public class QuestionDAO implements IQuestionDAO {

	private static Properties prop;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;

	public QuestionDAO() throws ClassNotFoundException, SQLException, PropertyFileNotFoundException {
		try {
			connection = DBUtil.createConnection();
			prop = CommonUtil.getProperties("db");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (PropertyFileNotFoundException e) {

			throw new PropertyFileNotFoundException("Exception occured", null);
		}

	}

	/**
	 * 
	 * @implNote thie method shall take a valid Question object and store in DBMS
	 * @author <Your Name>
	 */
	@Override
	public boolean insertQuestion(Question question) throws SQLException {

		String query = "insert into question values(1,'Hello',2,3)";

		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @author <Your Name>
	 * @implNote this method shall return all the question as list
	 */

	@Override
	public List<Question> getAllQuestions() throws SQLException {
		String query = "select qid, question, uid, votes from question";
		List<Question> allQuestion = new ArrayList<>();
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int i = rs.getInt("questionId");
				String str = rs.getString("question");
				int j = rs.getInt("uid");
				int k = rs.getInt("votes");

				// Assuming you have a user object
				Question user = new Question(i, str, j, k);

				allQuestion.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allQuestion;
	}

	/**
	 * @author <Your Name>
	 * @implNote this method shall return all the questions which has votes greater
	 *           than the specified number of votes
	 * @exception SQLException.class
	 */
	@Override
	public List<Question> getAllQuestions(int votes) throws SQLException {
		String query = "select qid, question, uid, votes from question where votes > " + votes;
		List<Question> allQuestion = new ArrayList<>();
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int i = rs.getInt("questionId");
				String str = rs.getString("question");
				int j = rs.getInt("uid");
				int k = rs.getInt("votes");

				// Assuming you have a user object
				Question user = new Question(i, str, j, k);

				allQuestion.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allQuestion;
	}

	/**
	 * @author <Your Name>
	 * @implNote this method shall return an Object of Question as Optional
	 * @exception should throw an exception which is an instance of SQLException
	 */
	@Override
	public Question getQuestion(int questionId) throws SQLException {

		String query = "select qid, question, uid, votes from question where qid= " + questionId;
		Question getQues = new Question();
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int i = rs.getInt("questionId");
				String str = rs.getString("question");
				int j = rs.getInt("uid");
				int k = rs.getInt("votes");

				// Assuming you have a user object
				getQues.setQuestionId(i);
				getQues.setQuestion(str);
				getQues.setUid(j);
				getQues.setVotes(k);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getQues;
	}

	/**
	 * @author <Your Name>
	 * @implNote this method shall return number of votes for the given Question,
	 *           and when user passes incrOrDecr=true then the votes for the
	 *           question to be incremented else it should be decremented
	 * @exception should throw an exception which is an instance of SQLException
	 */
	@Override
	public int upOrDownVoteQuestion(int questionId, boolean incrOrDecr) throws SQLException {
		String query = "update question set votes=" + incrOrDecr + " where qid=" + questionId;
		int vote = 0;
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				vote = rs.getInt("votes");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vote;
	}

	/**
	 * @author <Your Name>
	 * @implNote this method shall return all the asnwers as List for the given
	 *           question, when there are no answers then the function will return
	 *           instance of AnswersNotFoundException.class
	 * @exception should throw an exception which is an instance of SQLException
	 */
	@Override
	public List<Answer> getAnswers(int questionId) throws SQLException {
		String query = "select aid, qid, answer, ans_user_id from answer where qid=" + questionId;
		List<Answer> allAnswers = new ArrayList<>();
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int i = rs.getInt("answerId");
				String str = rs.getString("userAnswer");
				int j = rs.getInt("questionId");
				int k = rs.getInt("answerUserId");

				// Assuming you have a user object
				Answer user = new Answer(i, str, j, k);

				allAnswers.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allAnswers;
	}

	/**
	 * @author <Your Name>
	 * @implNote this method shall delete the question and related answers from the
	 *           database Imp: If the question has answers first delete the answers
	 *           then the Question to be deleted
	 * @exception should throw an exception which is an instance of SQLException
	 */
	@Override
	public boolean deleteQuestion(int questionId) throws SQLException {
		String query = "delete from question where qid=" + questionId;
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
