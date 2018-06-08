package com.hrvojematic.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.hrvojematic.chess.game.Board;
import com.hrvojematic.chess.game.Player;
import com.hrvojematic.chess.game.Position;

public abstract class Piece {
	private Player owner;

	public Player getOwner() {
		return owner;
	}
		
	public Piece(Player owner) {
		super();
		this.owner = owner;
	}



	public abstract boolean isValidMove(Position start, Position dest, Board board);

	public abstract String getPieceSymbol();
	
	public List<Position> getPossibleDestinations(Position pieceStart, Board board) {
		List<Position> possibleDestinations = new ArrayList<>();
		for(int i=1; i<=8; i++) {
			for(int j=1; j<=8; j++) {
				if(isValidMove(pieceStart, Position.get(i, j), board)) {
					possibleDestinations.add(Position.get(i, j));
				}
			}
		}
		return possibleDestinations;
	}
}
