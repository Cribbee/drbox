package com.lxy11.drbox.Dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lxy11.drbox.po.User;

public interface UserInfoRepository extends JpaRepository<User, Integer> {
    User findUserInfoById(int id);

    User findEmailById(int id);

    @Query(value = "select * from  user_info where user_status = ?1",nativeQuery = true)
    public List<User> nativeQuerry(boolean user_status);



}
