package com.example.sampleApi;

import com.example.sampleApi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by ishiis on 16/089/08.
 */

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findUser(Long id){
        return userRepository.findOne(id);
    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }
}