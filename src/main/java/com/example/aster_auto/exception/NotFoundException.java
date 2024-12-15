package com.example.aster_auto.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.Serial;

@Getter
@Setter
public class NotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5387342817346725665L;

    private HttpStatus httpStatus;

    public NotFoundException(@NonNull String message, @Nullable HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public NotFoundException(@Nullable HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public NotFoundException(@NonNull String message, Throwable throwable) {
        super(message, throwable);
    }

    public NotFoundException(@NonNull String message) {
        super(message);
    }
}
