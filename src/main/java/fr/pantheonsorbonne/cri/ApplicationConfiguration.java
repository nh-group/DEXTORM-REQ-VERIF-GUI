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

	@ApplicationScope
	@Bean
	public List<String> getRequirements() {
		return new ArrayList<>();
	}

	@ApplicationScope
	@Bean
	@Autowired
	public Server getGrPCServer(List<String> req, SimpMessagingTemplate template) {
		Server server = ServerBuilder.forPort(8081).addService(new CollectorImpl(template)).build();

		return server;

	}

	@Autowired
	SimpMessagingTemplate template;

	@PostConstruct
	public void init() {

		try {
			getGrPCServer(this.getRequirements(), template).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
