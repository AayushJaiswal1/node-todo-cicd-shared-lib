def call (String credID, String imageName, String imageTag){
  echo "pusiing code in docker hub"
                withCredentials([usernamePassword(
                    credentialsId:credID,
                    usernameVariable:"dockerHubUser",
                    passwordVariable:"dockerHubPass")]){
                    sh 'echo $dockerHubPass | docker login -u $dockerHubUser --password-stdin'
                    sh "docker image tag ${imageName}:${imageTag} ${env.dockerHubUser}/${imageName}:${imageTag}"
                    sh "docker push ${env.dockerHubUser}/${imageName}:${imageTag}"
}
