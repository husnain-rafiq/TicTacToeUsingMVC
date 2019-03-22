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
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;

class View extends JFrame {
    // DEFINE BUTTONS AND GRID

    private static View firstInstance = null;
    protected JButton button[];
    protected GridLayout grid;

    protected View() {
        super("Tic Tac Toe Game");
        button = new JButton[12];
        grid = new GridLayout(4, 3, 5, 5);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 550);
        setLayout(grid);

        //BUILD BUTTONS
        for (int loop = 0; loop < 12; loop++) {
            button[loop] = new JButton();

            if (loop < 9) {
                button[loop].setBackground(Color.gray);
            } else {
                button[loop].setBackground(Color.ORANGE);
            }

            add(button[loop]);
        }
        setVisible(true);
    }

    // RESET TO GUI
    public void resetGame() {
        for (int z = 0; z < 9; z++) {
            button[z].setText("");
        }
    }

    //USE THE SINGLETON DESIGN PATTERN
    public static View getInstace() {
        if (firstInstance == null) {
            firstInstance = new View();
        }

        return firstInstance;
    }
}
