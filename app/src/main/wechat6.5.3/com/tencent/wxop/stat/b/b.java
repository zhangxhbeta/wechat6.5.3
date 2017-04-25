package com.tencent.wxop.stat.b;

public final class b {
    private String a = "default";
    boolean b = true;
    private int c = 2;

    public b(String str) {
        this.a = str;
    }

    private String a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    public final void bQy() {
        if (this.c <= 6) {
            com.tencent.wxop.stat.b.bQm();
        }
    }

    public final void bw(Object obj) {
        if (this.b && this.c <= 4) {
            String a = a();
            if (a == null) {
                obj.toString();
            } else {
                new StringBuilder().append(a).append(" - ").append(obj);
            }
            com.tencent.wxop.stat.b.bQm();
        }
    }

    public final void bx(Object obj) {
        if (this.b) {
            warn(obj);
        }
    }

    public final void by(Object obj) {
        if (this.b) {
            error(obj);
        }
    }

    public final void bz(Object obj) {
        if (this.b) {
            debug(obj);
        }
    }

    public final void debug(Object obj) {
        if (this.c <= 3) {
            String a = a();
            if (a == null) {
                obj.toString();
            } else {
                new StringBuilder().append(a).append(" - ").append(obj);
            }
            com.tencent.wxop.stat.b.bQm();
        }
    }

    public final void error(Object obj) {
        if (this.c <= 6) {
            String a = a();
            if (a == null) {
                obj.toString();
            } else {
                new StringBuilder().append(a).append(" - ").append(obj);
            }
            com.tencent.wxop.stat.b.bQm();
        }
    }

    public final void i(Throwable th) {
        if (this.b) {
            bQy();
        }
    }

    public final void warn(Object obj) {
        if (this.c <= 5) {
            String a = a();
            if (a == null) {
                obj.toString();
            } else {
                new StringBuilder().append(a).append(" - ").append(obj);
            }
            com.tencent.wxop.stat.b.bQm();
        }
    }
}
