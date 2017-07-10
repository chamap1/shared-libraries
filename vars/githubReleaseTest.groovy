#!/usr/bin/groovy
import com.dell.cpsd.SCM.Utils

def call(String tag_name) {

    def utils = new com.dell.cpsd.SCM.Utils()
//    def repoName = utils.getRepoName()
//    def orgName = utils.getOrgName()
    def repoName = "travis-ci-tutorial-java"
    def orgName = "chamap1"
    println(tag_name)
//    if (tag_name == ''){
//        tag_name = "v1.0.0.${BUILD_ID}"
//    }
    def name = ''
    def body = ''
    if (name == ''){
        name = "${repoName} Release"
    }
    
    if (body == ''){
        body = "${repoName} Release"
    }
       
    if (env.BRANCH_NAME ==~ /release\/.*/) {
        sh "echo https://api.github.com/repos/${orgName}/${repoName}/releases"
        sh """
            curl -i -H 'Authorization: token ${GITHUB_TOKEN}' \
            -d '{ \
            "tag_name": "${tag_name}", \
            "target_commitish": "master", \
            "name": "${name}", \
            "body": "${body}", \
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
