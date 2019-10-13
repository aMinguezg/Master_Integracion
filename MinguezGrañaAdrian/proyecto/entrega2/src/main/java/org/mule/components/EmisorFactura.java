package org.mule.components;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.mule.entities.Pedido;

public class EmisorFactura {

	private Properties pedidos = new Properties();


	public EmisorFactura() throws IOException {
		FileInputStream inStream = new FileInputStream("src/pedidos.properties");	
		pedidos.load(inStream);
		inStream.close();
	}

	public String generarEmisionFactura(Pedido pedido) {

		System.out.println("Se ha generado la factura para: "+pedido.getCliente());


		StringBuffer  bf = new StringBuffer();
		bf.append("FACTURA\n\n");
		bf.append("-------------------------------------------");
		bf.append("\n");
		bf.append("Cliente - "+ pedido.getCliente());
		bf.append("\n");
		bf.append("NIF - "+ pedido.getNif());
		bf.append("\n");
		bf.append("PRODUCTO - "+ pedido.getIsbn());
		bf.append("\n");
		bf.append("Cantidad final a pagar: 50 euros");


		return bf.toString();

	}

}
