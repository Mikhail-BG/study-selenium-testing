#!/usr/bin/env bash
java -Dwebdriver.gecko.driver="c:\Project\Java_Workspace\automation\study-selenium-testing\geckodriver\win\geckodriver.exe" \
-jar selenium-server-standalone-3.141.59.jar \
-role webdriver -hub http://192.168.100.7:4444/grid/register \
-port 5556 \
-nodeConfig nodeConfig.json
