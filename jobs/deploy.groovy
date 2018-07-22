pipelineJob('deployClickCount') {
    parameters {
        choiceParam('ENVIRONMENT_NAME', ['STAGING', 'PROD'])
    }
    definition {
        cps {
            script('''
stage "deploy"
node {
    deleteDir()
    git "https://github.com/loikbriand/xebia.git"
    sshagent(credentials: ["AWS_SSH_KEY"], ignoreMissing: false) {
        withEnv(['ANSIBLE_CONFIG=ansible/ansible.cfg']) {
            sh 'echo \$ANSIBLE_CONFIG'
            sh "ansible-playbook -i ansible/\${ENVIRONMENT_NAME}/hosts ansible/deploy.yml"
        }
    }
}            
''')
            sandbox()
        }
    }
}