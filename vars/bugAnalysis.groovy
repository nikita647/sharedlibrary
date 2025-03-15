def call() {
                   echo "Using SonarQube Project Key: ${projectKey_name}"
            withSonarQubeEnv('sonar') {
                withCredentials([string(credentialsId: 'sonartoken', variable: 'SONARQUBE_TOKEN')]) {
                    sh """
                        /opt/sonar-scanner/bin/sonar-scanner \
                        -Dsonar.projectKey=${projectKey_name} \
                        -Dsonar.sources=. \
                        -Dsonar.token=${SONARQUBE_TOKEN}
                    """
                }
            }
    }
