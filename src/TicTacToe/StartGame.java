package TicTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StartGame {
    Scanner sc = new Scanner(System.in);
    public Deque<Player> players;
    public Board gameBoard;

    public StartGame(){
        initializeGame();
    }
    private String getPlayerName(){
        System.out.print("Enter player name ");
        return sc.nextLine();
    }
    public void initializeGame(){
        players = new LinkedList<>();
        PlayingSymbol symbol1 = new PlayingSymbolX();
        Player player1 = new Player(getPlayerName(), symbol1);

        PlayingSymbol symbol2 = new PlayingSymbolO();
        Player player2 = new Player(getPlayerName(), symbol2);

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;

        while (noWinner){
            Player playerTurn = players.removeFirst();

            gameBoard.printBoard();
            List<Pair<Integer, Integer>> freeCells = gameBoard.getFreeCells();
            if(freeCells.isEmpty()){
                noWinner = false;
                continue;
            }

            System.out.print("Player "+playerTurn.getName()+": Enter raw and column ");
            String input = sc.nextLine();
            String[] values = input.split(",");
            int inputRaw = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            boolean symbolAddedSuccessfully = gameBoard.addSymbol(inputRaw, inputColumn, playerTurn.symbol);
            if (!symbolAddedSuccessfully){
                System.out.println("Incorrect position, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isWinner(inputRaw, inputColumn, playerTurn.symbol.symbol);
            if (winner){
                gameBoard.printBoard();
                return playerTurn.getName();
            }

        }
        gameBoard.printBoard();
        return "tie";
    }

    private boolean isWinner(int row, int column, Symbol piece){
        boolean rawMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for (int i = 0; i < gameBoard.size; i++) {
            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].symbol != piece){
                rawMatch = false;
            }
        }

        for (int i = 0; i < gameBoard.size; i++) {
            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].symbol != piece){
                columnMatch = false;
            }
        }

        for (int i = 0, j = 0; i < gameBoard.size; i++, j++) {
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].symbol != piece){
                diagonalMatch = false;
            }
        }

        for (int i = 0, j = gameBoard.size-1; i < gameBoard.size; i++, j--) {
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].symbol != piece){
                antiDiagonalMatch = false;
            }
        }
        return rawMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
