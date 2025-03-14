def call(String emailRecipient, String slackChannel) {
    echo "Sending failure notifications..."
    
    emailext body: """Hello,

The Jenkins pipeline ${env.JOB_NAME} has failed on Build #${env.BUILD_NUMBER}.

Job Details:
- Job Name: ${env.JOB_NAME}  
- Build Number: ${env.BUILD_NUMBER}  
- Build URL: ${env.BUILD_URL}  

Please review the attached logs and reports for more details.

Regards,  
Jenkins CI
""", 
            subject: "Job Name: ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}", 
            to: emailRecipient
    
    // Slack notification
    slackSend(channel: slackChannel, 
              message: "Build Failed: JOB-Name:- ${env.JOB_NAME} Build_No.:- ${env.BUILD_NUMBER} & Build-URL:- ${env.BUILD_URL}", 
              tokenCredentialId: 'slack')
}
