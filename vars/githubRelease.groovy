#!/usr/bin/groovy

def call() {
    if (env.BRANCH_NAME ==~ /release\/.*/) {
        dir('/opt'){
            sh "rm -f linux-amd64-github-release.tar.bz2"
            sh "wget https://github.com/aktau/github-release/releases/download/v0.7.2/linux-amd64-github-release.tar.bz2"
            sh "tar -xvjf linux-amd64-github-release.tar.bz2"
            sh "yes | cp bin/linux/amd64/github-release /usr/bin/"
            sh '''
                github-release release \
                    --user dellemc-symphony \
                    --repo  rcm-evaluation-service-api \
                    --tag v0.0.1-${BRANCH_NAME}-${BUILD_ID} \
                    --name "rcm-evaluation-service-api release" \
                    --description "rcm-evaluation-service-api release"
                github-release upload \
                    --user dellemc-symphony \
                    --repo rcm-evaluation-service-api \
                    --tag v0.0.1-${BRANCH_NAME}-${BUILD_ID} \
                    --name "rcm-evaluation-service-api release" \
                    --file ${WORKSPACE}/target/travis-ci-tutorial-java-1.0-SNAPSHOT.jar
            '''
        }
    }
    else {
        println("Github Release skipped! Branch name pattern did not match 'release/*'.")
    }
}
