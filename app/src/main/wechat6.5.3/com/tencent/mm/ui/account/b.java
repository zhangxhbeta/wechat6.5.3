package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class b extends com.tencent.mm.ui.applet.SecurityImage.b {
    SecurityImage nFq = null;
    k nHH = null;

    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ Context lAe;
        final /* synthetic */ b nHI;

        AnonymousClass1(b bVar, Context context) {
            this.nHI = bVar;
            this.lAe = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            final k a = this.nHI.a(this.nHI.nHH, this.nHI.nFq.bBA());
            ak.vy().a(a, 0);
            Context context = this.lAe;
            this.lAe.getString(2131231164);
            g.a(context, this.lAe.getString(2131233565), true, new OnCancelListener(this) {
                final /* synthetic */ AnonymousClass1 nHJ;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(a);
                }
            });
        }
    }

    public abstract k a(k kVar, String str);

    public final void bAL() {
        ak.vy().a(a(this.nHH, SQLiteDatabase.KeyEmpty), 0);
    }
}
