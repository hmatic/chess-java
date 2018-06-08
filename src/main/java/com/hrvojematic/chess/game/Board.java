package com.hrvojematic.chess.game;

import java.util.HashMap;
import java.util.Map;

import com.hrvojematic.chess.pieces.Piece;

public class Board {
	private Map<Position, Piece> boardState = new HashMap<>();
	
		
	public Piece getPiece(Position position) {
		return boardState.get(position);
	}
	
	public Piece removePiece(Position position) {
		return boardState.remove(position);
	}
	
	public boolean containsPiece(Position position) {
		return boardState.containsKey(position);
	}
}
