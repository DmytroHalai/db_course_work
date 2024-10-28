package com.example.db.service;

import com.example.db.model.User;
import com.example.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String create(User user) {
        userRepository.save(user);
        return "User has been successfully created!";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) throws Exception {
        if (userRepository.existsById(id)) {
            return userRepository.findById(id);
        } else {
            throw new Exception("User with such an ID doesn't exists.");
        }
    }

    public String update(User user, Long id) throws Exception {
        if (userRepository.existsById(id)) {
            userRepository.save(user);
        } else {
            throw new Exception("User with such ID doesn't exists.");
        }
        return "User has been successfully updated!";
    }

    public String delete(Long id) throws Exception{
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new Exception("User with such an ID doesn't exists.");
        }
        return "User has been successfully deleted!";
    }
}

//@Service
//public class UserServiceImpl implements UserService {
//
//    private static final Map<Integer, User> USER_REPOSITORY_MAP = new HashMap<>();
//    private static final AtomicInteger USER_ID_HOLDER = new AtomicInteger();
//
//    @Override
//    public void create(User user) {
//        final int userid = USER_ID_HOLDER.incrementAndGet();
//        user.setId((long) userid);
//        USER_REPOSITORY_MAP.put(userid, user);
//    }
//
//    @Override
//    public List<User> readAll() {
//        return new ArrayList<>(USER_REPOSITORY_MAP.values());
//    }
//
//    @Override
//    public User read(int id) {
//        return USER_REPOSITORY_MAP.get(id);
//    }
//
//    @Override
//    public boolean update(User user, int id) {
//        if (USER_REPOSITORY_MAP.containsKey(id)) {
//            user.setId((long) id);
//            USER_REPOSITORY_MAP.put(id, user);
//            return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public boolean delete(int id) {
//        return USER_REPOSITORY_MAP.remove(id) != null;
//    }
//}