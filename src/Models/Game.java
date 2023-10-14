package Models;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Exception.InvalidGameConsructionException;
import Strategies.OrderNWinningStrategies;
import Strategies.WinningStrategies;

public class Game {
    private List<Player>players;
    private Board board;
    private GameStatus gameStatus;
    private int currentPlayerIndex;
    private List<Move>moves;
    private WinningStrategies strategy;
    
    public  Game(Gamebuilder gamebuilder)
    {
        this.players=gamebuilder.players;
        this.board=gamebuilder.board;
        this.gameStatus=gamebuilder.gameStatus;
        this.currentPlayerIndex=gamebuilder.currentPlayerIndex;
        this.moves=gamebuilder.moves;
        this.strategy=new OrderNWinningStrategies();
    }

    

    public List<Player> getPlayers() {
        return players;
    }



    public Board getBoard() {
        return board;
    }



    public GameStatus getGameStatus() {
        return gameStatus;
    }



    // public int getCurrentPlayerIndex() {
    //     return currentPlayerIndex;
    // }

    public Player getCurrentPlayer()
    {
        return this.players.get(currentPlayerIndex);
    }


    public List<Move> getMoves() {
        return moves;
    }



    public WinningStrategies getStrategy() {
        return strategy;
    }

            public void makemove()
            {
                Player curPlayer=getCurrentPlayer();
                Move move = curPlayer.makMove(getBoard());
                moves.add(move);

                System.out.println("Do you want to undo");
                Scanner sc=new Scanner(System.in);
                char option=sc.next().charAt(0);
                if(option=='y' || option=='Y'){
                    undo();
                    return;
                }
                
                boolean playerHasWon=this.strategy.checkifWon(this.board, move);
                if(playerHasWon)
                {
                    gameStatus=GameStatus.ENDED;
                    return;
                }

                int size=board.getCells().size();
                if(moves.size()==size*size)
                {
                    gameStatus=GameStatus.DRAW;
                    return;
                }

                this.currentPlayerIndex++;
                this.currentPlayerIndex %=players.size();
            }

            public void undo()
            {
                Move lastMove=moves.remove(moves.size()-1);
                Cell cell = lastMove.getCell();
                cell.removePlayer();
            }


    public static Gamebuilder getGamebuilder()
    {
        return new Gamebuilder();
    }

    public static class Gamebuilder
    {
         private List<Player>players;
    private Board board;
    private GameStatus gameStatus;
    private int currentPlayerIndex;
    private List<Move>moves;
    private WinningStrategies strategy;

    public Gamebuilder setPlayers(List<Player> players) {
        this.players = players;
        return this;
    }
    public Gamebuilder setBoard(Board board) {
        this.board = board;
        return this;
    }
    public Gamebuilder setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
        return this;
    }
    public Gamebuilder setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
        return this;
    }
    public Gamebuilder setMoves(List<Move> moves) {
        this.moves = moves;
        return this;
    }
    // public Gamebuilder setStrategy(WinningStrategies strategy) {
    //     this.strategy = strategy;
    //     return this;
    // }



        public Game build() throws InvalidGameConsructionException        {
            if(this.players.size()<=1 || this.players==null)
            {
                throw new InvalidGameConsructionException("At least 2 player required");
            }
            Collections.shuffle(players);
            this.board =new Board(this.players.size()+1);
            return new Game(this);
        }
    

    }
}
