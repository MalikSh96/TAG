package textadventure;

//THIS CLASS CONTAINS OLD CODE THAT IS NOT USED, BUT "MIGHT" BE USED AGAIN
public class UnusedCODE 
{
    //Movement method
     //Using a while loop to keep the game flowing until final destination is reached
        /*while(true)
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
            //The items method
            pickItems(player);           
            io.put("\nMake a choice player!");
            ArrayList<String> maze = new ArrayList<>();          
            io.put("\nYour name is: " + player.getName() + "\nYour current health is: " + player.getCurrentHealth()
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
                    return;                       
                default:
                    break;
            } 
        mo.move();
        }*/

    //Checking for enemies
    /*if(mo.getCurrentPosition() == player.getCurrentposition())
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
                            }*/




    //Our filewriting and reading
        //Writing the file     
        /*File newFile = new File("highscoreTAG.txt");
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
        }*/
    
    
        //HELP FUNCTION
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
    
    
                /*for (items item : player.getCurrentposition().getItems()) 
            {}*/ // <-- for each loop not used!
        
}
