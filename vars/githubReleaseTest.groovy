#!/usr/bin/groovy
import com.dell.cpsd.SCM.Utils

def call() {

    def utils = new com.dell.cpsd.SCM.Utils()
//    def repoName = utils.getRepoName()
//    def orgName = utils.getOrgName()
    def repoName = "travis-ci-tutorial-java"
    def orgName = "chamap1"
       
    if (env.BRANCH_NAME ==~ /release\/.*/) {
        sh "echo https://api.github.com/repos/${orgName}/${repoName}/releases"
        sh """
            curl -i -H 'Authorization: token ${GITHUB_TOKEN}' \
            -d '{ \
            "tag_name": "${RELEASE_TAG_NAME}", \
            "target_commitish": "master", \
            "name": "${RELEASE_NAME}", \
            "body": "${RELEASE_BODY}", \
            "draft": false, \
            "prerelease": false \
            }' \
            https://api.github.com/repos/${orgName}/${repoName}/releases
            """
    }
    else {
        println("Github Release skipped! Branch name pattern did not match 'release/*'.")
    } 
}
