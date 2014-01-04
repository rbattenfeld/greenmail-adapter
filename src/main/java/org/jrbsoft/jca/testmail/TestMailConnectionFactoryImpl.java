/*
 * IronJacamar, a Java EE Connector Architecture implementation
 * Copyright 2013, Red Hat Inc, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jrbsoft.jca.testmail;

import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;

/**
 * GreenMailConnectionFactoryImpl
 * 
 * @version $Revision: $
 */
public class TestMailConnectionFactoryImpl implements ITestMailConnectionFactory {
	
	/** The serial version UID */
	private static final long serialVersionUID = 1L;

	/** The logger */
	private static Logger log = Logger.getLogger(TestMailConnectionFactoryImpl.class.getName());

	/** Reference */
	private Reference reference;

	/** ManagedConnectionFactory */
	private TestMailManagedConnectionFactory mcf;

	/** ConnectionManager */
	private ConnectionManager connectionManager;

	/**
	 * Default constructor
	 */
	public TestMailConnectionFactoryImpl() {
	}

	/**
	 * Default constructor
	 * 
	 * @param mcf
	 *            ManagedConnectionFactory
	 * @param cxManager
	 *            ConnectionManager
	 */
	public TestMailConnectionFactoryImpl(final TestMailManagedConnectionFactory mcf, final ConnectionManager cxManager) {
		this.mcf = mcf;
		this.connectionManager = cxManager;
	}

	/**
	 * Get connection from factory
	 * 
	 * @return GreenMailConnection instance
	 * @exception ResourceException Thrown if a connection can't be obtained
	 */
	@Override
	public ITestMailConnection getConnection() throws ResourceException {
		log.finest("getConnection()");
		return (ITestMailConnection) connectionManager.allocateConnection(mcf, null);
	}

	/**
	 * Get the Reference instance.
	 * 
	 * @return Reference instance
	 * @exception NamingException Thrown if a reference can't be obtained
	 */
	@Override
	public Reference getReference() throws NamingException {
		log.finest("getReference()");
		return reference;
	}

	/**
	 * Set the Reference instance.
	 * 
	 * @param reference A Reference instance
	 */
	@Override
	public void setReference(final Reference reference) {
		log.finest("setReference()");
		this.reference = reference;
	}

}