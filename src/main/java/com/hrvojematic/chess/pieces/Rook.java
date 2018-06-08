package com.hrvojematic.chess.pieces;

import com.hrvojematic.chess.game.Board;
import com.hrvojematic.chess.game.Player;
import com.hrvojematic.chess.game.Position;

public class Rook extends Piece {

	public Rook(Player owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Position start, Position dest, Board board) {
		if(start==dest) return false;
		if(board.getPiece(dest)!=null && board.getPiece(dest).getOwner()==this.getOwner()) {
			return false;
		}
		return PathTrace.traceLinearPath(start, dest, board);
	}

	@Override
	public String getPieceSymbol() {
		return "R";
	}

}
