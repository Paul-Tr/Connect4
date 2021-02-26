package model;

public class Board {
	String[][] spaces;
	public Board() {
		spaces= new String[6][7];
		for(int i=0;i<6;i++) {
			for(int j=0;j<7;j++) {
				spaces[i][j]=" ";
			}
		}
	}
	public void printBoard() {
		String rowline="---------------";
		System.out.println(rowline);
		String line;
		for(int i=0;i<6;i++) {
			line="|";
			for(int j=0;j<7;j++) {
				line=line+spaces[i][j];
				line=line+"|";
			}
			System.out.println(line);
			System.out.println(rowline);
		}
		System.out.println(" 1 2 3 4 5 6 7");
		
	}
	public boolean addPiece(int position,String turn) {
		position--;
		for (int i=5;i>=0;i--) {
			if (spaces[i][position].compareTo(" ")==0) {
				spaces[i][position]=turn;
				return true;
			}
		}
		return false;
	}
	private boolean checkRowWin(int i, int j) {
		int direction=1;
		if (j<=3) {
			for (int s=1;s<=3;s++) {
				if (spaces[i][j].compareTo(spaces[i][j+direction])!=0) {
					return false;
				}
				j=j+direction;
			}
		}
		if (j>=3) {
			direction =-1;
			for (int s=1;s<=3;s++) {
				if (spaces[i][j].compareTo(spaces[i][j+direction])!=0) {
					return false;
				}
				j=j+direction;
			}
		}
		for (int s=1;s<=3;s++) {
			if (spaces[i][j].compareTo(spaces[i][j+direction])!=0) {
				return false;
			}
			j=j+direction;
		}
		return true;
		
	}
	private boolean checkColumnWin(int i, int j) {
		int direction=1;
		if (i>=3) {
			direction=-1;
		}
		for (int s=1;s<=3;s++) {
			if (spaces[i][j].compareTo(spaces[i+direction][j])!=0) {
				return false;
			}
			i=i+direction;
			
		}
		return true;
	}
	private boolean checkDiagWin(int i,int j) {
		int direction=1;
		if (i>2) {
			return false;
		}
		if (j<=3) {
			for (int s=1;s<=3;s++) {
				if (spaces[i][j].compareTo(spaces[i+1][j+direction])!=0) {
					return false;
				}
				i++;
				j=j+direction;
			}
		}
		if (j>=3) {
			direction=-1;
			for (int s=1;s<=3;s++) {
				if (spaces[i][j].compareTo(spaces[i+direction][j+direction])!=0) {
					return false;
				}
				i=i+direction;
				j=j+direction;
				}
			}
		
		return true;
	}
	private boolean checkIfWinningSpace(int i, int j){
		if (checkColumnWin(i, j)) {
			return true;
		}
		if (checkRowWin(i, j)) {
			return true;
		}
		return checkDiagWin(i, j);
		
	}
	public boolean checkForWinner() {
		for (int i=0;i<=5;i++) {
			for (int j=0;j<=6;j++) {
				if (spaces[i][j].compareTo(" ")!=0) {
					if (checkIfWinningSpace(i, j)) {
						return true;
					}
				}

			}
		}
		return false;
	}
	public boolean isFull() {
		int i=0;
		for (int j=0;j<7;j++) {
			if (spaces[i][j].compareTo(" ")==0) {
				return false;
			}
		}
		return true;
	}

}
