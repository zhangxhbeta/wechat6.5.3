package com.tencent.mm.plugin.location_soso;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.tencent.mm.plugin.e.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.q;
import com.tencent.tencentmap.mapsdk.map.MapActivity;

@a(19)
public class SoSoProxyUI extends MapActivity {
    protected static final String TAG = "MicroMsg.SoSoProxyUI";
    private com.tencent.mm.plugin.e.a basemapUI;

    public void onCreate(Bundle bundle) {
        v.d(TAG, "SoSoProxyUI onCreate");
        super.onCreate(bundle);
        this.basemapUI = c.a.gZR.e(this, getIntent().getIntExtra("intent_map_key", -1));
        if (this.basemapUI == null) {
            finish();
            return;
        }
        this.basemapUI.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(2131690051));
        }
    }

    public void onBackPressed() {
        this.basemapUI.onBackPressed();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.basemapUI.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.basemapUI.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || keyEvent.getAction() != 1) {
            return super.onKeyUp(i, keyEvent);
        }
        this.basemapUI.axh();
        return true;
    }

    public void onResume() {
        super.onResume();
        this.basemapUI.onResume();
    }

    public void onPause() {
        super.onPause();
        this.basemapUI.onPause();
    }

    public void onDestroy() {
        this.basemapUI.onDestroy();
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.basemapUI.onActivityResult(i, i2, intent);
    }

    public Object getSystemService(String str) {
        Object systemService = super.getSystemService(str);
        if (getAssets() == null || !"layout_inflater".equals(str)) {
            return systemService;
        }
        return q.b((LayoutInflater) systemService);
    }

    public Resources getResources() {
        if (getAssets() == null || aa.getResources() == null) {
            return super.getResources();
        }
        return aa.getResources();
    }

    public void finish() {
        super.finish();
    }
}
