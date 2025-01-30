package br.com.auto.domain.erros;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErroValidacaoResponse {
    private String campo;
    private String causaErro;
}
