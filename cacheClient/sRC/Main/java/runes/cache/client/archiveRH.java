
package net.runelite.cache.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.runelite.protocol.api.update.ArchiveResponsePacket;

public class ArchiveResponseHandler extends SimpleChannelInboundHandler<ArchiveResponsePacket>
{
	private final CacheClient client;

	public ArchiveResponseHandler(CacheClient client)
	{
		this.client = client;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ArchiveResponsePacket archiveResponse) throws Exception
	{
		client.onFileFinish(archiveResponse.getIndex(),
			archiveResponse.getArchive(),
			archiveResponse.getData());
	}

}
