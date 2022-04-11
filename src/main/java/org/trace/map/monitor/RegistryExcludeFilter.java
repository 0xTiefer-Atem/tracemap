package org.trace.map.monitor;

import org.springframework.boot.autoconfigure.AutoConfigurationImportFilter;
import org.springframework.boot.autoconfigure.AutoConfigurationMetadata;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Date 2022/3/15 下午 05:00
 * @Created by wangqian30
 * @description:
 */
public class RegistryExcludeFilter implements AutoConfigurationImportFilter {
    private static final Set<String> SHOULD_SKIP = new HashSet<>(Arrays.asList("org.springframework.cloud.client.serviceregistry.ServiceRegistryAutoConfiguration", "org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationAutoConfiguration"));

    @Override
    public boolean[] match(String[] classNames, AutoConfigurationMetadata metadata) {
        boolean[] matches = new boolean[classNames.length];
        for (int i = 0; i < classNames.length; i++) {
            matches[i] = !SHOULD_SKIP.contains(classNames[i]);
        }
        return matches;
    }
}
