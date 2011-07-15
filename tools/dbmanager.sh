#!/bin/sh
cd `dirname $0`
java -cp ../lib/main/hsqldb.jar org.hsqldb.util.DatabaseManagerSwing $@
