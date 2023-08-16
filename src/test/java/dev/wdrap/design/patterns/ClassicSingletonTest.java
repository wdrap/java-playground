package dev.wdrap.design.patterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClassicSingletonTest {

    @Test
    void sameInstance() {
        var a = ClassicSingleton.getInstance();
        var b = ClassicSingleton.getInstance();

        Assertions.assertEquals(a.getHash(), b.getHash());
    }
}
