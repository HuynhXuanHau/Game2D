package main;

import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import dao.HightScoreB;
import dao.HightScoreDao;
import entity.Entity;

public class HandlePlayerName implements ActionListener{
 GamePanel gp;
 Entity entity = new Entity();
 UI ui ;
	DecimalFormat dF = new DecimalFormat("#.##");
 
 public HandlePlayerName(GamePanel gp,UI ui) {
     this.gp = gp;
     this.ui = ui;
 }
	@Override
	public void actionPerformed(ActionEvent e) {
		String namePlayer = gp.playerNameTextField.getText();
		double time = ui.playTime;
		HightScoreB pla = new HightScoreB(namePlayer, dF.format(time));
		
		try {
			HightScoreDao.getInstance().insert(pla);
			 gp.playerNameTextField.setEditable(false);
			 KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
			    manager.focusNextComponent(gp.playerNameTextField);
			    gp.playerNameTextField.setEditable(true);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
