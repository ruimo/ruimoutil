package com.ruimo.util;

/**
<#if locale="ja">
算術アルゴリズム。
<#else>
Arithmetic algorithm.
</#if>
 */
public final class Math {
    private Math() {}

    /**
    <#if locale="ja">

      最大公約数の算出。引数の片方が0の場合、0で無い引数がそのまま返り
      ます。引数の両方が0の場合には、0が返ります。負の数は許されません。
      @param a 値1(自然数)。
      @param b 値2(自然数)。
      @return 最大公約数。
      @throws IllegalArgumentException 引数が0以上でないとスローされま
              す。

    <#else> 

      Calculate the greatest common divisor. If one of the specified
      arguments is zero, the other non-zero argument is returned. If
      both of the arguments are zero, zero is returned. Negative value
      is not allowed for the argument.
      @param a value 1 (non-negative integer)。
      @param b value 1 (non-netative integer)。
      @return The greatest common divisor.
      @throws IllegalArgumentException Thrown if the specified value
              is negative integer.

    </#if>
     */
    public static int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a < 0) throw new IllegalArgumentException
                       ("Value a (=" + a + ") is negative integer.");
        if (b < 0) throw new IllegalArgumentException
                       ("Value b (=" + b + ") is not negative integer.");
        int remainder;
        while ((remainder = a % b) > 0) {
            a = b;
            b = remainder;
        }

        return b;
    }
}
