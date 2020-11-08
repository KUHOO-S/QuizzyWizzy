package com.example.quizzywizzy;

public class User {
    public User(){
        
    }
    public String getEmail() {
        return email;
    }

    public int getPlayed() {
        return played;
    }

    public int getWon() {
        return won;
    }

    public int getLost() {
        return lost;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    String email;
int played,won,lost;
}
