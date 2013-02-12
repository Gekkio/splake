#!/bin/sh

mvn -Prelease clean package javadoc:jar source:jar deploy
