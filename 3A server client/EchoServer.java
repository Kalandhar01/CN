import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class EchoServer
    {
    public EchoServer(int portnum)
    {
    try
    {
    server = new ServerSocket(portnum);
    }
    catch (Exception err)
    {
    System.out.println(err);

    }
    }
    public void serve()
    {
    try
    {
    while (true)
    {
    Socket client = server.accept();
    BufferedReader r = new BufferedReader(new
    InputStreamReader(client.getInputStream()));
    PrintWriter w = new PrintWriter(client.getOutputStream(), true);
    w.println("Welcome to the Java EchoServer. Type 'bye' to close.");
    String line;
    // G:\My Drive\CN\3A SERVER CLIENT
    do
    {
    line = r.readLine();
    if ( line != null )
    w.println("Got: "+ line);
    }
    while ( !line.trim().equals("bye") );
    client.close();
    }
    }
    catch (Exception err)
    {
    System.err.println(err);
    }
    }

    public static void main(String[] args)
    {
    EchoServer s = new EchoServer(9999);
    s.serve();
    }
    private ServerSocket server;
    }
