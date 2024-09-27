package fr.efrei.web.mon_projet;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.*;

@Path("/api")
public class Resultat {

    private static Map<String, Player> players = new HashMap<>();
    private static List<Game> games = new ArrayList<>();

    @POST
    @Path("/post-game-result")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postGameResult(GameResult result) {
        Player player1 = players.getOrDefault(result.getPlayer1(), new Player(result.getPlayer1()));
        Player player2 = players.getOrDefault(result.getPlayer2(), new Player(result.getPlayer2()));
        Player winner = null;

        if (result.getWinner() != null) {
            winner = result.getWinner().equals(result.getPlayer1()) ? player1 : player2;
            winner.addWin(); 
        }

        games.add(new Game(player1, player2, winner));

        players.put(player1.getName(), player1);
        players.put(player2.getName(), player2);

        return Response.ok().entity("{\"message\": \"Game result added successfully!\"}").build();
    }

    @GET
    @Path("/get-score/{player}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getScore(@PathParam("player") String player) {
        Player p = players.get(player);
        if (p == null) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("{\"message\": \"Player not found\"}").build();
        }
        return Response.ok().entity("{\"player\": \"" + p.getName() + "\", \"score\": " + p.getScore() + "}").build();
    }

    @GET
    @Path("/ranking")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRanking() {
        List<Player> sortedPlayers = new ArrayList<>(players.values());
        sortedPlayers.sort((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));

        List<Map<String, Object>> ranking = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sortedPlayers.size()); i++) {
            Player p = sortedPlayers.get(i);
            Map<String, Object> playerData = new HashMap<>();
            playerData.put("name", p.getName());
            playerData.put("score", p.getScore());
            ranking.add(playerData);
        }

        return Response.ok().entity(ranking).build();
    }
}
