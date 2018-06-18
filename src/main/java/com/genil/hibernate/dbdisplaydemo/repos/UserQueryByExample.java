package com.genil.hibernate.dbdisplaydemo.repos;

import com.genil.hibernate.dbdisplaydemo.domain.User;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * Created by genil on 6/17/18 at 09 37
 **/
public interface UserQueryByExample extends QueryByExampleExecutor<User> {
}
