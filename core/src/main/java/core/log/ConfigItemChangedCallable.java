package core.log;

import core.model.ChangedConfigItem;

import java.util.List;

/**
 * @author lujinpeng
 * @date 2023-08-25 5:59 下午
 */
public interface ConfigItemChangedCallable {
    void changed(List<ChangedConfigItem> var1);
}
