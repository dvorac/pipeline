package com.dvorac.pipeline;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class PipelinePlugin implements Plugin<Project> {

    static final String TASK_NAME = "releaseNotes";

    public void apply(Project project) {
        project.getTasks().create(TASK_NAME, ReleaseNotesTask.class);
    }
}
