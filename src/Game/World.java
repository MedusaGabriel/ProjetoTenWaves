package Game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


public class World {

    public static ArrayList<Blocks> Blocks = new ArrayList<Blocks>();
    public static ArrayList<Floor> Floor = new ArrayList<Floor>();
    public static ArrayList<Wall> Wall = new ArrayList<Wall>();
    
    public Player player;

    public World(){
        // Inicializa os blocos
        for(int xx = 0; xx < 20; xx++){
            Blocks.add(new Blocks(xx*32, 0));
            Blocks.add(new Blocks(xx*32, 480-32));
        }
        for(int yy = 0; yy < 20; yy++){
            Wall.add(new Wall(0, yy*32));
            Wall.add(new Wall(640-32, yy*32));
        }

        // Inicializa o piso
        for(int xx = 0; xx < 20; xx++){
            for(int yy = 0; yy < 20; yy++){
                Floor.add(new Floor(xx*32, yy*32));
            }
        }
    }
    public static boolean isFree(int x, int y){
        for(int i = 0; i < Blocks.size(); i++){
            if(Blocks.get(i).intersects(new java.awt.Rectangle(x, y, 32, 32))){
                return false;
            }
        }
        for (int i = 0; i < Wall.size(); i++) {
            if (Wall.get(i).intersects(new Rectangle(x, y, 32, 32))) {
                return false;
            }
        }
        return true;
    }
    public void tick(){
        
    }
    
    public void render(Graphics g) {
        for(int i = 0; i < Floor.size(); i++){
            Floor.get(i).render(g);
        }
        for(int i = 0; i < Wall.size(); i++){
            Wall.get(i).render(g);
        }
        for(int i = 0; i < Blocks.size(); i++){
            Blocks.get(i).render(g);
        }
        
    }
    
}
