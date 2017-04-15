#!/usr/bin/groovy
package com.dell.cpsd.continuous-integration

def doCompile() {
  sh "mvn compile"
}
