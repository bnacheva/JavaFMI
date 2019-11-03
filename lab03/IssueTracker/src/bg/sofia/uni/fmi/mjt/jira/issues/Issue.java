package bg.sofia.uni.fmi.mjt.jira.issues;

import bg.sofia.uni.fmi.mjt.jira.enums.IssuePriority;
import bg.sofia.uni.fmi.mjt.jira.enums.IssueResolution;
import bg.sofia.uni.fmi.mjt.jira.enums.IssueStatus;
import bg.sofia.uni.fmi.mjt.jira.enums.WorkAction;
import org.jetbrains.annotations.Contract;

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

    @Contract(pure = true)
    public Issue(IssuePriority priority, Component component, String description) {
        this.issuePriority = priority;
        this.component = component;
        this.description = description;
    }

    public String getIssueID() { return this.issueID; }

    public String getDescription() { return this.description; }

    public IssuePriority getPriority() { return this.issuePriority; }

    public IssueResolution getResolution() { return this.issueResolution; }

    public IssueStatus getStatus() { return this.issueStatus; }

    public Component getComponent() { return this.component; }

    public LocalDateTime getCreatedOn() { return this.createdOn; }

    public LocalDateTime getLastModifiedOn() { return this.lastModifiedOn; }

    public String[] getActionLog(){ return this.actionLog; }

    public void setIssueID(String issueID) { this.issueID = issueID; }

    public void setDescription(String description) { this.description = description; }

    public void setIssuePriority(IssuePriority issuePriority) { this.issuePriority = issuePriority; }

    public void setIssueResolution(IssueResolution issueResolution) { this.issueResolution = issueResolution; }

    public void setStatus(IssueStatus status) { this.issueStatus = status; }

    public void setComponent(Component component) { this.component = component; }

    public void setCreatedOn(LocalDateTime createdOn) { this.createdOn = createdOn; }

    public void setLastModifiedOn(LocalDateTime lastModifiedOn) { this.lastModifiedOn = lastModifiedOn; }

    public void setActionLog(String[] actionLog) { this.actionLog = actionLog; }

    public void addAction(WorkAction action, String description) { }

    public abstract void resolve(IssueResolution resolution);
}
