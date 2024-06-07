package dao;

import main.GamePanel;


import java.io.*;
        import java.net.*;
        import java.util.ArrayList;



public class GameClient implements Runnable {
    private static final String HOST = "2001:ee0:4b48:79b0:8a01:f915:3250:2861";
    private static final int PORT = 12345;
    GamePanel gamePanel;
    Thread gameClientThread;

    public GameClient(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public static ArrayList<HightScoreB> getLeaderboard() {
        try (Socket socket = new Socket(HOST, PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            out.writeObject("GET_LEADERBOARD");

            return (ArrayList<HightScoreB>) in.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
    @Override
    public void run() {
            ArrayList<HightScoreB> leaderboard = getLeaderboard();
        	int count = leaderboard.size();
            gamePanel.highScoreBoard.model.setRowCount(0);
				if(count <=5) {
				for (int i = 0; i <= count-1 ; i++) {
					HightScoreB hsb = leaderboard.get(i);
                    gamePanel.highScoreBoard.model.addRow(new Object[]{String.valueOf(i+1),hsb.getNamePlayer(), hsb.getTime(),hsb.getmap()});
		        }} else {
					for (int i = 0; i < 5; i++) {
						HightScoreB hsb = leaderboard.get(i);
                        gamePanel.highScoreBoard.model.addRow(new Object[]{String.valueOf(i+1),hsb.getNamePlayer(), hsb.getTime(),hsb.getmap()});
				}}



    }

        public void startGameClientThread() {
            gameClientThread = new Thread((Runnable) this);
            gameClientThread.start();
        }
    }

