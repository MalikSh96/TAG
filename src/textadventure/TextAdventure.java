package textadventure;

public class TextAdventure 
{
    public static void main(String[] args) 
    {
        GameCTRL game = new GameCTRL();
        game.play();
        game.end();
        Monster monst = new Monster("NAME", "HISTORY", new RoomInfo("", -100, new Event(0, 0)));
    }
}
