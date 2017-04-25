package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.sdk.platformtools.ac;
import junit.framework.Assert;

public abstract class h<Params, Progress, Result> {
    private boolean bhY = false;
    ac handler = ad.aqz();

    public abstract ac aRW();

    public abstract Result aRX();

    public final boolean l(final Params... paramsArr) {
        if (this.bhY) {
            Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
        }
        this.bhY = true;
        ac aRW = aRW();
        if (aRW == null) {
            return false;
        }
        aRW.post(new Runnable(this) {
            final /* synthetic */ h jjL;

            public final void run() {
                final Object aRX = this.jjL.aRX();
                this.jjL.handler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 jjN;

                    public final void run() {
                        this.jjN.jjL.onPostExecute(aRX);
                    }
                });
            }
        });
        return true;
    }

    public void onPostExecute(Result result) {
    }
}
