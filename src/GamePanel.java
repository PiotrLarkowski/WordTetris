import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    Thread gameThread;
    final int FPS = 60;

    public GamePanel(){

        this.setPreferredSize(new Dimension(640, 900));
        this.setBackground(Color.white);
        this.setLayout(null);

    }

    public void launchGame(){
        gameThread = new Thread();
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){

            currentTime = System.nanoTime();
            delta =+ (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta --;
                System.out.println((currentTime - lastTime) / drawInterval);
            }
        }
    }

    public void update(){

    }

    public void paintComponent(Graphics g) {

    }
}
