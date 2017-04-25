package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.base.h;

public final class a {
    h iji;
    a oXM;

    static class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ a oXN;

        AnonymousClass1(a aVar) {
            this.oXN = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.oXN.oXM.bJI();
        }
    }

    static class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ a oXN;

        AnonymousClass2(a aVar) {
            this.oXN = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            a aVar = this.oXN;
            if (aVar.iji != null) {
                aVar.iji.dismiss();
                aVar.iji = null;
            }
            aVar.oXM.bJI();
        }
    }

    public interface a {
        void bJI();
    }

    a(a aVar) {
        this.oXM = aVar;
    }
}
