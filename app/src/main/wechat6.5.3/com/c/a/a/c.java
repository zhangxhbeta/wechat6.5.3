package com.c.a.a;

import android.os.Handler;

abstract class c extends d {
    private boolean aHo;

    abstract void nb();

    abstract void nc();

    c() {
    }

    synchronized void a(Handler handler, a aVar) {
        this.aHo = false;
        super.a(handler, aVar);
    }

    final synchronized void ae(boolean z) {
        if ((this.aHo ^ z) != 0) {
            this.aHo = z;
            if (this.aHo) {
                nb();
            } else {
                nc();
            }
        }
    }
}
