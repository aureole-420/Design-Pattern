package provided.hello;

import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerProcess1 {
	
	public ServerProcess1() {
		
	}
	
	public static final int SERVER_PORT = 2101;
	
	private RMIUtilsBasic rmiUtils = new RMIUtilsBasic();
	
	private Registry registry;
	
	// RMI server
	private IHello helloServer = new HelloImpl();
	//private IHello preyServer = new PreyImpl();
	
	// run the server;
	public void run() {
		try { // try start the server and get a local registry
			rmiUtils.startRMI();
			registry = rmiUtils.getLocalRegistry();
		}
		catch (Exception e) {
			System.err.println("Exception while initializing RMI: \n" + e);
			e.printStackTrace();
			System.exit(-1); // exit the program.
		}
		
		try {
			// create a UnicastRemoteObject stub from RMI server implementation to be sent to the clients.
			IHello helloStub = (IHello) UnicastRemoteObject.exportObject(helloServer, SERVER_PORT+1); 
			registry.rebind("Hello1", helloStub);
			System.err.println("Server ready!");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
			System.exit(-1);
		}
		
		while (true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.err.println("Exception while sleeping: " + e);
			}
		}
	}
	
	public static void main(String args[]) {
		(new ServerProcess1()).run();

	}
}
