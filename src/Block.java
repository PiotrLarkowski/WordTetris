import java.awt.*;

public class Block {
    int presentLevel = 1;
    public static final int BLOCK_HEIGHT = 50;
    public static final int BLOCK_WIDTH = 180;
    public static int x = (GamePanel.WIDTH/2)-PlayManager.WIDTH/2+(PlayManager.WIDTH/2-BLOCK_WIDTH/2);
    public static int y = PlayManager.TOP+12;
    String word;

    public Block(String presentWord){
        this.word = presentWord;
    }

    public void update(){

    }

    public void draw(Graphics2D g2){
        g2.fillRect(x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
        g2.setColor(Color.white);
        g2.setFont(new Font("Arial",Font.BOLD,32));
        g2.drawString(word,x+(BLOCK_WIDTH /2)-word.length()*10,y+(BLOCK_HEIGHT /2)+8);
    }
}
