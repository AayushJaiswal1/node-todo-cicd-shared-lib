def call(String name, String tag){
  sh "docker build -t ${name}:${tag} ."
}
