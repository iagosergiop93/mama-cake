package com.cake.repositories;

import com.cake.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    User findUserById(long id);

    User findUserByEmailAndPasswd(String email, String passwd);

    User findUserByEmail(String email);

}
