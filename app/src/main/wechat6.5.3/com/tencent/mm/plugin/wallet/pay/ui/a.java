package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.mm.e.a.fx;
import com.tencent.mm.e.a.fx.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.ui.g;

public final class a {
    private Dialog dxy = null;
    a kIs = null;
    private Context mContext;

    public interface a {
        void a(boolean z, String str, String str2);
    }

    public a(Context context, a aVar) {
        this.mContext = context;
        this.kIs = aVar;
    }

    public final void release() {
        this.kIs = null;
        this.mContext = null;
    }

    public final void b(boolean z, int i, String str) {
        final fx fxVar = new fx();
        fxVar.bfo = null;
        fxVar.bfn.bfp = z;
        if (z && (this.dxy == null || !(this.dxy == null || this.dxy.isShowing()))) {
            if (this.dxy != null) {
                this.dxy.dismiss();
            }
            this.dxy = g.a(this.mContext, false, new OnCancelListener(this) {
                final /* synthetic */ a kIu;

                {
                    this.kIu = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.kIu.beT();
                }
            });
        }
        fxVar.bfn.bfq = i;
        fxVar.bfn.bfr = str;
        fxVar.bpT = new Runnable(this) {
            final /* synthetic */ a kIu;

            public final void run() {
                v.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback");
                b bVar = fxVar.bfo;
                if (bVar != null && bVar.bbq) {
                    v.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
                    this.kIu.beT();
                    if (this.kIu.kIs != null) {
                        this.kIu.kIs.a(bVar.bbq, bVar.bfs, bVar.bft);
                    }
                } else if (bVar == null || bVar.bbq) {
                    v.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result == null");
                } else {
                    this.kIu.beT();
                    if (this.kIu.kIs != null) {
                        this.kIu.kIs.a(bVar.bbq, bVar.bfs, bVar.bft);
                    }
                    v.e("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
                }
            }
        };
        com.tencent.mm.sdk.c.a.nhr.a(fxVar, Looper.getMainLooper());
    }

    public final void beT() {
        if (this.dxy != null) {
            this.dxy.dismiss();
            this.dxy = null;
        }
    }
}
