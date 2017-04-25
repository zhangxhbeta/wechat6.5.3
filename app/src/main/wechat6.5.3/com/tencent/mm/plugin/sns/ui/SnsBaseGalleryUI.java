package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.ui.r.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery;

public abstract class SnsBaseGalleryUI extends MMActivity implements a {
    private boolean etZ = true;
    private LinearLayout jLV;
    q jLW;
    private LinearLayout jLX;
    r jLY;
    private boolean jLZ = true;
    private TextView jMa = null;
    protected SnsInfoFlip jMb;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ad.aSz().G(3, true);
        this.jLV = (LinearLayout) findViewById(2131759289);
        this.jLX = (LinearLayout) findViewById(2131755329);
        this.jLY = new r(this, this);
        r rVar = this.jLY;
        v.i("MicroMsg.GalleryTitleManager", "onAttach");
        ak.vy().a(218, rVar);
        com.tencent.mm.sdk.c.a.nhr.e(rVar.jFx);
        com.tencent.mm.sdk.c.a.nhr.e(rVar.jFy);
    }

    public void onResume() {
        super.onResume();
        if (this.jLW != null) {
            this.jLW.refresh();
        }
    }

    public final void addView(View view) {
        this.jLV.addView(view, new LayoutParams(-1, -1));
    }

    @SuppressLint({"ResourceAsColor"})
    public final void n(boolean z, int i) {
        this.jLW = new q(this, i, z);
        this.jLW.setBackgroundColor(2131690078);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        this.jLW.getBackground().setAlpha(50);
        this.jLX.addView(this.jLW, layoutParams);
        this.jLW.bcS = getIntent().getIntExtra("sns_source", 0);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.jLY != null) {
            r rVar = this.jLY;
            v.i("MicroMsg.GalleryTitleManager", "onDetch");
            ak.vy().b(218, rVar);
            com.tencent.mm.sdk.c.a.nhr.f(rVar.jFx);
            com.tencent.mm.sdk.c.a.nhr.f(rVar.jFy);
        }
        if (this.jMb != null) {
            SnsInfoFlip snsInfoFlip = this.jMb;
            if (snsInfoFlip.jOJ != null && (snsInfoFlip.jOJ instanceof MMGestureGallery)) {
                MMGestureGallery mMGestureGallery = (MMGestureGallery) snsInfoFlip.jOJ;
                mMGestureGallery.oTf.release();
                mMGestureGallery.oTg.release();
                mMGestureGallery.oTe.release();
            }
            this.jMb.onDestroy();
        }
    }

    protected int getLayoutId() {
        return 2130904451;
    }

    public void aZ(String str, int i) {
        if (this.jLZ && !ad.aSn()) {
            k Bq = ad.aSE().Bq(str);
            if (Bq == null || Bq.field_snsId == 0) {
                iT(false);
            } else {
                iT(true);
            }
        }
    }

    protected void onPause() {
        if (this.jMb != null) {
            this.jMb.onPause();
        }
        if (this.jLY != null) {
            r rVar = this.jLY;
            if (rVar.jFv != null) {
                com.tencent.mm.e.a.ad adVar = new com.tencent.mm.e.a.ad();
                adVar.aXF.aXH = (Activity) rVar.context;
                adVar.aXF.aXG = rVar.jFv;
                com.tencent.mm.sdk.c.a.nhr.z(adVar);
                rVar.jFv = null;
                rVar.aYW = 0;
                rVar.aYV = 0;
            }
        }
        super.onPause();
    }

    public final void cO(String str, String str2) {
        if (this.jLZ) {
            Fd(str);
            NY(str2);
        }
    }

    public void aY(String str, int i) {
    }

    public void XJ() {
        int i = 8;
        boolean z = false;
        if (this.jLZ) {
            int i2;
            if (this.etZ) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            vB(i2);
            if (this.jLW != null) {
                q qVar = this.jLW;
                if (!this.etZ) {
                    i = 0;
                }
                qVar.setVisibility(i);
            }
            if (!this.etZ) {
                z = true;
            }
            this.etZ = z;
        }
    }

    public final void aVF() {
        this.etZ = false;
        vB(8);
        if (this.jLW != null) {
            this.jLW.setVisibility(8);
        }
    }
}
