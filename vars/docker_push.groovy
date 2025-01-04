def call(String JOB_NAME, String docker_user) {
  withCredentials([
    usernamePassword(
      credentialsId: 'dockerhub-cred', 
      passwordVariable: 'docker_pass', 
      usernameVariable: 'docker_user'
    )
  ]) {
    sh """
      docker login -u ${docker_user} -p ${docker_pass}
    """
    sh """
      docker push ${docker_user}/${env.JOB_NAME.toLowerCase()}:latest
    """
  }
}
