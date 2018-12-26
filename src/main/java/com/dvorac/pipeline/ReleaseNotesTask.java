package com.dvorac.pipeline;

import groovy.util.logging.Slf4j;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.gradle.api.DefaultTask;
import org.gradle.api.internal.tasks.options.Option;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

@Slf4j
public class ReleaseNotesTask extends DefaultTask {

    private static Logger log = LoggerFactory.getLogger(ReleaseNotesTask.class);

    private String repoUrl;
    private String outputFile;

    @Input
    public String getRepoUrl() {
        return repoUrl;
    }

    @Option(option = "url", description = "the git repo to fetch")
    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }

    @Input
    public String getOutputFile() {
        return outputFile;
    }

    @Option(option = "outputFile", description = "filepath of output file")
    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    @TaskAction
    public void generate() throws IOException, GitAPIException {
        // prepare a new temp folder for cloned repo
        File tmp = File.createTempFile("release-notes-repo", "");
        if (!tmp.delete()) {
            throw new IOException("cannot delete repo temp directory");
        }

        // clone repo
        try (Git result = Git.cloneRepository()
                .setURI(repoUrl)
                .setDirectory(tmp)
                .call()) {
            File repo = result.getRepository().getDirectory();

            log.info("repo dir: {}", repo.toString());
        }

//        File releaseNotes = new File(outputFile);
    }
}
