package com.belajar.session.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataResponse<T> {
    private boolean status;
    private String message;
    private Long timeStamp;
    private T data;



    public DataResponse() {
        super();
    }

    public DataResponse(T data) {
        this(true, null, data);
    }

    public DataResponse(boolean status, String message) {
        this(status, message, null);
    }

    public DataResponse(boolean status, String message, T data) {
        this.timeStamp = System.currentTimeMillis();
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
