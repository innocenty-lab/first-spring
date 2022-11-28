package com.pbrspringc.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Qualifier("int")
public class RandomInt implements IRandomStringGenerator {
    @Override
    public String random() {
        Random random = new Random();
        int upperBound = 1000000;
        int int_random = random.nextInt(upperBound);
        return String.valueOf(int_random);
    }
}
