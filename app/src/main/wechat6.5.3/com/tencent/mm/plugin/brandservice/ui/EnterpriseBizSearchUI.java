package com.tencent.mm.plugin.brandservice.ui;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.b;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class EnterpriseBizSearchUI extends MMActivity implements b, p.a {
    private p eyI;
    private EnterpriseBizContactListView eyN;
    private String ezn;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.eyN != null) {
            EnterpriseBizContactListView.release();
        }
    }

    public final void Oh() {
    }

    protected final void NI() {
        if (be.kS(this.ezn)) {
            this.ezn = getIntent().getStringExtra("enterprise_biz_name");
            if (be.kS(this.ezn)) {
                finish();
            }
        }
        this.eyN = (EnterpriseBizContactListView) findViewById(2131755696);
        this.eyN.eyL = this.ezn;
        this.eyN.eyS = true;
        this.eyN.refresh();
        this.eyN.YE();
        this.eyN.Yw();
        this.eyN.YF();
        this.eyN.cf(false);
        this.eyN.eyV = this;
        ((TextView) this.eyN.Yy()).setText(2131232474);
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
        v.i("MicroMsg.EnterpriseBizSearchUI", "search biz, key word : %s", new Object[]{str});
        this.eyN.pB(str);
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
        return 2130903529;
    }

    public final boolean Yv() {
        axg();
        return false;
    }
}
