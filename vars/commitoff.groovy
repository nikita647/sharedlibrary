def call() {
    def gitCommit = sh(script: 'git log -1 --pretty=%an', returnStdout: true).trim()
                    def gitCommitMsg = sh(script: 'git log -1 --pretty=%B', returnStdout: true).trim()

                    // Check if commit sign-off is present
                    if (gitCommitMsg.contains('Signed-off-by:')) {
                        echo "Last commit by ${gitCommit} has a sign-off."
                    } 
                    
                    else {
                        // Map of usernames to their respective emails
                        def usernameEmailMap = [
                            'jnikita647': 'jnikita647@gmail.com '
               
                        ]

                        // Get the email for the commit author
                        def email = usernameEmailMap[gitCommit]

                        if (email) {
                            // Amend the commit with the sign-off
                            sh """
                                git commit --amend --signoff --author='${gitCommit} <${email}>' -m '${gitCommitMsg} Signed-off-by: ${email}'
                            """
                            echo "Commit message updated with sign-off by ${gitCommit}."
                        }
                        else {
                            error "Unable to find email for ${gitCommit}."
                        }
                    }
                

}
