package com.genil.hibernate.dbdisplaydemo.repos;

import com.genil.hibernate.dbdisplaydemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by genil on 6/17/18 at 09 26
 **/
public interface UserRepository  extends JpaRepository<User,Integer> {

    public List<User> findByLastName(String lastName);
}
