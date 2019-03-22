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
class Model {

    int matrixs[] = new int[9];
    int numberOfFillBox = 1;

    public void setClick(int position, int XorO) {
        matrixs[position] = XorO;
        numberOfFillBox++; // INCREMENT GAME TURNS

    }

    //RESET ARRAY AND THE NUMBER OF TURNS COUNT
    public void resetGame() {
        numberOfFillBox = 0;
        for (int z = 0; z < 9; z++) {
            matrixs[z] = 0;
        }
        
        
    }


    public int checkResult() {
    

        if (matrixs[0] == 1 && matrixs[1] == 1 && matrixs[2] == 1) {
            return 1; 
        }
        if (matrixs[0] == 2 && matrixs[1] == 2 && matrixs[2] == 2) {
            return 2;
        }
        if (matrixs[3] == 1 && matrixs[4] == 1 && matrixs[5] == 1) {
            return 1; 
        }
        if (matrixs[3] == 2 && matrixs[4] == 2 && matrixs[5] == 2) {
            return 2; 
        }
        if (matrixs[6] == 1 && matrixs[7] == 1 && matrixs[8] == 1) {
            return 1;
        }
        if (matrixs[6] == 2 && matrixs[7] == 2 && matrixs[8] == 2) {
            return 2; 
        }

        // VERT TEST
        if (matrixs[0] == 1 && matrixs[3] == 1 && matrixs[6] == 1) {
            return 1;  
        }
        if (matrixs[0] == 2 && matrixs[3] == 2 && matrixs[6] == 2) {
            return 2;
        }
        if (matrixs[1] == 1 && matrixs[4] == 1 && matrixs[7] == 1) {
            return 1;
        }
        if (matrixs[1] == 2 && matrixs[4] == 2 && matrixs[7] == 2) {
            return 2;
        }
        if (matrixs[2] == 1 && matrixs[5] == 1 && matrixs[8] == 1) {
            return 1;
        }
        if (matrixs[2] == 2 && matrixs[5] == 2 && matrixs[8] == 2) {
            return 2;
        }
        //DIAGONAL TEST

        if (matrixs[0] == 1 && matrixs[4] == 1 && matrixs[8] == 1) {
            return 1;
        }
        if (matrixs[0] == 2 && matrixs[4] == 2 && matrixs[8] == 2) {
            return 2;
        }
        if (matrixs[2] == 1 && matrixs[4] == 1 && matrixs[6] == 1) {
            return 1;
        }
        if (matrixs[2] == 2 && matrixs[4] == 2 && matrixs[6] == 2) {
            return 2; 
        }
        if (numberOfFillBox == 9) {
            return 3; //NO ONE WINS THIS GAME
        }
        return 0; // NOBODY HAS WON YET
    }
}
