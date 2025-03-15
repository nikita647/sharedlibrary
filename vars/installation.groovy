def call() {

  sh '''
                sudo apt install unzip -y
                wget https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-7.0.2.4839-linux-x64.zip
                unzip sonar-scanner-cli-7.0.2.4839-linux-x64.zip
                sudo rm -rf /opt/sonar-scanner
                sudo mv sonar-scanner-7.0.2.4839-linux-x64 /opt/sonar-scanner
                echo 'export PATH=$PATH:/opt/sonar-scanner/bin' >> ~/.bashrc
                . ~/.bashrc
            '''
}
