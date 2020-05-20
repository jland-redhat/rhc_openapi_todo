#!/bin/bash

openapi-generator generate \
        -g spring \
        --library spring-boot \
        -i todo.yaml \
        --enable-post-process-file \
        -DdebugModels \
	-o ${PWD} \
        -p groupId=com.redhat \
        -p artifactId=todo \
        -p artifactVersion=1.0.0-SNAPSHOT \
        \
        -p basePackage=com.redhat.todo \
        -p configPackage=com.redhat.todo.config \
        -p apiPackage=com.redhat.todo.api \
        -p modelPackage=com.redhat.todo.model \
        \
        -p sourceFolder=src/main/gen \
        \
        -p dateLibrary=java8 \
        -p java8=true
