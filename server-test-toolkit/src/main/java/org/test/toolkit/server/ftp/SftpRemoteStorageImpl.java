package org.test.toolkit.server.ftp;

import java.io.InputStream;

import org.test.toolkit.server.common.user.SshUser;
import org.test.toolkit.server.common.util.JSchUtil.JSchSessionUtil;
import org.test.toolkit.server.ftp.command.GetSftpCommand;
import org.test.toolkit.server.ftp.command.PutSftpCommand;

import com.jcraft.jsch.Session;

public class SftpRemoteStorageImpl extends AbstractRemoteStroage {

	private Session session;

	/**
	 * @param sshUser
	 */
	public SftpRemoteStorageImpl(SshUser sshUser) {
		super(sshUser);
 	}

	@Override
	public void disconnect() {
		JSchSessionUtil.disconnect(session);
	}

	@Override
	public void connect() {
		session = JSchSessionUtil.getSession(serverUser);
	}

	@Override
	public InputStream getFile(String storagePath) {
		GetSftpCommand sftpGetCommand = new GetSftpCommand(session, storagePath);
		return (InputStream) sftpGetCommand.execute();
 	}

	@Override
	public void storeFile(InputStream srcInputStream, String dstFolder, String dstFileName) {
		PutSftpCommand sftpPutCommand = new PutSftpCommand(session, srcInputStream, dstFolder,
				dstFileName);
		sftpPutCommand.execute();
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
