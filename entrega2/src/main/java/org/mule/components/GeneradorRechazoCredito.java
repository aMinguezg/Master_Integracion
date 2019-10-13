package org.mule.components;

import org.mule.entities.Pedido;

public class GeneradorRechazoCredito {

public String generarRechazoCredito(Pedido pedido) {
		
		System.out.println("Se ha rechazado la financiación a "+pedido.getCliente());
		
		
		StringBuffer  bf = new StringBuffer();
		bf.append("Se ha rechazalo la financiación\n\n");
		bf.append("-------------------------------------------");
		bf.append("\n");
		bf.append("La deuda es superior a 2000 euros - "+ pedido.getDeuda());
		bf.append("\n");
		bf.append("cliente - "+ pedido.getCliente());
		bf.append("\n");
	
		return bf.toString();

	}
	
}
