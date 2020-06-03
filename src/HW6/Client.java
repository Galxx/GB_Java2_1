package HW6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 8189;

    private static Socket socket;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static boolean close;

    public static void main(String[] args) throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        close = false;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Подключились к серверу");
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    while (!close) {
                        String str = in.readUTF();
                        if (str.equals("/end"))  {
                            close = true;
                            break;
                        }
                        System.out.println("Сервер: " + str);
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
    }

}


