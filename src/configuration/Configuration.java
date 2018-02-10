package configuration;

import random.MersenneTwisterFast;

public enum Configuration {
    instance;

    public final MersenneTwisterFast randomGenerator = new MersenneTwisterFast(System.currentTimeMillis());

}
