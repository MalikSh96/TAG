package textadventure;

import java.util.HashMap;
import java.util.Map;

//Gets the scores and sorts them, highscores are based of highest HP
//JUnit tests confirms this works
public class HighScore 
{
    private HashMap<String, Integer> scores = new HashMap<>();

    public void addScore(String name, int score) 
    {
        scores.put(name, score);
    }

    public String getBestName() 
    {   
        if(scores.isEmpty()) 
        {
            throw new IllegalStateException();
        }

        String bestName = null;
        int bestScore = Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> entry : scores.entrySet()) 
        {
            if(bestName == null) 
            {
                bestName = entry.getKey();
                bestScore = entry.getValue();
            }
            if(entry.getValue() > bestScore) 
            {
                bestName = entry.getKey();
                bestScore = entry.getValue();
            }
        }
        return bestName;
    }

    public int getBestScore() 
    {
        if(scores.isEmpty()) 
        {
            throw new IllegalStateException();
        }

        String bestName = null;
        int bestScore = Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> entry : scores.entrySet()) 
        {
            if(bestName == null) 
            {
                bestName = entry.getKey();
                bestScore = entry.getValue();
            }
            if(entry.getValue() > bestScore) 
            {
                bestName = entry.getKey();
                bestScore = entry.getValue();
            }
        }
        return bestScore;
    }
    
    public HashMap<String, Integer> getScores() 
    {
        return scores;
    }
}
