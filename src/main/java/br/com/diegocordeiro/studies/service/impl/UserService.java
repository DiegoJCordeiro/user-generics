package br.com.diegocordeiro.studies.service.impl;

import br.com.diegocordeiro.studies.dto.UserDTO;
import br.com.diegocordeiro.studies.mapper.ModelMapper;
import br.com.diegocordeiro.studies.models.User;
import br.com.diegocordeiro.studies.repository.Repository;
import br.com.diegocordeiro.studies.service.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserService implements Service<UserDTO> {
    private final Repository<User> repository;
    public UserService(Repository<User> repository) {

        this.repository = repository;
    }

    @Override
    public boolean save(UserDTO object) {

        User user = ModelMapper.fromTo(object, User.class);

        return repository.save(user);
    }

    @Override
    public List<UserDTO> findAll() {

        return repository.findAll().stream()
                .map(user -> ModelMapper.fromTo(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findById(String uuid) {

        return repository.findById(uuid)
                .map(user -> ModelMapper.fromTo(user, UserDTO.class));
    }

    @Override
    public boolean removeById(String uuid) {

        return repository.removeById(uuid);
    }
}
