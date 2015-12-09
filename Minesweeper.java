import java.util.Random;
import javax.swing.SwingUtilities;




public class Minesweeper {

	/**
	 * This is a Minesweeper game
	 */
	public static void main(String[] args) {
		
		
		int rows = 9;
		int columns = 9;
		int chance = 10;
		
		initialize(rows,columns,chance);
		
	}
	public static void initialize(int rowsA,int columnsA,int chanceA){
		
		int[][] locIsMine = isMine(rowsA,columnsA,chanceA);
		final int minecount = minecount(rowsA,columnsA,locIsMine);
		int[][] locValue = pointValue(rowsA,columnsA,locIsMine);
		final int[][] locValueFinal = marksMines(rowsA,columnsA,locIsMine,locValue);		
		
		final int rows = rowsA;
		final int columns = columnsA;
		final int chance = chanceA;
		createGUI.squaresOpenedFinish = 0;
		createGUI.squaresOpenedStart = 0;
		createGUI.gameFinished = false;
	
		
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				createGUI MS = new createGUI(rows,columns,locValueFinal, chance, minecount);
				
				
			}
		});
		
		
	}
	
   public static int[][] pointValue(int rows, int columns, int[][] isMine){
		
		int value = 0;
		int[][] pointValue = new int[rows][columns];
		int a,b;
		
		
		for (a = 0 ; a < rows ; a++ ){
			for (b = 0 ; b < columns ; b++){
				
				
				if(a!=0){
				if(b!=0)if(isMine[a-1][b-1] == 1)value++;
				if(isMine[a-1][b] == 1)value++;
				if(b!=columns-1)if(isMine[a-1][b+1] == 1)value++;
				}
				
				if(b!=0)if(isMine[a][b-1] == 1)value++;
				if(b!=columns-1)if(isMine[a][b+1] == 1)value++;
				
				if(a!=rows-1){
				if(b!=0)if(isMine[a+1][b-1] == 1)value++;
				if(isMine[a+1][b] == 1)value++;
				if(b!=columns-1)if(isMine[a+1][b+1] == 1)value++;
				}
				
				pointValue[a][b] = value;
				value=0;
			}
			
		}
		
		return pointValue;

	} 
	
	public static int[][] marksMines(int rows,int columns, int[][] isMine, int[][] pointValue){
		
		
		int a,b;
		
		for (a = 0 ; a < rows ; a++ ){
			for (b = 0 ; b < columns ; b++){
				
				if(isMine[a][b] == 1){
					
					pointValue[a][b] = 9;
					
				}
			}
		
		}
		
		return pointValue;
	}

	public static int[][] isMine( int rows , int columns, int chance){
		
		int a,b;
		
		
		int [][] isMine = new int[rows][columns];
		Random chosenmine = new Random();
		
		for (a = 0 ; a < rows ; a++ ){
			for (b = 0 ; b < columns ; b++){
				
				if(chosenmine.nextInt(chance) == 0){
					
					isMine[a][b] = 1;
					
				}else{
					isMine[a][b] = 0;
				}
				
				
			}
		}
		
		return isMine;
	}
	
	public static int minecount(int rows, int columns, int[][] isMine){
		
		int a,b;
		int minecount = 0;
		
		for(a = 0; a < rows; a++){
			for(b = 0 ; b < columns; b++){
				
				if(isMine[a][b] == 1) minecount++;
				
			}
		}
		
		return minecount;
		
	}


	
}	


