package org.goose.game;

import java.util.ArrayList;
import java.util.List;

public class GooseGame {
    private List<Player> players = new ArrayList<Player>();

    public String add(Player player) {

        if (players.contains(player)) {
            return player.getName() + ": already exisiting player";
        }

        players.add(player);
        return getPlayerNames();
    }

    private String getPlayerNames() {
        String listOfPlayers = null;
        for (Player player: players
             ) {
             if (listOfPlayers == null){
                 listOfPlayers = "players: " + player.getName();
             }else {
                 listOfPlayers += ", " + player.getName();
             }
        }
        return listOfPlayers;
    }


    public String userWrite(String comandoUtente) {

        String[] comandi = comandoUtente.split(" |, ");

        if (comandi[0].equals("move")) {
            int sum  = Integer.parseInt(comandi[2])  + Integer.parseInt(comandi[3]);
            return comandi[1] + " rools " + comandi[2] + ", "+ comandi[3] + ". " +comandi[1] +" moves from Start to " + sum;
        }

        return "Comando Sconosiuto";
    }
}
