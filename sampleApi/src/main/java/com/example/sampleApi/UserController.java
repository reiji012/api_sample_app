package com.example.sampleApi;

import com.example.sampleApi.User;
import com.example.sampleApi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ishiis on 16/09/08.
 */

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

    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        user.setId(id);
        return userService.save(user);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }

}
