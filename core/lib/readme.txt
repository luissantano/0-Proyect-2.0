#Execute this script to install the jar file into maven from lib folder

mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.2.0.1 -Dpackaging=jar -Dfile=ojdbc6-11.2.0.3.jar -DgeneratePom=true