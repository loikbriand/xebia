pipelineJob('build clickCount') {
    definition {
        cpsScm {
            scm {
                git('https://github.com/loikbriand/xebia.git')
            }
        }
    }
}