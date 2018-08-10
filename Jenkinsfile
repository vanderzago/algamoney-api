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
        sh "${dockerCMD} build -f docker/api.dockerfile -t vanderz/moneyapi:1.1.0 ."
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
        sh "${dockerCMD} build -f docker/postgres.dockerfile -t vanderz/moneydb:1.2.0 ."
    }
    stage ('Push Postgres Docker Image'){
        def dockerHome = tool name: 'Docker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
        def dockerCMD = "sudo ${dockerHome}/bin/docker"
        withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubPasswd')]) {
            sh "${dockerCMD} login -u vanderzago -p ${dockerhubPasswd}"
        }
        sh "${dockerCMD} tag vanderz/moneydb:1.2.0 vanderzago/moneydb:1.2.0"
        sh "${dockerCMD} push vanderzago/moneydb:1.2.0"
    }
    stage ('Connect Kubernetes Engine'){
        def GCSHome = tool name: 'Google Cloud SDK', type: 'com.cloudbees.jenkins.plugins.gcloudsdk.GCloudInstallation'
        def GCSCMD = "${GCSHome}/bin/gcloud"
        sh "${GCSCMD} auth activate-service-account 411677944816-compute@developer.gserviceaccount.com --key-file /usr/share/jenkins/ref/totemic-effect-212520-dd35111cff86.json --project totemic-effect-212520"
        sh "${GCSCMD} container clusters get-credentials algamoneyapi --zone southamerica-east1-a --project totemic-effect-212520"
    }
    stage ('Deploy Database on Kubernetes cluster'){
        sh 'kubectl apply -f kubernetes/db/permissoes.yaml'
        sh 'kubectl apply -f kubernetes/db/servico-banco.yaml'
        sh 'kubectl apply -f kubernetes/db/statefulSet.yaml'
    }
    stage ('Deploy Application on Kubernetes cluster'){
        sh 'kubectl apply -f kubernetes/app/deployment.yaml'
        sh 'kubectl apply -f kubernetes/app/servico-aplicacao.yaml'
    }
}
