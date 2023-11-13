# Example de makefile pour compiler le squelette de code distribué
# Vous pouvez compléter ce makefile, mais étant donnée la taille du projet, 
# il est FORTEMENT recommandé d'utiliser un IDE!

# Organisation:
#  1) Les sources (*.java) se trouvent dans le répertoire src
#     Les classes d'un package toto sont dans src/toto
#     Les classes du package par defaut sont dans src
#
#  2) Les bytecodes (*.class) sont générés dans le répertoire bin
#     La hiérarchie des sources (par package) est conservée.
#
#  3) Une librairie gui.jar est distribuée pour l'interface grapique. 
#     Elle se trouve dans le sous-répertoire lib.
#
# Compilation:
#  Options de javac:
#   -d : répertoire dans lequel sont générés les .class compilés
#   -sourcepath : répertoire dans lequel sont cherchés les .java
#   -classpath : répertoire dans lequel sont cherchées les classes compilées (.class et .jar)




all: runTestInvader 

compileTestInvader:
	javac -d bin -classpath lib/gui.jar src/Balls/TestInvader.java


runTestInvader: compileTestInvader
	java -classpath bin:lib/gui.jar TestInvader






all: runTestBallsSimulator

compileTestBallsSimulator:
	javac -d bin -classpath lib/gui.jar src/Balls/Balls.java src/Balls/BallsSimulator.java src/Balls/TestBallsSimulator.java

runTestBallsSimulator: compileTestBallsSimulator
	java -classpath bin:lib/gui.jar TestBallsSimulator





all: runTestConwaySimulator

compileTestConwaySimulator:
	javac -d bin -classpath lib/gui.jar src/AutomatesCellulaires/Cellule.java src/AutomatesCellulaires/Jeux.java src/AutomatesCellulaires/JeuxSimulator.java src/AutomatesCellulaires/Conway.java src/AutomatesCellulaires/ConwaySimulator.java src/AutomatesCellulaires/TestConwaySimulator.java

runTestConwaySimulator: compileTestConwaySimulator
	java -classpath bin:lib/gui.jar TestConwaySimulator





all: runTestImmigrationSimulator

compileTestImmigrationSimulator:
	javac -d bin -classpath lib/gui.jar src/AutomatesCellulaires/Cellule.java src/AutomatesCellulaires/Jeux.java src/AutomatesCellulaires/JeuxSimulator.java src/AutomatesCellulaires/Immigration.java src/AutomatesCellulaires/ImmigrationSimulator.java src/AutomatesCellulaires/TestImmigrationSimulator.java

runTestImmigrationSimulator: compileTestImmigrationSimulator
	java -classpath bin:lib/gui.jar TestImmigrationSimulator





all: runTestSchellingSimulator

compileTestSchellingSimulator:
	javac -d bin -classpath lib/gui.jar src/AutomatesCellulaires/Cellule.java src/AutomatesCellulaires/Jeux.java src/AutomatesCellulaires/JeuxSimulator.java src/AutomatesCellulaires/Schelling.java src/AutomatesCellulaires/SchellingSimulator.java src/AutomatesCellulaires/TestSchellingSimulator.java

runTestSchellingSimulator: compileTestSchellingSimulator
	java -classpath bin:lib/gui.jar TestSchellingSimulator


all: runTestBoidsSimulator

compileTestBoidsSimulator:
	javac -d bin -classpath lib/gui.jar src/Boids/Vector.java src/Boids/Boid.java src/Boids/Sardine.java src/Boids/Shark.java src/Boids/Boids.java src/Boids/BoidsModel.java src/Boids/BoidsSimulator.java src/Boids/TestBoids.java

runTestBoidsSimulator: compileTestBoidsSimulator
	java -classpath bin:lib/gui.jar TestBoids


clean:
	rm -rf bin/

