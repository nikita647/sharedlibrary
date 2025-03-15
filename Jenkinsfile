@Library ('my-shared-library@Nikita-155') _

pipeline {
    agent any
    
    tools {
        maven 'maven'
    }
    
    stages{
        stage('clean-workspace') {
            steps{
                script {
                cleanWorkspace()
                }
            }
        }
        
        stage('git clone') {
            steps {
                script {
                gitClone('main' , 'https://github.com/snaatak-Zero-Downtime-Crew/salary-api.git' , 'git-cred')
                }
            }
        }
        
        stage('Compile') {
                steps {
                    mavenCompile()
                }
            }
            
            
            
    }
    
    post {
        
        success {
            postBuildSuccess("jnikita647@gmail.com", "jenkins")
            }
            
            failure {
                postBuildFailure("jnikita647@gmail.com", "jenkins")
            }
        
    }
}
    
    
   
    
