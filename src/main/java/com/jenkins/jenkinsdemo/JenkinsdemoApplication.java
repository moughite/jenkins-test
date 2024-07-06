package com.jenkins.jenkinsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinsdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JenkinsdemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String getMessage(){
		return " hello message!!!!!" ;
	}

}

/*
pipeline {
    agent any

    environment {
        NGROK_TOKEN = '2ipWd4ZosRKCKTJhoC9UxAql5xc_5ckiiDrm1j3HLihbF7vNZ'
        PATH = "/usr/local/bin:/opt/homebrew/bin:/usr/local/opt/openjdk@17/bin:${env.PATH}"
        JAVA_HOME = "/usr/local/opt/openjdk@17/libexec/openjdk.jdk/Contents/Home"
        HOME = "/Users/moughitehanafi"  // Utilisateur non root
    }

    stages {
        stage('Check Homebrew') {
            steps {
                script {
                    // Vérification de l'installation de Homebrew
                    sh '''
                        if ! command -v brew &> /dev/null; then
                            echo "Homebrew could not be found, installing..."
                            /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
                        else
                            echo "Homebrew is already installed."
                        fi
                    '''
                }
            }
        }
        stage('Install ngrok') {
            steps {
                script {
                    // Téléchargement et installation de ngrok sur macOS en tant qu'utilisateur non root
                    sh '''
                        cd $HOME
                        sudo -u moughitehanafi /bin/bash -c "brew install --cask ngrok"
                    '''
                }
            }
        }
        stage('Clone Repository') {
            steps {
                script {
                    // Cloner le projet depuis GitHub
                    sh '''
                        cd $HOME
                        if [ -d "jenkins-test" ]; then
                            rm -rf jenkins-test
                        fi
                        git clone https://github.com/moughite/jenkins-test.git
                    '''
                }
            }
        }
        stage('Configure ngrok') {
            steps {
                script {
                    // Authentification avec le jeton ngrok
                    sh "ngrok authtoken ${env.NGROK_TOKEN}"
                }
            }
        }
        stage('Start ngrok Tunnel') {
            steps {
                script {
                    // Démarrage du tunnel ngrok (par exemple pour le port 8080)
                    sh 'ngrok http 8080 > /dev/null &'
                }
            }
        }
        stage('Check Java Version') {
            steps {
                script {
                    // Vérification de la version de Java
                    sh 'java -version'
                }
            }
        }
        stage('Clean Install') {
            steps {
                script {
                    // Exécution de la commande Maven clean install dans le répertoire du projet
                    sh '''
                        cd $HOME/jenkins-test
                        mvn clean install
                    '''
                }
            }
        }
        stage('Test Tunnel') {
            steps {
                script {
                    // Vérification que le tunnel est actif
                    sh 'curl -s http://localhost:4040/api/tunnels'
                }
            }
        }
    }
}

 */
