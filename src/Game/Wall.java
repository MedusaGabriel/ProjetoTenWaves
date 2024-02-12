package Game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall extends Rectangle{
    public Wall(int x, int y){
        super(x, y, 32, 32);
    }
    
    public void render(Graphics g){
        g.drawImage(Spritesheet.tileWallLeft, x, y, 32, 32, null);
        g.drawImage(Spritesheet.tileWallRight, x, y, 32, 32, null);
    }

}