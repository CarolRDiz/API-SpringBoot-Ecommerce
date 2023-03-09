//var db = connect("mongodb://root:pestillo@localhost:27017/admin");
var db = connect(spring.data.mongodb.uri);spring.data.mongodb.uri
db = db.getSiblingDB('images'); // we can not use "use" statement here to switch db

db.createUser(
    {
        user: "croddiz151",
        pwd: "croddiz151",
        roles: [ { role: "readWrite", db: "springbootapi"} ],
    }
)