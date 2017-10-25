package textadventure;

import java.util.ArrayList;

public class RoomDef
{    
    public void defRooms(ArrayList<RoomInfo> rooms)
    {   
        
        rooms.add(new RoomInfo("\nWelcome to the starting room, which is a safe spot" 
                + "\nYes, somewhere nearby is colossal cave, where others have found fortunes in treasure and gold."
                + "\nThough it is rumored that some who enter are never seen again."
                + "\nMagic is said to work in the cave."
                + "\nyou are inside a building, a well house for a large spring"
                + "\nThere are some keys on the ground here."
                + "\nThis dungeon contains a BIG treasure, which has a lot of positive items and wishes, such as being eternal rich and alive" 
                + "\n\n" + "\u001B[31m" +"***TYPE IN YOUR EVENT***",
                0, new Event(0, 0))); //Starting room, which is room 1, Event(..., ...) conatains the life damage added/inflicted and the damage added/inflicted
  
        rooms.add(new RoomInfo("\nWelcome into the entrance, be carefull, you may encounter hideous monsters ahead" 
                + "\n" + "\u001B[31m" +"***TYPE IN YOUR EVENT***",
                1, new Event(10, 20))); //room 2
        
        rooms.add(new RoomInfo("\nWelcome to the pool room, you can go for a swim... or not" 
                + "\n\n" + "\u001B[31m" +"***TYPE IN YOUR EVENT***",
                2, new Event(-20, -10))); //room 3
        
        rooms.add(new RoomInfo("\nWelcome to the living room, there is an item on the floor, pick it up" 
                + "\n\n" + "\u001B[31m" +"***TYPE IN YOUR EVENT***",
                3, new Event(-30, 40))); //room 4
        
        rooms.add(new RoomInfo("\nWelcome to the bar, sit and grab a drink, but drinking may damage you" 
                + "\n\n" + "\u001B[31m" +"***TYPE IN YOUR EVENT***",
                4, new Event(10, 10))); //room 5
        
        rooms.add(new RoomInfo("\nWelcome to the bunny room, lots of cute bunnies, but harmful" 
                + "\n\n" + "\u001B[31m" +"***TYPE IN YOUR EVENT***",
                5, new Event(-50, -30))); //room 6
        
        rooms.add(new RoomInfo("\nWelcome to the magical room, this is where the magic happens, gains full health and a new items" 
                + "\n\n" + "\u001B[31m" +"***TYPE IN YOUR EVENT***",
                6, new Event(50, 40))); //room 7
        
        rooms.add(new RoomInfo("\nWelcome to the pillow fight room, lay down and relax, but you lose health no matter what" 
                + "\n\n" + "\u001B[31m" +"***TYPE IN YOUR EVENT***",
                7, new Event(-60, 10))); //room 8
        
        rooms.add(new RoomInfo("\nWelcome to the dungeon, fight the demon to continue" 
                + "\n\n" + "\u001B[31m" +"***FINAL BOSS FIGHT***",
                8, new Event(-90, -40))); //room 9
        
        rooms.add(new RoomInfo("\nWell... hello there seems like you have found the" 
                + "\n" + "\u001B[31m" +"\u001B[31m" +  " BIG TREASURE!!! \n",
                9, new Event(100, 100))); //room 10

        //Directing the rooms to its respective neighbor
        //Starting room direction
        rooms.get(0).setNorth(rooms.get(1));

        //room 2 directions
        rooms.get(1).setSouth(rooms.get(0)); //room 2 south leads to starting room
        rooms.get(1).setWest(rooms.get(2)); //room 2 west leads to room 3
        rooms.get(1).setNorth(rooms.get(4)); //room 2 north leads to room 5

        //room 3 directions
        rooms.get(2).setNorth(rooms.get(3)); //room 3 north leads to room 4
        rooms.get(2).setEast(rooms.get(1)); //room 3 east leads to room 2

        //room 4 directions
        rooms.get(3).setSouth(rooms.get(2)); //room 4 south leads to room 3
        rooms.get(3).setEast(rooms.get(4)); //room 4 east leads to room 5

        //room 5 directions
        rooms.get(4).setWest(rooms.get(3)); //room 5 west leads to room 4
        rooms.get(4).setNorth(rooms.get(7)); //room 5 north leads to room 6
        rooms.get(4).setSouth(rooms.get(1)); //room 5 south leads to room 2
        rooms.get(4).setEast(rooms.get(5)); //room 5 east leads to room 6

        //room 6 directions
        rooms.get(5).setWest(rooms.get(4)); //room 6 west leads to room 5
        rooms.get(5).setNorth(rooms.get(6)); //room 6 north leads to room 7

        //room 7 directions
        rooms.get(6).setSouth(rooms.get(5)); //room 7 south leads to room 6

        //room 8 directions
        rooms.get(7).setSouth(rooms.get(4)); //room 8 south leads to room 5
        rooms.get(7).setWest(rooms.get(8)); //room 8 west leads to room 9

        //room 9 directions
        rooms.get(8).setWest(rooms.get(9)); //room 9 west leads to room 10, WINNER
        rooms.get(8).setEast(rooms.get(7)); //room 9 east leads to room 8
    }
}
