package textadventure;

import java.util.ArrayList;
import java.util.Comparator;

//Gets the scores and sorts them, highscores are based of highest HP
public class HighScore 
{
    private ArrayList<Integer> score = new ArrayList<>();
    private ArrayList<String> score_names = new ArrayList<>(); //find out a solution to this
    
    public HighScore() 
    {
        System.out.println("This is the highscores: ");
    }
    
    public void addScore(int NEW_HIGHSCORE)
    {
        score.add(NEW_HIGHSCORE);
        score.sort(Comparator.naturalOrder());
        for(int i : score)
        {
            System.out.println(i);
        }           
    }
    
    @Override
    public String toString() 
    {
        return "Highscores are: " + score;
    }    
}
