package textadventure;

public class PlayerInfo 
{
    private String name;
    private int currentHealth = 100;
    //private int maxHealth = startHealth;
    private int currentDamage = 10;
    //private int maxDamage = startDamage;
    //private int lostLife = 0;
    private RoomInfo currentposition;
        
    public PlayerInfo(String name, RoomInfo currentposition) 
    {
        //Declaring the variables at start
        this.name = name;
        this.currentposition = currentposition;
        
    }
    
    public RoomInfo getCurrentposition() 
    {
        return currentposition;
    }

    public void setCurrentposition(RoomInfo currentposition) 
    {
        this.currentposition = currentposition;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getCurrentHealth() 
    {
        return currentHealth;
    }

    /*public int getMaxHealth() 
    {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) 
    {
        this.maxHealth = maxHealth;
    }*/

    public int getCurrentDamage() 
    {
        return currentDamage;
    }

    public void setCurrentDamage(int currentDamage) 
    {
        this.currentDamage = currentDamage;
    }

   /* public int getMaxDamage() 
    {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) 
    {
        this.maxDamage = maxDamage;
    }

    public int getLostLife() 
    {
        return lostLife;
    }

    public void setLostLife(int lostLife) 
    {
        this.lostLife = lostLife;
    }*/

    public void setCurrentHealth(int currentHealth) 
    {
        this.currentHealth = currentHealth;
    }
}
