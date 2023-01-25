package chess;

import boardgame.Board;
import boardgame.Piece;

public abstract class ChessPiece extends Piece {
    private Color color;
    private Board board;


    public ChessPiece(Board board, Color color) {
        super(board);
        this.board = board;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract boolean[][] possibleMoves();
}
