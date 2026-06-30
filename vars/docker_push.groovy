def call(String projectName, String imageTag, String dockerHubUser) {

    withCredentials([usernamePassword(
        credentialsId: "dockerHubCred",
        usernameVariable: "dockerHubUser",
        passwordVariable: "dockerHubPass"
    )]) {

        sh "echo \$dockerHubPass | docker login -u \$dockerHubUser --password-stdin"
    }

    sh "docker push ${dockerHubUser}/${projectName}:${imageTag}"
}
     
  
