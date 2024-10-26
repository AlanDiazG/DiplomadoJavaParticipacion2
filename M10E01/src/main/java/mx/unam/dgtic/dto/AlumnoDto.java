package mx.unam.dgtic.dto;

import java.util.Objects;

public class AlumnoDto {
    private  String matricula;
    private String nombre;
    private String paterno;
    private String fnac;
    private double estatura;
    private String estado;

    public AlumnoDto() {
    }

    public AlumnoDto(String matricula, String nombre, String paterno, String fnac, double estatura, String estado) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.paterno = paterno;
        this.fnac = fnac;
        this.estatura = estatura;
        this.estado = estado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getFnac() {
        return fnac;
    }

    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoDto alumnoDto = (AlumnoDto) o;
        return Double.compare(estatura, alumnoDto.estatura) == 0 && Objects.equals(matricula, alumnoDto.matricula) && Objects.equals(nombre, alumnoDto.nombre) && Objects.equals(paterno, alumnoDto.paterno) && Objects.equals(fnac, alumnoDto.fnac) && Objects.equals(estado, alumnoDto.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, nombre, paterno, fnac, estatura, estado);
    }

    @Override
    public String toString() {
        return "AlumnoDto{" +
                "matricula='" + matricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", paterno='" + paterno + '\'' +
                ", fnac='" + fnac + '\'' +
                ", estatura=" + estatura +
                ", estado='" + estado + '\'' +
                '}';
    }
}
