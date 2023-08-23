package waisl.login.userlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import waisl.login.userlogin.model.AopUser;
import waisl.login.userlogin.service.AopUserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class AopUserController {

    private final AopUserService userService;

    @Autowired
    public AopUserController(AopUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<AopUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AopUser> getUserById(@PathVariable String id) {
        Optional<AopUser> user = userService.getUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<AopUser> createUser(@RequestBody AopUser user) {
        AopUser createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AopUser> updateUser(@PathVariable String id, @RequestBody AopUser user) {
        AopUser updatedUser = userService.updateUser(id, user);
        return updatedUser != null
                ? new ResponseEntity<>(updatedUser, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
