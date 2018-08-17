package edu.self.controller;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.resource.spi.RetryableUnavailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import edu.self.entity.User;
import edu.self.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.findUsers();
    }

    @RequestMapping(method=RequestMethod.GET, value="{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.findUser(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    public User createUser(@Validated @RequestBody User user) {
        return userService.save(user);
    }
    
//    @RequestMapping(method=RequestMethod.POST)
//    public ResponseEntity<User> createUser(@Validated @RequestBody User user) {
//    		User result = userService.save(user);
//    		return ResponseEntity.status(HttpStatus.CREATED).body(result);
//    	
//    }

    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user, BindingResult result) {
        user.setId(id);
        User users = userService.save(user);
        search(result);
        return users;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") Long id) {
         userService.delete(id);
    }
    
    public String search(BindingResult result) {
		if (result.hasErrors()) {
			return "this is has Error";
		}
		return null;
	}
}
