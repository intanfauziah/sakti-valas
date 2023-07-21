package com.belajar.session.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ADM_R_SEC_SESSION_LOGIN")
@Getter
@Setter
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SESSIONID")
    private String sessionId;
    @Column(name = "ACCESSED_TIME")
    private Date accessedTime;
    @Column(name = "REMOTE_ADDRESS")
    private String remoteAddress;
    @Column(name = "USERID")
    private String userId;
    @Column(name = "CURRENT_ALPHA_ID")
    private String currentAlphaId;
    @Column(name = "CURRENT_BETA_ID")
    private String currentBetaId;
    @Column(name = "CLIENT_ID")
    private String clientId;
}