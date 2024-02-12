package Game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {

    public boolean right, up, left, down;
    public int spd = 4;
    private int curFrames = 0, targetFrames = 10;
    private int curFramesIdle = 0, targetFramesIdle = 0;
    public boolean isMoving = false; // Variável para rastrear se o jogador está se movendo ou não
    public boolean isIdle = true; // Variável para rastrear se o jogador está parado ou não

    public Player(int x, int y) {
        super(x, y, 50, 50);
    }

    public void tick() {
        isMoving = (right || left || up || down);
        isIdle = (!right && !left && !up && !down);

        if (right && World.isFree(x + spd, y)) {
            x += spd;
        } else if (left && World.isFree(x - spd, y)) {
            x -= spd;
        }
        if (up && World.isFree(x, y - spd)) {
            y -= spd;
        } else if (down && World.isFree(x, y + spd)) {
            y += spd;
        }
        

        if (isIdle) {
            curFramesIdle++; // Incrementa o contador de frames enquanto o jogador está parado
            // Verifica se é hora de mudar para o próximo quadro de animação
        if (curFramesIdle <= targetFramesIdle) {
                curFramesIdle = 0; // Reinicia o contador de frames
            }
            // Verifica se o índice está dentro dos limites do array
        if (curFramesIdle >= Spritesheet.player_idle.length) {
                curFramesIdle = 0; // Reinicia para evitar índice fora dos limites
            }
        } else if (isMoving) {
            curFrames++; // Incrementa o contador de frames enquanto o jogador está se movendo
            // Verifica se é hora de mudar para o próximo quadro de animação
        if (curFrames >= targetFrames) {
                curFrames = 0; // Reinicia o contador de frames
            }
            // Verifica se o índice está dentro dos limites do array
        if (curFrames >= Spritesheet.player_walk.length) {
                curFrames = 0; // Reinicia para evitar índice fora dos limites
            }
        }
       

    }

    public void render(Graphics g) {
        if (isIdle) {
            if (curFramesIdle < Spritesheet.player_idle.length) {
                g.drawImage(Spritesheet.player_idle[curFramesIdle], x, y, 50, 50, null);
            }
        }
        else if (isMoving) {
            if (curFrames < Spritesheet.player_walk.length) {
                g.drawImage(Spritesheet.player_walk[curFrames], x, y, 50, 50, null);
            }
        } 
    }
    
}
    

