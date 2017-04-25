package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.pwd.a.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.n;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b.e;
import com.tencent.mm.wallet_core.b.o;
import com.tencent.mm.wallet_core.b.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.d;
import java.util.Iterator;
import java.util.Vector;

public class WalletDigitalCertUI extends WalletBaseUI {
    private Button eVF;
    private ImageView hEP;
    private TextView kKk;
    private Button kKl;
    private LinearLayout kKm;
    private TextView kKn;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gQ(1654);
        gQ(1568);
        p(new b());
        NI();
        g.iuh.h(13731, new Object[]{Integer.valueOf(1)});
    }

    public final void NI() {
        vD(2131236287);
        this.hEP = (ImageView) findViewById(2131759889);
        this.kKk = (TextView) findViewById(2131759890);
        this.kKl = (Button) findViewById(2131759894);
        this.eVF = (Button) findViewById(2131759895);
        this.kKm = (LinearLayout) findViewById(2131759897);
        this.kKn = (TextView) findViewById(2131759896);
        this.kKl.setOnClickListener(new d(this) {
            final /* synthetic */ WalletDigitalCertUI kKo;

            {
                this.kKo = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.kKo, WalletIdCardCheckUI.class);
                this.kKo.startActivityForResult(intent, 1);
            }
        });
        this.eVF.setOnClickListener(new d(this) {
            final /* synthetic */ WalletDigitalCertUI kKo;

            {
                this.kKo = r1;
            }

            public final void onClick(View view) {
                p.bLj();
                this.kKo.j(new e(p.bLi()));
                g.iuh.h(13731, new Object[]{Integer.valueOf(10)});
            }
        });
        b(new n(this) {
            final /* synthetic */ WalletDigitalCertUI kKo;

            {
                this.kKo = r1;
            }

            public final void bfd() {
                this.kKo.finish();
            }
        });
        bft();
    }

    private void bft() {
        v.i("MicroMsg.WalletDigitalCertUI", "updateCrtState");
        this.kKm.removeAllViews();
        if (p.bLj().bLk()) {
            this.kKl.setVisibility(8);
            this.eVF.setVisibility(0);
            this.kKk.setText(2131236304);
            this.hEP.setImageResource(2130839515);
        } else {
            this.kKl.setVisibility(0);
            this.eVF.setVisibility(8);
            this.kKk.setText(2131236290);
            this.hEP.setImageResource(2130839516);
        }
        Vector vector = p.bLj().piM;
        if (vector.size() == 0) {
            this.kKm.setVisibility(8);
            this.kKn.setVisibility(8);
            return;
        }
        this.kKm.setVisibility(0);
        this.kKn.setVisibility(0);
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (oVar.piK <= 0) {
                View inflate = View.inflate(this, 2130904630, null);
                TextView textView = (TextView) inflate.findViewById(2131759875);
                TextView textView2 = (TextView) inflate.findViewById(2131759876);
                ((TextView) inflate.findViewById(2131759874)).setText(oVar.piI);
                textView.setText(oVar.piJ);
                textView2.setTag(oVar);
                textView2.setOnClickListener(new d(this) {
                    final /* synthetic */ WalletDigitalCertUI kKo;

                    {
                        this.kKo = r1;
                    }

                    public final void onClick(View view) {
                        if (view.getTag() instanceof o) {
                            final o oVar = (o) view.getTag();
                            com.tencent.mm.ui.base.g.a(this.kKo, this.kKo.getString(2131236289, new Object[]{oVar.piI}), "", this.kKo.getString(2131232277), this.kKo.getString(2131231565), true, new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass4 kKq;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    v.i("MicroMsg.WalletDigitalCertUI", "del crt %s", new Object[]{oVar.mWk});
                                    this.kKq.kKo.j(new e(oVar.mWk));
                                }
                            }, null);
                        }
                    }
                });
                this.kKm.addView(inflate);
            }
        }
        if (this.kKm.getChildCount() == 0) {
            this.kKn.setVisibility(8);
        } else {
            this.kKn.setVisibility(0);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        gR(1654);
        gR(1568);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof b)) {
            if (kVar instanceof e) {
                if (i2 == 0) {
                    g.iuh.h(13731, new Object[]{Integer.valueOf(11)});
                    p.bLj().PP(((e) kVar).piv);
                } else {
                    g.iuh.h(13731, new Object[]{Integer.valueOf(12)});
                }
            }
            return false;
        }
        bft();
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (1 == i && i2 == -1) {
            p(new b());
        }
    }

    protected final int getLayoutId() {
        return 2130904638;
    }
}
