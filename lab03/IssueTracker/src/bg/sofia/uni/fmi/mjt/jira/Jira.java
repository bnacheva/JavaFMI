package bg.sofia.uni.fmi.mjt.jira;

import bg.sofia.uni.fmi.mjt.jira.enums.IssueResolution;
import bg.sofia.uni.fmi.mjt.jira.enums.WorkAction;
import bg.sofia.uni.fmi.mjt.jira.interfaces.Filter;
import bg.sofia.uni.fmi.mjt.jira.interfaces.Repository;
import bg.sofia.uni.fmi.mjt.jira.issues.Issue;

public class Jira implements Filter, Repository {

    private int size;
    private Issue[] issues;

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Issue[] getIssues() {
        return this.issues;
    }

    public void setIssues(Issue[] issues) {
        this.issues = issues;
    }

    public Jira() {

    }

    public Jira(int size, Issue[] issues) {
        this.size = size;
        this.issues = issues;
    }

    @Override
    public Issue find(String issueID) {
        for (int i = 0; i < issues.length; i++) {
            if (this.issues[i].getIssueID() == issueID) {
                return this.issues[i];
            }
        }
        return null;
    }

    @Override
    public void addIssue(Issue issue) {
        if (this.size > 100) {
            throw new ArrayIndexOutOfBoundsException("The array of issues is full!");
        } else if (this.find(issue.getIssueID()) != null) {
        } else {
            issues[size + 1] = issue;
        }
    }

    public void addActionToIssue(Issue issue, WorkAction action, String actionDescription) {}
    public void resolveIssue(Issue issue, IssueResolution resolution) {}
}
