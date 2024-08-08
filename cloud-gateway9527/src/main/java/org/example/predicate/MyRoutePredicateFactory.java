package org.example.predicate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {
    public MyRoutePredicateFactory() {
        super(Config.class);
    }

    // 断言判断规则
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                int grade = Integer.parseInt(Objects.requireNonNull(serverWebExchange.getRequest().getQueryParams().getFirst("grade")));
                return grade > config.getGrade();
            }
        };
    }

    // 支持短促方式配置
    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("grade");
    }

    // 这里定义需要配置的参数
    @Getter@Setter
    public static class Config {
        public Config() {
        }

        @NotNull
        private Integer grade;
    }
}
