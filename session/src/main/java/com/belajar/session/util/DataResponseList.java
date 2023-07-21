package com.belajar.session.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DataResponseList<E> {
    private boolean status;
    private String message;
    private Long timeStamp;
    private List<E> data;

    public DataResponseList(List<E> data) {
        this(true, null, data);
    }

    public DataResponseList(boolean status, String message) {
        this(status, message, null);
    }

    public DataResponseList(boolean status, String message, List<E> data) {
        this.timeStamp = System.currentTimeMillis();
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
