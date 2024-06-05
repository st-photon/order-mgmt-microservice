package com.photon.core;

import org.apache.commons.lang3.StringUtils;

public enum AddressType {

    WORK, HOME, NEIGHBOUR, RELATIVE;

    public static AddressType getByName(String name) {
        if(StringUtils.isBlank(name)) {
            throw new RuntimeException("Address type should not be empty");
        }
        return switch(name.toLowerCase()) {
            case "work" -> AddressType.WORK;
            case "home"-> AddressType.HOME;
            case "neighbour" ->AddressType.NEIGHBOUR;
            default -> AddressType.RELATIVE;
        };
    }
}
