package com.belajar.session.controller;

import com.belajar.session.entity.Session;
import com.belajar.session.request.IsAccessValidRequest;
import com.belajar.session.request.ValidateSessionLoginRequest;
import com.belajar.session.response.CommonResponse;
import com.belajar.session.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
    @Autowired
    private SessionService sessionService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    @RequestMapping(value = {"/validateSessionLogin"}, method = RequestMethod.POST, consumes = "application/json")
    public CommonResponse validateSessionLogin(@RequestBody ValidateSessionLoginRequest request){
        LOGGER.info("req" + request);
        LOGGER.info("req: " + request.getSessionId() + ", " + request.getToken() + ", " + request.getTimestamp());
        Session sessionLogin = sessionService.isSessionLoginValid(request.getSessionId(), request.getToken(), request.getTimestamp());
        CommonResponse response = new CommonResponse();
        response.setStatus(true);
        response.setObject(sessionLogin);
        return response;
    }

    @RequestMapping(value = {"/isAccessValid"}, method = RequestMethod.POST, consumes = "application/json")
    public CommonResponse isAccessValid(@RequestBody IsAccessValidRequest request){
        LOGGER.info("req" + request);
        LOGGER.info("req: " + request.getUserId() + ", " + request.getUrl());
        boolean sessionLogin = sessionService.isAccessValid(request.getUserId(), request.getUrl());
        CommonResponse response = new CommonResponse();
        response.setStatus(true);
        response.setObject(sessionLogin);
        return response;
    }


}
