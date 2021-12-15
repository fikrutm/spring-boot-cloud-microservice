curl -d '{"departmentName": "IT-47KL","departmentAddress": "ROX STREET 7RTH AV","departmentCode": "IT48577"}' -H "Content-Type: application/json" -X POST http://localhost:9191/departments/


curl -i -H "Accept: application/json" http://localhost:9191/departments/1



curl -d '{"firstName": "Ruth","lastName": "Smith","email": "ruth.smith@boot.com","departmentId":1}' -H "Content-Type: application/json" -X POST http://localhost:9191/users/

curl -i -H "Accept: application/json" http://localhost:9191/users/1


timeout 10
