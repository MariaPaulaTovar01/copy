package com.example.demo.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Nómina;
import com.example.demo.repositorio.RepositorioEmpleado;
import com.example.demo.repositorio.RepositorioNomina;

@RestController
@RequestMapping("/num/e2/")
@CrossOrigin(origins = "http://localhost/4200")
public class NominaControlador {
	
	@Autowired
	private RepositorioNomina repositorio1;
	@Autowired
	private RepositorioEmpleado repositorio;
	
	

	@GetMapping("/mostrar")
		public List<Nómina> verNomina(){
		return repositorio1.findAll();
	}
		
	@GetMapping ("/agregar")
	public List <Nómina>agregaNomina() {
		Empleado e = this.repositorio.findById(1261L).get();
		Nómina n = new Nómina (2, 4000000, e);
		this.repositorio1.save(n);
		return this.repositorio1.findAll();
	
}
	@GetMapping("/borrar")
	public String EliminaNomina() {
		long i = 7;
		this.repositorio1.deleteById(i);
		return "Eliminado";
	}
	
	@GetMapping("/refresh")
	public List<Nómina>actualizarN(){
		long i = 1;
		Nómina e = this.repositorio1.findById(i).get();
		e.setSalario(40000);
		this.repositorio1.save(e);
		return this.repositorio1.findAll();
	}
	
	@GetMapping ("/buscar")
	public Nómina BuscarId() {
		long n = 6 ;
		return this.repositorio1.findById(n).get();
	}
	
	@GetMapping ("/buscames")
	public List <Nómina> buscarMes() {
		return this.repositorio1.findByMes(2);
	}
	
	@GetMapping ("/buscasalario")
	public List <Nómina> buscapago() {
		return this.repositorio1.findBySalario(9000000);
	}
	
	@GetMapping("/nominaporempleado")
	public List <Object> nomPorEmpleado(){
		return this.repositorio1.NominaporAño();
	}
	
	@GetMapping("/nominapormes")
	public List <Object> nomPorMes(){
		return this.repositorio1.NominaporMes();
	}
	
	@GetMapping("/pagos")
	public List<Object>pagosT(){
		return this.repositorio1.PagosTotales();
	}

}
