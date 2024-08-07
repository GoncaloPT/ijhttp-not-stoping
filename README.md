# REPRODUCER

This reproducer wants to showcase that the ijhttp plugin doesn't fail gracefully when a failure occurs.

It consists of a simple test that tries to do a GET request to a non-existing URL.
This can be seen on src/test/http/this-will-fail.http.

ijhttp is configured to run such test.

The test uses testcontainers: http mockserver and redpanda ( kafka ) to simulate a real environment.

## Expected behavior

Although the test is expected to fail, the plugin should fail gracefully.
The post-integration-phase should be executed, result in spring boot stop command to be executed.
This would allow docker containers to stop, and ports to be released properly.

## Observed behavior

On test failure, post-integration-phase is not executed.
This results in docker containers not being stopped, and ports not being released.

## Steps to reproduce

1. Run the following command:

```bash
mvn clean integration-test
```

To confirm the faulty behaviour, check if at least one of the commands has output, if so then there
are "leftovers" caused by spring not being properly stopped.

```bash
lsof -t -i tcp:9001
```

```bash
docker ps
```

# Useful commands

Kill a process running on a specific port ( example 9001 ):

```bash
lsof -t -i tcp:9001 | xargs kill -9
```

