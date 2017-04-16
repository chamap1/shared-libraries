#!/usr/bin/groovy

def call() {
  def utils = new com.dell.cpsd.SCM.Utils()
  println utils.getRepoName()
  sh "mvn compile"
  sh "echo You are awesome!"
}
