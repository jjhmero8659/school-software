package com.school.sotfware.exception;

import com.school.sotfware.exception.message.ExceptionMessage;

public class UserNotFoundException extends BusinessException{
    public UserNotFoundException() {
        super(ExceptionMessage.USER_NOT_FOUND);
    }
}
