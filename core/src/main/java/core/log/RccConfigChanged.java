package core.log;

import com.google.common.collect.Maps;
import core.log.aspect.DependLogAspect;
import core.model.ChangedConfigItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Component
public class RccConfigChanged implements ConfigItemChangedCallable {
    private static final Logger LOGGER = LoggerFactory.getLogger(RccConfigChanged.class);

    /**
     * rcc 配置变更时支持热更新的配置项
     */
    private static final String ENABLE_RSP = "log.dependLog.enableRsp";

    @Autowired
    private DependLogAspect dependLogAspect;

    @Override
    public void changed(List<ChangedConfigItem> list) {
        Map<String, String> changedParamMap = Maps.newHashMap();
        for (ChangedConfigItem item : list) {
            LOGGER.info("rcc config {} changed from {} to {}", item.getKey(), item.getOldValue(), item.getNewValue());
            changedParamMap.put(item.getKey(), item.getNewValue());
        }
        update(changedParamMap);
    }

    private void update(Map<String, String> changedParamMap) {
        for (String key : changedParamMap.keySet()) {
            try {
                if (ENABLE_RSP.equals(key)) {
                    Field field = dependLogAspect.getClass().getDeclaredField("enableRsp");
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, dependLogAspect, new Boolean(changedParamMap.get(key)));
                    LOGGER.info("dependLogAspect.enableRsp 值变更为:{}", changedParamMap.get(key));
                }
            } catch (NoSuchFieldException e) {
                LOGGER.error("配置项:{} 变更异常", key, e);
            }
        }
    }
}
