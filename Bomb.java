import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*; // For list

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(8);
        
        if (isAtEdge())
            resetBomb();
        else {
             List<Hero> heroes = getIntersectingObjects(Hero.class);
             int size = heroes.size();
             if (size > 0) {
                 World world = getWorld();
                 int totalX = getX();
                 int totalY = getY();
                 for (int i = 0; i < size; i++) {
                     Hero hero = heroes.get(i);
                     totalX += hero.getX();
                     totalY += hero.getY();
                     world.removeObject(hero);
                 }
                 Death death = new Death();
                 world.addObject(death, totalX / (size + 1), totalY / (size + 1));
                 world.removeObject(this);
              }
        }
    }
    
    public void resetBomb() {
        // Get a number from 0-3
        int side = Greenfoot.getRandomNumber(4);
        int world_width = getWorld().getWidth();
        int world_height = getWorld().getHeight();
        switch(side) {
            case 0:
                setLocation(Greenfoot.getRandomNumber(world_width), 0);
                break;
            case 1:
                setLocation(Greenfoot.getRandomNumber(world_width), 400);
                break;
            case 2:
                setLocation(0, Greenfoot.getRandomNumber(world_height));
                break;
            case 3:
                setLocation(600, Greenfoot.getRandomNumber(world_height));
                break;
        }
        turnTowards(Greenfoot.getRandomNumber(world_width), Greenfoot.getRandomNumber(world_height));
    }
}
