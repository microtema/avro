package de.microtema;

import de.microtema.client.SimpleClient;
import de.microtema.converter.ArgumentsToMessageConverter;
import de.microtema.mail.Mail;
import de.microtema.mail.Message;
import de.microtema.model.converter.util.ClassUtil;
import de.microtema.server.SimpleServer;
import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.netty.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Usage: <to> <from> <body>");
            System.exit(1);
        }

        System.out.printf("Start..");

        Server server = ClassUtil.createInstance(SimpleServer.class);
        NettyTransceiver client = ClassUtil.createInstance(SimpleClient.class);
        ArgumentsToMessageConverter converter = ClassUtil.createInstance(ArgumentsToMessageConverter.class);

        try {

            server.start();

            Mail proxy = SpecificRequestor.getClient(Mail.class, client);

            Message message = converter.convert(args);

            CharSequence response = proxy.send(message);

            System.out.println("Result: " + response);
        } catch (IOException e) {
            System.out.println("Unable to send message: " + e.getMessage());
        } finally {
            server.close();
            client.close();
        }
    }
}
