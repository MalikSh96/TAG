package textadventure;

public class RoomInfo 
{   
    private String roomEventText;
    private int roomNumber;
    private int roomEvent;
    private RoomInfo north, south, east, west;
    private String enterRoom;
    private Event events; //eve is short for event

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

    public int getRoomEvent() 
    {
        return roomEvent;
    }

    public int getRoomNumber() 
    {
        return roomNumber;
    }  
    
    public String getEnterRoom() //not used as of now
    {
        return enterRoom;
    }

    public void setEnterRoom(String enterRoom) //not used as of now
    {
        this.enterRoom = enterRoom;
    }

    public Event getEvents() 
    {
        return events;
    }

    public void setEvents(Event events) 
    {
        this.events = events;
    }  
}
