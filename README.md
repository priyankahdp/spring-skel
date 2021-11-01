# Item Repository Spring Boot Application #

### Project Overview ###

This project contains an unfinished implementation of a simple repository for Items.



### Sample Curl commands ###

POST Sample ====================

curl -X POST \
  http://localhost:9443/app/api/1.0/items/ \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 44d6b3b0-b371-16e0-6854-330ee39bc953' \
  -d '{
	"state": "valid",
	"barcode": "12345",
	"name": "SuperMan",
	"descriptions": [{
		"description": "Series-3"
	}]
}'

PUT Sample ====================

curl -X PUT \
  http://localhost:9443/app/api/1.0/items \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 54f9c489-f9d3-ecbd-f8be-80c56b27d68d' \
  -d '    {
        "state": "undefined",
        "descriptions": [
            {
                "id": 1,
                "description": "series-1"
            }
        ],
        "barcode": 213199,
        "name": "Hobbit",
        "id": 1
    }'


GET Sample ====================

curl -X GET \
  http://localhost:9443/app/api/1.0/items

DELETE Sample ====================

curl -X DELETE \
  http://localhost:9443/app/api/1.0/items/4 
