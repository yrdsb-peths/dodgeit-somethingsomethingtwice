import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Hero hero = new Hero();
        addObject(hero, 300, 200);
    }
    
    public void started() {
        Bomb bomb = new Bomb();
        addObject(bomb, 600, 0);
        bomb.resetBomb();
    }
}
