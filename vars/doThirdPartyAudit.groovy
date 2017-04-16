#!/usr/bin/groovy

def call() {
    sh '''
        mvn org.apache.maven.plugins:maven-dependency-plugin:2.10:analyze-report license:add-third-party org.apache.maven.plugins:maven-dependency-plugin:2.10:tree \
        -DoutputType=dot \
        -DoutputFile=${WORKSPACE}/report/dependency-tree.dot
        '''   
    archiveArtifacts '**/dependency-analysis.html, **/THIRD-PARTY.txt, **/dependency-check-report.html, **/dependency-tree.dot'
}
