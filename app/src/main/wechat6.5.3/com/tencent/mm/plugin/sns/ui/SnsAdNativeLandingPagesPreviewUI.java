package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public class SnsAdNativeLandingPagesPreviewUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("sns_landing_pages_xml");
        if (TextUtils.isEmpty(stringExtra)) {
            v.e("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml");
            finish();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (e.Bm(stringExtra)) {
            v.i("SnsAdNativeLandingPagesPreviewUI", "isValidCanvas time cost " + (System.currentTimeMillis() - currentTimeMillis));
            e.z(intent, this);
            finish();
            if (intent.getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false)) {
                overridePendingTransition(0, 0);
                return;
            } else {
                overridePendingTransition(2130968680, 2130968677);
                return;
            }
        }
        v.i("SnsAdNativeLandingPagesPreviewUI", "unknown canvas goto webview, " + stringExtra);
        int indexOf = stringExtra.indexOf("<shareWebUrl>");
        if (indexOf >= 0) {
            int indexOf2 = stringExtra.indexOf("</shareWebUrl>");
            if (indexOf2 > indexOf + 13) {
                String substring = stringExtra.substring(indexOf + 13, indexOf2);
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", substring);
                intent2.putExtra("showShare", true);
                c.b(this, "webview", ".ui.tools.WebViewUI", intent2);
                finish();
                overridePendingTransition(2130968680, 2130968677);
                return;
            }
        }
        finish();
    }

    protected final int getLayoutId() {
        return 2130904431;
    }
}
