pipelineJob('example') {
    definition {
        cps {
            script("project-a-workflow")
            sandbox()
        }
    }
}