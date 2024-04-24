import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    int score = 0;
    Hero hero;
    Bomb bomb;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        hero = new Hero();
        bomb = new Bomb();
        addObject(hero, 300, 200);
    }
    
    public void started() {
        addObject(bomb, 600, 0);
        bomb.resetBomb();
    }
    
    public void act() {
        if (hero.getWorld() != null)
            score++;
        showText(String.valueOf(score), 300, 32);
    }
}
