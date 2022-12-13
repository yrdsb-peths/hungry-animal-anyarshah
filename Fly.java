import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The fly will move
 * 
 * @author Anya Shah 
 * @version December 12th, 2022
 */
public class Fly extends Actor
{
    int speed = 1;
    public void act()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        // Remove fly and draw game over when fly gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
            Greenfoot.stop();
        }
    }
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
