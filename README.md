1. Hello to start the Application go to 'GasStationsProjectApplication' and run it.
2. When the program is running you can start executing requests from POSTMAN on --> "http://localhost:8080/":
- If you want to search gas stations by name execute following request -> "http://localhost:8080/stations/listByName/{put some gas station name}"
- If you want to find the min, max and median price for fuel type execute following request -> "http://localhost:8080/stations/median/{put some fuel type}"