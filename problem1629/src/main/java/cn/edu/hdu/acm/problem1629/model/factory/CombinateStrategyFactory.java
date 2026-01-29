package cn.edu.hdu.acm.problem1629.model.factory;

import cn.edu.hdu.acm.problem1629.model.annotation.CombinationType;
import cn.edu.hdu.acm.problem1629.model.strategy.CombinationStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CombinateStrategyFactory {
    private final Map<String, CombinationStrategy> strategyMap = new ConcurrentHashMap<>();

    public CombinateStrategyFactory(Map<String, CombinationStrategy> strategyBeans) {
        for (CombinationStrategy strategy : strategyBeans.values()) {
            CombinationType combinationType = strategy.getClass().getAnnotation(CombinationType.class);
            if (combinationType != null) {
                strategyMap.put(combinationType.value(), strategy);
            }
        }
    }

    public CombinationStrategy getStrategy(String type) {
        CombinationStrategy strategy = strategyMap.get("type");
        if (strategy == null) {
            throw new IllegalArgumentException("Not support strategy: " + type);
        }
        return strategy;

    }

}
