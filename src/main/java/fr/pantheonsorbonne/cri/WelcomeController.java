package fr.pantheonsorbonne.cri;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHLabel;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", SpringBootWebApplication.req);
		List<GHIssue> issues = new ArrayList<>();
		try {
			GitHub github = GitHub.connect();
			GHRepository repo = github.getRepository("nh-group/basic-cli-uni/");

			for (GHIssue issue : repo.getIssues(GHIssueState.ALL)) {
				if (issue.getLabels().stream().map((GHLabel l) -> l.getName()).collect(Collectors.toList())
						.contains("user stories")) {
					issues.add(issue);
				}

			}
			
			issues.sort( (GHIssue i1,GHIssue i2) -> Integer.compare(i1.getNumber(),i2.getNumber() ));

			model.put("issues", issues);

		} catch (IOException e) {

		}

		return "welcome";
	}

	@RequestMapping("/ws")
	public String we(Map<String, Object> model) {

		return "ws";
	}

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}

}