#!/bin/sh

if [ $# -ne 1 ]; then
	echo "Usage: `basename $0` csv-file"
	exit
fi

sed -e 's/^\(.*\)$/merkmale(\1)./' "$1" | sed -e 's/;/,/g'
