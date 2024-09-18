import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GamePanel extends JPanel implements Runnable{

    static final int WIDTH = 600;
    static final int HEIGHT = 900;
    ArrayList<String> wordsList = new ArrayList<>(Arrays.asList("APPLE","BOTTLE"));

    Boolean isBlocDropping = false;
    Block block;
    Thread gameThread;
    final int FPS = 60;
    PlayManager pm = new PlayManager();

    public GamePanel(){

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.white);
        this.setLayout(null);

        launchGame();

    }

    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        long oneSecondInNano = 1000000000;
        double drawInterval = (double) oneSecondInNano / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;
        while(gameThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta --;
                drawCount++;
            }
            if(timer >= oneSecondInNano){
                System.out.println("FPS:"+drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update(){
        pm.update();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        pm.draw(g2);
        if(!isBlocDropping){
            block = new Block(wordsList.get(0));
        }
        block.draw(g2);
    }
}
