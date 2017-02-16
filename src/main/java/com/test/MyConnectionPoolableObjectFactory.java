package com.test;



import org.apache.commons.pool.PoolableObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyConnectionPoolableObjectFactory implements PoolableObjectFactory {

	private static Logger logger = LoggerFactory.getLogger(MyConnectionPoolableObjectFactory.class);

	private static int count = 0;

	@Override
	public Object makeObject() throws Exception {
		MyConnection myConn = new MyConnection(generateName());
		logger.info("make:" + myConn.getName());
		myConn.connect();
		return myConn;
	}

	@Override
	public void activateObject(Object obj) throws Exception {
		MyConnection myConn = (MyConnection) obj;
		logger.info("activateObject:" +myConn.getName());
	}

	@Override
	public void passivateObject(Object obj) throws Exception {
		MyConnection myConn = (MyConnection) obj;
		logger.info("passivateObject:" +myConn.getName());
	}

	@Override
	public boolean validateObject(Object obj) {
		MyConnection myConn = (MyConnection) obj;
		logger.info("validateObject" +myConn.getName());
		return myConn.isConnected();
	}

	@Override
	public void destroyObject(Object obj) throws Exception {
		MyConnection myConn = (MyConnection) obj;
		logger.info("destroyObject:" +myConn.getName());
		myConn.close();
	}

	private synchronized String generateName() {
		return "conn_" + (++count);
	}
}