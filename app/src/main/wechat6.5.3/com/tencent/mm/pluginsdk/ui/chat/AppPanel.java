package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.j.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.s;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppPanel extends LinearLayout {
    private static int iCg = 215;
    private static int iCh = 158;
    private static boolean lLD = false;
    private boolean bnE = true;
    private SharedPreferences cnm;
    Context context;
    private boolean iCr = false;
    private int iCs;
    private int iCt;
    public MMFlipper iCu;
    private MMDotView iCv;
    private boolean isInit = false;
    private int lKZ = 16;
    private Map<String, f> lLA = null;
    private final int lLB = 2;
    private com.tencent.mm.pluginsdk.ui.chat.AppGrid.b lLC = new com.tencent.mm.pluginsdk.ui.chat.AppGrid.b(this) {
        final /* synthetic */ AppPanel lLG;

        {
            this.lLG = r1;
        }

        public final int ub(int i) {
            int i2 = 0;
            if (i < this.lLG.lKZ) {
                int length = this.lLG.lLk.length;
                int i3 = 0;
                while (i2 < length) {
                    if (this.lLG.lLk[i2]) {
                        if (i3 == i) {
                            return i2;
                        }
                        i3++;
                    }
                    i2++;
                }
            } else if (i >= this.lLG.lKZ && i < this.lLG.lLo) {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }

        public final void uc(int i) {
            if (i != 0) {
                return;
            }
            if (this.lLG.lLp.lLK.value) {
                AppPanel.a(this.lLG, true);
            } else {
                Toast.makeText(this.lLG.context, this.lLG.context.getString(2131231848), 0).show();
            }
        }

        public final void a(int i, f fVar) {
            String str = "MicroMsg.AppPanel";
            String str2 = "pos=%d, has appInfo = %b";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Boolean.valueOf(fVar != null);
            v.d(str, str2, objArr);
            if (fVar != null && g.k(fVar)) {
                Map hashMap = new HashMap();
                k.b(327682, hashMap);
                hashMap.put(fVar.field_appId, "1");
                k.a(327682, hashMap);
            }
            com.tencent.mm.sdk.c.b pdVar;
            String str3;
            f fVar2;
            switch (i) {
                case Integer.MIN_VALUE:
                    break;
                case 0:
                    if (this.lLG.lLp.lLK.value) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(1));
                        AppPanel.a(this.lLG, false);
                        return;
                    }
                    Toast.makeText(this.lLG.context, this.lLG.context.getString(2131231848), 0).show();
                    return;
                case 1:
                    if (this.lLG.lLp.lMa.value) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(14));
                        this.lLG.lLl.azz();
                        return;
                    }
                    Toast.makeText(this.lLG.context, this.lLG.context.getString(2131231848), 0).show();
                    return;
                case 2:
                    if (this.lLG.lLp.lLN.value) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(8));
                        ak.yW();
                        c.vf().set(54, Boolean.valueOf(false));
                        if (this.lLG.lLl != null) {
                            pdVar = new pd();
                            pdVar.bqt.bqv = true;
                            com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                            str3 = pdVar.bqu.bqx;
                            if (be.kS(str3)) {
                                this.lLG.lLl.azq();
                                return;
                            }
                            v.v("MicroMsg.AppPanel", "Talkroom is on: " + str3);
                            com.tencent.mm.ui.base.g.b(this.lLG.context, this.lLG.context.getString(2131235616), SQLiteDatabase.KeyEmpty, this.lLG.context.getString(2131231107), this.lLG.context.getString(2131231010), new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass3 lLH;

                                {
                                    this.lLH = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    com.tencent.mm.sdk.c.b pdVar = new pd();
                                    pdVar.bqt.bqw = true;
                                    com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                                    this.lLH.lLG.lLl.azq();
                                    dialogInterface.dismiss();
                                }
                            }, new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass3 lLH;

                                {
                                    this.lLH = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    Toast.makeText(this.lLG.context, this.lLG.context.getString(2131231848), 0).show();
                    return;
                case 3:
                    if (this.lLG.lLl != null) {
                        this.lLG.lLl.azB();
                        return;
                    }
                    return;
                case 4:
                    if (this.lLG.lLp.lLT.value) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(7));
                        ak.yW();
                        c.vf().set(62, Boolean.valueOf(false));
                        pdVar = new pd();
                        pdVar.bqt.bqv = true;
                        com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                        str3 = pdVar.bqu.bqx;
                        if (be.kS(str3)) {
                            this.lLG.lLl.azr();
                            return;
                        }
                        v.v("MicroMsg.AppPanel", "Talkroom is on: " + str3);
                        com.tencent.mm.ui.base.g.b(this.lLG.context, this.lLG.context.getString(2131235616), SQLiteDatabase.KeyEmpty, this.lLG.context.getString(2131231107), this.lLG.context.getString(2131231010), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 lLH;

                            {
                                this.lLH = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.sdk.c.b pdVar = new pd();
                                pdVar.bqt.bqw = true;
                                com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                                this.lLH.lLG.lLl.azr();
                                dialogInterface.dismiss();
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 lLH;

                            {
                                this.lLH = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        return;
                    }
                    Toast.makeText(this.lLG.context, this.lLG.context.getString(2131231848), 0).show();
                    return;
                case 5:
                    if (this.lLG.lLl != null) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(6));
                        ak.yW();
                        c.vf().set(67, Boolean.valueOf(false));
                        this.lLG.lLl.azs();
                        return;
                    }
                    return;
                case 6:
                    if (this.lLG.lLp.lLX.value && this.lLG.lLp.lLY.value) {
                        ak.yW();
                        if (((Boolean) c.vf().get(290817, Boolean.valueOf(true))).booleanValue()) {
                            ak.yW();
                            c.vf().set(290817, Boolean.valueOf(false));
                            this.lLG.refresh();
                        }
                        com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(3));
                        this.lLG.lLl.azt();
                        return;
                    }
                    Toast.makeText(this.lLG.context, this.lLG.context.getString(2131231848), 0).show();
                    return;
                case 7:
                    if (this.lLG.lLp.lMb.value) {
                        if (fVar == null) {
                            fVar2 = (f) this.lLG.lLA.get(f.lAo);
                            if (fVar2 == null) {
                                return;
                            }
                        }
                        fVar2 = fVar;
                        if (fVar2.bnl() || fVar2.bnn()) {
                            if (this.lLG.cnm == null) {
                                this.lLG.cnm = this.lLG.context.getSharedPreferences(aa.bti(), 0);
                            }
                            if (this.lLG.cnm.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, true)) {
                                this.lLG.cnm.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, false).commit();
                            }
                            com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(13), fVar2.field_appId, Integer.valueOf(0));
                        } else {
                            com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(11), fVar2.field_appId);
                        }
                        this.lLG.lLl.azA();
                        return;
                    }
                    Toast.makeText(this.lLG.context, this.lLG.context.getString(2131231848), 0).show();
                    return;
                case 8:
                    if (fVar == null) {
                        fVar = (f) this.lLG.lLA.get(f.lAm);
                    }
                    ak.yW();
                    int intValue = ((Integer) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                    ak.yW();
                    List g = be.g(((String) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, SQLiteDatabase.KeyEmpty)).split(";"));
                    if (!g.contains(String.valueOf(intValue))) {
                        g.add(String.valueOf(intValue));
                        ak.yW();
                        c.vf().a(com.tencent.mm.storage.t.a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, be.b(g, ";"));
                        this.lLG.refresh();
                    }
                    ak.yW();
                    c.vf().set(80, Boolean.valueOf(false));
                    break;
                case 9:
                    if (this.lLG.lLl != null) {
                        if (fVar == null) {
                            fVar2 = (f) this.lLG.lLA.get(f.lAp);
                            if (fVar2 == null) {
                                v.i("MicroMsg.AppPanel", "empty info");
                                return;
                            }
                        }
                        fVar2 = fVar;
                        if (fVar2.bnl() || fVar2.bnn()) {
                            if (this.lLG.cnm == null) {
                                this.lLG.cnm = this.lLG.context.getSharedPreferences(aa.bti(), 0);
                            }
                            if (this.lLG.cnm.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, true)) {
                                this.lLG.cnm.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, false).commit();
                            }
                        }
                        this.lLG.lLl.azD();
                        return;
                    }
                    return;
                case 10:
                    if (this.lLG.lLp.lLL.value) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(4));
                        this.lLG.lLl.azu();
                        return;
                    }
                    Toast.makeText(this.lLG.context, this.lLG.context.getString(2131231848), 0).show();
                    return;
                case 11:
                    com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(9));
                    ak.yW();
                    c.vf().set(73, Boolean.valueOf(false));
                    this.lLG.lLm.bpB();
                    return;
                case 12:
                    if (this.lLG.lLp.lLM.value) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(5));
                        if (this.lLG.lLl != null) {
                            this.lLG.lLl.azw();
                            return;
                        }
                        return;
                    }
                    Toast.makeText(this.lLG.context, this.lLG.context.getString(2131231848), 0).show();
                    return;
                case 13:
                    if (this.lLG.lLp.lLZ.value) {
                        if (this.lLG.lLl != null) {
                            this.lLG.lLl.azy();
                        }
                        com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(15));
                        ak.yW();
                        boolean booleanValue = ((Boolean) c.vf().get(208899, Boolean.valueOf(false))).booleanValue();
                        ak.yW();
                        boolean booleanValue2 = ((Boolean) c.vf().get(208913, Boolean.valueOf(false))).booleanValue();
                        if (booleanValue) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(11594, Integer.valueOf(3));
                            return;
                        } else if (booleanValue2) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(11594, Integer.valueOf(4));
                            return;
                        } else {
                            return;
                        }
                    }
                    Toast.makeText(this.lLG.context, this.lLG.context.getString(2131231848), 0).show();
                    return;
                case 14:
                    if (this.lLG.lLp.lLP.value) {
                        ak.yW();
                        if (((Boolean) c.vf().get(327744, Boolean.valueOf(true))).booleanValue()) {
                            ak.yW();
                            c.vf().set(327744, Boolean.valueOf(false));
                            this.lLG.refresh();
                        }
                        com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(12));
                        this.lLG.lLl.azx();
                        return;
                    }
                    Toast.makeText(this.lLG.context, this.lLG.context.getString(2131231848), 0).show();
                    return;
                case 15:
                    if (this.lLG.lLp.lMd.value) {
                        this.lLG.lLl.azC();
                        return;
                    } else {
                        Toast.makeText(this.lLG.context, this.lLG.context.getString(2131231848), 0).show();
                        return;
                    }
                case Integer.MAX_VALUE:
                    if (this.lLG.lLc == null) {
                        v.e("MicroMsg.AppPanel", "infoList == null");
                        return;
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.Y(10305, String.valueOf(this.lLG.lLc.size()));
                    com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(10));
                    ak.yW();
                    c.vf().set(69121, SQLiteDatabase.KeyEmpty);
                    this.lLG.lLl.azv();
                    return;
                default:
                    return;
            }
            if (!this.lLG.lLp.lLR.value) {
                Toast.makeText(this.lLG.context, this.lLG.context.getString(2131231848), 0).show();
            } else if (fVar == null) {
                v.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
            } else {
                if (fVar.bnl() || fVar.bnn()) {
                    if (this.lLG.cnm == null) {
                        this.lLG.cnm = this.lLG.context.getSharedPreferences(aa.bti(), 0);
                    }
                    if (this.lLG.cnm.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, true)) {
                        this.lLG.cnm.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, false).commit();
                    }
                    if (fVar.bnn()) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(16), fVar.field_appId, Integer.valueOf(0));
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(13), fVar.field_appId, Integer.valueOf(0));
                } else {
                    com.tencent.mm.plugin.report.service.g.iuh.h(10923, Integer.valueOf(11), fVar.field_appId);
                }
                this.lLG.lLl.c(fVar);
            }
        }
    };
    boolean lLE = true;
    private int lLF = -1;
    private List<f> lLc = new LinkedList();
    private final boolean[] lLk = new boolean[16];
    a lLl;
    b lLm;
    private List<AppGrid> lLn;
    private int lLo = this.lKZ;
    public a lLp;
    private int lLq = 0;
    private int lLr = 0;
    int lLs = 0;
    private boolean lLt = false;
    private boolean lLu = false;
    private boolean lLv = false;
    private boolean lLw = false;
    boolean lLx = false;
    boolean lLy = false;
    boolean lLz = false;

    public interface a {
        void azA();

        void azB();

        void azC();

        void azD();

        void azq();

        void azr();

        void azs();

        void azt();

        void azu();

        void azv();

        void azw();

        void azx();

        void azy();

        void azz();

        void c(f fVar);

        void mS(int i);
    }

    public interface b {
        void bpB();
    }

    static /* synthetic */ void a(AppPanel appPanel, boolean z) {
        ak.yW();
        if (c.isSDCardAvailable()) {
            if (!lLD) {
                lLD = true;
                e.a(new Runnable(appPanel) {
                    final /* synthetic */ AppPanel lLG;

                    {
                        this.lLG = r1;
                    }

                    public final void run() {
                        com.tencent.mm.modelcdntran.g.Ea();
                        v.i("MicroMsg.AppPanel", "preMakeConnection ret:%d", Integer.valueOf(0));
                        AppPanel.lLD = false;
                    }
                }, "AppPanel_preMakeConnection");
            }
            if (z) {
                appPanel.lLl.mS(0);
                return;
            } else {
                appPanel.lLl.mS(1);
                return;
            }
        }
        s.ey(appPanel.context);
    }

    public AppPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public final void init(int i) {
        this.lLp = new a();
        this.lLs = i;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            this.lLq = defaultDisplay.getWidth();
            this.lLr = defaultDisplay.getHeight();
        } else {
            this.lLq = defaultDisplay.getHeight();
            this.lLr = defaultDisplay.getWidth();
        }
        View.inflate(this.context, 2130903125, this);
        this.iCv = (MMDotView) findViewById(2131755440);
        this.iCu = (MMFlipper) findViewById(2131755439);
        try {
            String value = j.sU().getValue("ShowAPPSuggestion");
            if (be.kS(value) || Integer.valueOf(value).intValue() != 1) {
                this.lLc = g.a(this.context, false, this.lLs);
                if (!bpz()) {
                    bM(this.lLc);
                }
                bL(this.lLc);
                bpw();
                bps();
            }
            this.lLc = g.a(this.context, true, this.lLs);
            if (bpz()) {
                bM(this.lLc);
            }
            bL(this.lLc);
            bpw();
            bps();
        } catch (Exception e) {
            v.e("MicroMsg.AppPanel", "exception in appPanel init, %s", e.getMessage());
            this.lLc = g.a(this.context, false, this.lLs);
        }
    }

    private void bL(List<f> list) {
        boolean z = this.lLt;
        this.lLt = false;
        boolean z2 = this.lLu;
        boolean z3 = this.lLv;
        boolean z4 = this.lLw;
        this.lLu = false;
        this.lLv = false;
        this.lLw = false;
        int i = this.lLs;
        ArrayList arrayList = new ArrayList();
        if (com.tencent.mm.pluginsdk.j.a.lxJ == null) {
            v.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
            i = 0;
        } else {
            Cursor cQ = com.tencent.mm.pluginsdk.j.a.lxJ.cQ(0, i);
            if (cQ == null) {
                i = 0;
            } else {
                i = cQ.getCount();
                cQ.close();
            }
        }
        v.d("MicroMsg.AppPanel", "serviceCount, %d", Integer.valueOf(i));
        this.lLA = new HashMap();
        if (i > 0 && list != null && list.size() > 0) {
            int i2 = 0;
            while (i2 < list.size()) {
                f fVar = (f) list.get(i2);
                if (!(fVar == null || fVar.field_appId == null || !fVar.bnl())) {
                    boolean z5;
                    int i3;
                    if ((fVar.field_serviceAppInfoFlag & 1) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (!z5) {
                        this.lLt = true;
                    }
                    if (f.lAm.equals(fVar.field_appId)) {
                        this.lLA.put(f.lAm, fVar);
                        if (!this.lLy) {
                            this.lLu = true;
                        }
                        i3 = i2 - 1;
                        list.remove(i2);
                        i2 = i3;
                    }
                    if (f.lAo.equals(fVar.field_appId)) {
                        this.lLA.put(f.lAo, fVar);
                        if (!this.lLx) {
                            this.lLv = true;
                        }
                        i3 = i2 - 1;
                        list.remove(i2);
                        i2 = i3;
                    }
                    if (f.lAp.equals(fVar.field_appId)) {
                        this.lLA.put(f.lAp, fVar);
                        if (!this.lLz) {
                            this.lLw = true;
                        }
                        i = i2 - 1;
                        list.remove(i2);
                        i2 = i;
                    }
                }
                i2++;
            }
        }
        v.d("MicroMsg.AppPanel", "hasService %b", Boolean.valueOf(this.lLt));
        if (z != this.lLt || z2 != this.lLu || z3 != this.lLv || z4 != this.lLw) {
            this.lLp.ic(this.lLt);
            this.lLp.id(this.lLu);
            this.lLp.ie(this.lLv);
            this.lLp.if(this.lLw);
            bpu();
        }
    }

    public final void bps() {
        a aVar = this.lLp;
        aVar.lLI.value = true;
        aVar.lLJ.value = true;
        aVar.lLK.value = true;
        aVar.lLL.value = true;
        aVar.lLM.value = true;
        aVar.lLN.value = true;
        aVar.lLO.value = true;
        aVar.lLX.value = true;
        aVar.lLV.value = true;
        aVar.lLP.value = true;
        aVar.lLQ.value = true;
        aVar.lLR.value = true;
        aVar.lLS.value = true;
        aVar.lLT.value = true;
        aVar.lLU.value = true;
        aVar.lLW.value = true;
        aVar.lLY.value = true;
        aVar.lLZ.value = false;
        aVar.lMa.value = true;
        aVar.lMb.value = true;
        aVar.lMd.value = true;
        aVar.lMe.value = true;
        aVar.lMd.value = false;
        this.lLx = false;
        this.lLy = false;
        this.lLz = false;
        bpt();
        this.lLp.ic(this.lLt);
        this.lLp.id(this.lLu);
        this.lLp.ie(this.lLv);
        this.lLp.if(this.lLw);
        bpu();
    }

    public final void bpt() {
        boolean z = true;
        boolean z2 = (k.xQ() & 1048576) == 0;
        j.sV();
        boolean brh = com.tencent.mm.h.c.sN() != 2 ? com.tencent.mm.ay.c.brh() : (k.xQ() & 4194304) == 0;
        this.lLp.lLO.value = z2;
        this.lLp.lLU.value = brh;
        this.lLp.lLY.value = com.tencent.mm.ay.c.EH("location");
        if ((k.xQ() & 33554432) != 0) {
            z = false;
        }
        this.lLp.lLW.value = z;
    }

    public final void ib(boolean z) {
        this.lLp.lLT.value = false;
        bpu();
        v.d("MicroMsg.AppPanel", "enable " + this.lLp.lLU.value + " isVoipAudioEnable false");
    }

    public final void bpu() {
        int i;
        int length = this.lLk.length;
        for (i = 0; i < length; i++) {
            this.lLk[i] = true;
        }
        if (this.lLp.lLK.value) {
            i = 0;
        } else {
            this.lLk[0] = false;
            i = 1;
        }
        if (!(this.lLp.lLX.value && this.lLp.lLY.value)) {
            this.lLk[6] = false;
            i++;
        }
        if (!this.lLp.lLP.value) {
            this.lLk[14] = false;
            i++;
        }
        if (!this.lLp.lLQ.value) {
            this.lLk[8] = false;
            i++;
        }
        if (!this.lLp.lLL.value) {
            this.lLk[10] = false;
            i++;
        }
        if (!this.lLp.lLZ.value) {
            this.lLk[13] = false;
            i++;
        }
        if (!this.lLp.lMc.value) {
            this.lLk[3] = false;
            i++;
        }
        if (!this.lLp.lLM.value) {
            this.lLk[12] = false;
            i++;
        }
        if (!this.lLp.lLS.value) {
            this.lLk[5] = false;
            i++;
        }
        if (!(this.lLp.lLU.value && this.lLp.lLT.value)) {
            this.lLk[4] = false;
            i++;
        }
        if (!(this.lLp.lLO.value && this.lLp.lLN.value)) {
            this.lLk[2] = false;
            i++;
        }
        if (!(this.lLp.lLW.value && this.lLp.lLV.value)) {
            this.lLk[11] = false;
            i++;
        }
        if (!this.lLp.lMa.value) {
            this.lLk[1] = false;
            i++;
        }
        if (!this.lLp.lMb.value) {
            this.lLk[7] = false;
            i++;
        }
        if (!this.lLp.lMd.value) {
            this.lLk[15] = false;
            i++;
        }
        if (!this.lLp.lMe.value) {
            this.lLk[9] = false;
            i++;
        }
        this.lKZ = 16 - i;
    }

    private int bpv() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            return 1;
        }
        return 2;
    }

    private void bpw() {
        v.d("MicroMsg.AppPanel", "AppPanel initFlipper");
        this.iCu.removeAllViews();
        this.iCu.nUX = new com.tencent.mm.ui.base.MMFlipper.a(this) {
            final /* synthetic */ AppPanel lLG;

            {
                this.lLG = r1;
            }

            public final void ck(int i, int i2) {
                v.d("MicroMsg.AppPanel", "onMeasure width:" + i + " height:" + i2 + " isMeasured:" + this.lLG.iCr);
                if (!this.lLG.iCr && i2 != 0 && i != 0) {
                    if (this.lLG.bpv() == 2) {
                        v.d("MicroMsg.AppPanel", "landspace");
                    } else {
                        v.d("MicroMsg.AppPanel", "portrait");
                    }
                    this.lLG.iCr = true;
                    this.lLG.iCt = i2;
                    this.lLG.iCs = i;
                    this.lLG.bpx();
                } else if (i2 == 0 || i == 0) {
                    v.d("MicroMsg.AppPanel", "onMeasure, width or height is 0");
                }
            }
        };
        this.iCu.nUW = new com.tencent.mm.ui.base.MMFlipper.b(this) {
            final /* synthetic */ AppPanel lLG;

            {
                this.lLG = r1;
            }

            public final void pa(int i) {
                this.lLG.iCv.wu(i);
            }
        };
        bpy();
    }

    public final void refresh() {
        v.v("MicroMsg.AppPanel", "app panel refleshed");
        try {
            String value = j.sU().getValue("ShowAPPSuggestion");
            int bBS;
            if (be.kS(value) || Integer.valueOf(value).intValue() != 1) {
                this.lLc = g.a(this.context, false, this.lLs);
                v.d("MicroMsg.AppPanel", "jacks not show App Suggestion");
                if (!bpz()) {
                    bM(this.lLc);
                }
                bL(this.lLc);
                if (this.lLp != null) {
                    this.lLp.ic(this.lLt);
                    this.lLp.id(this.lLu);
                    this.lLp.ie(this.lLv);
                    this.lLp.if(this.lLw);
                }
                bBS = this.iCu.bBS();
                bpx();
                this.iCu.wx(bBS);
                this.iCv.wu(bBS);
            }
            v.d("MicroMsg.AppPanel", "jacks show App Suggestion");
            this.lLc = g.a(this.context, true, this.lLs);
            if (bpz()) {
                bM(this.lLc);
            }
            bL(this.lLc);
            if (this.lLp != null) {
                this.lLp.ic(this.lLt);
                this.lLp.id(this.lLu);
                this.lLp.ie(this.lLv);
                this.lLp.if(this.lLw);
            }
            bBS = this.iCu.bBS();
            bpx();
            this.iCu.wx(bBS);
            this.iCv.wu(bBS);
        } catch (Exception e) {
            v.e("MicroMsg.AppPanel", "exception in appPanel init, %s", e.getMessage());
            this.lLc = g.a(this.context, false, this.lLs);
        }
    }

    private void bpx() {
        if (this.iCs != 0 && this.iCt != 0) {
            AppGrid appGrid;
            this.lLn = new ArrayList();
            this.iCu.removeAllViews();
            int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.context, 82.0f);
            int a2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.context, 90.0f);
            requestLayout();
            if (this.bnE) {
                a = 4;
            } else {
                a = this.iCs / a;
            }
            int i = this.iCt / a2;
            if (i > 2) {
                i = 2;
            }
            int i2 = (this.iCt - (a2 * i)) / (i + 1);
            v.d("MicroMsg.AppPanel", "jacks spacing2 = %d", Integer.valueOf(i2));
            v.d("MicroMsg.AppPanel", "in initAppGrid, gridWidth = %d, gridHeight = %d", Integer.valueOf(this.iCs), Integer.valueOf(this.iCt));
            if (a == 0) {
                a2 = 1;
            } else {
                a2 = a;
            }
            if (i == 0) {
                i = 1;
            }
            int i3 = a2 * i;
            if (this.lLp.lLR.value) {
                this.lLo = this.lKZ + this.lLc.size();
            } else {
                this.lLo = this.lKZ;
            }
            int ceil = (int) Math.ceil(((double) this.lLo) / ((double) i3));
            v.d("MicroMsg.AppPanel", "in initAppGrid, totalItemCount = %d, itemsPerPage = %d, pageCount = %d", Integer.valueOf(this.lLo), Integer.valueOf(i3), Integer.valueOf(ceil));
            for (i = 0; i < ceil; i++) {
                appGrid = (AppGrid) inflate(this.context, 2130903121, null);
                appGrid.lLa = new a(appGrid, appGrid.context, this.lLc, this.lLA);
                appGrid.setBackgroundResource(0);
                appGrid.setAdapter(appGrid.lLa);
                appGrid.setOnItemClickListener(appGrid.ezi);
                appGrid.setOnItemLongClickListener(appGrid.fOR);
                appGrid.setPadding(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(appGrid.context, 16.0f), com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(appGrid.context, 6.0f), com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(appGrid.context, 16.0f), 0);
                int i4 = this.lLo;
                int i5 = this.lKZ;
                appGrid.lKY = i;
                appGrid.lKV = i4;
                appGrid.lKW = i3;
                appGrid.lKX = ceil;
                appGrid.lKZ = i5;
                appGrid.setNumColumns(a2);
                if (i2 > 0) {
                    appGrid.setPadding(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(appGrid.context, 16.0f), i2, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(appGrid.context, 16.0f), 0);
                    appGrid.setVerticalSpacing(i2 / 2);
                }
                this.iCu.addView(appGrid, new LayoutParams(-1, -2));
                this.lLn.add(appGrid);
            }
            if (this.lLn != null) {
                for (AppGrid appGrid2 : this.lLn) {
                    appGrid2.lKU = this.lLC;
                }
            }
            if (this.lLn.size() <= 1) {
                this.iCv.setVisibility(4);
            } else {
                this.iCv.setVisibility(0);
                this.iCv.wt(this.lLn.size());
                a = this.iCu.bBS();
                this.iCu.wx(a);
                this.iCv.wu(a);
            }
            bpu();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            v.d("MicroMsg.AppPanel", "onConfigChanged:" + configuration.orientation);
            if (configuration.orientation == 1) {
                this.bnE = true;
            } else {
                this.bnE = false;
            }
            this.lLE = true;
            ahk();
        }
    }

    public final void ahk() {
        this.iCr = false;
        this.iCu.wx(0);
        bpw();
        requestLayout();
    }

    public final void ud(int i) {
        if (this.lLF != i) {
            this.lLF = i;
            this.lLE = true;
        }
    }

    public final void bpy() {
        if (this.lLE) {
            LayoutParams layoutParams;
            int a;
            View view;
            ViewGroup.LayoutParams layoutParams2;
            View findViewById;
            if (bpv() == 2) {
                v.d("MicroMsg.AppPanel", "initFlipper, landscape");
                findViewById = findViewById(2131755438);
                layoutParams = new LayoutParams(-1, 0);
                a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.context, (float) iCh);
                view = findViewById;
                layoutParams2 = layoutParams;
            } else {
                v.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", Integer.valueOf(iCg));
                findViewById = findViewById(2131755438);
                ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-1, 0);
                if (this.lLF > 0) {
                    a = this.lLF;
                    view = findViewById;
                    layoutParams2 = layoutParams3;
                } else {
                    a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.context, (float) iCg);
                    view = findViewById;
                    layoutParams2 = layoutParams3;
                }
            }
            layoutParams.height = a;
            view.setLayoutParams(layoutParams2);
            this.lLE = false;
        }
    }

    private static void bM(List<f> list) {
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (i < list.size()) {
                f fVar = (f) list.get(i);
                if (fVar == null || !f.lAn.equals(fVar.field_appId)) {
                    i++;
                } else {
                    list.remove(fVar);
                    return;
                }
            }
        }
    }

    private static boolean bpz() {
        d dVar = com.tencent.mm.pluginsdk.j.a.lxM;
        if (dVar == null || !dVar.ZV() || dVar.ZY() <= 0) {
            return false;
        }
        return true;
    }
}
