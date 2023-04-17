package br.com.diegocordeiro.studies.repository;

import br.com.diegocordeiro.studies.models.Entity;

import java.util.List;
import java.util.Optional;

public interface Repository<T extends Entity> {

    boolean save(T object);

    List<T> findAll();

    Optional<T> findById(String uuid);

    boolean removeById(String uuid);
}
