package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.e.a.lm;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.q;
import com.tencent.mm.wallet_core.b.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class MallIndexBaseUI extends WalletBaseUI implements a, g {
    private String hek = null;
    private TextView hiK = null;
    private ListView hiL = null;
    private a hiM = null;
    protected ImageView hiN = null;
    protected ImageView hiO;
    protected TextView hiP = null;
    protected TextView hiQ;
    private int hiR = 0;
    private boolean hiS = true;
    private boolean hiT = false;
    private String hic = null;
    private ArrayList<MallFunction> hid = null;
    protected int hih;

    protected abstract void ayG();

    protected abstract void ayH();

    protected abstract void ayI();

    protected abstract boolean ayK();

    protected abstract void ayP();

    protected abstract void ayQ();

    protected abstract void ayS();

    protected abstract void ayU();

    protected abstract void bU(View view);

    protected final int getLayoutId() {
        return 2130903927;
    }

    public void onCreate(Bundle bundle) {
        v.i("MicroMsg.MallIndexBaseUI", "onCreate");
        super.onCreate(bundle);
        if (!ak.uz()) {
            v.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
            finish();
        }
        ak.yW();
        int intValue = ((Integer) c.vf().get(t.a.nsQ, Integer.valueOf(0))).intValue();
        this.hih = getIntent().getIntExtra("key_wallet_region", intValue);
        gQ(495);
        k.bgh();
        com.tencent.mm.plugin.wallet_core.model.v.a(this);
        this.hic = getIntent().getStringExtra("key_func_id");
        v.i("MicroMsg.MallIndexBaseUI", "mFuncId:" + this.hic + " wallet_region: " + this.hih + " walletType: " + com.tencent.mm.model.k.xM() + " default_region: " + intValue);
        this.hek = getIntent().getStringExtra("key_native_url");
        v.i("MicroMsg.MallIndexBaseUI", "mNativeUrl:" + this.hek);
        if (!ayJ()) {
            oa(0);
            v.i("MicroMsg.MallIndexBaseUI", "index Oncreate");
            ayG();
            NI();
            com.tencent.mm.plugin.wallet_core.model.mall.c.bgN();
            ayH();
            v.i("MicroMsg.MallIndexBaseUI", "hy: use default controller for MallIndexUI");
            ayI();
            if (com.tencent.mm.model.k.xT()) {
                v.e("MicroMsg.MallIndexBaseUI", "it is payu account ,not initFingerPrint");
            } else {
                j.g gVar = j.a.lxX;
                if (gVar != null) {
                    v.i("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
                    gVar.bI(this);
                } else {
                    v.e("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null");
                }
            }
            n.dB(1, 0);
            com.tencent.mm.plugin.report.service.g.iuh.h(11850, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
        }
    }

    public final boolean ayJ() {
        if (be.kS(this.hic) && be.kS(this.hek)) {
            return false;
        }
        return true;
    }

    public void onResume() {
        super.onResume();
        f.ux(1);
        v.i("MicroMsg.MallIndexBaseUI", "index onResume");
        if (!ak.uz()) {
            v.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
            finish();
        }
        if (ayJ()) {
            this.hid = com.tencent.mm.plugin.mall.a.c.ayF().mN(this.hih);
            if (this.hid == null || this.hid.size() <= 0) {
                v.i("MicroMsg.MallIndexBaseUI", "mFunctionList == null");
                try {
                    if (getIntent().getIntExtra("key_scene", 0) == 1 || !be.kS(this.hek)) {
                        p(new com.tencent.mm.plugin.mall.a.a(this.hih, b.bgK()));
                        return;
                    }
                    String stringExtra = getIntent().getStringExtra("key_url");
                    if (stringExtra == null) {
                        stringExtra = "";
                    }
                    p(new com.tencent.mm.plugin.mall.a.a(this.hih, b.bgK(), getIntent().getStringExtra("key_app_id"), this.hic, stringExtra));
                    return;
                } catch (Throwable e) {
                    v.a("MicroMsg.MallIndexBaseUI", e, "", new Object[0]);
                    ayN();
                    return;
                }
            }
            MallFunction aK = aK(this.hid);
            if (aK == null) {
                aK = aL(this.hid);
            }
            a(aK, -1);
            finish();
            return;
        }
        boolean z;
        ayK();
        v.d("MicroMsg.MallIndexBaseUI", "initFunctionList");
        if (com.tencent.mm.plugin.mall.a.c.ayF().mN(this.hih) == null) {
            b(new com.tencent.mm.plugin.mall.a.a(this.hih, b.bgK()), true);
            v.e("MicroMsg.MallIndexBaseUI", "funcitonlist invalid");
            z = false;
        } else {
            b(new com.tencent.mm.plugin.mall.a.a(this.hih, b.bgK()), false);
            this.hid = com.tencent.mm.plugin.mall.a.c.ayF().mN(this.hih);
            z = true;
        }
        if (z) {
            v.i("MicroMsg.MallIndexBaseUI", "has data");
            av();
            if (!this.hiT && this.hid != null) {
                this.hiT = true;
                Iterator it = this.hid.iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (a.a((MallFunction) it.next())) {
                        this.hiL.setSelection(i);
                    }
                    i++;
                }
            }
        }
    }

    public void a(MallFunction mallFunction, int i) {
        String str;
        int i2;
        if (mallFunction != null && i >= 0) {
            str = "";
            if (!(mallFunction.kRg == null || be.kS(mallFunction.kRg.keV))) {
                str = mallFunction.kRg.keV;
            }
            int size = this.hid == null ? 0 : this.hid.size();
            boolean a = a.a(mallFunction);
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
            Object[] objArr = new Object[6];
            objArr[0] = mallFunction.imm;
            objArr[1] = Integer.valueOf(size);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(i);
            objArr[4] = str;
            if (a) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            objArr[5] = Integer.valueOf(i2);
            gVar.h(10881, objArr);
        }
        if (mallFunction == null || be.kS(mallFunction.cCj) || !com.tencent.mm.t.a.gq(mallFunction.cCj)) {
            if (mallFunction != null) {
                com.tencent.mm.plugin.wallet_core.model.mall.c.bgL().Dh(mallFunction.imm);
                d bgO = d.bgO();
                str = mallFunction.imm;
                v.d("MicroMsg.MallNewsManagerNewVersion", "removeNewsInIndexUI : " + str);
                if (!be.kS(str) && bgO.kRx.containsKey(str)) {
                    MallNews mallNews = (MallNews) bgO.kRx.get(str);
                    if ("0".equals(mallNews.kRl)) {
                        mallNews.kRl = "1";
                        bgO.aGr();
                    }
                }
                if ("wxpay://bizmall/mobile_recharge".equals(mallFunction.cCj)) {
                    i2 = 0;
                } else if ("wxpay://bizmall/weixin_hongbao".equals(mallFunction.cCj)) {
                    i2 = 4;
                } else if ("wxpay://bizmall/weixin_scan_qrcode".equals(mallFunction.cCj)) {
                    i2 = 8;
                } else if ("wxpay://bizmall/weixin_transfer".equals(mallFunction.cCj)) {
                    i2 = 5;
                } else if ("wxpay://bizmall/weixin_offline_pay".equals(mallFunction.cCj)) {
                    i2 = 6;
                } else if ("wxpay://bizmall/old_mobile_recharge".equals(mallFunction.cCj)) {
                    i2 = 7;
                } else if (be.kS(mallFunction.gxI)) {
                    v.w("MicroMsg.MallIndexUIHelper", "doSelectFunction no jump");
                    i2 = 2;
                } else {
                    i2 = 1;
                }
            } else {
                i2 = 3;
            }
            v.i("MicroMsg.MallIndexBaseUI", "functionType : " + i2);
            Intent intent;
            switch (i2) {
                case 0:
                    intent = new Intent();
                    if (ayJ()) {
                        intent.putExtra("key_is_hide_progress", true);
                    }
                    intent.putExtra("key_func_info", mallFunction);
                    com.tencent.mm.ay.c.b(this, "recharge", ".ui.PhoneRechargeUI", intent);
                    n.dB(15, 0);
                    return;
                case 1:
                    intent = new Intent();
                    intent.putExtra("rawUrl", mallFunction.gxI);
                    intent.putExtra("geta8key_username", com.tencent.mm.model.k.xF());
                    intent.putExtra("pay_channel", 1);
                    intent.putExtra("KPublisherId", "pay_wallet");
                    com.tencent.mm.ay.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    return;
                case 2:
                    v.w("MicroMsg.MallIndexBaseUI", "doSelectFunction no jump");
                    return;
                case 3:
                    v.w("MicroMsg.MallIndexBaseUI", "doSelectFunction do nothing");
                    s.makeText(this, "fuction list error", 1).show();
                    return;
                case 4:
                    com.tencent.mm.plugin.report.service.g.iuh.h(11701, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
                    intent = new Intent();
                    intent.putExtra("pay_channel", 1);
                    com.tencent.mm.ay.c.b(this, "luckymoney", ".ui.LuckyMoneyIndexUI", intent);
                    n.dB(13, 0);
                    com.tencent.mm.plugin.report.service.g.iuh.h(11850, new Object[]{Integer.valueOf(4), Integer.valueOf(0)});
                    return;
                case 5:
                    com.tencent.mm.plugin.report.service.g.iuh.h(11458, new Object[]{Integer.valueOf(1)});
                    if (com.tencent.mm.model.k.xT()) {
                        List linkedList = new LinkedList();
                        List linkedList2 = new LinkedList();
                        linkedList.add(getString(2131234548));
                        linkedList2.add(Integer.valueOf(0));
                        linkedList.add(getString(2131231965));
                        linkedList2.add(Integer.valueOf(1));
                        com.tencent.mm.ui.base.g.a(this, getString(2131234482), linkedList, linkedList2, null, true, new com.tencent.mm.ui.base.g.d(this) {
                            final /* synthetic */ MallIndexBaseUI hiU;

                            {
                                this.hiU = r1;
                            }

                            public final void bw(int i, int i2) {
                                switch (i2) {
                                    case 0:
                                        com.tencent.mm.plugin.report.service.g.iuh.h(11458, new Object[]{Integer.valueOf(2)});
                                        if (com.tencent.mm.model.k.xT()) {
                                            com.tencent.mm.wallet_core.a.b(this.hiU.nDR.nEl, "PayURemittanceProcess", null);
                                            return;
                                        } else {
                                            com.tencent.mm.wallet_core.a.b(this.hiU.nDR.nEl, "RemittanceProcess", null);
                                            return;
                                        }
                                    case 1:
                                        com.tencent.mm.plugin.report.service.g.iuh.h(11458, new Object[]{Integer.valueOf(3)});
                                        e.dq(this.hiU);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        });
                    } else {
                        ak.yW();
                        if (((Boolean) c.vf().get(t.a.npo, Boolean.valueOf(false))).booleanValue()) {
                            ayR();
                        } else {
                            ak.yW();
                            c.vf().a(t.a.npo, Boolean.valueOf(true));
                            com.tencent.mm.ui.base.g.a(this, getString(2131236198), "", new OnClickListener(this) {
                                final /* synthetic */ MallIndexBaseUI hiU;

                                {
                                    this.hiU = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.hiU.ayR();
                                }
                            });
                        }
                    }
                    n.dB(14, 0);
                    com.tencent.mm.plugin.report.service.g.iuh.h(11850, new Object[]{Integer.valueOf(3), Integer.valueOf(0)});
                    return;
                case 6:
                    intent = new Intent();
                    intent.putExtra("key_from_scene", 1);
                    com.tencent.mm.ay.c.b(this.nDR.nEl, "offline", ".ui.WalletOfflineEntranceUI", intent);
                    n.dB(9, 0);
                    com.tencent.mm.plugin.report.service.g.iuh.h(11850, new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
                    return;
                case 7:
                    intent = new Intent();
                    if (ayJ()) {
                        intent.putExtra("key_is_hide_progress", true);
                    }
                    intent.putExtra("key_func_info", mallFunction);
                    com.tencent.mm.ay.c.b(this, "recharge", ".ui.RechargeUI", intent);
                    return;
                case 8:
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    com.tencent.mm.ay.c.b(this.nDR.nEl, "scanner", ".ui.BaseScanUI", intent);
                    return;
                default:
                    return;
            }
        }
        v.i("MicroMsg.MallIndexBaseUI", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[]{mallFunction.cCj});
    }

    public void onDestroy() {
        gR(495);
        k.bgh();
        com.tencent.mm.plugin.wallet_core.model.v.b(this);
        super.onDestroy();
    }

    public boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("MicroMsg.MallIndexBaseUI", "onOtherSceneEnd");
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.b.a) {
            v.d("MicroMsg.MallIndexBaseUI", "hy: query bound scene end");
            if (i != 0 || i2 != 0) {
                finish();
                return true;
            } else if (this.hiS) {
                this.hiS = false;
                if (k.bfX().bgT().bgs()) {
                    com.tencent.mm.wallet_core.a.b((Activity) this, "PayUOpenProcess", null);
                    return true;
                }
            }
        }
        switch (kVar.getType()) {
            case 495:
                com.tencent.mm.plugin.mall.a.a aVar = (com.tencent.mm.plugin.mall.a.a) kVar;
                if (aVar.hih != this.hih) {
                    v.i("MicroMsg.MallIndexBaseUI", "pass wallet local: %d cgi: %d", new Object[]{Integer.valueOf(this.hih), Integer.valueOf(aVar.hih)});
                }
                if (ayJ()) {
                    v.d("MicroMsg.MallIndexBaseUI", "errorType:%d | errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (i != 0 || i2 != 0 || aVar.hid == null || aVar.hid.size() <= 0) {
                        ayN();
                        return true;
                    }
                    MallFunction aK;
                    if (getIntent().getIntExtra("key_scene", 0) == 1) {
                        aK = aK(aVar.hid);
                        if (aK != null) {
                            a(aK, -1);
                        }
                    } else if (!be.kS(this.hek)) {
                        v.d("MicroMsg.MallIndexBaseUI", "NativeUrl: %s", new Object[]{this.hek});
                        aK = aL(aVar.hid);
                        if (aK != null) {
                            a(aK, -1);
                        } else {
                            ayN();
                            return true;
                        }
                    } else if (aVar.hid != null && aVar.hid.size() > 0) {
                        v.i("MicroMsg.MallIndexBaseUI", "functionScene.mFunctionList != null");
                        a(aK(aVar.hid), -1);
                    } else if (com.tencent.mm.plugin.mall.a.c.ayF().mN(this.hih) == null || com.tencent.mm.plugin.mall.a.c.ayF().mN(this.hih).size() <= 0) {
                        v.e("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() == null");
                    } else {
                        v.i("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() != null");
                        a(aK(com.tencent.mm.plugin.mall.a.c.ayF().mN(this.hih)), -1);
                    }
                    setResult(-1);
                    finish();
                    return true;
                }
                if (i == 0 && i2 == 0 && com.tencent.mm.plugin.mall.a.c.ayF().mN(this.hih) != null && aVar.hid != null && aVar.hid.size() > 0) {
                    this.hid = com.tencent.mm.plugin.mall.a.c.ayF().mN(this.hih);
                    v.i("MicroMsg.MallIndexBaseUI", "get from server now! " + this.hih + " " + this.hid.size());
                    com.tencent.mm.plugin.wallet_core.model.mall.c.bgL().Q(this.hid);
                }
                av();
                return true;
            default:
                return false;
        }
    }

    private MallFunction aK(List<MallFunction> list) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(this.hic)) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            MallFunction mallFunction = (MallFunction) list.get(i);
            if (mallFunction != null && this.hic.equals(mallFunction.imm)) {
                return mallFunction;
            }
        }
        return null;
    }

    private MallFunction aL(List<MallFunction> list) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(this.hek)) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            MallFunction mallFunction = (MallFunction) list.get(i);
            if (mallFunction != null && this.hek.equals(mallFunction.cCj)) {
                return mallFunction;
            }
        }
        return null;
    }

    protected final boolean ayL() {
        if (!ayJ()) {
            av();
        }
        return true;
    }

    public final boolean ayM() {
        return false;
    }

    public final void k(String str, Bitmap bitmap) {
    }

    private void ayN() {
        setResult(0);
        finish();
    }

    private void av() {
        iU(true);
        a aVar = this.hiM;
        ArrayList arrayList = this.hid;
        aVar.hir.clear();
        if (arrayList != null) {
            int i = 0;
            while (i < arrayList.size()) {
                ArrayList arrayList2 = new ArrayList();
                int i2 = 0;
                while (i2 < 3 && i + i2 < arrayList.size()) {
                    int i3 = i + i2;
                    if (i2 > 0) {
                        int i4 = (i + i2) - 1;
                        if (i4 >= 0 && ((MallFunction) arrayList.get(i4)).type != ((MallFunction) arrayList.get(i3)).type) {
                            break;
                        }
                    }
                    c cVar = new c(aVar);
                    cVar.hiJ = i + i2;
                    cVar.hiI = (MallFunction) arrayList.get(i + i2);
                    arrayList2.add(cVar);
                    i2++;
                }
                if (arrayList2.size() > 0) {
                    aVar.hir.add(arrayList2);
                }
                i += i2;
            }
        }
        aVar.hig = com.tencent.mm.plugin.mall.a.c.ayF().mM(aVar.hih).hig;
        aVar.notifyDataSetChanged();
        ayQ();
        ayS();
        if (this.hiK != null) {
            this.hiK.setVisibility(8);
        }
        ayU();
    }

    public void onStop() {
        super.onStop();
    }

    protected final void ayO() {
        if (com.tencent.mm.model.k.xT()) {
            com.tencent.mm.ay.c.w(this, "wallet_payu", ".pwd.ui.WalletPayUPasswordSettingUI");
        } else {
            com.tencent.mm.ay.c.w(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
        }
    }

    public final void NI() {
        v.d("MicroMsg.MallIndexBaseUI", "index initView");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MallIndexBaseUI hiU;

            {
                this.hiU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 3);
                com.tencent.mm.ay.c.a(this.hiU, "com.tencent.mm.ui.LauncherUI", intent);
                this.hiU.finish();
                v.i("MicroMsg.MallIndexBaseUI", "set BackBtn");
                return true;
            }
        });
        this.hiL = (ListView) findViewById(2131758048);
        View inflate = q.em(this).inflate(2130903926, null);
        this.hiL.addHeaderView(inflate);
        this.hiM = new a(this, this.hih);
        this.hiL.setAdapter(this.hiM);
        this.hiM.his = new a.d(this) {
            final /* synthetic */ MallIndexBaseUI hiU;

            {
                this.hiU = r1;
            }

            public final void a(final int i, final MallFunction mallFunction) {
                if (mallFunction != null) {
                    int i2;
                    String str = mallFunction.imm;
                    if (be.kS(str)) {
                        i2 = 1;
                    } else {
                        ak.yW();
                        String str2 = (String) c.vf().get(t.a.nrF, null);
                        if (be.kS(str2)) {
                            i2 = 0;
                        } else {
                            String[] split = str2.split(",");
                            if (split == null || split.length == 0) {
                                i2 = 0;
                            } else {
                                for (String equals : split) {
                                    if (equals.equals(str)) {
                                        i2 = 1;
                                        break;
                                    }
                                }
                                i2 = 0;
                            }
                        }
                    }
                    if (i2 != 0 || be.kS(mallFunction.kRh)) {
                        this.hiU.a(mallFunction, i);
                        return;
                    }
                    v.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick show disclaimer funcId=%s", new Object[]{mallFunction.imm});
                    com.tencent.mm.ui.base.g.a(this.hiU.nDR.nEl, mallFunction.kRh, this.hiU.getString(2131233806), this.hiU.getString(2131230747), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 hiX;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Object obj = null;
                            String str = mallFunction.imm;
                            if (!be.kS(str)) {
                                ak.yW();
                                Object obj2 = (String) c.vf().get(t.a.nrF, null);
                                if (be.kS(obj2)) {
                                    obj2 = str;
                                } else {
                                    String[] split = obj2.split(",");
                                    if (split == null || split.length == 0) {
                                        String str2 = str;
                                    } else {
                                        for (String equals : split) {
                                            if (equals.equals(str)) {
                                                obj = 1;
                                                break;
                                            }
                                        }
                                        if (obj == null) {
                                            obj2 = obj2 + "," + str;
                                        }
                                    }
                                }
                                ak.yW();
                                c.vf().a(t.a.nrF, obj2);
                            }
                            this.hiX.hiU.a(mallFunction, i);
                        }
                    });
                    return;
                }
                v.w("MicroMsg.MallIndexBaseUI", "onFunctionItemClick functionItem null; pos=%d", new Object[]{Integer.valueOf(i)});
            }
        };
        bU(inflate);
        this.hiQ = (TextView) findViewById(2131756367);
        ayP();
    }

    private void ayR() {
        if (com.tencent.mm.model.k.xT()) {
            com.tencent.mm.wallet_core.a.b(this.nDR.nEl, "PayURemittanceProcess", null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pay_channel", 1);
        com.tencent.mm.wallet_core.a.b(this.nDR.nEl, "RemittanceProcess", bundle);
    }

    public void finish() {
        super.finish();
    }

    protected final void ayT() {
        String str;
        Intent intent = new Intent();
        if (com.tencent.mm.model.k.xT()) {
            str = "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/readtemplate?t=payu_faq_tmpl";
        } else {
            str = "https://kf.qq.com/touch/scene_product.html?scene_id=kf1";
        }
        intent.putExtra("rawUrl", str);
        com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
    }

    protected final int NO() {
        return 1;
    }

    public final void mO(int i) {
        if (i == 12 && this.hiP != null) {
            ayQ();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            ak.yW();
            this.hih = ((Integer) c.vf().get(t.a.nsQ, Integer.valueOf(0))).intValue();
            if (i2 != -1) {
                return;
            }
            if (com.tencent.mm.model.k.xU()) {
                finish();
                return;
            }
            finish();
            lm lmVar = new lm();
            lmVar.bmR.context = this.nDR.nEl;
            com.tencent.mm.sdk.c.a.nhr.z(lmVar);
        }
    }

    protected final void mP(int i) {
        switch (i) {
            case 0:
                y(this);
                return;
            case 1:
                ayO();
                com.tencent.mm.wallet_core.ui.e.yD(21);
                return;
            case 2:
                com.tencent.mm.wallet_core.ui.e.eT(this);
                com.tencent.mm.wallet_core.ui.e.yD(21);
                return;
            case 3:
                ayT();
                com.tencent.mm.wallet_core.ui.e.yD(23);
                return;
            case 4:
                ayV();
                return;
            default:
                return;
        }
    }

    protected final void ayV() {
        com.tencent.mm.ay.c.b(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
    }

    protected final void mQ(int i) {
        switch (i) {
            case 0:
                y(this);
                return;
            case 1:
                ayO();
                com.tencent.mm.wallet_core.ui.e.yD(21);
                return;
            case 2:
                com.tencent.mm.wallet_core.ui.e.eT(this);
                com.tencent.mm.wallet_core.ui.e.yD(22);
                return;
            case 3:
                ayT();
                com.tencent.mm.wallet_core.ui.e.yD(23);
                return;
            case 4:
                com.tencent.mm.ay.c.b(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
                return;
            default:
                return;
        }
    }

    protected final void mR(int i) {
        switch (i) {
            case 0:
                y(this);
                return;
            case 1:
                ayO();
                com.tencent.mm.wallet_core.ui.e.yD(21);
                return;
            case 2:
                com.tencent.mm.wallet_core.ui.e.eT(this);
                com.tencent.mm.wallet_core.ui.e.yD(22);
                return;
            case 3:
                ayT();
                com.tencent.mm.wallet_core.ui.e.yD(23);
                return;
            default:
                return;
        }
    }

    protected static void y(Activity activity) {
        if (k.bga().bgz().bgr()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "https://wx.tenpay.com/userroll/readtemplate?t=userroll/index_tmpl");
            com.tencent.mm.ay.c.b(activity, "webview", ".ui.tools.WebViewUI", intent);
            return;
        }
        com.tencent.mm.wallet_core.a.b(activity, "ShowOrdersInfoProcess", null);
        com.tencent.mm.wallet_core.ui.e.yD(20);
    }
}
