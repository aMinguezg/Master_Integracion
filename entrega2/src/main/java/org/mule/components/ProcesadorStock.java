package org.mule.components;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.mule.entities.Pedido;

public class ProcesadorStock {

	
	private Properties stock = new Properties();
	
	public ProcesadorStock() throws IOException {
		FileInputStream inStream = new FileInputStream("src/stock.properties");	
		stock.load(inStream);
		inStream.close();
	}
	
	public Object comprobarStock(Pedido pedido) {
		
		String isbn = String.valueOf(pedido.getIsbn());
		if(isbn.length() == 9) {
			isbn = 0 + isbn;
		}
		String message = "pedido: Cliente - " + pedido.getCliente() + "; nif - " + pedido.getNif()+ "; isbn - " + isbn;
		
		if(stock.getProperty(isbn) != null) {
			int cantidad = Integer.parseInt(stock.getProperty(isbn));
			
			if(cantidad > 0) {
				pedido.setDisponible(true);
				System.out.println("Hay stock del "+message);
			}
			
			else {
				pedido.setDisponible(false);
				System.out.println("No hay stock del "+message);
			}
		}
		else {
			pedido.setDisponible(false);
			System.out.println("No existe ningún producto con ese ISBN");
		}
		
		
		
		return pedido;
		
	}
	
}
