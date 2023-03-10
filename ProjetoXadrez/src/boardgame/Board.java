package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) throw new BoardException("ERROR: There must be at least one column and one row");
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) throw new BoardException("ERROR: This position is outside the board boundaries.");
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!positionExists(position)) throw new BoardException("ERROR: This position is outside the board boundaries.");
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)) throw  new BoardException("There is already a piece on position on " + position);
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position) {
        if (!positionExists(position)) throw new BoardException("ERROR: Position does not exist");
        if (piece(position) == null) return null;

        Piece tmpPiece = piece(position);
        tmpPiece.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return tmpPiece;
    }

    public boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) throw new BoardException("ERROR: This position is outside the board boundaries.");
        return piece(position) != null;
    }
}
