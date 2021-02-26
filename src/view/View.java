package view;

import java.util.Scanner;

import controller.Game;

public class View {
	Scanner console;
	Game game;
	public View() {
		System.out.println("Welcome to connect4");
		game=new Game();
		console = new Scanner(System.in);
		instructions();
	}
	public void instructions() {
		System.out.println("On your turn, enter a number between 1 and 7 to place a piece.");
		System.out.println("Pieces are placed on atop the other");
		System.out.println("The first to match 4 pieces on a row,column or diagonal wins!");
		
	}
	public void turn(String player) {
		System.out.println(player + ", please select a column to place a piece");
	}
	
	public void play () {
		int i;
		int rez;
		boolean finished=false;
		game.printBoard();
		while (finished==false) {
			turn(game.player());
			i=console.nextInt();
			rez=game.addPiece(i);
			if (rez==1) {
				System.out.println("piece added at " + i);
			}
			else if(rez==2) {
				finished=true;
				System.out.println("Game ended with draw!");
			}
			else if(rez==0) {
				finished=true;
				System.out.println("Victory !Congratulations "+ game.player());
			}
			else if(rez==-1) {
				System.out.println("Invalid Position!");
			}
			game.printBoard();
			
		}
		
	}

}
