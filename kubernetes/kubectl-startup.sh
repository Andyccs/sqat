kubectl delete rc -l "role in (frontend, api-server, stylechecker-service)" usage=prod
kubectl delete service -l "role in (frontend, api-server, stylechecker-service)" usage=prod

kubectl create -f frontend-rc.yml
kubectl create -f frontend-svc.yml

kubectl create -f api-server-rf.yml
kubectl create -f api-server-svc.yml

kubectl create -f stylechecker-service-rc.yml
kubectl create -f stylechecker-service-svc.yml