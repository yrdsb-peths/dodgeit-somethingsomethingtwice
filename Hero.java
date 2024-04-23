import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Hero extends Actor
{
    int targetX = -1;
    int targetY = -1;
    
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null) {
                targetX = mouse.getX();
                targetY = mouse.getY();
            }
        }
        if ((targetX != -1 || targetY != -1) && (getX() != targetX || getY() != targetY)) {
            turnTowards(targetX, targetY);
            // calculate distance, since x and y are ints, cast to int
            int distance = (int) Math.sqrt(Math.pow(targetX - getX(), 2) + Math.pow(targetY - getY(), 2));
            move(Math.min(8, distance));
        }
    }
}
