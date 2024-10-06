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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(stringBuilder.toString().equals(Block.word)){
                GamePanel.isBlocDropping = false;
                Block.y = PlayManager.TOP+12;
            }
            stringBuilder = new StringBuilder();
            clearAllLetters();
        }else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if(letter5 != ' '){
                letter5 = ' ';
            }else if(letter4 != ' '){
                letter4 = ' ';
            }else if(letter3 != ' '){
                letter3 = ' ';
            }else if(letter2 != ' '){
                letter2 = ' ';
            }else if(letter1 != ' '){
                letter1 = ' ';
            }
        }else {
            input = (char)e.getKeyCode();
            stringBuilder.append(input);
            if(letter1 == ' '){
                letter1 = input;
            }else if(letter2 == ' '){
                letter2 = input;
            }else if(letter3 == ' '){
                letter3 = input;
            }else if(letter4 == ' '){
                letter4 = input;
            }else if(letter5 == ' '){
                letter5 = input;
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
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.black);
        g2.setFont(new Font("Arial",Font.BOLD,32));

        g2.drawString("INPUT TEXT", 200, 730);

        g2.drawRect(130,760,40,60);
        g2.drawRect(190,760,40,60);
        g2.drawRect(250,760,40,60);
        g2.drawRect(310,760,40,60);
        g2.drawRect(370,760,40,60);

        try {
            g2.drawString("" + letter1, 140, 800);
            g2.drawString("" + letter2, 200, 800);
            g2.drawString("" + letter3, 260, 800);
            g2.drawString("" + letter4, 320, 800);
            g2.drawString("" + letter5, 380, 800);
        }catch(Exception ignored){
        }
    }
}
