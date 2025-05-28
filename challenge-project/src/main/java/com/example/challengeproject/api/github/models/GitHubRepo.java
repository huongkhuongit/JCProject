package com.example.challengeproject.api.github.models;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class GitHubRepo {

    private String name;

    private String description;

    private String language;

    @SerializedName("open_issues_count")
    private int openIssuesCount;

    @SerializedName("watchers_count")
    private int watchersCount;

    @SerializedName("stargazers_count")
    private int starsCount;

    @SerializedName("forks_count")
    private int forksCount;

    @SerializedName("updated_at")
    private String updatedAt;

    private Owner owner; // Nested object

    @Data
    public static class Owner {
        private String login;
    }
}

