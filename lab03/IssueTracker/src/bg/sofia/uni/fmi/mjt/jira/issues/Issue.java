package bg.sofia.uni.fmi.mjt.jira.issues;

import bg.sofia.uni.fmi.mjt.jira.enums.IssuePriority;
import bg.sofia.uni.fmi.mjt.jira.enums.IssueResolution;
import bg.sofia.uni.fmi.mjt.jira.enums.IssueStatus;
import bg.sofia.uni.fmi.mjt.jira.enums.WorkAction;

import java.time.LocalDateTime;

public abstract class Issue {
    private String issueID;
    private String description;
    private IssuePriority issuePriority;
    private IssueResolution issueResolution;
    private IssueStatus issueStatus;
    private Component component;
    private String[] actionLog;
    private LocalDateTime createdOn;
    private LocalDateTime lastModifiedOn;

    public Issue(IssuePriority priority, Component component, String description) {
        this.issuePriority = priority;
        this.component = component;
        this.description = description;
    }

    public String getIssueID() { return null; }

    public String getDescription() { return null; }

    public IssuePriority getPriority() { return null; }

    public IssueResolution getResolution() { return null; }

    public IssueStatus getStatus() { return null; }

    public Component getComponent() { return null; }

    public LocalDateTime getCreatedOn() { return null; }

    public LocalDateTime getLastModifiedOn() { return null; }

    public String[] getActionLog(){ return null; }

    public void setStatus(IssueStatus status) {}

    public void addAction(WorkAction action, String description) {}

    public abstract void resolve(IssueResolution resolution);
}
