package com.google.android.gms.b;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.w;

public abstract class c<T> {
    private final String arf;
    private T arg;

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    public c(String str) {
        this.arf = str;
    }

    public final T B(Context context) {
        if (this.arg == null) {
            w.Z(context);
            Context y = e.y(context);
            if (y == null) {
                throw new a("Could not get remote context.");
            }
            try {
                this.arg = e((IBinder) y.getClassLoader().loadClass(this.arf).newInstance());
            } catch (Throwable e) {
                throw new a("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new a("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new a("Could not access creator.", e22);
            }
        }
        return this.arg;
    }

    public abstract T e(IBinder iBinder);
}
