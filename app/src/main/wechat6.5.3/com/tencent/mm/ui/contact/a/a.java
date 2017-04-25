package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;

public abstract class a implements com.tencent.mm.ui.contact.t.a {
    public static final int cVN = com.tencent.mm.bd.a.N(aa.getContext(), 2131493169);
    public static final TextPaint cVO = new TextPaint();
    public static final int cVP = com.tencent.mm.bd.a.N(aa.getContext(), 2131493128);
    public static final TextPaint cVQ = new TextPaint();
    public String aYF;
    public String bkC;
    public final int eKg;
    public u euW;
    public boolean eyw;
    public boolean oHa;
    public boolean oJd;
    private int oJe;
    private int oJf;
    public int oJg;
    public boolean oJh;
    public boolean oJi = false;
    public final int position;
    public int scene;

    public class a {
        final /* synthetic */ a oJj;

        public a(a aVar) {
            this.oJj = aVar;
        }
    }

    public abstract class b {
        final /* synthetic */ a oJj;

        public abstract boolean NG();

        public abstract View a(Context context, ViewGroup viewGroup);

        public abstract void a(Context context, a aVar, a aVar2, boolean z, boolean z2);

        public b(a aVar) {
            this.oJj = aVar;
        }
    }

    public abstract b NE();

    public abstract a NF();

    public abstract void bo(Context context);

    static {
        cVO.setTextSize((float) cVN);
        cVQ.setTextSize((float) cVP);
    }

    public a(int i, int i2) {
        this.eKg = i;
        this.position = i2;
        v.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final String getQuery() {
        return this.bkC;
    }

    public final int bwF() {
        return this.scene;
    }

    public final void dp(int i, int i2) {
        this.oJf = i;
        this.oJe = i2;
    }

    public final int bHT() {
        return this.oJe;
    }

    public final int bHS() {
        return this.oJf;
    }

    public final int bHR() {
        return this.oJg;
    }

    public final boolean bHU() {
        return this.oJh;
    }

    public final boolean bHV() {
        return this.oJi;
    }

    public boolean aMM() {
        return false;
    }
}
