#!/bin/sh

mvn -Psnapshot clean package javadoc:jar source:jar deploy
