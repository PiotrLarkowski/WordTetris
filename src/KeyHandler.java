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

        g2.drawString("INPUT TEXT", 200, 730);

        g2.drawRect(70,760,40,60);
        g2.drawRect(130,760,40,60);
        g2.drawRect(190,760,40,60);
        g2.drawRect(250,760,40,60);
        g2.drawRect(310,760,40,60);
        g2.drawRect(370,760,40,60);
        g2.drawRect(430,760,40,60);
        g2.drawRect(490,760,40,60);

        try {
            g2.drawString("" + letter1, 80, 800);
            g2.drawString("" + letter2, 140, 800);
            g2.drawString("" + letter3, 200, 800);
            g2.drawString("" + letter4, 260, 800);
            g2.drawString("" + letter5, 320, 800);
            g2.drawString("" + letter6, 380, 800);
            g2.drawString("" + letter7, 440, 800);
            g2.drawString("" + letter8, 500, 800);
        }catch(Exception ignored){
        }
    }
}
