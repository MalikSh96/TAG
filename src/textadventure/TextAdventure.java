package textadventure;


/*
IMPORT NOTE, WHEN PLAYING THE GAME FIRST TIME, AT THE END OF THE GAME, IF YOU FINISH IT, 
A MESSAGE OF NULLPOINTER EXCEPTION WILL POP UP, DON'T WORRY ABOUT, IT IS ALL BECAUSE AT THE 
START YOU DON'T HAVE A FILE, THEREFORE A NEW FILE WILL BE CREATED, AND THEN THAT ERROR WILL 
DISSAPEAR AND NO LONGER BE THERE!
SO SHORT, IF YOU DON'T HAVE A FILE CREATED, THEN A NEW FILE WILL BE CREATED, AND A NULLPOINTER EXCEPTION WILL OCCUR
BUT AFTER THAT, WHEN THE FILE IS CREATED THE NULLPOINTER EXCEPTION IS GONE
*/
public class TextAdventure 
{
    public static void main(String[] args) 
    {
        GameCTRL game = new GameCTRL();
        game.play();
    }
}
