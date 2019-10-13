package org.mule.components;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.mule.entities.Pedido;

public class RechazadorPedido {

	
	private Properties espera = new Properties();

	public RechazadorPedido() throws IOException {
		FileInputStream inStream = new FileInputStream("src/espera.properties");	
		espera.load(inStream);
		inStream.close();
	}
	
	public String rechazarPedido(Pedido pedido) {
		
		String isbn = String.valueOf(pedido.getIsbn());
		if(isbn.length() == 9) {
			isbn = 0 + isbn;
		}
		
		System.out.println("Se ha añadido el pedido "+pedido.getIsbn()+" a la lista de espera");
		espera.setProperty(isbn, "S");
		
		StringBuffer  bf = new StringBuffer();
		bf.append("Se ha rechazado el pedido" + isbn + " por falta de Stock\n\n");
		bf.append("-------------------------------------------");
		bf.append("\n");
		bf.append("Sentimos las molestias ocasionadas, "+ pedido.getCliente());
		bf.append("\n");
	
		return bf.toString();

	}
	
	
}
