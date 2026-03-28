package com.rodriguez.dto;

public class PublicacionDTO {

	private String idpublicacion;

	private String titulo;

	private String autor;

	private int nroedicion;

	private double precio;

	private int stock;

	private String idtipo;

	public PublicacionDTO() {
	}

	public String getIdpublicacion() {
		return idpublicacion;
	}

	public void setIdpublicacion(String idpublicacion) {
		this.idpublicacion = idpublicacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNroedicion() {
		return nroedicion;
	}

	public void setNroedicion(int nroedicion) {
		this.nroedicion = nroedicion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(String idtipo) {
		this.idtipo = idtipo;
	}

}