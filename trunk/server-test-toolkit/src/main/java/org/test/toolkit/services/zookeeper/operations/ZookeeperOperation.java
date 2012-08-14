package org.test.toolkit.services.zookeeper.operations;

import org.apache.zookeeper.KeeperException;

public interface ZookeeperOperation<T> {

	T execute() throws KeeperException, InterruptedException;

	String operationName();

}