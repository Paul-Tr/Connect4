package controller;

import model.Board;

public class Game {
	Board board;
	int turn;
	public Game() {
		board=new Board();
		turn =1;
	}
	public String getTurn() {
		if (turn==1) {
			return "x";
		}
		return "o";
	}
	public String player() {
		if (turn==1) {
			return "Player 1";
		}
		return "Player 2";
	}
	public int addPiece(int i) {
		boolean rez;
		rez=board.addPiece(i, getTurn());
		if (rez==false) {
			return -1;
		}
		rez=board.checkForWinner();
		if (rez==true) {
			return 0;
		}
		if (board.isFull()) {
			return 2;
		}
		turn = turn * -1;
		return 1;
	}
		public void printBoard() {
			board.printBoard();
		}
}
	


