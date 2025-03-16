def call(String projectKey_name, String credentialsId) {
    def scannerHome = tool 'SonarQubeScanner'
    echo "Using SonarQube Project Key: ${projectKey_name}"

    withSonarQubeEnv('sonar') {
        withCredentials([string(credentialsId: credentialsId, variable: 'SONARQUBE_TOKEN')]) {
            sh """
                ${scannerHome}/bin/sonar-scanner \
                -Dsonar.projectKey=${projectKey_name} \
                -Dsonar.sources=. \
                -Dsonar.token=${SONARQUBE_TOKEN}
            """
        }
    }
}
