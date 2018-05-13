package server1;

import java.rmi.RemoteException;
import java.util.Enumeration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;

public class Client {
	public static void main(String[] args) throws NamingException, RemoteException {
		Context context = new InitialContext();
		// вывод всех приложений, зарегистрированных в контексте
		Enumeration<NameClassPair> e = context.list("rmi://localhost/");
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement().getName());
		}
		Imath iMath = (Imath) context.lookup("rmi://localhost/imath");
		int result = iMath.add(3, 5);
		System.out.println("Result: " + result);
	}
}
