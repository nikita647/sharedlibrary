def call(String repoUrl, String branch = 'main', String credentialsId='') {
    echo "Cloning repository from ${repoUrl}, branch: ${branch}"
    
    if (credentialsId) {
        echo "Using credentials ID: ${credentialsId}"
        git branch: branch, 
            url: repoUrl, 
            credentialsId: credentialsId
    } else {
        git branch: branch, 
            url: repoUrl
    }
}
