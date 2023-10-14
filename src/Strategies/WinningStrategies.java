package Strategies;

import Models.Board;
import Models.Move;

public interface WinningStrategies {
    public boolean checkifWon(Board board,Move move);
}
