package provided.hello;

import java.rmi.RemoteException;

/**
 * RMI "Server" object implementation.
 * 
 * @author Stephen Wong
 *
 */
public class PreyImpl implements IHello {

	@Override
	/**
	 * Concrete implementation of the method defined by the Hello interface.
	 */
	public String sayHello() throws RemoteException {
		//return "Hello RMI World!";
		return "Prey for Gordon Hayward!";
	}

}
