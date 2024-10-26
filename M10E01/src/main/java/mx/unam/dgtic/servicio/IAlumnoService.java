package mx.unam.dgtic.servicio;

import mx.unam.dgtic.model.Alumno;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IAlumnoService {

    public List<Alumno> getAlumnosList();
    public Optional<Alumno> getAlumnoById(String matricula);
    public Alumno updateAlumno(Alumno alumno);
    public Alumno createAlumno(Alumno alumno);
    public boolean deleteAlumno(String matricula);
    public List<Alumno> findAlumnosByEstado(String estado);


}