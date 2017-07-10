#!/usr/bin/groovy
import com.dell.cpsd.SCM.Utils

def call(String action = '', String tag_name = '', String name = '', String body = '') {

    def utils = new com.dell.cpsd.SCM.Utils()
//    def repoName = utils.getRepoName()
//    def orgName = utils.getOrgName()
    def repoName = "travis-ci-tutorial-java"
    def orgName = "chamap1"
    
    if (action == 'edit' || 'delete' && tag_name == '' || name == '' || body == ''){
        println("Requested to edit/delete a Github Release")
    }
    
    else {
        if (tag_name == ''){
            tag_name = "v1.0.0.${BUILD_ID}"
        }

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
}
