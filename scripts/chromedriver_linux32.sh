#!/bin/sh

wget -q -O- http://chromedriver.googlecode.com/files/chromedriver_linux32_26.0.1383.0.zip | funzip > /usr/bin/chromedriver
chmor +x /usr/bin/chromedriver
