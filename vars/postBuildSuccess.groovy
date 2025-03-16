def call(String emailRecipient, String slackChannel) {
    echo "Sending success notifications..."
    
    emailext body: """Hello,

The Jenkins pipeline ${env.JOB_NAME} has completed successfully on Build #${env.BUILD_NUMBER}.

Build Details:
- Job Name: ${env.JOB_NAME}  
- Build Number: ${env.BUILD_NUMBER}  
- Build URL: ${env.BUILD_URL}  

Best regards,  
Jenkins CI
""", 
            subject: "Job Name: ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}", 
            to: emailRecipient
    
    slackSend(channel: slackChannel, 
              message: "Build Successful: JOB-Name:- ${env.JOB_NAME} Build_No.:- ${env.BUILD_NUMBER} & Build-URL:- ${env.BUILD_URL}", 
              tokenCredentialId: 'slack')
}
