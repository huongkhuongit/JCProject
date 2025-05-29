package com.example.challengeproject;

import com.example.challengeproject.api.github.models.GitHubRepo;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class GithubApiTest {

    private static final String BASE_URL = "https://api.github.com";
    private static final String ORG = "SeleniumHQ";

    @Test
    public void testGitHubOrganizationRepos() {
        Response response = RestAssured
                .given()
                .baseUri(BASE_URL)
                .when()
                .get("/orgs/" + ORG + "/repos?per_page=100")
                .then()
                .statusCode(200)
                .extract().response();

        Gson gson = new Gson();
        List<GitHubRepo> gitHubRepoList = Arrays.asList(gson.fromJson(response.asString(), GitHubRepo[].class));

        int totalOpenIssues = gitHubRepoList.stream()
                .mapToInt(GitHubRepo::getOpenIssuesCount)
                .sum();

        GitHubRepo maxWatchersRepo = gitHubRepoList.stream()
                .max(Comparator.comparingInt(GitHubRepo::getWatchersCount))
                .orElse(null);

        // Sort List repo để tìm 5 repo update cuối cùng
        List<GitHubRepo> sortedRepos = gitHubRepoList.stream()
                .sorted(Comparator.comparing((GitHubRepo r) -> Instant.parse(r.getUpdatedAt())).reversed())
                .limit(5)
                .collect(Collectors.toList());


        // 1. Tổng số open issues
        System.out.println("1, Total open issues across all repos: " + totalOpenIssues);

        // 2. Sắp xếp theo updated_at giảm dần
        System.out.println("2, Top 5 repos sorted by updated_at:");
        sortedRepos.stream().forEach(repo ->
                System.out.println(" + " + repo.getName() + " - " + repo.getUpdatedAt())
        );

        // 3. Repo có nhiều watchers nhất
        System.out.println("3, Most watched repo: " + maxWatchersRepo.getName() + " with " + maxWatchersRepo.getWatchersCount() + " watchers.");
    }
}
