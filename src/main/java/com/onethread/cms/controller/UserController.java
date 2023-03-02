package com.onethread.cms.controller;

import com.onethread.cms.config.TokenProvider;
import com.onethread.cms.model.LoginUser;
import com.onethread.cms.model.User;
import com.onethread.cms.model.UserDto;
import com.onethread.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;



    @GetMapping("/get/{name}")
    public ResponseEntity<User> getUser(@PathVariable String name){
        return ResponseEntity.ok(userService.findOne(name));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get/all")
    public ResponseEntity<Iterable<User>> getAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/login")
        public ResponseEntity<String> login(@RequestBody LoginUser user) throws AuthenticationException {
//            final Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            user.getEmail(),
//                            user.getPassword()
//                    )
//            );

        try {
            // Authenticate the user with email and password
           final Authentication authentication=  authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getEmail(),
                            user.getPassword()
                    )
            );
            System.out.println("Authentication: " + authentication);
    // If authentication is successful, save the authentication in the context and
    // create a JWT token
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String token = jwtTokenUtil.generateToken(authentication);
            return ResponseEntity.ok(token);

        } catch (AuthenticationException e) {
            // If authentication fails, return 401 Unauthorized
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }


    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto user){
        userService.save(user);
        return ResponseEntity.ok("User registered");
    }



}
