package com.example.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Nómina;
import com.example.demo.repositorio.RepositorioEmpleado;
import com.example.demo.repositorio.RepositorioNomina;

@RestController
@RequestMapping("/ver/e1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoControlador {

	@Autowired
	private RepositorioEmpleado repositorio;
	@Autowired
	private RepositorioNomina repoN;
	
	@GetMapping("/empleados")
	public List<Empleado> verTodosEmpleados(){
		
		return repositorio.findAll();
	}
	
	@PostMapping("/guardar")
	public Empleado guardarEmpleado(@RequestBody Empleado e){
	
		return this.repositorio.save(e);	
	}
	
	@PostMapping("/buscarId")
	public Empleado buscarEmpleadoId(@RequestBody Long id){
		return this.repositorio.findById(id).get();
	
}
	
	@PostMapping("/eliminarId")
	public Optional<Empleado> eliminarEmpleado (@RequestBody Long n){
			Empleado e = this.repositorio.findById(n).get();
			List<Nómina> nE=this.repoN.findByEmpleados(e);
			for(int i=0; i<nE.size();i++) {
					this.repoN.deleteById(nE.get(i).getId());
			}
			this.repositorio.deleteById(n);
		return Optional.empty();
	}
	
	@PostMapping("/actualizar")
	public Empleado actualizarDatos(@RequestBody Empleado e) {
		this.repositorio.save(e);
		return this.repositorio.findById(e.getId()).get();
	}
	
	@GetMapping("/actualizarCorreo")
	public Empleado actualizarCorreoEmpleado() {
		Empleado e = this.repositorio.findById(1260L).get();
		e.setCorreo("juanito@gmail.com");
		this.repositorio.save(e);
		
		return this.repositorio.findById(1260L).get();
}
	@GetMapping("/buscanombre")
	public Empleado buscarNombre(){
		return this.repositorio.findByNombre("Juan");
		
	}
	
	@GetMapping("/buscaapellido")
	public Empleado buscaAp() {
		return this.repositorio.findByApellido("GOMEZ");
	}
	
	@GetMapping("/buscacorreo")
	public Empleado buscaCorreo () {
		return this.repositorio.findByCorreo("CARE@GMAIL.COM");
	}
	
	@GetMapping ("/contar")
	public List<Object> contar() {
		return this.repositorio.ContarEmpleados();
	}
}

