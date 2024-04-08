import java.util.Scanner;

public class TicToeTocGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];

        boolean playAgain;
        do {
            initializeBoard(board);
            char currentPlayer = 'X';
            boolean gameWon = false;
            boolean boardFull = false;

            while (!gameWon && !boardFull) {
                displayBoard(board);
                System.out.println("Player " + currentPlayer + "'s turn.");
                int[] move = getPlayerMove(scanner);
                int row = move[0];
                int col = move[1];

                // Check if the move is valid
                if (board[row][col] == '\u0000') {
                    board[row][col] = currentPlayer;
                    gameWon = checkWin(board, currentPlayer);
                    boardFull = isBoardFull(board);
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                } else {
                    System.out.println("That position is already taken. Try again.");
                }
            }

            displayBoard(board);
            if (gameWon) {
                System.out.println("Player " + currentPlayer + " wins!");
            } else {
                System.out.println("It's a draw!");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '\u0000';
            }
        }
    }

    public static void displayBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] getPlayerMove(Scanner scanner) {
        int[] move = new int[2];
        System.out.print("Enter row (0-2): ");
        move[0] = scanner.nextInt();
        System.out.print("Enter column (0-2): ");
        move[1] = scanner.nextInt();
        return move;
    }

    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }
}
