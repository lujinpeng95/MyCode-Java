package core.email;

public class MailDto {

    /**
     * 接收方，逗号分隔
     */
    private String to;

    /**
     * 抄送方，逗号分隔
     */
    private String cc;

    /**
     * 主题
     */
    private String subject;

    /**
     * 内容
     */
    private String message;

    public MailDto() {
    }

    private MailDto(Builder builder) {
        to = builder.to;
        cc = builder.cc;
        subject = builder.subject;
        message = builder.message;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return new StringBuilder().append("MailDto{")
                .append("to='").append(to).append('\'')
                .append(", cc='").append(cc).append('\'')
                .append(", subject='").append(subject).append('\'')
                .append(", message='").append(message).append('\'')
                .append('}').toString();
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public static final class Builder {
        private String to;
        private String subject;
        private String message;
        private String cc;

        private Builder() {
        }

        public Builder to(String to) {
            this.to = to;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder cc(String cc) {
            this.cc = cc;
            return this;
        }

        public MailDto build() {
            return new MailDto(this);
        }
    }
}
