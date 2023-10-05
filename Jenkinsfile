pipeline {
    agent any

    tools {
        maven "jenkins_maven"
    }

    stages {
        stage('Verify') {
            steps {
                git branch: 'master', credentialsId: '', url: ''
                sh "mvn clean verify"
            }
            post {
                success {
                    ansiblePlaybook credentialsId: '', installation: 'jenkins_ansible', inventory: 'ansible/inventory', playbook: 'ansible/playbook.yml'
                }
            }
        }
    }
}
