# personAPI

Welcome to the documentation for Person API Resource.

## Getting Started
Base URL: `https://zuri-task-production.up.railway.app/`

If you are using a local server, the base url will be `http://localhost:8080` (by default).  
Be sure to check the [README](readme.MD) on how to start the project.

## API Endpoints
| Endpoint     | Functionality | Description | HTTP method |
|--------------| --- | --- | --- |
| `/api`       | Create | Create a new person | `POST` |
| `/api/:name` | Read | Get a single person | `GET` |
| `/api/:id`   | Update | Update a single person | `PUT` |
| `/api/:id`   | Delete | Delete a single person | `DELETE` |

## Api Endpoints
In this section, you'll find examples of how to interact with the API endpoints to perform various CRUD operations on person entities.
* ### Create a new Person
  To create a new person entity, send a `POST` request to the `/api` endpoint with the following JSON request body:
```json
{
  "name": "John Doe"
}
```
Example Response:
```json
{
    "id": 1,
    "name": "John Doe"
}
```

* ### Retrieve a peron by name
  To retrieve a person by name, send a `GET` request to the `/api` endpoint with the `name` in the url.
  Example Response:
```json
{
    "id": 1,
    "name": "John Doe"
}
```

* ### Retrieve all persons
  To retrieve all persons, send a `GET` request to the `/api/all` endpoint.

Example Response:
```json
[
  {
    "id": 1,
    "name": "John Doe"
  },
  {
    "id": 2,
    "name": "Jane Smith"
  }
]
```

* ### Update an existing Person
  To update a person's details by name, send a `PUT` request to the `/api/:id` endpoint with the id in the url a JSON request body containing the updated name.

Example Response:
```json
{
  "id": 1,
  "name": "John Doe Jr."
}
```

* ### Delete a Person
  To delete a person by name, send a `DELETE` request to the `/api/{id}` endpoint with the id as a path variable.

Example Response:
```text
SUCCESSFUL
```