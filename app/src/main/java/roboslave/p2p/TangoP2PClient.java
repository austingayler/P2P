package roboslave.p2p;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by AJ on 4/23/2016.
 */
public class TangoP2PClient {

    String host;
    int port;
    Context context;
    Socket socket;

    public TangoP2PClient(String addr, int port, Context ctx, Socket skt) {
        this.host = addr;
        this.port = port;
        this.context = ctx;
        this.socket = skt;
    }

    void sendCommand(int msg) {
        Toast.makeText(context.getApplicationContext(), "tryna write " + Integer.toString(msg), Toast.LENGTH_SHORT).show();
        try {
            /**
             * Create a client socket with the host,
             * port, and timeout information.
             */
            socket.bind(null);
            socket.connect((new InetSocketAddress(host, port)), 500);

            /**
             * Create a byte stream from a JPEG file and pipe it to the output stream
             * of the socket. This data will be retrieved by the server device.
             */
            OutputStream outputStream = socket.getOutputStream();

            outputStream.write(1); //make 1 w?

            outputStream.close();
        } catch (IOException e) {
            //catch logic
        }

        finally {
            if (socket != null) {
                if (socket.isConnected()) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        //catch logic
                    }
                }
            }
        }
    }
}
