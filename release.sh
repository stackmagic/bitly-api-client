#!/bin/bash

mvn -DperformRelease=true clean deploy

cd ../gh-stackmagic-maven-repo
./update-repository-index.sh

