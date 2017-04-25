package com.tencent.mm.ui.f.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class a {
    public String bkC;
    public final int eKg;
    public int iHC;
    public int iHJ;
    public boolean imS = true;
    public String info;
    public int oJe;
    public int oJf;
    public int oJg;
    public boolean oPs;
    public boolean oPt;
    public int oPu;
    public String oPv;
    public long oPw;
    public boolean oPx;
    public final int position;

    public abstract class a {
        final /* synthetic */ a oPy;

        public a(a aVar) {
            this.oPy = aVar;
        }
    }

    public abstract class b {
        final /* synthetic */ a oPy;

        public abstract View a(Context context, ViewGroup viewGroup);

        public abstract void a(Context context, a aVar, a aVar2);

        public abstract boolean a(Context context, a aVar);

        public b(a aVar) {
            this.oPy = aVar;
        }

        public final void cY(View view) {
            if (this.oPy.oPt) {
                view.setBackgroundResource(2130838048);
            } else {
                view.setBackgroundResource(2130838046);
            }
        }
    }

    public abstract b YL();

    public abstract void a(Context context, a aVar);

    public a(int i, int i2) {
        this.eKg = i;
        this.position = i2;
        v.d("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void dp(int i, int i2) {
        this.oJf = i;
        this.oJe = i2;
    }

    public int YM() {
        return 0;
    }

    public String asE() {
        return SQLiteDatabase.KeyEmpty;
    }

    public int aML() {
        return 0;
    }

    public boolean aMM() {
        return false;
    }
}
