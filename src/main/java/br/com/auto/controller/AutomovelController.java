package br.com.auto.controller;

import br.com.auto.domain.entity.Automovel;
import br.com.auto.domain.form.AutomovelForm;
import br.com.auto.service.AutomovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AutomovelController {

    @Autowired
    private AutomovelService automovelService;

    @PostMapping("/cadastroAutomoveis")
    public ResponseEntity<Automovel> cadastraAutomovel(@RequestBody @Valid AutomovelForm automovelForm) {
        var automovel = automovelService.cadastraAutomovel(automovelForm);
        return new ResponseEntity<>(automovel, HttpStatus.CREATED);
    }

    @GetMapping("/automoveis")
    public ResponseEntity<List<Automovel>> buscaTodosAutomoveis() {
        var automoveis = automovelService.buscaTodosAutomoveis();
        return new ResponseEntity<>(automoveis, HttpStatus.OK);
    }

    @GetMapping("/automoveis/{automovelId}")
    public ResponseEntity<Automovel> buscaAutomovelPeloId(@PathVariable Long automovelId) {
        var automovel = automovelService.buscaAutomovelPeloId(automovelId);
        return new ResponseEntity<>(automovel, HttpStatus.OK);
    }
}
