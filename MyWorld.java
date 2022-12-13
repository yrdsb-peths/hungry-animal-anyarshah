import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world where the frog lives.
 * 
 * @author Anya Shah 
 * @version December 5th, 2022
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        // Create frog object
        Frog frog = new Frog();
        addObject(frog, 50, 350);
        
        // Create a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
         
        // Adds a fly randomly on the world
        spawnFly();
        // Adds a ladybug randomly on the world
        spawnLadybug();
    }
    
    /*
     * End the game and draw 'Game Over'
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label ("Game Over!", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /*
     * Increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        if(score % 10 == 0)
        {
            level += 1;
        }
    }
    public void spawnFly()
    {
        Fly fly = new Fly();
        fly.setSpeed(level);
        int x = Greenfoot.getRandomNumber(500);
        int y = 10;
        addObject(fly, (x + 100), y);
    }
    public void spawnLadybug()
    {
        Ladybug ladybug = new Ladybug();
        ladybug.setSpeed(level);
        int x = Greenfoot.getRandomNumber(500);
        int y = 10;
        addObject(ladybug, (x + 100), y);
    }
}
