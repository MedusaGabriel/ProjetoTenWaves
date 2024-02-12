package Game;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Spritesheet {

    public static BufferedImage spritesheet;
    public static BufferedImage spritesheetwall;
    

    public static BufferedImage[] player_front;

    public static BufferedImage tileWall;
    public static BufferedImage tileFloor;
    public static BufferedImage tileWallRight;
    public static BufferedImage tileWallLeft;
        
    public Spritesheet(){
        try {
            spritesheet = ImageIO.read(getClass().getResource("res/spritesheet.png"));
            spritesheetwall = ImageIO.read(getClass().getResource("res/spritesheetwall.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        player_front = new BufferedImage[3];


        player_front[0] = Spritesheet.getSprite(259, 229, 32, 32);
        player_front[1] = Spritesheet.getSprite(291, 229, 32, 32);
        player_front[2] = Spritesheet.getSprite(323, 229, 32, 32);
        //player_front[3] = Spritesheet.getSprite(52, 11, 16, 16);

        tileWall = Spritesheet.getSpriteWall(36, 1, 16, 16);
        tileFloor = Spritesheet.getSpriteWall(54, 1, 16, 16);

        tileWallRight = Spritesheet.getSpriteWall(93, 1, 16, 16);
        tileWallLeft = Spritesheet.getSpriteWall(74, 1, 16, 16);
    }
    public static BufferedImage getSprite(int x, int y, int width, int height){
        return spritesheet.getSubimage(x, y, 31,54);
    }
    public static BufferedImage getSpriteWall(int x, int y, int width, int height){
        return spritesheetwall.getSubimage(x, y, width, height);
    }


  
    
}
