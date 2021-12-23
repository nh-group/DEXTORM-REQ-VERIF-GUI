/**
 * @fileoverview gRPC-Web generated client stub for requirements
 * @enhanceable
 * @public
 */

// GENERATED CODE -- DO NOT EDIT!



const grpc = {};
grpc.web = require('grpc-web');

const proto = {};
proto.requirements = require('./requirements_pb.js');

/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?Object} options
 * @constructor
 * @struct
 * @final
 */
proto.requirements.ReqCollectorClient =
    function(hostname, credentials, options) {
  if (!options) options = {};
  options['format'] = 'text';

  /**
   * @private @const {!grpc.web.GrpcWebClientBase} The client
   */
  this.client_ = new grpc.web.GrpcWebClientBase(options);

  /**
   * @private @const {string} The hostname
   */
  this.hostname_ = hostname;

  /**
   * @private @const {?Object} The credentials to be used to connect
   *    to the server
   */
  this.credentials_ = credentials;

  /**
   * @private @const {?Object} Options for the client
   */
  this.options_ = options;
};


/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?Object} options
 * @constructor
 * @struct
 * @final
 */
proto.requirements.ReqCollectorPromiseClient =
    function(hostname, credentials, options) {
  if (!options) options = {};
  options['format'] = 'text';

  /**
   * @private @const {!proto.requirements.ReqCollectorClient} The delegate callback based client
   */
  this.delegateClient_ = new proto.requirements.ReqCollectorClient(
      hostname, credentials, options);

};


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.requirements.Empty,
 *   !proto.requirements.Requirement>}
 */
const methodInfo_ReqCollector_pullRequirement = new grpc.web.AbstractClientBase.MethodInfo(
  proto.requirements.Requirement,
  /** @param {!proto.requirements.Empty} request */
  function(request) {
    return request.serializeBinary();
  },
  proto.requirements.Requirement.deserializeBinary
);


/**
 * @param {!proto.requirements.Empty} request The request proto
 * @param {!Object<string, string>} metadata User defined
 *     call metadata
 * @return {!grpc.web.ClientReadableStream<!proto.requirements.Requirement>}
 *     The XHR Node Readable Stream
 */
proto.requirements.ReqCollectorClient.prototype.pullRequirement =
    function(request, metadata) {
  return this.client_.serverStreaming(this.hostname_ +
      '/requirements.ReqCollector/pullRequirement',
      request,
      metadata,
      methodInfo_ReqCollector_pullRequirement);
};


/**
 * @param {!proto.requirements.Empty} request The request proto
 * @param {!Object<string, string>} metadata User defined
 *     call metadata
 * @return {!grpc.web.ClientReadableStream<!proto.requirements.Requirement>}
 *     The XHR Node Readable Stream
 */
proto.requirements.ReqCollectorPromiseClient.prototype.pullRequirement =
    function(request, metadata) {
  return this.delegateClient_.client_.serverStreaming(this.delegateClient_.hostname_ +
      '/requirements.ReqCollector/pullRequirement',
      request,
      metadata,
      methodInfo_ReqCollector_pullRequirement);
};


/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?Object} options
 * @constructor
 * @struct
 * @final
 */
proto.requirements.AgentConfigurationClient =
    function(hostname, credentials, options) {
  if (!options) options = {};
  options['format'] = 'text';

  /**
   * @private @const {!grpc.web.GrpcWebClientBase} The client
   */
  this.client_ = new grpc.web.GrpcWebClientBase(options);

  /**
   * @private @const {string} The hostname
   */
  this.hostname_ = hostname;

  /**
   * @private @const {?Object} The credentials to be used to connect
   *    to the server
   */
  this.credentials_ = credentials;

  /**
   * @private @const {?Object} Options for the client
   */
  this.options_ = options;
};


/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?Object} options
 * @constructor
 * @struct
 * @final
 */
proto.requirements.AgentConfigurationPromiseClient =
    function(hostname, credentials, options) {
  if (!options) options = {};
  options['format'] = 'text';

  /**
   * @private @const {!proto.requirements.AgentConfigurationClient} The delegate callback based client
   */
  this.delegateClient_ = new proto.requirements.AgentConfigurationClient(
      hostname, credentials, options);

};


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.requirements.AgentConfig,
 *   !proto.requirements.Empty>}
 */
const methodInfo_AgentConfiguration_pushAgentConfiguration = new grpc.web.AbstractClientBase.MethodInfo(
  proto.requirements.Empty,
  /** @param {!proto.requirements.AgentConfig} request */
  function(request) {
    return request.serializeBinary();
  },
  proto.requirements.Empty.deserializeBinary
);


/**
 * @param {!proto.requirements.AgentConfig} request The
 *     request proto
 * @param {!Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.requirements.Empty)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.requirements.Empty>|undefined}
 *     The XHR Node Readable Stream
 */
proto.requirements.AgentConfigurationClient.prototype.pushAgentConfiguration =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/requirements.AgentConfiguration/pushAgentConfiguration',
      request,
      metadata,
      methodInfo_AgentConfiguration_pushAgentConfiguration,
      callback);
};


/**
 * @param {!proto.requirements.AgentConfig} request The
 *     request proto
 * @param {!Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.requirements.Empty>}
 *     The XHR Node Readable Stream
 */
proto.requirements.AgentConfigurationPromiseClient.prototype.pushAgentConfiguration =
    function(request, metadata) {
  return new Promise((resolve, reject) => {
    this.delegateClient_.pushAgentConfiguration(
      request, metadata, (error, response) => {
        error ? reject(error) : resolve(response);
      });
  });
};


module.exports = proto.requirements;

