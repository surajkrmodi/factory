package com.asde.beans;

public class Question {
    private int questionId;
    private String question; 
    private int uid; 
    private int votes; 

    public Question() {
    }

    public Question(int questionId, String question, int uid, int votes) {
        this.questionId = questionId;
        this.question = question;
        this.uid = uid;
        this.votes = votes;
    }


    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
            " questionId='" + getQuestionId() + "'" +
            ", question='" + getQuestion() + "'" +
            ", uid='" + getUid() + "'" +
            ", votes='" + getVotes() + "'" +
            "}";
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
     * @return String
     */
    public String getQuestion() {
        return this.question;
    }

    
    /** 
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    
    /** 
     * @return int
     */
    public int getUid() {
        return this.uid;
    }

    
    /** 
     * @param uid
     */
    public void setUid(int uid) {
        this.uid = uid;
    }

    
    /** 
     * @return int
     */
    public int getVotes() {
        return this.votes;
    }

    
    /** 
     * @param votes
     */
    public void setVotes(int votes) {
        this.votes = votes;
    }



}
