package com.rodriguez.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "publicacion")

public class Publicacion {

	@Id

	private String idpublicacion;

	private String titulo;

	private String autor;

	private int nroedicion;

	private double precio;

	private int stock;

	@ManyToOne

	@JoinColumn(name = "idtipo")

	private Tipo tipo;

	public Publicacion() {
	}

	public String getIdpublicacion() {
		return idpublicacion;
	}

	public void setIdpublicacion(String idpublicacion) {
		this.idpublicacion = idpublicacion;
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

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}