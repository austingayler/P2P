package roboslave.p2p;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TangoP2PServer extends AsyncTask {

    private Context context;
    private TextView statusText;

    public TangoP2PServer(Context context, View statusText) {
        this.context = context;
        this.statusText = (TextView) statusText;
    }

    @Override
    protected String doInBackground(Object[] params) {
        try {

            /**
             * Create a server socket and wait for client connections. This
             * call blocks until a connection is accepted from a client
             */
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket client = serverSocket.accept();

            /**
             * If this code is reached, a client has connected and transferred data
             * Save the input stream from the client as a JPEG file
             */

            InputStream inputstream = client.getInputStream();
            int cmd = inputstream.read();

            sendCommand(cmd);

            serverSocket.close();
            return Integer.toString(cmd);
        } catch (IOException e) {
            return null;
        }
    }

    private void sendCommand(int cmd) {
    }

    /**
     * Start activity that can handle the JPEG image
     */
//    @Override
//    protected void onPostExecute(String result) {
//        if (result != null) {
//            statusText.setText("File copied - " + result);
//            Intent intent = new Intent();
//            intent.setAction(android.content.Intent.ACTION_VIEW);
//            intent.setDataAndType(Uri.parse("file://" + result), "image/*");
//            context.startActivity(intent);
//        }
//    }

}
