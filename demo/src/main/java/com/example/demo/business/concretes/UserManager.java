package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.UserService;
import com.example.demo.core.dataAccess.UserDao;
import com.example.demo.core.entities.User;
import com.example.demo.core.result.DataResult;
import com.example.demo.core.result.Result;
import com.example.demo.core.result.SuccessDataResult;
import com.example.demo.core.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
 public class UserManager implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Result add(User user) {
          this.userDao.save(user);
        return new SuccessResult("ok");
    }

    @Override
    public DataResult<User> findbyEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email),"başarılı");
    }
}
