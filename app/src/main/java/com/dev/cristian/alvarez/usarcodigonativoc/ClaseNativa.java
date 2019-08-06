package com.dev.cristian.alvarez.usarcodigonativoc;

public class ClaseNativa {

    static {
        System.loadLibrary("sumar");
    }

    public static native int sumar(int numero1, int numero2);
}
