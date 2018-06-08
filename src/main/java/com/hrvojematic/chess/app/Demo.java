package com.hrvojematic.chess.app;

import com.hrvojematic.chess.game.Board;
import com.hrvojematic.chess.game.Game;
import com.hrvojematic.chess.game.Player;
import com.hrvojematic.chess.game.Position;
import com.hrvojematic.chess.pieces.King;
import com.hrvojematic.chess.pieces.Rook;

public class Demo {
	public static void main(String[] args) {
		Board board = new Board();
		Player player1 = new Player();
		Player player2 = new Player();
		board.addPiece(Position.get(7,1), new Rook(player2));
//		board.addPiece(Position.get(1,8), new Rook(player2));
		board.addPiece(Position.get(7,6), new King(player2));
		board.addPiece(Position.get(8,8), new King(player1));
		Game game = new Game(board, player1, player2);
		System.out.println(board.printBoard());
		System.out.println(game.isStaleMate());
		System.out.println(game.isCheckMate());
		
	}
}
