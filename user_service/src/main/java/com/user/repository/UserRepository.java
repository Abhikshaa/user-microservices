package com.user.repository;



import com.user.entity.User;
import com.user.payload.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {


}

