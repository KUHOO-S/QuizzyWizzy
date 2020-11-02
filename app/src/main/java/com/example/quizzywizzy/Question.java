package com.example.quizzywizzy;

public class Question {
    String category;
    String type;
    String difficulty;
    String question;
    String correct_answer;
    String[] incorrect_answers =new String[3];
    public Question(String category,String type,String difficulty,String question,String correct_answer,String[] incorrect_answers )
    {
        this.category=category;
        this.type=type;
        this.difficulty=difficulty;
        this.question=question;
        this.correct_answer=correct_answer;
        this.incorrect_answers=incorrect_answers;
    }
}
