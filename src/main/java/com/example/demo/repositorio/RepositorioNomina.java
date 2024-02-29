package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Nómina;

@Repository
public interface RepositorioNomina extends JpaRepository< Nómina, Long  >{

	public List <Nómina> findByMes(int mes);
	
	public List <Nómina> findBySalario(int salario);
	
	public List<Nómina> findByEmpleados(Empleado e);
	
	@Query (value = "Select sum(n.salario) as Salario_Total, n.id_empleado, e.nombre, e.apellido from nomina n inner join empleados e " 
			+ "on n.id_empleado = e.identificacion group by n.id_empleado", nativeQuery = true  )
	public List <Object> NominaporAño();
	
	@Query (value = "Select sum(n.salario) as Nomina_Mensual, n.mes from nomina n join empleados e " 
			+ "on n.id_empleado = e.identificacion group by n.mes", nativeQuery = true  )
	public List <Object> NominaporMes();
	

	@Query (value = "Select e.identificacion, e.nombre, e.apellido, count(e.identificacion) as Pagos from empleados e\r\n"
			+ "inner join nomina n on e.identificacion = n.id_empleado\r\n"
			+ "group by e.identificacion, e.nombre, e.apellido", nativeQuery = true )
	public List <Object>PagosTotales();
	
}


