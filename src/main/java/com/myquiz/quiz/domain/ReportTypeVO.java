package com.myquiz.quiz.domain;

public class ReportTypeVO {
	private int wrongAnswer;
	private int unAcceptable;
	private int etc;
	public int getWrongAnswer() {
		return wrongAnswer;
	}
	public void setWrongAnswer(int wrongAnswer) {
		this.wrongAnswer = wrongAnswer;
	}
	public int getUnAcceptable() {
		return unAcceptable;
	}
	public void setUnAcceptable(int unAcceptable) {
		this.unAcceptable = unAcceptable;
	}
	public int getEtc() {
		return etc;
	}
	public void setEtc(int etc) {
		this.etc = etc;
	}
	
	
}
