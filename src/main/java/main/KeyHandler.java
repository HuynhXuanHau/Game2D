package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import dao.GameClient;
import dao.HightScoreB;
import dao.HightScoreDao;

public class KeyHandler extends KeyAdapter implements KeyListener {
	
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, music= false;
	public int dem=0;
	public boolean map1= true;
	public String map ="map1";
	public String getMap() {
		return this.map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
	
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		//finishstate
		if(gp.gameState == gp.finishState) {
			handleFinishStateKeys(code);
		}else
		//hightstate
		if(gp.gameState == gp.hightState) {
			handleHightStateKeys(code);
		}else
		//pause
		if(gp.gameState == gp.pauseState) {
			handlePauseStateKeys(code);
		}else
		//title state
		if (gp.gameState == gp.titleState) {
			gp.playerNameTextField.setEditable(true);
	
			handleTitleStateKeys(code);
		}else
		if (gp.gameState == gp.sourceState) {
			sourceState(code);
		}else
			if(gp.gameState == gp.settingState) {
				settingState(code);
			}
		else
		//play state 
		if (code == KeyEvent.VK_W ) {
			upPressed = true;
		}else
		if (code == KeyEvent.VK_S ) {
			downPressed = true;
			
		}else
		if (code == KeyEvent.VK_A ) {
			leftPressed = true;
		}else
		if (code == KeyEvent.VK_D ) {
			rightPressed = true;
		}else
		if (code == KeyEvent.VK_P) {
			if(gp.gameState == gp.playerState) {
				gp.gameState = gp.pauseState;
				gp.stopMusic();
				music = false;			
			}else 
				if(gp.gameState == gp.pauseState){
				gp.gameState = gp.playerState;
				if (!music) {
					gp.playMusic(0);
					music = true;
					}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			upPressed = false;
		}else
		if (code == KeyEvent.VK_S) {
			downPressed = false;
		}else
		if (code == KeyEvent.VK_A) {
			leftPressed = false;
		}else
		if (code == KeyEvent.VK_D) {
			rightPressed = false;
		}
	}
	private void handleFinishStateKeys(int code) {
		if (code == KeyEvent.VK_W) {
		    gp.ui.commandNum = (gp.ui.commandNum - 1 + 2) % 2;
		} else if (code == KeyEvent.VK_S) {
		    gp.ui.commandNum = (gp.ui.commandNum + 1) % 2;
		}
		if(code == KeyEvent.VK_ENTER) {
			if (gp.ui.commandNum ==0) {
				gp.resetGame();
				gp.ui.playTime=0;
				gp.gameState= gp.playerState;
				if (!music) {
				gp.playMusic(0);
				music = true;
				}
			}if (gp.ui.commandNum ==1) {
				gp.gameState= gp.titleState;
				gp.stopMusic();
				music = false;				
				}
		}
	}
	private void handleTitleStateKeys(int code) {
	
		if (code == KeyEvent.VK_W) {
			gp.ui.commandNum --;
			if (gp.ui.commandNum <0) {
				gp.ui.commandNum =5;
			}
		}else
		if (code == KeyEvent.VK_S) {
			gp.ui.commandNum ++;
			if (gp.ui.commandNum >5) {
				gp.ui.commandNum =0;
			}
		}
		if (code == KeyEvent.VK_ENTER) {
			if (gp.ui.commandNum ==0) {
				gp.resetGame();
				gp.ui.playTime=0;
				gp.gameState= gp.playerState;
				if (!music) {
					gp.playMusic(0);
					music = true;}	
				gp.checkNewGame = true;
				}else
			if (gp.ui.commandNum ==1) {
				if(gp.checkNewGame) {
					gp.gameState= gp.playerState;
				if (!music) {
					gp.playMusic(0);
					music = true;}
				}else {
					gp.resetGame();
					gp.ui.playTime=0;
					gp.gameState= gp.playerState;
					if (!music) {
						gp.playMusic(0);
						music = true;}	
					gp.checkNewGame = true;
				}
								
				}else
			if (gp.ui.commandNum ==2) {
				//gp.drawHighScoreBoard =true;
				gp.gameState= gp.hightState;
				gp.highScoreBoard.setVisible(true);
				GameClient gameClient = new GameClient(gp);
				gameClient.startGameClientThread();

//			ArrayList<HightScoreB> list = HightScoreDao.getInstance().selectAll(map);
//				int count = list.size();
//				gp.highScoreBoard.model.setRowCount(0);
//				if(count <=5) {
//				for (int i = 0; i <= count-1 ; i++) {
//					HightScoreB hsb = list.get(i);
//		           gp.highScoreBoard.model.addRow(new Object[]{String.valueOf(i+1),hsb.getNamePlayer(), hsb.getTime(),hsb.getmap()});
//		        }} else {
//					//gp.highScoreBoard.model.addRow(new Object[]{"Places", "Name Player", "Time","Map"});
//					for (int i = 0; i <5; i++) {
//						HightScoreB hsb = list.get(i);
//			           gp.highScoreBoard.model.addRow(new Object[]{String.valueOf(i+1),hsb.getNamePlayer(), hsb.getTime(),hsb.getmap()});
//				}
//				}
			} else
				if(gp.ui.commandNum==3) {
					gp.gameState= gp.sourceState;
				}
				else
			if (gp.ui.commandNum ==4) {
				System.exit(0);
			}
			if (gp.ui.commandNum ==5) {
				gp.gameState= gp.settingState;
			}

		}
		System.out.println("commandNum = "+ gp.ui.commandNum);
	}
	
	private void handleHightStateKeys(int code) {
		if (code == KeyEvent.VK_W) {
		    gp.ui.commandNum = (gp.ui.commandNum - 1 + 2) % 2;
		} else if (code == KeyEvent.VK_S) {
		    gp.ui.commandNum = (gp.ui.commandNum + 1) % 2;
		}
		if(code== KeyEvent.VK_ENTER) {
		//	gp.drawHighScoreBoard =false;
			gp.highScoreBoard.setVisible(false);
			gp.gameState = gp.titleState;
			
		}
	}
	
	private void handlePauseStateKeys(int code) {
		if (code == KeyEvent.VK_W){
			gp.ui.commandNum--;
			if (gp.ui.commandNum<0) {
				gp.ui.commandNum=1;
			}
		}else if (code == KeyEvent.VK_S) {
			gp.ui.commandNum++;
			if (gp.ui.commandNum >1) {
				gp.ui.commandNum=0;
			}
		}
		if (code==KeyEvent.VK_ENTER) {
			if (gp.ui.commandNum ==0) {
				gp.gameState= gp.playerState;
				if (!music) {
				gp.playMusic(0);
				music = true;}
			}if (gp.ui.commandNum ==1) {
				gp.gameState= gp.titleState;
				gp.stopMusic();
				music = false;
			}
		}
	}
	private void sourceState(int code) {
		if (code == KeyEvent.VK_W) {
		    gp.ui.commandNum = (gp.ui.commandNum - 1 + 2) % 2;
		} else if (code == KeyEvent.VK_S) {
		    gp.ui.commandNum = (gp.ui.commandNum + 1) % 2;
		}
		if(code == KeyEvent.VK_ENTER) {
			gp.gameState = gp.titleState;
		}
	}
	private void settingState(int code) {
		if (code == KeyEvent.VK_W) {
			gp.ui.commandNum = (gp.ui.commandNum -1 + 3) % 3;
		} else if (code == KeyEvent.VK_S) {
			gp.ui.commandNum = (gp.ui.commandNum +1) % 3;
		}
		if(code == KeyEvent.VK_ENTER) {
			switch (gp.ui.commandNum) {
				case 2:
					System.out.println("commandNum = "+ gp.ui.commandNum);
					gp.gameState = gp.titleState;
					break;
				case 0:
					System.out.println("commandNum = "+ gp.ui.commandNum);
					map1= true;
					setMap( "map1");
					System.out.println("New map: " + getMap());
					gp.reloadMap();
					gp.reloadobj();
					break;
				case 1:
					System.out.println("commandNum = "+ gp.ui.commandNum);
					map1= false;
					setMap( "map2");
					System.out.println("New map: " + getMap());
					gp.reloadMap();
					gp.reloadobj();
					break;
			}
		}
	}
}
