package textadventure;

import java.util.ArrayList;

public class RoomInfo
{   
    private String roomEventText;
    private int roomNumber;
    private RoomInfo north, south, east, west;
    private Event events; 
    private ArrayList<items> items = new ArrayList<>();
    private MiniMonster minions;

    RoomInfo(String roomEventText, int roomNumber, Event events) 
    {
        this.roomEventText = roomEventText;
        this.roomNumber = roomNumber;
        this.events = events;
    }
    
    public RoomInfo getNorth() 
    {
        return north;
    }

    public void setNorth(RoomInfo north) 
    {
        this.north = north;
    }

    public RoomInfo getSouth() 
    {
        return south;
    }

    public void setSouth(RoomInfo south) 
    {
        this.south = south;
    }

    public RoomInfo getEast() 
    {
        return east;
    }

    public void setEast(RoomInfo east) 
    {
        this.east = east;
    }

    public RoomInfo getWest() 
    {
        return west;
    }

    public void setWest(RoomInfo west) {
        this.west = west;
    }
    
    public String getRoomEventText() 
    {
        return roomEventText;
    }

    public int getRoomNumber() 
    {
        return roomNumber;
    }  

    public Event getEvents() 
    {
        return events;
    }

    public void setEvents(Event events) 
    {
        this.events = events;
    }  

    public ArrayList<items> getItems() 
    {
        return items;
    }

    public void addItem(items item) 
    {
       items.add(item);
    }
    
    public void addMiniMonster(MiniMonster minions)
    {
        this.minions = minions;
    }

    public MiniMonster getMinions() 
    {
        return minions;
    }
}
