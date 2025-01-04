def call(String docker_user) {
    sh """
        trivy image \
        --format table \
        ${docker_user}/${env.JOB_NAME.toLowerCase()}:latest \
        -o ${env.JOB_NAME.toLowerCase()}-trivy_report.html
    """
}
