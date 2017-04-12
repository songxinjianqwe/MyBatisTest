package me.newsong.exception;

import me.newsong.exception.annotation.RESTField;
import me.newsong.exception.annotation.RESTResponseStatus;
import org.springframework.http.HttpStatus;

import me.newsong.exception.base.BaseRESTException;

@RESTResponseStatus(value = HttpStatus.CONFLICT, code = 1)
@RESTField("name")
public class UsernameExistedException extends BaseRESTException {
    public UsernameExistedException(String name) {
        super(name);
    }

}
