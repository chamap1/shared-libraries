#!/usr/bin/groovy

package com.dell.cpsd.SCM

def getRepoName() {
  return env.JOB_NAME.replaceAll("dellemc-symphony/", "").replaceAll("/${BRANCH_NAME}", "")
}

def getRepoName2() {
  return env.JOB_NAME.replaceAll("vce-symphony/", "").replaceAll("/${BRANCH_NAME}", "")
}
