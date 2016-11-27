#!/bin/bash

if [[ $TRAVIS_PULL_REQUEST == "false" ]]; then
    echo "Preparing to upload artifacts"

    openssl aes-256-cbc -pass pass:$ENCRYPTION_PASSWORD -in $GPG_DIR/pubring.gpg.enc -out $GPG_DIR/pubring.gpg -d
    openssl aes-256-cbc -pass pass:$ENCRYPTION_PASSWORD -in $GPG_DIR/secring.gpg.enc -out $GPG_DIR/secring.gpg -d

    mvn deploy --settings $GPG_DIR/settings.xml -DperformRelease=true -DskipTests=true
    exit $?
fi
