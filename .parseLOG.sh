#!/bin/bash

inputfile="/home/debian/.log.log"
cat $inputfile | while read line; do
    echo "INSERT INTO LOG VALUES ('','$line');"
done | mysql -u -p sambaLOG;
> .log.log
