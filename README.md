# Spring Basic Rest API

GET by Id

-http://localhost:8080/v1/movie/id/1

Get by name

-http://localhost:8080/v1/movie/name/KRRISH

POST

-add movie
-http://localhost:8080/v1/movie/add
`{
"movieName": "READY",
"collection": "865646"
}`


PUT 
- modify movie
- http://localhost:8080/v1/movie/modify
- Body
` {
  "movieId": 9,
  "movieName": "READY",
  "collection": "865646"
  }`