#!/usr/bin/groovy

def call() {
  sh "mvn compile"
  sh "echo You are awesome!"
}
