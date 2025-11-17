package com.churi_dev.gestion_estudiante;

import com.churi_dev.gestion_estudiante.model.Estudiante;
import com.churi_dev.gestion_estudiante.servicio.EstudianteServicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class GestionEstudianteApplication implements CommandLineRunner {

	public final EstudianteServicio estudianteServico;

	public GestionEstudianteApplication(EstudianteServicio estudianteServicio) {
		this.estudianteServico = estudianteServicio;
	}

	public static void main(String[] args) {
		SpringApplication.run(GestionEstudianteApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Scanner readLine = new Scanner(System.in);

		boolean isSalir = false;
		int opcion;

		while (!isSalir) {
			try {
				MenuEstudiante();
				opcion = Integer.parseInt(readLine.nextLine());

				switch (opcion) {
					case 1:
						ListarEstudiantes(estudianteServico);
						break;
					case 2:
						BuscarPorId(estudianteServico, readLine);
						break;
					case 3:
						CrearEstudiante(estudianteServico, readLine);
						break;
					case 4:
						ModificarEstudiante(estudianteServico, readLine);
						break;
					case 5:
						ElimiarEstudiante(estudianteServico, readLine);
						break;
					case 6:
						isSalir = true;
						System.out.println("Cerrando sesion...");
					default:
						System.out.println("Opcion no encontrada");
				}

			} catch (NumberFormatException e) {
				System.out.println("Error: Ingrese un valor numerico");
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

	}

	private static void MenuEstudiante() {
		String menu =
				"""
				--- GESTION DE ESTUDIANTES ---
				1. Listar estudiantes
				2. Buscar estudiante
				3. Agregar estudiante
				4. Modificar estudiante
				5. Eliminar estudiante
				6. Cerrar sesion
				
				Seleccione opción: 
				""";
		System.out.print(menu);
	}

	private static void ListarEstudiantes(EstudianteServicio estudianteServicio) {

		List<Estudiante> estudiantes = estudianteServicio.ListarEstudianyes();

		if (!estudiantes.isEmpty()) {
			estudiantes.forEach(System.out::println);
		} else {
			System.out.println("No se encontraron estudiantes");
		}
	}

	private static void BuscarPorId(EstudianteServicio estudianteServicio, Scanner readLine) {
		System.out.println("Ingrese el id del estudiante: ");
		Long id = Long.parseLong(readLine.nextLine());

		Estudiante estudiante = estudianteServicio.BuscarPorId(id);

		if (estudiante != null) {
			System.out.println(estudiante);
		} else {
			System.out.println("Estudiante no encontrado con id: " + id);
		}
	}

	private static void CrearEstudiante(EstudianteServicio estudianteServicio, Scanner readLine) {
		System.out.println("Ingrese el nombre: ");
		String nombre = readLine.nextLine();
		System.out.println("Ingrese el apellido: ");
		String apellido = readLine.nextLine();
		System.out.println("Ingrese el telefono: ");
		String telefono = readLine.nextLine();
		System.out.println("Ingrese el correo: ");
		String email = readLine.nextLine();

		Estudiante newEstudiante = new Estudiante(nombre, apellido, telefono, email);

		estudianteServicio.GuardarEstudiante(newEstudiante);
		System.out.println("Estudiante creado:  " + newEstudiante);
	}

	private static void ModificarEstudiante(EstudianteServicio estudianteServicio, Scanner readLine) {
		System.out.println("Ingrese el id: ");
		Long id = Long.parseLong(readLine.nextLine());

		Estudiante estudiante = estudianteServicio.BuscarPorId(id);

		if (estudiante != null) {
			System.out.println("Ingrese el nombre: ");
			String nombre = readLine.nextLine();
			System.out.println("Ingrese el apellido: ");
			String apellido = readLine.nextLine();
			System.out.println("Ingrese el telefono: ");
			String telefono = readLine.nextLine();
			System.out.println("Ingrese el correo: ");
			String email = readLine.nextLine();

			Estudiante newEstudiante = new Estudiante(id, nombre, apellido, telefono, email);

			estudianteServicio.GuardarEstudiante(newEstudiante);

			System.out.println("Estudiante actualizado:  " + newEstudiante);
		} else {
			System.out.println("Estudiante no encontrado con id: " + id);
		}
	}

	private static void ElimiarEstudiante(EstudianteServicio estudianteServicio, Scanner readLine) {

		System.out.println("Ingrese el id del estudiante: ");
		Long id = Long.parseLong(readLine.nextLine());

		Estudiante estudiante = estudianteServicio.BuscarPorId(id);

		if (estudiante != null) {
			estudianteServicio.EliminarEstudiante(id);
			System.out.println("Estudiante eliminado: " + estudiante);
		} else {
			System.out.println("Estudiante no encontrado con id: " + id);
		}
	}
}
