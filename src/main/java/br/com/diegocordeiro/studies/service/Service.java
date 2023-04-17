package br.com.diegocordeiro.studies.service;

import br.com.diegocordeiro.studies.dto.DTO;

import java.util.List;
import java.util.Optional;

public interface Service<T extends DTO> {

    boolean save(T object);

    List<T> findAll();

    Optional<T> findById(String uuid);

    boolean removeById(String uuid);
}
