package com.codeup.springblog.services;

import com.codeup.springblog.models.User;
import com.codeup.springblog.models.UserWithRoles;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepository usersDao;


    public UserDetailsLoader(UserRepository usersDao){
        this.usersDao = usersDao;
    }


    // given a username give me a user
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = usersDao.findByUsername(username);
       if(user == null){
           throw new UsernameNotFoundException("No user found for username " + username);
       }

       UserDetails enhancedUser = new UserWithRoles(user);
       return enhancedUser;
    }
}
