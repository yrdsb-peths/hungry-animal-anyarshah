import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The frog will move.
 * 
 * @author Anya Shah
 * @version December 8th, 2022
 */
public class Frog extends Actor
{
    GreenfootSound frogSound = new GreenfootSound("frogsound.mp3");
    GreenfootImage[] idle = new GreenfootImage[8];
    public Frog()
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/frog_idle/idle" + i + ".png");
        }
        setImage(idle[0]);
    }
    /**
     * Animate the frog
     */
    int imageIndex = 0;
    public void animateFrog()
    {
        setImage(idle[imageIndex]);   
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    /**0
     * Moves the frog using the arrow keys.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
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
    }
}
