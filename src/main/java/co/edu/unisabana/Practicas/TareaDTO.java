package co.edu.unisabana.Practicas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TareaDTO {
    @NotNull(message = "Mande el campo")
    @Size(min = 3, max = 50)
    private String nombre;
    private Date fecha;
}
