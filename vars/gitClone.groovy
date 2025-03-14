def call(String branch, String repo, String credentialsId) {
    checkout([
        $class: 'GitSCM',
        branches: [[name: "*/${branch}"]],
        userRemoteConfigs: [[url: repo, credentialsId: credentialsId]]
    ])
}
