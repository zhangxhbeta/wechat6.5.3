package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.freewifi.j;

public class FreeWifiOwnerUI extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
        String stringExtra = getIntent().getStringExtra("wifi_owner_name");
        int intExtra = getIntent().getIntExtra("wifi_owner_type", 0);
        j.userName = stringExtra;
        j.type = intExtra;
        finish();
    }
}
