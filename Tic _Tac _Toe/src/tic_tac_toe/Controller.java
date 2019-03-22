/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic_tac_toe;

/**
 *
 * @author HUSNAIN
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

class Controller extends View implements ActionListener {

    private Model model = new Model();
    private int gameResult = 0;
    private boolean whosTurn = false; // SET PLAYER O TO GO FIRST
    private StringBuilder sb=new StringBuilder("PLAYER 1");

    public Controller() {

        //ADD ACTIONLISTER TO BUTTONS FROM VIEW CLASS
        for (int x = 0; x < 9; x++) {
            super.button[x].addActionListener(this);
        }

        super.button[9].setText("PLAYER 1 TURN");
    }

    public void askForPlayAgain() {
        int reply = JOptionPane.showConfirmDialog(null, "PLAY AGAIN ?", "TIC TAC TOE", JOptionPane.YES_NO_OPTION);

        if (reply == JOptionPane.YES_OPTION) {
            model.resetGame();
            super.button[9].setText("PLAYER 1 TURN");
            StringBuilder sb1=new StringBuilder();
            
            
            sb=sb1; 
            sb.insert(0,"PLAYER 1"); 
            super.button[10].setText("");
            super.button[11].setText("");
            
            
            super.resetGame();
        } else {
            dispose();
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object objClicked = event.getSource();

        for (int x = 0; x < 9; x++) {
            if (objClicked == super.button[x]) {
                if ("".equals(super.button[x].getText())) {
                    if (whosTurn == false) {

                        super.button[x].setText("X");
                        model.setClick(x, 1);

                        
                        whosTurn = true;  // CHANGE TO NEXT PLAYER
                        super.button[9].setText("PLAYER 2 TURN");
                        sb.replace(0,9,"PLAYER 1");

                        gameResult = model.checkResult();

                    } else {
                        super.button[x].setText("O");
                        model.setClick(x, 2);
                        whosTurn = false; // CHANGE TO NEXT PLAYER 
                        super.button[9].setText("PLAYER 1 TURN");
                        sb.replace(0,9,"PLAYER 2");

                        gameResult = model.checkResult();
                    }
                }
            }
        }
        
        if (gameResult == 3) {
            super.button[10].setText("RESULT: NO ONE WIN");
        }
        
        if(gameResult == 1 || gameResult == 2){
            
            super.button[9].setText("");
            super.button[11].setText("CONGRATULATIONS");
            sb.append(" WIN");
            super.button[10].setText(sb.toString());
        }
        if (gameResult != 0) {
            askForPlayAgain();
        }

    }
}
