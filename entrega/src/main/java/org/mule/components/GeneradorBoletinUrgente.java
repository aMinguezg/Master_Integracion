package org.mule.components;

import org.mule.entities.Pedido;

public class GeneradorBoletinUrgente {
	
public String generarBoletinUrgente(Pedido pedido) {
		
		System.out.println("Boletin urgente pedido - "+pedido.getIsbn());
		
		
		StringBuffer  bf = new StringBuffer();
		bf.append("ENVIO URGENTE\n\n");
		bf.append("-------------------------------------------");
		bf.append("\n");
		bf.append("PEDIDO, "+ pedido.getIsbn());
		bf.append("\n");
		bf.append("CLIENTE - "+ pedido.getCliente());
	
		return bf.toString();

	}

}
