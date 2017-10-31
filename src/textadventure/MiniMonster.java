package textadventure;

import java.util.ArrayList;

public class MiniMonster 
{
    private String minions;
    private int minionLife;
    private int minionDamage;
    private ArrayList<items> inv = new ArrayList();

    public MiniMonster(String minions, int life, int damage, Weapon loot) 
    {
        this.minions = minions;
        this.minionLife = life;
        this.minionDamage = damage;
        
        if (loot != null)
        {
            addMinionLoot(loot);
        }
    }
    
    /*public void Combat(PlayerInfo player) //work in progress, moved into GameCTRL
    {
        player.setCurrentHealth(player.getCurrentHealth() + minionDamage); //The damage the minion inflicts on the player
        setMinionLife(getMinionLife() - player.getCurrentDamage()); //The damage the player inflicts on the minion
    }*/
    
    public void addMinionLoot(Weapon loot)
    {
        inv.add(loot);
    }
    
    /*public void remiveLoot(Weapon loot)
    {
        inv.remove(loot);
    }*/

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
    
    //Setters
    public void setMinionLife(int minionLife) 
    {
        this.minionLife = minionLife;
    }   
}
