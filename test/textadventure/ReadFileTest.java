/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import java.io.BufferedReader;
import java.io.FileReader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author malik
 */
public class ReadFileTest {
    
    public ReadFileTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testSomeMethod() throws Exception
    {
         FileReader file = new FileReader("C:\\Users\\malik\\Desktop\\highscoreTAG.txt");
        BufferedReader reader = new BufferedReader(file);
        
        String text = "";
        String line = reader.readLine(); 
        
        while(line != null)
        {
            text += line;
            line = reader.readLine();
        }
        System.out.println(text);
    }  
}
