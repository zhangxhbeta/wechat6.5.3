package com.tencent.mm.ui.bindqq;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.e.a.gn;
import com.tencent.mm.e.a.go;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.gh;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public class VerifyQQUI extends MMWizardActivity implements e {
    private String bgb;
    private String bgd;
    private byte[] cxX = null;
    private p dwg = null;
    private String kQj = SQLiteDatabase.KeyEmpty;
    private SecurityImage nFq = null;
    private long ogP = 0;
    private String ogQ = SQLiteDatabase.KeyEmpty;
    private String ogR;

    class a extends b {
        final /* synthetic */ VerifyQQUI ogS;

        a(VerifyQQUI verifyQQUI) {
            this.ogS = verifyQQUI;
        }

        public final void bAL() {
            ak.vy().a(new com.tencent.mm.w.a(this.ogS.ogP, this.ogS.kQj, this.ogS.ogQ, SQLiteDatabase.KeyEmpty, this.ogS.ogR, 2, true), 0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(144, (e) this);
    }

    public void onDestroy() {
        super.onDestroy();
        ak.vy().b(144, (e) this);
    }

    protected void onResume() {
        super.onResume();
        NI();
    }

    protected final int getLayoutId() {
        return 2130903178;
    }

    public final boolean bkj() {
        axg();
        finish();
        return true;
    }

    protected final void NI() {
        com.tencent.mm.sdk.c.b gnVar = new gn();
        gnVar.bfZ.context = this;
        com.tencent.mm.sdk.c.a.nhr.z(gnVar);
        this.bgb = gnVar.bga.bgb;
        gnVar = new go();
        com.tencent.mm.sdk.c.a.nhr.z(gnVar);
        this.bgd = gnVar.bgc.bgd;
        vD(2131231484);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ VerifyQQUI ogS;

            {
                this.ogS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ogS.axg();
                this.ogS.bAv();
                return true;
            }
        });
        final EditText editText = (EditText) findViewById(2131755632);
        final EditText editText2 = (EditText) findViewById(2131755633);
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ VerifyQQUI ogS;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = editText.getText().toString().trim();
                this.ogS.kQj = editText2.getText().toString().trim();
                try {
                    this.ogS.ogP = Long.parseLong(trim);
                    if (this.ogS.ogP < 10000) {
                        g.f(this.ogS.nDR.nEl, 2131231478, 2131231476);
                    } else if (this.ogS.kQj.equals(SQLiteDatabase.KeyEmpty)) {
                        g.f(this.ogS.nDR.nEl, 2131231477, 2131231476);
                    } else {
                        this.ogS.axg();
                        final k aVar = new com.tencent.mm.w.a(this.ogS.ogP, this.ogS.kQj, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, this.ogS.bgb, this.ogS.bgd, false);
                        ak.vy().a(aVar, 0);
                        VerifyQQUI verifyQQUI = this.ogS;
                        Context context = this.ogS.nDR.nEl;
                        this.ogS.getString(2131231480);
                        verifyQQUI.dwg = g.a(context, this.ogS.getString(2131231471), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass2 ogW;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(aVar);
                            }
                        });
                    }
                } catch (Exception e) {
                    g.f(this.ogS.nDR.nEl, 2131231478, 2131231476);
                }
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        byte[] a;
        v.i("MicroMsg.VerifyQQUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwg != null) {
            this.dwg.dismiss();
            this.dwg = null;
        }
        com.tencent.mm.w.a aVar = (com.tencent.mm.w.a) kVar;
        byte[] Q = ak.yS().Q(aVar.cBd);
        v.i("MicroMsg.NetSceneBindQQ", "getRespImgBuf getWtloginMgr getVerifyImg:%d  uin:%d", Integer.valueOf(be.k(Q, new byte[0]).length), Long.valueOf(aVar.cBd));
        if (be.bl(Q)) {
            a = m.a(((gh) aVar.cif.czl.czs).mbY);
        } else {
            a = Q;
        }
        this.cxX = a;
        this.ogQ = ((gh) ((com.tencent.mm.w.a) kVar).cif.czl.czs).mgT;
        if (this.cxX != null) {
            v.d("MicroMsg.VerifyQQUI", "imgSid:" + this.ogQ + " img len" + this.cxX.length + " " + com.tencent.mm.compatible.util.g.sm());
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.a.a.drq.ow();
            g.a(this.nDR.nEl, 2131231479, 2131231480, new OnClickListener(this) {
                final /* synthetic */ VerifyQQUI ogS;

                {
                    this.ogS = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.ogS.bAv();
                }
            });
            return;
        }
        Object obj;
        if (i == 4) {
            com.tencent.mm.f.a dm;
            switch (i2) {
                case -311:
                case -310:
                case -6:
                    v.d("MicroMsg.VerifyQQUI", "imgSid:" + this.ogQ + " img len" + this.cxX.length + " " + com.tencent.mm.compatible.util.g.sm());
                    if (!ak.uz()) {
                        obj = 1;
                        break;
                    }
                    if (this.nFq == null) {
                        this.nFq = com.tencent.mm.ui.applet.SecurityImage.a.a(this.nDR.nEl, 0, this.cxX, this.ogQ, this.ogR, new OnClickListener(this) {
                            final /* synthetic */ VerifyQQUI ogS;

                            {
                                this.ogS = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                final k aVar = new com.tencent.mm.w.a(this.ogS.ogP, this.ogS.kQj, this.ogS.nFq.nJJ, this.ogS.nFq.bBA(), this.ogS.nFq.nJK, this.ogS.bgb, this.ogS.bgd, true);
                                ak.vy().a(aVar, 0);
                                VerifyQQUI verifyQQUI = this.ogS;
                                Context context = this.ogS.nDR.nEl;
                                this.ogS.getString(2131231480);
                                verifyQQUI.dwg = g.a(context, this.ogS.getString(2131231471), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass4 ogX;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ak.vy().c(aVar);
                                    }
                                });
                            }
                        }, null, new OnDismissListener(this) {
                            final /* synthetic */ VerifyQQUI ogS;

                            {
                                this.ogS = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                this.ogS.nFq = null;
                            }
                        }, new a(this));
                    } else {
                        v.d("MicroMsg.VerifyQQUI", "imgSid:" + this.ogQ + " img len" + this.cxX.length + " " + com.tencent.mm.compatible.util.g.sm());
                        this.nFq.a(0, this.cxX, this.ogQ, this.ogR);
                    }
                    obj = 1;
                    break;
                case -72:
                    g.f(this.nDR.nEl, 2131231475, 2131231164);
                    obj = 1;
                    break;
                case -34:
                    g.f(this.nDR.nEl, 2131231474, 2131231164);
                    obj = 1;
                    break;
                case -12:
                    g.f(this.nDR.nEl, 2131231472, 2131231476);
                    obj = 1;
                    break;
                case -5:
                    g.f(this.nDR.nEl, 2131231473, 2131231164);
                    obj = 1;
                    break;
                case -4:
                case -3:
                    dm = com.tencent.mm.f.a.dm(str);
                    if (dm == null) {
                        g.f(this.nDR.nEl, 2131231481, 2131231476);
                        obj = 1;
                        break;
                    }
                    dm.a(this, null, null);
                    obj = 1;
                    break;
                default:
                    dm = com.tencent.mm.f.a.dm(str);
                    if (dm != null) {
                        dm.a(this, null, null);
                        obj = 1;
                        break;
                    }
                    break;
            }
        }
        obj = null;
        if (obj == null) {
            Toast.makeText(this, getString(2131232858, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
