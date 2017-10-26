/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author malik
 */
public class HighScoreTest {

    public HighScoreTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testAddScore() {
    }

    @Test
    public void testGetBestName() {
        HighScore highscores = new HighScore();
        highscores.addScore("a", 1);
        highscores.addScore("b", 17);
        highscores.addScore("c", 0);
        assertEquals("b", highscores.getBestName());
    }

    @Test
    public void testGetBestScore() {
               HighScore highscores = new HighScore();
        highscores.addScore("a", 1);
        highscores.addScore("b", 17);
        highscores.addScore("c", 0);
        assertEquals(17, highscores.getBestScore());
    }

    @Test
    public void testToString() {
    }

}
