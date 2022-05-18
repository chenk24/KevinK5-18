package AAKevinKwuestPrototypeAlpha;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UniversalG {
    public static Font gameFont;


    public UniversalG(){
        try {
            gameFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/AAKevinKwuestPrototypeAlpha/yoster.ttf")).deriveFont(30f);
        }
        catch(IOException | FontFormatException e){
            System.out.println("font failed");
        }


    }
}
