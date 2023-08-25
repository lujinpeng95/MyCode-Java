package core.model;

import java.io.Serializable;

/**
 * @author lujinpeng
 * @date 2023-08-25 6:00 下午
 */
public class ChangedConfigItem implements Serializable {
    private static final long serialVersionUID = 8760573498030245046L;
    private String key;
    private String oldValue;
    private String newValue;

    public ChangedConfigItem() {
    }

    public String getKey() {
        return this.key;
    }

    public String getOldValue() {
        return this.oldValue;
    }

    public String getNewValue() {
        return this.newValue;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
}

