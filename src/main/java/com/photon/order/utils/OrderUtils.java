package com.photon.order.utils;

import lombok.experimental.UtilityClass;

import java.util.concurrent.atomic.AtomicLong;

@UtilityClass
public class OrderUtils {

    private static final AtomicLong sequence = new AtomicLong(System.currentTimeMillis() / 1000);

    public String generateOrderNumber() {
        return String.valueOf(sequence.incrementAndGet());
    }
}
