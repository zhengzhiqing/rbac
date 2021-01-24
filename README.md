## create 
curl localhost:8080/user/create -d 'name=apple&email=apple@home.com&age=20'

## update
curl localhost:8080/user/update -d 'id=9&name=apple123&version=0'

## delete
curl localhost:8080/user/delete -d 'id=9&version=1'

## query all
curl localhost:8080/user/all

## paging query
curl localhost:8080/user/paging