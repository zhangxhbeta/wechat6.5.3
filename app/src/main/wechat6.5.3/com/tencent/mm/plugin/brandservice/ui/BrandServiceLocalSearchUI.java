package com.tencent.mm.plugin.brandservice.ui;

import android.os.Bundle;
import android.view.Menu;
import com.tencent.mm.al.k;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class BrandServiceLocalSearchUI extends MMActivity implements BrandServiceSortView.a, p.a {
    private p eyI;
    private BrandServiceSortView eyJ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        ak.vy().a(new k(18), 0);
    }

    public final void Oh() {
    }

    protected final void NI() {
        this.eyJ = (BrandServiceSortView) findViewById(2131755696);
        this.eyJ.YE();
        this.eyJ.eyG = getIntent().getBooleanExtra("is_return_result", false);
        this.eyJ.YF();
        this.eyJ.cf(false);
        this.eyJ.L(false);
        this.eyJ.eAf = this;
        this.eyI = new p();
        this.eyI.kj(true);
        this.eyI.a(this);
        this.eyI.lUX = false;
    }

    public final void Og() {
    }

    public final void Of() {
        finish();
    }

    public final void ml(String str) {
        v.i("MicroMsg.BrandServiceLocalSearchUI", "search biz, key word : %s", new Object[]{str});
        this.eyJ.pB(str);
    }

    public final boolean mk(String str) {
        axg();
        return true;
    }

    public final void Yt() {
        axg();
    }

    public final void Yu() {
    }

    protected void onPause() {
        super.onPause();
        this.eyI.cancel();
        this.eyI.clearFocus();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.eyJ.release();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.eyI.a(this, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.eyI.a(this, menu);
        return true;
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
    }

    protected final int getLayoutId() {
        return 2130903195;
    }

    public final boolean Yv() {
        axg();
        return false;
    }
}
