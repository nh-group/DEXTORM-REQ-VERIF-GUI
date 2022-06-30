package fr.pantheonsorbonne.cri;

import org.kohsuke.github.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.HtmlUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "root";
    }

    @RequestMapping(value = "/main", method = {RequestMethod.POST, RequestMethod.GET})
    public String welcome(Map<String, Object> model, @RequestParam(value = "githubRepoName", required = false) String githubRepoName,
                          @RequestParam(value = "githubToken", required = true) String githubToken) {
        model.put("message", SpringBootWebApplication.req);
        List<GHIssue> issues = new ArrayList<>();
        try {

            GitHub github = new GitHubBuilder().withOAuthToken(githubToken).build();
            if (githubRepoName == null || githubRepoName.isEmpty()) {
                githubRepoName = "nh-group/basic-cli-uni/";
            }

            GHRepository repo = github.getRepository(githubRepoName);

            for (GHIssue issue : repo.getIssues(GHIssueState.ALL)) {
                if (repo.getFullName().equals("nh-group/basic-cli-uni")) {
                    if (issue.getLabels().stream().map((GHLabel l) -> l.getName()).collect(Collectors.toList())
                            .contains("user stories")) {
                        issues.add(issue);
                    }
                } else {
                    issues.add(issue);
                }

            }

            issues.sort((GHIssue i1, GHIssue i2) -> Integer.compare(i1.getNumber(), i2.getNumber()));

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
        if (githubRepoName == null || githubRepoName.isEmpty()) {
            githubRepoName = "nh-group/basic-cli-uni/";
        }

        //notify dextorm backend that the repo name has changed
        String reqBody = "{\"name\": \"" + githubRepoName + "\"}";
        final String url = "http://localhost:3000/project/settings";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(reqBody, headers);
        restTemplate.postForLocation(url, entity);

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
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\static\\metricsConfig.json");
        FileWriter fileWritter = new FileWriter(file);
        fileWritter.write(config);
        fileWritter.close();
    }
}
