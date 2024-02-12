package Game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Floor extends Rectangle{
    public Floor(int x, int y){
        super(x, y, 32, 32);
    }
    
    public void render(Graphics g){
        g.drawImage(Spritesheet.tileFloor, x, y, 32, 32, null);
   
    }

}
