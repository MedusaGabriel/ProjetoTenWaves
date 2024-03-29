package Game;
import java.awt.Canvas;
//import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import Game.Game;



public class Game extends Canvas implements Runnable, KeyListener{

    public static int WIDTH = 1280, HEIGHT = 720;
    public static int SCALER = 3;
    public static Image grass;
    public Game game;
    public Player player;
    public World world;
    
    //1366x768
    public Game(){
        this.addKeyListener(this);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        new Spritesheet();

        player = new Player(32, 32);
        world = new World();
    }

    // Game loop - logica do jogo
    public void tick(){
        player.tick();

    }
    // Render  - Renderizar o jogo
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        //g.setColor(Color.DARK_GRAY);
       //g.fillRect(0,0, WIDTH, HEIGHT);

        
        world.render(g);
        player.render(g);

        bs.show();


    }

    public static void main(String[] args){

        Game game = new Game();
        JFrame frame = new JFrame("Game");
        frame.add(game);
        frame.setTitle("Ten Waves");

        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

        new Thread(game).start();


    }


   public void run(){
         while(true){
            tick();
            render();

            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }

              //System.out.println("Running...");
         }

   }

@Override
public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    
}

@Override
public void keyPressed(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_RIGHT){
        player.right = true;
    }
    else if(e.getKeyCode() == KeyEvent.VK_LEFT){
        player.left = true;
    }
    if(e.getKeyCode() == KeyEvent.VK_UP){
        player.up = true;
    }
    else if(e.getKeyCode() == KeyEvent.VK_DOWN){
        player.down = true;
    }
}

@Override
public void keyReleased(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_RIGHT){
        player.right = false;
    }
    else if(e.getKeyCode() == KeyEvent.VK_LEFT){
        player.left = false;
    }
    if(e.getKeyCode() == KeyEvent.VK_UP){
        player.up = false;
    }
    else if(e.getKeyCode() == KeyEvent.VK_DOWN){
        player.down = false;
    }
}
}