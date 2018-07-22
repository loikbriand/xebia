pipelineJob('test deploy clickCount') {
    parameters {
        choiceParam('ENVIRONMENT_NAME', ['STAGING(default)', 'PROD'])
    }
    definition {
        cps {
            script('''
stage "deploy"
node {
    deleteDir()
    git "https://github.com/loikbriand/xebia.git"
    sshagent(credentials: ["AWS_SSH_KEY"], ignoreMissing: false) {
        sh \'\'\'
cd ansible
export ANSIBLE_CONFIG=./ansible.cfg
ansible-playbook -i \$ENVIRONMENT_NAME/hosts test.yml
\'\'\'
    }
}            
''')
            sandbox()
        }
    }
}