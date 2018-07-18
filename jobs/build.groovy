pipelineJob('build clickCount') {
    definition {
        cps {
            script('''
stage "build"
node {
    deleteDir()
    git "https://github.com/loikbriand/xebia.git"
    sh "mvn clean deploy"
}
''')
            sandbox()
        }
    }
}