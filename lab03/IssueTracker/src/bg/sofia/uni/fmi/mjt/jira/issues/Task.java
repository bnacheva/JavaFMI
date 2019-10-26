package bg.sofia.uni.fmi.mjt.jira.issues;

import bg.sofia.uni.fmi.mjt.jira.enums.IssuePriority;
import bg.sofia.uni.fmi.mjt.jira.enums.IssueResolution;

public class Task extends Issue {
    public Task(IssuePriority priority, Component component, String description) {
        super(priority, component, description);
    }

    @Override
    public void resolve(IssueResolution resolution) {

    }
}
