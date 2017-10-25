package textadventure;

//Gonna be used for later milestones
public class Event
{
    private int life; //life of the player
    
    public Event(int life)
    {
        this.life = life;   
    }
    
    //applying the event
    public void applyEvent(PlayerInfo player)
    {     
        player.setCurrentHealth(player.getCurrentHealth() + life);
    }

    public int getLife() 
    {
        return life;
    }

    public void setLife(int life) 
    {
        this.life = life;
    }
}
