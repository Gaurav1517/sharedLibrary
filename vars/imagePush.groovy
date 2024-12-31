def docker() {
    stage('Docker Image Push') {
        steps {
            script {
                withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', usernameVariable: 'docker_user', passwordVariable: 'docker_pass')]) {
                    // Login to Docker Hub
                    sh "docker login -u '${docker_user}' -p '${docker_pass}'"
                    def JOB = env.JOB_NAME.toLowerCase()
                    // Push the image to Docker Hub
                    sh "docker push ${docker_user}/${JOB}:v${BUILD_NUMBER}"
                    sh "docker push ${docker_user}/${JOB}:latest"
                }
            }
        }
    }
}
