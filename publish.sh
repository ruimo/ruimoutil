#!/bin/sh
export PGK_TOKEN="$1"
./gradlew publishRuimoutilPublicationToGprRepository
