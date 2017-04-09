package me.newsong.exceptions;

import me.newsong.exceptions.annotation.RESTField;
import me.newsong.exceptions.annotation.RESTResponseStatus;
import org.springframework.http.HttpStatus;

import me.newsong.exceptions.base.BaseRESTException;

@RESTResponseStatus(value = HttpStatus.CONFLICT, code = 1)
@RESTField("name")
public class UsernameExistedException extends BaseRESTException {
    public UsernameExistedException(String name) {
        super(name);
    }

}
