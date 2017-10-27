/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WriteFileTest {
    
    public WriteFileTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testSomeMethod() 
    {
        File newFile = new File("C:\\Users\\malik\\Desktop\\highscoreTAG.txt");
        if(newFile.exists())
        {
            System.out.println("The file already exist");
        }
        else
        {
            try
            {
                newFile.createNewFile();
            }
            catch (Exception e)
            {
                e.printStackTrace(); 
            }
            try 
            {
                FileWriter fileW = new FileWriter(newFile);
                BufferedWriter buffW = new BufferedWriter(fileW);
                buffW.write("The highest score is");
                buffW.close();
                System.out.println("SUCCESS, FILE WRITTEN!");
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }    
    }
}
