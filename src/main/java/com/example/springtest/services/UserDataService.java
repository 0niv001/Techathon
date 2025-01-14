package com.example.springtest.services;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataService {
    // Normally user credentials would be stored in the database
    // For the purpose of this prototype, they're stored in an array list
    private static List<String[]> userData;

    // Populate the array list with user data
    @PostConstruct
    public void init() {
        userData = new ArrayList<>();
        userData.add(new String[]{"Plutonic", "yKDBBZ4ap"});
        userData.add(new String[]{"Misdrawn", "HJfJTjdl"});
        userData.add(new String[]{"Zoneless", "password"});
    }

    // Getter
    public static List<String[]> getUserData() {
        return userData;
    }
}
