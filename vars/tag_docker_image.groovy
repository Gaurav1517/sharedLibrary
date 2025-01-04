def call(String JOB_NAME, int BUILD_NUMBER, String docker_user) {
    sh """
        docker tag \
        ${JOB_NAME.toLowerCase()}:v${BUILD_NUMBER} \
        ${docker_user}/${JOB_NAME.toLowerCase()}:latest
    """
}
