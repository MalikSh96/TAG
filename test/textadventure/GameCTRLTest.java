/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import java.util.ArrayList;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import textio.*;

/**
 *
 * @author malik
 */
public class GameCTRLTest {
    
    private ArrayList<RoomInfo> rooms = new ArrayList<>(); //arraylist to store the roominfo
    private TextIO io = new TextIO(new SysTextIO());
    private boolean quit = false; //false at start to be able to play the game
    private Random rnd = new Random(); //to randomize the startlocation of the monster
    
    
    public GameCTRLTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testPlay() {
    }

    @Test
    public void testCombat() 
    {
        RoomDef rd = new RoomDef(rooms);
        rd.defRooms();
        Monster mo = new Monster("MONSTERNAME", "HISTORY", rooms.get(rnd.nextInt(8) +2));
        PlayerInfo player = new PlayerInfo("sdasd", rooms.get(0));
        MiniMonster minion = new MiniMonster("minion", 1, -5, new Weapon("Knife", "Historic knife", 5));
        
        ArrayList<String> comb = new ArrayList<>();
        comb.add("Attack");
        comb.add("Passive");
        
        while(true)
        {
            io.put("\nMinion attacks you!");
            player.setCurrentHealth(player.getCurrentHealth() + minion.getMinionDamage()); //The damage the minion inflicts on the player           
            
            int attacking = io.select("\nDo you wish to attack?", comb, "Make a choice");
            switch(comb.get(attacking))
            {
                case "Attack":
                    minion.setMinionLife(minion.getMinionLife() - player.getCurrentDamage()); //The damage the player inflicts on the minion
                    io.put("\nYou attacked the minion!"); 
                    break;
                case "Passive":
                    io.put("\nYou stayed passive!");
                    break;
                default:
                    break;  
            }
            
            io.put("\nRemaining health of the minion: " + minion.getMinionLife());
            io.put("\nYour remaining health:" + player.getCurrentHealth());
            
            if(player.getCurrentHealth() < 1)
            {
                io.put("\nYou died!");
                //combat = false;
                break;
            }
            else if(minion.getMinionLife() < 1)
            {
                io.put("\nYou managed to kill the minion!");
                //combat = false;
                break;
            }
        }       
    }

    @Test
    public void testPrintInfo() {
    }

    @Test
    public void testHelp() {
    }
    
}
