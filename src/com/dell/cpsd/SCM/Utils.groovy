#!/usr/bin/groovy

package com.dell.cpsd.SCM

def getRepoName() {
  
  if (env.JOB_NAME ==~ /dellemc.*/) {
    return env.JOB_NAME.replaceAll("dellemc-symphony/", "").replaceAll("/${BRANCH_NAME}", "")
  }
  else if (env.JOB_NAME ==~ /vce.*/) {
    return env.JOB_NAME.replaceAll("vce-symphony/", "").replaceAll("/${BRANCH_NAME}", "")
  }
}
