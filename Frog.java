import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The frog will move.
 * 
 * @author Anya Shah
 * @version December 5th, 2022
 */
public class Frog extends Actor
{
    GreenfootSound frogSound = new GreenfootSound("frogsound.mp3");
    
    /**
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
        eat();
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
