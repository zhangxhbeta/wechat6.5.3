package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.a.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

public class RegByQQAuthUI extends MMActivity implements e {
    private String bax;
    private String bld;
    private String cYN;
    private ProgressDialog dwR = null;
    private String nJH;
    private EditText nLB = null;
    private int nLC;

    protected final int getLayoutId() {
        return 2130904272;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        ak.vy().a(126, this);
    }

    public void onPause() {
        super.onPause();
        ak.vy().b(126, this);
    }

    protected final void NI() {
        this.nLC = getIntent().getIntExtra("RegByQQ_BindUin", 0);
        this.nJH = getIntent().getStringExtra("RegByQQ_RawPsw");
        this.cYN = getIntent().getStringExtra("RegByQQ_Account");
        this.bax = getIntent().getStringExtra("RegByQQ_Ticket");
        this.bld = getIntent().getStringExtra("RegByQQ_Nick");
        v.v("MicroMsg.RegByQQAuthUI", "values : bindUin:" + this.nLC + "  pass:" + this.nJH + "  ticket:" + this.bax);
        this.nLB = (EditText) findViewById(2131758873);
        if (!(this.bld == null || this.bld.equals(""))) {
            this.nLB.setText(this.bld);
        }
        vD(2131234455);
        a(0, getString(2131231103), new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByQQAuthUI nLD;

            {
                this.nLD = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nLD.bld = this.nLD.nLB.getText().toString().trim();
                if (this.nLD.bld.equals("")) {
                    g.f(this.nLD, 2131235771, 2131231040);
                } else {
                    final u uVar = new u("", this.nLD.nJH, this.nLD.bld, this.nLD.nLC, "", "", this.nLD.bax, 2);
                    ak.vy().a(uVar, 0);
                    RegByQQAuthUI regByQQAuthUI = this.nLD;
                    RegByQQAuthUI regByQQAuthUI2 = this.nLD;
                    this.nLD.getString(2131231164);
                    regByQQAuthUI.dwR = g.a(regByQQAuthUI2, this.nLD.getString(2131234461), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass1 nLF;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(uVar);
                        }
                    });
                }
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByQQAuthUI nLD;

            {
                this.nLD = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nLD.axg();
                this.nLD.finish();
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.RegByQQAuthUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (!be.bm(this)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 126:
                    ak.unhold();
                    ai.cse.J("login_user_name", this.cYN);
                    Intent intent = new Intent(this, BindMContactIntroUI.class);
                    intent.putExtra("key_upload_scene", 1);
                    intent.putExtra("skip", true);
                    Intent ak = a.drp.ak(this);
                    ak.addFlags(67108864);
                    ak.putExtra("LauncherUI.enter_from_reg", true);
                    MMWizardActivity.b(this, intent, ak);
                    return;
                default:
                    return;
            }
        }
        boolean z;
        if (kVar.getType() == 126) {
            com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
            if (dm != null) {
                dm.a(this, null, null);
                return;
            }
        }
        if (a.drq.a(this.nDR.nEl, i, i2, str)) {
            z = true;
        } else {
            if (i == 4) {
                switch (i2) {
                    case -75:
                        g.f(this.nDR.nEl, 2131230895, 2131231164);
                        z = true;
                        break;
                    case -72:
                        g.f(this.nDR.nEl, 2131234451, 2131231164);
                        z = true;
                        break;
                    case DownloadResult.CODE_SPACE_NOT_ENOUGH /*-12*/:
                        g.f(this, 2131234454, 2131234453);
                        z = true;
                        break;
                    case -11:
                        g.f(this, 2131234452, 2131234453);
                        z = true;
                        break;
                    case -4:
                        g.f(this, 2131231038, 2131234453);
                        z = true;
                        break;
                    case -1:
                        if (ak.vy().BJ() == 5) {
                            g.f(this, 2131234021, 2131234020);
                            z = true;
                            break;
                        }
                    case -3:
                        g.f(this, 2131231039, 2131234453);
                        z = true;
                        break;
                }
            }
            z = false;
        }
        if (!z) {
            Toast.makeText(this, getString(2131232915, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
