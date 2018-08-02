node {
    stage ('SCM Checkout'){
        git branch: 'postgres', credentialsId: 'github-pwd', url: 'https://github.com/vanderzago/algamoney-api.git'        
    }
    stage ('MVN Package'){
        def mvnHome = tool name: 'Maven3', type: 'maven'
        def mvnCMD = "${mvnHome}/bin/mvn"
        sh "${mvnCMD} clean package -DskipTests"
    }
    stage ('Build APP Docker Image'){
        def dockerHome = tool name: 'Docker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
        def dockerCMD = "sudo ${dockerHome}/bin/docker"
        sh "${dockerCMD} build -t vanderz/moneyapi:1.1.0 ."
    }
    stage ('Push APP Docker Image'){
        def dockerHome = tool name: 'Docker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
        def dockerCMD = "sudo ${dockerHome}/bin/docker"
        withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubPasswd')]) {
            sh "${dockerCMD} login -u vanderzago -p ${dockerhubPasswd}"
        }
        sh "${dockerCMD} tag vanderz/moneyapi:1.1.0 vanderzago/moneyapi:1.1.0"
        sh "${dockerCMD} push vanderzago/moneyapi:1.1.0"
    }
    stage ('Build Postgres Docker Image'){
        def dockerHome = tool name: 'Docker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
        def dockerCMD = "sudo ${dockerHome}/bin/docker"
        sh "${dockerCMD} build -t vanderz/moneydb:1.1.0 postgres.dockerfile"
    }
    stage ('Push Postgres Docker Image'){
        def dockerHome = tool name: 'Docker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
        def dockerCMD = "sudo ${dockerHome}/bin/docker"
        withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubPasswd')]) {
            sh "${dockerCMD} login -u vanderzago -p ${dockerhubPasswd}"
        }
        sh "${dockerCMD} tag vanderz/moneydb:1.1.0 vanderzago/moneydb:1.1.0"
        sh "${dockerCMD} push vanderzago/moneydb:1.1.0"
    }
}
