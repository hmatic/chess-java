package com.hrvojematic.chess.pieces;

import com.hrvojematic.chess.game.Board;
import com.hrvojematic.chess.game.Player;
import com.hrvojematic.chess.game.Position;

public abstract class Piece {
	private Player owner;

	public Player getOwner() {
		return owner;
	}
	
	public abstract boolean isValidMove(Position start, Position dest, Board board);
}
