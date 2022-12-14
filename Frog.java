import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The frog will move.
 * 
 * @author Anya Shah
 * @version December 12th, 2022
 */
public class Frog extends Actor
{
    GreenfootSound frogSound = new GreenfootSound("frogsound.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    // Direction the frog is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Constructor
     */
    
    public Frog()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/frog_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/frog_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        
        animationTimer.mark();
        // Initial frog image
        setImage(idleRight[0]);
    }
    /**
     * Animate the frog
     */
    int imageIndex = 0;
    public void animateFrog()
    {
        if(animationTimer.millisElapsed() < 175)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);   
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);   
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    /**
     * Moves the frog using the arrow keys.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            move(3);
            facing = "right";
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
            facing = "left";
        }
        // Removes fly if frog touches it
        eat();
        // Animates the frog
        animateFrog();
    }
    /**
     * Removes the fly if the frog touches it. Then it spawns a new fly
     * anywhere in the world.
     */
    public void eat()
    {
        if(isTouching(Fly.class))
        {
            removeTouching(Fly.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnFly();
            world.increaseScore();
            frogSound.play();
        }
        if(isTouching(Ladybug.class))
        {
            removeTouching(Ladybug.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnLadybug();
            world.increaseScore();
            frogSound.play();
        }
    }
}
