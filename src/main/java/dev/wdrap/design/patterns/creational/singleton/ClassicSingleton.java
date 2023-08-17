package dev.wdrap.design.patterns.creational.singleton;

import java.util.Objects;

public class ClassicSingleton {
    private static volatile ClassicSingleton singleton;

    private ClassicSingleton () {}

    public static ClassicSingleton getInstance() {
        if (singleton == null) {
            synchronized (ClassicSingleton.class) {
                if (singleton == null) {
                    singleton = new ClassicSingleton();
                }
            }
        }
        return singleton;
    }

    public int getHash() {
        return Objects.hash(singleton);
    }
}
