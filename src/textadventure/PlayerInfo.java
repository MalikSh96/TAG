package textadventure;

import java.util.ArrayList;

public class PlayerInfo
{
    private String name;
    private int currentHealth = 100;
    private int currentDamage = 10;
    private RoomInfo currentposition;
    private ArrayList<items> inv = new ArrayList<>();
    private ArrayList<items> equipped = new ArrayList<>();
        
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

    public int getCurrentDamage() 
    {
        return currentDamage;
    }

    public void setCurrentDamage(int currentDamage) 
    {
        this.currentDamage = currentDamage;
    }

    public void setCurrentHealth(int currentHealth) 
    {
        this.currentHealth = currentHealth;
    }

    public ArrayList<items> getInv() 
    {
        return inv;
    }
    
    public void addToInv(items item)
    {
        inv.add(item);
    }
    
    public void addToEquip(items item)
    {
        if(item instanceof Weapon)
        {
            setCurrentDamage(currentDamage + item.Effect());
            equipped.add(item);
            inv.remove(item);
        }
        if(item instanceof Potion)
        {
            setCurrentHealth(currentHealth + item.Effect());
            inv.remove(item);
        }       
    }

    public ArrayList<items> getEquipped() 
    {
        return equipped;
    }
}
