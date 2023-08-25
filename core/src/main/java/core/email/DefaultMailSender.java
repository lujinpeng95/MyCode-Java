package core.email;

import core.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DefaultMailSender implements MailSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMailSender.class);

    @Value("${mail.default.hostName:mail1-in.baidu.com}")
    private String hostName;

    @Value("${mail.default.from:opensa@baidu.com}")
    private String from;

    @Value("${mail.default.port:25}")
    private String port;

    @Override
    public String send(MailDto body) {
        int retryTimes = 0;
        String messageId = "";

        if (body.getCc() == null) {
            throw new BizException("Mail cc must not null");
        }
        if (StringUtils.isBlank(body.getTo())) {
            throw new BizException("Mail receiver must not empty");
        }

        Email email = setupMail();
        while (retryTimes < 3) {
            ++retryTimes;
            try {
                Set<String> ccSet = Arrays.stream(body.getCc()
                        .split(","))
                        .filter(StringUtils::isNotBlank).collect(Collectors.toSet());
                Set<String> toSet = Arrays.stream(body.getTo()
                        .split(","))
                        .filter(StringUtils::isNotBlank).collect(Collectors.toSet());

                for (String cc : ccSet) {
                    email.addCc(cc);
                }
                for (String to : toSet) {
                    email.addTo(to);
                }
                email.setFrom(from);
                email.setMsg(body.getMessage());
                email.setSubject(body.getSubject());
                messageId = email.send();
                break;
            } catch (EmailException e) {
                LOGGER.error("DefaultMailSender send fail, body:{}", body, e);
            }
        }
        return messageId;
    }

    private Email setupMail() {
        boolean ssl = false;
        Email mail = new SimpleEmail();
        mail.setHostName(hostName);
        mail.setSmtpPort(Integer.parseInt(port));
        mail.setSSLOnConnect(ssl);
        mail.setCharset(StandardCharsets.UTF_8.displayName());
        return mail;
    }

}
