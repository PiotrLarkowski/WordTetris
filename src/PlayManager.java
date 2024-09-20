import java.awt.*;

public class PlayManager {

    static final int WIDTH = 400;
    static final int HEIGHT = 580;
    public static int bottomLevel = 0;
    public static int bottomY = 0;
    static final int TOP = 100;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

    public PlayManager(){

        left_x = (GamePanel.WIDTH/2)-WIDTH/2;
        right_x = left_x + WIDTH;
        top_y = TOP;
        bottom_y = top_y + HEIGHT;

    }

    public void update(){

    }

    public void draw(Graphics2D g2){

        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(left_x-4, top_y - 4, WIDTH+8, HEIGHT + 8);
        g2.drawRect(left_x+8, top_y+8, WIDTH-16, HEIGHT-16);
        if(bottomLevel>0){
            g2.fillRect(114, 114+((10-bottomLevel)*Block.BLOCK_HEIGHT),
                    (WIDTH-28),Block.BLOCK_HEIGHT+(bottomLevel*Block.BLOCK_HEIGHT));
        }

    }

}
