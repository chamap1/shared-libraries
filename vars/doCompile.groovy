#!/usr/bin/groovy

def call() {
  println getRepoName()
  sh "mvn compile"
  sh "echo You are awesome!"
}

def getRepoName() {
  return env.JOB_NAME
}
