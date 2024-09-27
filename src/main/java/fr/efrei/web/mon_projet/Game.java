package fr.efrei.web.mon_projet;

public class Game {
    private Player player1;
    private Player player2;
    private Player winner;

    public Game(Player player1, Player player2, Player winner) {
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;

        
        if (this.winner != null) {
            this.winner.addWin();
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getWinner() {
        return winner;
    }
}