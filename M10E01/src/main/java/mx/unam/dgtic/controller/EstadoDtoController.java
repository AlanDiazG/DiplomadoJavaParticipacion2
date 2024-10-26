package mx.unam.dgtic.controller;

import mx.unam.dgtic.dto.AlumnoDto;
import mx.unam.dgtic.dto.EstadoDto;
import mx.unam.dgtic.model.Alumno;
import mx.unam.dgtic.model.Estado;
import mx.unam.dgtic.servicio.EstadoDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v2/estados")
public class EstadoDtoController {

    @Autowired
    EstadoDtoService estadoDtoService;

    @GetMapping(path = "/")
    public List<EstadoDto> getAllDto(){
        return estadoDtoService.getEstadosList();
    }

    @GetMapping(path = "/{idEstado}")
    public ResponseEntity<EstadoDto> getByIdDto(@PathVariable int idEstado){
        Optional<EstadoDto> estadoDto = estadoDtoService.getEstadoById(idEstado);
        if (estadoDto.isPresent()){
            return ResponseEntity.ok(estadoDto.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/")
    public ResponseEntity<EstadoDto> createEstadoDto(@RequestBody EstadoDto estadoDto) throws ParseException, URISyntaxException {
        EstadoDto estadoDto1 = estadoDtoService.createEstado(estadoDto);
        URI location= new URI("/api/v2/estados/"+estadoDto1.getIdEstado());
        return ResponseEntity.created(location).body(estadoDto1);
    }

    @PutMapping(path = "/{idEstado}")
    public ResponseEntity<EstadoDto> updateEstado(@PathVariable int idEstado,
                                                  @RequestBody EstadoDto estadoDto
    ) throws URISyntaxException, ParseException {
        estadoDto.setIdEstado(idEstado);
        EstadoDto estadoModificado = estadoDtoService.updateEstado(estadoDto);
        return ResponseEntity.ok(estadoModificado);
    }

    @PatchMapping(path = "/{idEstado}")
    public ResponseEntity<EstadoDto> actualizacionParcialDto(
            @PathVariable int idEstado,
            @RequestBody EstadoDto estadoDto
    ) throws ParseException {
        Optional<EstadoDto> estadoDto1= estadoDtoService.getEstadoById(idEstado);
        if (estadoDto1.isPresent()){
            EstadoDto modificable = estadoDto1.get();
            if (estadoDto.getAbreviatura()!= null){ modificable.setAbreviatura(estadoDto.getAbreviatura());}
            return ResponseEntity.ok(estadoDtoService.updateEstado(modificable));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{idEstado}")
    public ResponseEntity<?> eliminarEstado(
            @PathVariable int idEstado){
        if (estadoDtoService.deleteEstado(idEstado)){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/estados/{edo}")
    public ResponseEntity<EstadoDto> findByEstado(@PathVariable String edo) {
        return ResponseEntity.ok(estadoDtoService.findByEstado(edo));
    }

    // /api/v2/alumnos/paginado?page=0&size=2&dir=asc&sort=nombre
    @GetMapping("/paginado")
    public ResponseEntity<List<Estado>> getPaginadoEstado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "asc") String dir,
            @RequestParam(defaultValue = "idEstado") String sort
    ) {
        return ResponseEntity.ok(estadoDtoService.getEstadosPageable(page,size,dir,sort));

    }


}
