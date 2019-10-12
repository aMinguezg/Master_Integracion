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
		for ( int i = 0 ; i < datos.length ; i ++)
		{
			/*String[] detalle = datos[i].split(";");
			Pedido orden = new Pedido();
			orden.setNombre(detalle[0]);
			orden.setApellidos(detalle[1]);
			orden.setCif(detalle[2]);
			orden.setDireccion(detalle[3]);
			orden.addProducto("producto1", new Integer(detalle[4].trim()));
			orden.addProducto("producto2", new Integer(detalle[5].trim()));
			orden.addProducto("producto3", new Integer(detalle[6].trim()));
			orden.addProducto("producto4", new Integer(detalle[7].trim()));
			resultado.add(orden);*/
		}
		System.out.println("Datos transformados "+resultado);
		return resultado;
	}

}
