package co.edu.unisabana.Practicas;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping( "/practicas")
public class PracticasController {
    List<PracticaDTO> listaPracticas;
    public PracticasController() {
        this.listaPracticas = new ArrayList<>();
    }
    @PostMapping(path = "/crear")
    public Respuesta crearPractica(@RequestBody @Valid PracticaDTO nuevaPractica){
        nuevaPractica.setCodigo(listaPracticas.size()+1);
        nuevaPractica.setFecha(LocalDate.now());
        System.out.println(nuevaPractica.getFecha());
        listaPracticas.add(nuevaPractica);
        return new Respuesta("Practica ingresada correctamente");
    }
    @GetMapping(path = "/todas")
    public List<PracticaDTO> obtenerPracticas(){
        return listaPracticas;
    }
    @GetMapping(path = "/")
    public List<PracticaDTO> obtenerEstudiantesPorFecha(@RequestParam @Valid Date fecha){
        List<PracticaDTO> busqueda = new ArrayList<>();
        for(PracticaDTO practica : listaPracticas){
            if (practica.getFecha().equals(fecha)){
                busqueda.add(practica);
            }
        }
        return busqueda;
    }

    @PutMapping(path = "/actualizar/{codigo}")
    public Respuesta actualizarPractica(@PathVariable @Valid int codigo, @RequestBody @Valid PracticaDTO practicaModificada){
        for(PracticaDTO practicaDTO : listaPracticas){
            if (practicaDTO.getCodigo()==codigo){
                practicaDTO.setEmpresa(practicaModificada.getEmpresa());
                practicaDTO.setSupervisor(practicaModificada.getSupervisor());
                practicaDTO.setTareas(practicaModificada.getTareas());
            }
        }
        return new Respuesta("Practica actualizada correctamente");
    }

    @DeleteMapping(path = "/eliminar/{codigo}")
    public Respuesta eliminarPracticas(@PathVariable @Valid int codigo){
        listaPracticas.removeIf(practica -> practica.getCodigo() == codigo);
        return new Respuesta("Practica borrada correctamente");
    }
}
