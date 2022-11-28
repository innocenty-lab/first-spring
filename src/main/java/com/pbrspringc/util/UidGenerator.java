package com.pbrspringc.util;

import java.util.UUID;

public class UidGenerator implements IRandomStringGenerator{
    @Override
    public String random() {
        return UUID.randomUUID().toString();
    }
}
