package dao;

import main.GamePanel;
import main.KeyHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GameServer implements Runnable {
    private static final int PORT= 12345;
    private KeyHandler keyHandler;
    private GamePanel gp;

    public GameServer(GamePanel gp) {
        this.gp = gp;

    }

    public void startGameServerThread() {
        Thread gameServerThread = new Thread((Runnable) this);
        gameServerThread.start();
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server listening on port " + PORT);
            keyHandler = gp.keyH; // Khởi tạo keyHandler

            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket, keyHandler).start(); // Truyền keyHandler vào ClientHandler
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class ClientHandler extends Thread{
    private KeyHandler keyHandler;
    private Socket socket;
    public ClientHandler(Socket socket, KeyHandler keyHandler) {
        this.socket = socket;
        this.keyHandler = keyHandler;    }
    public void run(){
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            String request= (String) in.readObject();
            if(request.equals("GET_LEADERBOARD")){
                HightScoreDao dao = HightScoreDao.getInstance();
                String currentMap = keyHandler.getMap();
                System.out.println(currentMap);
                ArrayList<HightScoreB> scores = dao.selectAll(currentMap);
                out.writeObject(scores);
            } else if (request.startsWith("INSERT_SCORE")) {
                String[] parts = request.split(":");
                String name = parts[1];
                String time = parts[2];
                String map = parts[3];
                HightScoreDao dao = HightScoreDao.getInstance();
                dao.insert(new HightScoreB(name, time, map));
                out.writeObject("SUCCESS");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
