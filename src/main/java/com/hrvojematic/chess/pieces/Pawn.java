package com.hrvojematic.chess.pieces;

import com.hrvojematic.chess.game.Board;
import com.hrvojematic.chess.game.Player;
import com.hrvojematic.chess.game.Position;

public class Pawn extends Piece {

	public Pawn(Player owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Position start, Position end, Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPieceSymbol() {
		return "P";
	}

}
