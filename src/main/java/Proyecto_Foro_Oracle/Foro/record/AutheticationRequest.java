package Proyecto_Foro_Oracle.Foro.record;

import jakarta.validation.Valid;
import lombok.NonNull;

public record AutheticationRequest(@NonNull String name,@NonNull String password) {
}
