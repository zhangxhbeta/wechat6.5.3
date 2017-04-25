package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class a {
    private String bpX;
    private String cYN = SQLiteDatabase.KeyEmpty;
    boolean nJV = false;
    private String nNE = SQLiteDatabase.KeyEmpty;
    private a nNF;
    private String username = SQLiteDatabase.KeyEmpty;

    public interface a {
        void a(ProgressDialog progressDialog);
    }

    public a(a aVar, String str, String str2, String str3) {
        this.username = str;
        this.cYN = str3;
        this.nNE = str2;
        this.nNF = aVar;
    }

    public final void h(MMActivity mMActivity) {
        final k sVar = new s(this.username, this.nNE, 0, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty, false, true);
        ak.vy().a(sVar, 0);
        a aVar = this.nNF;
        mMActivity.getString(2131231164);
        aVar.a(g.a((Context) mMActivity, mMActivity.getString(2131233565), true, new OnCancelListener(this) {
            final /* synthetic */ a nNG;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(sVar);
            }
        }));
    }

    public final void a(final MMActivity mMActivity, int i, int i2, String str, k kVar) {
        if (i == 4 && (i2 == -16 || i2 == -17)) {
            ak.vy().a(new ay(new com.tencent.mm.model.ay.a(this) {
                final /* synthetic */ a nNG;

                {
                    this.nNG = r1;
                }

                public final void a(e eVar) {
                    if (eVar != null) {
                        c BU = eVar.BU();
                        byte[] bArr = new byte[0];
                        ak.yW();
                        BU.i(bArr, com.tencent.mm.model.c.ww());
                    }
                }
            }), 0);
            int i3 = 1;
        } else {
            boolean z = false;
        }
        if (kVar instanceof s) {
            this.bpX = ((s) kVar).Jh();
        }
        if (i3 != 0 || (i == 0 && i2 == 0)) {
            ak.unhold();
            d.aX(mMActivity);
            l.lX(this.cYN);
            l.a(mMActivity, new Runnable(this) {
                final /* synthetic */ a nNG;

                public final void run() {
                    Intent ak = com.tencent.mm.plugin.a.a.drp.ak(mMActivity);
                    ak.addFlags(67108864);
                    mMActivity.startActivity(ak);
                    mMActivity.finish();
                }
            }, false, 2);
            if (this.nJV) {
                String string = aa.getContext().getSharedPreferences("randomid_prefs", 4).getString("randomID", SQLiteDatabase.KeyEmpty);
                com.tencent.mm.plugin.report.service.g.iuh.h(11930, string, Integer.valueOf(4));
            }
        } else if (i2 == -106) {
            l.D(mMActivity, str);
        } else if (i2 == -217) {
            l.a(mMActivity, ((s) kVar).Jg(), i2);
        } else {
            int i4;
            if (com.tencent.mm.plugin.a.a.drq.a((Context) mMActivity, i, i2, str)) {
                i4 = 1;
            } else {
                if (i == 4) {
                    switch (i2) {
                        case -140:
                            if (!be.kS(this.bpX)) {
                                l.j(mMActivity, str, this.bpX);
                            }
                            i4 = 1;
                            break;
                        case -100:
                            ak.hold();
                            g.a((Context) mMActivity, TextUtils.isEmpty(ak.uA()) ? com.tencent.mm.bd.a.O(mMActivity, 2131233716) : ak.uA(), mMActivity.getString(2131231164), new OnClickListener(this) {
                                final /* synthetic */ a nNG;

                                {
                                    this.nNG = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }, new OnCancelListener(this) {
                                final /* synthetic */ a nNG;

                                {
                                    this.nNG = r1;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                }
                            });
                            i4 = 1;
                            break;
                        case -75:
                            g.f(mMActivity, 2131230894, 2131231164);
                            i4 = 1;
                            break;
                        case -72:
                            g.f(mMActivity, 2131234451, 2131231164);
                            i4 = 1;
                            break;
                        case -9:
                            g.f(mMActivity, 2131233556, 2131233557);
                            i4 = 1;
                            break;
                        case -1:
                            if (ak.vy().BJ() == 5) {
                                g.f(mMActivity, 2131234021, 2131234020);
                                i4 = 1;
                                break;
                            }
                        case -4:
                        case -3:
                            g.f(mMActivity, 2131232483, 2131233557);
                            i4 = 1;
                            break;
                    }
                }
                boolean z2 = false;
            }
            if (i4 == 0) {
                Toast.makeText(mMActivity, mMActivity.getString(2131232858, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }
}
