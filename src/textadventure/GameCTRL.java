package textadventure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import textio.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

//Where the gaming happens
public class GameCTRL implements Control
{
    private ArrayList<RoomInfo> rooms = new ArrayList<>(); //arraylist to store the roominfo
    private TextIO io = new TextIO(new SysTextIO());
    private boolean quit = false; //false at start to be able to play the game
    private Random rnd = new Random(); //to randomize the startlocation of the monster

    @Override
    public void play() 
    {
        io.put("***To sign in to play the, please enter name!***");
        //Definition of rooms      
        RoomDef rd = new RoomDef(rooms);
        rd.defRooms();
        Monster mo = new Monster("MONSTERNAME", "HISTORY", rooms.get(rnd.nextInt(8) +2));
        PlayerInfo player = new PlayerInfo(io.get(), rooms.get(0));
        
        //Introduction to the game
        io.put("\u001B[31m" + "Welcome to adventure!\n"); 
        //Prints info about the game
        printInfo();
        
        //Signing in to play the game
        io.put("Enter gamertag please");
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
            //If these 3 if statements below becomes true, the game stops, otherwise it will continue
            if(player.getCurrentposition() == rooms.get(9))
            {
                io.put("\n\u001B[32m" + "WINNER, CONGRATULATIONS!!!\n" 
                    + "\u001B[32m" + "IT WAS A JOY HAVING YOU HERE, HOPE TO SEE YOU AGAIN SOON!\n");
                break;
            }         
            if(player.getCurrentHealth() < 1)
            {
                io.put("\n" + "\u001B[31m" + "You died!\n");
                break;
            }          
            if(quit == true)
            {
                break; //stops the game if quit becomes true
            }
            
            //Ikke færdigt endnu
            if(player.getCurrentposition().getItems().size() > 0){
            for (items item : player.getCurrentposition().getItems()) {
                io.put("You've stumbled upon an item! Do you want to pick it up ?" + player.getCurrentposition().getItems());
            }
            int pickUp = io.getInteger(0, player.getCurrentposition().getItems().size());
                player.getInv().add(player.getCurrentposition().getItems().get(pickUp));
                player.getCurrentposition().getItems().remove(pickUp);
            }
            
    
               
            io.put("\nMake a choice player!");
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
            
            int result = io.select("You have these choices", maze, "What is your choice?");
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
                        if(mo.getCurrentPosition() == player.getCurrentposition())
                        {
                            player.setCurrentHealth(0);
                            player.setCurrentDamage(0);
                            io.put("\n\n" + "\u001B[31m" + "MONSTER KILLED YOU");
                            break;
                        }
                        else
                        {
                            player.getCurrentposition().getEvents().applyEvent(player);
                        }
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
                            if(mo.getCurrentPosition() == player.getCurrentposition())
                            {
                                player.setCurrentHealth(0);
                                player.setCurrentDamage(0);
                                io.put("\n\n" + "\u001B[31m" + "MONSTER KILLED YOU");
                                break;
                            }
                            else
                            {
                                player.getCurrentposition().getEvents().applyEvent(player);
                            }
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
                            if(mo.getCurrentPosition() == player.getCurrentposition())
                            {
                                player.setCurrentHealth(0);
                                player.setCurrentDamage(0);
                                io.put("\n\n" + "\u001B[31m" + "MONSTER KILLED YOU");
                                break;
                            }
                            else
                            {
                                player.getCurrentposition().getEvents().applyEvent(player);
                            }
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
                            if(mo.getCurrentPosition() == player.getCurrentposition())
                            {
                                player.setCurrentHealth(0);
                                player.setCurrentDamage(0);
                                io.put("\n\n" + "\u001B[31m" + "MONSTER KILLED YOU");
                                break;
                            }
                            else
                            {
                                player.getCurrentposition().getEvents().applyEvent(player);
                            }
                        }
                        break;
                    case "Help":
                        help();
                        break;
                        
                    case "Quit":
                        io.put("\u001B[31m" + "You have chosen to quit the game\n");
                        return;
                        
                    default:
                        break;
            } 
        mo.move();
        }
        
        //Getting the scores and comparing them
        HighScore highscores = new HighScore();
        highscores.addScore(player.getName(), player.getCurrentHealth());
        System.out.println(highscores.getBestName() + ": " + highscores.getBestScore());
        
        //Our filewriting and reading
        //Writing the file     
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
        try 
        {
            FileReader file = new FileReader("highscoreTAG.txt");
            BufferedReader reader = new BufferedReader(file);
        
            String text = "";
            String line = reader.readLine();
            String[] parts = line.split(", ");
            highscores.addScore(parts[0], Integer.parseInt(parts[1]));          
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
                + "\u001B[34m" + "\n");*/ // <-- advanced help function, might be used in the future 
        
        io.put("\n" + "\u001B[34m" + "Here is your hints" 
                + "\u001B[34m" + "\nOn your screen, you see the possible choices you have"
                + "\u001B[34m" + "\nInput the given choices to advance in the game"
                + "\u001B[34m" + "\n");
    } 
}
