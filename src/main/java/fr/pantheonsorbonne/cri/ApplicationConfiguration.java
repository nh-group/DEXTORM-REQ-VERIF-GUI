package fr.pantheonsorbonne.cri;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.context.annotation.ApplicationScope;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@Configuration
public class ApplicationConfiguration {
    Server server;
    public ApplicationConfiguration() {
        server = ServerBuilder.forPort(6081).addService(new CollectorImpl(template)).build();


    }

    public SimpMessagingTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(SimpMessagingTemplate template) {
        this.template = template;
    }


    SimpMessagingTemplate template;

    @PostConstruct
    public void init() {

        try {
            server.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
