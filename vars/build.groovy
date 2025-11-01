def call(String name){
  sh "docker build -t ${name} ."
}
