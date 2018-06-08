package com.hrvojematic.chess.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hrvojematic.chess.pieces.Piece;

public class Board {
	private Map<Position, Piece> boardState = new HashMap<>();
	
	public Board(Map<Position, Piece> boardState) {
		this.boardState = boardState;
	}

	public Board changeBoard(Position start, Position dest) {
		Piece piece = removePiece(start);
		if(piece==null) throw new IllegalStateException("Starting position has no piece on it.");
		if(containsPiece(dest)) {
			removePiece(dest);
		}
		addPiece(dest, piece);
		return this;
	}
	
	public List<Position> getPlayerPiecesPositions(Player player) {
		List<Position> playerPiecesPositions = new ArrayList<>();
		for(Map.Entry<Position, Piece> entry : boardState.entrySet()) {
			if(entry.getValue().getOwner()==player) {
				playerPiecesPositions.add(entry.getKey());
			}
		}
		return playerPiecesPositions;
	}
	
	public void addPiece(Position position, Piece piece) {
		boardState.put(position, piece);
	}
	
	public Piece getPiece(Position position) {
		return boardState.get(position);
	}
	
	public Piece removePiece(Position position) {
		return boardState.remove(position);
	}
	
	public boolean containsPiece(Position position) {
		return boardState.containsKey(position);
	}
	
	public Board clone() {
		return new Board(boardState);
	}
	
}
