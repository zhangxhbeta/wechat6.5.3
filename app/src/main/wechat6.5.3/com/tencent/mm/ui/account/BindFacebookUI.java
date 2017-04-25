package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.e.a.b;
import com.tencent.mm.ui.e.a.c;
import com.tencent.mm.ui.e.a.d;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.List;

public class BindFacebookUI extends MMWizardActivity implements e {
    private c nHN;
    private ProgressDialog nHO;
    private OnCancelListener nHP;
    private g nHQ;

    private final class a implements com.tencent.mm.ui.e.a.c.a {
        final /* synthetic */ BindFacebookUI nHR;

        private a(BindFacebookUI bindFacebookUI) {
            this.nHR = bindFacebookUI;
        }

        public final void k(Bundle bundle) {
            v.d("MicroMsg.BindFacebookUI", "token:" + this.nHR.nHN.oed);
            ak.yW();
            com.tencent.mm.model.c.vf().set(65830, this.nHR.nHN.oed);
            if (this.nHR.nHN.oNm != 0) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(65832, Long.valueOf(this.nHR.nHN.oNm));
            }
            this.nHR.nHO = ProgressDialog.show(this.nHR, this.nHR.getString(2131231164), this.nHR.getString(2131232607), true);
            this.nHR.nHO.setOnCancelListener(this.nHR.nHP);
            this.nHR.nHQ = new g(1, this.nHR.nHN.oed);
            ak.vy().a(this.nHR.nHQ, 0);
            BindFacebookUI.jb(true);
        }

        public final void a(d dVar) {
            v.d("MicroMsg.BindFacebookUI", "onFacebookError:" + dVar.oNt);
            com.tencent.mm.ui.base.g.A(this.nHR, dVar.getMessage(), this.nHR.getString(2131232029));
            BindFacebookUI.jb(false);
        }

        public final void a(b bVar) {
            v.d("MicroMsg.BindFacebookUI", "onError:" + bVar.getMessage());
            com.tencent.mm.ui.base.g.A(this.nHR, bVar.getMessage(), this.nHR.getString(2131232029));
            BindFacebookUI.jb(false);
        }

        public final void onCancel() {
            v.d("MicroMsg.BindFacebookUI", "onCancel");
            BindFacebookUI.jb(false);
        }
    }

    static /* synthetic */ void jb(boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.ak.i.a(32, z ? "0" : "1"));
        ak.yW();
        com.tencent.mm.model.c.wG().b(new i(arrayList));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(183, this);
        NI();
    }

    protected void onPause() {
        super.onPause();
        ak.vy().b(183, this);
    }

    protected final int getLayoutId() {
        return 2130903167;
    }

    protected final void NI() {
        this.nHN = new c("290293790992170");
        this.nHP = new OnCancelListener(this) {
            final /* synthetic */ BindFacebookUI nHR;

            {
                this.nHR = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.nHR.nHQ != null) {
                    ak.vy().c(this.nHR.nHQ);
                }
            }
        };
        a(0, getString(2131231078), new OnMenuItemClickListener(this) {
            final /* synthetic */ BindFacebookUI nHR;

            {
                this.nHR = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nHR.bAv();
                return true;
            }
        });
        vD(2131231379);
        TextView textView = (TextView) findViewById(2131755594);
        textView.setVisibility(4);
        textView.setText(2131231378);
        Button button = (Button) findViewById(2131755595);
        button.setVisibility(0);
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindFacebookUI nHR;

            {
                this.nHR = r1;
            }

            public final void onClick(View view) {
                this.nHR.nHN.a(this.nHR, FacebookAuthUI.nIg, new a());
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 183) {
            if (this.nHO != null) {
                this.nHO.dismiss();
            }
            if (!com.tencent.mm.plugin.a.a.drq.a(this.nDR.nEl, i, i2, str)) {
                int i3 = ((g) kVar).opType;
                if (i == 0 && i2 == 0) {
                    if (i3 == 1) {
                        ak.yW();
                        com.tencent.mm.model.c.wK().Mf("facebookapp");
                        ak.yW();
                        com.tencent.mm.model.c.wJ().MO("facebookapp");
                    }
                    bAv();
                } else if (i == 4 && i2 == -67) {
                    Toast.makeText(this, 2131232609, 1).show();
                } else if (i == 4 && i2 == -5) {
                    Toast.makeText(this, i3 == 1 ? 2131232604 : 2131232610, 1).show();
                } else {
                    Toast.makeText(this, i3 == 0 ? 2131232035 : 2131232029, 1).show();
                }
            }
        }
    }
}
