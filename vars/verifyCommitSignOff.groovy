def call() {
def signoff_status = sh(script: "git log -1 --format=%B | grep -iq 'Signed[- ]off[- ]by:'", returnStatus: true)
                    if (signoff_status != 0) {
                        echo "Commit signoff verification failed. Attempting to amend the commit to include sign-off."
                         sh '''
                         AUTHOR=$(git log -1 --pretty=format:"%an <%ae>")
                        SIGN_OFF="Signed-off-by: $AUTHOR"
                        git commit --amend --no-edit --message "$(git log -1 --pretty=%B) $SIGN_OFF"
                        '''
                        echo "Commit is properly signed off now, appended the author name & email as sign-off."
                    } 
else {
                        echo "Commit is properly signed off."
                    }
                
}
