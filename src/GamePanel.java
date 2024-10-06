import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GamePanel extends JPanel implements Runnable {
    public boolean endGame = false;
    static final int WIDTH = 600;
    static final int HEIGHT = 900;
    static ArrayList<String> wordsList = new ArrayList<>();
    long lastTime, currentTime;
    static Boolean isBlocDropping = false;
    Block block;
    Thread gameThread;
    final int FPS = 60;
    PlayManager pm = new PlayManager();
    KeyHandler keyHandler = new KeyHandler();

    public GamePanel() {

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.white);
        this.setLayout(null);

        this.addKeyListener(keyHandler);
        this.setFocusable(true);

        downloadWordsFile();

        launchGame();

    }

    public void launchGame() {
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
        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update() {
        pm.update();
         currentTime = System.currentTimeMillis();
        if (isBlocDropping && (currentTime - lastTime) >= 500) {
            block.update();
            lastTime = currentTime;
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        String presentWord;
        Random random = new Random();
        pm.draw(g2);
        if(!endGame) {
            if (!isBlocDropping) {
                presentWord = wordsList.get(random.nextInt(wordsList.size()-1));
                block = new Block(presentWord);
                lastTime = System.currentTimeMillis();
                isBlocDropping = true;
            }
            if (Block.y >= 600 - PlayManager.bottomLevel * Block.BLOCK_HEIGHT) {
                PlayManager.bottomY = Block.y + 2;
                isBlocDropping = false;
                Block.y = PlayManager.TOP + 12;
                PlayManager.bottomLevel++;
            }
            if (PlayManager.bottomLevel == 9) {
                endGame = true;
            }
            block.draw(g2);
            keyHandler.draw(g2);
        }else{
            g2.setColor(Color.white);
            g2.fillRect(150,300,300,200);
            g2.setColor(Color.black);
            g2.drawRect(160,310,280,180);
            g2.setFont(new Font("Arial",Font.BOLD,64));
            g2.drawString("THE",240,390);
            g2.drawString("END",240,450);
        }
    }
    public static ArrayList<String> downloadWordsFile() {
        ArrayList<String> allWords = new ArrayList<>();
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    wordsList.add(myReader.nextLine());
                }
                myReader.close();
            } catch (Exception e) {
                System.out.println("Read File Problem");
            }
        }
        return allWords;
    }
}
