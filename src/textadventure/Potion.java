package textadventure;

public class Potion implements items 
{
    private String description; 
    private int hlt;

    Potion(String potion, String description, int hlt) 
    {
        this.description = description;
        this.hlt = hlt;
    }
    
    public void applyPotion(PlayerInfo player)
    {
        player.setCurrentHealth(player.getCurrentHealth() + hlt);
    }

    @Override
    public String getName() 
    {
        return "Potion";
    }

    @Override
    public String getDescription() 
    {
      return description;  
    }

    public int getHlt() 
    {
        return hlt;
    }

    @Override
    public String toString() 
    {
        return "Potiondescription: " + description + ", health:" + hlt;
    }
}
