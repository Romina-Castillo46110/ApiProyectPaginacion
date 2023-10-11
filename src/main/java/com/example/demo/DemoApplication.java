package com.example.demo;

import com.example.demo.entities.*;
import com.example.demo.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	AutorRepository autorRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	LibroRepository libroRepository;
	@Autowired
	LocalidadRespository localidadRespository;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Corriendo mi Api");
	}

	/*@Bean
	public CommandLineRunner init() {
		return args -> {
			System.out.println("------------------------Estoy Funcionando------------------------");
			Persona persona1 = new Persona();
			persona1.setApellido("Rodriguez");
			persona1.setDni(46110);
			persona1.setNombre("Melisa");
			//creo un libro
			Libro libro1 = new Libro();
			libro1.setGenero("Romance");
			libro1.setFecha(new Date());
			libro1.setPaginas(336);
			libro1.setTitulo("Persuasion");
			//asocio con persona
			persona1.agregarLibro(libro1);
			//creo un autor
			Autor autor1 = new Autor();
			autor1.setApellido("Austen");
			autor1.setNombre("Jane");
			autor1.setBibliografia("Jane Austen fue una novelista británica que vivió durante la época georgiana");
			//creo un Domicilio
			Domicilio domicilio1 = new Domicilio();
			domicilio1.setCalle("Libertad");
			domicilio1.setNumero(1176);
			domicilio1.agregarAutor(autor1);
			//asocio persona con Domicilio
			persona1.setDomicilio(domicilio1);
			//creo una localidad
			Localidad localidad1 = new Localidad();
			localidad1.setDenominacion("Ciudad");
			//asocio con domicilio
			domicilio1.agregarLocalidad(localidad1);


			personaRepository.save(persona1);
			autorRepository.save(autor1);
			domicilioRepository.save(domicilio1);
			libroRepository.save(libro1);
			localidadRespository.save(localidad1);
		};

	}*/
}


