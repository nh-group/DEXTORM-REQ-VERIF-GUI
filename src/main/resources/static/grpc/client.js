const {Requirement, Empty} = require('./requirements_pb.js');
const {ReqCollectorClient} = require('./requirements_grpc_web_pb.js');

var client = new ReqCollectorClient('http://localhost:8082');

var empty = new Empty();

console.log("coucou");

var serverStream = client.pullRequirement(empty, {});



