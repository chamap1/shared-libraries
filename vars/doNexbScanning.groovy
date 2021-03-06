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
    sh "mkdir -p /opt/nexB/${JOB_NAME}/nexb-output/"
    sh "sh /opt/nexB/scancode --help"
    sh "sh /opt/nexB/scancode --format html ${WORKSPACE} /opt/nexB/${JOB_NAME}/nexb-output/${repoName}.html"
    sh "sh /opt/nexB/scancode --format html-app ${WORKSPACE} /opt/nexB/${JOB_NAME}/nexb-output/${repoName}-grap.html"	       
    sh "mv /opt/nexB/${JOB_NAME}/nexb-output/ ${WORKSPACE}/"
    archiveArtifacts '**/nexb-output/**'    
}
