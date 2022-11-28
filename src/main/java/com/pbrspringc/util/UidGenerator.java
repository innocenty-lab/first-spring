package com.pbrspringc.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Qualifier("uid")
public class UidGenerator implements IRandomStringGenerator{
    @Override
    public String random() {
        return UUID.randomUUID().toString();
    }
}
