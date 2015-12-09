import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.Timer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;



public class createGUI{
	
	public static int squaresOpenedStart = 0;
	public static int squaresOpenedFinish = 0;
	public static boolean gameFinished = false;
		
	public createGUI(int rows , int columns, final int[][] value, int chance, int minecount){
	
	final JFrame MSFrame = new JFrame();
	MSFrame.setVisible(true);
	final JPanel panel = new JPanel();
	MSFrame.add(panel);
	panel.setLayout(new GridLayout(rows,columns,1,1));

	
	
	
	
	
	final JButton[][] buttons = new JButton[rows][columns];
	int a,b;
	
	
	
	for (a = 0 ; a < rows ; a++){
		for (b = 0 ; b < columns ; b++){
			buttons[a][b] = new JButton("");
		}
	}
		
	
	
	for (a = 0 ; a < rows ; a++){
		for (b = 0 ; b < columns ; b++){
			panel.add(buttons[a][b]);
		}
	}
	
	final ImageIcon mine = new ImageIcon("icons/mine.png");
	final ImageIcon number0 = new ImageIcon("icons/number0.png");
	final ImageIcon number1 = new ImageIcon("icons/number1.png");
	final ImageIcon number2 = new ImageIcon("icons/number2.png");
	final ImageIcon number3 = new ImageIcon("icons/number3.png");
	final ImageIcon number4 = new ImageIcon("icons/number4.png");
	final ImageIcon number5 = new ImageIcon("icons/number5.png");
	final ImageIcon number6 = new ImageIcon("icons/number6.png");
	final ImageIcon number7 = new ImageIcon("icons/number7.png");
	final ImageIcon number8 = new ImageIcon("icons/number8.png");
	final ImageIcon flag = new ImageIcon("icons/flag.png");
	
	final int rows1 = rows;
	final int columns1 = columns;
	final int chance1 = chance;
	final int minecount1 = minecount;
	
	for (a = 0 ; a < rows ; a++){
		for (b = 0 ; b < columns ; b++){
			final int finalA = a;
			final int finalB = b;
					
			buttons[a][b].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					
					if( gameFinished == false ){
					
					JButton button = (JButton) e.getSource();						
					switch(value[finalA][finalB]){
					
					case 1: button.setIcon(number1); break;
					case 2: button.setIcon(number2); break;
					case 3: button.setIcon(number3); break;
					case 4: button.setIcon(number4); break;
					case 5: button.setIcon(number5); break;
					case 6: button.setIcon(number6); break;
					case 7: button.setIcon(number7); break;
					case 8: button.setIcon(number8); break;
					//VIRHE
					case 9:{ 
						Timer sekunti = new Timer(1000, new ActionListener(){
							public void actionPerformed(ActionEvent e){
								 
								MSFrame.setVisible(false);
								    MSFrame.dispose();
								    Minesweeper.initialize(rows1, columns1, chance1);
								    
								    
								
							}
						});
						
						
						
						button.setIcon(mine); 
						gameFinished = true;
						sekunti.setRepeats(false);
						sekunti.start();
						
					
					}
		            break;	
		            
					case 0:{button.setIcon(number0); 
					boolean[][] buttonsOpened = new boolean[rows1][columns1];
					int a,b;
					for(a = 0 ; a < rows1; a++){
						for(b = 0 ; b < columns1; b++){
							
							buttonsOpened[a][b] = false;
							
						}
					}
					        zeroes(finalA, finalB, value, rows1, columns1, buttonsOpened, buttons, number0, number1, number2, number3, number4, number5, number6, number7, number8);
					        break;
						}
					}
					int a,b;
					for(a = 0 ; a < rows1 ; a++){
						for(b = 0 ; b < columns1 ; b++){
							
							if(buttons[a][b].getIcon()!=null && buttons[a][b].getIcon()!=flag){
								
								squaresOpenedStart++;
								
							
							}
								
							}
							
							
						}
					
					squaresOpenedFinish = squaresOpenedFinish + (squaresOpenedStart - squaresOpenedFinish);
					squaresOpenedStart = 0;
					
					if(rows1*columns1 - squaresOpenedFinish <= minecount1){
						
						winGame(rows1,columns1,chance1,MSFrame);
						a = rows1;
						b = columns1;								
						}
					}
				}
				
			});
		}
	}
									    			
					
			
							
				
			
		
	

	
	
	
	
	for (a = 0 ; a < rows ; a++){
		for (b = 0 ; b < columns ; b++){
			final int finalA = a;
			final int finalB = b;
			buttons[a][b].addMouseListener(new MouseListener(){
				public void mouseClicked( MouseEvent e){
					if(e.getButton() == MouseEvent.BUTTON3){
						buttons[finalA][finalB].setIcon(flag);
					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					
					
				}
		});
		}
	}
	
	
				
				
		
				

	
	
	
	
	MSFrame.setTitle("Minesweeper");
	MSFrame.setSize(columns*24,rows*24+32);
	MSFrame.setLocationRelativeTo(null);
	MSFrame.setResizable(false);
	
	JMenuBar menubar = new JMenuBar();
	
	JMenu game = new JMenu("Game");
	JMenu help = new JMenu("Help");
	JMenuItem newgame = new JMenuItem("New game");
	JMenuItem options = new JMenuItem("Options");
	JMenuItem exit = new JMenuItem("Exit");
	JMenuItem rules = new JMenuItem("How to play");
	JMenuItem about = new JMenuItem("About");
	
	
	
	exit.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	});
		

	
	
	newgame.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			
			
			MSFrame.setVisible(false);
			MSFrame.dispose();
			Minesweeper.initialize(rows1,columns1,chance1);
			
			
		}
	});
	
	options.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			
			final JFrame options = new JFrame();			
			JPanel leftSidePanel = new JPanel();
			options.setResizable(false);       
			        leftSidePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			        leftSidePanel.setLayout(new GridLayout(0,3,5,20));
			   
			        
			
			final JSlider difficultySlider = new JSlider(0,3,0);
			final JSlider rowsSlider = new JSlider(0,11,0);
			final JSlider columnsSlider = new JSlider(0,21,0);
			final JSlider minesSlider = new JSlider(0,8,0);
			JButton accept = new JButton("OK");
			JButton cancel = new JButton("Cancel");
			JLabel difficultySliderLabel = new JLabel("Difficulty:");
			                 final JLabel difficultyLabel = new JLabel("  easy");
			JLabel rowsSliderLabel = new JLabel("Rows:");
			                 final JLabel rowsLabel = new JLabel("9");
			JLabel columnsSliderLabel = new JLabel("Columns:");
			                 final JLabel columnsLabel = new JLabel("9");
			JLabel minesSliderLabel = new JLabel("Mines:");
                             final JLabel minesLabel = new JLabel("1/10");
			
			
			options.add(leftSidePanel);
			options.add(leftSidePanel);
			
			leftSidePanel.add(difficultySliderLabel);
			leftSidePanel.add(difficultySlider);
			difficultySlider.addChangeListener( new ChangeListener(){
				@Override
				public void stateChanged(ChangeEvent e){
					int slidervalue = difficultySlider.getValue();
					
					switch (slidervalue) {
					case 0: {difficultyLabel.setText("  easy");
					         rowsSlider.setValue(0);
					         columnsSlider.setValue(0);
					         minesSlider.setValue(0);}
						break;
					case 1: {difficultyLabel.setText("medium");
					         rowsSlider.setValue(7);
			                 columnsSlider.setValue(7);
			                 minesSlider.setValue(4);}
					
					
					break;
					case 2: {difficultyLabel.setText("  hard");
			                 rowsSlider.setValue(11);
	                         columnsSlider.setValue(21);
	                         minesSlider.setValue(6);}
					break;
					case 3: difficultyLabel.setText("custom");
					}
					
					
						
						
					}
					
				
			});
			leftSidePanel.add(difficultyLabel);
			
			
			leftSidePanel.add(rowsSliderLabel);
			leftSidePanel.add(rowsSlider);
			rowsSlider.addChangeListener(new ChangeListener(){
				@Override
				public void stateChanged(ChangeEvent e){
					 rowsLabel.setText("" + (rowsSlider.getValue()+9));
					 difficultySlider.setValue(3);
					
					}
				
			});
			
			leftSidePanel.add(rowsLabel);
			
			leftSidePanel.add(columnsSliderLabel);
			leftSidePanel.add(columnsSlider);
			columnsSlider.addChangeListener(new ChangeListener(){
				@Override
				public void stateChanged(ChangeEvent e){
					 columnsLabel.setText("" + (columnsSlider.getValue()+9));
					 difficultySlider.setValue(3);
					
					}
				
			});
			leftSidePanel.add(columnsLabel);
			
			leftSidePanel.add(minesSliderLabel);
			leftSidePanel.add(minesSlider);
			minesSlider.addChangeListener(new ChangeListener(){
				@Override
				public void stateChanged(ChangeEvent e){
					 minesLabel.setText("1/" + (10-(minesSlider.getValue())));
					 difficultySlider.setValue(3);
					
					}
				
			});
			leftSidePanel.add(minesLabel);
			
			leftSidePanel.add(new JLabel("  "));
			leftSidePanel.add(accept);
			accept.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int rows = 9 + rowsSlider.getValue();
					int columns = 9 + columnsSlider.getValue();
					int chance = 10 - minesSlider.getValue();
					
					MSFrame.setVisible(false);
					MSFrame.dispose();
					options.setVisible(false);
					options.dispose();
					Minesweeper.initialize(rows,columns,chance);
					
					
				}
			});	
				
			leftSidePanel.add(cancel);
			cancel.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					options.setVisible(false);
					options.dispose();
				}
			});
			
		
			
			options.setVisible(true);
			options.setLocationRelativeTo(null);
			options.setSize(300,250);
			
			
			
			
			
		}
	});
	
	
	
    about.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent e){
			JFrame about = new JFrame();
			JPanel aboutPanel = new JPanel();
			JPanel textPanel = new JPanel();
			
			textPanel.setBackground(Color.WHITE);
			textPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			String aboutString = "<html>This version of Minesweeper is made by Urauth.<br><center>2013</center></html>";
					
			JLabel aboutLabel = new JLabel(aboutString);
			Font aboutFont = new Font("SansSerif", Font.PLAIN, 16);
			aboutLabel.setFont(aboutFont);
			about.add(aboutPanel);
			aboutPanel.add(textPanel);
			textPanel.add(aboutLabel);
			about.setVisible(true);
			about.setTitle("About");
			about.setSize(450,100);
			about.setLocationRelativeTo(null);
			about.setResizable(false);
		}
		
	});
    
     rules.addActionListener(new ActionListener(){
    	
    	 public void actionPerformed(ActionEvent e){
    		
    		 JFrame rules = new JFrame();
    		    rules.setResizable(false);
    		    rules.setVisible(true);
		        rules.setTitle("About");
		        rules.setSize(500,200);
		        rules.setLocationRelativeTo(null);
		        
		        
 			String aboutString = "<html>You can start playing Minesweeper by left-clicking any square in the game.<br>" +
 					"In the square, you will find either a number or a mine.<br>" +
 					"If it is a number, it shows the amount of mines adjacent to it.<br>" +
 					"For example, if the number is 2,<br>" +
 					"it means that there are 2 mines right next to it diagonally, horizontally or vertically<br>" +
 					"Beware though! If you open a mine, your game is over!<br>" +
 					"You can mark mines you have found by right-clicking over a mine.<br>" +
 					"The point of the game is to open all squares that are not mines.<br>" +
 					"<center>Good luck</center></html>";
 					
 			
 			JPanel rulesPanel = new JPanel();
 			          rules.add(rulesPanel);
 			        
 			JPanel textPanel = new JPanel();
 			          textPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
 			          rulesPanel.add(textPanel);
 			          textPanel.setBackground(Color.WHITE);
 			          JLabel rulesLabel = new JLabel(aboutString);
 			          textPanel.add(rulesLabel);
 			          
 			        
 		    
 			
 			
 			
 			
 			
 			
 			
 			
 			
 			
    	}
    	 
     });
	
	
	menubar.add(game);
	menubar.add(help);
	game.add(newgame);
	game.add(options);
	game.addSeparator();
	game.add(exit);
	help.add(rules);
	help.add(about);
	MSFrame.setJMenuBar(menubar);
	
		
	}	
	
	public void zeroes(int finalA, int finalB, int[][] value, int rows, int columns, boolean[][] buttonsOpened, JButton[][] buttons, ImageIcon number0,ImageIcon number1,ImageIcon number2,ImageIcon number3,ImageIcon number4,ImageIcon number5,ImageIcon number6,ImageIcon number7,ImageIcon number8){
		
		int a,b;
		
		for(a = 0; a < 3; a++){
			for(b = 0; b < 3; b++){
				
			
		
		if(finalA-1+a >= 0 && finalA-1+a < rows && finalB-1+b >= 0 && finalB-1+b < columns && buttonsOpened[finalA-1+a][finalB-1+b]==false){
			
			
			switch(value[finalA-1+a][finalB-1+b] ){
			    
			
		
		         case 1: buttons[finalA-1+a][finalB-1+b].setIcon(number1); break;
		         case 2: buttons[finalA-1+a][finalB-1+b].setIcon(number2); break;
		         case 3: buttons[finalA-1+a][finalB-1+b].setIcon(number3); break;
		         case 4: buttons[finalA-1+a][finalB-1+b].setIcon(number4); break;
		         case 5: buttons[finalA-1+a][finalB-1+b].setIcon(number5); break;
		         case 6: buttons[finalA-1+a][finalB-1+b].setIcon(number6); break;
		         case 7: buttons[finalA-1+a][finalB-1+b].setIcon(number7); break;
		         case 8: buttons[finalA-1+a][finalB-1+b].setIcon(number8); break;
		         
		       
		         case 0:{ 
		        	 ;
		        	 buttons[finalA-1+a][finalB-1+b].setIcon(number0);
		        	 buttonsOpened[finalA-1+a][finalB-1+b]=true;
		        	 zeroes(finalA-1+a, finalB-1+b, value, rows, columns, buttonsOpened, buttons, number0, number1, number2, number3, number4, number5, number6, number7, number8 );
		         }
		         break;
			}
		}
		}
		}
		}

	
	public static void winGame(int rows,int columns,int chance, JFrame MSFrame){
		
		final int rows1 = rows;
		final int columns1 = columns;
		final int chance1 = chance;
		final JFrame MSFrame1 = MSFrame; 
		
		final JFrame wg = new JFrame();
		JPanel wgPanel = new JPanel();
		JPanel wg2Panel = new JPanel();
		wgPanel.setLayout(null);
						
		wg2Panel.setBackground(Color.WHITE);
		wg2Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		String wgString = "<html>Congratulations!<br><center>You won.</center></html>";
				
		JLabel wgLabel = new JLabel(wgString);
		Font wgFont = new Font("SansSerif", Font.PLAIN, 16);
		wgLabel.setFont(wgFont);
		wg.add(wgPanel);
		
		wg.setVisible(true);
		wg.setTitle("Congratulations!");
		wg.setSize(250,160);
		wg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wg.setLocationRelativeTo(null);
		wg.setResizable(false);
		JButton wgbuttonNewGame = new JButton("New Game");
		JButton wgbuttonExit = new JButton("Exit");
		wgPanel.add(wg2Panel);
		wg2Panel.setBounds(20,10,200,70);
		
		wgPanel.add(wg2Panel);
		wg2Panel.add(wgLabel);
		wgPanel.add(wgbuttonNewGame);
		wgbuttonNewGame.setBounds(50,90,100,30);
		wgbuttonNewGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MSFrame1.setVisible(false);
				MSFrame1.dispose();
				wg.setVisible(false);
				wg.dispose();
				Minesweeper.initialize(rows1,columns1,chance1);
				
			}
		});
		wgPanel.add(wgbuttonExit);
		wgbuttonExit.setBounds(160,90,60,30);
		wgbuttonExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		}
		
		
	}
		

