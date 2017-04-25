package com.tencent.mm.compatible.util;

import android.content.Context;

public final class b {
    public b cfW = null;
    private final String cfX = "audio_lock";
    Context mContext = null;

    public interface a {
        void dV(int i);
    }

    public interface b {
        void a(a aVar);

        boolean requestFocus();

        boolean si();
    }

    public b(Context context) {
        this.mContext = context;
        com.tencent.mm.compatible.a.a.a(8, new com.tencent.mm.compatible.a.a.a(this) {
            final /* synthetic */ b cfY;

            {
                this.cfY = r1;
            }

            public final void run() {
                this.cfY.cfW = new c(this.cfY.mContext);
            }
        });
    }

    public final boolean requestFocus() {
        boolean z;
        synchronized ("audio_lock") {
            if (this.cfW == null) {
                z = false;
            } else {
                z = this.cfW.requestFocus();
            }
        }
        return z;
    }

    public final boolean si() {
        boolean z;
        synchronized ("audio_lock") {
            if (this.cfW == null) {
                z = false;
            } else {
                z = this.cfW.si();
            }
        }
        return z;
    }
}
