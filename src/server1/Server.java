package server1;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Server {
	public static void main(String[] args) throws NamingException, RemoteException, MalformedURLException, AlreadyBoundException {
		Context context = new InitialContext();
		// выставл€ем на указанный порт экземпл€р объекта-обработчика
		context.bind("rmi://localhost:1099/imath", new ImathImpl());
		// альтернативный вариант байндинга (другое API - механизм тот же)
		//Naming.bind("imath", new ImathImpl());
	}
}

interface Imath extends Remote {
	int add(int a, int b) throws RemoteException;
}

class ImathImpl extends UnicastRemoteObject implements Imath {
	private static final long serialVersionUID = -6783931854505052381L;

	protected ImathImpl() throws RemoteException {
		super();
	}

	public int add(int a, int b) throws RemoteException {
		return a + b;
	}

}
