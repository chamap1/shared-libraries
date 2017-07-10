#!/usr/bin/groovy
import com.dell.cpsd.SCM.Utils

def call(String tag_name = '', String name = '', String body = '', String action = '', release_id = '') {

    def utils = new com.dell.cpsd.SCM.Utils()
//    def repoName = utils.getRepoName()
//    def orgName = utils.getOrgName()
    def repoName = "travis-ci-tutorial-java"
    def orgName = "chamap1"
    
    if (action == 'edit' || 'delete' && tag_name == '' || name == '' || body == '' || release_id = ''){
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
            if (action == 'edit'){
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
                    https://api.github.com/repos/${orgName}/${repoName}/releases/${release_id}
                    """            
            }
            if (action == 'delete'){
                sh """
                    curl -i -H 'Authorization: token ${GITHUB_TOKEN}' \
                    --X DELETE https://api.github.com/repos/${orgName}/${repoName}/releases/${release_id}
                    """     
            }
            else {
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
        }
        else {
            println("Github Release skipped! Branch name pattern did not match 'release/*'.")
        } 
    }
}
