package com.tencent.mm.ui.bindqq;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.a.o;
import com.tencent.mm.e.a.pu;
import com.tencent.mm.e.a.z;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.ae;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.d;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.w.b;
import com.tencent.mmdb.database.SQLiteDatabase;

public class StartUnbindQQ extends MMWizardActivity implements e {
    private p dwg;
    private h iLp;
    private String iMp = null;
    private View ogL;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(253, (e) this);
        this.iMp = getIntent().getStringExtra("notice");
    }

    public void onDestroy() {
        ak.vy().b(253, (e) this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        NI();
    }

    protected final int getLayoutId() {
        return 2130904527;
    }

    protected final void NI() {
        vD(2131235707);
        this.ogL = findViewById(2131759525);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ StartUnbindQQ ogM;

            {
                this.ogM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ogM.finish();
                return true;
            }
        });
        this.ogL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ StartUnbindQQ ogM;

            {
                this.ogM = r1;
            }

            public final void onClick(View view) {
                if (this.ogM.iLp == null) {
                    this.ogM.iLp = g.a(this.ogM, this.ogM.getString(2131234953), null, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 ogN;

                        {
                            this.ogN = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ak.vy().a(new b(SQLiteDatabase.KeyEmpty), 0);
                            StartUnbindQQ startUnbindQQ = this.ogN.ogM;
                            Context context = this.ogN.ogM;
                            this.ogN.ogM.getString(2131231164);
                            startUnbindQQ.dwg = g.a(context, this.ogN.ogM.getString(2131234954), true, null);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 ogN;

                        {
                            this.ogN = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    this.ogM.iLp.show();
                }
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.StartUnbindQQ", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        if (kVar.getType() == 253) {
            if (this.dwg != null) {
                this.dwg.dismiss();
                this.dwg = null;
            }
            if (i == 0 && i2 == 0) {
                ak.yW();
                int a = be.a((Integer) c.vf().get(9, null), 0);
                v.d("MicroMsg.StartUnbindQQ", "iBindUin " + a);
                if (a != 0) {
                    ak.yW();
                    c.wN().hp(new o(a) + "@qqim");
                }
                ak.yW();
                Object obj = c.vf().get(102407, null);
                if (obj != null && ((String) obj).length() > 0) {
                    ak.yW();
                    c.vf().set(102407, null);
                }
                try {
                    a.nhr.z(new z());
                    ak.yW();
                    String str2 = new o(be.a((Integer) c.vf().get(9, null), 0)) + "@qqim";
                    ak.yW();
                    c.wN().hp(str2);
                    ak.yW();
                    c.wH().Mc(str2);
                    n.Bo().gR(str2);
                    String str3 = com.tencent.mm.model.k.xF() + "@qqim";
                    n.Bo().gR(str3);
                    n.AX();
                    d.t(str2, false);
                    n.AX();
                    d.t(str2, true);
                    n.AX();
                    d.t(str3, false);
                    n.AX();
                    d.t(str3, true);
                    ae FO = ah.FO();
                    v.d("MicroMsg.QQGroupStorage", "delete all");
                    if (FO.cuX.delete("qqgroup", null, null) > 0) {
                        FO.Ls();
                    }
                    com.tencent.mm.plugin.a.a.drq.ow();
                } catch (Throwable e) {
                    v.a("MicroMsg.StartUnbindQQ", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.a("MicroMsg.StartUnbindQQ", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                ak.yW();
                c.vf().set(9, Integer.valueOf(0));
                com.tencent.mm.sdk.c.b puVar = new pu();
                puVar.brb.brc = false;
                puVar.brb.brd = true;
                a.nhr.z(puVar);
                if (be.kS(this.iMp)) {
                    bAv();
                } else {
                    g.a((Context) this, this.iMp, SQLiteDatabase.KeyEmpty, getString(2131230747), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ StartUnbindQQ ogM;

                        {
                            this.ogM = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.ogM.bAv();
                        }
                    });
                }
            }
            com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
            if (dm != null) {
                dm.a(this, null, null);
            }
        }
    }
}
