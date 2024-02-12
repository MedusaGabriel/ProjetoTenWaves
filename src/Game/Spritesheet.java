package Game;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Spritesheet {

    
    public static BufferedImage spritesheetwall;
    public static BufferedImage spritesheetfloor;
    public static BufferedImage sprite_player_idle;

    //Sprites Player Buffered
    public static BufferedImage[] player_idle;


    //Sprite Floor/Wall(Chão/Parede)
    public static BufferedImage tileFloor;

    public static BufferedImage tileWall;
    public static BufferedImage tileWallRight;
    public static BufferedImage tileWallLeft;
        
    public Spritesheet(){
        try {
            sprite_player_idle = ImageIO.read(getClass().getResource("res/sprite_player_idle.png"));
            spritesheetwall = ImageIO.read(getClass().getResource("res/spritesheetwall.png"));
            spritesheetfloor = ImageIO.read(getClass().getResource("res/spritesheetfloor.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Sprites Player
        player_idle = new BufferedImage[2];
        player_idle[0] = sprite_player_idle.getSubimage(25, 41, 32, 32);
        player_idle[1] = sprite_player_idle.getSubimage(155, 41, 32, 32);
       // player_idle[2] = sprite_player_idle.getSubimage(278, 41, 32, 32);
       // player_idle[3] = sprite_player_idle.getSubimage(406, 41, 32, 32);
       // player_idle[4] = sprite_player_idle.getSubimage(535, 41, 32, 32);
       // player_idle[5] = sprite_player_idle.getSubimage(664, 41, 32, 32);


        //Sprites Floor
        tileFloor = spritesheetfloor.getSubimage(617, 614, 300, 300);
        

       // tileWall = Spritesheet.getSpriteWall(36, 1, 16, 16);
        //tileWallRight = Spritesheet.getSpriteWall(93, 1, 16, 16);
        //tileWallLeft = Spritesheet.getSpriteWall(74, 1, 16, 16);
    }
   // public static BufferedImage getSprite(int x, int y, int width, int height){
   //     return spritesheet.getSubimage(x, y, 31,54);
   // }
   
    public static BufferedImage getSpriteWall(int x, int y, int width, int height){
        return spritesheetwall.getSubimage(x, y, width, height);
    }
    public static BufferedImage getSpritePlayerIdle(int x, int y, int width, int height){
        return sprite_player_idle.getSubimage(x, y, 90, 90);
    }
    public static BufferedImage getSpriteFloor(int x, int y, int width, int height){
        return spritesheetfloor.getSubimage(x, y, 300, 300);
    }




  
    
}
