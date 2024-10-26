package mx.unam.dgtic.servicio;

import mx.unam.dgtic.dto.EstadoDto;
import mx.unam.dgtic.model.Alumno;
import mx.unam.dgtic.model.Estado;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface IEstadoDtoService {
    
    public List<EstadoDto> getEstadosList();
    public List<Estado> getEstadosPageable(int page,
                                           int size,
                                           String dirSort,
                                           String sort);
    public Optional<EstadoDto> getEstadoById(int idEstado);
    public EstadoDto updateEstado(EstadoDto estado) throws ParseException;
    public EstadoDto createEstado(EstadoDto estado) throws ParseException;
    public boolean deleteEstado(int idEstado);
    public EstadoDto findByEstado(String estado);
}
