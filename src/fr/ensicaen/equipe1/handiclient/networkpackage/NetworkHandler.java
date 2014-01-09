package fr.ensicaen.equipe1.handiclient.networkpackage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public final class NetworkHandler {
	private static NetworkHandler _instance = new NetworkHandler();
	static final int serverPort = 6942;
	static String serverName = "localhost";

	private NetworkHandler() {

	}

	public static NetworkHandler getInstance() {
		return _instance;
	}

	public static void setServerName(String newName) {
		serverName = newName;
	}

	public boolean withdrawMoney(String id, int money) {

		/*Socket socket = new Socket(serverName, serverPort);
		  ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		  ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

		  out.flush();
		  out.writeObject(id);
		  out.writeObject(money);
		  out.flush();

		  boolean validation = (boolean)in.readObject();

		  try {
		  Thread.sleep(1000);
		  } catch(InterruptedException ex) {
		  Thread.currentThread().interrupt();
		  }
		  out.close();
		  in.close();
		  socket.close();

		  return validation;
		  */

		return true;
	}

	public void addUser(String id, String name, int balance) {
		/*Socket socket = new Socket(serverName, serverPort);
		  ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

		  out.flush();
		  out.writeObject(id);
		  out.writeObject(name);
		  out.writeObject(balance);
		  out.flush();

		  try {
		  Thread.sleep(1000);
		  } catch(InterruptedException ex) {
		  Thread.currentThread().interrupt();
		  }
		  out.close();
		  socket.close();

		  return validation;*/
	}

	public String getName(String id) {
		/*ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		  ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

		  out.flush();
		  out.writeObject(id);
		  out.flush();

		  String returnedName = (String)in.readObject();

		  try {
		  Thread.sleep(1000);
		  } catch(InterruptedException ex) {
		  Thread.currentThread().interrupt();
		  }
		  out.close();
		  in.close();
		  socket.close();

		  return returnedName;*/
		return "Name";
	}

	public int getBalance(String id) {
		/*ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		  ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

		  out.flush();
		  out.writeObject(id);
		  out.flush();

		  double returnedBalance = (double)in.readObject();
		  try {
		  Thread.sleep(1000);
		  } catch(InterruptedException ex) {
		  Thread.currentThread().interrupt();
		  }
		  out.close();
		  in.close();
		  socket.close();

		  return returnedBalance;*/
		return 1;
	}

	public boolean testUser(String id){
		/*ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		  ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

		  out.flush();
		  out.writeObject(id);
		  out.flush();

		  boolean test = (boolean)in.readObject();
		  try {
		  Thread.sleep(1000);
		  } catch(InterruptedException ex) {
		  Thread.currentThread().interrupt();
		  }
		  out.close();
		  in.close();
		  socket.close();

		  return test;*/
		return true;
	}
}
