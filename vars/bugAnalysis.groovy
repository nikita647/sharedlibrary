def call(String projectKey_name ) {
                withSonarQubeEnv('sonar') {
                withCredentials([string(credentialsId: 'sonartoken', variable: 'SONARQUBE_TOKEN')]) {
                sh '''
              sonar-scanner \
             -Dsonar.projectKey="${projectKey_name}" \
             -Dsonar.token="${SONARQUBE_TOKEN}"
                '''
                
    }
