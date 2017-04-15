#!/usr/bin/groovy

def call() {
      withSonarQubeEnv('SonarQube') { 
            sh '''
                mvn sonar:sonar \
                    -Dsonar.host.url=$SONAR_HOST_URL \
                    -Dsonar.login=$SONAR_AUTH_TOKEN \
                    -Dsonar.java.coveragePlugin=jacoco \
                    -Dsonar.junit.reportsPath=target/surefire-reports \
                    -Dsonar.jacoco.reportPath=target/coverage-reports/jacoco-ut.exec \
                    -Dsonar.jacoco.itReportPath=target/coverage-reports/jacoco-it.exec \
                    -Dsonar.dependencyCheck.reportPath=${WORKSPACE}/report/dependency-check-report.xml
                '''
       }
}
