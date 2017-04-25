package com.tencent.wxop.stat;

import android.app.ListActivity;

public class EasyListActivity extends ListActivity {
    protected void onPause() {
        super.onPause();
        d.gL(this);
    }

    protected void onResume() {
        super.onResume();
        d.gK(this);
    }
}
