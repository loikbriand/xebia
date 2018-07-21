pipelineJob('build clickCount') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/loikbriand/xebia.git')
                    }
                    branches('master')
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
}