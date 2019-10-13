package org.mule.components;

import org.mule.entities.Pedido;

public class GeneradorConcesionCredito {

	
	
	public String generarConcesionCredito(Pedido pedido) {
		
		System.out.println("Se ha concedido la financiación a "+pedido.getCliente());
		
		
		StringBuffer  bf = new StringBuffer();
		bf.append("Se ha concedido la financiación\n\n");
		bf.append("-------------------------------------------");
		bf.append("\n");
		bf.append("Beneficiari@, "+ pedido.getCliente());
		bf.append("\n");
	
		return bf.toString();

	}
}
