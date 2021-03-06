package fr.univ.lorraine.houseSkipper.repositories;

import fr.univ.lorraine.houseSkipper.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<ApplicationUser, Long>{

    public ApplicationUser findByUsername(String username);

    public ApplicationUser findByEmailToken(String email_token);


}
