package com.mygdx.doodlesiege;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum MobType {
    GHOST;

    private static final List<MobType> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static MobType getRandomMobType()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
