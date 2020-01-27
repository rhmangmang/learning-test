package com.spring.learning.demo.repository;


import com.spring.learning.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


// JpaRepository<User, Long> 中的Long我猜是User中id对应的类型
public interface UserRepository extends JpaRepository<User, Long> {
//    还有一个特别有尿性的功能非常赞，就是可以根据方法名来自动的生成 SQL，
//    比如findByUserName 会自动生成一个以 userName 为参数的查询方法，
//    比如 findAlll 自动会查询表里面的所有数据，比如自动分页等等。
    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);

}