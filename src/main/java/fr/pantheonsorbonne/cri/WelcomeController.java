package fr.pantheonsorbonne.cri;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
import org.kohsuke.github.GitHubBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String welcome(Map<String, Object> model, @RequestParam(value = "githubRepoName", required = false) String githubRepoName) {
		model.put("message", SpringBootWebApplication.req);
		List<GHIssue> issues = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("/github_oauth.txt"));
			GitHub github = new GitHubBuilder().withOAuthToken(br.readLine()).build();
			if(githubRepoName == null || githubRepoName.isEmpty()) {
				githubRepoName = "nh-group/basic-cli-uni/";
			}

			GHRepository repo = github.getRepository(githubRepoName );

			for (GHIssue issue : repo.getIssues(GHIssueState.ALL)) {
				if(repo.getFullName().equals("nh-group/basic-cli-uni") ) {
					if (issue.getLabels().stream().map((GHLabel l) -> l.getName()).collect(Collectors.toList())
							.contains("user stories")) {
						issues.add(issue);
					}
				} else {
					issues.add(issue);
				}

			}
			
			issues.sort( (GHIssue i1,GHIssue i2) -> Integer.compare(i1.getNumber(),i2.getNumber() ));

			model.put("issues", issues);
			model.put("githubRepoName", repo.getFullName());

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		return "welcome";
	}

	@RequestMapping("/parameters")
	public String parameters(Map<String, Object> model, @RequestParam(value = "githubRepoName", required = false) String githubRepoName) {
		if(githubRepoName == null || githubRepoName.isEmpty()) {
			githubRepoName = "nh-group/basic-cli-uni/";
		}

		model.put("githubRepoName", githubRepoName);

		return "parameters";
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

	@RequestMapping(value = "/save-metrics", method = RequestMethod.POST)
	@ResponseBody
	public void postConfig(@RequestBody String config) throws IOException {
    	File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\static\\metricsConfig.json");
		FileWriter fileWritter = new FileWriter(file);
		fileWritter.write(config);
		fileWritter.close();
	}
}