package cn.edu.hdu.acm.problem1629.model.factory;

import cn.edu.hdu.acm.problem1629.model.annotation.CombinationType;
import cn.edu.hdu.acm.problem1629.model.strategy.CombinationStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CombinateStrategyFactory {
    private final Map<String, CombinationStrategy> strategyMap = new ConcurrentHashMap<>();
    private final StrategyConfig strategyConfig;

//    public CombinateStrategyFactory(Map<String, CombinationStrategy> strategyBeans, StrategyConfig strategyConfig) {
//        this.strategyConfig = strategyConfig;
//        for (CombinationStrategy strategy : strategyBeans.values()) {
//            CombinationType combinationType = strategy.getClass().getAnnotation(CombinationType.class);
//            if (combinationType != null) {
//                strategyMap.put(combinationType.value(), strategy);
//            }
//        }
//    }

    public CombinateStrategyFactory(CombinationStrategy bitmaskStrategy,
                                    CombinationStrategy backtraceStrategy, StrategyConfig strategyConfig) {
        strategyMap.put("bitmask", bitmaskStrategy);
        strategyMap.put("backtrace", backtraceStrategy);
        this.strategyConfig = strategyConfig;
    }

    public CombinationStrategy getStrategy(String type) {
        CombinationStrategy strategy = strategyMap.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("Not support strategy: " + type);
        }
        return strategy;
    }

    @Bean
    @Primary // 标记为默认注入的策略
    public CombinationStrategy getStrategy() {
        String type = strategyConfig.getType();
        if (!strategyMap.containsKey(type)) {
            throw new IllegalArgumentException("Unknown strategy: " + type);
        }
        return strategyMap.get(type);
    }
}
