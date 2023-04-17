package br.com.diegocordeiro;

import br.com.diegocordeiro.studies.dto.UserDTO;
import br.com.diegocordeiro.studies.models.Role;
import br.com.diegocordeiro.studies.repository.impl.UserRepository;
import br.com.diegocordeiro.studies.service.Service;
import br.com.diegocordeiro.studies.service.impl.UserService;

public class Application
{
    public static void main( String[] args ) {

        UserDTO userOne = new UserDTO("", "Diego J", "Diego", 28, Role.ADMIN);
        UserDTO userTwo = new UserDTO("", "Diego J", "Diego", 28, Role.ADMIN);

        Service<UserDTO> service = new UserService(new UserRepository());

        service.save(userOne);
        service.save(userTwo);

        service.findAll().forEach(System.out::println);

        service.findAll().stream().findFirst().ifPresent(user -> service.removeById(user.getUuid()));

        service.findAll().forEach(System.out::println);
    }
}
