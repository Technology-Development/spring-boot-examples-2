package org.example.config;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpSessionConfigurator extends Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        HttpSession session = (HttpSession) request.getHttpSession();
        if (session != null) {
            sec.getUserProperties().put(HttpSession.class.getName(), session);
            log.info("HttpSessionId: {}", session.getId());
        } else {
            log.info("No HttpSession");
        }
        super.modifyHandshake(sec, request, response);
    }

}
