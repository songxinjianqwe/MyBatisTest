package me.newsong.exception;

import me.newsong.exception.annotation.RESTField;
import me.newsong.exception.annotation.RESTResponseStatus;
import me.newsong.exception.base.BaseRESTException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/3/19.
 */
@RESTResponseStatus(value = HttpStatus.BAD_REQUEST, code = 1)
@RESTField("page")
public class PageOutOfBoundsException extends BaseRESTException {
    public PageOutOfBoundsException(int totalPage) {
        super(totalPage);
    }
}
