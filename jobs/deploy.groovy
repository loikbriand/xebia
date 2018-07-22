pipelineJob('test deploy clickCount') {
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
pwd
export ANSIBLE_CONFIG=./ansible.cfg
ansible-playbook -i hosts test.yml
\'\'\'
    }
}            
''')
            sandbox()
        }
    }
}