package mx.unam.dgtic.servicio;

import mx.unam.dgtic.dto.AlumnoDto;
import mx.unam.dgtic.dto.EstadoDto;
import mx.unam.dgtic.model.Alumno;
import mx.unam.dgtic.model.Estado;
import mx.unam.dgtic.repository.EstadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstadoDtoService implements IEstadoDtoService{

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<EstadoDto> getEstadosList() {
        List<Estado> estados = estadoRepository.findAll();
        return estados.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<Estado> getEstadosPageable(int page, int size, String dirSort, String sort) {
        PageRequest pageRequest = PageRequest.of(page,size, Sort.Direction.fromString(dirSort),sort);
        Page<Estado> pageResult = estadoRepository.findAll(pageRequest);
        return pageResult.stream().toList();
    }

    @Override
    public Optional<EstadoDto> getEstadoById(int idEstado) {
        Optional<Estado> estado = estadoRepository.findById(idEstado);
        if(estado.isPresent()){
            EstadoDto estadoDto= convertToDto(estado.get());
            return Optional.of(estadoDto);
        }else {
            return Optional.empty();
        }
    }

    @Override
    public EstadoDto updateEstado(EstadoDto estado) throws ParseException {
        Estado estadoActualizado = estadoRepository.save(this.convertToEntity(estado));
        return convertToDto(estadoActualizado);
    }

    @Override
    public EstadoDto createEstado(EstadoDto estado) throws ParseException {
        Estado estadoSalvado = estadoRepository.save(this.convertToEntity(estado));
        return convertToDto(estadoSalvado);
    }

    @Override
    public boolean deleteEstado(int idEstado) {
        Optional<Estado> estado= estadoRepository.findById(idEstado);
        if(estado.isPresent()){
            estadoRepository.deleteById(idEstado);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public EstadoDto findByEstado(String estadoString) {
        Estado estado = estadoRepository.findByEstado(estadoString);
        return this.convertToDto(estado);
    }

    private EstadoDto convertToDto(Estado estado){
        EstadoDto estadoDto = modelMapper.map(estado,EstadoDto.class);
        return estadoDto;
    }

    private Estado convertToEntity(EstadoDto estadoDto) throws ParseException {
        Estado estado=modelMapper.map(estadoDto,Estado.class);
        return estado;
    }
    
    
}
