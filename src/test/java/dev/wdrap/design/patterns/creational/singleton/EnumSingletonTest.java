package dev.wdrap.design.patterns.creational.singleton;

import dev.wdrap.design.patterns.creational.singleton.EnumSingleton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnumSingletonTest {

    @Test
    void sameHash() {
        var x = EnumSingleton.INSTANCE;
        var y = EnumSingleton.INSTANCE;

        Assertions.assertEquals(x.hashCode(), y.hashCode());
    }
}
