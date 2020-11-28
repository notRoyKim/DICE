#!/bin/bash

#git pull
git pull

#gradle build
./gradlew build --no-daemon

#jar start
java -jar build/libs/DICE-0.0.1-SNAPSHOT.jar