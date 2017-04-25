package com.tencent.mm.plugin.search.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.aa;
import com.tencent.mm.e.a.jz;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.modelsearch.l;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import java.util.Map;

public class FTSAddFriendUI extends FTSBaseUI {
    private ars fGQ;
    private String fPD = "";
    private Dialog gqy;
    private View iGO;
    private View iGP;
    private View iGQ;
    private View iGR;
    private View iGS;
    private View iGT;
    private ImageView iGU;
    private TextView iGV;
    private TextView iGW;
    private TextView iGX;
    private TextView iGY;
    private boolean iGZ;
    protected boolean iHa;
    private int iHb = 1;
    private a iHc;
    private int iHd;
    private int iHe;
    int iHf = -1;
    private long iHg;

    static /* synthetic */ void a(FTSAddFriendUI fTSAddFriendUI) {
        String str = fTSAddFriendUI.bkC;
        if (str != null && !be.kS(str.trim()) && System.currentTimeMillis() - fTSAddFriendUI.iHg > 1000) {
            fTSAddFriendUI.iHg = System.currentTimeMillis();
            if (h.Ih()) {
                if (!be.kS(fTSAddFriendUI.bkC)) {
                    fTSAddFriendUI.iHa = true;
                    l.c(fTSAddFriendUI.bkC, 2, 2, 16);
                }
                Intent Ij = h.Ij();
                Ij.putExtra("ftsbizscene", 16);
                Ij.putExtra("ftsQuery", fTSAddFriendUI.bkC);
                Map a = h.a(16, true, 0);
                a.put("query", fTSAddFriendUI.bkC);
                Ij.putExtra("rawUrl", h.l(a));
                c.b(fTSAddFriendUI.nDR.nEl, "webview", ".ui.tools.fts.FTSWebViewUI", Ij);
                l.fZ(16);
                jz jzVar = new jz();
                jzVar.bkG.bkC = fTSAddFriendUI.bkC;
                jzVar.bkG.scene = 16;
                jzVar.bkG.bkI = 1;
                jzVar.bkG.bkH = true;
                jzVar.bkG.bkK = false;
                jzVar.bkG.bkJ = "";
                a.nhr.z(jzVar);
                return;
            }
            v.e("MicroMsg.FTS.FTSAddFriendUI", "fts h5 template not avail");
        }
    }

    static /* synthetic */ void f(FTSAddFriendUI fTSAddFriendUI) {
        final aa aaVar = new aa();
        aaVar.aXn.context = fTSAddFriendUI;
        aaVar.aXn.fromScene = 16;
        aaVar.aXn.aXp = fTSAddFriendUI.bkC;
        aaVar.aXn.aXr = false;
        aaVar.aXn.title = fTSAddFriendUI.getString(2131232216);
        aaVar.aXn.aXq = 1;
        Runnable anonymousClass5 = new Runnable(fTSAddFriendUI) {
            final /* synthetic */ FTSAddFriendUI iHh;

            public final void run() {
                this.iHh.aMq();
                if (aaVar.aXo.aWL) {
                    this.iHh.iHe = 1;
                } else {
                    this.iHh.iHe = -1;
                }
                FTSAddFriendUI.g(this.iHh);
            }
        };
        aaVar.aXn.aXs = anonymousClass5;
        aaVar.aXn.action = 1;
        if (!a.nhr.z(aaVar)) {
            aaVar.aXo.aWL = false;
            anonymousClass5.run();
        }
    }

    static /* synthetic */ void g(FTSAddFriendUI fTSAddFriendUI) {
        if (fTSAddFriendUI.iHd != 0 && fTSAddFriendUI.iHe != 0) {
            fTSAddFriendUI.aMq();
            if (fTSAddFriendUI.iHd <= 0 || fTSAddFriendUI.iHe >= 0) {
                if (fTSAddFriendUI.iHd > 0) {
                    ars com_tencent_mm_protocal_c_ars = fTSAddFriendUI.fGQ;
                    String a = m.a(com_tencent_mm_protocal_c_ars.moM);
                    CharSequence a2 = m.a(com_tencent_mm_protocal_c_ars.mEj);
                    CharSequence charSequence = com_tencent_mm_protocal_c_ars.cHf;
                    fTSAddFriendUI.iHp.setVisibility(8);
                    fTSAddFriendUI.iGO.setVisibility(0);
                    fTSAddFriendUI.iGP.setVisibility(0);
                    fTSAddFriendUI.iGT.setOnClickListener(new OnClickListener(fTSAddFriendUI) {
                        final /* synthetic */ FTSAddFriendUI iHh;

                        {
                            this.iHh = r1;
                        }

                        public final void onClick(View view) {
                            if (!be.kS(this.iHh.bkC)) {
                                this.iHh.iHa = true;
                                l.c(this.iHh.bkC, this.iHh.iHb, 1, 16);
                            }
                            this.iHh.aMp();
                        }
                    });
                    fTSAddFriendUI.iGV.setText(a2);
                    fTSAddFriendUI.iGW.setText(charSequence);
                    b.m(fTSAddFriendUI.iGU, a);
                    fTSAddFriendUI.iGQ.setVisibility(8);
                    fTSAddFriendUI.iGR.setVisibility(8);
                    fTSAddFriendUI.iGS.setVisibility(8);
                } else {
                    fTSAddFriendUI.iHp.setVisibility(8);
                    fTSAddFriendUI.iGO.setVisibility(0);
                    fTSAddFriendUI.iGP.setVisibility(8);
                    fTSAddFriendUI.iGQ.setVisibility(0);
                    fTSAddFriendUI.iGR.setVisibility(8);
                    fTSAddFriendUI.iGS.setVisibility(8);
                }
                if (fTSAddFriendUI.iHe > 0) {
                    fTSAddFriendUI.iGR.setVisibility(0);
                    fTSAddFriendUI.iGS.setVisibility(0);
                    fTSAddFriendUI.iGX.setText(h.m(fTSAddFriendUI.getString(2131233006), "", fTSAddFriendUI.bkC));
                    fTSAddFriendUI.iHb = 2;
                    fTSAddFriendUI.iGS.setOnClickListener(new OnClickListener(fTSAddFriendUI) {
                        final /* synthetic */ FTSAddFriendUI iHh;

                        {
                            this.iHh = r1;
                        }

                        public final void onClick(View view) {
                            FTSAddFriendUI.a(this.iHh);
                        }
                    });
                    return;
                }
                fTSAddFriendUI.iGR.setVisibility(8);
                fTSAddFriendUI.iGS.setVisibility(8);
                return;
            }
            fTSAddFriendUI.iHa = true;
            fTSAddFriendUI.aMp();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iGO = findViewById(2131757142);
        this.iGP = findViewById(2131757143);
        this.iGT = findViewById(2131757144);
        this.iGQ = findViewById(2131757148);
        this.iGR = findViewById(2131757150);
        this.iGS = findViewById(2131757151);
        this.iGU = (ImageView) findViewById(2131757145);
        this.iGV = (TextView) findViewById(2131757146);
        this.iGW = (TextView) findViewById(2131757147);
        this.iGX = (TextView) findViewById(2131757152);
        this.iGY = (TextView) findViewById(2131757149);
    }

    protected final boolean aMn() {
        return false;
    }

    protected final b a(c cVar) {
        if (this.iHc == null) {
            this.iHc = new a(cVar);
        }
        return this.iHc;
    }

    public final void b(com.tencent.mm.ui.f.a.a aVar) {
        if (aVar instanceof com.tencent.mm.plugin.search.ui.a.a) {
            this.fPD = aVar.bkC;
            zi(aVar.bkC);
        }
    }

    public final void ml(String str) {
        super.ml(str);
        this.iGZ = false;
    }

    public final boolean mk(String str) {
        this.fPD = str;
        zi(str);
        axg();
        return true;
    }

    protected final int getLayoutId() {
        return 2130903675;
    }

    protected final void aMo() {
        super.aMo();
        this.iGO.setVisibility(8);
    }

    protected final void stopSearch() {
        super.stopSearch();
        this.iGO.setVisibility(8);
    }

    private void aMp() {
        if (be.ma(m.a(this.fGQ.moM)).length() > 0) {
            if (2 == this.fGQ.mQK) {
                this.iHf = 15;
            } else if (1 == this.fGQ.mQK) {
                this.iHf = 1;
            }
            Intent intent = new Intent();
            com.tencent.mm.pluginsdk.ui.tools.c.a(intent, this.fGQ, this.iHf);
            if (this.iHf == 15 && 2 == this.fGQ.mQK) {
                intent.putExtra("Contact_Search_Mobile", this.fPD.trim());
            }
            intent.putExtra("add_more_friend_search_scene", 2);
            com.tencent.mm.plugin.search.a.drp.d(intent, this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.iGZ && !this.iHa) {
            l.c(this.bkC, this.iHb, 3, 16);
        }
    }

    private void zi(String str) {
        this.iGZ = true;
        this.iHa = false;
        this.iHb = 1;
        if (str != null && str.length() != 0 && str.trim().length() != 0) {
            this.iHf = Character.isDigit(str.charAt(0)) ? 15 : 3;
            final AnonymousClass3 anonymousClass3 = new e(this) {
                final /* synthetic */ FTSAddFriendUI iHh;

                {
                    this.iHh = r1;
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void a(int r6, int r7, java.lang.String r8, com.tencent.mm.v.k r9) {
                    /*
                    r5 = this;
                    r2 = 2131234058; // 0x7f080d0a float:1.808427E38 double:1.0529695313E-314;
                    r3 = 0;
                    r4 = 1;
                    r0 = com.tencent.mm.model.ak.vy();
                    r1 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
                    r0.b(r1, r5);
                    if (r6 != 0) goto L_0x0012;
                L_0x0010:
                    if (r7 == 0) goto L_0x0061;
                L_0x0012:
                    switch(r7) {
                        case -24: goto L_0x0045;
                        case -4: goto L_0x002f;
                        default: goto L_0x0015;
                    };
                L_0x0015:
                    r0 = r5.iHh;
                    r0 = r0.iGY;
                    r0.setText(r2);
                L_0x001e:
                    r0 = r5.iHh;
                    r1 = -1;
                    r0.iHd = r1;
                    r0 = r5.iHh;
                    r0.iHe = r4;
                L_0x0029:
                    r0 = r5.iHh;
                    com.tencent.mm.plugin.search.ui.FTSAddFriendUI.g(r0);
                L_0x002e:
                    return;
                L_0x002f:
                    r0 = 4;
                    if (r6 == r0) goto L_0x0015;
                L_0x0032:
                    r0 = r5.iHh;
                    r0 = r0.iGY;
                    r1 = r5.iHh;
                    r2 = 2131232921; // 0x7f080899 float:1.8081965E38 double:1.0529689696E-314;
                    r1 = r1.getString(r2);
                    r0.setText(r1);
                    goto L_0x001e;
                L_0x0045:
                    r0 = com.tencent.mm.f.a.dm(r8);
                    if (r0 == 0) goto L_0x0057;
                L_0x004b:
                    r1 = r5.iHh;
                    r1 = r1.iGY;
                    r0 = r0.desc;
                    r1.setText(r0);
                    goto L_0x001e;
                L_0x0057:
                    r0 = r5.iHh;
                    r0 = r0.iGY;
                    r0.setText(r2);
                    goto L_0x001e;
                L_0x0061:
                    r0 = r5.iHh;
                    r9 = (com.tencent.mm.modelsimple.y) r9;
                    r1 = r9.Jx();
                    r0.fGQ = r1;
                    r0 = r5.iHh;
                    r0 = r0.fGQ;
                    r0 = r0.mxP;
                    if (r0 <= 0) goto L_0x00c3;
                L_0x0076:
                    r0 = r5.iHh;
                    r0 = r0.fGQ;
                    r0 = r0.mxQ;
                    r0 = r0.isEmpty();
                    if (r0 == 0) goto L_0x008e;
                L_0x0084:
                    r0 = r5.iHh;
                    r1 = 2131230867; // 0x7f080093 float:1.8077799E38 double:1.0529679547E-314;
                    r2 = 0;
                    com.tencent.mm.ui.base.g.a(r0, r1, r3, r4, r2);
                    goto L_0x002e;
                L_0x008e:
                    r1 = new android.content.Intent;
                    r1.<init>();
                    r0 = "add_more_friend_search_scene";
                    r2 = 3;
                    r1.putExtra(r0, r2);
                    r0 = r5.iHh;
                    r0 = r0.fGQ;
                    r0 = r0.mxQ;
                    r0 = r0.size();
                    if (r0 <= r4) goto L_0x00dc;
                L_0x00a8:
                    r0 = "result";
                    r2 = r5.iHh;	 Catch:{ IOException -> 0x00cf }
                    r2 = r2.fGQ;	 Catch:{ IOException -> 0x00cf }
                    r2 = r2.toByteArray();	 Catch:{ IOException -> 0x00cf }
                    r1.putExtra(r0, r2);	 Catch:{ IOException -> 0x00cf }
                    r0 = com.tencent.mm.plugin.search.a.drp;	 Catch:{ IOException -> 0x00cf }
                    r2 = r5.iHh;	 Catch:{ IOException -> 0x00cf }
                    r2 = r2.nDR;	 Catch:{ IOException -> 0x00cf }
                    r2 = r2.nEl;	 Catch:{ IOException -> 0x00cf }
                    r0.x(r1, r2);	 Catch:{ IOException -> 0x00cf }
                L_0x00c3:
                    r0 = r5.iHh;
                    r0.iHd = r4;
                    r0 = r5.iHh;
                    com.tencent.mm.plugin.search.ui.FTSAddFriendUI.f(r0);
                    goto L_0x0029;
                L_0x00cf:
                    r0 = move-exception;
                    r1 = "MicroMsg.FTS.FTSAddFriendUI";
                    r2 = "";
                    r3 = new java.lang.Object[r3];
                    com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
                    goto L_0x00c3;
                L_0x00dc:
                    r0 = r5.iHh;
                    r0 = r0.fGQ;
                    r0 = r0.mxQ;
                    r0 = r0.getFirst();
                    r0 = (com.tencent.mm.protocal.c.arq) r0;
                    r2 = r5.iHh;
                    r2 = r2.iHf;
                    com.tencent.mm.pluginsdk.ui.tools.c.a(r1, r0, r2);
                    goto L_0x00c3;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.FTSAddFriendUI.3.a(int, int, java.lang.String, com.tencent.mm.v.k):void");
                }
            };
            this.iHd = 0;
            this.iHe = 0;
            ak.vy().a(106, anonymousClass3);
            final y yVar = new y(str, 3);
            ak.vy().a(yVar, 0);
            getString(2131231164);
            this.gqy = g.a(this, getString(2131230873), true, new OnCancelListener(this) {
                final /* synthetic */ FTSAddFriendUI iHh;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(yVar);
                    ak.vy().b(106, anonymousClass3);
                    this.iHh.gqy = null;
                }
            });
        }
    }

    private void aMq() {
        ad.o(new Runnable(this) {
            final /* synthetic */ FTSAddFriendUI iHh;

            {
                this.iHh = r1;
            }

            public final void run() {
                if (this.iHh.gqy != null) {
                    this.iHh.gqy.dismiss();
                    this.iHh.gqy = null;
                }
            }
        });
    }

    public void onClickBg(View view) {
    }
}
