package com.hrvojematic.chess.game;

import java.util.List;

import com.hrvojematic.chess.pieces.Piece;

public class Game {
	private Board board;
	private Player playerOnMove;
	private Player otherPlayer;
	
	public boolean move(Position start, Position dest) {
		Piece piece = this.board.getPiece(start);
		if(piece==null || piece.getOwner()!=playerOnMove ) return false;
		if(piece.isValidMove(start, dest, board)) {
			Board boardAfterMove = board.clone().changeBoard(start, dest);
			if(playerOnMove.isInCheck(boardAfterMove)) return false;
		}
		return false;
	}
	
	public boolean isCheckMate() {
		if(playerOnMove.isInCheck(board)) {
			List<Board> allPossibleBoards = null; //TODO method that calculates all possible board states
			for(Board possibleBoard : allPossibleBoards) {
				if(!playerOnMove.isInCheck(possibleBoard)) return false;
				return true;
			}
		}
		return false;
	}
	
	public void switchPlayerOnMove() {
		Player temp = playerOnMove;
		playerOnMove = otherPlayer;
		otherPlayer = temp;
	}
	
}
