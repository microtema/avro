package de.microtema.client;

import de.microtema.server.SimpleServer;
import org.apache.avro.ipc.netty.NettyTransceiver;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleClient extends NettyTransceiver {

    public SimpleClient() throws IOException {
        super(new InetSocketAddress(SimpleServer.PORT));
    }
}
