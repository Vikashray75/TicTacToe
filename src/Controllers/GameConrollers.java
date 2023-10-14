package Controllers;

import java.util.ArrayList;
import java.util.List;

import Exception.InvalidGameConsructionException;
import Models.Game;
import Models.GameStatus;
import Models.Player;

public class GameConrollers {
    
    public Game createGame(List<Player>players) throws InvalidGameConsructionException
    {
        Game game=Game.getGamebuilder()
                    .setPlayers(players)
                    .setGameStatus(GameStatus.INPROGRESS)
                    .setMoves(new ArrayList<>())
                    .setCurrentPlayerIndex(0)
                    .build();

                    return game;
    }

    public void makeMove(Game game)
    {
        game.makemove();
    }

    public GameStatus getGameStatus(Game game)
    {
        return game.getGameStatus();
    }

    public void displayBoard(Game game)
    {
        game.getBoard().displayBoard();
    }
}
