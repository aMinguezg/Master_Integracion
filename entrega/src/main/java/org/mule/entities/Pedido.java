package org.mule.entities;


public class Pedido {

	private String nif;
	private String cliente;
	private boolean financia;
	private int isbn;
	private int cantidad;
	
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public boolean isFinancia() {
		return financia;
	}
	public void setFinancia(boolean financia) {
		this.financia = financia;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

}
