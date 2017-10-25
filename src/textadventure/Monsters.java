package textadventure;

import textio.*;
import java.util.Random;
import java.util.ArrayList;

public class Monsters
{
    private String description; 
    private String backgroundStory;
    private RoomInfo currentPosition;
    private TextIO io = new TextIO(new SysTextIO());
    private Random rnd = new Random();

    public Monsters(String description, String backgroundStory, RoomInfo currentPosition) 
    {
        this.description = description;
        this.backgroundStory = backgroundStory;
        this.currentPosition = currentPosition;
    }

    public String getDescription() 
    {
        return description;
    }

    public String getBackgroundStory() 
    {
        return backgroundStory;
    }

    public RoomInfo getCurrentPosition() 
    {
        return currentPosition;
    }

    public void setCurrentPosition(RoomInfo currentPosition) 
    {
        this.currentPosition = currentPosition;
    }
  
    public void move()
    {    
        boolean movement = false;
        ArrayList<String> movements = new ArrayList<>();
        int count = 0;
        
        if(getCurrentPosition().getNorth() != null)
        {
            movements.add("North");
        }
        if(getCurrentPosition().getSouth() != null)
        {
            movements.add("South");
        }
        if(getCurrentPosition().getWest() != null)
        {
            movements.add("West");
        }
        if(getCurrentPosition().getEast() != null)
        {
            movements.add("East");
        }
        
        while(!movement)
        {
            count++;
            if(count > 1000)
            {
                System.out.println("PROBLEM IS HERE!!!");
            }
            
            int move = rnd.nextInt(4) + 1;
            switch(move)
            {
                case 1:
                    if(getCurrentPosition().getNorth() != null)
                    {
                        setCurrentPosition(getCurrentPosition().getNorth());
                        System.out.println("\n\nMONSTER MOVED NORTH");
                        movement = true;
                        break;
                    }
                    else
                    {
                        break;
                    }
                case 2:
                    if(getCurrentPosition().getSouth() != null)
                    {
                        setCurrentPosition(getCurrentPosition().getSouth());
                        System.out.println("\n\nMONSTER MOVED SOUTH");
                        movement = true;
                        break;
                    }
                    else
                    {
                        break;
                    }
                case 3:
                    if(getCurrentPosition().getWest() != null)
                    {
                        setCurrentPosition(getCurrentPosition().getWest());
                        System.out.println("\n\nMONSTER MOVED WEST");
                        movement = true;
                        break;
                    }
                    else
                    {
                        break;
                    }
                case 4:
                    if(getCurrentPosition().getEast() != null)
                    {
                        setCurrentPosition(getCurrentPosition().getEast());
                        System.out.println("\n\nMONSTER MOVED EAST");
                        movement = true;
                        break;
                    }
                    else 
                    {
                        break;
                    }
                default:
                    break;
            }
        }   
    }    

    /*@Override
    public void miniMonsters() 
    {
        
    }*///NOT USED YET, LATER   
}
