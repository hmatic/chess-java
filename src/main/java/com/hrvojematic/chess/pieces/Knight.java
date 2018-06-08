package com.hrvojematic.chess.pieces;

import com.hrvojematic.chess.game.Board;
import com.hrvojematic.chess.game.Position;

public class Knight extends Piece {

	@Override
	public boolean isValidMove(Position start, Position dest, Board board) {
		if(start==dest) return false;
		if(board.getPiece(dest)!=null && board.getPiece(dest).getOwner()==this.getOwner()) {
			return false;
		}
		if (start.getX() - 2 == dest.getX() || start.getX() + 2 == dest.getX()) {
            if (start.getY() - 1 == dest.getY() || start.getY() + 1 == dest.getY()) {
                return true;
            }
        } else if (start.getX() - 1 == dest.getX() || start.getX() + 1 == dest.getX()) {
            if (start.getY() - 2 == dest.getY() || start.getY() + 2 == dest.getY()) {
                return true;
            }
        }
		return false;
	}

}
