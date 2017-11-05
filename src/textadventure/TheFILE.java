package textadventure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
                System.out.println("New file created!");
            }
            catch (Exception e)
            {
                e.printStackTrace(); 
            }
        }
        else
        {
            System.out.println("The file with the highest score already exist!");
        }        
        //Reading the file
        //Trying to catch the exception
        try 
        {
            FileReader file = new FileReader("highscoreTAG.txt");
            BufferedReader reader = new BufferedReader(file);
        
            String text = "";
            String line = reader.readLine();
            while(line != null)
            {
                //System.out.println("line="+line); <-- used to check
                String[] parts = line.split(", ");
                highscores.addScore(parts[0], Integer.parseInt(parts[1]));
                line = reader.readLine();
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }       
        
        for(String name : highscores.getScores().keySet())
        {
            System.err.println("-------> " + name + " - "+ highscores.getScores().get(name));
        }
               
        //Writing the file
        try 
        {
            FileWriter fileW = new FileWriter(newFile);
            BufferedWriter buffW = new BufferedWriter(fileW);
            
            ArrayList<String> names = new ArrayList();
            for(String name : highscores.getScores().keySet())
            {
                names.add(name);
            }
            Collections.sort(names, new Comparator<String>()
            {
                @Override
                public int compare(String o1, String o2) 
                {
                    return highscores.getScores().get(o2) - highscores.getScores().get(o1);
                }
            });
            for(String name : names)
            {
                buffW.write(name + ", " + highscores.getScores().get(name));
                buffW.newLine();
            }
            buffW.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
