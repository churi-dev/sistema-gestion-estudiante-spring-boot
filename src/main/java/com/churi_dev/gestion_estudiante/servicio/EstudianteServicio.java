package com.churi_dev.gestion_estudiante.servicio;

import com.churi_dev.gestion_estudiante.model.Estudiante;
import com.churi_dev.gestion_estudiante.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServicio implements IEstudianteServicio {

    private final EstudianteRepository estudianteRepository;

    public EstudianteServicio(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> ListarEstudianyes() {
        return estudianteRepository.findAll();
    }

    public Estudiante BuscarPorId(Long id) {
        return estudianteRepository.findByIdEstudiante(id);
    }

    public void GuardarEstudiante (Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    public void EliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

}
