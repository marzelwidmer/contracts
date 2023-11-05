```bash 
java -Dlogging.level.org.springframework=info\
-jar ${PWD}/etc/stub-runner.jar \
--server.port=8087 \
--stubrunner.ids="ch.keepcalm:application-module:+:stubs:8081" \
--stubrunner.stubs-mode=LOCAL \
--stubrunner.snapshot-check-skip=true \
--stubrunner.generate-stubs=true \
--stubrunner.repository-root=stubs://file:${PWD}"/META-INF/application-module"
``` 

```bash
http :8081/__admin/mappings
```

# Start
```bash 
docker run --rm \
-e "STUBRUNNER_IDS=ch.keepcalm.demo:kboot-puername:+:stubs:8081,ch.keepcalm.demo:kboot-puername:+:stubs,ch.keepcalm.demo:xml:+:stubs" \
-e "STUBRUNNER_STUBS_MODE=REMOTE" \
-e "STUBRUNNER_GENERATE_STUBS=TRUE" \
-e "STUBRUNNER_REPOSITORY_ROOT=git://https://github.com/marzelwidmer/contracts.git" \
-e "LANG=C.UTF-8" \
-p "8083:8083" \
-p "8081:8081" \
springcloud/spring-cloud-contract-stub-runner:4.0.4
```

# Call API
```bash 
http :8081/api/persons  "Content-Type: application/json"
```

# Deploy Contracts to Minikube as Servcie
```bash
skaffold run
```

# Test Contracts inside K8s
```bash
kubectl run -i --rm --restart=Never curl-client --image=tutum/curl:alpine --command -- curl -s 'http://contracts/api/persons' -H 'Content-Type: application/json' -w "\n"

[{"firstName":"John"}]
pod "curl-client" deleted
```



## Start from local path
```bash
./etc/run-stubs-from-local.sh
```

## Run with local DIR in docker 
--> don`t work

```bash
docker run --rm \
-e "STUBRUNNER_IDS=ch.keepcalm.demo:kboot-puername:+:stubs:8081,ch.keepcalm.demo:xml:+:stubs" \
-e "STUBRUNNER_STUBS_MODE=LOCAL" \
-e "STUBRUNNER_SNAPSHOT_CHECK_SKIP=true" \
-e "STUBRUNNER_GENERATE_STUBS=true" \
-e "STUBRUNNER_REPOSITORY_ROOT=stubs://file://$PWD/META-INF" \
-e "logging.level.org.springframework=DEBUG" \
-p 8081:8081 \
springcloud/spring-cloud-contract-stub-runner:4.0.4

``` 
