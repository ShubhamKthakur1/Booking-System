package com.userservice.service.imp;
import com.userservice.model.UserDetail;
import com.userservice.repo.UserRepository;
import com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;


    // creating user
    @Override
    public UserDetail createUser(UserDetail user) throws Exception {
        UserDetail local=this.userRepository.findByUsername(user.getUsername());
        if(local !=null){
            System.out.println("User is already there !!");
            throw new Exception("User already present !!");
        }else{
            //user create
            local=this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public UserDetail getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }
}
