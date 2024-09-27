package fr.efrei.web.mon_projet;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GameResult {
    private String player1;
    private String player2;
    private String winner;

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}