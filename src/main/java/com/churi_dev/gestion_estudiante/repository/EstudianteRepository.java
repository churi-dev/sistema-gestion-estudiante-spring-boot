package com.churi_dev.gestion_estudiante.repository;

import com.churi_dev.gestion_estudiante.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Estudiante findByIdEstudiante(Long idEstudiante);
}
