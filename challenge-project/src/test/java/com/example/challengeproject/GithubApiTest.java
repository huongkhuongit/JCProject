package com.example.challengeproject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GithubApiTest {

    private static final String BASE_URL = "https://api.github.com";
    private static final String ORG = "SeleniumHQ";

    @Test
    public void testGitHubOrganizationRepos() {
        // Gọi API lấy tất cả repo
        Response response = RestAssured
                .given()
                .baseUri(BASE_URL)
                .when()
                .get("/orgs/" + ORG + "/repos?per_page=100") // lấy tối đa 100 repo
                .then()
                .statusCode(200)
                .extract().response();

        List<Map<String, Object>> repos = response.jsonPath().getList("");

        int totalOpenIssues = 0;
        Map<String, Object> mostWatchedRepo = null;
        int maxWatchers = -1;

        // Duyệt qua từng repo để tổng hợp
        for (Map<String, Object> repo : repos) {
            int openIssues = (Integer) repo.get("open_issues_count");
            int watchers = (Integer) repo.get("watchers_count");
            totalOpenIssues += openIssues;

            if (watchers > maxWatchers) {
                maxWatchers = watchers;
                mostWatchedRepo = repo;
            }
        }

        // ✅ 1. Tổng số open issues
        System.out.println("Total open issues across all repos: " + totalOpenIssues);

        // ✅ 2. Sắp xếp theo updated_at giảm dần
        repos.sort((a, b) -> ((String) b.get("updated_at")).compareTo((String) a.get("updated_at")));
        System.out.println("Top 5 repos sorted by updated_at:");
        repos.stream().limit(5).forEach(repo ->
                System.out.println(repo.get("name") + " - " + repo.get("updated_at"))
        );

        // ✅ 3. Repo có nhiều watchers nhất
        if (mostWatchedRepo != null) {
            System.out.println("Most watched repo: " + mostWatchedRepo.get("name")
                    + " with " + mostWatchedRepo.get("watchers_count") + " watchers.");
        }

        // Assertions
        assertTrue(totalOpenIssues >= 0, "Total open issues should be >= 0");
        assertNotNull(mostWatchedRepo, "There should be at least one repo");
    }
}
