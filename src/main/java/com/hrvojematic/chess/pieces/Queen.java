package com.hrvojematic.chess.pieces;

import com.hrvojematic.chess.game.Board;
import com.hrvojematic.chess.game.Position;

public class Queen extends Piece {

	@Override
	public boolean isValidMove(Position start, Position dest, Board board) {
		int startX = start.getX();
		int startY = start.getY();
		int destX = dest.getX();
		int destY = dest.getY();
		
		if(start==dest) return false;
		if(board.getPiece(dest)!=null && board.getPiece(dest).getOwner()==this.getOwner()) {
			return false;
		} else if(startX==destX || startY==destY) {
			return PathTrace.traceLinearPath(start, dest, board);
		} else if(Math.abs(startX-destX)==Math.abs(startY-destY)) {
			return PathTrace.traceDiagonalPath(start, dest, board);
		}
		return false;
	}

}
