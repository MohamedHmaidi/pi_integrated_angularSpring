package Hend.BackendSpringboot.service;
import java.util.List;

import Hend.BackendSpringboot.entity.User;



public interface IUserService {


        List<User> retrieveAllUser();

        User createUser(User user);
        User getUserById(Integer id_user);
        User updateUser(Integer id_user, User user);
        void deleteUser(Integer id_user);
    }


