package textadventure;

//Gonna be used for later milestones
public class Event
{
    private int life; //life of the player
    private int damagePoint;
    
    public Event(int life, int damagePoint)
    {
        this.life = life; 
        this.damagePoint = damagePoint;
    }
    
    //applying the event
    public void applyEvent(PlayerInfo player)
    {     
        player.setCurrentHealth(player.getCurrentHealth() + life);
        player.setCurrentDamage(player.getCurrentDamage() + damagePoint);
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
