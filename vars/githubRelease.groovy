#!/usr/bin/groovy
import com.dell.cpsd.SCM.Utils

def call() {
    
    sh "echo Github Release stage skipped!"

//    def utils = new com.dell.cpsd.SCM.Utils()
//    def repoName = utils.getRepoName()
//    
//    if (env.BRANCH_NAME ==~ /release\/.*/) {
//        dir('/opt'){
//            sh "rm -f linux-amd64-github-release.tar.bz2"
//            sh "wget https://github.com/aktau/github-release/releases/download/v0.7.2/linux-amd64-github-release.tar.bz2"
//            sh "tar -xvjf linux-amd64-github-release.tar.bz2"
//            sh "yes | cp bin/linux/amd64/github-release /usr/bin/"
//            sh "github-release release \
//                    --user dellemc-symphony \
//                    --repo ${repoName} \
//                    --tag v0.0.1-${BRANCH_NAME}-${BUILD_ID} \
//                    --name '${repoName} release' \
//                    --description '${repoName} release'"
//            sh "github-release upload \
//                    --user dellemc-symphony \
//                    --repo ${repoName} \
//                    --tag v0.0.1-${BRANCH_NAME}-${BUILD_ID} \
//                    --name '${repoName} release' \
//                    --file ${WORKSPACE}/target/${repoName}-1.0-SNAPSHOT.jar"
//        }
//    }
//    else {
//        println("Github Release skipped! Branch name pattern did not match 'release/*'.")
//    } 
}
