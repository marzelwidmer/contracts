#!/bin/bash
BASEDIR=$(dirname "$0")

ROOTDIR=`(/usr/bin/cd -- "$BASEDIR" && pwd)`

# Spring Cloud Contract Stub Runner properties
SC_CONTRACT_DOCKER_VERSION=4.0.4
STUB_PORT=9876
STUBRUNNER_IDS=ch.keepcalm.demo:kboot-puername:+:stubs:${STUB_PORT}
STUBRUNNER_PORT=8087
STUBRUNNER_REPOSITORY_ROOT=stubs://file:${ROOTDIR}"/META-INF"
#STUBRUNNER_REPOSITORY_ROOT=git://https://github.com/marzelwidmer/contracts.git


docker run --rm \
-e "STUBRUNNER_IDS=${STUBRUNNER_IDS}" \
-e "SERVER_PORT=${STUBRUNNER_PORT}" \
-e "STUBRUNNER_REPOSITORY_ROOT=${STUBRUNNER_REPOSITORY_ROOT}" \
-e "STUBRUNNER_GENERATE_STUBS=TRUE" \
-e "STUBRUNNER_STUBS_MODE=REMOTE" \
-p "${STUBRUNNER_PORT}:${STUBRUNNER_PORT}" \
-p "${STUB_PORT}:${STUB_PORT}" \
-v "${ROOTDIR}:/root/m2" springcloud/spring-cloud-contract-stub-runner:"${SC_CONTRACT_DOCKER_VERSION}"

