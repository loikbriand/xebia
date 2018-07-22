# Click Count LBR application

Ce projet contient plusieurs répertoires :

## Répertoires applicatifs

### war
Contient le code originel de l'application clickCount avec quelques modifications

### src
Contient les properties et fichiers de configuration à déployer automatiquement avec l'application

### packaging
Répertoire permettant de faire l'assembly et de packager tout l'applicatif en un seul artefact déployable

## Répertoire automatisation

### jobs

Contient le code groovy DSL de création des jobs permettant de builder et deployer automatiquement

### ansible

Contient le code et la configuration ansible pour déployer l'applicatif automatiquement
