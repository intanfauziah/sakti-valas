package com.belajar.session.service;

import com.belajar.session.entity.AccessMatrix;
import com.belajar.session.entity.Session;
import com.belajar.session.repository.AccessMatrixRepository;
import com.belajar.session.repository.AclRepository;
import com.belajar.session.repository.SessionRepository;
import edu.vt.middleware.crypt.digest.SHA512;
import edu.vt.middleware.crypt.util.Convert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private AclRepository aclRepository;

    @Autowired
    private AccessMatrixRepository accessMatrixRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionService.class);

    public Session isSessionLoginValid(String sessionId, String token, String timestamp) {
        byte[] saktiTokenId = Base64.getDecoder().decode(token);
        String plainSaktiTokenId = new String(saktiTokenId);
        String[] tokens = plainSaktiTokenId.split("\\|");

        Session sessionLogin = this.getSessionLoginByUserId(tokens[0]);
        if (sessionLogin != null) {
            String _key = String.format("%s:%s:%s", tokens[0], sessionLogin.getCurrentAlphaId(), tokens[1]);
            String expectedSessionId = Convert.toHex(new SHA512().digest(_key.getBytes(StandardCharsets.UTF_8)));
            if (expectedSessionId.equals(sessionId) && timestamp.equals(tokens[2])) {
                return sessionLogin;
            }
        }
        return null;
    }

    public boolean isAccessValid(String userId, String url) {
        List<AccessMatrix> accessMatrixList =  accessMatrixRepository.findByUrlRest(url);
        if (!CollectionUtils.isEmpty(accessMatrixList)) {
            boolean isValid = false;
            for (AccessMatrix wrapper : accessMatrixList) {
                int counter = 0;
                Integer aclObject = wrapper.getFormId();
                switch (wrapper.getAclValue()) {
                    case 1:
                        counter = aclRepository.countFormAclCreateByUserAndFormId(userId, aclObject);
                        break;
                    case 2:
                        counter = aclRepository.countFormAclReadByUserAndFormId(userId, aclObject);
                        break;
                    case 3:
                        counter = aclRepository.countFormAclUpdateByUserAndFormId(userId, aclObject);
                        break;
                    case 4:
                        counter = aclRepository.countFormAclDeleteByUserAndFormId(userId, aclObject);
                        break;
                    default:
                        LOGGER.error("Invalid acl value");
                }
                if (counter > 0) {
                    isValid = true;
                }
            }
            return isValid;
        }
        return true;
    }

    public Session getSessionLoginByUserId(String userId) {
        Session sessionLogin = sessionRepository.findByUserId(userId);

        return sessionLogin;
    }

}