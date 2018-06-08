package com.hrvojematic.chess.game;

public class Player {
	private String name;
	private int win;
	private int loss;
	private int draw;
	
	public boolean isInCheck(Board board) {
		Position kingPos = board.getKingPosition(this);
		for(Position enemyPiecePos : board.getEnemyPositions(this)) {
			if(board.getPiece(enemyPiecePos).isValidMove(enemyPiecePos, kingPos, board)) {
				return true;
			}
		}
		
		return false;
	}

}
