package com.example.demo.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Nomina")

public class Nómina {
	
	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Long id;
 	
 	@Column(name = "Mes")
 	private int mes;
 	
 	@Column (name = "Salario")
 	private int salario;
 	
 	@ManyToOne(cascade = CascadeType.ALL)
 	@JoinColumn(name = "Id_Empleado", referencedColumnName="identificacion")
 	private Empleado empleados;
 	
 	
	public Nómina() {
		
	}


	public Nómina( int mes, int salario, Empleado empleados) {
		
		this.mes = mes;
		this.salario = salario;
		this.empleados = empleados;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getMes() {
		return mes;
	}



	public void setMes(int mes) {
		this.mes = mes;
	}



	public int getSalario() {
		return salario;
	}



	public void setSalario(int salario) {
		this.salario = salario;
	}



	public Empleado getEmpleados() {
		return empleados;
	}



	public void setEmpleados(Empleado empleados) {
		this.empleados = empleados;
	}
 	
 	
}
