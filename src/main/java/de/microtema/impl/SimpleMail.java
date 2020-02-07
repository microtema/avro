package de.microtema.impl;

import de.microtema.mail.Mail;
import de.microtema.mail.Message;
import org.apache.avro.util.Utf8;

public class SimpleMail implements Mail {

    public CharSequence send(Message message) {

        return new Utf8("Sending message to " + message.getTo() + " from " + message.getFrom() + " with body " + message.getBody());
    }
}
