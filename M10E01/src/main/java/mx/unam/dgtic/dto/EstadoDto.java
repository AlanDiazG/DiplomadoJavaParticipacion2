package mx.unam.dgtic.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.Objects;

public class EstadoDto {

    private int idEstado;
    private String abreviatura;

    public EstadoDto() {
    }

    public EstadoDto(String abreviatura, int idEstado) {
        this.abreviatura = abreviatura;
        this.idEstado = idEstado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoDto estadoDto = (EstadoDto) o;
        return idEstado == estadoDto.idEstado && Objects.equals(abreviatura, estadoDto.abreviatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstado, abreviatura);
    }

    @Override
    public String toString() {
        return "EstadoDto{" +
                "idEstado=" + idEstado +
                ", abreviatura='" + abreviatura + '\'' +
                '}';
    }
}
