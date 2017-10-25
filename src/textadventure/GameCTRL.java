package textadventure;

import java.util.ArrayList;
import textio.*;

//Where the gaming happens
public class GameCTRL implements Control
{
    private ArrayList<RoomInfo> rooms = new ArrayList<>(); //arraylist to store the roominfo
    private TextIO io = new TextIO(new SysTextIO());
    private boolean quit = false; //false at start to be able to play the game

    @Override
    public void play() 
    {
        //Definition of rooms
        RoomDef rd = new RoomDef();
        rd.defRooms(rooms);
        PlayerInfo player = new PlayerInfo("playerName", rooms.get(0));    
        
        //Introduction to the game
        io.put("\u001B[31m" + "Welcome to adventure!\n"); 
        //Prints info about the game
        printInfo();
        
        //Signing in to play the game
        io.put("Enter name please");
        String name = io.get();
        io.put("Welcome " + name + ", we are looking forward to play with you\n");
        io.put("\nEnter age");
        int age = io.getInteger();
        io.put("you are " + age + "\n");
        
        
        //The game starts here
        io.put(player.getCurrentposition().getRoomEventText() + "\n\nName is: " + name +  "\nYour health is: " + player.getCurrentHealth() 
                + "\nThe damage you can inflict is: " + player.getCurrentDamage());
        
        //Using a while loop to keep the game flowing until final destination is reached
        while(true)
        { 
            if(player.getCurrentposition() == rooms.get(9))
            {
                io.put("\n\u001B[32m" + "WINNER, CONGRATULATIONS!!!\n" 
                    + "\u001B[32m" + "IT WAS A JOY HAVING YOU HERE, HOPE TO SEE YOU AGAIN SOON!\n");
                break;
            }
            
            if(player.getCurrentHealth() < 1)
            {
                io.put("\nYou died!");
                break;
            }
            
           
            io.put("\nMake a choice\n");
            ArrayList<String> maze = new ArrayList<>();
            
            io.put("\nYour name is: " + name + "\nYour current health is: " + player.getCurrentHealth()
                    + "\nThe damage you can inflict is: " + player.getCurrentDamage() + "\n");
            if(player.getCurrentposition().getNorth() != null)
            {
                maze.add("North");
            }
            if(player.getCurrentposition().getSouth() != null)
            {
                maze.add("South");
            }
            if(player.getCurrentposition().getWest() != null)
            {
                maze.add("West");
            }
            if(player.getCurrentposition().getEast() != null)
            {
                maze.add("East");
            }
            maze.add("Help");
            maze.add("Quit");
            
            int result = io.select("You have these choices", maze, "What do you wanna do");
            switch(maze.get(result)) 
            {
                case "North":
                    if (player.getCurrentposition().getNorth() == null) 
                    {
                        io.put("Invalid choice, try input a new one\n");
                    } 
                    else 
                    {
                        player.setCurrentposition(player.getCurrentposition().getNorth());
                        io.put(player.getCurrentposition().getRoomEventText());
                        player.getCurrentposition().getEvents().applyEvent(player);
                    }
                    break;
                    
                case "South":
                        if (player.getCurrentposition().getSouth() == null) 
                        {
                            //io.put("Invalid choice, try input a new one\n"); <--NOT USED
                        } 
                        else 
                        {
                            player.setCurrentposition(player.getCurrentposition().getSouth());
                            io.put(player.getCurrentposition().getRoomEventText());
                            player.getCurrentposition().getEvents().applyEvent(player);
                        }
                    break;
                    
                case "West":
                        if (player.getCurrentposition().getWest() == null) 
                        {
                            //io.put("Invalid choice, try input a new one\n"); <--NOT USED ?
                        } 
                        else 
                        {
                            player.setCurrentposition(player.getCurrentposition().getWest());
                            io.put(player.getCurrentposition().getRoomEventText());
                            player.getCurrentposition().getEvents().applyEvent(player);
                        }
                        break;
                        
                    case "East":
                        if (player.getCurrentposition().getEast() == null)
                        {
                            //io.put("Invalid choice, try input a new one\n"); <--NOT USED?
                        } 
                        else 
                        {
                            player.setCurrentposition(player.getCurrentposition().getEast());
                            io.put(player.getCurrentposition().getRoomEventText()); 
                            player.getCurrentposition().getEvents().applyEvent(player);
                        }
                        break;
                    case "Help":
                        help();
                        break;
                        
                    case "Quit":
                        io.put("\u001B[31m" + "You have chosen to quit the game\n");
                        quit = true;
                        break;
                        
                    default:
                        break;
            } 
        }   
    }
    
    @Override
    public void printInfo()
    {
        //Prints the info at the beginning of the game
        //Using the color blue to difference from the room descriptions
        io.put("\u001B[34m" + "Info about the game" 
                  + "\u001B[34m" + "\nWelcome to adventure!" 
                  + "\u001B[34m" + "\nHere is your instructions" 
                  + "\u001B[34m" + "\nYes, somewhere nearby is colossal cave, where others have found fortunes in treasure and gold."
                  + "\u001B[34m" + "\nThough it is rumored that some who enter are never seen again."
                  + "\u001B[34m" + "\nMagic is said to work in the cave."
                  + "\u001B[34m" + "\nI will be your eyes and hands, direct me with commands of 1 and 2 words."
                  + "\u001B[34m" + "\n(Errors, suggestions, complaints to crowther)"
                  + "\u001B[34m" + "\n(If stuck type help for some hints)"
                  + "\u001B[34m" + "\nYou are standing at the end of a road before a small brick building."
                  + "\u001B[34m" + "\nAround you is a forest, a small stream flows out of the building and down a gully."
                  + "\u001B[34m" + "\nGo in, you are inside a building, a well house for a large spring"
                  + "\u001B[34m" + "\nThere are some keys on the ground here." 
                  + "\u001B[34m" + "\n" + "\n"); 
    }
    
    @Override
    public void help()
    {
        //If the player inputs the character i, these hints pops up
        //Using the color blue to difference from the room descriptions
        /*io.put("\u001B[34m" + "You need help?" 
                + "\u001B[34m" + "\nHere is your hints" 
                + "\u001B[34m" + "\nTo move n(orth)" 
                + "\u001B[34m" + "\nTo move s(outh) input s" 
                + "\u001B[34m" + "\nTo move w(est) input w" 
                + "\u001B[34m" + "\nTo move e(ast) input e" 
                + "\u001B[34m" + "\nIf you encounter an invalid choice, it might be because you have nothing at the direction you tried to input"
                + "\u001B[34m" + "\n");*/ // <-- advanced help function 
        
        io.put("\u001B[34m" + "Here is your hints" 
                + "\u001B[34m" + "\nOn your screen, you see the possible choices you have"
                + "\u001B[34m" + "\nInput the given choices to advance in the game"
                + "\u001B[34m" + "\n");
    }
}
