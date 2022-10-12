#!/usr/bin/env bash

BASEDIR=$(dirname "$0")

ROOTDIR=`(/usr/bin/cd -- "$BASEDIR" && pwd)`

# start stub-runner server with stub maven references
start_stub_runner() {
	prepare_stub_runner
    java -Dlogging.level.org.springframework=info\
        -jar ${BASEDIR}/stub-runner.jar \
        --server.port=8087 \
        --stubrunner.ids=["ch.keepcalm.demo:kboot-puername:+:stubs:9876","ch.keepcalm.demo:xml:+:stubs"] \
        --stubrunner.stubs-mode=LOCAL \
        --stubrunner.snapshot-check-skip=true \
        --stubrunner.generate-stubs=true \
        --stubrunner.repository-root=stubs://file:${ROOTDIR}"/META-INF"

}

# download stub-runner jar executable in work directory
prepare_stub_runner() {
    if [ ! -r "${BASEDIR}/stub-runner.jar" ]; then
        wget -O ${BASEDIR}/stub-runner.jar \
        'https://repo.spring.io/release/org/springframework/cloud/spring-cloud-contract-stub-runner-boot/3.1.4/spring-cloud-contract-stub-runner-boot-3.1.4.jar'
    fi
}

start_stub_runner


