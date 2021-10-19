package tictactoe;

import java.util.Scanner;

public class Main {

    static int row;
    static int column;
    static char[][] board = new char[3][3];
    static char turnX = 'X';
    static char turnO = 'O';
    static byte counter;

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        printBoard();
        play();
    }

    public static boolean xWins(char[][] board) {
        if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') {
            return true;
        }
        if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') {
            return true;
        }
        if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') {
            return true;
        }
        if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') {
            return true;
        }
        if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') {
            return true;
        }
        if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') {
            return true;
        }
        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
            return true;
        }
        if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean oWins(char[][] board) {
        if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') {
            return true;
        }
        if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') {
            return true;
        }
        if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') {
            return true;
        }
        if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') {
            return true;
        }
        if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') {
            return true;
        }
        if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') {
            return true;
        }
        if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
            return true;
        }
        if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean notFinished(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return true;
                }
            }

        }
        return false;
    }
    public static void printBoard() {
        System.out.println("---------");
        System.out.println("| " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " |");
        System.out.println("| " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " |");
        System.out.println("| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |");
        System.out.println("---------");
    }
    public static void play() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.print("Enter the coordinates: ");
            try {
                String v1 = scanner.next();
                row = Integer.parseInt(v1);
                String v2 = scanner.next();
                column = Integer.parseInt(v2);
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
                continue;
            }
            if (row < 1 || row > 3 || column < 1 || column > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (board[row - 1][column - 1] == 'X' || board[row - 1][column - 1] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                flag = false;
            }
        }
        counter++;
        if (counter % 2 != 0) {
            board[row - 1][column - 1] = turnX;
        } else {
            board[row - 1][column - 1] = turnO;
        }
        printBoard();

        if (!xWins(board) && !oWins(board) && notFinished(board)) {
            play();
        } else if (!xWins(board) && !oWins(board) && !notFinished(board)) {
            System.out.println("Draw");
        } else if (xWins(board)){
            System.out.println("X wins");
        } else if (oWins(board)) {
            System.out.println("O wins");
        }
    }
}
