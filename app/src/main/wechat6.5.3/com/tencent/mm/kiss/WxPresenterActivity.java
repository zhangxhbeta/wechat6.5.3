package com.tencent.mm.kiss;

import android.os.Bundle;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.e.a;

public abstract class WxPresenterActivity extends MMActivity {
    protected c cll = new c();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cll.B(getIntent(), this);
    }

    public void onResume() {
        super.onResume();
        this.cll.yw(2);
    }

    public void onPause() {
        this.cll.yw(3);
        super.onPause();
    }

    public void onDestroy() {
        this.cll.onDestroy();
        super.onDestroy();
    }

    public final void a(a aVar) {
        this.cll.a(aVar);
    }

    public final <T extends b<? extends com.tencent.mm.vending.app.a>> T i(Class<? extends b<? extends com.tencent.mm.vending.app.a>> cls) {
        return this.cll.a(this, cls);
    }

    public final com.tencent.mm.vending.app.a vF() {
        return this.cll.vF();
    }
}
