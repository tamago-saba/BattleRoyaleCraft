pipeline {

    agent any

    environment {
        DISCORD_WEBHOOK = credentials("tamago-saba-discord-webhook")
    }

    stages {
        stage("Build") {
            agent {
                docker {
                    image "maven:3.8.5-jdk-11"
                    args "-v $HOME/.m2:/root/.m2"
                }
            }
            steps {
                sh "mvn clean package"
            }
            post {
                success {
                    archiveArtifacts "target/*.jar"
                }
            }
        }
    }

    post {
        always {
            discordSend webhookURL: "${env.DISCORD_WEBHOOK}"
        }
    }

}
