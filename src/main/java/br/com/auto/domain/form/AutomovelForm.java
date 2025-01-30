package br.com.auto.domain.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutomovelForm {
    @NotBlank(message = "A marca do automóvel deve ser informada.")
    private String marca;

    @NotBlank(message = "O modelo do automóvel deve ser informado.")
    private String modelo;

    @NotNull(message = "O valor do automóvel deve ser informado.")
    private BigDecimal valor;
}
