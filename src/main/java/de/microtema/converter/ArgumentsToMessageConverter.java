package de.microtema.converter;

import de.microtema.mail.Message;
import de.microtema.model.converter.Converter;
import org.apache.avro.util.Utf8;

public class ArgumentsToMessageConverter implements Converter<Message, String[]> {

    public void update(Message dest, String[] orig) {

        dest.setTo(new Utf8(orig[0]));
        dest.setFrom(new Utf8(orig[1]));
        dest.setBody(new Utf8(orig[2]));
    }
}
