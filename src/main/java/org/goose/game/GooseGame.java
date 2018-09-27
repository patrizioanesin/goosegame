package org.goose.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GooseGame {
    private List<Player> players = new ArrayList<Player>();
    private Map<String , Integer> posizioni = new HashMap<String, Integer>();

    public String add(Player player) {

        if (players.contains(player)) {
            return player.getName() + ": already exisiting player";
        }

        players.add(player);
        posizioni.put(player.getName() ,0);
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
            int posizioneCorrente = posizioni.get(comandi[1]);
            int sum  = posizioneCorrente + Integer.parseInt(comandi[2])  + Integer.parseInt(comandi[3]);
            posizioni.replace(comandi[1],sum);
            String posizionePrecedente = posizioneCorrente+"";
            if (posizioneCorrente == 0)
                posizionePrecedente = "Start";
            return comandi[1] + " rools " + comandi[2] + ", "+ comandi[3] + ". " + comandi[1] +" moves from "+posizionePrecedente+" to " + sum;
        }

        return "Comando Sconosiuto";
    }
}
