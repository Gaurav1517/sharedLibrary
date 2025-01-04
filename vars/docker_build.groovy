def call(String JOB_NAME, int BUILD_NUMBER) {
  sh "docker build -t ${JOB_NAME.toLowerCase()}:v${BUILD_NUMBER} ."
}
