package com.pbrspringc.util;

import java.util.Random;

public class RandomInt implements IRandomStringGenerator {
    @Override
    public String random() {
        Random random = new Random();
        int upperBound = 1000000;
        int int_random = random.nextInt(upperBound);
        return String.valueOf(int_random);
    }
}
