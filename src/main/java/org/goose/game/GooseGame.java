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
            int sum = calculateNewPosition(comandi, posizioneCorrente);
            posizioni.replace(comandi[1],sum);
            String posizionePrecedente = Integer.toString(posizioneCorrente);
            posizionePrecedente = chkStartPosition(posizioneCorrente, posizionePrecedente);


            String output = comandi[1] + " rools " + comandi[2] + ", "+ comandi[3] + ". " + comandi[1] +" moves from " + posizionePrecedente;
            output = chkWinner(comandi, sum, output);
            return output;
        }

        return "Comando Sconosiuto";
    }

    private int calculateNewPosition(String[] comandi, int posizioneCorrente) {
        return posizioneCorrente + Integer.parseInt(comandi[2])  + Integer.parseInt(comandi[3]);
    }

    private String chkStartPosition(int posizioneCorrente, String posizionePrecedente) {
        if (posizioneCorrente == 0)
            posizionePrecedente = "Start";
        return posizionePrecedente;
    }

    private String chkWinner(String[] comandi, int sum, String output) {
        String esito = "";
        if (sum == 63) {
            esito = ". " + comandi[1] + " Wins!!";
            return output + " to 63" + esito;
        }
        else if (sum > 63){
            Integer overposition = sum - 63;
            sum = sum - overposition;

            esito = ". " + comandi[1] + " bounces! Pippo returns to " + (sum - overposition);
            return output + " to 63" + esito;
        }
        return  output + " to " + sum;
    }
}
