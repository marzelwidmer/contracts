
# Start
``` 
docker run --rm \
-e "STUBRUNNER_IDS=ch.keepcalm.demo:kboot-puername:+:stubs:9876" \
-e "STUBRUNNER_REPOSITORY_ROOT=git://https://github.com/marzelwidmer/contracts.git" \
-e "STUBRUNNER_STUBS_MODE=REMOTE" \
-e "STUBRUNNER_GENERATE_STUBS=TRUE" \
-p "8083:8083" \
-p "9876:9876" \
  springcloud/spring-cloud-contract-stub-runner:4.0.4
```

# Call API
``` 
http :9876/api/persons  "Content-Type: application/json"
```

# Deploy Contracts to Minikube as Servcie
```
skaffold run
```

# Test Contracts inside K8s
```
kubectl run -i --rm --restart=Never curl-client --image=tutum/curl:alpine --command -- curl -s 'http://contracts/api/persons' -H 'Content-Type: application/json' -w "\n"

[{"firstName":"John"}]
pod "curl-client" deleted
```



## Start from local path
```
./etc/run-stubs-from-local.sh
```

## Run with local DIR in docker 
--> don`t work

``` 
docker run --rm \
-e "STUBRUNNER_IDS=ch.keepcalm.demo:kboot-puername:+:stubs:9876,ch.keepcalm.demo:xml:+:stubs" \
-e "STUBRUNNER_STUBS_MODE=LOCAL" \
-e "STUBRUNNER_SNAPSHOT_CHECK_SKIP=true" \
-e "STUBRUNNER_GENERATE_STUBS=true" \
-e "STUBRUNNER_REPOSITORY_ROOT=stubs://file://$PWD/META-INF" \
-e "logging.level.org.springframework=DEBUG" \
-p 8087:8087 \
springcloud/spring-cloud-contract-stub-runner:4.0.4

``` 
