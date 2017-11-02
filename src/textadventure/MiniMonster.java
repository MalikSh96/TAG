package textadventure;

import java.util.ArrayList;

public class MiniMonster 
{
    private String minions;
    private int minionLife;
    private int minionDamage;
    private ArrayList<items> inv = new ArrayList();
    private Weapon loot;

    public MiniMonster(String minions, int life, int damage, Weapon loot) 
    {
        this.minions = minions;
        this.minionLife = life;
        this.minionDamage = damage;
        this.loot = loot;
        addMinionLoot(loot);
        
    }

    public MiniMonster(String minions, int minionLife, int minionDamage) 
    {
        this.minions = minions;
        this.minionLife = minionLife;
        this.minionDamage = minionDamage;
    }
    
    

    public void addMinionLoot(Weapon loot)
    {
        inv.add(loot);
    }
    
    public void removeInv(Weapon loot)
    {
        inv.remove(loot);
    }

    //Getters
    public String getMinion() 
    {
        return minions;
    }

    public int getMinionLife() 
    {
        return minionLife;
    }

    public int getMinionDamage() 
    {
        return minionDamage;
    }

    public Weapon getLoot() 
    {
        return loot;
    }

    public ArrayList<items> getInv() 
    {
        return inv;
    }
    
    

    //Setters
    public void setMinionLife(int minionLife) 
    {
        this.minionLife = minionLife;
    }  
}
