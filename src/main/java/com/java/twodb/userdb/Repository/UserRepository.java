package com.java.twodb.userdb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.twodb.userdb.Model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{
    
}
