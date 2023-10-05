// Server Program(ECHO):
import java.net.*;
import java.io.*;
public class EServer {
public static void main(String args[]) {
try {
ServerSocket s = new ServerSocket(9000);
String line;
Socket c = s.accept();
DataInputStream is = new DataInputStream(c.getInputStream());
PrintStream ps = new PrintStream(c.getOutputStream());
while (true) {
line = is.readLine();
ps.println(line);
}
} catch (IOException e) {
System.out.println(e);
}
}
}
// Client Program (ECHO):
import java.net.*;
import java.io.*;
public class EClient {
public static void main(String arg[]) {
try {
InetAddress ia = InetAddress.getLocalHost();
Socket c = new Socket(ia, 9000);
String line;
PrintStream os = new PrintStream(c.getOutputStream());
DataInputStream is = new DataInputStream(System.in);
DataInputStream is1 = new DataInputStream(c.getInputStream());
while (true) {
System.out.println("Client:");
line = is.readLine();
os.println(line);
System.out.println("Server:" + is1.readLine());
}
} catch (IOException e) {
System.out.println("Socket Closed!");
}
}
}
