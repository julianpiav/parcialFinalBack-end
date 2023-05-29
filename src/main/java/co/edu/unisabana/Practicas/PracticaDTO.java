package co.edu.unisabana.Practicas;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PracticaDTO {
    private int codigo;
    @NotNull(message = "Mande el campo")
    @Size(min = 3, max = 50)
    private String empresa;
    @NotNull(message = "Mande el campo")
    @Size(min = 3, max = 50)
    private String supervisor;
    private Date fecha;
    private ArrayList<TareaDTO> tareas;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracticaDTO that = (PracticaDTO) o;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
