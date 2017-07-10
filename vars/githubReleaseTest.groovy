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
        sh "curl -i -H 'Authorization: token 222fd1a2dcbfa35fa92e4c9c29314b977f29990f' \
            -d '{ \
            "tag_name": "v1.0.9002", \
            "target_commitish": "master", \
            "name": "v1.0.9002 testing", \
            "body": "Description of the rel testing", \
            "draft": false, \
            "prerelease": false \
            }' \
            https://api.github.com/repos/${orgName}/${repoName}/releases"
    }
    else {
        println("Github Release skipped! Branch name pattern did not match 'release/*'.")
    } 
}
