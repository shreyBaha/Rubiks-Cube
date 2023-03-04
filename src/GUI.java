import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;
import javax.xml.transform.Source;

import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
//introcs.cs.princeton.edu/java/15inout/GUI.java.html
public class GUI extends JFrame implements ActionListener{
  
  Cube cube = new Cube();
  int curF = 0;
  int curR = 0;
  int curC = 0;

  JRadioButton col0 = new JRadioButton();
  JRadioButton col1 = new JRadioButton();
  JRadioButton col2 = new JRadioButton();
  JRadioButton row0 = new JRadioButton();
  JRadioButton row1 = new JRadioButton();
  JRadioButton row2 = new JRadioButton();

  ButtonGroup col = new ButtonGroup();
  ButtonGroup row = new ButtonGroup();
  
  JButton rowRight;
  JButton rowLeft;
  JButton colUp;
  JButton colDown;
  JButton rotateClock = new JButton("Rotate Face Clockwise");
  JButton rotateCountClock = new JButton("Rotate Face Counter-Clockwise");
  JButton f0Button = new JButton("Front Face");
  JButton f1Button = new JButton("Right Face");
  JButton f2Button = new JButton("Back Face");
  JButton f3Button = new JButton("Left Face");
  JButton f4Button = new JButton("Top Face");
  JButton f5Button = new JButton("Bottom Face");
  JButton prevButton = f0Button;
  JButton scramble = new JButton("SCRAMBLE!");
  
  JPanel curr0c0 = new JPanel();
  JPanel curr0c1 = new JPanel();
  JPanel curr0c2 = new JPanel();
  JPanel curr1c0 = new JPanel();
  JPanel curr1c1 = new JPanel();  
  JPanel curr1c2 = new JPanel();
  JPanel curr2c0 = new JPanel();
  JPanel curr2c1 = new JPanel();
  JPanel curr2c2 = new JPanel();
  JPanel f0r0c0 = new JPanel();
  JPanel f0r0c1 = new JPanel();
  JPanel f0r0c2 = new JPanel();
  JPanel f0r1c0 = new JPanel();
  JPanel f0r1c1 = new JPanel();
  JPanel f0r1c2 = new JPanel();
  JPanel f0r2c0 = new JPanel();
  JPanel f0r2c1 = new JPanel();
  JPanel f0r2c2 = new JPanel();
  JPanel f1r0c0 = new JPanel();
  JPanel f1r0c1 = new JPanel();
  JPanel f1r0c2 = new JPanel();
  JPanel f1r1c0 = new JPanel();
  JPanel f1r1c1 = new JPanel();
  JPanel f1r1c2 = new JPanel();
  JPanel f1r2c0 = new JPanel();
  JPanel f1r2c1 = new JPanel();
  JPanel f1r2c2 = new JPanel();
  JPanel f2r0c0 = new JPanel();
  JPanel f2r0c1 = new JPanel();
  JPanel f2r0c2 = new JPanel();
  JPanel f2r1c0 = new JPanel();
  JPanel f2r1c1 = new JPanel();
  JPanel f2r1c2 = new JPanel();
  JPanel f2r2c0 = new JPanel();
  JPanel f2r2c1 = new JPanel();
  JPanel f2r2c2 = new JPanel();
  JPanel f3r0c0 = new JPanel();
  JPanel f3r0c1 = new JPanel();
  JPanel f3r0c2 = new JPanel();
  JPanel f3r1c0 = new JPanel();
  JPanel f3r1c1 = new JPanel();
  JPanel f3r1c2 = new JPanel();
  JPanel f3r2c0 = new JPanel();
  JPanel f3r2c1 = new JPanel();
  JPanel f3r2c2 = new JPanel();
  JPanel f4r0c0 = new JPanel();
  JPanel f4r0c1 = new JPanel();
  JPanel f4r0c2 = new JPanel();
  JPanel f4r1c0 = new JPanel();
  JPanel f4r1c1 = new JPanel();
  JPanel f4r1c2 = new JPanel();
  JPanel f4r2c0 = new JPanel();
  JPanel f4r2c1 = new JPanel();
  JPanel f4r2c2 = new JPanel();
  JPanel f5r0c0 = new JPanel();
  JPanel f5r0c1 = new JPanel();
  JPanel f5r0c2 = new JPanel();
  JPanel f5r1c0 = new JPanel();
  JPanel f5r1c1 = new JPanel();
  JPanel f5r1c2 = new JPanel();
  JPanel f5r2c0 = new JPanel();
  JPanel f5r2c1 = new JPanel();
  JPanel f5r2c2 = new JPanel();

  JPanel[][] curArr = {{curr0c0, curr0c1, curr0c2}, {curr1c0, curr1c1, curr1c2}, {curr2c0, curr2c1, curr2c2}};
  JPanel[][] f0Arr = {{f0r0c0, f0r0c1, f0r0c2}, {f0r1c0, f0r1c1, f0r1c2}, {f0r2c0, f0r2c1, f0r2c2}};
  JPanel[][] f1Arr = {{f1r0c0, f1r0c1, f1r0c2}, {f1r1c0, f1r1c1, f1r1c2}, {f1r2c0, f1r2c1, f1r2c2}};
  JPanel[][] f2Arr = {{f2r0c0, f2r0c1, f2r0c2}, {f2r1c0, f2r1c1, f2r1c2}, {f2r2c0, f2r2c1, f2r2c2}};
  JPanel[][] f3Arr = {{f3r0c0, f3r0c1, f3r0c2}, {f3r1c0, f3r1c1, f3r1c2}, {f3r2c0, f3r2c1, f3r2c2}};
  JPanel[][] f4Arr = {{f4r0c0, f4r0c1, f4r0c2}, {f4r1c0, f4r1c1, f4r1c2}, {f4r2c0, f4r2c1, f4r2c2}};
  JPanel[][] f5Arr = {{f5r0c0, f5r0c1, f5r0c2}, {f5r1c0, f5r1c1, f5r1c2}, {f5r2c0, f5r2c1, f5r2c2}};

  ImageIcon rubiksIcon = new ImageIcon("rubiks-cube.png");

  public static void main(String[] args){
    new GUI(); 
  }
  
  GUI(){

    col.add(col0);
    col.add(col1);
    col.add(col2);
    row.add(row0);
    row.add(row1);
    row.add(row2);

    col0.setBounds(315, 115, 20, 20);
    col0.addActionListener(this);
    col1.setBounds(365, 115, 20, 20);
    col1.addActionListener(this);
    col2.setBounds(415, 115, 20, 20);
    col2.addActionListener(this);
    row0.setBounds(275, 155, 20, 20);
    row0.addActionListener(this);
    row1.setBounds(275, 205, 20, 20);
    row1.addActionListener(this);
    row2.setBounds(275, 255, 20, 20);
    row2.addActionListener(this);

    curr0c0.setBounds(300, 140, 50, 50);
    curr0c0.setBackground(Color.GREEN);
    curr0c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    curr0c1.setBounds(350, 140, 50, 50);
    curr0c1.setBackground(Color.GREEN);
    curr0c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    curr0c2.setBounds(400, 140, 50, 50);
    curr0c2.setBackground(Color.GREEN);
    curr0c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    curr1c0.setBounds(300, 190, 50, 50);
    curr1c0.setBackground(Color.GREEN);
    curr1c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    curr1c1.setBounds(350, 190, 50, 50);
    curr1c1.setBackground(Color.GREEN);
    curr1c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    curr1c2.setBounds(400, 190, 50, 50);
    curr1c2.setBackground(Color.GREEN);
    curr1c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    curr2c0.setBounds(300, 240, 50, 50);
    curr2c0.setBackground(Color.GREEN);
    curr2c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    curr2c1.setBounds(350, 240, 50, 50);
    curr2c1.setBackground(Color.GREEN);
    curr2c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    curr2c2.setBounds(400, 240, 50, 50);
    curr2c2.setBackground(Color.GREEN);
    curr2c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    f3r0c0.setBounds(30, 500, 30, 30);
    f3r0c0.setBackground(Color.ORANGE);
    f3r0c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f3r0c1.setBounds(60, 500, 30, 30);
    f3r0c1.setBackground(Color.ORANGE);
    f3r0c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f3r0c2.setBounds(90, 500, 30, 30);
    f3r0c2.setBackground(Color.ORANGE);
    f3r0c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f3r1c0.setBounds(30, 530, 30, 30);
    f3r1c0.setBackground(Color.ORANGE);
    f3r1c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f3r1c1.setBounds(60, 530, 30, 30);
    f3r1c1.setBackground(Color.ORANGE);
    f3r1c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f3r1c2.setBounds(90, 530, 30, 30);
    f3r1c2.setBackground(Color.ORANGE);
    f3r1c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f3r2c0.setBounds(30, 560, 30, 30);
    f3r2c0.setBackground(Color.ORANGE);
    f3r2c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f3r2c1.setBounds(60, 560, 30, 30);
    f3r2c1.setBackground(Color.ORANGE);
    f3r2c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f3r2c2.setBounds(90, 560, 30, 30);
    f3r2c2.setBackground(Color.ORANGE);
    f3r2c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    f0r0c0.setBounds(150, 500, 30, 30);
    f0r0c0.setBackground(Color.GREEN);
    f0r0c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f0r0c1.setBounds(180, 500, 30, 30);
    f0r0c1.setBackground(Color.GREEN);
    f0r0c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f0r0c2.setBounds(210, 500, 30, 30);
    f0r0c2.setBackground(Color.GREEN);
    f0r0c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f0r1c0.setBounds(150, 530, 30, 30);
    f0r1c0.setBackground(Color.GREEN);
    f0r1c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f0r1c1.setBounds(180, 530, 30, 30);
    f0r1c1.setBackground(Color.GREEN);
    f0r1c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f0r1c2.setBounds(210, 530, 30, 30);
    f0r1c2.setBackground(Color.GREEN);
    f0r1c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f0r2c0.setBounds(150, 560, 30, 30);
    f0r2c0.setBackground(Color.GREEN);
    f0r2c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f0r2c1.setBounds(180, 560, 30, 30);
    f0r2c1.setBackground(Color.GREEN);
    f0r2c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f0r2c2.setBounds(210, 560, 30, 30);
    f0r2c2.setBackground(Color.GREEN);
    f0r2c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    f1r0c0.setBounds(270, 500, 30, 30);
    f1r0c0.setBackground(Color.RED);
    f1r0c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f1r0c1.setBounds(300, 500, 30, 30);
    f1r0c1.setBackground(Color.RED);
    f1r0c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f1r0c2.setBounds(330, 500, 30, 30);
    f1r0c2.setBackground(Color.RED);
    f1r0c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f1r1c0.setBounds(270, 530, 30, 30);
    f1r1c0.setBackground(Color.RED);
    f1r1c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f1r1c1.setBounds(300, 530, 30, 30);
    f1r1c1.setBackground(Color.RED);
    f1r1c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f1r1c2.setBounds(330, 530, 30, 30);
    f1r1c2.setBackground(Color.RED);
    f1r1c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f1r2c0.setBounds(270, 560, 30, 30);
    f1r2c0.setBackground(Color.RED);
    f1r2c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f1r2c1.setBounds(300, 560, 30, 30);
    f1r2c1.setBackground(Color.RED);
    f1r2c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f1r2c2.setBounds(330, 560, 30, 30);
    f1r2c2.setBackground(Color.RED);
    f1r2c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    f2r0c0.setBounds(390, 500, 30, 30);
    f2r0c0.setBackground(Color.YELLOW);
    f2r0c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f2r0c1.setBounds(420, 500, 30, 30);
    f2r0c1.setBackground(Color.YELLOW);
    f2r0c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f2r0c2.setBounds(450, 500, 30, 30);
    f2r0c2.setBackground(Color.YELLOW);
    f2r0c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f2r1c0.setBounds(390, 530, 30, 30);
    f2r1c0.setBackground(Color.YELLOW);
    f2r1c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f2r1c1.setBounds(420, 530, 30, 30);
    f2r1c1.setBackground(Color.YELLOW);
    f2r1c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f2r1c2.setBounds(450, 530, 30, 30);
    f2r1c2.setBackground(Color.YELLOW);
    f2r1c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f2r2c0.setBounds(390, 560, 30, 30);
    f2r2c0.setBackground(Color.YELLOW);
    f2r2c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f2r2c1.setBounds(420, 560, 30, 30);
    f2r2c1.setBackground(Color.YELLOW);
    f2r2c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f2r2c2.setBounds(450, 560, 30, 30);
    f2r2c2.setBackground(Color.YELLOW);
    f2r2c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    f4r0c0.setBounds(150, 380, 30, 30);
    f4r0c0.setBackground(Color.WHITE);
    f4r0c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f4r0c1.setBounds(180, 380, 30, 30);
    f4r0c1.setBackground(Color.WHITE);
    f4r0c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f4r0c2.setBounds(210, 380, 30, 30);
    f4r0c2.setBackground(Color.WHITE);
    f4r0c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f4r1c0.setBounds(150, 410, 30, 30);
    f4r1c0.setBackground(Color.WHITE);
    f4r1c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f4r1c1.setBounds(180, 410, 30, 30);
    f4r1c1.setBackground(Color.WHITE);
    f4r1c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f4r1c2.setBounds(210, 410, 30, 30);
    f4r1c2.setBackground(Color.WHITE);
    f4r1c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f4r2c0.setBounds(150, 440, 30, 30);
    f4r2c0.setBackground(Color.WHITE);
    f4r2c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f4r2c1.setBounds(180, 440, 30, 30);
    f4r2c1.setBackground(Color.WHITE);
    f4r2c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f4r2c2.setBounds(210, 440, 30, 30);
    f4r2c2.setBackground(Color.WHITE);
    f4r2c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    f5r0c0.setBounds(150, 620, 30, 30);
    f5r0c0.setBackground(Color.BLUE);
    f5r0c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f5r0c1.setBounds(180, 620, 30, 30);
    f5r0c1.setBackground(Color.BLUE);
    f5r0c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f5r0c2.setBounds(210, 620, 30, 30);
    f5r0c2.setBackground(Color.BLUE);
    f5r0c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f5r1c0.setBounds(150, 650, 30, 30);
    f5r1c0.setBackground(Color.BLUE);
    f5r1c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f5r1c1.setBounds(180, 650, 30, 30);
    f5r1c1.setBackground(Color.BLUE);
    f5r1c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f5r1c2.setBounds(210, 650, 30, 30);
    f5r1c2.setBackground(Color.BLUE);
    f5r1c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f5r2c0.setBounds(150, 680, 30, 30);
    f5r2c0.setBackground(Color.BLUE);
    f5r2c0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f5r2c1.setBounds(180, 680, 30, 30);
    f5r2c1.setBackground(Color.BLUE);
    f5r2c1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    f5r2c2.setBounds(210, 680, 30, 30);
    f5r2c2.setBackground(Color.BLUE);
    f5r2c2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    rowRight = new JButton("Turn Row Right");
    rowRight.setBounds(550, 140, 150, 50);
    rowRight.setForeground(new Color(140, 138, 79));
    rowRight.setBackground(new Color(52, 63, 94));
    rowRight.setFocusable(false);
    rowRight.addActionListener(this);

    rowLeft = new JButton("Turn Row Left");
    rowLeft.setBounds(550, 240, 150, 50);
    rowLeft.setForeground(new Color(140, 138, 79));
    rowLeft.setBackground(new Color(52, 63, 94));
    rowLeft.setFocusable(false);
    rowLeft.addActionListener(this);

    colUp = new JButton("Turn Col Up");
    colUp.setBounds(50, 140, 150, 50);
    colUp.setFocusable(false);
    colUp.setForeground(new Color(140, 138, 79));
    colUp.setBackground(new Color(52, 63, 94));
    colUp.addActionListener(this);

    colDown = new JButton("Turn Col Down");
    colDown.setBounds(50, 240, 150, 50);
    colDown.setFocusable(false);
    colDown.setForeground(new Color(140, 138, 79));
    colDown.setBackground(new Color(52, 63, 94));
    colDown.addActionListener(this);

    rotateClock = new JButton("Rotate Face Right");
    rotateClock.setBounds(400, 300, 150, 50);
    rotateClock.setFocusable(false);
    rotateClock.setForeground(new Color(140, 138, 79));
    rotateClock.setBackground(new Color(52, 63, 94));
    rotateClock.addActionListener(this);

    rotateCountClock = new JButton("Rotate Face Left");
    rotateCountClock.setBounds(200, 300, 150, 50);
    rotateCountClock.setFocusable(false);
    rotateCountClock.setForeground(new Color(140, 138, 79));
    rotateCountClock.setBackground(new Color(52, 63, 94));
    rotateCountClock.addActionListener(this);

    f0Button.setBounds(525, 370, 150, 50);
    f0Button.setFocusable(false);
    f0Button.setForeground(new Color(140, 138, 79));
    f0Button.setBackground(new Color(52, 63, 94));
    f0Button.addActionListener(this);
    f0Button.setEnabled(false);

    f1Button.setBounds(525, 430, 150, 50);
    f1Button.setFocusable(false);
    f1Button.setForeground(new Color(140, 138, 79));
    f1Button.setBackground(new Color(52, 63, 94));
    f1Button.addActionListener(this);

    f2Button.setBounds(525, 490, 150, 50);
    f2Button.setFocusable(false);
    f2Button.setForeground(new Color(140, 138, 79));
    f2Button.setBackground(new Color(52, 63, 94));
    f2Button.addActionListener(this);

    f3Button.setBounds(525, 550, 150, 50);
    f3Button.setFocusable(false);
    f3Button.setForeground(new Color(140, 138, 79));
    f3Button.setBackground(new Color(52, 63, 94));
    f3Button.addActionListener(this);

    f4Button.setBounds(525, 610, 150, 50);
    f4Button.setFocusable(false);
    f4Button.setForeground(new Color(140, 138, 79));
    f4Button.setBackground(new Color(52, 63, 94));
    f4Button.addActionListener(this);

    f5Button.setBounds(525, 670, 150, 50);
    f5Button.setFocusable(false);
    f5Button.setForeground(new Color(140, 138, 79));
    f5Button.setBackground(new Color(52, 63, 94));
    f5Button.addActionListener(this);

    scramble.setBounds(300, 30, 150, 75);
    scramble.setFocusable(false);
    scramble.setForeground(new Color(140, 138, 79));
    scramble.setBackground(new Color(52, 63, 94));
    scramble.addActionListener(this);

    this.setTitle("Rubiks Cube");
    this.setIconImage(rubiksIcon.getImage());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setSize(750, 800);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.getContentPane().setBackground(Color.GRAY);
    
    this.add(col0);
    this.add(col1);
    this.add(col2);
    this.add(row0);
    this.add(row1);
    this.add(row2);
    
    this.add(rowRight);
    this.add(rowLeft);
    this.add(colUp);
    this.add(colDown);
    this.add(rotateClock);
    this.add(rotateCountClock);

    this.add(f0Button);
    this.add(f1Button);
    this.add(f2Button);
    this.add(f3Button);
    this.add(f4Button);
    this.add(f5Button);
    this.add(scramble);
    
    this.add(curr0c0);
    this.add(curr0c1);
    this.add(curr0c2);
    this.add(curr1c0);
    this.add(curr1c1);
    this.add(curr1c2);
    this.add(curr2c0);
    this.add(curr2c1);
    this.add(curr2c2);
    this.add(f0r0c0);
    this.add(f0r0c1);
    this.add(f0r0c2);
    this.add(f0r1c0);
    this.add(f0r1c1);
    this.add(f0r1c2);
    this.add(f0r2c0);
    this.add(f0r2c1);
    this.add(f0r2c2);
    this.add(f1r0c0);
    this.add(f1r0c1);
    this.add(f1r0c2);
    this.add(f1r1c0);
    this.add(f1r1c1);
    this.add(f1r1c2);
    this.add(f1r2c0);
    this.add(f1r2c1);
    this.add(f1r2c2);
    this.add(f2r0c0);
    this.add(f2r0c1);
    this.add(f2r0c2);
    this.add(f2r1c0);
    this.add(f2r1c1);
    this.add(f2r1c2);
    this.add(f2r2c0);
    this.add(f2r2c1);
    this.add(f2r2c2);
    this.add(f3r0c0);
    this.add(f3r0c1);
    this.add(f3r0c2);
    this.add(f3r1c0);
    this.add(f3r1c1);
    this.add(f3r1c2);
    this.add(f3r2c0);
    this.add(f3r2c1);
    this.add(f3r2c2);
    this.add(f4r0c0);
    this.add(f4r0c1);
    this.add(f4r0c2);
    this.add(f4r1c0);
    this.add(f4r1c1);
    this.add(f4r1c2);
    this.add(f4r2c0);
    this.add(f4r2c1);
    this.add(f4r2c2);
    this.add(f5r0c0);
    this.add(f5r0c1);
    this.add(f5r0c2);
    this.add(f5r1c0);
    this.add(f5r1c1);
    this.add(f5r1c2);
    this.add(f5r2c0);
    this.add(f5r2c1);
    this.add(f5r2c2);
    
  }

  public void actionPerformed(ActionEvent e) { 
    if(e.getSource()==f0Button){
      prevButton.setEnabled(true);
      prevButton = f0Button;
      f0Button.setEnabled(false);
      curF = 0;
      for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
          panelRet(curArr, i, j).setBackground(f0Arr[i][j].getBackground());
        }
      }
    }
    if(e.getSource()==f1Button){
      prevButton.setEnabled(true);
      prevButton = f1Button;
      f1Button.setEnabled(false);
      curF = 1;
      for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
          panelRet(curArr, i, j).setBackground(f1Arr[i][j].getBackground());
        }
      }
    }
    if(e.getSource()==f2Button){
      prevButton.setEnabled(true);
      prevButton = f2Button;
      f2Button.setEnabled(false);
      curF = 2;
      for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
          panelRet(curArr, i, j).setBackground(f2Arr[i][j].getBackground());
        }
      }
    }
    if(e.getSource()==f3Button){
      prevButton.setEnabled(true);
      prevButton = f3Button;
      f3Button.setEnabled(false);
      curF = 3;
      for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
          panelRet(curArr, i, j).setBackground(f3Arr[i][j].getBackground());
        }
      }
    }
    if(e.getSource()==f4Button){
      prevButton.setEnabled(true);
      prevButton = f4Button;
      f4Button.setEnabled(false);
      curF = 4;
      for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
          panelRet(curArr, i, j).setBackground(f4Arr[i][j].getBackground());
        }
      }
    }
    if(e.getSource()==f5Button){
      prevButton.setEnabled(true);
      prevButton = f5Button;
      f5Button.setEnabled(false);
      curF = 5;
      for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
          panelRet(curArr, i, j).setBackground(f5Arr[i][j].getBackground());
        }
      }
    }
    if(e.getSource()==col0){
      curC = 0;
    }
    if(e.getSource()==col1){
      curC = 1;
    }
    if(e.getSource()==col2){
      curC = 2;
    }
    if(e.getSource()==row0){
      curR = 0;
    }
    if(e.getSource()==row1){
      curR = 1;
    }
    if(e.getSource()==row2){
      curR = 2;
    }
    if(e.getSource()==rowRight){
      cube.turnRowRight(curR, curF, false);
      update(curArr, curF);
      update(f0Arr, 0);
      update(f1Arr, 1);
      update(f2Arr, 2);
      update(f3Arr, 3);
      update(f4Arr, 4);
      update(f5Arr, 5);
    }
    if(e.getSource()==rowLeft){
      cube.turnRowLeft(curR, curF, false);
      update(curArr, curF);
      update(f0Arr, 0);
      update(f1Arr, 1);
      update(f2Arr, 2);
      update(f3Arr, 3);
      update(f4Arr, 4);
      update(f5Arr, 5);
    }
    if(e.getSource()==colDown){
      cube.turnColFor(curC, curF, false);
      update(curArr, curF);
      update(f0Arr, 0);
      update(f1Arr, 1);
      update(f2Arr, 2);
      update(f3Arr, 3);
      update(f4Arr, 4);
      update(f5Arr, 5);
    }
    if(e.getSource()==colUp){
      cube.turnColBack(curC, curF, false);
      update(curArr, curF);
      update(f0Arr, 0);
      update(f1Arr, 1);
      update(f2Arr, 2);
      update(f3Arr, 3);
      update(f4Arr, 4);
      update(f5Arr, 5);
    }
    if(e.getSource()==rotateClock){
      cube.rotateFaceClock(curF, false);
      update(curArr, curF);
      update(f0Arr, 0);
      update(f1Arr, 1);
      update(f2Arr, 2);
      update(f3Arr, 3);
      update(f4Arr, 4);
      update(f5Arr, 5);
    }
    if(e.getSource()==rotateCountClock){
      cube.rotateFaceCounterClock(curF, false);
      update(curArr, curF);
      update(f0Arr, 0);
      update(f1Arr, 1);
      update(f2Arr, 2);
      update(f3Arr, 3);
      update(f4Arr, 4);
      update(f5Arr, 5);
    }
    if(e.getSource()==scramble){
      cube.scramble();
      update(curArr, curF);
      update(f0Arr, 0);
      update(f1Arr, 1);
      update(f2Arr, 2);
      update(f3Arr, 3);
      update(f4Arr, 4);
      update(f5Arr, 5);
    }
  }

  public void update(JPanel[][] panelFace, int cubeFace){
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        panelRet(panelFace, i, j).setBackground(cube.retColor(cubeFace, i, j));
      }
    }
  }

  public JPanel panelRet(JPanel[][] ret, int i, int j){
    return ret[i][j];
  }
}


