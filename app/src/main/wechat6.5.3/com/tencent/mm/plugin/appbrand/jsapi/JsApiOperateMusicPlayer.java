package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.id;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.appbrand.AppBrandStickInChattingPluginLogic;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiOperateMusicPlayer extends a {
    public static final int CTRL_INDEX = 47;
    public static final String NAME = "operateMusicPlayer";
    public static boolean dHs;
    OperateMusicPlayer dHt;

    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] dHw = new int[com.tencent.mm.plugin.appbrand.c.b.OG().length];

        static {
            try {
                dHw[com.tencent.mm.plugin.appbrand.c.b.dyZ - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dHw[com.tencent.mm.plugin.appbrand.c.b.dyY - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dHw[com.tencent.mm.plugin.appbrand.c.b.dyX - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static class OperateMusicPlayer extends MainProcessTask {
        public static final Creator<OperateMusicPlayer> CREATOR = new Creator<OperateMusicPlayer>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OperateMusicPlayer(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateMusicPlayer[i];
            }
        };
        public int action;
        public String bjE;
        public String bmJ;
        private f dFd;
        private int dFe;
        private d dGU;
        public boolean dGX = false;
        public String dHA;
        private final com.tencent.mm.sdk.c.c dHB = new com.tencent.mm.sdk.c.c<id>(this) {
            final /* synthetic */ OperateMusicPlayer dHH;

            {
                this.dHH = r2;
                this.nhz = id.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                id idVar = (id) bVar;
                v.i("MicroMsg.JsApiOperateMusicPlayer", "callback in");
                ajr com_tencent_mm_protocal_c_ajr = idVar.bif.bib;
                if (com_tencent_mm_protocal_c_ajr != null) {
                    String str = com_tencent_mm_protocal_c_ajr.mKc;
                    Map hashMap = new HashMap();
                    hashMap.put("dataUrl", str);
                    this.dHH.dHA = new JSONObject(hashMap).toString();
                    this.dHH.action = idVar.bif.action;
                    this.dHH.PP();
                }
                return false;
            }
        };
        com.tencent.mm.model.o.b dHx;
        com.tencent.mm.ui.appbrand.c.a dHy;
        com.tencent.mm.plugin.appbrand.c.a dHz;
        public String errorMsg;

        public OperateMusicPlayer(d dVar, f fVar, int i) {
            this.dGU = dVar;
            this.dFd = fVar;
            this.dFe = i;
        }

        public OperateMusicPlayer(Parcel parcel) {
            f(parcel);
        }

        public final void OL() {
            boolean z = false;
            try {
                JSONObject jSONObject = new JSONObject(this.bjE);
                String optString = jSONObject.optString("operationType");
                final String optString2 = jSONObject.optString("dataUrl");
                if (be.kS(optString)) {
                    this.action = -1;
                    this.dGX = true;
                    this.errorMsg = "operationType is null or nil";
                    PP();
                } else if (a.dze.ao(this.bmJ, optString)) {
                    if (com.tencent.mm.ai.b.HD() && !com.tencent.mm.ai.b.HC() && optString.equalsIgnoreCase("play")) {
                        if (!a.dze.ao(this.bmJ, "resume")) {
                            v.i("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
                        } else if (be.kS(jSONObject.optString("title")) || be.kS(jSONObject.optString("coverImgUrl"))) {
                            v.i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, but title or coverImgUrl is null", new Object[]{this.bmJ});
                            this.action = -1;
                            this.dGX = true;
                            this.errorMsg = "title or coverImgUrl is null or nil";
                            PP();
                            return;
                        } else {
                            v.i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", new Object[]{this.bmJ});
                            optString = "resume";
                        }
                    }
                    if (optString.equalsIgnoreCase("play")) {
                        final String optString3 = jSONObject.optString("title");
                        final String optString4 = jSONObject.optString("singer");
                        optString = jSONObject.optString("epname");
                        final String optString5 = jSONObject.optString("coverImgUrl");
                        if (be.kS(optString2)) {
                            this.action = -1;
                            this.dGX = true;
                            this.errorMsg = "title or dataUrl is null or nil";
                            PP();
                            return;
                        }
                        v.i("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", new Object[]{optString3, optString4, optString, optString5, optString2, optString2, optString2});
                        com.tencent.mm.ai.b.HB();
                        optString = a.dze.dzc;
                        if (!be.kS(optString)) {
                            v.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[]{optString, this.bmJ});
                            a.dze.oL(optString);
                        }
                        final String str = optString2;
                        final String str2 = optString2;
                        ad.g(new Runnable(this) {
                            final /* synthetic */ OperateMusicPlayer dHH;

                            public final void run() {
                                String str = (this.dHH.bmJ + optString2 + optString5).hashCode();
                                String str2 = optString5;
                                String str3 = optString5;
                                String str4 = optString3;
                                String str5 = optString4;
                                String str6 = str;
                                String str7 = str2;
                                String str8 = optString2;
                                String str9 = e.cnj;
                                StringBuilder stringBuilder = new StringBuilder();
                                ak.yW();
                                String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.wP()).append(optString5.hashCode()).toString();
                                ajr com_tencent_mm_protocal_c_ajr = new ajr();
                                com_tencent_mm_protocal_c_ajr.mJV = 7;
                                com_tencent_mm_protocal_c_ajr.mKb = str2;
                                com_tencent_mm_protocal_c_ajr.mKj = str3;
                                com_tencent_mm_protocal_c_ajr.mJY = str4;
                                com_tencent_mm_protocal_c_ajr.mJZ = str5;
                                com_tencent_mm_protocal_c_ajr.mKe = str6;
                                com_tencent_mm_protocal_c_ajr.mKd = str7;
                                com_tencent_mm_protocal_c_ajr.mKc = str8;
                                com_tencent_mm_protocal_c_ajr.mKh = str9;
                                com_tencent_mm_protocal_c_ajr.glj = "";
                                com_tencent_mm_protocal_c_ajr.mKg = stringBuilder2;
                                com_tencent_mm_protocal_c_ajr.mJW = str;
                                com_tencent_mm_protocal_c_ajr.mJX = 0.0f;
                                com_tencent_mm_protocal_c_ajr.mKa = "";
                                com_tencent_mm_protocal_c_ajr.mfh = 1;
                                com_tencent_mm_protocal_c_ajr.mKf = null;
                                com_tencent_mm_protocal_c_ajr.mfo = str;
                                com_tencent_mm_protocal_c_ajr.mKp = true;
                                com.tencent.mm.ai.b.b(com_tencent_mm_protocal_c_ajr);
                                a.dze.a(this.dHH.dHB, this.dHH.bmJ);
                                a.dze.dzc = this.dHH.bmJ;
                                a.dze.dzd = com_tencent_mm_protocal_c_ajr.mJW;
                                v.i("MicroMsg.JsApiOperateMusicPlayer", "startPlayMusic");
                                this.dHH.action = -1;
                                this.dHH.errorMsg = "";
                                this.dHH.dGX = false;
                                this.dHH.PP();
                            }
                        }, 500);
                    } else if (optString.equalsIgnoreCase("resume")) {
                        optString = a.dze.dzc;
                        if (!be.kS(optString)) {
                            v.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[]{optString, this.bmJ});
                            a.dze.oL(optString);
                        }
                        a.dze.a(this.dHB, this.bmJ);
                        a.dze.dzc = this.bmJ;
                        ajr HE = com.tencent.mm.ai.b.HE();
                        if (HE != null) {
                            a.dze.dzd = HE.mJW;
                        }
                        if (com.tencent.mm.ai.b.HD() && !com.tencent.mm.ai.b.HC()) {
                            com.tencent.mm.ai.b.rc();
                            z = true;
                        }
                        if (z) {
                            ad.g(new Runnable(this) {
                                final /* synthetic */ OperateMusicPlayer dHH;

                                {
                                    this.dHH = r1;
                                }

                                public final void run() {
                                    v.i("MicroMsg.JsApiOperateMusicPlayer", "resume ok");
                                    this.dHH.action = -1;
                                    this.dHH.errorMsg = "";
                                    this.dHH.dGX = false;
                                    this.dHH.PP();
                                }
                            }, 500);
                            return;
                        }
                        v.i("MicroMsg.JsApiOperateMusicPlayer", "resume fail");
                        this.action = -1;
                        this.dGX = true;
                        this.errorMsg = "resume play fail";
                        PP();
                    } else if (optString.equalsIgnoreCase("pause")) {
                        if (com.tencent.mm.ai.b.HC()) {
                            com.tencent.mm.ai.b.rb();
                            z = true;
                        }
                        if (z) {
                            ad.g(new Runnable(this) {
                                final /* synthetic */ OperateMusicPlayer dHH;

                                {
                                    this.dHH = r1;
                                }

                                public final void run() {
                                    v.i("MicroMsg.JsApiOperateMusicPlayer", "pause ok");
                                    this.dHH.action = -1;
                                    this.dHH.dGX = false;
                                    this.dHH.errorMsg = "";
                                    this.dHH.PP();
                                }
                            }, 500);
                            return;
                        }
                        v.i("MicroMsg.JsApiOperateMusicPlayer", "pause fail");
                        this.action = -1;
                        this.dGX = true;
                        this.errorMsg = "pause play fail";
                        PP();
                    } else if (optString.equalsIgnoreCase("seek")) {
                        if (com.tencent.mm.ai.b.fR(be.getInt(be.be(jSONObject.optString("position")), -1) * BaseReportManager.MAX_READ_COUNT)) {
                            ad.g(new Runnable(this) {
                                final /* synthetic */ OperateMusicPlayer dHH;

                                {
                                    this.dHH = r1;
                                }

                                public final void run() {
                                    v.i("MicroMsg.JsApiOperateMusicPlayer", "seek ok");
                                    this.dHH.action = -1;
                                    this.dHH.dGX = false;
                                    this.dHH.errorMsg = "";
                                    this.dHH.PP();
                                }
                            }, 500);
                            return;
                        }
                        v.i("MicroMsg.JsApiOperateMusicPlayer", "seek fail");
                        this.action = -1;
                        this.dGX = true;
                        this.errorMsg = "seek fail";
                        PP();
                    } else if (optString.equalsIgnoreCase("stop")) {
                        boolean z2;
                        if (com.tencent.mm.ai.b.HD()) {
                            com.tencent.mm.ai.b.HB();
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            ad.g(new Runnable(this) {
                                final /* synthetic */ OperateMusicPlayer dHH;

                                {
                                    this.dHH = r1;
                                }

                                public final void run() {
                                    v.i("MicroMsg.JsApiOperateMusicPlayer", "stop ok");
                                    this.dHH.action = -1;
                                    this.dHH.dGX = false;
                                    this.dHH.errorMsg = "";
                                    this.dHH.PP();
                                }
                            }, 500);
                            return;
                        }
                        v.i("MicroMsg.JsApiOperateMusicPlayer", "stop fail");
                        this.action = -1;
                        this.dGX = false;
                        this.errorMsg = "stop play fail";
                        PP();
                    } else {
                        this.action = -1;
                        this.dGX = true;
                        PP();
                    }
                } else {
                    v.i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
                    this.action = -1;
                    this.dGX = true;
                    this.errorMsg = "appid not match cannot operate";
                    PP();
                }
            } catch (Exception e) {
                v.e("MicroMsg.JsApiOperateMusicPlayer", e.toString());
                this.action = -1;
                this.dGX = true;
                this.errorMsg = "data is null";
                PP();
            }
        }

        public final void OM() {
            String str;
            f fVar = this.dFd;
            int i = this.dFe;
            d dVar = this.dGU;
            if (this.dGX) {
                str = "fail" + (TextUtils.isEmpty(this.errorMsg) ? "" : ":" + this.errorMsg);
            } else {
                str = "ok";
            }
            fVar.y(i, dVar.c(str, null));
            e a;
            switch (this.action) {
                case 0:
                    v.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
                    a = new c().a(this.dFd);
                    a.mData = this.dHA;
                    a.PX();
                    this.dHx.l("Music#isPlaying", Boolean.valueOf(true));
                    AppBrandStickInChattingPluginLogic.a(this.dHy);
                    com.tencent.mm.plugin.appbrand.c.a(this.dFd.dzg, this.dHz);
                    return;
                case 1:
                    this.dHx.l("Music#isPlaying", Boolean.valueOf(true));
                    AppBrandStickInChattingPluginLogic.a(this.dHy);
                    com.tencent.mm.plugin.appbrand.c.a(this.dFd.dzg, this.dHz);
                    return;
                case 2:
                case 7:
                    v.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
                    a = new a().a(this.dFd);
                    a.mData = this.dHA;
                    a.PX();
                    this.dHx.l("Music#isPlaying", Boolean.valueOf(false));
                    AppBrandStickInChattingPluginLogic.b(this.dHy);
                    com.tencent.mm.plugin.appbrand.c.b(this.dFd.dzg, this.dHz);
                    return;
                case 3:
                    v.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
                    a = new b().a(this.dFd);
                    a.mData = this.dHA;
                    a.PX();
                    this.dHx.l("Music#isPlaying", Boolean.valueOf(false));
                    AppBrandStickInChattingPluginLogic.b(this.dHy);
                    com.tencent.mm.plugin.appbrand.c.b(this.dFd.dzg, this.dHz);
                    return;
                case 4:
                    v.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
                    this.dFd.e("onMusicError", this.dHA, 0);
                    this.dHx.l("Music#isPlaying", Boolean.valueOf(false));
                    AppBrandStickInChattingPluginLogic.b(this.dHy);
                    com.tencent.mm.plugin.appbrand.c.b(this.dFd.dzg, this.dHz);
                    return;
                default:
                    return;
            }
        }

        public final void f(Parcel parcel) {
            this.bjE = parcel.readString();
            this.bmJ = parcel.readString();
            this.dGX = parcel.readByte() != (byte) 0;
            this.dHA = parcel.readString();
            this.action = parcel.readInt();
            this.errorMsg = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.bjE);
            parcel.writeString(this.bmJ);
            parcel.writeByte(this.dGX ? (byte) 1 : (byte) 0);
            parcel.writeString(this.dHA);
            parcel.writeInt(this.action);
            parcel.writeString(this.errorMsg);
        }
    }

    private static final class a extends e {
        private static final int CTRL_INDEX = 82;
        private static final String NAME = "onMusicEnd";

        private a() {
        }
    }

    private static final class b extends e {
        private static final int CTRL_INDEX = 81;
        private static final String NAME = "onMusicPause";

        private b() {
        }
    }

    private static final class c extends e {
        private static final int CTRL_INDEX = 80;
        private static final String NAME = "onMusicPlay";

        private c() {
        }
    }

    public final void a(final f fVar, JSONObject jSONObject, int i) {
        if (dHs) {
            this.dHt = new OperateMusicPlayer(this, fVar, i);
            final com.tencent.mm.model.o.b n = o.yx().n(o.fz("AppBrandService#" + fVar.hashCode()), true);
            synchronized (n) {
                com.tencent.mm.ui.appbrand.c.a aVar;
                com.tencent.mm.ui.appbrand.c.a aVar2 = (com.tencent.mm.ui.appbrand.c.a) n.a("StickyBannerChangeListener", com.tencent.mm.ui.appbrand.c.a.class);
                if (aVar2 == null) {
                    AnonymousClass1 anonymousClass1 = new com.tencent.mm.ui.appbrand.c.a(this) {
                        final /* synthetic */ JsApiOperateMusicPlayer dHv;

                        public final void L(String str, int i) {
                            String string = n.getString("appId", "");
                            int bf = n.bf("pkgType");
                            if (!(string.equals(str) && bf == i) && n.fA("Music#isPlaying")) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("operationType", "pause");
                                } catch (JSONException e) {
                                }
                                MainProcessTask operateMusicPlayer = new OperateMusicPlayer(this.dHv, fVar, this.dHv.dHt.dFe);
                                operateMusicPlayer.bjE = jSONObject.toString();
                                operateMusicPlayer.bmJ = string;
                                AppBrandMainProcessService.a(operateMusicPlayer);
                            }
                        }
                    };
                    AppBrandSysConfig mr = com.tencent.mm.plugin.appbrand.a.mr(fVar.dzg);
                    if (mr != null) {
                        n.l("pkgType", Integer.valueOf(mr.dDB.dBr));
                    }
                    n.l("StickyBannerChangeListener", anonymousClass1);
                    n.l("appId", fVar.dzg);
                    aVar = anonymousClass1;
                } else {
                    aVar = aVar2;
                }
                if (((com.tencent.mm.plugin.appbrand.c.a) n.a("AppBrandLifeCycle.Listener", com.tencent.mm.plugin.appbrand.c.a.class)) == null) {
                    com.tencent.mm.plugin.appbrand.c.a anonymousClass2 = new com.tencent.mm.plugin.appbrand.c.a(this) {
                        final /* synthetic */ JsApiOperateMusicPlayer dHv;

                        public final void gW(int i) {
                            String string = n.getString("appId", "");
                            int bf = n.bf("pkgType");
                            switch (AnonymousClass3.dHw[i - 1]) {
                                case 1:
                                    if (AppBrandStickInChattingPluginLogic.I(string, bf)) {
                                        return;
                                    }
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                default:
                                    return;
                            }
                            if (AppBrandStickInChattingPluginLogic.I(string, bf)) {
                                return;
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("operationType", "pause");
                            } catch (JSONException e) {
                            }
                            MainProcessTask operateMusicPlayer = new OperateMusicPlayer(this.dHv, fVar, this.dHv.dHt.dFe);
                            operateMusicPlayer.bjE = jSONObject.toString();
                            operateMusicPlayer.bmJ = string;
                            AppBrandMainProcessService.a(operateMusicPlayer);
                        }
                    };
                    n.l("AppBrandLifeCycle.Listener", anonymousClass2);
                    this.dHt.dHz = anonymousClass2;
                }
                this.dHt.dHy = aVar;
                this.dHt.dHx = n;
            }
            this.dHt.bjE = jSONObject.toString();
            this.dHt.bmJ = fVar.dzg;
            AppBrandMainProcessService.a(this.dHt);
            return;
        }
        fVar.y(i, c("fail:user must tap first", null));
    }
}
