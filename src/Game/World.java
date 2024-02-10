package Game;

import java.awt.Graphics;
import java.util.ArrayList;


public class World {

    public static ArrayList<Blocks> Blocks = new ArrayList<Blocks>();

    public World(){
        for(int xx = 0; xx < 15; xx++){
            Blocks.add(new Blocks(xx*32, 0));
        }
        for(int xx = 0; xx < 15; xx++){
            Blocks.add(new Blocks(xx*32, 480-32));
        }
        for(int yy = 0; yy < 15; yy++){
            Blocks.add(new Blocks(0, yy*32));
        }
        for(int yy = 0; yy < 15; yy++){
            Blocks.add(new Blocks(480-32, yy*32));
        }
    }
    public static boolean isFree(int x, int y){
        for(int i = 0; i < Blocks.size(); i++){
            if(Blocks.get(i).intersects(new java.awt.Rectangle(x, y, 32, 32))){
                return false;
            }
        }
        return true;
    }
    public void tick(){
        
    }
    
    public void render(Graphics g) {
        for(int i = 0; i < Blocks.size(); i++){
            Blocks.get(i).render(g);
        }
       
    }
    
}
