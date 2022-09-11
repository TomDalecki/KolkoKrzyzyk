import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class KolkoKrzyzyk implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] button = new JButton[9];
    boolean player1Turn;
    boolean winnerExists = false;

    KolkoKrzyzyk(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.ITALIC, 95));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Kółko i Krzyżyk");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0, 800, 100);

        buttonsPanel.setLayout(new GridLayout(3, 3));
        buttonsPanel.setBackground(new Color(150, 150, 150));

        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonsPanel);

        for (int i = 0; i<9; i++){
            button[i] = new JButton();
            buttonsPanel.add(button[i]);
            button[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            button[i].setFocusable(false);
            button[i].addActionListener(this);}

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!winnerExists){
            for(int i=0; i<9; i++){
                if(e.getSource()==button[i]){
                    if (player1Turn){
                        if(button[i].getText()==""){
                            button[i].setForeground(new Color(255,0,0));
                            button[i].setText("X");
                            player1Turn = false;
                            textField.setText("O turn");}}
                    else{
                        if(button[i].getText()==""){
                            button[i].setForeground(new Color(0,0,255));
                            button[i].setText("O");
                            player1Turn = true;
                            textField.setText("X turn");}
                    }
                }
                xWins();
                oWins();}
        }}

    public void firstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(random.nextInt(2)==1){
            player1Turn = true;
            textField.setText("X turn");}
        else{
            player1Turn = false;
            textField.setText("O turn");}
    }

    public void xWins(){ //Dla xWins wersja długa kodu

        int ii = 0;
        for (int i=0; i<3; i++){
            //System.out.println(ii);
            if(button[i].getText().equals("X")){ii++;}
            if (ii==3){
                char symbol = 'X';
                winMsg(symbol);}
        }

        ii = 0;
        for (int i=3; i<6; i++){
            if(button[i].getText().equals("X")){ii++;}
            if (ii==3){
                char symbol = 'X';
                winMsg(symbol);}
        }

        ii = 0;
        for (int i=6; i<9; i++){
            if(button[i].getText().equals("X")){ii++;}
            if (ii==3){
                char symbol = 'X';
                winMsg(symbol);}
        }

        ii = 0;
        for (int i=0; i<7; i=i+3){
            if(button[i].getText().equals("X")){ii++;}
            if (ii==3){
                char symbol = 'X';
                winMsg(symbol);}
        }

        ii = 0;
        for (int i=1; i<8; i=i+3){
            if(button[i].getText().equals("X")){ii++;}
            if (ii==3){
                char symbol = 'X';
                winMsg(symbol);}
        }

        ii = 0;
        for (int i=2; i<9; i=i+3){
            if(button[i].getText().equals("X")){ii++;}
            if (ii==3){
                char symbol = 'X';
                winMsg(symbol);}
        }

        ii = 0;
        for (int i=0; i<9; i=i+4){
            if(button[i].getText().equals("X")){ii++;}
            if (ii==3){
                char symbol = 'X';
                winMsg(symbol);}
        }

        ii = 0;
        for (int i=2; i<7; i=i+2){
            if(button[i].getText().equals("X")){ii++;}
            if (ii==3){
                char symbol = 'X';
                winMsg(symbol);}
        }
    }

    public void oWins(){ // Dla oWins wersja zoptymalizowana kodu
        int [][] winComb = {
                {0,3,1},
                {3,6,1},
                {6,9,1},
                {0,7,3},
                {1,8,3},
                {2,9,3},
                {0,9,4},
                {2,7,2}};

        for (int i =0; i<winComb.length; i++) {
            int ii = 0;
            for (int x = winComb[i][0]; x < winComb[i][1]; x = x + winComb[i][2]) {
                if (button[x].getText().equals("O")) {
                    ii++;
                }
                if (ii == 3) {
                    char symbol = 'O';
                    winMsg(symbol);
                }
            }
        }
    }

    public void winMsg (char symbol){
        if (symbol == 'X'){
            textField.setText("X WINS!!!!");
        }
        else{
            textField.setText("O WINS!!!!");
        }
        winnerExists = true;
    }

}



