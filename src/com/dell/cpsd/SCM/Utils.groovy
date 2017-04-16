#!/usr/bin/groovy

package com.dell.cpsd.SCM

def getRepoName() {
  return env.JOB_NAME.replaceAll("git-org-test-purna/", "").replaceAll("/${BRANCH_NAME}", "")
}
