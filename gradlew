#!/bin/sh
#
# Gradle start up script for UN*X
#
set -e

APP_HOME="$(cd "$(dirname "$0")" && pwd)"
JAVA_EXE="java"

exec "$JAVA_EXE" \
  -classpath "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" \
  org.gradle.wrapper.GradleWrapperMain \
  "$@"
