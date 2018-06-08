package com.hrvojematic.chess.pieces;

import com.hrvojematic.chess.game.Board;
import com.hrvojematic.chess.game.Position;

public class PathTrace {
	public static boolean traceLinearPath(Position start, Position dest, Board board) {
		int startX = start.getX();
		int startY = start.getY();
		int destX = dest.getX();
		int destY = dest.getY();
		
        if(startX == destX){
            if(startY < destY) {
                for(int i = startY+1; i < destY; i++){
                    if(board.containsPiece(Position.get(startX, i))) return false;
                }
                return true;
            } else if(startY > destY) {
                for(int i = startY-1; i > destY; i--){
                    if(board.containsPiece(Position.get(startX, i))) return false;
                }
                return true;
            } else {
            	return false;
            }
        } else if(startY == destY){
            if(startX < destX) {
                for(int i = startX+1; i < destX; i++){
                    if(board.containsPiece(Position.get(i, startY))) return false;
                }
                return true;
            }
            else if(startX > destX) {
                for(int i = startX-1; i > destX; i--){
                    if(board.containsPiece(Position.get(i, startY))) return false;
                }
                return true;
            } else {
            	return false;
            }
        }
        return false;
    }
	
	public static boolean traceDiagonalPath(Position start, Position dest, Board board) {
		int startX = start.getX();
		int startY = start.getY();
		int destX = dest.getX();
		int destY = dest.getY();
		int distanceX = Math.abs(startX-destX);
		int distanceY = Math.abs(startY-destY);
		
		if(distanceX != distanceY) return false;
		if (destX > startX && destY > startY) {
            for (int i = 1; i < distanceX; i++) {
                if (board.containsPiece(Position.get(startX+i,startY+i))) return false;
            }
            return true;
        } else if (destX < startX && destY > startY) {
            for (int i = 1; i < distanceX; i++) {
                if (board.containsPiece(Position.get(startX-i,startY+i))) return false;
            }
            return true;
        } else if (destX < startX && destY < startY) {
            for (int i = 1; i < distanceX; i++) {
                if (board.containsPiece(Position.get(startX-i,startY-i))) return false;
            }
            return true;
        } else if (destX > startX && destY < startY) {
            for (int i = 1; i < distanceX; i++) {
                if (board.containsPiece(Position.get(startX+i,startY-i))) return false;
            }
            return true;
        }
        return false;
	}

}
