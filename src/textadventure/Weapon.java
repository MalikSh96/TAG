package textadventure;

public class Weapon implements items
{
    private String name;
    private String description;
    private int dmg;

    public Weapon(String name, String description, int dmg) 
    {
        this.name = name;
        this.description = description;
        this.dmg = dmg;
    }

    @Override
    public String getName() 
    {
        return name;
    }

    @Override
    public String getDescription() 
    {
        return description;
    }
    
    public int getDamage()
    {
        return dmg;
    }

    @Override
    public String toString() 
    {
        return "Weaponname: " + name + ", description: " + description + ", dmg: " + dmg;
    }  
}
