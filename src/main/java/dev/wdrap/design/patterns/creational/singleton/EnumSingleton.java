package dev.wdrap.design.patterns.creational.singleton;

public enum EnumSingleton {
    INSTANCE;

    public String echo() {
        return "Hello you";
    }
}
