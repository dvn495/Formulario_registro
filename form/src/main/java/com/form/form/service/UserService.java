package com.form.form.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.form.form.model.User;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final String FILE_PATH = "users.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    public void saveUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        objectMapper.writeValue(new File(FILE_PATH), users);
    }

    public List<User> getAllUsers() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return objectMapper.readValue(file, new TypeReference<List<User>>() {});
    }
}

