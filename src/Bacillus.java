import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bacillus extends JFrame{
	int x_max = 35;
	int y_max = 35;
	int count_r = 4;
	int count_b = 4;
	int add_r = 0;
	int[][] map = { { 1, 1, 0, 0, 0, 0, 0 }, 
					{ 1, 1, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0 }, 
					{ 0, 0, 0, 0, 0, 0, 0 }, 
					{ 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 2, 2 }, 
					{ 0, 0, 0, 0, 0, 2, 2 } }; // 빨간공은 1, 파란공은 2로 관리
	boolean turn = true;
	
	
	Bacillus() {
		setTitle("세균전");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel t = new MyPanel();
		setContentPane(t);
		
		t.setFocusable(true);
		setSize(400,285);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new Bacillus();
	}
	
	class MyPanel extends JPanel {
		int set_x=-1, set_y=-1;
		
		public MyPanel() {
			addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub

				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub					
					if((set_x >=0 && set_x <= 6) && (set_y <= 6 && set_y>=0)) {
						
						switch (e.getKeyCode()) {
						
							case KeyEvent.VK_UP: 
								if(--set_y < 0) set_y=0;
								
								if(map[set_x][set_y] == 0) {
									map[set_x][set_y] = 3;
									System.out.println(set_x + ", " + set_y);
								}
								else if(map[set_x][set_y] == 1) {
									map[set_x][set_y] = 3;
									map[set_x][set_y] = 1;
								}
								else {
									map[set_x][set_y] = 3;
									map[set_x][set_y] = 2;
								}
								break;
								
							case KeyEvent.VK_DOWN:
								if(++set_y > 6) set_y=6;
								if(map[set_x][set_y] == 0) {
									map[set_x][set_y] = 3;
									System.out.println(set_x + ", " + set_y);
								}
								else if(map[set_x][set_y] == 1) {
									map[set_x][set_y] = 3;
									map[set_x][set_y] = 1;
								}
								else {
									map[set_x][set_y] = 3;
									map[set_x][set_y] = 2;
								}
								break;
								
							case KeyEvent.VK_LEFT:
								if(--set_x < 0) set_x=0;
								if(map[set_x][set_y] == 0) {
									map[set_x][set_y] = 3;
									System.out.println(set_x + ", " + set_y);
								}
								else if(map[set_x][set_y] == 1) {
									map[set_x][set_y] = 3;
									map[set_x][set_y] = 1;
								}
								else {
									map[set_x][set_y] = 3;
									map[set_x][set_y] = 2;
								}
								break;
								
							case KeyEvent.VK_RIGHT:
								if(++set_x > 6) set_x=6;
								if(map[set_x][set_y] == 0) {
									map[set_x][set_y] = 3;
									System.out.println(set_x + ", " + set_y);
								}
								else if(map[set_x][set_y] == 1) {
									map[set_x][set_y] = 3;
									map[set_x][set_y] = 1;
								}
								else {
									map[set_x][set_y] = 3;
									map[set_x][set_y] = 2;
								}
								break;
							
						
							case KeyEvent.VK_SPACE:
								int[] add = {-1, 0, 1};
								
								if (turn == true) {
									map[set_x][set_y] = 1;
									for (int item1 : add) {
										for (int item2 : add) {
											if (map[set_x + item1][set_y+item2] == 2 ) {
												map[set_x + item1][set_y+item2] = 1;
											}
										}
									}
									System.out.println(set_x + ", " + set_y);
									turn = false;
									break;
								}
								else {
									map[set_x][set_y] = 2;
									try {
										for (int item1 : add) {
											for (int item2 : add) {
												if (map[set_x + item1][set_y+item2] == 1 ) {
													map[set_x + item1][set_y+item2] = 2;
												}
											}
										}
									} catch(IndexOutOfBoundsException E) {
										
									}
									System.out.println(set_x + ", " + set_y);
									turn = true;
									break;
								}
								
								
								
						}
					}
					repaint();
				}
			});
			
			addMouseListener(new MouseListener() {
			
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
					if (e.getX() <= 245 && e.getY() <= 245) {
						int [] copy = {35, 0, -35};
						int [] add = {70, 35, 0, -35, -70};
						
						int x = e.getX() / x_max;
						int y = e.getY() / y_max;
						
						try {
							if(((turn == true) && (map[x][y] == 1)) ||
								(turn == false) && (map[x][y] == 2)) {
								for(int item1 : copy) { 
									for (int item2 : copy) {
										int x1 = (e.getX() + item1) / x_max;
										int y1 = (e.getY() + item2) / y_max;
										if (x1 >= 6) x1 = 6;
										if (y1 >= 6) y1 = 6;
																			
										if(map[x1][y1] != 0) {
											continue;
										}
										else {
											map[x1][y1] = 4;
										}
									}
								}
							}
							else {
								System.out.println("ERROR! 잘못 눌렀습니다.");
							}
						} catch (IndexOutOfBoundsException E) {
							
						}
//						if(((turn == true) && (map[x][y] == 1)) ||
//								(turn == false) && (map[x][y] == 2)) {
//							for(int item3 : add) {
//								for(int item4 : add) {
//									if(Math.abs(item3) + Math.abs(item4) >= 105) {
//										int x2 = (e.getX() + item3) / x_max;
//										int y2 = (e.getY() + item4) / y_max;
//										
//										if(map[x2][y2] != 0) {
//											continue;
//										}
//										else {
//											map[x2][y2] = 5;
//										}
//									}
//									else if((Math.abs(item3) == 70 || Math.abs(item4) == 70)) {
//										int x2 = (e.getX() + item3) / x_max;
//										int y2 = (e.getY() + item4) / y_max;
//										if(map[x2][y2] == 0)
//											map[x2][y2] = 5;
//									}
//									else {
//										continue;
//									}
//								}
//							}
//						}
															
						if(map[x][y] == 1) {
							set_x = x;
							set_y = y;
						}
						if(map[x][y] == 2) {
							set_x = x;
							set_y = y;
						}

					}
					repaint();
				}
				
			});
			
		}
		
		

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(new Font("Arial",Font.ITALIC,30));
			g.drawString("RED", 260, 30);
			g.drawString("BLUE", 260, 60);
			
			if(turn == true) {
				g.setColor(Color.RED);
			}
			else {
				g.setColor(Color.blue);
			}

			
			for (int i=0; i<=7; i++) {
				g.drawLine(0, 35 * i, 245, 35*i );
				g.drawLine(35*i, 0, 35*i, 245);
			}
			for (int i=0; i<7; i++) {
				for(int j=0; j<7; j++) {
					if(map[i][j] == 1) { //빨간공 놓기
						g.setColor(Color.RED);
						g.fillOval(i * 35, j * 35, 35, 35);
					}
					else if (map[i][j] == 2) { //파란공 놓기
						g.setColor(Color.BLUE);
						g.fillOval(i * 35, j * 35, 35, 35);
						
					}
					else if (map[i][j] == 3) { //그냥 이동할 때 보이는 공
						if(map[i][j] == 1 || map[i][j]==2) {
							break;
						}
						g.setColor(Color.GRAY);
						g.drawOval(i*35, j*35, 35, 35);
						map[i][j] = 0;
					}
					else if (map[i][j] == 4) { //복제가능한 공간
						g.setColor(Color.GREEN);
						g.fillRect(i * 35, j * 35, 35, 35);
						map[i][j] = 0;
						
					}
					else if (map[i][j] == 5) { //이동가능한 공간
						g.setColor(Color.ORANGE);
						g.fillRect(i * 35, j * 35, 35, 35);
						map[i][j] = 0;
						
					}
				}
			}
			
			
			g.setFont(new Font("Arial",Font.ITALIC,30));
			g.setColor(Color.black);
			g.drawString(count_r+"", 350, 30);
			g.drawString(count_b+"", 350, 60);
			
			
			
		}
	}
}

