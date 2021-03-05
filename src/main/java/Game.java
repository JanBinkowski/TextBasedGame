/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jan Binkowski
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Game {
    
        JFrame window;
        Container con;
        JPanel titleNamePanel,   //--- Here I create areas for texts and buttons etc.
               startButtonPanel,
               mainTextPanel,  
               choiceButtonPanel,
               playerPanel;
        JLabel  titleNameLabel, //--- Here I create the text (visible text)
                hpLabel, 
                hpLabelNumber, 
                weaponLabel, 
                weaponLabelName; 
        Font titleFont = new Font("Times New Roman", Font.PLAIN, 90); //--- here I set kind od font and size
       // Font startButtonFont = new Font("Times New Roman", Font.PLAIN, 30); 
       // Font choiceButtonFont = new Font("Times New Roman", Font.PLAIN, 24);
       // Font normalFont = new Font("Times New Roman", Font.PLAIN, 24);
        Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
        JButton startButton,
                choiceButton_1, choiceButton_2, choiceButton_3, choiceButton_4;
        JTextArea mainTextArea;
        int playerHP;
        String weapon, position;
       // String mainText;
        
        TitleScreenHandler tsHandler = new TitleScreenHandler();
        ChoiceHandler choiceHandler = new ChoiceHandler();
        
        public static void main(String[] args){ 
            new Game();
        }
        
        
        public Game(){ //--- Constructor
            window = new JFrame();
            window.setSize(800, 600); //--- width = x, height = y
            //window.setExtendedState(JFrame.MAXIMIZED_BOTH);
            
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.getContentPane().setBackground(Color.black);
            window.setLayout(null);
            window.setVisible(true);    //--- making window visible
            con = window.getContentPane();
            
            titleNamePanel = new JPanel();
            titleNamePanel.setBounds(100, 100, 600, 150); //--- setting place & size of the title
            titleNamePanel.setBackground(Color.black);
            
            titleNameLabel = new JLabel("ADVENTURE");   //--- here i'm setting the name of the title
            titleNameLabel.setForeground(Color.white);  //--- and color of a text
            titleNameLabel.setFont(titleFont);          //--- and kind of font
            
            startButtonPanel = new JPanel();
            startButtonPanel.setBounds(300, 400, 200, 100);
            startButtonPanel.setBackground(Color.black);
                    
            startButton = new JButton("START");
            startButton.setBackground(Color.black); //--- color of a backgorund
            startButton.setForeground(Color.white); //--- color of a text
            startButton.setFont(normalFont);
            startButton.addActionListener(tsHandler);
            startButton.setFocusPainted(false); //--- this line remove white box sorrounding a button           
            
            titleNamePanel.add(titleNameLabel);
            startButtonPanel.add(startButton);
            con.add(titleNamePanel);
            con.add(startButtonPanel);
            
        }
        
         
        public void createGameScreen(){
            
            titleNamePanel.setVisible(false);
            startButtonPanel.setVisible(false);
           
            mainTextPanel = new JPanel();
            mainTextPanel.setBounds(100, 100, 600, 250);
            mainTextPanel.setBackground(Color.black);
            con.add(mainTextPanel);
            
            mainTextArea = new JTextArea("Zadanie numer 1");
            mainTextArea.setBounds(100, 100, 600, 250);
            mainTextArea.setBackground(Color.BLACK);
            mainTextArea.setForeground(Color.WHITE);
            mainTextArea.setFont(normalFont);
            mainTextArea.setLineWrap(true);
            mainTextPanel.add(mainTextArea);
            
            choiceButtonPanel = new JPanel();
            choiceButtonPanel.setBounds(250,350,300,150);
            choiceButtonPanel.setBackground(Color.black);
            choiceButtonPanel.setLayout(new GridLayout(4,1));  //--- Here I set positions of buttons
            con.add(choiceButtonPanel);
                                  
                    //---  Button no1.
                    choiceButton_1 = new JButton("Option no 1");
                    choiceButton_1.setBackground(Color.black);
                    choiceButton_1.setForeground(Color.white);
                    choiceButton_1.setFont(normalFont);
                    choiceButtonPanel.add(choiceButton_1); //--- Here I am adding Button to a Panel
                    choiceButton_1.setFocusPainted(false); //--- Line which remove white line at the button
                    choiceButton_1.addActionListener(choiceHandler); // --- Now when you click a button it makes action 
                    choiceButton_1.setActionCommand("c1");
                    
                    //---  Button no2.
                    choiceButton_2 = new JButton("Option no 2");
                    choiceButton_2.setBackground(Color.black);
                    choiceButton_2.setForeground(Color.white);
                    choiceButton_2.setFont(normalFont);
                    choiceButtonPanel.add(choiceButton_2); //--- Here I am adding Button to a Panel
                    choiceButton_2.setFocusPainted(false); //--- Line which remove white line at the button
                    choiceButton_2.addActionListener(choiceHandler);
                    choiceButton_2.setActionCommand("c2");
                    
                    //---  Button no3.
                    choiceButton_3 = new JButton("Option no 3");
                    choiceButton_3.setBackground(Color.black);
                    choiceButton_3.setForeground(Color.white);
                    choiceButton_3.setFont(normalFont);
                    choiceButtonPanel.add(choiceButton_3); //--- Here I am adding Button to a Panel
                    choiceButton_3.setFocusPainted(false); //--- Line which remove white line at the button
                    choiceButton_3.addActionListener(choiceHandler);
                    choiceButton_3.setActionCommand("c3");
                    
                    //---  Button no4.
                    choiceButton_4 = new JButton("Option no 4");
                    choiceButton_4.setBackground(Color.black);
                    choiceButton_4.setForeground(Color.white);
                    choiceButton_4.setFont(normalFont);
                    choiceButtonPanel.add(choiceButton_4); //--- Here I am adding Button to a Panel
                    choiceButton_4.setFocusPainted(false); //--- Line which remove white line at the button
                    choiceButton_4.addActionListener(choiceHandler); 
                    choiceButton_4.setActionCommand("c4");
                    
            //---  Player panel on the top of a window ---
            playerPanel = new JPanel();
            playerPanel.setBounds(100, 15, 600, 50);
            playerPanel.setBackground(Color.black);
            playerPanel.setLayout(new GridLayout(1,4));
            con.add(playerPanel);
            
            
            
            //--- Labels for player's panel ---
            hpLabel = new JLabel("HP:");
            hpLabel.setFont(normalFont);
            hpLabel.setForeground(Color.white);
            playerPanel.add(hpLabel);  //--- adding label to a panel
            
            hpLabelNumber = new JLabel();
            hpLabelNumber.setFont(normalFont);
            hpLabelNumber.setForeground(Color.white);
            playerPanel.add(hpLabelNumber); //--- again, adding label to a panel
            
            weaponLabel = new JLabel("Weapon:");
            weaponLabel.setFont(normalFont);
            weaponLabel.setForeground(Color.white);
            playerPanel.add(weaponLabel);
            
            weaponLabelName = new JLabel();
            weaponLabelName.setFont(normalFont);
            weaponLabelName.setForeground(Color.white);
            playerPanel.add(weaponLabelName);
            
            playerSetup();  //--- Method to set up HPlevel and Weapon
        }
        
        public void playerSetup(){
            playerHP = 15;
            weapon = "Knife";
            hpLabelNumber.setText(""+playerHP); //--- setText() demands using a String type, so I had to do itthis way 
            weaponLabelName.setText(weapon);
            
            townGate();
        }
        
        public void townGate(){
            position = "townGate";
            
            mainTextArea.setText("You are at the gate of the town.\nA guard is standing in front of you.\n\nWhat do you do?"); 
            
            choiceButton_1.setText("Talk to the guard.");
            choiceButton_2.setText("Attack the guard.");
            choiceButton_3.setText("Leave.");
            choiceButton_4.setText("");
        }
        
        public void talkGuard(){
            position = "talkGuard";
            
            mainTextArea.setText("Guard: \nHello stranger. I have never seen your face before. \nI'm sorry but we cannot"
                    + " let a stranger enter our town.");
            
            choiceButton_1.setText("hasa");
            choiceButton_2.setText("");
            choiceButton_3.setText("");
            choiceButton_4.setText("");
        }
        
        public void attackGuard(){
            position = "attackGuard";
            
            mainTextArea.setText("Guard:\nHey, don't be stupid!\n\nThe guard fought back and hit ypu hard\n"
                    + "(You receive 3 damage.)");
            
            playerHP -= 3;  //--- HP level is updated
            hpLabelNumber.setText(""+playerHP); //--- update of HP level is visible
            choiceButton_1.setText("hasa");
            choiceButton_2.setText("");
            choiceButton_3.setText("");
            choiceButton_4.setText("");
        }
        
        
        public class TitleScreenHandler /*extends javax.swing.JFrame*/ implements ActionListener{
  
            public void actionPerformed(ActionEvent event){   
                createGameScreen();
            }    
        }
        
        public class ChoiceHandler implements ActionListener{
            public void actionPerformed(ActionEvent event){
             
                String yourChoice = event.getActionCommand( );
                
                switch(position){
                    case "townGate":
                        switch(yourChoice){
                            case "c1": talkGuard(); break;
                            case "c2": attackGuard(); break;
                            case "c3": break;
                        }break;
                    case "talkGuard":
                        switch(yourChoice){
                            case "c1": townGate();
                        }break;
                    case "attackGuard":
                        switch(yourChoice){
                            case "c1": townGate(); break;
                        }
                }
            }
        }
}
