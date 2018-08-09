package edu.self.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.self.entity.User;
import edu.self.repository.UserRepository;

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
