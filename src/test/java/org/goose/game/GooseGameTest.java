package org.goose.game;

import org.goose.game.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GooseGameTest {


    private GooseGame goso;

    @Before
    public void initialize(){
        goso = new GooseGame();
    }

    @Test
    public void addNewPlayer(){

        assertEquals("players: Pippo", goso.add(new Player("Pippo")) );
    }

    @Test
    public void addSecondPlayer(){
        goso.add(new Player("Pippo"));
        String test = goso.add(new Player("Pluto"));

        assertEquals( "players: Pippo, Pluto", test);
    }

    @Test
    public void duplicatedPlayer(){
        goso.add(new Player("Pippo"));
        goso.add(new Player("Pluto"));
        String test = goso.add(new Player("Pippo"));

        assertEquals( "Pippo: already exisiting player", test);

    }

    @Test
    public void movePlayerPippo(){
        goso.add(new Player("Pippo"));
        goso.add(new Player("Pluto"));

        assertEquals("Pippo rools 4, 2. Pippo moves from Start to 6" ,  goso.userWrite("move Pippo 4, 2"));
    }

    @Test
    public void movePlayerPluto(){
        goso.add(new Player("Pippo"));
        goso.add(new Player("Pluto"));

        assertEquals("Pluto rools 2, 2. Pluto moves from Start to 4" ,  goso.userWrite("move Pluto 2, 2"));
    }

}
