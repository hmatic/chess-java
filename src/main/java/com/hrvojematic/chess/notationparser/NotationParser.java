package com.hrvojematic.chess.notationparser;

import com.hrvojematic.chess.game.Position;

public class NotationParser {
	private String moveNotation;
	private Position startPos;
	private Position endPos;
	
	public NotationParser(String moveNotation) {
		this.moveNotation = moveNotation;
	}
	
	public void parse() {
		moveNotation = "";
		//TODO parse given string and set startPos and endPos variables for given move
	}

	public Position getStartPos() {
		return startPos;
	}
	
	public Position getEndPos() {
		return endPos;
	}
	
	
}
