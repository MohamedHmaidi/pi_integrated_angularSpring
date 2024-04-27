package Hend.BackendSpringboot.service;

import Hend.BackendSpringboot.entity.User;
import Hend.BackendSpringboot.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements IUserService{


        private UserRepository userRepository;

    @Override
  //  @Transactional(readOnly = true)
    public List<User> retrieveAllUser() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
   // @Transactional(readOnly = true)
    public User getUserById(Integer id_user) {
        return userRepository.findById(id_user).orElse(null);
    }

    @Override
    @Transactional
    public User updateUser(Integer id_user, User user) {
        if (userRepository.existsById(id_user)) {
            user.setId_user(id_user);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteUser(Integer id_user) {
        userRepository.deleteById(id_user);
    }

     /*   @Override
        public List<User> retrieveAllUser() {
        return userRepository.findAll();
              }
    @Override
        public User createUser(User user) {
            return userRepository.save(user);
        }

        @Override
        public User getUserById(Integer id_user) {
            return userRepository.findById(id_user).orElse(null);
        }

        @Override
        public User updateUser(Integer id_user, User user) {
            if (userRepository.existsById(id_user)) {
                user.setId_user(id_user);
                return userRepository.save(user);
            }
            return null;
        }

    @Override
    public void deleteUser(Integer id_user) {
        userRepository.deleteById(id_user);
    }*/
    }

