import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ladybug here.
 * 
 * @author Anya Shah 
 * @version November 12th, 2022
 */
public class Ladybug extends Actor
{
    int speed = 1;
    public void act()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        // Remove ladybug and draw game over when ladybug gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
            Greenfoot.stop();
        }
    }
    
    //Set frog speed
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
