package com.geni.beans;

import java.util.List;

public class Question {
	private int question_id;
	private String question_txt;
	private String category;
	private List<String> iv;
	
	
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestion_txt() {
		return question_txt;
	}
	public void setQuestion_txt(String question_txt) {
		this.question_txt = question_txt;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<String> getIv() {
		return iv;
	}
	public void setIv(List<String> iv) {
		this.iv = iv;
	}
	
	
}
