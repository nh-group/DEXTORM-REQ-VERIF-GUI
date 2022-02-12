package fr.pantheonsorbonne.cri;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;

import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import fr.pantheonsorbonne.cri.requirements.Empty;
import fr.pantheonsorbonne.cri.requirements.ReqCollectorGrpc;
import fr.pantheonsorbonne.cri.requirements.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.google.rpc.Status;


import io.grpc.StatusRuntimeException;
import io.grpc.netty.shaded.io.netty.util.internal.ConcurrentSet;
import io.grpc.stub.StreamObserver;

public class CollectorImpl extends ReqCollectorGrpc.ReqCollectorImplBase {
	
	
	public CollectorImpl(SimpMessagingTemplate template) {
		this.template=template;
	}
	

    
    private SimpMessagingTemplate template;

	java.util.concurrent.CopyOnWriteArraySet<StreamObserver<Requirement>> pullReqSet = new CopyOnWriteArraySet<>();

	@Override
	public void pullRequirement(Empty request, StreamObserver<Requirement> responseObserver) {
		pullReqSet.add(responseObserver);
	}

	@Override
	public StreamObserver<Requirement> pushRequirement(StreamObserver<Empty> responseObserver) {
		return new StreamObserver<Requirement>() {

			@Override
			public void onNext(Requirement value) {
				if (SpringBootWebApplication.req.size() > 5) {
					SpringBootWebApplication.req.pop();
				}
				SpringBootWebApplication.req.addLast(value);
				try {
				pullReqSet.forEach((StreamObserver<Requirement> responseObserver) -> responseObserver.onNext(value));
		        template.convertAndSend("/topic/greetings", new Greeting(value.getId()));
				}
				catch(StatusRuntimeException e) {
					if(e.getStatus().equals(io.grpc.Status.CANCELLED)) {
						pullReqSet.clear();
					}
				}

			}

			@Override
			public void onError(Throwable t) {
				System.out.println("error receiving req");
				for (StreamObserver<Requirement> responseObserver : pullReqSet) {
					responseObserver.onError(t);
				}
				pullReqSet.clear();

			}

			@Override
			public void onCompleted() {
				System.out.println("done receiving req");
				pullReqSet.forEach(StreamObserver::onCompleted);
				pullReqSet.clear();

			}
		};
	}

}
