package com.rodriguez.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venta")

public class Venta {

	@Id
	private String idventa;

	private String cliente;

	private int cantidad;

	private double precio;

	private double dcto;

	private double impuesto;
	
	private Date fecha;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@ManyToOne
	@JoinColumn(name = "idpublicacion")

	private Publicacion publicacion;

	@ManyToOne
	@JoinColumn(name = "idempleado")

	private Empleado empleado;

	public Venta() {
	}

	public String getIdventa() {
		return idventa;
	}

	public void setIdventa(String idventa) {
		this.idventa = idventa;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getDcto() {
		return dcto;
	}

	public void setDcto(double dcto) {
		this.dcto = dcto;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public void setTotal(double total) {
		// TODO Auto-generated method stub
		
	}

}