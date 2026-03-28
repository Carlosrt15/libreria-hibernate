package com.rodriguez.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "promocion")

public class Promocion {

	@Id

	private int idpromocion;

	@Column(name = "cantmin")

	private int cantmin;

	@Column(name = "cantmax")

	private int cantmax;

	@Column(name = "porcentaje")

	private double porcentaje;

	public Promocion() {
	}

	public int getIdpromocion() {

		return idpromocion;

	}

	public void setIdpromocion(int idpromocion) {

		this.idpromocion = idpromocion;

	}

	public int getCantmin() {

		return cantmin;

	}

	public void setCantmin(int cantmin) {

		this.cantmin = cantmin;

	}

	public int getCantmax() {

		return cantmax;

	}

	public void setCantmax(int cantmax) {

		this.cantmax = cantmax;

	}

	public double getPorcentaje() {

		return porcentaje;

	}

	public void setPorcentaje(double porcentaje) {

		this.porcentaje = porcentaje;

	}

}