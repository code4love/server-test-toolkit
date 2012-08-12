package org.test.toolkit.server.ftp.command.sftp;

import org.test.toolkit.util.ValidationUtil;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SftpGetCommand extends SftpCommandWithResult {

	private String storagePath;

	public SftpGetCommand(Session session, String storagePath) {
		super(session);
		ValidationUtil.checkNull(storagePath);

		this.storagePath = storagePath;
	}

	@Override
	public Object runCommandByChannelWithResult(ChannelSftp channelSftp) throws SftpException {
		return channelSftp.get(storagePath);
	}

}