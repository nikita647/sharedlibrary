def call() {
      def unsignedCommits = sh(script: '''
                        git log --pretty=format:"%h - %an: %s" --show-signature | grep -i -v "signed-off-by"
                    ''', returnStdout: true).trim()

                    if (unsignedCommits) {
                        error "The following commits are missing a sign-off:\n${unsignedCommits}"
                    }
}
