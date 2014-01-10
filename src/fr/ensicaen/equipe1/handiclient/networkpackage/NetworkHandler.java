package fr.ensicaen.equipe1.handiclient.networkpackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import android.os.AsyncTask;
import android.util.Log;

public final class NetworkHandler {
	
	private static NetworkHandler _instance = new NetworkHandler();
	static final int serverPort = 6942;
	static String serverName ="192.168.235.1";
	Socket socket;
	

	String id;
	int money;
	String name;
	Boolean validation;

	
	
	/*
	 * Access exemple
	NetworkHandler n = NetworkHandler.getInstance();
	Log.i("TEST : WithdrawMoney : ", n.getWithdraw().execute().toString());
	Log.i("TEST : addUser : ", n.getAddUser().execute().toString());
	Log.i("TEST : getName : ", n.getGetName().execute().toString());
	Log.i("TEST : getBalance : ", n.getGetBalance().execute().toString());
	Log.i("TEST : testUser : ", n.getGetGetGetGetGetTestUser().execute().toString());
	*/
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getValidation() {
		return validation;
	}


	
	private NetworkHandler() {}
	
	
	
	public static NetworkHandler getInstance() {
		return _instance;
	}

	public static void setServerName(String newName) {
		serverName = newName;
	}
	
	public Withdraw getWithdrawFunction() {
		return new Withdraw();
	}
	
	public addUser getAddUserFunction(){
		return new addUser();
	}
	
	public getName getGetNameFunction(){
		return new getName();
	}
	
	public getBalance getGetBalanceFunction(){
		return new getBalance();
	}
	
	public testUser getTestUserFunction(){
		return new testUser();
	}
	
	public class Withdraw extends AsyncTask<Void, Void, Void>{	
		
		public Withdraw(){}
		
		public Boolean withdrawMoney(String id, int money) throws IOException, ClassNotFoundException  {

			  try {
				  Log.i("sock", "socket");

				  socket = new Socket();
				  InetAddress servAddr = InetAddress.getByName(serverName);
				  SocketAddress remoteAddr = new InetSocketAddress(servAddr, serverPort);
				  socket.connect(remoteAddr, 12000);
				  
				  //socket = new Socket(servAddr, serverPort);
				  Log.i("sock", "socket");
			} catch (UnknownHostException e) {
				Log.i("e", e.getClass().getName().toString()+" : "+e.getMessage().toString());
				e.printStackTrace();
			} catch (IOException e) {
				Log.i("e", e.getClass().getName().toString()+" : "+e.getMessage().toString());
				e.printStackTrace();
			}
			  
			  ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			  ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			  out.flush();
			  out.writeObject(0);
			  out.writeObject(id);
			  out.writeObject((double)money);
			  out.flush();

			  Boolean validation = (Boolean)in.readObject();

			  try {
			  Thread.sleep(1000);
			  } catch(InterruptedException ex) {
			  Thread.currentThread().interrupt();
			  }
			  out.close();
			  in.close();
			  socket.close();

			  return validation;
		}
			
		
		@Override
		protected Void doInBackground(Void... arg0) {
			try {
				validation =  withdrawMoney(id, money);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	}

	public class addUser extends AsyncTask<Void, Void, Void>{
		
		public addUser(){
			
		}
		
		public void addUserPohPoh(String id, String name, int balance) throws IOException {
			
			 try {

				  socket = new Socket();
				  InetAddress servAddr = InetAddress.getByName(serverName);
				  SocketAddress remoteAddr = new InetSocketAddress(servAddr, serverPort);
				  socket.connect(remoteAddr, 12000);
				  
				  //socket = new Socket(servAddr, serverPort);
				  Log.i("sock", "socket");
			} catch (UnknownHostException e) {
				Log.i("e", e.getClass().getName().toString()+" : "+e.getMessage().toString());
				e.printStackTrace();
			} catch (IOException e) {
				Log.i("e", e.getClass().getName().toString()+" : "+e.getMessage().toString());
				e.printStackTrace();
			}
			  
			  ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			  ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			  out.flush();
			  out.writeObject(2);
			  out.writeObject(id);
			  out.writeObject(name);
			  out.writeObject((double)balance);
			  out.flush();

			  try {
			  Thread.sleep(1000);
			  } catch(InterruptedException ex) {
			  Thread.currentThread().interrupt();
			  }
			  out.close();
			  in.close();
			  socket.close(); 

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			try {
				addUserPohPoh(id, name, money);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	
	public class getName extends AsyncTask<Void, Void, Void>{

		public getName(){}
		
		public String getNamePouet(String id) throws IOException, ClassNotFoundException {

			 try {

				  socket = new Socket();
				  InetAddress servAddr = InetAddress.getByName(serverName);
				  SocketAddress remoteAddr = new InetSocketAddress(servAddr, serverPort);
				  socket.connect(remoteAddr, 12000);
				  
				  //socket = new Socket(servAddr, serverPort);
				  Log.i("sock", "socket");
			} catch (UnknownHostException e) {
				Log.i("e", e.getClass().getName().toString()+" : "+e.getMessage().toString());
				e.printStackTrace();
			} catch (IOException e) {
				Log.i("e", e.getClass().getName().toString()+" : "+e.getMessage().toString());
				e.printStackTrace();
			}
			  
			  ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			  ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			  out.flush();
			  out.writeObject(3);
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

			  return returnedName;
			
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			try {
				name = getNamePouet(id);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	}
	
	public class getBalance extends AsyncTask<Void, Void, Void>{
		
		public Double gonnaGetBalance(String id) throws UnknownHostException, IOException, ClassNotFoundException {
			socket = new Socket(serverName, serverPort);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			  ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			  out.flush();
			  out.writeObject(4);
			  out.writeObject(id);
			  out.flush();

			  Double returnedBalance = (Double)in.readObject();
			  try {
			  Thread.sleep(1000);
			  } catch(InterruptedException ex) {
			  Thread.currentThread().interrupt();
			  }
			  out.close();
			  in.close();
			  socket.close();

			  return returnedBalance;
		}
		
		@Override
		protected Void doInBackground(Void... arg0) {
			try {
			money = gonnaGetBalance(id).intValue();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			return null;
		}
		
	}
	
	public class testUser extends AsyncTask<Void, Void, Void>{
		
		Boolean test;
		
		public Boolean YoupieTestUser(String id) throws ClassNotFoundException, IOException{

			try {

				socket = new Socket();
				InetAddress servAddr = InetAddress.getByName(serverName);
				SocketAddress remoteAddr = new InetSocketAddress(servAddr, serverPort);
				socket.connect(remoteAddr, 12000);

				//socket = new Socket(servAddr, serverPort);
				Log.i("sock", "socket");
			} catch (UnknownHostException e) {
				Log.i("e", e.getClass().getName().toString()+" : "+e.getMessage().toString());
				e.printStackTrace();
			} catch (IOException e) {
				Log.i("e", e.getClass().getName().toString()+" : "+e.getMessage().toString());
				e.printStackTrace();
			}

			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			out.flush();
			out.writeObject(1);
			out.writeObject(id);
			out.flush();

			Boolean test = (Boolean)in.readObject();

			try {
				Thread.sleep(1000);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			out.close();
			in.close();
			socket.close(); 		  

			return test;
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			try {
				test = YoupieTestUser(id);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return null;
		}
	}


	


//	@Override
//	protected Void doInBackground(Void... arg0) {
//		// TODO Auto-generated method stub
//		NetworkHandler n = NetworkHandler.getInstance();
//		try {
//			Boolean b =  n.withdrawMoney("111", 20);
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			n.addUser("111", "name", 20);
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			String getName = n.getName("111");
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			Double getBalance = getBalance("111");
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			testUser("111");
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		return null;
//	}
}

