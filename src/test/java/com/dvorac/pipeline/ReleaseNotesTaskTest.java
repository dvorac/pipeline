package com.dvorac.pipeline;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ReleaseNotesTaskTest {

    private ReleaseNotesTask target;

    @BeforeAll
    void setup() {
        target = new ReleaseNotesTask();


    }

    @Test
    void generate() throws IOException, GitAPIException {
        // exercise
        target.generate();
    }
}