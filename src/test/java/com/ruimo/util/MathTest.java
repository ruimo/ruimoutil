package com.ruimo.util;

import junit.framework.*;
import java.math.*;

public class MathTest extends TestCase {
    public void test001() {
        assertEquals(BigInteger.valueOf(24).gcd(BigInteger.valueOf(32)).intValue(),
                     com.ruimo.util.Math.gcd(24, 32));

        assertEquals(BigInteger.valueOf(1827347).gcd(BigInteger.valueOf(281237)).intValue(),
                     com.ruimo.util.Math.gcd(1827347, 281237));

        assertEquals(BigInteger.valueOf(1).gcd(BigInteger.valueOf(281237)).intValue(),
                     com.ruimo.util.Math.gcd(1, 281237));

        assertEquals(BigInteger.valueOf(11234).gcd(BigInteger.valueOf(1)).intValue(),
                     com.ruimo.util.Math.gcd(11234, 1));
    }
}
