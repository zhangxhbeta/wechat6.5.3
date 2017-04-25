package com.google.android.gms.c;

import android.os.Binder;

public abstract class j<T> {
    private static final Object afg = new Object();
    static a aye = null;
    private static int ayf = 0;
    private static String ayg = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private T aiV = null;
    protected final String ayh;
    protected final T ayi;

    private interface a {
        Boolean kJ();

        Long kK();

        Integer kL();

        Float kM();

        String kN();
    }

    protected j(String str, T t) {
        this.ayh = str;
        this.ayi = t;
    }

    public static j<Float> a(String str, Float f) {
        return new j<Float>(str, f) {
            protected final /* synthetic */ Object kH() {
                return j.aye.kM();
            }
        };
    }

    public static j<Integer> a(String str, Integer num) {
        return new j<Integer>(str, num) {
            protected final /* synthetic */ Object kH() {
                return j.aye.kL();
            }
        };
    }

    public static j<Long> a(String str, Long l) {
        return new j<Long>(str, l) {
            protected final /* synthetic */ Object kH() {
                return j.aye.kK();
            }
        };
    }

    public static j<Boolean> f(String str, boolean z) {
        return new j<Boolean>(str, Boolean.valueOf(z)) {
            protected final /* synthetic */ Object kH() {
                return j.aye.kJ();
            }
        };
    }

    public static boolean isInitialized() {
        return aye != null;
    }

    public static j<String> j(String str, String str2) {
        return new j<String>(str, str2) {
            protected final /* synthetic */ Object kH() {
                return j.aye.kN();
            }
        };
    }

    public static int kG() {
        return ayf;
    }

    public final T get() {
        return this.aiV != null ? this.aiV : kH();
    }

    protected abstract T kH();

    public final T kI() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            T t = get();
            return t;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
