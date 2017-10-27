package textadventure;

import java.util.ArrayList;
import textio.*;
import java.util.Random;

public class Monster
{
    private String name;
    private String history;
    private RoomInfo currentPosition;    
    private TextIO io = new TextIO(new SysTextIO());
    private Random rnd = new Random();
    private ArrayList<RoomInfo> rooms;
    
    public Monster(String name, String history, RoomInfo currentPosition) 
    {
        this.name = name;
        this.history = history;
        this.currentPosition = currentPosition; 
    }
  
    public void move()
    {    
        //io.put("\n\n***THIS IS A TEST IN THE MONSTER CLASS***"); <-- tests if we get into this method        

        int direction;
        while(true)
        {
            direction = rnd.nextInt(4) + 1;
            //System.out.println(direction); //<-- prints out what number the rnd gave
            if(move(direction) == true)
            {
                break;
            }
        }           
            //System.out.println("Moved to " + direction); //<-- prints out direction the monster moved, for testing if it works
    }
    
    private boolean move(int rand)
    {
        switch(rand)
        {
            case 1:
                if(getCurrentPosition().getNorth() != null)
                {
                    setCurrentPosition(getCurrentPosition().getNorth());
                    //System.out.println("\nMONSTER MOVED NORTH"); <-- this checks where the monster moved
                    return true;
                }
                return false;
            case 2:
                if(getCurrentPosition().getSouth() != null)
                {
                    setCurrentPosition(getCurrentPosition().getSouth());
                    //System.out.println("\nMONSTER MOVED SOUTH"); <-- this checks where the monster moved
                    return true;
                }
                return false;
            case 3:
                if(getCurrentPosition().getWest() != null)
                {
                    setCurrentPosition(getCurrentPosition().getWest());
                    //System.out.println("\nMONSTER MOVED WEST"); <-- this checks where the monster moved
                    return true;
                }
                return false;
            case 4:
                if(getCurrentPosition().getEast() != null)
                {
                    setCurrentPosition(getCurrentPosition().getEast());
                    //System.out.println("\nMONSTER MOVED EAST"); <-- this checks where the monster moved
                    return true;
                }
                return false;
            default:
                throw new IllegalStateException();
        }
    }

    //Getters
    public String getName() 
    {
        return name;
    }

    public String getHistory() 
    {
        return history;
    }

    public RoomInfo getCurrentPosition() 
    {
        return currentPosition;
    }
    
    //Setters
    public void setName(String name) 
    {
        this.name = name;
    }

    public void setHistory(String history) 
    {
        this.history = history;
    }

    public void setCurrentPosition(RoomInfo currentPosition) 
    {
        this.currentPosition = currentPosition;
    }
}
