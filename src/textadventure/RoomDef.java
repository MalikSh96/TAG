package textadventure;

import java.util.ArrayList;

public class RoomDef
{    
    private ArrayList<RoomInfo> rooms;

    public RoomDef(ArrayList<RoomInfo> rooms) 
    {
        this.rooms = rooms;
    }

    public void defRooms()
    {     
        //If a room contains a monster, it events will the be nullified, ie. the room itself will NOT have an impact on the player if the room has a monster       
        rooms.add(new RoomInfo("\nWelcome to the starting room, which is a safe spot" 
                + "\nYes, somewhere nearby is colossal cave, where others have found fortunes in treasure and gold."
                + "\nThough it is rumored that some who enter are never seen again."
                + "\nMagic is said to work in the cave."
                + "\nyou are inside a building, a well house for a large spring"
                + "\nThere are some keys on the ground here."
                + "\nThis dungeon contains a BIG treasure, which has a lot of positive items and wishes, such as being eternal rich and alive",
                0, new Event(0, 0))); //Starting room, which is room 1, Event(..., ...) conatains the life damage added/inflicted and the damage added/reduced
  
        rooms.add(new RoomInfo("\nWelcome into the entrance, be carefull, further in this maze you may encounter hideous monsters, be ready and armed!",
                1, new Event(0, 0))); //room 2
        
        rooms.add(new RoomInfo("\nWelcome to the pool room, some say the water is safe, "
                + "others say that the water contains radioactive chemicals which may affect your health negatively"
                + " only one way to find out...",
                2, new Event(0, 0))); //room 3
        
        rooms.add(new RoomInfo("\nWelcome to the living room, it was rumored that this was the room where the architects dissapeared",
                3, new Event(0, 0))); //room 4
        
        rooms.add(new RoomInfo("\nWelcome to the bar, sit and grab a drink, reload yourself",
                4, new Event(0, 0))); //room 5
        
        rooms.add(new RoomInfo("\nWelcome to the minion room, lots of cute minion, but they are very aggressive",
                5, new Event(0, 0))); //room 6
        
        rooms.add(new RoomInfo("\nWelcome to the magical room, this is where the magic happens, gaining health and acquiring new items",
                6, new Event(0, 0))); //room 7
        
        rooms.add(new RoomInfo("\nWelcome to the pillow fight room, lay down and relax, but as you relax a loss of health and damage infliction occurs",
                7, new Event(0, 0))); //room 8
        
        rooms.add(new RoomInfo("\nWelcome to the dungeon, history of this dungeon is, that it is known to roam serious magic, and NOT the good kind of magic",
                8, new Event(0, 0))); //room 9
        
        rooms.add(new RoomInfo("\nWell... hello there seems like you have found the" 
                + "\n" + "\u001B[31m" + "\u001B[31m" +  "BIG TREASURE!!!\n",
                9, new Event(100, 100))); //room 10

        //Directing the rooms to its respective neighbor(s)
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
        
        //Final room direction only returns to the second to last room
        rooms.get(9).setEast(rooms.get(8)); //room 10 east leads back to room 9
        
        
        //adding items to the different rooms
        rooms.get(1).addItem(new Weapon("Sword", "Is a sword", 3));
        rooms.get(1).addItem(new Potion("Potion","Is health potion", 10));
        rooms.get(5).addItem(new Weapon("Sword level 1", "Use to kill opponents", 6));

        //Adding minions to the different rooms, wit possibility of having loots on them
        rooms.get(1).addMiniMonster(new MiniMonster("minion1", 20, -2, new Weapon("Knife", "Historic knife", 5)));
        rooms.get(3).addMiniMonster(new MiniMonster("minion2", 20, -3, new Weapon("Sword level 2", "Upgrades your level 1 sword", 20)));
        rooms.get(5).addMiniMonster(new MiniMonster("minion3", 40, -5, new Weapon("Baseball bat", "Can be used to damage opponent", 5)));
        rooms.get(7).addMiniMonster(new MiniMonster("minion4", 80, -3)); //The minion in this room has no item on it
        rooms.get(8).addMiniMonster(new MiniMonster("minion4", 80, -1, new Weapon("", "", 0)));
    }
}
