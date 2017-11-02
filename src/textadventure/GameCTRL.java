package textadventure;

import java.util.ArrayList;
import textio.*;
import java.util.Random;

//Where the gaming happens
public class GameCTRL implements Control
{
    private ArrayList<RoomInfo> rooms = new ArrayList<>(); //arraylist to store the roominfo
    private TextIO io = new TextIO(new SysTextIO());
    private boolean quit = false; //false at start to be able to play the game
    private Random rnd = new Random(); //to randomize the startlocation of the monster

    @Override
    public void GameCentral() 
    {
        io.put("********************To sign in to play the game, please enter name!********************");
        //Gets RoomDef, where the description of the rooms are     
        RoomDef rd = new RoomDef(rooms);
        rd.defRooms();
        //Gets the Monster class and creates a new instance of it
        Monster mo = new Monster("\u001B[31m" + "BigBoss", "\u001B[31m" + "The story behind BigBoss is, that BigBoss was the first ever to enter this dungeon. "
                + "\u001B[31m" + "\nBigBoss decided to visit the dungeon because he heard rumors that there was a big treasure hiding."
                + "\u001B[31m" + "\nBigBoss went into the dungeon, and that was the last we heard of BigBoss."
                + "\u001B[31m" + "\nSome say that this very day BigBoss is still walking in the dungeon searching for the treasure, and will kill everyone that gets in BigBoss' way"
                + "\u001B[31m" + "\nOur advice is to avoid BigBoss no matter what, the strenght of BigBoss is enormous, and you don't want to witness it" + "\u001B[31m", rooms.get(rnd.nextInt(8) +2));
        //Gets the PlayerInfo class and creates a new instance of it
        PlayerInfo player = new PlayerInfo(io.get(), rooms.get(0));
        //Introduction to the game
        io.put("\u001B[31m" + "Welcome to adventure!\n"); 
        //Prints info about the game
        GameInfo();
        //BigBoss' history gets printed to the screen
        io.put("\n" + mo.getHistory() + "\n\n");       
        //Signing in to play the game
        io.put("Welcome " + player.getName() + ", we are looking forward to play with you\n");
        io.put("\nEnter age");
        int age = io.getInteger();
        io.put("you are " + age + "\n");        
        //The game starts here
        io.put(player.getCurrentposition().getRoomEventText() + "\n\nName is: " + player.getName() +  "\nYour health is: " + player.getCurrentHealth() 
                + "\nThe damage you can inflict is: " + player.getCurrentDamage());      
        //Getting the Play method for the player, the Play method contains other methods in it too
        Play(player, mo);      
        //Getting the HighScore class and creates a new instance of it
        HighScore highscores = new HighScore();
        if(!quit) //to make sure that if the player decides to quit, he score doesn't count
        {
            io.put("\nThis is the highscores: ");   
            highscores.addScore(player.getName(), player.getCurrentHealth());
            System.out.println(highscores.getBestName() + ": " + highscores.getBestScore());
            //Getting TheFILE class
            TheFILE file = new TheFILE();
            file.FILE(highscores);
        }      
    }
    
    
    //OUR MEHTODS USED ABOVE, IS CREATED BELOW HERE
    //Play method, includes our compass and move method
    public void Play(PlayerInfo player, Monster mo)
    {
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
            //Getting the PickItems method to use in the Play method
            PickItems(player);  
            //Lets the user know he can make a choice
            io.put("\nMake a choice player!");
            //Creating a maze which contains our directions
            ArrayList<String> maze = new ArrayList<>();
            //Prints info to the player
            io.put("\nYour name is: " + player.getName() + "\nYour current health is: " + player.getCurrentHealth()
                    + "\nThe damage you can inflict is: " + player.getCurrentDamage() + "\n");            
            //Adding our directions into the ArrayList
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
            //Adding our created maze into a select, that displays our choices
            int result = io.select("You have these choices", maze, "What is your choice?");
            //Using a switch statement to make use o our choices
            switch(maze.get(result)) 
            {
                case "North":
                        player.setCurrentposition(player.getCurrentposition().getNorth());
                        io.put(player.getCurrentposition().getRoomEventText());
                        CheckEnemy(player, mo);
                    break;                  
                case "South":                  
                        player.setCurrentposition(player.getCurrentposition().getSouth());
                        io.put(player.getCurrentposition().getRoomEventText());
                        CheckEnemy(player, mo);
                    break;                   
                case "West":
                        player.setCurrentposition(player.getCurrentposition().getWest());
                        io.put(player.getCurrentposition().getRoomEventText());    
                        CheckEnemy(player, mo);
                    break;                       
                case "East":
                        player.setCurrentposition(player.getCurrentposition().getEast());
                        io.put(player.getCurrentposition().getRoomEventText());     
                        CheckEnemy(player, mo);
                    break;
                case "Help":
                        help();
                    break;                      
                case "Quit":
                        io.put("\u001B[31m" + "You have chosen to quit the game\n");
                        quit = true;
                    return;                       
                default:
                    break;
            }
        //Getting the movement method for the BigBoss, which is allowed to move around after the player makes a choice    
        mo.move();
        }
    }
    
    //Items method
    public void PickItems(PlayerInfo player)
    {
        //Items for the player
        /*if(player.getCurrentposition().getItems().size() > 0)
        {
            //Prints out that the player has a choice of picking up an item_Items
            io.put("\n\nYou've stumbled upon an item! Do you want to pick it up?\nInput 0 if room contains 1 item, "
                    + "and if the room contains 2 item_Items input either 0 or 1, depending on which you wish to pick up" 
                    + player.getCurrentposition().getItems());
            int pickUp = io.getInteger(0, player.getCurrentposition().getItems().size());
            //Gets the inventory and adds the pickup into it
            player.getInv().add(player.getCurrentposition().getItems().get(pickUp));
            //System.out.println(player.getInv().size()); <-- used to check
            System.out.println("You picked up the following item(s): " + player.getCurrentposition().getItems().get(pickUp));
            player.getCurrentposition().getItems().remove(pickUp);              
        }*/
        
            ArrayList<items> item_Items = player.getCurrentposition().getItems();
            int pickUp = 1;
            while (item_Items.size() > 0 && pickUp != 0) {
                
                io.put("\n\nYou've stumbled upon an item! Do you want to pick it up?\n");

                ArrayList<String> options = new ArrayList();
                options.add("Nothing");

                for (int i = 0; i < item_Items.size(); i++) 
                {
                    options.add(item_Items.get(i).getName());
                }
                options.add("All");

                pickUp = io.select("Here are the options you can chose from ", options, "");
                if (pickUp == options.size() - 1) 
                {
                    //all
                }
                else if (pickUp > 0) 
                {
                    player.getInv().add(item_Items.get(pickUp - 1));
                    io.put("You have picked up the following: " + item_Items.get(pickUp -1));
                    item_Items.remove(pickUp - 1);
                }
            }
        
        
    }
    
    //Combat method
    public void Combat(PlayerInfo player, MiniMonster minion)
    {       
        //Creating a combat ArrayList to add our options
        ArrayList<String> combat = new ArrayList<>();
        //Adding our options
        combat.add("Attack");
        combat.add("Passive");
        //Using a while(true) to keep to combat going until either the player og enemy dies
        while(true)
        {
            io.put("\nMinion attacks you!");
            //Takes the players current health and the minions damage to substract from the players current healt
            player.setCurrentHealth(player.getCurrentHealth() + minion.getMinionDamage()); //The damage the minion inflicts on the player           
            //Creating a menu for the player if he decides to attack or stay passive, staying passive DOES allow the enemy to attack you
            int attacking = io.select("\nDo you wish to attack?", combat, "Make a choice");
            //Using a switch statement to choose between our options
            switch(combat.get(attacking))
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
            //If the player dies this happens
            if(player.getCurrentHealth() < 1)
            {
                io.put("\nThe minion killed you!");
                break;
            }
            //If the minion dies and contains loot, this happens
            if(minion.getMinionLife() < 1 && minion.getInv().size() > 0)
            {
                ArrayList<items> monsterloot = new ArrayList<>();
                io.put("\nYou managed to kill the minion"
                    + "\nThe minion dropped some loot "
                    + minion.getInv()
                    + "\nIf you wish to pick up the loot type 1, else leave it behind by typing any other NUMBER than 1.");
                int loot = io.getInteger();
                //If input is 1, the loot gets picked up
                if(loot == 1)
                {
                    player.addToInv(minion.getLoot());
                    io.put("You've picked up: " + minion.getLoot());
                    minion.removeInv(minion.getLoot());
                    player.getCurrentposition().addMiniMonster(null); //setting it to null, so that when the minion gets killed it gets removed from the room
                    break;
                } 
                //If the player decides to leave it behind, this happens
                else
                {
                   io.put("You've decided to leave the item behind.");
                   minion.removeInv(minion.getLoot());
                   player.getCurrentposition().addMiniMonster(null); //setting it to null, so that when the minion gets killed it gets removed from the room
                   break;
                }                  
            }
            //If the minion dies and it doesn't contain loot, this happens
            if(minion.getMinionLife() < 1)
            {
                io.put("\nYou managed to kill the minion!");
                break;
            }
        }
    }
    
    //Checking if the room contains an enemy
    public void CheckEnemy(PlayerInfo player, Monster mo)
    {
        //If BigBoss' current position is the same as the players, the players health is set to 0, which kills the player and ends the game
        if(mo.getCurrentPosition() == player.getCurrentposition())
        {
            player.setCurrentHealth(0);
            player.setCurrentDamage(0);
            io.put("\n\n" + "\u001B[31m" + "BigBoss killed you!");
        }
        //If the players current position contains an enemy(minion) this here happen
        else if(player.getCurrentposition().getMinions()!= null) //if the room contains a minion
        {
            io.put("\u001B[31m" + "\n\nMINION IN HERE\n");                                
            Combat(player, player.getCurrentposition().getMinions());
        }
        //Else if none of the above happens the player moves "safely" around
        else
        {
            player.getCurrentposition().getEvents().applyEvent(player);
        }
    }
    
    @Override
    public void GameInfo()
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
        io.put("\n" + "\u001B[34m" + "Here is your hints" 
                + "\u001B[34m" + "\nOn your screen, you see the possible choices you have"
                + "\u001B[34m" + "\nInput the given choices to advance in the game"
                + "\u001B[34m" + "\nTo pick up the items input 0 or 1, depends on how many items the room has, if 1 item then input 0, "
                + "if 2 items you can input 0 or 1"
                + "\u001B[34m" + "\n");
    } 
}
