package com.codingdojo.tictactoe.classes;


public class TicTacToeGameboard {
	private int[] simpleCol;
	
	
	// Originally, I was going to use an Enum for the TicTacToe symbols, but because I'll be reading the values while in html as well as storing and exporting them as integers, using enums just seems like a waste of time
	
	// Instead, I'll just be directly using the 9 digit code and chopping it up. 0 for blanks, 1 for X's, and 2 for O's
	public TicTacToeGameboard() {
		this.simpleCol = new int[]{0,0,0,0,0,0,0,0,0};
		/*this.columns = new int[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				this.columns[i][j] = 0;
			}
		}
		this.changes = this.columns;*/
	}
	
	public int[] getSimpleCol(){
		return this.simpleCol;
	}
	
	public TicTacToeGameboard(int gameCode) {
		//this.columns = new int[3][3];
		this.simpleCol = new int[9];
		int remainder = gameCode;
		/*for(int i = 2; i >= 0; i--) {
			for(int j = 2; j >= 0; j--) {
				this.columns[i][j] = remainder % 10;
				remainder = remainder / 10;
			}
		}
		this.changes = this.columns;*/
		for(int i = 8; i >= 0; i--) {
			this.simpleCol[i] = remainder % 10;
			remainder = remainder / 10;
		}
	}
	
	/*public int getCell(int x, int y) {
		//Could check for invalid calls but this will be done automatically in a fixed way by the forms anyway
		return this.columns[x][y]; // <-- Perhaps I'll just put a try-catch here
	}*/
	
	public int getCell(int cell) {
		System.out.println(cell);
		return this.simpleCol[cell];
	}
	
	/*public boolean setCell(int x, int y, int symbol) {
		if(this.columns[x][y] != 0) {
			return false;
		} else {
			this.columns[x][y] = symbol;
			return true;
		}
	}*/
	
	public boolean setCell(int cell, int symbol) {
		if(this.simpleCol[cell] != 0) {
			return false;
		} else {
			this.simpleCol[cell] = symbol;
			return true;
		}
	}
	
	public int convertToNotation() {
		String notation = "";
		for(int i = 0; i < 9; i++) {
			notation += this.simpleCol[i];
		}
		
		return Integer.parseInt(notation); //this can throw an exception but we know exactly what will be going through this at all times
	}
	
	/*public Integer checkGameCondition() {
		//Start by grabbing the center cell
		int centerCell = this.columns[1][1];
		//If the center cell is a blank, we can move on to the top right and bottom left corners
		if(centerCell != 0) {
			//But if not, check the top left corner first
			if(this.columns[0][0] == centerCell) {
				//If it's the same, check bottom right
				if(this.columns[2][2] == centerCell) {
					//Three in a row, top left diagonally down through the center into bottom right
					return 0;
				}
				//Otherwise move on
			}
			
			if(this.columns[0][2] == centerCell) {
				//If it's the same, check top right
				if(this.columns[2][0] == centerCell) {
					//Three in a row, bottom left diagonally up through the center into top right
					return 0;
				}
				//Otherwise move on
			}
			
			//Now check top center
			if(this.columns[1][0] == centerCell) {
				//Check center bottom
				if(this.columns[1][2] == centerCell) {
					//Three in a row, vertical center
					return 0;
				}
				//Otherwise move on
			}
			
			//Now check start center
			if(this.columns[0][1] == centerCell) {
				//check right center
				if(this.columns[2][1] == centerCell) {
					//Three in a row, horizontal center
					return 0;
				}
				//Otherwise move on
			}
		}
		
		//Now we set up so we can check top right corner cell now for the horizontal and vertical
		int topRightCell = this.columns[2][0];
		//First check if top right corner is not blank
		if(topRightCell != 0) {
			//check top center
			if(this.columns[1][0] == topRightCell) {
				//Check top left
				if(this.columns[0][0] == topRightCell) {
					//Three in a row, top horizontal
					return 0;
				}
				//Otherwise move on
			}
			
			//check right center
			if(this.columns[2][1] == topRightCell) {
				//check bottom right
				if(this.columns[2][2] == topRightCell) {
					//Three in a row, right vertical
					return 0;
				}
				//Otherwise move on
			}
		}
		
		//Now we finally check bottom left cell
		int bottomLeftCell = this.columns[0][2];
		if(bottomLeftCell != 0) {
			//check left center
			if(this.columns[0][1] == bottomLeftCell) {
				//Check top left
				if(this.columns[0][0] == bottomLeftCell) {
					//Three in a row, left vertical
					return 0;
				}
				//Otherwise move on
			}
			
			//check bottom center
			if(this.columns[1][2] == bottomLeftCell) {
				//check bottom right
				if(this.columns[2][2] == bottomLeftCell) {
					//Three in a row, bottom horizontal
					return 0;
				}
				//Otherwise move on
			}
		}
		
		//If we make it here, the game continues as normal unless...
		boolean full = true;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(this.columns[i][j] != 0) {
					full = false;
				}
			}
		}
		//If it's full, we end the game there
		if(full) return 2;
		//But if not, continue
		return 1;
	}*/
	
	public Integer checkGameCondition() {
		//Start by grabbing the center cell
		int centerCell = this.simpleCol[4];
		//If the center cell is a blank, we can move on to the top right and bottom left corners
		if(centerCell != 0) {
			//But if not, check the top left corner first
			if(this.simpleCol[0] == centerCell) {
				//If it's the same, check bottom right
				if(this.simpleCol[8] == centerCell) {
					//Three in a row, top left diagonally down through the center into bottom right
					return 0;
				}
				//Otherwise move on
			}
			
			if(this.simpleCol[2] == centerCell) {
				//If it's the same, check top right
				if(this.simpleCol[6] == centerCell) {
					//Three in a row, bottom left diagonally up through the center into top right
					return 0;
				}
				//Otherwise move on
			}
			
			//Now check top center
			if(this.simpleCol[1] == centerCell) {
				//Check center bottom
				if(this.simpleCol[7] == centerCell) {
					//Three in a row, vertical center
					return 0;
				}
				//Otherwise move on
			}
			
			//Now check start center
			if(this.simpleCol[3] == centerCell) {
				//check right center
				if(this.simpleCol[5] == centerCell) {
					//Three in a row, horizontal center
					return 0;
				}
				//Otherwise move on
			}
		}
		
		//Now we set up so we can check top right corner cell now for the horizontal and vertical
		int topRightCell = this.simpleCol[2];
		//First check if top right corner is not blank
		if(topRightCell != 0) {
			//check top center
			if(this.simpleCol[1] == topRightCell) {
				//Check top left
				if(this.simpleCol[0] == topRightCell) {
					//Three in a row, top horizontal
					return 0;
				}
				//Otherwise move on
			}
			
			//check right center
			if(this.simpleCol[5] == topRightCell) {
				//check bottom right
				if(this.simpleCol[8] == topRightCell) {
					//Three in a row, right vertical
					return 0;
				}
				//Otherwise move on
			}
		}
		
		//Now we finally check bottom left cell
		int bottomLeftCell = this.simpleCol[6];
		if(bottomLeftCell != 0) {
			//check left center
			if(this.simpleCol[3] == bottomLeftCell) {
				//Check top left
				if(this.simpleCol[0] == bottomLeftCell) {
					//Three in a row, left vertical
					return 0;
				}
				//Otherwise move on
			}
			
			//check bottom center
			if(this.simpleCol[7] == bottomLeftCell) {
				//check bottom right
				if(this.simpleCol[8] == bottomLeftCell) {
					//Three in a row, bottom horizontal
					return 0;
				}
				//Otherwise move on
			}
		}
		
		//If we make it here, the game continues as normal unless...
		boolean full = true;
		for(int i = 0; i < 9; i++) {
			if(this.simpleCol[i] !=0) full = false;
		}
		//If it's full, we end the game there
		if(full) return 2;
		//But if not, continue
		return 1;
	}
	
	public void setSimpleCol(int[] simpleCol) {
		this.simpleCol = simpleCol;
	}
}
