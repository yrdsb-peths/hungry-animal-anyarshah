import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The fly will move
 * 
 * @author Anya Shah 
 * @version November 28th, 2022
 */
public class Fly extends Actor
{
    /**
     * Act - do whatever the Fly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int x = getX();
        int y = getY() + 1;
        setLocation(x, y);
    }
}
