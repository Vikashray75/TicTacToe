
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Controllers.GameConrollers;
import Exception.InvalidGameConsructionException;
import Models.Board;
import Models.Game;
import Models.GameStatus;
import Models.Player;

public class App {
   private static GameConrollers gameConrollers=new GameConrollers();
    public static void main(String[] args) throws Exception {
       System.out.println("How many players are going to play");
       Scanner scanner=new Scanner(System.in);
       int numberOfPlayer=scanner.nextInt();
       if(numberOfPlayer<=1){
        throw new InvalidGameConsructionException("player should be greater then 1");
       }
       System.out.println(numberOfPlayer+" :players are playing");
       List<Player>players=new ArrayList<>();
        for (int i = 0; i < numberOfPlayer; i++) {
            System.out.println("Give player "+ (i+1) +" name");
            String Name=scanner.next();
            System.out.println("Give Player"+ (i+1) +" Symbol");
            char Symbol=scanner.next().charAt(0);
            players.add(new Player(Name, Symbol));
        }

    Game game;
    try {
        game=gameConrollers.createGame(players);
    } catch (Exception e) {
        System.out.println("Error while creaing game"+ e.getMessage());
        return;
    }

            while(gameConrollers.getGameStatus(game).equals(GameStatus.INPROGRESS))
            {
                gameConrollers.displayBoard(game);
                gameConrollers.makeMove(game);
            }

            if(gameConrollers.getGameStatus(game).equals(GameStatus.ENDED))
            {
                Player winnerPlaer=game.getCurrentPlayer();
                System.out.println(winnerPlaer.getName()+" has won");

            }
            else if(gameConrollers.getGameStatus(game).equals(GameStatus.DRAW))
            {
                System.out.println("Game is Drawn");
            }

            gameConrollers.displayBoard(game);

        
    }
}
