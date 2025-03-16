def call() {
    // Disable GPG signing globally
    sh 'git config --global commit.gpgsign false'
    
    // Confirm the setting
    sh 'git config --get commit.gpgsign'
    
    // Identify unsigned commits (ignore GPG signature messages)
    def unsignedCommits = sh(script: '''
        git log --pretty=format:"%h - %an: %s" | grep -v "Signed-off-by" || true
    ''', returnStdout: true).trim()
    
    // Fail if unsigned commits are found
    if (unsignedCommits) {
        error "The following commits are missing a sign-off:\n${unsignedCommits}"
    }
}
