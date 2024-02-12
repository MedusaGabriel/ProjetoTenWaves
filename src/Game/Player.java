package Game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle{
    public boolean right, up, left, down;
    public int spd = 10;
    public int curAnimation = 0;
    public int curFrames = 0, targetFrames = 7;
    public Player(int x, int y){
        super(x, y, 90, 90);
    }
    public void tick(){
        if(right && World.isFree(x+spd, y)){
            x+=spd;
        }
        else if(left && World.isFree(x-spd, y)	){
            x-=spd;
        }
        if(up && World.isFree(x, y-spd)){
            y-=spd;
        }
        else if(down && World.isFree(x, y+spd)){
            y+=spd;
        }
        curFrames++;
        if (curFrames == targetFrames) {
            curFrames = 0;
            curAnimation++;
            if(curAnimation == Spritesheet.player_idle.length){
                curAnimation = 0;
            }
            
        }
    }
    public void render (Graphics g){

       g.drawImage(Spritesheet.player_idle[curAnimation], x, y, 90, 90, null);
    }
}