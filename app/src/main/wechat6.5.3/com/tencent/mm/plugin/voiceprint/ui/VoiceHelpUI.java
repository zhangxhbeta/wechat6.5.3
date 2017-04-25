package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public class VoiceHelpUI extends MMActivity {
    private String cZU;
    private int dLU;
    private String dRA;
    private String gNF;
    private String kpP;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dRA = be.ah(getIntent().getStringExtra("Kusername"), null);
        this.cZU = be.ah(getIntent().getStringExtra("Kvertify_key"), null);
        if (be.kS(this.dRA) || be.kS(this.cZU)) {
            v.w("MicroMsg.VoiceHelpUI", "summervoice username or ticket is null and finish");
            finish();
            return;
        }
        this.kpP = be.ah(getIntent().getStringExtra("KVoiceHelpUrl"), null);
        this.gNF = be.ah(getIntent().getStringExtra("KVoiceHelpWording"), null);
        this.dLU = getIntent().getIntExtra("KVoiceHelpCode", 0);
        if (!be.kS(this.gNF)) {
            ((TextView) findViewById(2131759639)).setText(this.gNF);
        }
        vD(2131235811);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ VoiceHelpUI kpQ;

            {
                this.kpQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kpQ.finish();
                return true;
            }
        });
        findViewById(2131759640).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VoiceHelpUI kpQ;

            {
                this.kpQ = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.kpQ, VoiceLoginUI.class);
                intent.putExtra("kscene_type", 73);
                intent.putExtra("Kusername", this.kpQ.dRA);
                intent.putExtra("Kvertify_key", this.kpQ.cZU);
                this.kpQ.startActivityForResult(intent, 1024);
            }
        });
        findViewById(2131759641).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VoiceHelpUI kpQ;

            {
                this.kpQ = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", new StringBuilder(this.kpQ.kpP).toString());
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                c.b(this.kpQ, "webview", ".ui.tools.WebViewUI", intent);
                this.kpQ.finish();
            }
        });
    }

    protected final int getLayoutId() {
        return 2130904580;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.VoiceHelpUI";
        String str2 = "summervoice onActivityResult, requestCode:%d, resultCode:%d, data==null:%b, mErrCode[%d]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        objArr[3] = Integer.valueOf(this.dLU);
        v.i(str, str2, objArr);
        if (i2 == -1) {
            if (i == 1024 && intent != null) {
                String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                str = "MicroMsg.VoiceHelpUI";
                str2 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d";
                objArr = new Object[2];
                objArr[0] = Boolean.valueOf(be.kS(stringExtra));
                if (!be.kS(stringExtra)) {
                    i3 = stringExtra.length();
                }
                objArr[1] = Integer.valueOf(i3);
                v.d(str, str2, objArr);
                Intent intent2 = new Intent();
                intent2.putExtra("VoiceLoginAuthPwd", stringExtra);
                intent2.putExtra("KVoiceHelpCode", this.dLU);
                setResult(-1, intent2);
            }
            finish();
        }
    }
}
