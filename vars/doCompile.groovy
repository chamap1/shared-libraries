#!/usr/bin/groovy

def call() {
  echo "${env.JOB_NAME}"
  echo "${BRANCH_NAME}"
  sh "mvn compile"
  sh "echo You are awesome!"
}
