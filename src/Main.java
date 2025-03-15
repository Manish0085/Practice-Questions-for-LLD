import TicTacToe.StartGame;

public class Main {
    public static void main(String[] args) {

        StartGame game = new StartGame();
        String str = game.startGame();
        if(str.equalsIgnoreCase("tie")){
            System.out.println("The game has been tie");
            return;
        }
        System.out.println(str+" is the winner");
    }
}