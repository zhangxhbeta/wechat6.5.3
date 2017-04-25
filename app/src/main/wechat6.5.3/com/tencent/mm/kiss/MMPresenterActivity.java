package com.tencent.mm.kiss;

import android.os.Bundle;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.app.c;

public abstract class MMPresenterActivity extends MMActivity {
    private c cll = new c();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cll.B(getIntent(), this);
    }

    protected void onResume() {
        super.onResume();
        this.cll.yw(2);
    }

    protected void onPause() {
        super.onPause();
        this.cll.yw(3);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.cll.onDestroy();
    }
}
