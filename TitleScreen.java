import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a title screen
 * 
 * @author Anya Shah 
 * @version December 12th, 2022
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Frog", 80);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(titleLabel, 245, 50);
        prepare();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Frog frog = new Frog();
        addObject(frog,512,85);
        Label label1 = new Label("Press <space> to start the game!", 40);
        addObject(label1,getWidth()/2,245);
        Label label2 = new Label("Use <-- and --> to move!", 40);
        addObject(label2,getWidth()/2,306);
    }
}
