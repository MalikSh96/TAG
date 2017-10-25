package textadventure;

//Gonna be used for later milestones
public class Event
{
    private int life; //life of the player
    private String monster;
    
    public Event(int life, String monster)
    {
        this.life = life;   
        this.monster = monster;
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

    public String getMonster() 
    {
        return monster;
    }

    public void setMonster(String monster) 
    {
        this.monster = monster;
    } 
}
