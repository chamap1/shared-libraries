#!/usr/bin/groovy
import com.dell.cpsd.SCM.Utils

def call() {
    
    def utils = new com.dell.cpsd.SCM.Utils()
    def repoName = utils.getRepoName()
    
    dir('/opt') {
            checkout([$class: 'GitSCM', 
            branches: [[name: '*/master']], 
            doGenerateSubmoduleConfigurations: false, 
            extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'nexB']], 
            submoduleCfg: [], 
            userRemoteConfigs: [[url: 'https://github.com/nexB/scancode-toolkit.git']]])
    }				
    sh "mkdir -p /opt/nexB/nexb-output/"
    sh "sh /opt/nexB/scancode --help"
    sh "sh /opt/nexB/scancode --format html ${WORKSPACE} /opt/nexB/nexb-output/minimal.html"
    sh "sh /opt/nexB/scancode --format html-app ${WORKSPACE} /opt/nexB/nexb-output/scancode_result.html"	       
    sh "mv /opt/nexB/nexb-output/ ${WORKSPACE}/"
    archiveArtifacts '**/nexb-output/**'
}
