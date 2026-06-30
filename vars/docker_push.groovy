def call (String ImageTag, String dockerhubuser){
   withCredentials([usernamePassword(
        credentialsId: "dockerHubCred" ,
        usernameVariable: 'dockerHubUser',
        passwordVariable: 'dockerHubPass')]) {
      sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
}
  sh "docker push ${dockerhubuser}/${Projecr}:${ImageTag}"
}
     
  
