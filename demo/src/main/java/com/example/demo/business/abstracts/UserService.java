package com.example.demo.business.abstracts;

import com.example.demo.core.entities.User;
import com.example.demo.core.result.DataResult;
import com.example.demo.core.result.Result;

public interface UserService {
       Result add(User user);
       DataResult<User>findbyEmail(String email);
}

