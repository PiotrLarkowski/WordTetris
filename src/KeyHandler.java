import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    StringBuilder stringBuilder = new StringBuilder();
    String input = "";
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            stringBuilder = new StringBuilder();
            input = "";
        }else {
            stringBuilder.append(e.getKeyCode());
            input = stringBuilder.toString();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.black);
        g2.setFont(new Font("Arial",Font.BOLD,32));
        try {
            g2.drawString("" + (char) Integer.parseInt(input), 300, 800);
        }catch(Exception e){

        }
    }
}
