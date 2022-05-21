package com.shou.loadbalance;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLoadBalance implements LoadBalance {

    private final AtomicInteger visitCount = new AtomicInteger();

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int count;
        for (; ; ) {
            count = visitCount.get();
            int next = count >= Integer.MAX_VALUE ? 0 : count + 1;
            if (visitCount.compareAndSet(count, next)) {
                break;
            }
        }
        int index = count % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
