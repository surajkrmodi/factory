package com.asde.beans;

public class Answer {
    private int answerId; 
    private String userAnswer; 
    private int questionId;
    private int answerUserId;

    public Answer(int answerId, String userAnswer, int questionId, int answerUserId) {
        this.answerId = answerId;
        this.userAnswer = userAnswer;
        this.questionId = questionId;
        this.answerUserId = answerUserId;
    }

    
    /** 
     * @return int
     */
    public int getAnswerId() {
        return this.answerId;
    }

    
    /** 
     * @param answerId
     */
    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    
    /** 
     * @return String
     */
    public String getUserAnswer() {
        return this.userAnswer;
    }

    
    /** 
     * @param userAnswer
     */
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    
    /** 
     * @return int
     */
    public int getQuestionId() {
        return this.questionId;
    }

    
    /** 
     * @param questionId
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    
    /** 
     * @return int
     */
    public int getAnswerUserId() {
        return this.answerUserId;
    }

    
    /** 
     * @param answerUserId
     */
    public void setAnswerUserId(int answerUserId) {
        this.answerUserId = answerUserId;
    }

    public Answer() {
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
            " answerId='" + answerId + "'" +
            ", userAnswer='" + userAnswer + "'" +
            ", questionId='" + questionId + "'" +
            ", answerUserId='" + answerUserId + "'" +
            "}";
    }

}
