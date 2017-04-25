package com.tencent.mm.pluginsdk.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ac;
import junit.framework.Assert;

public abstract class j<Params, Progress, Result> {
    private boolean bhY = false;
    ac handler = new ac(Looper.getMainLooper());

    public abstract ac aRW();

    public abstract Result aRX();

    public final boolean l(final Params... paramsArr) {
        if (this.bhY) {
            Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
        }
        this.bhY = true;
        m(paramsArr);
        ac aRW = aRW();
        if (aRW == null) {
            return false;
        }
        aRW.post(new Runnable(this) {
            final /* synthetic */ j lzA;

            public final void run() {
                final Object aRX = this.lzA.aRX();
                this.lzA.handler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 lzB;

                    public final void run() {
                        this.lzB.lzA.onPostExecute(aRX);
                    }
                });
            }
        });
        return true;
    }

    public void m(Params... paramsArr) {
    }

    public void onPostExecute(Result result) {
    }
}
