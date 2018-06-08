package com.hrvojematic.chess.pieces;

import com.hrvojematic.chess.game.Board;
import com.hrvojematic.chess.game.Position;

public class King extends Piece {

	@Override
	public boolean isValidMove(Position start, Position dest, Board board) {
		if(start==dest) return false;
		if(board.getPiece(dest)!=null && board.getPiece(dest).getOwner()==this.getOwner()) {
			return false;
		}
		
		int distanceX = Math.abs(start.getX()-dest.getX());
		int distanceY = Math.abs(start.getY()-dest.getY());
		if(distanceX<=1 && distanceY<=1) return true;
		
		return false;
	}

}
