package HW6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static ServerSocket serverSocket;
    private static Socket socket;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static boolean close;

    public static void main(String[] args) throws IOException {

        serverSocket = new ServerSocket(8189);
        System.out.println("Сервер запущен, ожидаем подключения...");
        socket = serverSocket.accept();
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
        close = false;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Клиент подключился");
                    while (!close) {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            close = true;
                            break;
                        }
                        System.out.println("Клиент: " + str);
                    }
                    if (close){
                        closeConnection();
                    }
                } catch (IOException e) {
                    closeConnection();
                    e.printStackTrace();
                }
            }
        }).start();

        while (true) {
            Scanner s = new Scanner(System.in);
            String str = s.nextLine();
            if(close){
                break;
            }else {
                out.writeUTF(str);
                if (str.equals("/end")) {
                     close = true;
                     break;
                }
            }
        }

    }

    public static void closeConnection() {
        try {
            in.close();
            System.out.println("Закрыли in");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
            System.out.println("Закрыли out");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
            System.out.println("Закрыли socket");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            serverSocket.close();
            System.out.println("Закрыли serverSocket");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
