package core.email;

public interface MailSender {

    /**
     * 发送邮件
     *
     * @param body
     * @return
     */
    String send(MailDto body);

}
