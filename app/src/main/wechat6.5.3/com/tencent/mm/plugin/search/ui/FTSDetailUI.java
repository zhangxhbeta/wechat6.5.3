package com.tencent.mm.plugin.search.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.modelsearch.h.b;
import com.tencent.mm.pluginsdk.j.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.f.a.a;
import com.tencent.mm.ui.f.e;

public class FTSDetailUI extends FTSBaseUI {
    private int iHC;
    private int iHJ;
    private View iHK;
    private LinearLayout iHL;
    private b iHM = new b();
    private e iHN;
    private boolean iHO = true;
    private boolean iHP = true;
    private boolean iHQ = true;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e.bIM().aMI();
        ak.lyj.a(7, "", this.iHM);
    }

    protected final void aMr() {
        this.bkC = getIntent().getStringExtra("detail_query");
        this.iHC = getIntent().getIntExtra("detail_type", 0);
        this.iHJ = getIntent().getIntExtra("Search_Scene", 0);
        v.i("MicroMsg.FTS.FTSDetailUI", "onCreate query=%s, searchType=%d, kvScene=%d", new Object[]{r0, Integer.valueOf(this.iHC), Integer.valueOf(this.iHJ)});
    }

    protected final boolean aMn() {
        return false;
    }

    protected final b a(c cVar) {
        if (this.iHN == null) {
            this.iHN = new e(cVar, this.iHC, this.iHJ);
        }
        return this.iHN;
    }

    public final void b(a aVar) {
    }

    protected final int getLayoutId() {
        return 2130903678;
    }

    public final View abc() {
        if (this.iHK == null) {
            this.iHK = getLayoutInflater().inflate(2130903684, null);
            this.iHL = (LinearLayout) this.iHK.findViewById(2131757181);
            this.iHL.setVisibility(4);
        }
        return this.iHK;
    }

    protected final void aMy() {
        if (this.iHL != null) {
            this.iHL.setVisibility(0);
        }
    }

    protected final void aMz() {
        if (this.iHL != null) {
            this.iHL.setVisibility(4);
        }
    }

    protected void onDestroy() {
        this.iHN.finish();
        e.bIM().aMF();
        ak.lyj.a(this.iHM, 7);
        super.onDestroy();
    }

    public final void ml(String str) {
        if (this.iHQ && be.kS(str)) {
            CharSequence charSequence;
            this.iHQ = false;
            this.eyI.Pw(this.bkC);
            ActionBarActivity actionBarActivity = this.nDR.nEl;
            if (h.fV(this.iHC) < 0) {
                charSequence = "";
            } else {
                charSequence = actionBarActivity.getResources().getString(2131234843, new Object[]{actionBarActivity.getResources().getString(r1)});
            }
            this.eyI.setHint(charSequence);
            this.eyI.clearFocus();
        } else if (this.iHP) {
            this.iHP = false;
            if (this.iHO) {
                super.ml(str);
            }
        } else {
            super.ml(str);
        }
    }

    protected final boolean aMA() {
        return false;
    }
}
