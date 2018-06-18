package com.genil.hibernate.dbdisplaydemo.repos;

import com.genil.hibernate.dbdisplaydemo.domain.SecretClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by genil on 6/17/18 at 12 46
 **/
public interface SecretClientRepository extends JpaRepository<SecretClient,Integer> {
    Optional<SecretClient> findByEmail(String email);
}
