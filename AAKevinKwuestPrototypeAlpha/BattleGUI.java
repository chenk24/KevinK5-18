package AAKevinKwuestPrototypeAlpha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;



public class BattleGUI extends JFrame {
    private static JFrame battleWindow;
    private static Container battleOverlay;
    private static JButton attackButton;
    private static JLayeredPane layers;
    public static JTextArea healthStatus;

    public static void main(String[] args){
        new BattleGUI();
    }


    public BattleGUI(JFrame window) {
        battleWindow = window;
        battleOverlay = battleWindow.getContentPane();
        createSceneBackground();
        createAttackScreenBackground();
        createAttackButton();
        createHealthScreen();
        battleOverlay.add(layers);
        battleWindow.setVisible(true);
    }

    public BattleGUI(){
        createWindow();
        createSceneBackground();
        createAttackScreenBackground();
        createAttackButton();
        createHealthScreen();
        battleOverlay.add(layers);
        battleWindow.setVisible(true);
    }

    public void createWindow(){
        battleWindow = new JFrame("Kevin Kwuest");
        battleWindow.setSize(1920, 1080);
        battleWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        battleWindow.getContentPane().setBackground(Color.black);
        battleWindow.setLayout(null);
        battleOverlay = battleWindow.getContentPane();
    }

    public void createSceneBackground() {
        try {
            ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource("/images/BattleBackground1.png"));
            JLabel displayField = new JLabel(backgroundImage);
            displayField.setSize(1920, 1080);
            layers = new JLayeredPane();
            layers.setBounds(0, 0, 1920, 1080);
            layers.add(displayField, Integer.valueOf(1));
        } catch (Exception e) {
            System.out.print("No image found3");
        }
    }

    public void createAttackScreenBackground(){
        try {
            ImageIcon screenBackgroundImage = new ImageIcon(this.getClass().getResource("/images/BattleScreenBackgroundv1.4.png"));
            JLabel displayField = new JLabel(screenBackgroundImage);
            displayField.setSize(1920, 1080);
            layers.add(displayField, Integer.valueOf(2));
        } catch (Exception e) {
            System.out.print("No image found4");
        }
    }

public void createHealthScreen(){

    healthStatus = new JTextArea();
    // stops the user from being able to edit the text
    healthStatus.setEditable(false);
    healthStatus.setBounds(100, 100, 600, 250);
    healthStatus.setBackground(Color.black);
    // makes the background of textarea transparent
    healthStatus.setOpaque(false);
    // stops the user from being able to highlight the text
    healthStatus.setHighlighter(null);
    // sets the color of the text
    healthStatus.setForeground(Color.black);
    // sets the custom game font
    healthStatus.setFont(UniversalG.gameFont);
    healthStatus.setLineWrap(true);
    healthStatus.setWrapStyleWord(true);

    // set text sets a new string
    healthStatus.setText("tableeee");


    layers.add(healthStatus, Integer.valueOf(3));



}



    public void createAttackButton(){
        attackButton = new JButton("Attack");
        attackButton.setBounds(1920 / 2 - 320 / 2, 1080 / 2 - 125 / 2, 320, 125);
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == attackButton) {
                    Battle.attack();
                }
            }
        });
        layers.add(attackButton, Integer.valueOf(3));
    }
}

