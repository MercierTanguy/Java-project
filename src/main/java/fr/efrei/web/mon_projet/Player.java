package fr.efrei.web.mon_projet;

public class Player {
    private String name;
    private int win;

    public Player(String name) {
        this.name = name;
        this.win = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return win;
    }

    public void addWin() {
        this.win++;
    }
}