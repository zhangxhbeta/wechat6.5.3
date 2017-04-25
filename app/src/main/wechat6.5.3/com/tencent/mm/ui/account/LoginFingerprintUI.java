package com.tencent.mm.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ap.d;
import com.tencent.mm.ap.h;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.l.a.c;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.g;

public class LoginFingerprintUI extends LoginHistoryUI {
    private LinearLayout nIT;
    private LinearLayout nIU;
    private LinearLayout nIV;
    private TextView nIW;
    private Button nIX;
    private int nIY = 0;
    private h nIZ = new h();
    private a nJa = new a();

    private class a implements com.tencent.mm.ap.h.a {
        final /* synthetic */ LoginFingerprintUI nJb;

        private a(LoginFingerprintUI loginFingerprintUI) {
            this.nJb = loginFingerprintUI;
        }

        public final void a(boolean z, int i, String str) {
            if (z) {
                v.i("MicroMsg.LoginFingerprintUI", "soter fingerprint login successfully");
                return;
            }
            v.i("MicroMsg.LoginFingerprintUI", "soter fingerprint login failed errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
            if (i == -3203) {
                v.i("MicroMsg.LoginFingerprintUI", "fingerprint invalid");
                LoginFingerprintUI.a(this.nJb);
                return;
            }
            v.i("MicroMsg.LoginFingerprintUI", "fingerprint login failed with unknown error");
            this.nJb.i(false, null);
        }

        public final void u(int i, String str) {
            v.e("MicroMsg.LoginFingerprintUI", "soter fingerprint get ticket failed errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
            g.bf(aa.getContext(), "cannot use fingerprint login");
        }

        public final void kr(String str) {
            v.i("MicroMsg.LoginFingerprintUI", "soter fingerprint login need confirm: %b", new Object[]{Boolean.valueOf(true)});
            this.nJb.i(true, str);
        }
    }

    static /* synthetic */ void a(LoginFingerprintUI loginFingerprintUI) {
        loginFingerprintUI.nIY++;
        if (loginFingerprintUI.nIY < 3) {
            loginFingerprintUI.nIZ.JL();
        } else {
            loginFingerprintUI.i(false, null);
        }
    }

    public void onCreate(Bundle bundle) {
        v.i("MicroMsg.LoginFingerprintUI", "LoginFingerprintUI onCreate");
        super.onCreate(bundle);
        if (!this.nJp) {
            this.nIT = (LinearLayout) findViewById(2131757726);
            this.nIU = (LinearLayout) findViewById(2131757727);
            this.nIV = (LinearLayout) findViewById(2131757731);
            this.nIX = (Button) findViewById(2131757733);
            this.nIT.setVisibility(8);
            this.nIU.setVisibility(8);
            this.nJf.setVisibility(8);
            this.nJd.setVisibility(8);
            this.nIV.setVisibility(0);
            this.nIW = (TextView) findViewById(2131757732);
            this.nIW.setVisibility(0);
            this.nIX.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LoginFingerprintUI nJb;

                {
                    this.nJb = r1;
                }

                public final void onClick(View view) {
                    v.i("MicroMsg.LoginFingerprintUI", "auth fingerprint");
                    v.i("MicroMsg.SoterFingerprintLoginService", "alvinluo: start get soter fingerprint ticket");
                    c bol = e.bol();
                    String str = bol.bgr;
                    String str2 = bol.bgs;
                    String A = ai.cse.A("login_user_name", null);
                    if (!be.kS(str) && !be.kS(str2) && !be.kS(A)) {
                        v.d("MicroMsg.SoterFingerprintLoginService", "cpuId: %s, uid: %s, username: %s", new Object[]{str, str2, A});
                        ak.vy().a(new d(str, str2, A), 0);
                    }
                }
            });
            this.nIY = 0;
            this.nIZ.cZY = this.nJa;
        }
    }

    public void onResume() {
        super.onResume();
        v.i("MicroMsg.LoginFingerprintUI", "LoginFingerprintUI onResume");
    }

    public void onDestroy() {
        super.onDestroy();
        h hVar = this.nIZ;
        ak.vy().b(261, hVar);
        ak.vy().b(248, hVar);
        ak.vy().b(620, hVar);
        hVar.cZY = null;
    }

    public final boolean bAP() {
        return false;
    }

    private void i(boolean z, String str) {
        if (!ai.cse.A("login_user_name", "").equals("")) {
            int KL = be.KL(ai.cse.A("last_login_use_voice", ""));
            v.i("MicroMsg.LoginFingerprintUI", "pluginSwitch  " + KL);
            Intent intent = new Intent();
            intent.putExtra("login_success_need_bind_fingerprint", z);
            if (z) {
                intent.putExtra("bind_login_fingerprint_info", str);
            }
            if ((KL & 131072) != 0) {
                v.i("MicroMsg.LoginFingerprintUI", "voice login");
                intent.setClass(aa.getContext(), LoginVoiceUI.class);
            } else {
                v.i("MicroMsg.LoginFingerprintUI", "history login");
                intent.setClass(aa.getContext(), LoginHistoryUI.class);
            }
            startActivity(intent);
            finish();
            b.ev(this);
        }
    }

    public void onPause() {
        super.onPause();
        if (this.nIZ != null) {
            h hVar = this.nIZ;
            if (com.tencent.mm.compatible.util.d.dY(15) && hVar.cZZ != null) {
                hVar.cZZ.cancel();
                hVar.cZZ = null;
            }
        }
    }
}
