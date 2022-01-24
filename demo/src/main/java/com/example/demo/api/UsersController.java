package com.example.demo.api;

import com.example.demo.business.abstracts.UserService;
import com.example.demo.core.entities.User;
import com.example.demo.core.result.DataResult;
import com.example.demo.core.result.ErrorDataResult;
import com.example.demo.core.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users/")
public class UsersController {
    @Autowired
    private UserService userService;

    @PostMapping("add")
    public Result add(@Valid  @RequestBody User user)
    {

        return this.userService.add(user);

    }
    @GetMapping("getEmail")
    public DataResult<User> findbyEmail(@Valid @RequestParam String email)
    {
        return  this.userService.findbyEmail(email);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exp)
    {
        Map<String,String> validationErrors= new HashMap<String,String>();
        for (FieldError fe:exp.getBindingResult().getFieldErrors())
        {
            validationErrors.put(fe.getField(),fe.getDefaultMessage());
        }
        ErrorDataResult<Object>errors=new ErrorDataResult<Object>(validationErrors,"Hatalar");
        return  errors;

    }
}
