package org.platzi.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {

    CLIArguments() {

    }

    //Jcommander
    @Parameter(
            required = false,
            descriptionKey = "KEYWORD",
            description = "KEYWORD"
    )
    private String keyword;

    @Parameter(
            names = {"--location", "-l"},
            description = "Every search can be by ID"
    )
    private String id;

    @Parameter(
            names = {"--page", "-p"},
            description = "The API returns 50 results, use a number for the pagination",
            validateWith = CLIIdValidator.class
    )
    private int page = 0;

    @Parameter(
            names = {"--full-time"},
            description = "Add if we want a full time job"
    )
    private boolean isFullTime = false;

    @Parameter(
            names = {"--markdown"},
            description = "Get the results in markdown"
    )
    private boolean isMarkdown = false;

    @Parameter(
            names = {"--help", "-h"},
            description = "Show the help",
            validateWith = CLIHelpValidator.class,
            help = true
    )
    private boolean isHelp;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    public boolean isMarkdown() {
        return isMarkdown;
    }

    public void setMarkdown(boolean markdown) {
        isMarkdown = markdown;
    }

    public boolean isHelp() {
        return isHelp;
    }

    public void setHelp(boolean help) {
        isHelp = help;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", id='" + id + '\'' +
                ", page=" + page +
                ", isFullTime=" + isFullTime +
                ", isMarkdown=" + isMarkdown +
                ", isHelp=" + isHelp +
                '}';
    }

    public static CLIArguments newInstance() {
        return new CLIArguments();
    }
}
