REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=jobs4u.app.server/target/jobs4u.app.server-0.1.0.jar;jobs4u.app.server/target/dependency\*;

REM call the java VM, e.g,
java -cp %BASE_CP% lapr4.jobs4u.server.TcpSrv
