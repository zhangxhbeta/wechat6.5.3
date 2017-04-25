package com.tencent.mm.vending.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.vending.e.b;

public abstract class PresenterActivity extends Activity implements b {
    private c cll = new c();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cll.B(getIntent(), this);
    }

    protected void onResume() {
        super.onResume();
        this.cll.yw(2);
    }

    protected void onPause() {
        this.cll.yw(3);
        super.onPause();
    }

    protected void onDestroy() {
        this.cll.onDestroy();
        super.onDestroy();
    }
}
