package com.tencent.wxop.stat;

import android.app.Activity;

public class EasyActivity extends Activity {
    protected void onPause() {
        super.onPause();
        d.gL(this);
    }

    protected void onResume() {
        super.onResume();
        d.gK(this);
    }
}
