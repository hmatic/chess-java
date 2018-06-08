package com.hrvojematic.chess.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hrvojematic.chess.pieces.King;
import com.hrvojematic.chess.pieces.Piece;

public class Board {
	private Map<Position, Piece> boardState;
	
	public Board() {
		this.boardState = new HashMap<>();
	}
	public Board(Map<Position, Piece> boardState) {
		this.boardState = new HashMap<>(boardState);
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
	
	public List<Position> getPlayerPositions(Player player) {
		List<Position> playerPiecesPositions = new ArrayList<>();
		for(Map.Entry<Position, Piece> entry : boardState.entrySet()) {
			if(entry.getValue().getOwner()==player) {
				playerPiecesPositions.add(entry.getKey());
			}
		}
		return playerPiecesPositions;
	}
	
	public List<Position> getEnemyPositions(Player player) {
		List<Position> playerPiecesPositions = new ArrayList<>();
		for(Map.Entry<Position, Piece> entry : boardState.entrySet()) {
			if(entry.getValue().getOwner()!=player) {
				playerPiecesPositions.add(entry.getKey());
			}
		}
		return playerPiecesPositions;
	}
	
	public Position getKingPosition(Player player) {
		for(Map.Entry<Position, Piece> entry : boardState.entrySet()) {
			if(entry.getValue().getClass()==King.class && entry.getValue().getOwner()==player) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	public String printBoard() {
		StringBuilder sb = new StringBuilder();
		for(int y=8; y>=1; y--) {
			for(int x=1; x<=8; x++) {
				Piece piece = getPiece(Position.get(x, y));
				if(piece==null) {
					sb.append("- ");
				} else {
					sb.append(piece.getPieceSymbol() + " ");
				}
			}
			sb.append("\n");
		}
		
		
		return sb.toString();
	}
	
}
