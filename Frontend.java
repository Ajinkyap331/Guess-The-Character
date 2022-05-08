package gtc.FRONTEND;
import gtc.CALCULATE.Calculate;
import gtc.DATABASE.Data;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.net.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Frontend extends JFrame{

    JButton StartButton;
    JFrame INTRO;
    JFrame QUESTIONS;
    JFrame ENDING;
    JFrame LOADING;
    JLabel label;
    int x = (int) (Math.random()*5);
    Calculate c = new Calculate();

    public void Loading(){
        LOADING = new JFrame("Loading");
        JLabel label1 = new JLabel();
		label1.setText("Loading...");
		label1.setBounds(50, 35, 300, 50);
		label1.setFont(new Font("Verdana", Font.ITALIC, 25));
		label1.setForeground(Color.WHITE);

        LOADING.add(label1);
        LOADING.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LOADING.getContentPane().setBackground(Color.BLACK);
	    LOADING.setLayout(null);
	    LOADING.setSize(650,700);
	    LOADING.setResizable(false);
	    LOADING.setVisible(true);

    }

    public void EndingPage(int index){
		ENDING = new JFrame("Guess the character");
		
		JLabel label1 = new JLabel();
		label1.setText("I am Thinking of ");
		label1.setBounds(50, 35, 300, 50);
		label1.setFont(new Font("Verdana", Font.ITALIC, 25));
		label1.setForeground(Color.WHITE);
		
        JLabel label2 = new JLabel();
        try{
            Loading();
            String path = Data.Link[index];
            URL url = new URL(path);
            BufferedImage image = ImageIO.read(url);
            ImageIcon imageIcon = new ImageIcon(image);
            Image image1 = imageIcon.getImage();
            Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH);
            label2 = new JLabel(new ImageIcon(newimg));
            label2.setBounds(0,115,650,366);
            LOADING.setVisible(false);
            label2.setVisible(true);
        }
        catch(Exception e){
            System.out.println("Error");
        } 
       
		
		
		
		String name = Data.Name[index];
		JLabel label3 = new JLabel(("<html><body><h4 class = \"Answer\" id = \"Answer\"><h1> "+ name +" </h1></body></html>"));
		label3.setFont(new Font("Verdana", Font.ITALIC, 25));
		label3.setBounds(350, 470, 300, 100);
		label3.setBackground(Color.WHITE);
		label3.setForeground(Color.RED);
		label3.setVisible(true);
		
		
		
		ENDING.add(label1);
		ENDING.add(label2);
		ENDING.add(label3);
		ENDING.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ENDING.getContentPane().setBackground(Color.BLACK);
	    ENDING.setLayout(null);
	    ENDING.setSize(650,700);
	    ENDING.setResizable(false);
	    ENDING.setVisible(true);
	}

    public void QuestionPage(String s) {
        QUESTIONS = new JFrame("Guess the character");
 
        JLabel L = new JLabel(("<html><body><h2 class = \"Question\" id = \"Question\"> " + s));
         L.setFont(new Font("Verdana", Font.ITALIC, 100));
         L.setBounds(50,375,500,150);
         L.setForeground(Color.WHITE);
 
         JButton Yes = new JButton("Yes");
         Yes.setBounds(20,560,125,30);
         Yes.setBackground(new Color(0x3d8c40));
         Yes.setForeground(Color.WHITE);
         Yes.setBorderPainted(true);
         Yes.setOpaque(true);
         Yes.setFont(new Font("Verdana", Font.ITALIC, 18));
         Yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QUESTIONS.setVisible(false);
                int fi = c.categorizeInput(x,1);
                if(fi != -1)
                    EndingPage(fi);
                else{
                    x = (int) (Math.random()*5);
                    QuestionPage(Data.start[Data.Starting[x]] + " your character " + Data.Q[x]);
                }
                
            }
        });
         
         JButton Probably=new JButton("Probably");
         Probably.setBounds(165,560,125,30);
         Probably.setBackground(new Color(0xffff00));
         Probably.setForeground(Color.BLACK);
         Probably.setBorderPainted(true);
         Probably.setOpaque(true);
         Probably.setFont(new Font("Verdana", Font.ITALIC, 18));
         
         JButton No=new JButton("No");
         No.setBounds(315,560,125,30);
         No.setBackground(new Color(0x2a9df4));
         No.setForeground(Color.WHITE);
         No.setBorderPainted(true);
         No.setOpaque(true);
         No.setFont(new Font("Verdana", Font.ITALIC, 18));
         No.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QUESTIONS.setVisible(false);
                int fi = c.categorizeInput(x,0);
                if(fi != -1)
                    EndingPage(fi);
                else{
                    x = (int) (Math.random()*5);
                    QuestionPage(Data.Q[x]);
                }

            }
        });
         
         JButton dont=new JButton("Dont't know");
         dont.setBounds(460,560,150,30);
         dont.setBackground(new Color(0xff595e));
         dont.setForeground(Color.WHITE);
         dont.setBorderPainted(true);
         dont.setOpaque(true);
         dont.setFont(new Font("Verdana", Font.ITALIC, 18));
 
 
         QUESTIONS.add(L);
         QUESTIONS.add(Yes);
         QUESTIONS.add(No);
         QUESTIONS.add(dont);
         QUESTIONS.add(Probably);
         QUESTIONS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         QUESTIONS.getContentPane().setBackground(Color.BLACK);
         QUESTIONS.setLayout(null);
         QUESTIONS.setSize(650,700);
         QUESTIONS.setResizable(false);
         QUESTIONS.setVisible(true);
     }

  

    public void IntroPage() {
        INTRO = new JFrame("Guess the character");

        ImageIcon image = new ImageIcon("./Images/start.jpg");
        label = new JLabel();
        label.setIcon(image);
        label.setBounds(150, 30, 300, 300);
        label.setVisible(true);

        // for start StartButton
        StartButton = new JButton("Start");
        StartButton.setBounds(400, 550, 150, 30);
        StartButton.setBackground(Color.cyan);
        StartButton.setBorderPainted(true);
        StartButton.setOpaque(true);
        StartButton.setFont(new Font("Verdana", Font.ITALIC, 18));
        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                INTRO.setVisible(false);
                QuestionPage(Data.start[Data.Starting[x]] + " your character " + Data.Q[x]);
            }
        });

        // for intro text
        JLabel L = new JLabel(
                ("<html><body>Hi I am Viru sahastra bhudhi<br>I can read your mind<br>Answer simple questions in YES or NO <br>I will guess the character you are thinking of<br><br>Give it a try!!!!!!</body></html>"));
        L.setFont(new Font("Verdana", Font.ITALIC, 18));
        L.setBounds(85, 350, 400, 175);
        L.setForeground(Color.RED);
        INTRO.add(L);

        // for INTRO Don't touch this code
        INTRO.add(StartButton);
        INTRO.add(label);
        INTRO.getContentPane().setBackground(Color.BLACK);
        INTRO.setLayout(null);
        INTRO.setSize(650, 700);
        INTRO.setResizable(false);
        INTRO.setVisible(true);
    }

    
}