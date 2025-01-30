package br.com.auto.repository;

import br.com.auto.domain.entity.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomovelRepository extends JpaRepository<Automovel, Long> {

}
