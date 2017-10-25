package textadventure;

public class Monsters implements Enemy
{
    private String description; 
    private String backgroundStory;
    private RoomInfo currentPosition;
    
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
    
    @Override
    public void finalBoss() 
    {
        
    }
    
    /*@Override
    public void miniMonsters() 
    {
        
    }*///NOT USED YET, LATEr
}
