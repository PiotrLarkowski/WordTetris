import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    StringBuilder stringBuilder = new StringBuilder();
    char input = ' ';
    char letter1 = ' ';
    char letter2 = ' ';
    char letter3 = ' ';
    char letter4 = ' ';
    char letter5 = ' ';
    char letter6 = ' ';
    char letter7 = ' ';
    char letter8 = ' ';

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            stringBuilder = new StringBuilder();
            clearAllLetters();
        }else {
            input = (char)e.getKeyCode();
            stringBuilder.append(input);
            if(letter1==' '){
                letter1 = input;
            }else if(letter2 == ' '){
                letter2 = input;
            }else if(letter3 == ' '){
                letter3 = input;
            }else if(letter4 == ' '){
                letter4 = input;
            }else if(letter5 == ' '){
                letter5 = input;
            }else if(letter6 == ' '){
                letter6 = input;
            }else if(letter7 == ' '){
                letter7 = input;
            }else if(letter8 == ' '){
                letter8 = input;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void clearAllLetters(){
        letter1 = ' ';
        letter2 = ' ';
        letter3 = ' ';
        letter4 = ' ';
        letter5 = ' ';
        letter6 = ' ';
        letter7 = ' ';
        letter8 = ' ';
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.black);
        g2.setFont(new Font("Arial",Font.BOLD,32));
        try {
            g2.drawString("" + letter1, 200, 800);
            g2.drawString("" + letter2, 240, 800);
            g2.drawString("" + letter3, 280, 800);
            g2.drawString("" + letter4, 320, 800);
            g2.drawString("" + letter5, 360, 800);
            g2.drawString("" + letter6, 400, 800);
            g2.drawString("" + letter7, 440, 800);
            g2.drawString("" + letter8, 480, 800);
        }catch(Exception e){

        }
    }
}
