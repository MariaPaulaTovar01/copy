package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Empleado;


@Repository
public interface RepositorioEmpleado extends JpaRepository <Empleado, Long> {

	public Empleado findByNombre(String nombre);
	
	public Empleado findByApellido(String apellido);
	
	public Empleado findByCorreo (String correo);
	
	@Query(value = "Select count(*) as Cantidad_Empleados from empleados;", nativeQuery = true)
	public List <Object> ContarEmpleados();
	
	
}
