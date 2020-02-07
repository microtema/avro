package de.microtema.server;

import de.microtema.impl.SimpleMail;
import de.microtema.mail.Mail;
import org.apache.avro.ipc.netty.NettyServer;
import org.apache.avro.ipc.specific.SpecificResponder;

import java.net.InetSocketAddress;

public class SimpleServer extends NettyServer {

    public static final int PORT = 65111;

    public SimpleServer(SimpleMail mail) {
        super(new SpecificResponder(Mail.class, mail), new InetSocketAddress(PORT));
    }
}
