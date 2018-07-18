pipelineJob('example') {
    definition {
        cps {
            sandbox("toto")
        }
    }
}