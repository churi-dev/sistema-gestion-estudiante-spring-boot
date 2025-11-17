package com.churi_dev.gestion_estudiante.servicio;

import com.churi_dev.gestion_estudiante.model.Estudiante;

import java.util.List;

public interface IEstudianteServicio {

    List<Estudiante> ListarEstudianyes();

    Estudiante BuscarPorId(Long id);

    void GuardarEstudiante(Estudiante estudiante);

    void EliminarEstudiante(Long id);
}
