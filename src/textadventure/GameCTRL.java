package textadventure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import textio.*;
import java.util.Random;
import java.util.Scanner;

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
            
            //Items for the player
            if(player.getCurrentposition().getItems().size() > 0)
            {
                for (items item : player.getCurrentposition().getItems()) 
                {}
                io.put("\n\nYou've stumbled upon an item! Do you want to pick it up?\nInput 0 if room contains 1 item, "
                        + "and if the room contains 2 items input either 0 or 1, depending on which you wish to pick up" + player.getCurrentposition().getItems());
                int pickUp = io.getInteger(0, player.getCurrentposition().getItems().size());
                
                player.getInv().add(player.getCurrentposition().getItems().get(pickUp));
                //System.out.println(player.getInv().size()); <-- used to check
                System.out.println("You picked up the following item(s): " + player.getCurrentposition().getItems());
                ArrayList<items> it = player.getCurrentposition().getItems();
                for (items object : it) 
                {
                    player.addToInv(object);
                    if(object instanceof Weapon)
                    {
                        ((Weapon)object).addToPlayerDamage(player);
                    }
                    else if(object instanceof Potion)
                    {
                        ((Potion)object).applyPotion(player);
                    }
                }
                //System.out.println(player.getInv().size()); <-- used to check
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
                        else if(player.getCurrentposition().getMinions()!= null) //if the room contains a minion
                        {
                                io.put("\u001B[31m" + "\n\nMINION IN HERE\n");                                
                                combat(player, player.getCurrentposition().getMinions());
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
                            else if(player.getCurrentposition().getMinions() != null)
                            {
                                io.put("\u001B[31m" + "\n\nMINION IN HERE\n");
                                combat(player, player.getCurrentposition().getMinions());
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
                            else if(player.getCurrentposition().getMinions() != null)
                            {
                                io.put("\u001B[31m" + "\n\nMINION IN HERE\n");
                                combat(player, player.getCurrentposition().getMinions());
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
                            else if(player.getCurrentposition().getMinions() != null)
                            {
                                io.put("\u001B[31m" + "\n\nMINION IN HERE\n"); 
                                combat(player, player.getCurrentposition().getMinions());
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

    public void combat(PlayerInfo player, MiniMonster minion) //work in progress
    {       
        ArrayList<String> comb = new ArrayList<>();
        comb.add("Attack");
        comb.add("Passive");
        
        while(true)
        {
            io.put("\nMinion attacks you!");
            player.setCurrentHealth(player.getCurrentHealth() + minion.getMinionDamage()); //The damage the minion inflicts on the player           
            
            int attacking = io.select("\nDo you wish to attack?", comb, "Make a choice");
            switch(comb.get(attacking))
            {
                case "Attack":
                    minion.setMinionLife(minion.getMinionLife() - player.getCurrentDamage()); //The damage the player inflicts on the minion
                    io.put("\nYou attacked the minion!"); 
                    break;
                case "Passive":
                    io.put("\nYou stayed passive!");
                    break;
                default:
                    break;  
            }
            
            io.put("\nRemaining health of the minion: " + minion.getMinionLife());
            io.put("\nYour remaining health:" + player.getCurrentHealth());
            
            if(player.getCurrentHealth() < 1)
            {
                io.put("\nYou died!");
                //combat = false;
                break;
            }
            else if(minion.getMinionLife() < 1)
            {
                io.put("\nYou managed to kill the minion!");
                //combat = false;
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
                + "\u001B[34m" + "\n");*/ // <-- advanced help function, might be used in the future 
        
        io.put("\n" + "\u001B[34m" + "Here is your hints" 
                + "\u001B[34m" + "\nOn your screen, you see the possible choices you have"
                + "\u001B[34m" + "\nInput the given choices to advance in the game"
                + "\u001B[34m" + "\nTo pick up the items input 0 or 1, depends on how many items the room has, if 1 item then input 0, "
                + "if 2 items you can input 0 or 1"
                + "\u001B[34m" + "\n");
    } 
}
