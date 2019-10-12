package org.mule.transformers;

import java.util.Collection;
import java.util.Vector;

import org.mule.api.transformer.TransformerException;
import org.mule.entities.Pedido;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

public class FileToPedido extends AbstractTransformer {

	public FileToPedido()
	{
		this.registerSourceType(DataTypeFactory.STRING);
		this.setReturnDataType(DataTypeFactory.create(Collection.class));
	}
	
	@Override
	protected Object doTransform(Object src, String encoding)
			throws TransformerException {
		System.out.println("Entrando en el transformador con "+src);
		Vector<Pedido> resultado = new Vector<Pedido>();
		String [] datos = ((String) src).split("\n");
		String cliente = "";
		String nif = "";
		boolean financia = true;
		for ( int i = 0 ; i < datos.length ; i ++)
		{
			if (i != 0 && i != 2) {
				String[] detalle = datos[i].split(";");
				if(i == 1) {
					nif = detalle[0];
					cliente = detalle[1];
					if(detalle[2].equals("S")) {
						financia = true;
					}
					else {
						financia = false;
					}
				}
				else {
					Pedido pedido = new Pedido();
					pedido.setCliente(cliente);
					pedido.setNif(nif);
					pedido.setFinancia(financia);
					pedido.setIsbn(Integer.parseInt(detalle[0]));
					pedido.setCantidad(Integer.parseInt(detalle[1]));
					resultado.add(pedido);
				}
			}
		}
		System.out.println("Datos transformados "+resultado);
		return resultado;
	}

}
