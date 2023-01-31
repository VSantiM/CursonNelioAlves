package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Color color;
    private Board board;
    private int moveCount;


    public ChessPiece(Board board, Color color) {
        super(board);
        this.board = board;
        this.color = color;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(this.position);
    }

    public Color getColor() {
        return color;
    }

    public void increaseMoveCount() { this.moveCount++; }
    public void decreaseMoveCount() { this.moveCount--; }

    public int getMoveCount() {
        return moveCount;
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != this.getColor();
    }
}
