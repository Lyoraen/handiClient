package fr.ensicaen.equipe1.handiclient.networkpackage;

public final class NetworkHandler {
	private static NetworkHandler _instance = new NetworkHandler();

	private NetworkHandler() {
		
	}

	public static NetworkHandler getInstance() {
		return _instance;
	}
	
	public boolean withdrawMoney(int money) {
		return true;
	}
	
	public boolean addUser(String name, int balance) {
		return true;
	}
	
	public String getName() {
		return "Name";
	}
	
	public int getBalance() {
		return 1;
	}

	public int getPersonalisation() {
		return 0;
	}
}
