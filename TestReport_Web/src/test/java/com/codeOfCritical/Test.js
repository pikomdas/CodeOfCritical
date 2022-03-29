let msg = 'Hello World';
let user;
console.log(msg);

const fs = require("fs");

// Read users.json file
fs.readFile("./src/test/java/com/codeOfCritical/backup_deviations.json", function (err, data) {

    // Check for errors
    if (err) throw err;

    // Converting to JSON
    users = JSON.parse(data);

    console.log(users); // Print users
});

/*var http = require('http')

http.createServer(onRequest).listen(8881);
console.log('Server has started');

function onRequest(request, response){
  response.writeHead(200);
  response.write('Hello Noders');
  response.write('Hello Noders');
  response.end();
  
}*/




