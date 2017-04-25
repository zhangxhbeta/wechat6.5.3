package com.tencent.mm.plugin.webview.stub;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.SystemClock;
import com.tencent.mm.a.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.ae;
import com.tencent.mm.e.a.bm;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.e.a.ch;
import com.tencent.mm.e.a.ci;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.e.a.eh;
import com.tencent.mm.e.a.ek;
import com.tencent.mm.e.a.en;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.e.a.gb;
import com.tencent.mm.e.a.gl;
import com.tencent.mm.e.a.iw;
import com.tencent.mm.e.a.km;
import com.tencent.mm.e.a.kt;
import com.tencent.mm.e.a.kv;
import com.tencent.mm.e.a.lk;
import com.tencent.mm.e.a.oi;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.model.o;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelbiz.d;
import com.tencent.mm.modelbiz.i;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.modelsearch.l;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLogin;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.d.ag;
import com.tencent.mm.plugin.webview.d.aj;
import com.tencent.mm.plugin.webview.d.p;
import com.tencent.mm.plugin.webview.d.x;
import com.tencent.mm.plugin.webview.modelcache.h;
import com.tencent.mm.plugin.webview.modelcache.n;
import com.tencent.mm.plugin.webview.modelcache.w.AnonymousClass5;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.AnonymousClass32;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.ach;
import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.protocal.c.dj;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.yo;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.AssertionFailedError;

public class WebViewStubService extends Service implements e {
    private List<WebViewStubCallbackWrapper> bed = new ArrayList();
    private c cND = new c<kv>(this) {
        final /* synthetic */ WebViewStubService lhL;

        {
            this.lhL = r2;
            this.nhz = kv.class.getName().hashCode();
        }

        private boolean a(kv kvVar) {
            if ((kvVar instanceof kv) && (this.lhL.lhG == null || this.lhL.lhG.containsKey(kvVar.bme.filePath))) {
                if (this.lhL.lhG != null) {
                    this.lhL.lhG.remove(kvVar.bme.filePath);
                }
                v.d("MicroMsg.WebViewStubService", "result: " + kvVar.bme.bfz);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.lhL.bed) {
                        webViewStubCallbackWrapper.ljN.i(kvVar.bme.filePath, kvVar.bme.bfz, kvVar.bme.aYV, kvVar.bme.aYW);
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.WebViewStubService", e, "", new Object[0]);
                }
            }
            return false;
        }
    };
    private ac handler;
    private com.tencent.mm.plugin.webview.stub.d.a lhF = new com.tencent.mm.plugin.webview.stub.d.a(this) {
        final /* synthetic */ WebViewStubService lhL;

        {
            this.lhL = r1;
        }

        public final void j(int i, Bundle bundle) {
            com.tencent.mm.plugin.webview.b.a biY = com.tencent.mm.plugin.webview.e.e.biY();
            Map hashMap = new HashMap();
            for (String str : bundle.keySet()) {
                hashMap.put(str, bundle.get(str));
            }
            switch (i) {
                case 1:
                    biY.C(hashMap);
                    return;
                default:
                    v.w("MicroMsg.emoji.EmojiStoreWebViewLogic", "unknow action:%d", new Object[]{Integer.valueOf(i)});
                    return;
            }
        }

        public final void k(int i, Bundle bundle) {
            com.tencent.mm.plugin.webview.c.b biZ = com.tencent.mm.plugin.webview.e.e.biZ();
            Map hashMap = new HashMap();
            for (String str : bundle.keySet()) {
                hashMap.put(str, bundle.get(str));
            }
            switch (i) {
                case 1:
                    biZ.ldn.remove(Integer.valueOf(bundle.getInt("webview_id")));
                    com.tencent.mm.plugin.webview.c.b.e eVar = biZ.ldr;
                    if (!(!eVar.ldC) || be.kS(eVar.bkC)) {
                        v.v("MicroMsg.FTS.FTSWebViewLogic", "can not report %s", new Object[]{eVar.bkC});
                    } else {
                        v.v("MicroMsg.FTS.FTSWebViewLogic", "report isReported:%b query:%s hasResult:%b isClick:%b searchType:%d", new Object[]{Boolean.valueOf(eVar.ldC), eVar.bkC, Boolean.valueOf(eVar.aWL), Boolean.valueOf(eVar.ldD), Integer.valueOf(eVar.iHC)});
                        l.a(eVar.scene, eVar.bkC, eVar.ldD, eVar.aWL, eVar.iHC);
                        eVar.ldC = true;
                    }
                    v.i("MicroMsg.FTS.FTSWebViewLogic", "activity destroy %d", new Object[]{Integer.valueOf(r4)});
                    return;
                default:
                    return;
            }
        }

        public final String er(final String str) {
            boolean uM = ak.uM();
            v.i("MicroMsg.WebViewStubService", "getDisplayName, needSetUin = " + uM);
            if (uM) {
                return (String) new az<String>(this, "") {
                    final /* synthetic */ AnonymousClass1 lhM;

                    protected final /* synthetic */ Object run() {
                        ak.yW();
                        return com.tencent.mm.model.c.wH().LX(str).tT();
                    }
                }.c(this.lhL.handler);
            }
            ak.yW();
            return com.tencent.mm.model.c.wH().LX(str).tT();
        }

        public final boolean eC(final String str) {
            boolean uM = ak.uM();
            v.i("MicroMsg.WebViewStubService", "isContact, needSetUin = " + uM);
            if (uM) {
                return ((Boolean) new az<Boolean>(this, Boolean.valueOf(false)) {
                    final /* synthetic */ AnonymousClass1 lhM;

                    protected final /* synthetic */ Object run() {
                        return Boolean.valueOf(m.eC(str));
                    }
                }.c(this.lhL.handler)).booleanValue();
            }
            return m.eC(str);
        }

        public final boolean fn(String str) {
            return m.fn(str);
        }

        public final boolean eD(String str) {
            boolean uz = ak.uz();
            v.i("MicroMsg.WebViewStubService", "isBizContact, accHasReady = " + uz);
            if (uz) {
                return m.eD(str);
            }
            return false;
        }

        public final boolean sj() {
            return f.sj();
        }

        public final boolean bjs() {
            return ak.uz();
        }

        @Deprecated
        public final void a(final int i, final Bundle bundle, final int i2) {
            v.i("MicroMsg.WebViewStubService", "edw, invoke, actionCode = %d, binderID = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            this.lhL.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 lhM;

                public final void run() {
                    int i;
                    int i2;
                    Intent intent;
                    String str;
                    Bundle bundle;
                    switch (i) {
                        case 1:
                            WebViewStubService.a(this.lhM.lhL, 2, bundle, i2);
                            return;
                        case 2:
                            s.ey(this.lhM.lhL);
                            return;
                        case 3:
                            this.lhM.lhL.handler.post(new Runnable(this.lhM, bundle) {
                                final /* synthetic */ AnonymousClass1 lhM;

                                public final void run() {
                                    Intent intent = new Intent();
                                    intent.addFlags(268435456);
                                    intent.putExtras(r3);
                                    intent.putExtra("isFromWebView", true);
                                    com.tencent.mm.plugin.webview.a.a.drp.u(intent, this.lhM.lhL);
                                }
                            });
                            return;
                        case 4:
                            WebViewStubService.a(this.lhM.lhL, 3, bundle, i2);
                            return;
                        case 5:
                            i = bundle.getInt("scene_end_type", 0);
                            i2 = bundle.getInt("scene_end_listener_hash_code", -1);
                            if (i2 != -1) {
                                this.lhM.lhL.lhK.add(Integer.valueOf(i2));
                            }
                            v.i("MicroMsg.WebViewStubService", "add Scene end, hashCode:[%d], set size:[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.lhM.lhL.lhK.size())});
                            if (i > 0) {
                                this.lhM.lhL.lhH = this.lhM.lhL.lhH + 1;
                                v.i("MicroMsg.WebViewStubService", "real add Scene end, hashCode:[%d]", new Object[]{Integer.valueOf(i2)});
                                ak.vy().a(233, this.lhM.lhL);
                                ak.vy().a(673, this.lhM.lhL);
                                ak.vy().a(666, this.lhM.lhL);
                                ak.vy().a(1080, this.lhM.lhL);
                                return;
                            }
                            return;
                        case 6:
                            i = bundle.getInt("scene_end_type", 0);
                            i2 = bundle.getInt("scene_end_listener_hash_code", -1);
                            if (i2 != -1) {
                                this.lhM.lhL.lhK.remove(Integer.valueOf(i2));
                            }
                            v.i("MicroMsg.WebViewStubService", "remove Scene end, hashCode:[%d], set size:[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.lhM.lhL.lhK.size())});
                            if (i > 0) {
                                this.lhM.lhL.lhH = this.lhM.lhL.lhH - 1;
                                if (this.lhM.lhL.lhH <= 0 && this.lhM.lhL.lhK.size() <= 0) {
                                    v.i("MicroMsg.WebViewStubService", "real remove Scene end, hashCode:[%d]", new Object[]{Integer.valueOf(i2)});
                                    if (ak.uz()) {
                                        ak.vy().b(233, this.lhM.lhL);
                                        ak.vy().b(673, this.lhM.lhL);
                                        ak.vy().b(666, this.lhM.lhL);
                                        ak.vy().b(1080, this.lhM.lhL);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        case 7:
                            intent = new Intent();
                            intent.putExtra("MMActivity.OverrideEnterAnimation", 0);
                            intent.putExtra("MMActivity.OverrideExitAnimation", 2130968644);
                            intent.addFlags(268435456);
                            com.tencent.mm.plugin.webview.a.a.drp.v(intent, this.lhM.lhL);
                            return;
                        case 8:
                            intent = new Intent();
                            intent.putExtras(bundle);
                            intent.addFlags(268435456);
                            com.tencent.mm.plugin.webview.a.a.drp.w(intent, this.lhM.lhL);
                            return;
                        case 20:
                            j.tl(i2).lpj = bundle.getBundle("jsapiargs");
                            str = (String) bundle.getCharSequence("bizofstartfrom");
                            bundle = bundle.getBundle("startwebviewparams");
                            if (str != null && bundle != null) {
                                iw iwVar = new iw();
                                iwVar.bjn.bjo = str;
                                iwVar.bjn.bjp = bundle;
                                com.tencent.mm.sdk.c.a.nhr.z(iwVar);
                                return;
                            }
                            return;
                        case 21:
                            j.tl(i2).blp().putAll(bundle);
                            return;
                        case JsApiChooseImage.CTRL_INDEX /*29*/:
                            str = bundle.getString("srcUsername");
                            u.Dy();
                            d.ht(str);
                            u.Dy();
                            d.hu(str);
                            u.DH();
                            if (!be.kS(str) && com.tencent.mm.modelbiz.e.hD(str)) {
                                u.DH();
                                i.hI(str);
                                return;
                            }
                            return;
                        case 30:
                            str = bundle.getString("srcUsername");
                            u.Dy();
                            d.hv(str);
                            u.DH();
                            if (!be.kS(str) && com.tencent.mm.modelbiz.e.hD(str)) {
                                u.DH();
                                i.hJ(str);
                                return;
                            }
                            return;
                        case 41:
                            if (ak.uz()) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.i tl = j.tl(i2);
                                bundle = bundle;
                                if (tl.lpN != null) {
                                    if (bundle == null || bundle.size() <= 0) {
                                        tl.a(tl.leB, tl.lpN, "showKeyboard:fail", null, true, true);
                                    } else {
                                        Map hashMap = new HashMap();
                                        hashMap.put("text", be.ma(bundle.getString("show_kb_input_callback_text")));
                                        tl.a(tl.leB, tl.lpN, "showKeyboard:ok", hashMap, true, true);
                                    }
                                    tl.lpN = null;
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            v.e("MicroMsg.WebViewStubService", "not support action code:[%d]", new Object[]{Integer.valueOf(i)});
                            return;
                    }
                }
            });
        }

        public final b F(Bundle bundle) {
            boolean a;
            Object aVar = new a();
            long j = bundle.getLong("msg_id", Long.MIN_VALUE);
            String string = bundle.getString("sns_local_id");
            int i = bundle.getInt("news_svr_id", 0);
            String string2 = bundle.getString("news_svr_tweetid");
            bp bpVar = new bp();
            if (Long.MIN_VALUE != j) {
                bpVar.aZd.aZi = bundle.getInt("message_index", 0);
                a = com.tencent.mm.pluginsdk.model.d.a(bpVar, j);
            } else if (!be.kS(string)) {
                oi oiVar = new oi();
                oiVar.bpn.bpp = string;
                oiVar.bpn.bpq = bpVar;
                oiVar.bpn.url = bundle.getString("rawUrl");
                com.tencent.mm.sdk.c.a.nhr.z(oiVar);
                a = oiVar.bpo.aYN;
            } else if (i != 0) {
                km kmVar = new km();
                kmVar.blJ.opType = 3;
                kmVar.blJ.blL = bpVar;
                kmVar.blJ.blM = i;
                kmVar.blJ.blN = string2;
                com.tencent.mm.sdk.c.a.nhr.z(kmVar);
                a = kmVar.blK.aYN;
            } else {
                aVar.lhT = true;
                return aVar;
            }
            if (a) {
                string = be.ma(bundle.getString("prePublishId"));
                String fz = o.fz(string);
                com.tencent.mm.model.o.b n = o.yx().n(fz, true);
                n.l("sendAppMsgScene", Integer.valueOf(2));
                n.l("preChatName", bundle.getString("preChatName"));
                n.l("preMsgIndex", Integer.valueOf(bundle.getInt("preMsgIndex")));
                n.l("prePublishId", string);
                n.l("preUsername", bundle.getString("preUsername"));
                n.l("getA8KeyScene", bundle.getString("getA8KeyScene"));
                n.l("referUrl", bundle.getString("referUrl"));
                Bundle bundle2 = bundle.getBundle("jsapiargs");
                if (bundle2 != null) {
                    n.l("adExtStr", bundle2.getString("key_snsad_statextstr"));
                }
                bpVar.aZd.aZj = fz;
                com.tencent.mm.sdk.c.a.nhr.z(bpVar);
            } else {
                if (bpVar.aZd.aZk == 0) {
                    bpVar.aZd.aZk = 2131232661;
                }
                com.tencent.mm.sdk.c.a.nhr.z(bpVar);
            }
            aVar.ret = bpVar.aZe.ret;
            return aVar;
        }

        public final String ED(final String str) {
            boolean uM = ak.uM();
            v.i("MicroMsg.WebViewStubService", "getHeadImgPath, needSetUin = " + uM);
            if (uM) {
                return (String) new az<String>(this, "") {
                    final /* synthetic */ AnonymousClass1 lhM;

                    protected final /* synthetic */ Object run() {
                        return com.tencent.mm.u.b.r(str, false);
                    }
                }.c(this.lhL.handler);
            }
            return com.tencent.mm.u.b.r(str, false);
        }

        public final boolean isSDCardAvailable() {
            boolean uM = ak.uM();
            v.i("MicroMsg.WebViewStubService", "isSDCardAvailable, needSetUin = " + uM);
            if (uM) {
                return ((Boolean) new az<Boolean>(this, Boolean.valueOf(false)) {
                    final /* synthetic */ AnonymousClass1 lhM;

                    protected final /* synthetic */ Object run() {
                        ak.yW();
                        return Boolean.valueOf(com.tencent.mm.model.c.isSDCardAvailable());
                    }
                }.c(this.lhL.handler)).booleanValue();
            }
            ak.yW();
            return com.tencent.mm.model.c.isSDCardAvailable();
        }

        public final int cN(final int i, final int i2) {
            boolean uM = ak.uM();
            v.i("MicroMsg.WebViewStubService", "getIntConfig, needSetUin = " + uM);
            if (uM) {
                return ((Integer) new az<Integer>(this, Integer.valueOf(0)) {
                    final /* synthetic */ AnonymousClass1 lhM;

                    protected final /* synthetic */ Object run() {
                        ak.yW();
                        return Integer.valueOf(be.a((Integer) com.tencent.mm.model.c.vf().get(i, null), i2));
                    }
                }.c(this.lhL.handler)).intValue();
            }
            ak.yW();
            return be.a((Integer) com.tencent.mm.model.c.vf().get(i, null), i2);
        }

        public final void cO(final int i, final int i2) {
            this.lhL.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 lhM;

                public final void run() {
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(i, Integer.valueOf(i2));
                }
            });
        }

        public final String am(final int i, final String str) {
            boolean uM = ak.uM();
            v.i("MicroMsg.WebViewStubService", "getStringConfig, needSetUin = " + uM);
            if (uM) {
                return (String) new az<String>(this) {
                    final /* synthetic */ AnonymousClass1 lhM;

                    protected final /* synthetic */ Object run() {
                        ak.yW();
                        return be.ah((String) com.tencent.mm.model.c.vf().get(i, null), str);
                    }
                }.c(this.lhL.handler);
            }
            ak.yW();
            return be.ah((String) com.tencent.mm.model.c.vf().get(i, null), str);
        }

        public final boolean l(int i, final Bundle bundle) {
            boolean uM;
            switch (i) {
                case 233:
                    if (bjs()) {
                        uM = ak.uM();
                        v.i("MicroMsg.WebViewStubService", "doScene, needSetUin = " + uM);
                        if (uM) {
                            return ((Boolean) new az<Boolean>(this, Boolean.valueOf(false)) {
                                final /* synthetic */ AnonymousClass1 lhM;

                                protected final /* synthetic */ Object run() {
                                    return Boolean.valueOf(AnonymousClass1.G(bundle));
                                }
                            }.c(this.lhL.handler)).booleanValue();
                        }
                        return AnonymousClass1.G(bundle);
                    }
                    v.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 666:
                    if (bjs()) {
                        uM = ak.uM();
                        v.d("MicroMsg.WebViewStubService", "doScene, needSetUin = " + uM);
                        if (uM) {
                            return ((Boolean) new az<Boolean>(this, Boolean.valueOf(false)) {
                                final /* synthetic */ AnonymousClass1 lhM;

                                protected final /* synthetic */ Object run() {
                                    return Boolean.valueOf(ak.vy().a(new w(bundle.getString("emoji_store_jump_url")), 0));
                                }
                            }.c(this.lhL.handler)).booleanValue();
                        }
                        return ak.vy().a(new w(bundle.getString("emoji_store_jump_url")), 0);
                    }
                    v.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 673:
                    if (bjs()) {
                        uM = ak.uM();
                        v.d("MicroMsg.WebViewStubService", "doScene, needSetUin = " + uM);
                        if (uM) {
                            return ((Boolean) new az<Boolean>(this, Boolean.valueOf(false)) {
                                final /* synthetic */ AnonymousClass1 lhM;

                                protected final /* synthetic */ Object run() {
                                    return Boolean.valueOf(AnonymousClass1.H(bundle));
                                }
                            }.c(this.lhL.handler)).booleanValue();
                        }
                        return AnonymousClass1.H(bundle);
                    }
                    v.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                case 1080:
                    if (bjs()) {
                        uM = ak.uM();
                        v.d("MicroMsg.WebViewStubService", "doScene, needSetUin = " + uM);
                        if (uM) {
                            return ((Boolean) new az<Boolean>(this, Boolean.valueOf(false)) {
                                final /* synthetic */ AnonymousClass1 lhM;

                                protected final /* synthetic */ Object run() {
                                    return Boolean.valueOf(ak.vy().a(new com.tencent.mm.modelbiz.l(bundle.getString("key_async_url_check_url")), 0));
                                }
                            }.c(this.lhL.handler)).booleanValue();
                        }
                        return ak.vy().a(new com.tencent.mm.modelbiz.l(bundle.getString("key_async_url_check_url")), 0);
                    }
                    v.w("MicroMsg.WebViewStubService", "doScene, hasSetUin false");
                    return false;
                default:
                    return false;
            }
        }

        private static boolean G(Bundle bundle) {
            k lVar;
            String string = bundle.getString("geta8key_data_req_url");
            if (be.kS(string)) {
                lVar = new com.tencent.mm.modelsimple.l(bundle.getString("geta8key_data_appid"), bundle.getString("geta8key_data_scope"), bundle.getString("geta8key_data_state"));
            } else {
                lVar = new com.tencent.mm.modelsimple.l(string, bundle.getString("geta8key_data_username"), bundle.getInt("geta8key_data_scene"), bundle.getInt("geta8key_data_reason"), bundle.getInt("geta8key_data_flag"), bundle.getString("geta8key_data_net_type"));
            }
            return ak.vy().a(lVar, 0);
        }

        private static boolean H(Bundle bundle) {
            return ak.vy().a(new com.tencent.mm.plugin.webview.d.j(bundle.getString("reading_mode_data_url"), bundle.getString("reading_mode_data_useragent"), bundle.getInt("reading_mode_data_width"), bundle.getInt("reading_mode_data_height")), 0);
        }

        public final boolean Dn() {
            boolean uM = ak.uM();
            v.i("MicroMsg.WebViewStubService", "hasAcceptLinkList, needSetUin = " + uM);
            if (uM) {
                return ((Boolean) new az<Boolean>(this, Boolean.valueOf(false)) {
                    final /* synthetic */ AnonymousClass1 lhM;

                    protected final /* synthetic */ Object run() {
                        return Boolean.valueOf(com.tencent.mm.modelbiz.e.Dn());
                    }
                }.c(this.lhL.handler)).booleanValue();
            }
            return com.tencent.mm.modelbiz.e.Dn();
        }

        public final List<String> Dm() {
            boolean uM = ak.uM();
            v.i("MicroMsg.WebViewStubService", "getMyAcceptLinkList, needSetUin = " + uM);
            if (uM) {
                return (List) new az<List<String>>(this) {
                    final /* synthetic */ AnonymousClass1 lhM;

                    {
                        this.lhM = r4;
                    }

                    protected final /* synthetic */ Object run() {
                        return AnonymousClass1.bjt();
                    }
                }.c(this.lhL.handler);
            }
            return AnonymousClass1.bjt();
        }

        private static List<String> bjt() {
            List<String> Dm = com.tencent.mm.modelbiz.e.Dm();
            List<String> linkedList = new LinkedList();
            for (String str : Dm) {
                if (!com.tencent.mm.modelbiz.e.hz(str)) {
                    linkedList.add(str);
                }
            }
            return linkedList;
        }

        public final void g(int i, List<String> list) {
            g.iuh.d(i, list);
        }

        public final boolean a(String str, boolean z, Bundle bundle) {
            return com.tencent.mm.pluginsdk.j.a.lxU.a(this.lhL, str, z, bundle);
        }

        public final String EE(String str) {
            if (com.tencent.mm.pluginsdk.j.a.lxV != null) {
                return com.tencent.mm.pluginsdk.j.a.lxV.q(this.lhL, str);
            }
            return null;
        }

        public final void bk(String str, int i) {
            new Bundle().putInt("webview_binder_id", i);
            WebViewStubService.a(this.lhL, 5, null, i);
        }

        public final void ax(String str, boolean z) {
            com.tencent.mm.pluginsdk.j.a.lxU.a(this.lhL, str, z);
        }

        public final boolean yn() {
            boolean uM = ak.uM();
            v.i("MicroMsg.WebViewStubService", "hasBindQQ, needSetUin = " + uM);
            if (uM) {
                return ((Boolean) new az<Boolean>(this, Boolean.valueOf(false)) {
                    final /* synthetic */ AnonymousClass1 lhM;

                    protected final /* synthetic */ Object run() {
                        return Boolean.valueOf(com.tencent.mm.model.k.yn());
                    }
                }.c(this.lhL.handler)).booleanValue();
            }
            return com.tencent.mm.model.k.yn();
        }

        public final void g(String str, boolean z, int i) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.i tl = j.tl(i);
            if (!be.kS(str)) {
                v.i("MicroMsg.MsgHandler", "addInvokedJsApiFromMenu, functionName = %s, clear isBusy state", new Object[]{str});
                tl.fHM = false;
                tl.lpi.add(str);
                if (z) {
                    tl.lph.add(str);
                }
            }
        }

        public final Bundle sN(int i) {
            return j.tl(i).blp();
        }

        public final boolean sO(int i) {
            boolean z = j.tl(i).fHM;
            if (z) {
                v.w("MicroMsg.WebViewStubService", "isBusy, doingFunction = " + j.tl(i).lpn);
            }
            return z;
        }

        public final void w(String str, String str2, int i) {
            j.tl(i).blp().putString(str, str2);
        }

        public final boolean a(String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i) {
            boolean EC = WebViewStubService.EC(str2);
            v.i("MicroMsg.WebViewStubService", "handleMsg, function = " + str2 + ", doInActivity = " + EC);
            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper();
            jsapiPermissionWrapper.u(bundle);
            if (EC) {
                WebViewStubService.a(this.lhL, str, str2, str3, jsapiPermissionWrapper, bundle2, i);
                return true;
            }
            com.tencent.mm.plugin.webview.ui.tools.jsapi.k kVar = new com.tencent.mm.plugin.webview.ui.tools.jsapi.k();
            kVar.type = str;
            kVar.lqZ = str2;
            kVar.lqX = str3;
            kVar.iaJ = com.tencent.mm.plugin.webview.ui.tools.jsapi.k.P(bundle2);
            e eVar = null;
            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.lhL.bed) {
                e eVar2;
                if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.id != i) {
                    eVar2 = eVar;
                } else {
                    eVar2 = webViewStubCallbackWrapper.ljN;
                }
                eVar = eVar2;
            }
            j.tl(i).a(this.lhL, eVar);
            EC = j.tl(i).a(kVar, jsapiPermissionWrapper);
            v.i("MicroMsg.WebViewStubService", "handleRet = " + EC);
            return EC;
        }

        public final void a(String str, Bundle bundle, int i) {
            Bundle bundle2 = new Bundle();
            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper();
            jsapiPermissionWrapper.u(bundle);
            bundle2.putParcelable("proxyui_perm_key", jsapiPermissionWrapper);
            bundle2.putString("proxyui_username_key", str);
            bundle2.putInt("webview_binder_id", i);
            WebViewStubService.a(this.lhL, 4, bundle2, i);
        }

        public final void EF(String str) {
            com.tencent.mm.pluginsdk.model.app.f aC = com.tencent.mm.pluginsdk.model.app.g.aC(str, false);
            if (aC != null && be.kS(aC.field_openId)) {
                v.i("MicroMsg.WebViewStubService", "initView trigger getappsetting, appId = " + str);
                gb gbVar = new gb();
                gbVar.bfD.appId = str;
                com.tencent.mm.sdk.c.a.nhr.z(gbVar);
            }
        }

        public final String EG(final String str) {
            boolean uM = ak.uM();
            v.i("MicroMsg.WebViewStubService", "getPackageName, needSetUin = " + uM);
            if (uM) {
                return (String) new az<String>(this) {
                    final /* synthetic */ AnonymousClass1 lhM;

                    protected final /* synthetic */ Object run() {
                        com.tencent.mm.pluginsdk.model.app.f aC = com.tencent.mm.pluginsdk.model.app.g.aC(str, false);
                        return aC == null ? null : aC.field_packageName;
                    }
                }.c(this.lhL.handler);
            }
            com.tencent.mm.pluginsdk.model.app.f aC = com.tencent.mm.pluginsdk.model.app.g.aC(str, false);
            return aC == null ? null : aC.field_packageName;
        }

        public final boolean bv(String str) {
            return com.tencent.mm.pluginsdk.j.a.lxV.bv(str);
        }

        public final void N(int i, int i2, int i3) {
            Bundle bundle = new Bundle();
            bundle.putInt("proxyui_expired_errtype", i);
            bundle.putInt("proxyui_expired_errcode", i2);
            WebViewStubService.a(this.lhL, 6, bundle, i3);
        }

        public final boolean EH(String str) {
            return com.tencent.mm.ay.c.EH(str);
        }

        public final void sP(int i) {
            v.i("MicroMsg.WebViewStubService", "removeCallback, id = %d", new Object[]{Integer.valueOf(i)});
            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.lhL.bed) {
                if (webViewStubCallbackWrapper.id == i) {
                    this.lhL.bed.remove(webViewStubCallbackWrapper);
                    return;
                }
            }
        }

        public final void a(e eVar, int i) {
            v.i("MicroMsg.WebViewStubService", "addCallback, cb.hash = %d, id = %d", new Object[]{Integer.valueOf(eVar.hashCode()), Integer.valueOf(i)});
            this.lhL.bed.add(new WebViewStubCallbackWrapper(eVar, i));
            j.tl(i);
        }

        public final String[] sO() {
            boolean uM = ak.uM();
            v.i("MicroMsg.WebViewStubService", "getRemoveJsInterfaceList, needSetUin = " + uM);
            if (uM) {
                return (String[]) new az<String[]>(this) {
                    final /* synthetic */ AnonymousClass1 lhM;

                    {
                        this.lhM = r4;
                    }

                    protected final /* synthetic */ Object run() {
                        return com.tencent.mm.h.j.sV().sO();
                    }
                }.c(this.lhL.handler);
            }
            return com.tencent.mm.h.j.sV().sO();
        }

        public final boolean I(Bundle bundle) {
            bm bmVar = new bm();
            bmVar.aYY.aZa = bundle.getLong("fav_local_id", -1);
            com.tencent.mm.sdk.c.a.nhr.z(bmVar);
            v.i("MicroMsg.WebViewStubService", "do del fav web url, local id %d, result %B", new Object[]{Long.valueOf(bmVar.aYY.aZa), Boolean.valueOf(bmVar.aYZ.aYN)});
            return bmVar.aYZ.aYN;
        }

        public final String bju() {
            ak.yW();
            return (String) com.tencent.mm.model.c.vf().get(-1535680990, null);
        }

        public final String Ec(String str) {
            return aj.Ec(str);
        }

        public final String bjv() {
            return com.tencent.mm.sdk.platformtools.u.d(this.lhL.getSharedPreferences(aa.bti(), 0));
        }

        public final String EI(final String str) {
            boolean uz = ak.uz();
            v.i("MicroMsg.WebViewStubService", "getDynamicConfigValue, accHasReady = " + uz);
            if (uz) {
                return com.tencent.mm.h.j.sU().getValue(str);
            }
            return (String) new az<String>(this) {
                final /* synthetic */ AnonymousClass1 lhM;

                protected final /* synthetic */ Object run() {
                    return ak.uz() ? com.tencent.mm.h.j.sU().getValue(str) : null;
                }
            }.c(this.lhL.handler);
        }

        public final void EJ(final String str) {
            boolean uz = ak.uz();
            v.i("MicroMsg.WebViewStubService", "triggerGetContact, accHasReady = " + uz);
            AnonymousClass13 anonymousClass13 = new az<Void>(this) {
                final /* synthetic */ AnonymousClass1 lhM;

                protected final /* synthetic */ Object run() {
                    if (ak.uz()) {
                        ak.yW();
                        com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(str);
                        if (LX == null || ((int) LX.chr) <= 0) {
                            com.tencent.mm.model.ab.a.crZ.a(str, "", null);
                        } else {
                            v.v("MicroMsg.WebViewStubService", "triggerGetContact, already exist, no need to getcontact");
                        }
                    }
                    return null;
                }
            };
            if (uz) {
                anonymousClass13.c(null);
            } else {
                anonymousClass13.c(this.lhL.handler);
            }
        }

        public final String bl(String str, int i) {
            x DW;
            switch (i) {
                case 1:
                    DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(str);
                    if (DW != null) {
                        v.i("MicroMsg.WebviewJSSDKUtil", "get local thumb filepath from local id :%s", new Object[]{DW.lek});
                        return DW.lek;
                    }
                    v.e("MicroMsg.WebviewJSSDKUtil", "fromLocalIdToFilePath, local map not contains the local id : %s", new Object[]{str});
                    return null;
                case 2:
                    DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(str);
                    if (DW != null) {
                        v.i("MicroMsg.WebviewJSSDKUtil", "get orignal filepath from local id :%s", new Object[]{DW.lek});
                        return DW.lel;
                    }
                    v.e("MicroMsg.WebviewJSSDKUtil", "getOrigFilePathByLocalId, local map not contains the local id : %s", new Object[]{str});
                    return null;
                default:
                    return null;
            }
        }

        public final int EK(String str) {
            bp bpVar = new bp();
            com.tencent.mm.pluginsdk.model.d.a(bpVar, 1, str);
            com.tencent.mm.sdk.c.a.nhr.z(bpVar);
            return bpVar.aZe.ret;
        }

        public final void bjw() {
            ez ezVar = new ez();
            ezVar.bdQ.type = 35;
            com.tencent.mm.sdk.c.a.nhr.z(ezVar);
        }

        public final boolean l(long j, String str) {
            if (j == Long.MIN_VALUE && str == null) {
                return false;
            }
            cp cpVar = new cp();
            if (j != Long.MIN_VALUE) {
                cpVar.bay.bao = j;
            }
            if (str != null) {
                cpVar.bay.bap = str;
            }
            com.tencent.mm.sdk.c.a.nhr.z(cpVar);
            if (cpVar.baz.aZW) {
                return true;
            }
            if (ak.uz() && j != Long.MIN_VALUE) {
                ak.yW();
                at ek = com.tencent.mm.model.c.wJ().ek(j);
                if (ek.field_type == 49) {
                    boolean dE = m.dE(ek.field_talker);
                    String str2 = ek.field_content;
                    int i = ek.field_isSend;
                    if (dE && str2 != null && i == 0) {
                        str2 = aw.fM(str2);
                    }
                    com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(str2);
                    if (dV.type == 3) {
                        return com.tencent.mm.pluginsdk.model.app.g.l(aa.getContext(), 16);
                    }
                    if (dV.type == 4) {
                        return com.tencent.mm.pluginsdk.model.app.g.l(aa.getContext(), 8);
                    }
                }
            }
            return false;
        }

        public final void EL(String str) {
            int i = 0;
            if (com.tencent.mm.sdk.platformtools.o.JZ(str)) {
                com.tencent.mm.storage.a.c rg = com.tencent.mm.pluginsdk.j.a.bmr().rg(com.tencent.mm.a.g.aX(str));
                if (rg == null || !rg.bxE()) {
                    rg = com.tencent.mm.pluginsdk.j.a.bmr().rg(com.tencent.mm.pluginsdk.j.a.bmr().rh(str));
                }
                if (rg != null) {
                    i = com.tencent.mm.a.e.aQ(rg.dR(rg.field_groupId, rg.EB()));
                }
                if (i > com.tencent.mm.h.b.sJ()) {
                    com.tencent.mm.ui.base.g.a(aa.getContext(), this.lhL.getString(2131232336), "", this.lhL.getString(2131233285), null);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Retr_File_Name", rg.EB());
                intent.putExtra("Retr_Msg_Type", 5);
                intent.putExtra("Retr_MsgImgScene", 1);
                intent.addFlags(268435456);
                com.tencent.mm.plugin.webview.a.a.drp.l(intent, this.lhL);
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("Retr_File_Name", str);
            intent2.putExtra("Retr_Compress_Type", 0);
            intent2.putExtra("Retr_Msg_Type", 0);
            intent2.addFlags(268435456);
            com.tencent.mm.plugin.webview.a.a.drp.l(intent2, this.lhL);
        }

        public final String getLanguage() {
            return com.tencent.mm.sdk.platformtools.u.dJ(aa.getContext());
        }

        public final String bjx() {
            gl glVar = new gl();
            com.tencent.mm.sdk.c.a.nhr.z(glVar);
            return glVar.bfX.url;
        }

        public final Map bjy() {
            boolean uM = ak.uM();
            v.i("MicroMsg.WebViewStubService", "getConfigListMap, needSetUin = " + uM);
            if (uM) {
                return (Map) new az<Map>(this) {
                    final /* synthetic */ AnonymousClass1 lhM;

                    {
                        this.lhM = r4;
                    }

                    protected final /* synthetic */ Object run() {
                        return com.tencent.mm.h.j.sV().sT();
                    }
                }.c(this.lhL.handler);
            }
            return com.tencent.mm.h.j.sV().sT();
        }

        public final String db(String str, String str2) {
            return "";
        }

        public final int uQ() {
            return ak.uQ();
        }

        public final int bjz() {
            ak.yW();
            return be.f((Integer) com.tencent.mm.model.c.vf().get(12304, null));
        }

        public final void bjA() {
            Intent intent = new Intent();
            ak.yW();
            String str = (String) com.tencent.mm.model.c.vf().get(2, null);
            intent.setFlags(268435456);
            intent.putExtra("sns_userName", str);
            intent.addFlags(67108864);
            ak.yW();
            int a = be.a((Integer) com.tencent.mm.model.c.vf().get(68389, null), 0);
            ak.yW();
            com.tencent.mm.model.c.vf().set(68389, Integer.valueOf(a + 1));
            intent.setClassName(aa.getContext(), "com.tencent.mm.plugin.sns.ui.SnsUserUI");
            this.lhL.startActivity(intent);
        }

        public final void bjB() {
            if (((com.tencent.mm.model.k.xQ() & 32768) == 0) && com.tencent.mm.ay.c.EH("sns")) {
                Intent intent = new Intent();
                intent.setFlags(268435456);
                intent.addFlags(67108864);
                intent.setClassName(aa.getContext(), "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI");
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                this.lhL.startActivity(intent);
            }
        }

        public final void sL(int i) {
            Iterator it;
            String str;
            if (this.lhL.bed.size() == 0) {
                en enVar = new en();
                enVar.bdc.bdf = 2;
                com.tencent.mm.sdk.c.a.nhr.z(enVar);
                eh ehVar = new eh();
                ehVar.bcF.op = 2;
                com.tencent.mm.sdk.c.a.nhr.z(ehVar);
                ek ekVar = new ek();
                ekVar.bcM.op = 2;
                com.tencent.mm.sdk.c.a.nhr.z(ekVar);
            }
            com.tencent.mm.plugin.webview.ui.tools.jsapi.i tl = j.tl(i);
            v.d("MicroMsg.MsgHandler", "onWebViewUIDestroy");
            if (tl.blv()) {
                x DW = com.tencent.mm.plugin.webview.e.e.bjd().DW(tl.lpK);
                if (DW != null) {
                    ad.o(new AnonymousClass32(tl, DW));
                }
            }
            Entry entry;
            String str2;
            if ((tl.bjG() == 8 || tl.bjG() == -1) && tl.aLC() != 27) {
                if (tl.bjG() == 8) {
                    if (tl.lpl == null || tl.lpl.isEmpty()) {
                        v.i("MicroMsg.MsgHandler", "Not hard biz, or no ble device connection, just return");
                    } else {
                        it = tl.lpl.entrySet().iterator();
                        if (it != null) {
                            while (it.hasNext()) {
                                entry = (Entry) it.next();
                                str2 = (String) entry.getKey();
                                str = (String) entry.getValue();
                                v.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", new Object[]{str2, str});
                                ci ciVar = new ci();
                                ciVar.aZZ.bab = str2;
                                ciVar.aZZ.aRh = str;
                                com.tencent.mm.sdk.c.a.nhr.z(ciVar);
                                if (!ciVar.baa.aZW) {
                                    try {
                                        cg cgVar = new cg();
                                        cgVar.aZS.aZV = false;
                                        cgVar.aZS.aZU = str2;
                                        cgVar.aZS.aRh = str;
                                        com.tencent.mm.sdk.c.a.nhr.z(cgVar);
                                        v.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                                    } catch (Throwable e) {
                                        v.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                                        v.a("MicroMsg.MsgHandler", e, "", new Object[0]);
                                    }
                                }
                            }
                        }
                        tl.lpl.clear();
                    }
                }
            } else if ((tl.lpm == null || tl.lpm.isEmpty()) && (tl.lpl == null || tl.lpl.isEmpty())) {
                v.i("MicroMsg.MsgHandler", "No exdevice connection, just return");
            } else {
                if (!(tl.lpm == null || tl.lpm.isEmpty())) {
                    for (Entry entry2 : tl.lpm.entrySet()) {
                        v.i("MicroMsg.MsgHandler", "Remove wifi devices, srcUserName(%s), deviceId(%s)", new Object[]{(String) entry2.getKey(), (String) entry2.getValue()});
                        try {
                            ch chVar = new ch();
                            chVar.aZX.aZV = false;
                            chVar.aZX.aZU = str2;
                            chVar.aZX.aRh = str;
                            com.tencent.mm.sdk.c.a.nhr.z(chVar);
                            v.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                        } catch (Throwable e2) {
                            v.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                            v.a("MicroMsg.MsgHandler", e2, "", new Object[0]);
                        }
                    }
                    tl.lpm.clear();
                }
                if (!(tl.lpl == null || tl.lpl.isEmpty())) {
                    boolean z;
                    ci ciVar2;
                    cg cgVar2;
                    Iterator it2 = tl.lpl.entrySet().iterator();
                    str = tl.blu();
                    if (!be.kS(str)) {
                        BizInfo hw = com.tencent.mm.modelbiz.e.hw(str);
                        if (hw != null) {
                            ExtInfo aX = hw.aX(false);
                            if (!(aX == null || aX.CR() == null || !aX.CR().Da())) {
                                z = true;
                                v.i("MicroMsg.MsgHandler", "Is in hard biz(%b)", new Object[]{Boolean.valueOf(z)});
                                if (it2 != null) {
                                    while (it2.hasNext()) {
                                        entry2 = (Entry) it2.next();
                                        str2 = (String) entry2.getKey();
                                        str = (String) entry2.getValue();
                                        v.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", new Object[]{str2, str});
                                        if (z) {
                                            ciVar2 = new ci();
                                            ciVar2.aZZ.bab = str2;
                                            ciVar2.aZZ.aRh = str;
                                            com.tencent.mm.sdk.c.a.nhr.z(ciVar2);
                                            if (ciVar2.baa.aZW) {
                                            }
                                        }
                                        try {
                                            cgVar2 = new cg();
                                            cgVar2.aZS.aZV = false;
                                            cgVar2.aZS.aZU = str2;
                                            cgVar2.aZS.aRh = str;
                                            com.tencent.mm.sdk.c.a.nhr.z(cgVar2);
                                            v.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                                        } catch (Throwable e22) {
                                            v.e("MicroMsg.MsgHandler", "ExDeviceConnectDeviceEvent publish failed");
                                            v.a("MicroMsg.MsgHandler", e22, "", new Object[0]);
                                        }
                                    }
                                }
                                tl.lpl.clear();
                            }
                        }
                    }
                    z = false;
                    v.i("MicroMsg.MsgHandler", "Is in hard biz(%b)", new Object[]{Boolean.valueOf(z)});
                    if (it2 != null) {
                        while (it2.hasNext()) {
                            entry2 = (Entry) it2.next();
                            str2 = (String) entry2.getKey();
                            str = (String) entry2.getValue();
                            v.i("MicroMsg.MsgHandler", "Remove ble devices, srcUserName(%s), deviceId(%s)", new Object[]{str2, str});
                            if (z) {
                                ciVar2 = new ci();
                                ciVar2.aZZ.bab = str2;
                                ciVar2.aZZ.aRh = str;
                                com.tencent.mm.sdk.c.a.nhr.z(ciVar2);
                                if (ciVar2.baa.aZW) {
                                }
                            }
                            cgVar2 = new cg();
                            cgVar2.aZS.aZV = false;
                            cgVar2.aZS.aZU = str2;
                            cgVar2.aZS.aRh = str;
                            com.tencent.mm.sdk.c.a.nhr.z(cgVar2);
                            v.i("MicroMsg.MsgHandler", "Publish ExDeviceConnectDeviceEvent");
                        }
                    }
                    tl.lpl.clear();
                }
            }
            com.tencent.mm.plugin.webview.d.e bib = a.ldT;
            if (be.bP(bib.ldQ)) {
                v.d("MicroMsg.WebView.JsLogHelper", "not kv stat cached, no need to doReport, skip");
            } else if (ak.uz()) {
                List list;
                bib.ldN = com.tencent.mm.h.j.sU().getInt("MMUxAdLog2GSendSize", 20480);
                bib.ldO = com.tencent.mm.h.j.sU().getInt("MMUxAdLog3GSendSize", 30720);
                bib.ldP = com.tencent.mm.h.j.sU().getInt("MMUxAdLogWifiSendSize", 51200);
                v.d("MicroMsg.WebView.JsLogHelper", "readDynamicSendSize, 2g(%d), 3g(%d), wifi(%d)", new Object[]{Integer.valueOf(bib.ldN), Integer.valueOf(bib.ldO), Integer.valueOf(bib.ldP)});
                Collection<afi> collection = bib.ldQ;
                if (be.bP(collection)) {
                    v.d("MicroMsg.WebView.JsLogHelper", "no need to split, existings is empty");
                    list = null;
                } else {
                    afi com_tencent_mm_protocal_c_afi;
                    int i2;
                    v.d("MicroMsg.WebView.JsLogHelper", "begin split >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    v.d("MicroMsg.WebView.JsLogHelper", "before split, given list:");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.setLength(0);
                    stringBuilder.append("{ ");
                    for (afi com_tencent_mm_protocal_c_afi2 : collection) {
                        stringBuilder.append(com_tencent_mm_protocal_c_afi2.mFd).append(", ");
                    }
                    stringBuilder.append(" }");
                    v.d("MicroMsg.WebView.JsLogHelper", stringBuilder.toString());
                    if (be.az(bib.ldS) >= 100 || bib.ldR <= 0) {
                        bib.ldS = SystemClock.elapsedRealtime();
                        int i3;
                        if (com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
                            i3 = bib.ldP;
                            bib.ldR = i3;
                            i2 = i3;
                        } else if (com.tencent.mm.sdk.platformtools.ak.is3G(aa.getContext()) || com.tencent.mm.sdk.platformtools.ak.is4G(aa.getContext())) {
                            i3 = bib.ldO;
                            bib.ldR = i3;
                            i2 = i3;
                        } else {
                            com.tencent.mm.sdk.platformtools.ak.is2G(aa.getContext());
                            i3 = bib.ldN;
                            bib.ldR = i3;
                            i2 = i3;
                        }
                    } else {
                        i2 = bib.ldR;
                    }
                    LinkedList linkedList = new LinkedList();
                    linkedList.addAll(collection);
                    List<List> linkedList2 = new LinkedList();
                    int i4 = 0;
                    LinkedList linkedList3 = null;
                    while (linkedList.size() > 0) {
                        if (i4 <= 0) {
                            linkedList3 = new LinkedList();
                            com_tencent_mm_protocal_c_afi2 = (afi) linkedList.remove();
                            i4 += com_tencent_mm_protocal_c_afi2.mFe.lVU.length;
                            linkedList3.add(com_tencent_mm_protocal_c_afi2);
                            linkedList2.add(linkedList3);
                        } else if (((afi) linkedList.peek()).mFe.lVU.length + i4 >= i2) {
                            i4 = 0;
                        } else {
                            com_tencent_mm_protocal_c_afi2 = (afi) linkedList.remove();
                            i4 += com_tencent_mm_protocal_c_afi2.mFe.lVU.length;
                            linkedList3.add(com_tencent_mm_protocal_c_afi2);
                        }
                    }
                    v.d("MicroMsg.WebView.JsLogHelper", "split result: ");
                    for (List<afi> list2 : linkedList2) {
                        stringBuilder.setLength(0);
                        stringBuilder.append("{ ");
                        for (afi com_tencent_mm_protocal_c_afi22 : list2) {
                            stringBuilder.append(com_tencent_mm_protocal_c_afi22.mFd).append(", ");
                        }
                        stringBuilder.append(" }");
                        v.d("MicroMsg.WebView.JsLogHelper", stringBuilder.toString());
                        v.d("MicroMsg.WebView.JsLogHelper", "---------------------------");
                    }
                    v.d("MicroMsg.WebView.JsLogHelper", "end split <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    list = linkedList2;
                }
                if (be.bP(r1)) {
                    v.d("MicroMsg.WebView.JsLogHelper", "split result empty, skip");
                } else {
                    for (List list3 : r1) {
                        if (!be.bP(list3)) {
                            v.d("MicroMsg.WebView.JsLogHelper", "trigger do scene");
                            ak.vy().a(new p(list3), 0);
                        }
                    }
                    bib.ldQ.clear();
                }
            } else {
                v.i("MicroMsg.WebView.JsLogHelper", "doReport(), acc not ready, skip");
            }
            if (tl.lpj != null) {
                tl.lpj.setClassLoader(tl.getClass().getClassLoader());
            }
            if (tl.lpj != null) {
                Parcelable parcelable = tl.lpj.getParcelable("KSnsAdTag");
                if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                    SnsAdClick snsAdClick = (SnsAdClick) parcelable;
                    lk lkVar = new lk();
                    lkVar.bmN.bmO = 1;
                    lkVar.bmN.bmB = snsAdClick;
                    com.tencent.mm.sdk.c.a.nhr.z(lkVar);
                }
            }
            if (tl.lpj != null) {
                com.tencent.mm.modelsns.a m = com.tencent.mm.modelsns.a.m(tl.lpj);
                if (m != null) {
                    m.update();
                    m.JF();
                }
            }
            for (String str3 : tl.lpJ.keySet()) {
                if (!be.kS(str3)) {
                    com.tencent.mm.plugin.webview.e.e.bjc();
                    com.tencent.mm.plugin.webview.d.w.DR(str3);
                    a aVar = (a) tl.lpJ.get(str3);
                    if (aVar != null) {
                        if (aVar.lqU != null) {
                            com.tencent.mm.plugin.webview.e.e.bjc().a(aVar.lqU);
                        }
                        if (aVar.lpf != null) {
                            tl.a(aVar.lpf, "uploadVideo:cancel", null, false, true);
                        }
                    }
                }
            }
            tl.lpJ.clear();
            for (com.tencent.mm.pluginsdk.ui.tools.r.a aVar2 : r.brd()) {
                v.i("MicroMsg.MsgHandler", "onWebViewUIDestroy, stop plugin = " + aVar2.getName());
                aVar2.bkO();
            }
            r.clear();
            com.tencent.mm.sdk.c.a.nhr.f(tl.iSE);
            com.tencent.mm.sdk.c.a.nhr.f(tl.lpI);
            if (ak.uz()) {
                ak.yW();
                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nrq, Boolean.valueOf(false));
            }
            Editor edit = aa.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", false);
            edit.commit();
            tl.lpg = null;
            tl.lpH = null;
            tl.b(tl.lpf, new int[0]);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.i.lpq = null;
            if (com.tencent.mm.plugin.webview.ui.tools.jsapi.i.lpr != -1) {
                tl.lpf = tl.th(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.lpr).lpf;
                tl.lpf = null;
                tl.leB = tl.th(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.lpr).leB;
                tl.leB = null;
            }
            tl.lpo = null;
            tl.lpM.clear();
            com.tencent.mm.plugin.webview.modelcache.w biP = b.lgu;
            List list4 = tl.lpL;
            if (!(com.tencent.mm.compatible.d.w.sb() == 0 || !ak.uz() || be.bP(list4))) {
                biP.vA().x(new AnonymousClass5(biP, list4));
            }
            b.lgu.sL(tl.bkE);
        }

        public final void bm(String str, int i) {
            Bundle bundle = new Bundle();
            bundle.putString("proxyui_phone", str);
            WebViewStubService.a(this.lhL, 8, bundle, i);
        }

        public final boolean bjC() {
            return com.tencent.mm.model.k.xT();
        }

        public final void EM(String str) {
            if (this.lhL.lhG == null) {
                this.lhL.lhG = new HashMap();
                com.tencent.mm.sdk.c.a.nhr.e(this.lhL.cND);
            }
            kt ktVar = new kt();
            ktVar.bmc.filePath = str;
            com.tencent.mm.sdk.c.a.nhr.z(ktVar);
            this.lhL.lhG.put(str, Integer.valueOf(1));
        }

        public final void EN(String str) {
            if (this.lhL.lhG == null || !this.lhL.lhG.containsKey(str)) {
                v.e("MicroMsg.WebViewStubService", "%s is not recognizing", new Object[]{str});
                return;
            }
            ae aeVar = new ae();
            aeVar.aXI.filePath = str;
            com.tencent.mm.sdk.c.a.nhr.z(aeVar);
            this.lhL.lhG.remove(str);
        }

        public final void j(String str, String str2, int i, int i2) {
            if (str != null) {
                Intent intent = new Intent();
                intent.setClass(aa.getContext(), WebviewScanImageActivity.class);
                intent.setFlags(872415232);
                intent.putExtra("key_string_for_scan", str);
                intent.putExtra("key_string_for_url", str2);
                intent.putExtra("key_codetype_for_scan", i);
                intent.putExtra("key_codeversion_for_scan", i2);
                aa.getContext().startActivity(intent);
            }
        }

        public final String EO(String str) {
            String str2 = "";
            com.tencent.mm.pluginsdk.d.Ge(str);
            return str2;
        }

        public final boolean bjD() {
            if (AnonymousClass1.lR("EnableWebviewScanQRCode") == 1) {
                return true;
            }
            return false;
        }

        private static int lR(String str) {
            int i = 1;
            try {
                i = be.getInt(com.tencent.mm.h.j.sU().getValue(str), 1);
            } catch (Exception e) {
                v.e("MicroMsg.WebViewStubService", "getIntValFromDynamicConfig parseInt failed, val: " + str);
            }
            return i;
        }

        public final void sQ(int i) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.i tl = j.tl(i);
            Context context = this.lhL;
            for (com.tencent.mm.pluginsdk.ui.tools.r.a aVar : r.brd()) {
                v.i("MicroMsg.MsgHandler", "onWebViewUIResume, resume plugin = " + aVar.getName());
                aVar.cP(context);
            }
            tl.lpt = false;
        }

        public final void sR(int i) {
            j.tl(i);
            for (com.tencent.mm.pluginsdk.ui.tools.r.a aVar : r.brd()) {
                v.i("MicroMsg.MsgHandler", "onWebViewUIPause, pause plugin = " + aVar.getName());
                aVar.bkP();
            }
        }

        public final Bundle i(int i, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            String ma;
            String str;
            long j;
            int i2;
            long j2;
            com.tencent.mm.storage.c cVar;
            switch (i) {
                case an.CTRL_INDEX /*14*/:
                    if (bundle == null) {
                        return null;
                    }
                    ma = be.ma(bundle.getString("task_url"));
                    v.i("MicroMsg.WebViewStubService", "add download task, taskurl = %s, taskname = %s", new Object[]{ma, bundle.getString("task_name")});
                    if (be.kS(ma)) {
                        v.e("MicroMsg.WebViewStubService", "download url is null or nil");
                        return null;
                    }
                    com.tencent.mm.pluginsdk.model.downloader.e.a aVar = new com.tencent.mm.pluginsdk.model.downloader.e.a();
                    aVar.GQ(ma);
                    aVar.GR(str);
                    aVar.hO(true);
                    aVar.tE(1);
                    v.i("MicroMsg.WebViewStubService", "add download task, downloadId = %d", new Object[]{Long.valueOf(com.tencent.mm.pluginsdk.model.downloader.d.bnK().a(aVar.lCn))});
                    bundle = new Bundle();
                    bundle.putLong("download_id", j);
                    return bundle;
                case am.CTRL_INDEX /*15*/:
                    com.tencent.mm.pluginsdk.model.downloader.f dn = com.tencent.mm.pluginsdk.model.downloader.d.bnK().dn(bundle.getLong("download_id", 0));
                    String str2 = "MicroMsg.WebViewStubService";
                    String str3 = "query download task info, info == null ? %b task state = %d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(dn == null);
                    if (dn == null) {
                        i2 = 0;
                    } else {
                        i2 = dn.status;
                    }
                    objArr[1] = Integer.valueOf(i2);
                    v.i(str2, str3, objArr);
                    i2 = 0;
                    if (dn != null) {
                        i2 = dn.status;
                    }
                    v.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", new Object[]{Long.valueOf(j2), Integer.valueOf(i2)});
                    bundle = new Bundle();
                    bundle.putInt("download_state", i2);
                    return bundle;
                case 16:
                    v.i("MicroMsg.WebViewStubService", "query download task, task id = %d, ret = %d", new Object[]{Long.valueOf(bundle.getLong("download_id", 0)), Integer.valueOf(com.tencent.mm.pluginsdk.model.downloader.d.bnK().dm(bundle.getLong("download_id", 0)))});
                    bundle = new Bundle();
                    bundle.putBoolean("cancel_result", com.tencent.mm.pluginsdk.model.downloader.d.bnK().dm(bundle.getLong("download_id", 0)) > 0);
                    return bundle;
                case 17:
                    com.tencent.mm.pluginsdk.model.downloader.f dn2 = com.tencent.mm.pluginsdk.model.downloader.d.bnK().dn(bundle.getLong("download_id"));
                    bundle = new Bundle();
                    if (dn2 == null) {
                        v.e("MicroMsg.WebViewStubService", "install download task fail, get download task info failed");
                        bundle.putBoolean("install_result", false);
                        return bundle;
                    } else if (dn2.status != 3) {
                        v.e("MicroMsg.WebViewStubService", "install download task fail, invalid status = " + dn2.status);
                        bundle.putBoolean("install_result", false);
                        return bundle;
                    } else if (com.tencent.mm.a.e.aR(dn2.path)) {
                        bundle.putBoolean("install_result", com.tencent.mm.pluginsdk.model.app.p.c(this.lhL, Uri.fromFile(new File(dn2.path))));
                        return bundle;
                    } else {
                        v.e("MicroMsg.WebViewStubService", "file not exists : %s", new Object[]{dn2.path});
                        bundle.putBoolean("install_result", false);
                        return bundle;
                    }
                case 19:
                    bundle = new Bundle();
                    bundle.putBoolean("webview_video_proxy_init", ag.bim().hasInit);
                    return bundle;
                case 23:
                    boolean uz = ak.uz();
                    AnonymousClass15 anonymousClass15 = new az<String>(this) {
                        final /* synthetic */ AnonymousClass1 lhM;

                        {
                            this.lhM = r4;
                        }

                        protected final /* synthetic */ Object run() {
                            return !ak.uz() ? "" : com.tencent.mm.model.k.xF();
                        }
                    };
                    if (uz) {
                        ma = (String) anonymousClass15.c(null);
                    } else {
                        ma = (String) anonymousClass15.c(this.lhL.handler);
                    }
                    bundle = new Bundle();
                    bundle.putString("config_info_username", ma);
                    return bundle;
                case 24:
                    bundle = new Bundle();
                    cVar = null;
                    try {
                        cVar = com.tencent.mm.model.c.c.Au().Ls(com.tencent.mm.plugin.webview.e.b.lgF);
                    } catch (AssertionFailedError e) {
                        v.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, acc stg is null");
                    } catch (com.tencent.mm.model.b e2) {
                        v.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: getHostList, uin invalid");
                    }
                    if (cVar == null || !cVar.isValid()) {
                        v.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: dbItem(%s) invalid", new Object[]{cVar});
                        return bundle;
                    }
                    Map buX = cVar.buX();
                    j2 = be.getLong((String) buX.get("interval"), 0);
                    long Nh = be.Nh();
                    ak.yW();
                    v.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: nextQuerySeconds(%d), now(%d), interval(%d)", new Object[]{Long.valueOf(be.d((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nrl, null))), Long.valueOf(Nh), Long.valueOf(j2)});
                    if (be.d((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nrl, null)) >= Nh) {
                        v.i("MicroMsg.WebViewStubService", "WebViewCookiesCleanup: not exceed interval, skip");
                        return bundle;
                    }
                    j2 += Nh;
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nrl, Long.valueOf(j2));
                    int i3 = be.getInt((String) buX.get("urlCount"), 0);
                    ArrayList arrayList = new ArrayList(i3);
                    for (i2 = 0; i2 < i3; i2++) {
                        arrayList.add(buX.get(String.format("url%d", new Object[]{Integer.valueOf(i2)})));
                    }
                    bundle.putStringArrayList("cookies_cleanup_url_list", arrayList);
                    return bundle;
                case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                    if (!com.tencent.mm.plugin.webview.modelcache.c.biH()) {
                        bundle = new Bundle(1);
                        bundle.putBoolean("webview_resource_cache_inWhiteList", false);
                        return bundle;
                    } else if (bundle == null) {
                        return null;
                    } else {
                        h hVar;
                        if (bundle == null) {
                            hVar = null;
                        } else {
                            byte[] byteArray = bundle.getByteArray("webview_resource_cache_requestURL");
                            byte[] byteArray2 = bundle.getByteArray("webview_resource_cache_mainDocURL");
                            hVar = (be.bl(byteArray) || be.bl(byteArray2)) ? null : new h(new String(q.p(byteArray)), new String(q.p(byteArray2)), bundle.getInt("webview_resource_cache_binderId"));
                        }
                        if (hVar == null) {
                            return null;
                        }
                        str = hVar.lfE;
                        String str4 = hVar.lfC;
                        if (be.kS(str)) {
                            v.e("MicroMsg.WebViewStubService", "queryWebViewCacheResource, mainDocumentURL is null or nil, return null");
                            return null;
                        } else if (com.tencent.mm.plugin.webview.modelcache.v.Ei(str)) {
                            String FA = j.tl(hVar.ldX).FA(str);
                            if (str.startsWith("http://")) {
                                i2 = com.tencent.mm.plugin.webview.modelcache.b.a.sG(com.tencent.mm.plugin.webview.modelcache.b.a.sH(0));
                            } else {
                                i2 = com.tencent.mm.plugin.webview.modelcache.b.a.sH(0);
                            }
                            com.tencent.mm.plugin.webview.modelcache.w biP = b.lgu;
                            if (biP.lgf == null) {
                                biP.lgf = new n();
                            }
                            com.tencent.mm.plugin.webview.modelcache.q d = biP.lgf.d(FA, str, str4, i2);
                            if (d == null) {
                                return null;
                            }
                            bundle = new Bundle(6);
                            bundle.putString("webview_resource_cache_appId", d.appId);
                            bundle.putString("webview_resource_cache_domain", d.bsI);
                            bundle.putString("webview_resource_cache_filePath", d.filePath);
                            bundle.putLong("webview_resource_cache_contentLength", d.bsM);
                            bundle.putString("webview_resource_cache_contentType", d.bsL);
                            bundle.putInt("webview_resource_cache_cacheType", d.bsK);
                            return bundle;
                        } else {
                            v.e("MicroMsg.WebViewStubService", "queryWebViewCacheResource, mainDocumentURL = %s, unsupported scheme, return nul");
                            return null;
                        }
                    }
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    if (!ak.uz()) {
                        return null;
                    }
                    cVar = com.tencent.mm.model.c.c.Au().Ls("100036");
                    if (cVar.isValid()) {
                        Map buX2 = cVar.buX();
                        bundle = new Bundle();
                        i2 = be.getInt((String) buX2.get("controlFlag"), 0);
                        bundle.putInt("webview_ad_intercept_control_flag", i2);
                        if (i2 == 0) {
                            v.i("MicroMsg.WebViewStubService", "control flag = 0, ignore get black list and white list");
                            return bundle;
                        }
                        int i4;
                        int i5 = be.getInt((String) buX2.get("blackListCount"), 0);
                        ArrayList arrayList2 = new ArrayList();
                        for (i4 = 0; i4 < i5; i4++) {
                            ma = (String) buX2.get("blackList" + (i4 + 1));
                            if (!(be.kS(ma) || arrayList2.contains(ma))) {
                                v.i("MicroMsg.WebViewStubService", "add black list domin = %s", new Object[]{ma});
                                arrayList2.add(ma);
                            }
                        }
                        i5 = be.getInt((String) buX2.get("whiteListCount"), 0);
                        ArrayList arrayList3 = new ArrayList();
                        for (i4 = 0; i4 < i5; i4++) {
                            ma = (String) buX2.get("whiteList" + (i4 + 1));
                            if (!(be.kS(ma) || arrayList3.contains(ma))) {
                                v.i("MicroMsg.WebViewStubService", "add white list domin = %s", new Object[]{ma});
                                arrayList3.add(ma);
                            }
                        }
                        bundle.putStringArrayList("webview_ad_intercept_blacklist_domins", arrayList2);
                        bundle.putStringArrayList("webview_ad_intercept_whitelist_domins", arrayList3);
                        return bundle;
                    }
                    v.d("MicroMsg.WebViewStubService", "test is valid");
                    return null;
                case 50:
                    if (bundle == null) {
                        return null;
                    }
                    ma = bundle.getString("data");
                    if (ma == null) {
                        return null;
                    }
                    bundle = new Bundle();
                    bundle.putInt("key_biz_type", com.tencent.mm.modelbiz.e.hw(ma).field_type);
                    return bundle;
                case com.tencent.mm.plugin.appbrand.jsapi.file.d.CTRL_INDEX /*51*/:
                case JsApiLogin.CTRL_INDEX /*52*/:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case EncrptType.VERIFY_CODE /*60*/:
                case 61:
                case ao.CTRL_INDEX /*62*/:
                case 64:
                case bs.CTRL_INDEX /*65*/:
                case bb.CTRL_INDEX /*66*/:
                case com.tencent.mm.plugin.appbrand.jsapi.aj.CTRL_INDEX /*67*/:
                case com.tencent.mm.plugin.appbrand.jsapi.at.CTRL_INDEX /*68*/:
                case com.tencent.mm.plugin.appbrand.jsapi.q.CTRL_INDEX /*69*/:
                case com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX /*70*/:
                    com.tencent.mm.plugin.webview.e.e.bjb().n(i, bundle);
                    return bundle;
                case com.tencent.mm.plugin.appbrand.jsapi.az.CTRL_INDEX /*63*/:
                    j = bundle.getLong("msgId", -1);
                    bp bpVar = new bp();
                    com.tencent.mm.pluginsdk.model.d.a(bpVar, j);
                    com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                    bundle.putInt("ret", bpVar.aZe.ret);
                    return bundle;
                case 71:
                    if (bundle == null) {
                        return null;
                    }
                    ma = bundle.getString("enterprise_action");
                    bundle = new Bundle();
                    if (ma.equals("enterprise_has_connector")) {
                        str = "enterprise_has_connector";
                        u.Dy();
                        bundle.putBoolean(str, d.Dd().size() > 0);
                        return bundle;
                    } else if (!ma.equals("enterprise_connectors")) {
                        return bundle;
                    } else {
                        u.Dy();
                        Collection Dd = d.Dd();
                        if (Dd == null) {
                            return bundle;
                        }
                        bundle.putStringArrayList("enterprise_connectors", new ArrayList(Dd));
                        return bundle;
                    }
                case 75:
                    ag bim = ag.bim();
                    if (bim.hasInit) {
                        bim.leB = null;
                        ag.leA = null;
                        bim.hasInit = false;
                    }
                    return null;
                case 76:
                    if (bundle == null) {
                        return Bundle.EMPTY;
                    }
                    bundle2 = new Bundle();
                    bundle2.putString("appId", j.tl(bundle.getInt("webview_binder_id")).FA(be.ma(bundle.getString("rawUrl"))));
                    return bundle2;
                case 4006:
                    bundle = new Bundle();
                    ma = aa.btl().getString("nfc_open_url", null);
                    v.i("MicroMsg.WebViewStubService", "nfc url=" + be.ma(ma));
                    if (!(be.kS(ma) || be.kS(ma.trim()))) {
                        bundle.putString("debugConfig", ma);
                    }
                    ak.yW();
                    bundle.putString("config", (String) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nqh, null));
                    return bundle;
                case 10001:
                    StringBuilder stringBuilder = new StringBuilder("kwid_");
                    ak.yW();
                    com.tencent.mm.t.b.jHs = stringBuilder.append(com.tencent.mm.model.c.ww()).append("_").append(be.Ni()).toString();
                    v.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchKeywordId : %s", new Object[]{com.tencent.mm.t.b.jHs});
                    break;
                default:
                    v.e("MicroMsg.WebViewStubService", "unknown action = %d", new Object[]{Integer.valueOf(i)});
                    break;
            }
            return bundle2;
        }

        public final boolean bjE() {
            if (!ak.uN() || ak.uG()) {
                return true;
            }
            return false;
        }

        public final void N(Intent intent) {
            Intent intent2 = new Intent(this.lhL, WebViewStubProxyUI.class);
            intent2.putExtra("proxyui_action_code_key", 9);
            intent2.putExtra("proxyui_next_intent_key", intent);
            intent2.setFlags(268435456);
            this.lhL.startActivity(intent2);
        }

        public final void w(int i, String str, String str2) {
            x aaVar = new com.tencent.mm.plugin.webview.d.aa();
            aaVar.fileType = i;
            aaVar.let = str;
            aaVar.lel = str2;
            aaVar.bih();
            aaVar.mediaId = com.tencent.mm.modelcdntran.d.a("jsupfile", be.Ni(), aaVar.bde, aaVar.bde);
            v.d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", new Object[]{Integer.valueOf(i), str2, aaVar.bde});
            aaVar.leq = false;
            com.tencent.mm.plugin.webview.e.e.bjd().b(aaVar);
            com.tencent.mm.plugin.webview.e.e.bjc().b(null, aaVar.bde, null);
        }

        public final List<String> bjF() {
            com.tencent.mm.plugin.webview.e.e.biX();
            com.tencent.mm.plugin.webview.e.h bje = com.tencent.mm.plugin.webview.e.e.bje();
            long Nh = be.Nh();
            v.d("MicroMsg.WebViewStorage", "webview hijack deleteExpiredItem now = " + Nh);
            boolean dF = bje.dF("WebViewHostsFilter", "delete from WebViewHostsFilter where expireTime < " + Nh);
            v.i("MicroMsg.WebViewStorage", "delete expired items request  : [%b]", new Object[]{Boolean.valueOf(dF)});
            Cursor query = bje.cie.query(bje.getTableName(), new String[]{"host"}, null, null, null, null, null);
            Collection hashSet = new HashSet();
            if (query == null || !query.moveToFirst()) {
                query.close();
                return new ArrayList(hashSet);
            }
            do {
                String string = query.getString(0);
                if (!be.kS(string)) {
                    hashSet.add(string);
                    v.d("MicroMsg.WebViewStorage", "webview hijack gethost = " + string);
                }
            } while (query.moveToNext());
            query.close();
            return new ArrayList(hashSet);
        }

        public final int bjG() {
            return com.tencent.mm.pluginsdk.wallet.f.bjG();
        }

        public final boolean bjH() {
            if (AnonymousClass1.lR("WebViewDownLoadFileSwitch") == 1) {
                return true;
            }
            return false;
        }

        public final String[] bjI() {
            String z = com.tencent.mm.h.j.sV().z("AsyncCheckUrl", "UrlHost");
            return !be.kS(z) ? z.split(";") : null;
        }
    };
    private Map<String, Integer> lhG;
    private int lhH = 0;
    private com.tencent.mm.pluginsdk.model.downloader.l lhI;
    private com.tencent.mm.plugin.webview.d.c.a lhJ;
    private Set<Integer> lhK = new HashSet();

    private static class a extends com.tencent.mm.plugin.webview.stub.b.a {
        public boolean aXR;
        public boolean lhT;
        public int ret;
        public int type;

        private a() {
        }

        public final boolean bjl() {
            return this.lhT;
        }

        public final boolean getResult() {
            return this.aXR;
        }

        public final int getRet() {
            return this.ret;
        }

        public final int getType() {
            return this.type;
        }
    }

    private static class b extends com.tencent.mm.plugin.webview.stub.c.a {
        public String biS;
        public int errCode;
        public int errType;
        public Bundle fNM;
        public int type;

        private b() {
        }

        public final int getType() {
            return this.type;
        }

        public final int bjm() {
            return this.errType;
        }

        public final int bjn() {
            return this.errCode;
        }

        public final String Ch() {
            return this.biS;
        }

        public final Bundle getData() {
            return this.fNM;
        }
    }

    static /* synthetic */ boolean EC(String str) {
        if (str == null) {
            v.e("MicroMsg.WebViewStubService", "doInActivity fail, function null");
        } else {
            com.tencent.mm.protocal.c.g Is = com.tencent.mm.protocal.c.Is(str);
            if (Is == null) {
                v.e("MicroMsg.WebViewStubService", "doInActivity fail, func null, %s", new Object[]{str});
            } else if (Is.brt()) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void a(WebViewStubService webViewStubService, int i, Bundle bundle, int i2) {
        Parcelable parcelable = null;
        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : webViewStubService.bed) {
            if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.id != i2) {
                Parcelable parcelable2 = parcelable;
            }
            Object obj = webViewStubCallbackWrapper;
        }
        Intent intent = new Intent(webViewStubService, WebViewStubProxyUI.class);
        intent.putExtras(bundle);
        intent.putExtra("proxyui_action_code_key", i);
        intent.putExtra("webview_stub_callbacker_key", parcelable);
        intent.putExtra("webview_binder_id", i2);
        intent.addFlags(268435456);
        webViewStubService.startActivity(intent);
    }

    static /* synthetic */ void a(WebViewStubService webViewStubService, String str, String str2, String str3, JsapiPermissionWrapper jsapiPermissionWrapper, Bundle bundle, int i) {
        Parcelable parcelable = null;
        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : webViewStubService.bed) {
            if (webViewStubCallbackWrapper == null || webViewStubCallbackWrapper.id != i) {
                Parcelable parcelable2 = parcelable;
            }
            Object obj = webViewStubCallbackWrapper;
        }
        Intent intent = new Intent(webViewStubService, WebViewStubProxyUI.class);
        intent.putExtras(bundle);
        intent.putExtra("proxyui_action_code_key", 1);
        intent.putExtra("proxyui_type_key", str);
        intent.putExtra("proxyui_function_key", str2);
        intent.putExtra("proxyui_callback_key", str3);
        intent.putExtra("webview_stub_callbacker_key", parcelable);
        intent.putExtra("proxyui_perm_key", jsapiPermissionWrapper);
        intent.putExtra("webview_binder_id", i);
        intent.addFlags(268435456);
        webViewStubService.startActivity(intent);
    }

    public void onCreate() {
        super.onCreate();
        v.i("MicroMsg.WebViewStubService", "WebViewStubService onCreate");
        this.handler = new ac();
        this.lhI = new com.tencent.mm.pluginsdk.model.downloader.l(this) {
            final /* synthetic */ WebViewStubService lhL;

            {
                this.lhL = r1;
            }

            public final void onTaskStarted(long j, String str) {
            }

            public final void g(long j, String str) {
                v.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, downloadId = " + j);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.lhL.bed) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        al dG = com.tencent.mm.pluginsdk.model.downloader.c.dG(j);
                        bundle.putCharSequence("download_manager_appid", dG != null ? dG.field_appId : "");
                        webViewStubCallbackWrapper.ljN.g(1002, bundle);
                    }
                } catch (Exception e) {
                    v.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFinished, ex = " + e.getMessage());
                }
            }

            public final void q(long j, int i) {
                v.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, downloadId = " + j);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.lhL.bed) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        al dG = com.tencent.mm.pluginsdk.model.downloader.c.dG(j);
                        bundle.putCharSequence("download_manager_appid", dG != null ? dG.field_appId : "");
                        webViewStubCallbackWrapper.ljN.g(1003, bundle);
                    }
                } catch (Exception e) {
                    v.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskFailed, ex = " + e.getMessage());
                }
            }

            public final void onTaskRemoved(long j) {
                v.i("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, downloadId = " + j);
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.lhL.bed) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        al dG = com.tencent.mm.pluginsdk.model.downloader.c.dG(j);
                        bundle.putCharSequence("download_manager_appid", dG != null ? dG.field_appId : "");
                        webViewStubCallbackWrapper.ljN.g(1008, bundle);
                    }
                } catch (Exception e) {
                    v.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskRemoved, ex = " + e.getMessage());
                }
            }

            public final void onTaskPaused(long j) {
            }

            public final void bV(long j) {
                try {
                    for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.lhL.bed) {
                        al dG = com.tencent.mm.pluginsdk.model.downloader.c.dG(j);
                        if (dG == null || dG.field_totalSize == 0) {
                            v.w("MicroMsg.WebViewUI.IFileDownloadCallback", "loadDownloadProgress failed, downloadId = " + j);
                            return;
                        }
                        int i = (int) ((((double) dG.field_downloadedSize) / ((double) dG.field_totalSize)) * 100.0d);
                        Bundle bundle = new Bundle();
                        bundle.putLong("download_manager_downloadid", j);
                        bundle.putInt("download_manager_progress", i);
                        bundle.putString("download_manager_appid", dG.field_appId);
                        webViewStubCallbackWrapper.ljN.g(1007, bundle);
                    }
                } catch (Exception e) {
                    v.w("MicroMsg.WebViewUI.IFileDownloadCallback", "onTaskProgressChanged, ex = " + e.getMessage());
                }
            }

            public final void bW(long j) {
            }
        };
        com.tencent.mm.pluginsdk.model.downloader.d.bnK();
        com.tencent.mm.pluginsdk.model.downloader.a.a(this.lhI);
        this.lhJ = new com.tencent.mm.plugin.webview.d.c.a(this) {
            final /* synthetic */ WebViewStubService lhL;

            {
                this.lhL = r1;
            }

            public final void a(boolean z, int i, int i2, String str, String str2) {
                Bundle bundle;
                v.i("MicroMsg.WebViewStubService", "onWebView cdn callback progress, upload : %b, mediaType : %d, percent : %d, localid : %s, mediaId : %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2});
                if (z) {
                    try {
                        bundle = new Bundle();
                        bundle.putString("webview_jssdk_file_item_local_id", str);
                        bundle.putInt("webview_jssdk_file_item_progreess", i2);
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.lhL.bed) {
                            webViewStubCallbackWrapper.ljN.g(2011, bundle);
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", new Object[]{e.getMessage()});
                    }
                }
                switch (i) {
                    case 1:
                        if (z) {
                            try {
                                bundle = new Bundle();
                                bundle.putString("webview_jssdk_file_item_local_id", str);
                                bundle.putInt("webview_jssdk_file_item_progreess", i2);
                                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : this.lhL.bed) {
                                    webViewStubCallbackWrapper2.ljN.g(2003, bundle);
                                }
                                return;
                            } catch (Exception e2) {
                                v.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", new Object[]{e2.getMessage()});
                                return;
                            }
                        }
                        try {
                            bundle = new Bundle();
                            bundle.putString("webview_jssdk_file_item_server_id", str2);
                            bundle.putInt("webview_jssdk_file_item_progreess", i2);
                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22 : this.lhL.bed) {
                                webViewStubCallbackWrapper22.ljN.g(2004, bundle);
                            }
                            return;
                        } catch (Exception e22) {
                            v.e("MicroMsg.WebViewStubService", "notify download image failed :%s", new Object[]{e22.getMessage()});
                            return;
                        }
                    case 2:
                        if (z) {
                            try {
                                bundle = new Bundle();
                                bundle.putString("webview_jssdk_file_item_local_id", str);
                                bundle.putInt("webview_jssdk_file_item_progreess", i2);
                                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper222 : this.lhL.bed) {
                                    webViewStubCallbackWrapper222.ljN.g(2005, bundle);
                                }
                                return;
                            } catch (Exception e222) {
                                v.e("MicroMsg.WebViewStubService", "notify upload voice failed :%s", new Object[]{e222.getMessage()});
                                return;
                            }
                        }
                        try {
                            bundle = new Bundle();
                            bundle.putString("webview_jssdk_file_item_server_id", str2);
                            bundle.putInt("webview_jssdk_file_item_progreess", i2);
                            for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2222 : this.lhL.bed) {
                                webViewStubCallbackWrapper2222.ljN.g(2006, bundle);
                            }
                            return;
                        } catch (Exception e2222) {
                            v.e("MicroMsg.WebViewStubService", "notify download voice failed :%s", new Object[]{e2222.getMessage()});
                            return;
                        }
                    case 4:
                        if (z) {
                            try {
                                bundle = new Bundle();
                                bundle.putString("webview_jssdk_file_item_local_id", str);
                                bundle.putInt("webview_jssdk_file_item_progreess", i2);
                                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22222 : this.lhL.bed) {
                                    webViewStubCallbackWrapper22222.ljN.g(2010, bundle);
                                }
                                return;
                            } catch (Exception e22222) {
                                v.e("MicroMsg.WebViewStubService", "notify upload video failed :%s", new Object[]{e22222.getMessage()});
                                return;
                            }
                        }
                        return;
                    default:
                        v.e("MicroMsg.WebViewStubService", "unsupport media type : %d", new Object[]{Integer.valueOf(i)});
                        return;
                }
            }
        };
        if (ak.uz()) {
            com.tencent.mm.plugin.webview.d.w bjc = com.tencent.mm.plugin.webview.e.e.bjc();
            com.tencent.mm.plugin.webview.d.c.a aVar = this.lhJ;
            if (bjc.lei != null && aVar != null && !bjc.lei.contains(aVar)) {
                bjc.lei.add(aVar);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        v.i("MicroMsg.WebViewStubService", "WebViewStubService onBind");
        return this.lhF;
    }

    public boolean onUnbind(Intent intent) {
        v.i("MicroMsg.WebViewStubService", "WebViewStubService onUnbind");
        j.detach();
        aj.clear();
        b.lgu.dj(false);
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        v.i("MicroMsg.WebViewStubService", "WebViewStubService onDestroy");
        super.onDestroy();
        com.tencent.mm.pluginsdk.model.downloader.d.bnK();
        com.tencent.mm.pluginsdk.model.downloader.a.b(this.lhI);
        if (ak.uz()) {
            com.tencent.mm.plugin.webview.d.w bjc = com.tencent.mm.plugin.webview.e.e.bjc();
            com.tencent.mm.plugin.webview.d.c.a aVar = this.lhJ;
            if (!(bjc.lei == null || aVar == null)) {
                bjc.lei.remove(aVar);
            }
        }
        this.lhI = null;
        this.bed.clear();
    }

    public final void a(int i, int i2, String str, k kVar) {
        int type = kVar.getType();
        v.i("MicroMsg.WebViewStubService", "onSceneEnd :[%d]", new Object[]{Integer.valueOf(type)});
        c bVar = new b();
        bVar.type = type;
        bVar.errType = i;
        bVar.errCode = i2;
        bVar.biS = str;
        String a;
        Bundle bundle;
        if (type == 106) {
            ak.vy().b(106, this);
            if (i == 0 && i2 == 0) {
                ars Jx = ((y) kVar).Jx();
                a = com.tencent.mm.platformtools.m.a(Jx.moM);
                com.tencent.mm.u.n.AX().g(a, com.tencent.mm.platformtools.m.a(Jx.mbY));
                Intent intent = new Intent();
                com.tencent.mm.pluginsdk.ui.tools.c.a(intent, Jx, 30);
                if (be.ma(a).length() > 0) {
                    ak.yW();
                    com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(a);
                    if (!(LX == null || com.tencent.mm.i.a.ei(LX.field_type))) {
                        intent.putExtra("Contact_IsLBSFriend", true);
                    }
                    if ((Jx.mFu & 8) > 0) {
                        g.iuh.Y(10298, a + ",30");
                    }
                    intent.addFlags(268435456);
                    com.tencent.mm.plugin.webview.a.a.drp.d(intent, this);
                    bundle = new Bundle();
                    bundle.putString("search_contact_result_user", a);
                    bVar.fNM = bundle;
                    try {
                        for (WebViewStubCallbackWrapper webViewStubCallbackWrapper : this.bed) {
                            bVar.fNM.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper.id);
                            webViewStubCallbackWrapper.ljN.a(bVar);
                        }
                        return;
                    } catch (Exception e) {
                        v.e("MicroMsg.WebViewStubService", "onSceneEnd searchcontact fail, ex = " + e.getMessage());
                        return;
                    }
                }
                return;
            }
            v.e("MicroMsg.WebViewStubService", "onSceneEnd, sendcard errType = " + i + ", errCode = " + i2);
        } else if (type == 233) {
            com.tencent.mm.modelsimple.l lVar = (com.tencent.mm.modelsimple.l) kVar;
            Bundle bundle2 = new Bundle();
            byte[] IW = lVar.IW();
            if (IW == null || IW.length <= 0) {
                v.e("MicroMsg.WebViewStubService", "getA8Key controlBytes is null");
            }
            a = "geta8key_result_jsapi_perm_control_bytes";
            if (IW == null) {
                IW = null;
            }
            bundle2.putByteArray(a, IW);
            rr rrVar = ((rv) lVar.cif.czl.czs).mvN;
            bundle2.putInt("geta8key_result_general_ctrl_b1", rrVar == null ? 0 : rrVar.mvv);
            bundle2.putInt("geta8key_result_reason", ((ru) lVar.cif.czk.czs).mvF);
            bundle2.putString("geta8key_result_req_url", lVar.IU());
            bundle2.putString("geta8key_result_full_url", lVar.IT());
            bundle2.putString("geta8key_result_title", lVar.getTitle());
            bundle2.putInt("geta8key_result_action_code", lVar.IV());
            bundle2.putString("geta8key_result_content", lVar.pO());
            bundle2.putLong("geta8key_result_deep_link_bit_set", lVar.IZ());
            bundle2.putString("geta8key_data_username", ((rv) lVar.cif.czl.czs).gln);
            List<ach> list = ((rv) lVar.cif.czl.czs).mvV;
            if (!be.bP(list)) {
                ach com_tencent_mm_protocal_c_ach;
                Object obj;
                for (ach com_tencent_mm_protocal_c_ach2 : list) {
                    if (com_tencent_mm_protocal_c_ach2 != null && !be.kS(com_tencent_mm_protocal_c_ach2.mhC)) {
                        if (be.kS(com_tencent_mm_protocal_c_ach2.itR)) {
                            v.e("MicroMsg.WebViewStubService", "http header has null value");
                            obj = 1;
                            break;
                        }
                    }
                    v.e("MicroMsg.WebViewStubService", "http header has null value");
                    obj = 1;
                    break;
                }
                obj = null;
                if (obj == null) {
                    String[] strArr = new String[list.size()];
                    String[] strArr2 = new String[list.size()];
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        com_tencent_mm_protocal_c_ach2 = (ach) list.get(i3);
                        v.i("MicroMsg.WebViewStubService", "http header index = %d, key = %s, value = %s", new Object[]{Integer.valueOf(i3), com_tencent_mm_protocal_c_ach2.mhC, com_tencent_mm_protocal_c_ach2.itR});
                        strArr[i3] = r9;
                        strArr2[i3] = r2;
                    }
                    bundle2.putStringArray("geta8key_result_http_header_key_list", strArr);
                    bundle2.putStringArray("geta8key_result_http_header_value_list", strArr2);
                }
            }
            bundle2.putSerializable("geta8key_result_scope_list", lVar.IY());
            v.i("MicroMsg.WebViewStubService", "geta8key onscened: share url:[%s], full url:[%s], req url:[%s], has scopeList:[%s]", new Object[]{lVar.IX(), lVar.IT(), lVar.IU(), Boolean.valueOf(true)});
            if (be.kS(lVar.IX())) {
                v.e("MicroMsg.WebViewStubService", "null shareUrl, full url:[%s], req url:[%s]", new Object[]{lVar.IT(), lVar.IU()});
            } else {
                aj.cY(lVar.IT(), lVar.IX());
            }
            bVar.fNM = bundle2;
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2 : this.bed) {
                    bVar.fNM.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper2.id);
                    webViewStubCallbackWrapper2.ljN.a(bVar);
                }
            } catch (Exception e2) {
                v.e("MicroMsg.WebViewStubService", "onSceneEnd geta8key fail, ex = " + e2.getMessage());
            }
        } else if (type == 673) {
            com.tencent.mm.plugin.webview.d.j jVar = (com.tencent.mm.plugin.webview.d.j) kVar;
            r3 = new Bundle();
            r5 = "reading_mode_result_url";
            if (jVar.cif == null) {
                r2 = null;
            } else {
                r2 = ((yo) jVar.cif.czl.czs).URL;
            }
            r3.putString(r5, r2);
            bVar.fNM = r3;
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper22 : this.bed) {
                    bVar.fNM.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper22.id);
                    webViewStubCallbackWrapper22.ljN.a(bVar);
                }
            } catch (Exception e22) {
                v.e("MicroMsg.WebViewStubService", "onSceneEnd geta8key fail, ex = " + e22.getMessage());
            }
        } else if (type == 666) {
            w wVar = (w) kVar;
            bundle = new Bundle();
            bundle.putString("emoji_stroe_product_id", wVar.Jv().mdM);
            bVar.fNM = bundle;
            if (i == 0 && i2 == 0) {
                r2 = bundle.getString("emoji_stroe_product_id");
                v.i("MicroMsg.WebViewStubService", "[cpan] onsceneend url:%s", new Object[]{r2});
                if (!be.kS(r2)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("extra_id", r2);
                    intent2.putExtra("preceding_scence", 12);
                    intent2.putExtra("download_entrance_scene", 12);
                    com.tencent.mm.ay.c.b(this, "emoji", ".ui.EmojiStoreDetailUI", intent2);
                }
            }
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper222 : this.bed) {
                    bVar.fNM.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper222.id);
                    webViewStubCallbackWrapper222.ljN.a(bVar);
                }
            } catch (Exception e222) {
                v.e("MicroMsg.WebViewStubService", "onSceneEnd MMFunc_JumpEmotionDetail fail, ex = " + e222.getMessage());
            }
        } else if (type == 1080) {
            com.tencent.mm.modelbiz.l lVar2 = (com.tencent.mm.modelbiz.l) kVar;
            r3 = new Bundle();
            r5 = "key_async_url_check_res_attribute";
            type = (lVar2.cif == null || lVar2.cif.czl.czs == null) ? 0 : ((dj) lVar2.cif.czl.czs).mdP;
            r3.putInt(r5, type);
            r3.putString("key_async_url_check_url", lVar2.url);
            bVar.fNM = r3;
            try {
                for (WebViewStubCallbackWrapper webViewStubCallbackWrapper2222 : this.bed) {
                    bVar.fNM.putInt("scene_end_listener_hash_code", webViewStubCallbackWrapper2222.id);
                    webViewStubCallbackWrapper2222.ljN.a(bVar);
                }
            } catch (Exception e2222) {
                v.e("MicroMsg.WebViewStubService", "onSceneEnd geta8key fail, ex = " + e2222.getMessage());
            }
        }
    }
}
