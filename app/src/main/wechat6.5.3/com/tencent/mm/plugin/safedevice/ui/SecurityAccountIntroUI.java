package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.plugin.a.a;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.gf;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Map;

public class SecurityAccountIntroUI extends MMWizardActivity implements e {
    private String bhT;
    private ProgressDialog dwR = null;
    private String ivc;
    private String ivd;
    private boolean ive = false;
    private Button ivf;
    private String ivg;
    private String jumpUrl;

    protected final int getLayoutId() {
        return 2130904315;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ivc = getIntent().getStringExtra("auth_ticket");
        this.bhT = getIntent().getStringExtra("binded_mobile");
        this.ive = getIntent().getBooleanExtra("re_open_verify", false);
        String stringExtra = getIntent().getStringExtra("close_safe_device_style");
        v.i("MicroMsg.SecurityAccountIntroUI", "summerphone authTicket[%s], showStyle[%s]", new Object[]{be.KW(this.ivc), stringExtra});
        if (!be.kS(stringExtra)) {
            Map q = bf.q(stringExtra, "wording");
            if (q != null) {
                this.ivd = (String) q.get(".wording.title");
                this.jumpUrl = (String) q.get(".wording.url");
                v.i("MicroMsg.SecurityAccountIntroUI", "summerphone closeBtnText[%s], jumpUrl[%s]", new Object[]{this.ivd, this.jumpUrl});
            }
        }
        this.ivg = b.Oa();
        NI();
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(145, this);
        ak.vy().a(132, this);
        if (!this.ive) {
            b.b(true, ak.uR() + "," + getClass().getName() + ",L600_100," + ak.dR("L600_100") + ",1");
            b.mh("L600_100");
        }
    }

    protected void onPause() {
        super.onPause();
        ak.vy().b(145, this);
        ak.vy().b(132, this);
        if (!this.ive) {
            b.b(false, ak.uR() + "," + getClass().getName() + ",L600_100," + ak.dR("L600_100") + ",2");
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        aKM();
        return true;
    }

    protected final void NI() {
        vD(2131234722);
        findViewById(2131759016).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SecurityAccountIntroUI ivh;

            {
                this.ivh = r1;
            }

            public final void onClick(View view) {
                k vVar;
                if (this.ivh.ive) {
                    vVar = new com.tencent.mm.modelfriend.v(this.ivh.bhT, 10, "", 0, "");
                } else {
                    vVar = new u(this.ivh.bhT, 10, "", 0, "", this.ivh.ivc);
                }
                ak.vy().a(vVar, 0);
                SecurityAccountIntroUI securityAccountIntroUI = this.ivh;
                SecurityAccountIntroUI securityAccountIntroUI2 = this.ivh;
                this.ivh.getString(2131231164);
                securityAccountIntroUI.dwR = g.a(securityAccountIntroUI2, this.ivh.getString(2131234718), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass1 ivj;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(vVar);
                    }
                });
            }
        });
        if (!this.ive) {
            this.ivf = (Button) findViewById(2131759017);
            if (!be.kS(this.ivd)) {
                this.ivf.setText(this.ivd);
            }
            this.ivf.setVisibility(0);
            this.ivf.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SecurityAccountIntroUI ivh;

                {
                    this.ivh = r1;
                }

                public final void onClick(View view) {
                    String d = com.tencent.mm.sdk.platformtools.u.d(this.ivh.getSharedPreferences(aa.bti(), 0));
                    Intent intent = new Intent();
                    if (be.kS(this.ivh.jumpUrl)) {
                        intent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[]{d}));
                    } else {
                        intent.putExtra("rawUrl", this.ivh.jumpUrl);
                    }
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, this.ivh.getString(2131234713));
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                    a.drp.j(intent, this.ivh);
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SecurityAccountIntroUI ivh;

            {
                this.ivh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ivh.aKM();
                return true;
            }
        });
    }

    private void aKM() {
        b.mi(this.ivg);
        cancel();
        bAv();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (i == 0 && i2 == 0) {
            String str2;
            if (this.ive) {
                str2 = ((gf) ((com.tencent.mm.modelfriend.v) kVar).cif.czl.czs).meg;
            } else {
                str2 = ((u) kVar).Fj();
            }
            v.d("MicroMsg.SecurityAccountIntroUI", "duanyi test authTicket_login = " + this.ivc + "duanyi test authTicket_check = " + str2);
            Intent intent = new Intent(this, SecurityAccountVerifyUI.class);
            intent.putExtra("auth_ticket", str2);
            intent.putExtra("binded_mobile", this.bhT);
            intent.putExtra("re_open_verify", this.ive);
            intent.putExtra("from_source", getIntent().getIntExtra("from_source", 1));
            w(this, intent);
            if (getIntent().getIntExtra("from_source", 1) == 3) {
                finish();
                return;
            }
            return;
        }
        int i3;
        switch (i2) {
            case -74:
                g.a(this, 2131231398, 2131231164, null);
                i3 = 1;
                break;
            case -57:
            case -1:
                Toast.makeText(this, 2131231042, 0).show();
                i3 = 1;
                break;
            case -41:
                Toast.makeText(this, 2131231401, 0).show();
                i3 = 1;
                break;
            case -34:
                Toast.makeText(this, 2131231402, 0).show();
                i3 = 1;
                break;
            default:
                i3 = 0;
                break;
        }
        if (i3 == 0 && !a.drq.a(this, i, i2, str)) {
            Toast.makeText(this, getString(2131234716, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
