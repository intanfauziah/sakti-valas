package com.belajar.session.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IsAccessValidRequest {
    private String userId;
    private String url;
}
