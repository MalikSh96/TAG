package textadventure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//Creating our file in this class
public class TheFILE 
{
    //Writing and reading our file
    public void FILE(HighScore highscores)
    {
        File newFile = new File("highscoreTAG.txt");
        if(!newFile.exists())
        {
            try
            {
                newFile.createNewFile();
                System.out.println("New file created");
            }
            catch (Exception e)
            {
                e.printStackTrace(); 
            }
        }
        else
        {
            System.out.println("The file with the highest score already exist");
        }        
        //Reading the file
        //Trying to catch the exception
        try 
        {
            FileReader file = new FileReader("highscoreTAG.txt");
            BufferedReader reader = new BufferedReader(file);
        
            String text = "";
            String line = reader.readLine();
            if(line != null)
            {
                String[] parts = line.split(", ");
                highscores.addScore(parts[0], Integer.parseInt(parts[1]));          
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }       
        //Writing the file
        try 
        {
            FileWriter fileW = new FileWriter(newFile);
            BufferedWriter buffW = new BufferedWriter(fileW);
            buffW.write(highscores.getBestName() + ", " + highscores.getBestScore());
            buffW.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }   
}
