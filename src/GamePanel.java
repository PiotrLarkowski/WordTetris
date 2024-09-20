import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

public class GamePanel extends JPanel implements Runnable{

    static final int WIDTH = 600;
    static final int HEIGHT = 900;
    ArrayList<String> wordsList = new ArrayList<>(Arrays.asList("APPLE","BOTTLE"));
    long lastTime, currentTime;
    Boolean isBlocDropping = false;
    Block block;
    Thread gameThread;
    final int FPS = 60;
    PlayManager pm = new PlayManager();
    KeyHandler keyHandler = new KeyHandler();
    public GamePanel(){

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.white);
        this.setLayout(null);

        this.addKeyListener(keyHandler);
        this.setFocusable(true);

        launchGame();

    }

    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS;
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
            if(timer >= 1000000000){
                System.out.println("FPS:"+drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update(){
        pm.update();
        currentTime = System.currentTimeMillis();
        if(isBlocDropping && (currentTime-lastTime)>=1000){
            block.update();
            lastTime = currentTime;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        pm.draw(g2);
        if(!isBlocDropping){
            block = new Block(wordsList.get(0));
            lastTime = System.currentTimeMillis();
            isBlocDropping = true;
        }
        if(Block.y >= 600-PlayManager.bottomLevel*Block.BLOCK_HEIGHT){
            PlayManager.bottomY = Block.y+2;
            isBlocDropping = false;
            Block.y = PlayManager.TOP+12;
            PlayManager.bottomLevel ++;
        }
        block.draw(g2);
        keyHandler.draw(g2);
    }
}
