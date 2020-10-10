package com.example.quizzywizzy;

public class QuestionSet {
    int response_code;
    Question[] results = new Question[3];
    public QuestionSet(int response_code,Question[] results){
        this.response_code=response_code;
        this.results=results;

    }
}
