package com.tencent.mm.plugin.search.ui;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.al.j;
import com.tencent.mm.al.t;
import com.tencent.mm.e.a.fq;
import com.tencent.mm.e.a.jz;
import com.tencent.mm.e.a.pw;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.modelsearch.h.b;
import com.tencent.mm.modelsearch.l;
import com.tencent.mm.modelsearch.s;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.search.a.i;
import com.tencent.mm.pluginsdk.ui.tools.c;
import com.tencent.mm.protocal.c.ahm;
import com.tencent.mm.protocal.c.arq;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.d.d;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

public class FTSMainUI extends FTSBaseUI implements a, e {
    private Dialog gqy;
    private int iHJ;
    private View iHK;
    private LinearLayout iHL;
    private b iHM = new b();
    int iHf = -1;
    private long iHg;
    private View iHz;
    private View iIc;
    private TextView iId;
    private LinearLayout iIe;
    private View iIf;
    private View iIg;
    private TextView iIh;
    private View iIi;
    private View iIj;
    private TextView iIk;
    private f iIl;

    static /* synthetic */ void a(FTSMainUI fTSMainUI, final String str) {
        if (str != null && str.length() != 0 && str.trim().length() != 0) {
            fTSMainUI.iHf = Character.isDigit(str.charAt(0)) ? 15 : 3;
            final AnonymousClass4 anonymousClass4 = new e(fTSMainUI) {
                final /* synthetic */ FTSMainUI iIm;

                public final void a(int i, int i2, String str, k kVar) {
                    ak.vy().b(106, this);
                    if (i == 4 && i2 == -4) {
                        ad.o(new Runnable(this.iIm) {
                            final /* synthetic */ FTSMainUI iIm;

                            {
                                this.iIm = r1;
                            }

                            public final void run() {
                                if (this.iIm.gqy != null) {
                                    this.iIm.gqy.dismiss();
                                    this.iIm.gqy = null;
                                }
                            }
                        });
                        g.a(this.iIm, 2131230867, 0, true, null);
                        return;
                    }
                    ad.o(/* anonymous class already generated */);
                    if (i == 0 && i2 == 0) {
                        ars Jx = ((y) kVar).Jx();
                        Intent intent;
                        if (Jx.mxP > 0) {
                            if (Jx.mxQ.isEmpty()) {
                                g.a(this.iIm, 2131230867, 0, true, null);
                                return;
                            }
                            intent = new Intent();
                            c.a(intent, (arq) Jx.mxQ.getFirst(), this.iIm.iHf);
                            com.tencent.mm.plugin.search.a.drp.d(intent, this.iIm);
                            return;
                        } else if (be.ma(m.a(Jx.moM)).length() > 0) {
                            if (2 == Jx.mQK) {
                                this.iIm.iHf = 15;
                            } else if (1 == Jx.mQK) {
                                this.iIm.iHf = 1;
                            }
                            intent = new Intent();
                            c.a(intent, Jx, this.iIm.iHf);
                            if (this.iIm.iHf == 15) {
                                intent.putExtra("Contact_Search_Mobile", str.trim());
                            }
                            intent.putExtra("add_more_friend_search_scene", 2);
                            com.tencent.mm.plugin.search.a.drp.d(intent, this.iIm);
                            return;
                        } else {
                            return;
                        }
                    }
                    switch (i2) {
                        case -24:
                            com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
                            if (dm != null) {
                                g.a(this.iIm, dm.desc, dm.aXz, true, null);
                                break;
                            }
                            break;
                        case -4:
                            Toast.makeText(this.iIm, this.iIm.getString(2131232921), 0).show();
                            break;
                    }
                    v.w("MicroMsg.FTS.FTSMainUI", String.format("Search contact failed: %d, %d.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                }
            };
            ak.vy().a(106, anonymousClass4);
            final y yVar = new y(str, 3);
            ak.vy().a(yVar, 0);
            fTSMainUI.getString(2131231164);
            fTSMainUI.gqy = g.a(fTSMainUI, fTSMainUI.getString(2131230873), true, new OnCancelListener(fTSMainUI) {
                final /* synthetic */ FTSMainUI iIm;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(yVar);
                    ak.vy().b(106, anonymousClass4);
                    this.iIm.gqy = null;
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        long vc;
        super.onCreate(bundle);
        this.iHz = findViewById(2131757183);
        this.iIe = (LinearLayout) findViewById(2131757156);
        this.iIc = findViewById(2131757184);
        this.iId = (TextView) this.iIc.findViewById(2131757185);
        if (t.HS().aK(0, 18) != null) {
            if (new File(t.HS().aN(0, 18)).exists()) {
                v.i("MicroMsg.FTS.SubCoreSearch", "Exist Uzip Folder path=%s", new Object[]{t.HS().aN(0, 18)});
            } else {
                v.i("MicroMsg.FTS.SubCoreSearch", "Not Exist Uzip Folder， path=%s", new Object[]{t.HS().aN(0, 18)});
                ak.vy().a(new j(0, 18), 0);
                com.tencent.mm.modelgeo.c.FY().b(this);
                if (com.tencent.mm.ui.f.e.bIM() != null) {
                    finish();
                }
                com.tencent.mm.ui.f.e.bIM().aMI();
                com.tencent.mm.pluginsdk.j.ak.lyj.a(6, "", this.iHM);
                ak.yW();
                long vc2 = com.tencent.mm.model.c.vf().vc(87);
                ak.yW();
                vc = com.tencent.mm.model.c.vf().vc(84);
                ak.yW();
                v.i("MicroMsg.FTS.FTSMainUI", "SnsHotWordUpdateTime: %d %d %d", new Object[]{Long.valueOf(vc), Integer.valueOf(com.tencent.mm.model.c.vf().getInt(85, 0)), Long.valueOf(vc2)});
                if ((System.currentTimeMillis() - vc) / 1000 > ((long) com.tencent.mm.model.c.vf().getInt(85, 0)) && System.currentTimeMillis() - vc2 > 3600000) {
                    v.i("MicroMsg.FTS.FTSMainUI", "start to do NetSceneBizSearchGuide");
                    s sVar = new s(15, 0, h.cVT, 0);
                    ak.vy().a(1048, this);
                    ak.vy().a(sVar, 0);
                    return;
                }
                return;
            }
        }
        if (System.currentTimeMillis() - i.aMj().iGv > 7200000) {
            i.aMj().iGv = System.currentTimeMillis();
            ak.vy().a(new com.tencent.mm.al.k(18), 0);
        }
        com.tencent.mm.modelgeo.c.FY().b(this);
        if (com.tencent.mm.ui.f.e.bIM() != null) {
            com.tencent.mm.ui.f.e.bIM().aMI();
            com.tencent.mm.pluginsdk.j.ak.lyj.a(6, "", this.iHM);
            ak.yW();
            long vc22 = com.tencent.mm.model.c.vf().vc(87);
            ak.yW();
            vc = com.tencent.mm.model.c.vf().vc(84);
            ak.yW();
            v.i("MicroMsg.FTS.FTSMainUI", "SnsHotWordUpdateTime: %d %d %d", new Object[]{Long.valueOf(vc), Integer.valueOf(com.tencent.mm.model.c.vf().getInt(85, 0)), Long.valueOf(vc22)});
            if ((System.currentTimeMillis() - vc) / 1000 > ((long) com.tencent.mm.model.c.vf().getInt(85, 0))) {
                return;
            }
            return;
        }
        finish();
    }

    protected final void aMr() {
        switch (getIntent().getIntExtra("from_tab_index", -1)) {
            case 0:
                this.iHJ = 1;
                return;
            case 1:
                this.iHJ = 2;
                return;
            case 2:
                this.iHJ = 3;
                return;
            case 3:
                this.iHJ = 4;
                return;
            default:
                this.iHJ = 0;
                return;
        }
    }

    protected final boolean aMn() {
        return u.bsV();
    }

    protected final b a(c cVar) {
        this.iIl = new f(cVar, this.iHJ);
        return this.iIl;
    }

    protected final int getLayoutId() {
        return 2130903686;
    }

    public final void b(com.tencent.mm.ui.f.a.a aVar) {
    }

    protected void onDestroy() {
        ad.o(new Runnable(this) {
            final /* synthetic */ FTSMainUI iIm;

            {
                this.iIm = r1;
            }

            public final void run() {
                fq fqVar = new fq();
                fqVar.beY.context = aa.getContext();
                fqVar.beY.actionCode = 3;
                com.tencent.mm.sdk.c.a.nhr.z(fqVar);
            }
        });
        com.tencent.mm.modelgeo.c.FY().c(this);
        if (com.tencent.mm.ui.f.e.bIM() != null) {
            com.tencent.mm.ui.f.e.bIM().aMJ();
        }
        com.tencent.mm.pluginsdk.j.ak.lyj.a(this.iHM, 6);
        ak.vy().b(1048, this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        pw pwVar = new pw();
        pwVar.brg.brh = 0;
        com.tencent.mm.sdk.c.a.nhr.z(pwVar);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        sendBroadcast(intent);
        if (this.iIf != null) {
            this.iIf.setEnabled(true);
        }
    }

    public void finish() {
        axg();
        super.finish();
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
        v.i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", new Object[]{Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2)});
        com.tencent.mm.modelgeo.c.FY().c(this);
        return false;
    }

    private void aMB() {
        this.iHz.setVisibility(0);
        aME();
    }

    private void aMC() {
        this.iHz.setVisibility(8);
        this.iIc.setVisibility(8);
    }

    protected final void aMs() {
        super.aMs();
        aMC();
        this.iIe.setVisibility(8);
    }

    protected final void aMt() {
        super.aMt();
        aMB();
        this.iIe.setVisibility(8);
    }

    protected final void aMx() {
        super.aMx();
        aMB();
        this.iIe.setVisibility(8);
    }

    protected final void aMw() {
        super.aMw();
        aMC();
        this.iIe.setVisibility(8);
    }

    protected final void aMv() {
        super.aMv();
        aMC();
        this.iIe.setVisibility(8);
        this.iHp.setVisibility(0);
        this.gxS.setVisibility(8);
    }

    protected final void aMu() {
        super.aMu();
        aMC();
        this.iIe.setVisibility(8);
    }

    public final View abc() {
        if (this.iHK == null) {
            this.iHK = getLayoutInflater().inflate(2130903684, null);
            this.iIh = (TextView) this.iHK.findViewById(2131757180);
            this.iIg = this.iHK.findViewById(2131757178);
            this.iIf = this.iHK.findViewById(2131757179);
            this.iIf.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FTSMainUI iIm;

                {
                    this.iIm = r1;
                }

                public final void onClick(View view) {
                    this.iIm.aMD();
                }
            });
            this.iIk = (TextView) this.iHK.findViewById(2131757177);
            this.iIj = this.iHK.findViewById(2131757175);
            this.iIi = this.iHK.findViewById(2131757176);
            this.iIi.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FTSMainUI iIm;

                {
                    this.iIm = r1;
                }

                public final void onClick(View view) {
                    FTSMainUI.a(this.iIm, this.iIm.bkC);
                }
            });
            this.iHL = (LinearLayout) this.iHK.findViewById(2131757181);
        }
        return this.iHK;
    }

    private void aMD() {
        String str = this.bkC;
        if (str != null && !be.kS(str.trim()) && System.currentTimeMillis() - this.iHg > 1000) {
            this.iHg = System.currentTimeMillis();
            if (h.Ih()) {
                Intent Ij = h.Ij();
                Ij.putExtra("ftsbizscene", 3);
                Ij.putExtra("ftsQuery", this.bkC);
                Map a = h.a(3, true, 0);
                a.put("query", this.bkC);
                Ij.putExtra("rawUrl", h.l(a));
                com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.fts.FTSWebViewUI", Ij);
                l.fZ(3);
                if (!be.kS(this.bkC)) {
                    this.iIl.iGM = true;
                    l.c(this.bkC, 2, 2, 3);
                }
                jz jzVar = new jz();
                jzVar.bkG.bkC = this.bkC;
                jzVar.bkG.scene = 3;
                jzVar.bkG.bkI = 1;
                jzVar.bkG.bkH = true;
                jzVar.bkG.bkK = false;
                jzVar.bkG.bkJ = "";
                com.tencent.mm.sdk.c.a.nhr.z(jzVar);
                this.iIf.setEnabled(false);
                return;
            }
            v.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
        }
    }

    public final boolean mk(String str) {
        if (this.iIl.getCount() == 0) {
            aMD();
        }
        return super.mk(str);
    }

    protected final void aMy() {
        if (this.iHL != null) {
            this.iHL.setVisibility(0);
        }
    }

    protected final void aMz() {
        if (this.iHL != null) {
            this.iHL.setVisibility(8);
        }
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
        super.a(z, strArr, j, i);
        if (z) {
            com.tencent.mm.ay.c.a(this, ".ui.voicesearch.VoiceSearchResultUI", new Intent().putExtra("VoiceSearchResultUI_Resultlist", strArr).putExtra("VoiceSearchResultUI_VoiceId", j).putExtra("VoiceSearchResultUI_ShowType", i));
            return;
        }
        com.tencent.mm.ay.c.a(this, ".ui.voicesearch.VoiceSearchResultUI", new Intent().putExtra("VoiceSearchResultUI_Resultlist", new String[0]).putExtra("VoiceSearchResultUI_Error", this.nDR.nEl.getString(2131232875)).putExtra("VoiceSearchResultUI_VoiceId", j).putExtra("VoiceSearchResultUI_ShowType", i));
    }

    public final void E(int i, boolean z) {
        super.E(i, z);
        if (!z && i == 0 && this.iIl.iHZ) {
            this.iIe.setVisibility(0);
        } else {
            this.iIe.setVisibility(8);
        }
        if (z) {
            boolean jD = h.jD(this.bkC);
            boolean jE = h.jE(this.bkC);
            if (i > 0) {
                if (jD || jE) {
                    this.iIj.setVisibility(0);
                }
                this.iIg.setVisibility(0);
            } else {
                this.iIj.setVisibility(8);
                if (jD || jE) {
                    this.iIg.setVisibility(0);
                } else {
                    this.iIg.setVisibility(8);
                }
            }
            if (jD || jE) {
                this.iIi.setVisibility(0);
            }
            this.iIf.setVisibility(0);
            return;
        }
        this.iIf.setVisibility(8);
        this.iIi.setVisibility(8);
    }

    protected final void aMo() {
        super.aMo();
        this.iIh.setText(h.m(getString(2131233006), "", this.bkC));
        if (h.jD(this.bkC)) {
            this.iIk.setText(h.m(getString(2131233001), "", this.bkC));
        } else if (h.jE(this.bkC)) {
            this.iIk.setText(h.m(getString(2131233002), "", this.bkC));
        }
    }

    public void onSearchTimeLineDetail(View view) {
        ph(8);
    }

    public void onSearchArticleDetail(View view) {
        ph(2);
    }

    public void onSearchBizContactDetail(View view) {
        ph(1);
    }

    private void ph(int i) {
        if (System.currentTimeMillis() - this.iHg > 1000) {
            this.iHg = System.currentTimeMillis();
            if (h.Ih()) {
                l.ga(i);
                axg();
                Intent Ij = h.Ij();
                Ij.putExtra("ftsneedkeyboard", true);
                Ij.putExtra("ftsbizscene", 14);
                Ij.putExtra("ftsType", i);
                Ij.putExtra("rawUrl", h.l(h.a(14, true, i)));
                Ij.putExtra("key_load_js_without_delay", true);
                com.tencent.mm.ay.c.b(aa.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", Ij);
                return;
            }
            v.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
        }
    }

    public void onClickSnsHotArticle(View view) {
        if (System.currentTimeMillis() - this.iHg > 1000) {
            this.iHg = System.currentTimeMillis();
            if (h.Ih()) {
                ak.yW();
                String str = (String) com.tencent.mm.model.c.vf().get(86, "");
                Intent Ij = h.Ij();
                Ij.putExtra("ftsbizscene", 15);
                Ij.putExtra("ftsQuery", str);
                Ij.putExtra("title", str);
                Ij.putExtra("isWebwx", str);
                Ij.putExtra("ftscaneditable", false);
                Map a = h.a(15, false, 2);
                a.put("query", str);
                a.put("sceneActionType", "2");
                Ij.putExtra("rawUrl", h.l(a));
                com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.fts.FTSWebViewUI", Ij);
                l.mK(str);
                return;
            }
            v.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof s) {
            ak.vy().b(1048, this);
            if (i == 0 && i2 == 0) {
                ahm com_tencent_mm_protocal_c_ahm = ((s) kVar).cWR;
                v.i("MicroMsg.FTS.FTSMainUI", "onSceneEnd: %s", new Object[]{com_tencent_mm_protocal_c_ahm.min});
                try {
                    String optString = new JSONObject(com_tencent_mm_protocal_c_ahm.min).optJSONArray("data").optJSONObject(0).optJSONArray("items").optJSONObject(0).optString("hotword");
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(86, optString);
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(84, Long.valueOf(System.currentTimeMillis()));
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(85, Integer.valueOf(com_tencent_mm_protocal_c_ahm.mHb));
                } catch (Throwable e) {
                    v.a("MicroMsg.FTS.FTSMainUI", e, "error parse NetSceneBizSearchGuide.response.json %s", new Object[]{com_tencent_mm_protocal_c_ahm.min});
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(87, Long.valueOf(System.currentTimeMillis()));
                }
                aME();
            }
        }
    }

    private void aME() {
        ak.yW();
        long vc = com.tencent.mm.model.c.vf().vc(84);
        ak.yW();
        int i = com.tencent.mm.model.c.vf().getInt(85, 0);
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(86, "");
        v.i("MicroMsg.FTS.FTSMainUI", "updateSnsHotWordView %s %d %d", new Object[]{str, Long.valueOf(vc), Integer.valueOf(i)});
        if (be.kS(str) || (System.currentTimeMillis() - vc) / 1000 > ((long) i)) {
            this.iIc.setVisibility(8);
            return;
        }
        this.iIc.setVisibility(0);
        this.iId.setVisibility(0);
        this.iId.setText(str);
        l.a(15, 0, "", 2, 4, str);
    }
}
