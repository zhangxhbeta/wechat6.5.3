package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.VideoView;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.export.external.DexLoader;

public class VideoActivity extends Activity {
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        r.fD(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.requestWindowFeature(1);
        super.getWindow().setFormat(-3);
        Intent intent = super.getIntent();
        Bundle bundleExtra = intent != null ? intent.getBundleExtra("extraData") : null;
        if (bundleExtra != null) {
            bundleExtra.putInt("callMode", 1);
            r fD = r.fD(super.getApplicationContext());
            if (bundleExtra == null) {
                bundleExtra = new Bundle();
            }
            if (!TextUtils.isEmpty(null)) {
                bundleExtra.putString("videoUrl", null);
            }
            bundleExtra.putInt("callMode", 1);
            s sVar = fD.pxu;
            sVar.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
            if (sVar.pxw == null) {
                c.kx(true).a(sVar.getContext().getApplicationContext(), null);
                t bMI = c.kx(true).bMI();
                DexLoader dexLoader = bMI != null ? bMI.pxC : null;
                if (dexLoader != null && QbSdk.canLoadVideo(sVar.getContext())) {
                    sVar.pxw = new v(dexLoader);
                }
            }
            if (sVar.pxw != null && sVar.pxv == null) {
                sVar.pxv = sVar.pxw.fE(sVar.getContext().getApplicationContext());
            }
            boolean z = false;
            if (sVar.bNC()) {
                bundleExtra.putInt("callMode", bundleExtra.getInt("callMode"));
                z = sVar.pxw.a(sVar.pxv, bundleExtra, sVar, null);
            }
            if (!z) {
                if (sVar.pxx != null) {
                    sVar.pxx.stopPlayback();
                }
                if (sVar.pxx == null) {
                    sVar.pxx = new VideoView(sVar.getContext());
                }
                sVar.mUrl = bundleExtra.getString("videoUrl");
                sVar.pxx.setVideoURI(Uri.parse(sVar.mUrl));
                sVar.pxx.setOnErrorListener(sVar);
                intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                Context applicationContext = sVar.getContext().getApplicationContext();
                intent.setPackage(applicationContext.getPackageName());
                applicationContext.startActivity(intent);
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        r.fD(this).j(this, 4);
    }

    protected void onPause() {
        super.onPause();
        r.fD(this).j(this, 3);
    }

    protected void onResume() {
        super.onResume();
        r.fD(this).j(this, 2);
    }

    protected void onStop() {
        super.onStop();
        r.fD(this).j(this, 1);
    }
}
