package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;

public final class l {
    public Resources BE;
    public a gWe;
    public h gWf = null;
    public Context mContext;

    class AnonymousClass8 implements OnClickListener {
        final /* synthetic */ int dBa;
        final /* synthetic */ l gWg;

        public AnonymousClass8(l lVar, int i) {
            this.gWg = lVar;
            this.dBa = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (this.gWg.gWe != null) {
                this.gWg.gWe.mt(this.dBa);
            }
        }
    }

    public interface a {
        void awW();

        void awX();

        void awY();

        void dX(boolean z);

        void mt(int i);
    }

    public l(Context context, a aVar) {
        this.mContext = context;
        this.gWe = aVar;
        this.BE = this.mContext.getResources();
    }

    public final void awV() {
        if (!mr(67590)) {
            g.a(this.mContext, this.BE.getString(2131233544), "", false, new OnClickListener(this) {
                final /* synthetic */ l gWg;

                {
                    this.gWg = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.gWg.gWe != null) {
                        this.gWg.gWe.awW();
                    }
                }
            }, new OnClickListener(this) {
                final /* synthetic */ l gWg;

                {
                    this.gWg = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            ms(67590);
        } else if (this.gWe != null) {
            this.gWe.awW();
        }
    }

    public static boolean mr(int i) {
        ak.yW();
        Object obj = c.vf().get(i, null);
        if (obj == null) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public static void ms(int i) {
        ak.yW();
        c.vf().set(i, Boolean.valueOf(true));
    }
}
