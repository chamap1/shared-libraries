#!/usr/bin/groovy

def doCompile() {
  sh "mvn compile"
  sh "echo You are awesome!"
}
