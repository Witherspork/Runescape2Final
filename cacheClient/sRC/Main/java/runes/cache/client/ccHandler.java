package net.runelite.cache.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheClientHandler extends ChannelInboundHandlerAdapter
{
	private static final Logger logger = LoggerFactory.getLogger(CacheClientHandler.class);

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception
	{
		logger.warn("Channel has gone inactive");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
	{
		// Close the connection when an exception is raised.
		logger.warn(null, cause);
		ctx.close();
	}
}
