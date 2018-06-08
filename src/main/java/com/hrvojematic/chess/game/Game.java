package com.hrvojematic.chess.game;

import java.util.ArrayList;
import java.util.List;

import com.hrvojematic.chess.pieces.Piece;

public class Game {
	private Board board;
	private Player playerOnMove;
	private Player otherPlayer;
	
	
	
	public Game(Board board, Player playerOnMove, Player otherPlayer) {
		super();
		this.board = board;
		this.playerOnMove = playerOnMove;
		this.otherPlayer = otherPlayer;
	}

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
			List<Board> possibleBoards = allPossibleBoards();
			for(Board possibleBoard : possibleBoards) {
				if(!playerOnMove.isInCheck(possibleBoard)) return false;
			}
			return true;
		}
		return false;
	}
	
	public boolean isStaleMate() {
		if(!playerOnMove.isInCheck(board)) {
			for(Board possibleBoard : allPossibleBoards()) {
				if(!playerOnMove.isInCheck(possibleBoard)) return false;
			}
			return true;
		}
		return false;
	}
	
	public void switchPlayerOnMove() {
		Player temp = playerOnMove;
		playerOnMove = otherPlayer;
		otherPlayer = temp;
	}
	
	public List<Board> allPossibleBoards() {
		List<Board> allPossibleBoards = new ArrayList<>();
		
		for(Position pieceStart : board.getPlayerPositions(playerOnMove)) {
			for(Position pieceDest : board.getPiece(pieceStart).getPossibleDestinations(pieceStart, board)) {
				allPossibleBoards.add(board.clone().changeBoard(pieceStart, pieceDest));
			}
		}
		
		return allPossibleBoards;
	}
	
}
