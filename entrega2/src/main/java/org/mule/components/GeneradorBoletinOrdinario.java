package org.mule.components;

import org.mule.entities.Pedido;

public class GeneradorBoletinOrdinario {

	
public String generarBoletinOrdinario(Pedido pedido) {
		
		System.out.println("Boletin ordinario pedido - "+pedido.getIsbn());
		
		
		StringBuffer  bf = new StringBuffer();
		bf.append("ENVIO ORDINARIO\n\n");
		bf.append("-------------------------------------------");
		bf.append("\n");
		bf.append("PEDIDO, "+ pedido.getIsbn());
		bf.append("\n");
		bf.append("CLIENTE - "+ pedido.getCliente());
	
		return bf.toString();

	}
}
