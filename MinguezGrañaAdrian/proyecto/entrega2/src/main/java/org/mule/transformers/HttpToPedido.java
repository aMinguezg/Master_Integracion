package org.mule.transformers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

import org.mule.api.transformer.TransformerException;
import org.mule.entities.Pedido;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

public class HttpToPedido extends AbstractTransformer {

	public HttpToPedido()
	{
		this.registerSourceType(DataTypeFactory.STRING);
		this.setReturnDataType(DataTypeFactory.create(Pedido.class));
	}
	
	@Override
	protected Object doTransform(Object src, String encoding)
			throws TransformerException {
		Pedido pedido = new Pedido();
		String cadena="";
		boolean financia;
		try {
			cadena = URLDecoder.decode(((String) src),encoding);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Recibido: "+cadena);
		int comienzo = cadena.indexOf("?");
		if ( comienzo == -1 )
		{
			return pedido;
		}
		String queryString = cadena.substring(comienzo +1);
		System.out.println("QueryString: "+cadena);
		HashMap<String,String> parametros = new HashMap<String,String>();
		String[] pares = queryString.split("&");
		for ( int i = 0 ; i < pares.length ; i ++ )
		{
			String[] item = pares[i].split("=");
			if ( item.length>1 )
				parametros.put(item[0],item[1]);
		}
		if(parametros.get("financia").equals("S")) {
			financia = true;
		}
		else {
			financia = false;
		}
		if(parametros.get("nif") == null || parametros.get("nif") == "") {
			pedido.setNif("9999999999Z");
		}
		else {
			pedido.setNif(parametros.get("nif"));
		}
		if(parametros.get("nombre") == null || parametros.get("nombre") == "") {
			pedido.setCliente("Desconocido");
		}
		else {
			pedido.setCliente(parametros.get("nombre"));
		}

		pedido.setFinancia(financia);
		pedido.setIsbn(Integer.parseInt(parametros.get("isbn")));
		pedido.setCantidad(Integer.parseInt(parametros.get("cantidad")));

		System.out.println("Transformado "+cadena+" en "+pedido.toString());
		return pedido;
	}

}
