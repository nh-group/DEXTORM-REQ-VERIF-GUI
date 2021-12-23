package fr.pantheonsorbonne.cri;

import fr.pantheonsorbonne.cri.requirements.AgentConfig;
import fr.pantheonsorbonne.cri.requirements.Empty;
import fr.pantheonsorbonne.cri.requirements.AgentConfigurationGrpc.AgentConfigurationImplBase;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.StreamObserver;

public class ConfigurationImpl extends AgentConfigurationImplBase {
	@Override
	public void pushAgentConfiguration(AgentConfig request, StreamObserver<Empty> responseObserver) {
		SpringBootWebApplication.githubProjetName = request.getProjectGHPath();
	}
}
