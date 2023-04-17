package br.com.diegocordeiro.studies.repository.impl;

import br.com.diegocordeiro.studies.exceptions.UserNotFoundException;
import br.com.diegocordeiro.studies.models.User;
import br.com.diegocordeiro.studies.repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepository implements Repository<User> {

    private static final List<User> users = new ArrayList<>();

    private static final String MESSAGE_ERROR_USER_NOT_FOUND = "Não foi encontrado o recurso desejado.";

    @Override
    public boolean save(User object) {

        object.setUuid(UUID.randomUUID().toString());

        return users.add(object);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(String uuid) {

        return users.stream().filter(user -> user.getUuid().equals(uuid)).findFirst();
    }

    @Override
    public boolean removeById(String uuid) {

        User userFound = users.stream()
                .filter(user -> user.getUuid().equals(uuid))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(MESSAGE_ERROR_USER_NOT_FOUND));

        return users.remove(userFound);
    }
}
