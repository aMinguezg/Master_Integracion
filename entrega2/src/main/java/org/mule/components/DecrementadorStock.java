package org.mule.components;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.mule.entities.Pedido;

public class DecrementadorStock {

	private Properties stock = new Properties();
	private Properties deuda = new Properties();
	private Properties pedidos = new Properties();

	public DecrementadorStock() throws IOException {
		FileInputStream inStream = new FileInputStream("src/stock.properties");	
		stock.load(inStream);
		inStream.close();
		FileInputStream inStream2 = new FileInputStream("src/deuda.properties");	
		deuda.load(inStream2);
		inStream2.close();
		FileInputStream inStream3 = new FileInputStream("src/pedidos.properties");	
		pedidos.load(inStream3);
		inStream3.close();
	}


	public Object decrementarStock(Pedido pedido) {

		String isbn = String.valueOf(pedido.getIsbn());
		if(isbn.length() == 9) {
			isbn = 0 + isbn;
		}
		int stockMenos = Integer.parseInt(stock.getProperty(isbn)) - 1;

		if(deuda.getProperty(pedido.getNif()) == null) {
			System.out.println("No existe el cliente");
			pedido.setDeuda(0);
		}
		else {
			pedido.setDeuda(Integer.parseInt(deuda.getProperty(pedido.getNif())));
		}

		int gasto = Integer.parseInt(pedidos.getProperty(pedido.getNif()));

		if(gasto > 2000) {
			pedido.setVip(true);
		}
		else {
			pedido.setVip(false);
		}


		stock.setProperty(isbn, String.valueOf(stockMenos));

		System.out.println("Se ha decrementado el stock del producto: " + pedido.getIsbn() + ", ahora hay " + stockMenos + " unidades");

		return pedido;

	}


}
