def call() {
    // Ensure the config is applied globally
    sh 'git config --global commit.gpgsign false'
    // Confirm the change took effect
    sh 'git config --get commit.gpgsign'
    // Identify unsigned commits
    def unsignedCommits = sh(script: '''
        git log --pretty=format:"%h - %an: %s" --show-signature | grep -i -v "signed-off-by" || true
    ''', returnStdout: true).trim()
    // Fail the build if unsigned commits are found
    if (unsignedCommits) {
        error "The following commits are missing a sign-off:\n${unsignedCommits}"
    }
}
