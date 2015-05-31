/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author dick
 */
@ServerEndpoint("/echo")
public class Echo {
    
    Session session;
    
    @OnOpen
    public void connect(Session session) {
        System.out.println("connect ...");
     this.session = session;   
    }
    
    @OnClose
    public void close() {
        System.out.println("close ...");
       session = null;

    }
    
    @OnMessage
    public void message(String msg) {
        System.out.println("msg ..."+ msg);
        session.getAsyncRemote().sendText("Echooo "+ msg);
    }
}
