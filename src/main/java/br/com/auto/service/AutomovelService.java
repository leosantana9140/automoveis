package br.com.auto.service;

import br.com.auto.domain.entity.Automovel;
import br.com.auto.domain.form.AutomovelForm;
import br.com.auto.exception.InternalServerErrorException;
import br.com.auto.exception.NotFoundException;
import br.com.auto.repository.AutomovelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AutomovelService {

    @Autowired
    private AutomovelRepository automovelRepository;

    public Automovel cadastraAutomovel(final AutomovelForm automovelForm) {

        var automovel = Automovel.builder()
                .marca(automovelForm.getMarca())
                .modelo(automovelForm.getModelo())
                .valor(automovelForm.getValor())
                .dataCadastro(LocalDateTime.now())
                .build();

        try {
            return automovelRepository.save(automovel);
        } catch (Exception e) {
            log.error("Erro ao salvar automóvel.", e);
            throw new InternalServerErrorException("Erro ao salvar automóvel.");
        }
    }

    public List<Automovel> buscaTodosAutomoveis() {

       List<Automovel> automoveis;

        try {
            automoveis = automovelRepository.findAll();
        } catch (Exception e) {
            log.error("Erro ao buscar todos os automóveis.", e);
            throw new InternalServerErrorException("Erro ao buscar todos os automóveis.");
        }

        if (automoveis.isEmpty()) {
            throw new NotFoundException("Nenhum automóvel encontrado.");
        }

        return automoveis;
    }

    public Automovel buscaAutomovelPeloId(final Long automovelId) {

        Optional<Automovel> automovelOptional;

        try {
            automovelOptional = automovelRepository.findById(automovelId);
        } catch (Exception e) {
            log.error("Erro ao buscar automóvel pelo id.", e);
            throw new InternalServerErrorException("Erro ao buscar automóvel pelo id.");
        }

        if (automovelOptional.isEmpty()) {
            throw new NotFoundException("Nenhum automóvel encontrado com o id informado.");
        }

        return automovelOptional.get();
    }
}
