package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.WindowManager;
import com.tencent.mm.plugin.appbrand.jsapi.ak;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.appbrand.jsapi.bu;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager.UpdateLogConst;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class e {
    public static int jBe = 750;
    public static int jBf = 10;
    private static Set<a> jBg = null;

    private static class a {
        int jBh;
        int jBi;
        int jBj;

        private a() {
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (aVar.jBh == this.jBh && aVar.jBi == this.jBi && aVar.jBj == this.jBj) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.jBh + this.jBi) + this.jBj;
        }

        public final String toString() {
            return "[nodeType=" + this.jBh + ",compType=" + this.jBi + ",subCompType=" + this.jBj + "]";
        }
    }

    private static boolean qx(int i) {
        if (i == 101 || i == 103) {
            return false;
        }
        return true;
    }

    private static boolean qy(int i) {
        if (i == 103) {
            return true;
        }
        return false;
    }

    public static float a(double d, int i, int i2, int i3) {
        if (i == 0) {
            return (float) d;
        }
        if (i2 == 0) {
            return (float) d;
        }
        float width = (((float) ((WindowManager) aa.getContext().getSystemService("window")).getDefaultDisplay().getWidth()) * (((float) d) * ((float) i3))) / ((float) i2);
        int i4 = (int) width;
        if (((double) (width - ((float) i4))) > 0.001d) {
            i4++;
        }
        return (float) i4;
    }

    private static n a(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        n nVar;
        int KL = be.KL((String) map.get(str + ".type"));
        int KL2 = be.KL((String) map.get(str + ".subType"));
        n pVar;
        switch (KL) {
            case 1:
                pVar = new p();
                pVar.jvH = KL;
                pVar.aYp = KL2;
                pVar.jvX = be.ah((String) map.get(str + ".content"), "");
                pVar.textAlignment = be.KL((String) map.get(str + ".textAlignment"));
                pVar.jvY = be.ah((String) map.get(str + ".fontColor"), "");
                pVar.cmK = a(be.KN((String) map.get(str + ".fontSize")), i, i2, i3);
                pVar.jvZ = (be.KL((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & p.jvU) > 0;
                pVar.jwa = (be.KL((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & p.jvV) > 0;
                pVar.jwb = (be.KL((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & p.jvW) > 0;
                pVar.maxLines = be.KL((String) map.get(str + ".maxLines"));
                nVar = pVar;
                break;
            case 21:
                if (KL2 == 2) {
                    pVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a();
                    pVar.bmJ = (String) map.get(str + ".appid");
                    pVar.channelId = (String) map.get(str + ".channelId");
                    pVar.tX = (String) map.get(str + ".pkg");
                    pVar.jvf = be.KL((String) map.get(str + ".platform"));
                    pVar.jvg = (String) map.get(str + ".warningAndroid");
                } else if (KL2 == 4) {
                    pVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e();
                    pVar.eGm = be.ah((String) map.get(str + ".cardTpId"), "");
                    pVar.eCX = be.ah((String) map.get(str + ".cardExt"), "");
                } else {
                    pVar = new g();
                }
                pVar.jvH = KL;
                pVar.aYp = KL2;
                pVar.title = be.ah((String) map.get(str + ".btnTitle"), "");
                pVar.jvn = be.KL((String) map.get(str + ".btnType"));
                pVar.jvo = be.ah((String) map.get(str + ".btnJumpUrl"), "");
                pVar.jvp = be.ah((String) map.get(str + ".btnJumpApp"), "");
                pVar.jvq = be.ah((String) map.get(str + ".fontColor"), "");
                pVar.jvr = a(be.KN((String) map.get(str + ".fontSize")), i, i2, i3);
                pVar.textAlignment = be.KL((String) map.get(str + ".btnAlignment"));
                pVar.jvs = a(be.KN((String) map.get(str + ".borderSize")), i, i2, i3);
                pVar.height = a(be.KN((String) map.get(str + ".btnHeight")), i, i2, i3);
                pVar.jvt = be.ah((String) map.get(str + ".btnBgColorTheme"), "");
                pVar.jvu = be.ah((String) map.get(str + ".btnBorderColorTheme"), "");
                pVar.jvv = be.ah((String) map.get(str + ".btnBgImgUrl"), "");
                nVar = pVar;
                break;
            case 41:
                pVar = new k();
                pVar.jvH = KL;
                pVar.aYp = KL2;
                pVar.jvA = be.ah((String) map.get(str + ".pureImageUrl"), "");
                pVar.width = a(be.KN((String) map.get(str + ".imageWidth")), i, i2, i3);
                pVar.height = a(be.KN((String) map.get(str + ".imageHeight")), i, i2, i3);
                pVar.jvx = false;
                nVar = pVar;
                break;
            case 44:
                pVar = new j();
                pVar.jvH = KL;
                pVar.aYp = KL2;
                pVar.jvA = be.ah((String) map.get(str + ".panoramaImageUrl"), "");
                pVar.width = a(be.KN((String) map.get(str + ".imageWidth")), i, i2, i3);
                pVar.height = a(be.KN((String) map.get(str + ".imageHeight")), i, i2, i3);
                nVar = pVar;
                break;
            case 45:
                pVar = new k();
                pVar.jvH = KL;
                pVar.aYp = KL2;
                pVar.jvA = be.ah((String) map.get(str + ".fullScreenImageUrl"), "");
                pVar.jvx = true;
                nVar = pVar;
                break;
            case 61:
                pVar = new l();
                pVar.jvH = KL;
                pVar.aYp = KL2;
                pVar.jvB = be.ah((String) map.get(str + ".sightVideoUrl"), "");
                pVar.jvC = be.ah((String) map.get(str + ".sightThumbUrl"), "");
                pVar.width = a(be.KN((String) map.get(str + ".sightDisplayWidth")), i, i2, i3);
                pVar.height = a(be.KN((String) map.get(str + ".sightDisplayHeight")), i, i2, i3);
                pVar.jvD = be.KL((String) map.get(str + ".sightDisplayType"));
                nVar = pVar;
                break;
            case ao.CTRL_INDEX /*62*/:
                pVar = new r();
                pVar.jvH = KL;
                pVar.aYp = KL2;
                pVar.jwc = be.ah((String) map.get(str + ".streamVideoUrl"), "");
                pVar.jwd = be.ah((String) map.get(str + ".streamVideoThumb"), "");
                pVar.width = a(be.KN((String) map.get(str + ".streamDisplayWidth")), i, i2, i3);
                pVar.height = a(be.KN((String) map.get(str + ".streamDisplayHeight")), i, i2, i3);
                pVar.jwe = be.KL((String) map.get(str + ".streamDisplayType"));
                nVar = pVar;
                break;
            case 81:
                pVar = new q();
                pVar.jvH = KL;
                pVar.aYp = KL2;
                pVar.gxI = be.ah((String) map.get(str + ".webviewUrl"), "");
                nVar = pVar;
                break;
            case 102:
                nVar = c(map, str, i, i2, i3, i4);
                break;
            case UpdateLogConst.ACTION_POP_INSTALL_DIALOG /*104*/:
                List b = b(map, str, i, i2, i3, i4);
                nVar = new d();
                nVar.jvl = b;
                break;
            case ak.CTRL_INDEX /*121*/:
            case bu.CTRL_INDEX /*122*/:
                int argb;
                double a = (double) a(be.KN((String) map.get(str + ".topLineSize")), i, i2, i3);
                double a2 = (double) a(be.KN((String) map.get(str + ".bottomLineSize")), i, i2, i3);
                if (qz(i4)) {
                    argb = Color.argb(51, 0, 0, 0);
                } else {
                    argb = Color.argb(51, 255, 255, 255);
                }
                if (KL != ak.CTRL_INDEX) {
                    if (KL != bu.CTRL_INDEX) {
                        nVar = null;
                        break;
                    }
                    String str2 = str + ".phoneNumList.phoneNum";
                    List arrayList = new ArrayList();
                    int i5 = 0;
                    while (true) {
                        CharSequence charSequence;
                        if (i5 == 0) {
                            charSequence = (String) map.get(str2);
                        } else {
                            String str3 = (String) map.get(str2 + i5);
                        }
                        if (!TextUtils.isEmpty(charSequence)) {
                            arrayList.add(charSequence);
                            i5++;
                        } else if (!arrayList.isEmpty()) {
                            nVar = new c(a, a2, argb, arrayList);
                            break;
                        } else {
                            return null;
                        }
                    }
                }
                double KN = be.KN((String) map.get(str + ".location.$x"));
                double KN2 = be.KN((String) map.get(str + ".location.$y"));
                int KL3 = be.KL((String) map.get(str + ".location.$scale"));
                String str4 = (String) map.get(str + ".location.$label");
                String str5 = (String) map.get(str + ".location.$poiname");
                if (!TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str5)) {
                    n fVar = new f(a, a2, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f.a(KN, KN2, KL3, str4, str5), argb);
                    break;
                }
                return null;
                break;
            case 131:
                pVar = new o();
                pVar.jvH = KL;
                pVar.aYp = KL2;
                pVar.label = be.ah((String) map.get(str + ".label"), "");
                pVar.value = (float) be.KN((String) map.get(str + ".value"));
                pVar.jvT = be.ah((String) map.get(str + ".foregroundImage"), "");
                pVar.jvr = a(be.KN((String) map.get(str + ".fontSize")), i, i2, i3);
                pVar.dCB = be.ah((String) map.get(str + ".backgroundColor"), "");
                nVar = pVar;
                break;
            case 132:
                nVar = a(map, str, i, i2, i3);
                break;
            default:
                return null;
        }
        if (nVar == null) {
            return nVar;
        }
        nVar.jvO = qz(i4);
        nVar.type = KL;
        nVar.aYp = KL2;
        a(nVar, (Map) map, str, i, i2, i3);
        return nVar;
    }

    private static s a(Map<String, String> map, String str, int i, int i2, int i3) {
        s sVar = new s();
        try {
            String str2 = str + ".radarChart";
            sVar.jwf = (String) map.get(str2 + ".borderImg");
            sVar.jwm = (String) map.get(str2 + ".maskImg");
            sVar.jwh = (String) map.get(str2 + ".coverColor");
            sVar.jwi = Color.parseColor((String) map.get(str2 + ".labelFont.$color"));
            sVar.jwj = (int) a(be.KN((String) map.get(str2 + ".labelFont.$size")), i, i2, i3);
            sVar.jwk = Color.parseColor((String) map.get(str2 + ".scoreFont.$color"));
            sVar.jwl = (int) a(be.KN((String) map.get(str2 + ".scoreFont.$size")), i, i2, i3);
            sVar.jwg = a(be.KN((String) map.get(str2 + ".borderImgWidth")), i, i2, i3);
            String str3 = str2 + ".itemList.item";
            int i4 = 0;
            while (true) {
                if (i4 != 0) {
                    str2 = str3 + i4;
                } else {
                    str2 = str3;
                }
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s.a();
                aVar.label = (String) map.get(str2 + ".label");
                aVar.jwn = (String) map.get(str2 + ".score");
                aVar.value = (float) be.KN((String) map.get(str2 + ".value"));
                if (TextUtils.isEmpty(aVar.label) && TextUtils.isEmpty(aVar.jwn)) {
                    break;
                }
                sVar.iBY.add(aVar);
                i4++;
            }
        } catch (Throwable e) {
            v.e("AdLandingPagesParseHelper", be.e(e));
        }
        return sVar;
    }

    private static List<n> b(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        List<n> arrayList = new ArrayList();
        String str2 = str + ".layoutItems.componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            n a = a((Map) map, i, i3, i2, i4, str3);
            if (a == null) {
                return arrayList;
            }
            if (a.jvR) {
                arrayList.add(a);
            } else {
                v.i("AdLandingPagesParseHelper", "comp " + a.toString() + " ifCondition is false");
            }
            i5++;
        }
    }

    private static h c(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        h hVar = new h();
        try {
            int parseColor = Color.parseColor((String) map.get(str + ".bgColorTheme"));
            hVar.backgroundColor = (((int) (be.getDouble((String) map.get(str + ".bgColorAlpha"), 0.0d) * 255.0d)) << 24) | (parseColor & 16777215);
        } catch (Throwable e) {
            v.e("AdLandingPagesParseHelper", "%s", new Object[]{be.e(e)});
            hVar.backgroundColor = Color.argb(51, 0, 0, 0);
        }
        String str2 = (str + ".componentGroupList") + ".componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            parseColor = be.KL((String) map.get(str3 + ".type"));
            n nVar = null;
            if (qx(parseColor)) {
                nVar = a((Map) map, str3, i, i2, i3, i4);
            }
            if (nVar == null) {
                return hVar;
            }
            if (nVar.jvR) {
                hVar.jvw.add(nVar);
            }
            i5++;
        }
    }

    private static i d(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        n iVar = new i();
        a(iVar, (Map) map, str, i, i2, i3);
        iVar.jvy = be.KL((String) map.get(str + ".pageCtrType"));
        iVar.jvz = be.KL((String) map.get(new StringBuilder().append(str).append(".isFullScreen").toString())) == 1;
        String str2 = str + ".componentGroupList.componentGroup";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            h hVar = new h();
            String str4 = str3 + ".componentItem";
            int i6 = 0;
            while (true) {
                String str5;
                if (i6 == 0) {
                    str5 = str4;
                } else {
                    str5 = str4 + i6;
                }
                int KL = be.KL((String) map.get(str5 + ".type"));
                n nVar = null;
                if (qx(KL)) {
                    nVar = a((Map) map, str5, i, i2, i3, i4);
                }
                if (nVar == null) {
                    break;
                }
                if (nVar.jvR) {
                    hVar.jvw.add(nVar);
                }
                i6++;
            }
            if (hVar.jvw.size() == 0) {
                return iVar;
            }
            iVar.jvw.add(hVar);
            i5++;
        }
    }

    private static void a(n nVar, Map<String, String> map, String str, int i, int i2, int i3) {
        boolean z = true;
        nVar.jvH = be.KL((String) map.get(str + ".type"));
        nVar.type = nVar.jvH;
        nVar.jvG = be.ah((String) map.get(str + ".id"), "");
        nVar.jvI = a(be.KN((String) map.get(str + ".paddingTop")), i, i2, i3);
        nVar.jvJ = a(be.KN((String) map.get(str + ".paddingBottom")), i, i2, i3);
        nVar.jvK = a(be.KN((String) map.get(str + ".paddingLeft")), i, i2, i3);
        nVar.jvL = a(be.KN((String) map.get(str + ".paddingRight")), i, i2, i3);
        nVar.aYp = be.KL((String) map.get(str + ".subType"));
        String str2 = str + ".if";
        if (map.containsKey(str2)) {
            nVar.jvR = "1".equals(map.get(str2));
        } else {
            nVar.jvR = true;
        }
        str2 = str + ".noReport";
        if (map.containsKey(str2)) {
            if (!"1".equals(map.get(str2))) {
                z = false;
            }
            nVar.jvS = z;
        } else {
            nVar.jvS = false;
        }
        Object ah = be.ah((String) map.get(str + ".layoutWidth"), "");
        Object ah2 = be.ah((String) map.get(str + ".layoutHeight"), "");
        if (TextUtils.isEmpty(ah)) {
            nVar.jvM = 2.14748365E9f;
        } else {
            double KN = be.KN(ah);
            if (KN < 0.0d) {
                nVar.jvM = (float) KN;
            } else {
                nVar.jvM = a(KN, i, i2, i3);
            }
        }
        if (TextUtils.isEmpty(ah2)) {
            nVar.jvN = 2.14748365E9f;
        } else {
            double KN2 = be.KN(ah2);
            if (KN2 < 0.0d) {
                nVar.jvN = (float) KN2;
            } else {
                nVar.jvN = a(KN2, i, i2, i3);
            }
        }
        str2 = (String) map.get(str + ".verticalAlignment");
        String str3 = (String) map.get(str + ".horizontalAlignment");
        if (TextUtils.isEmpty(str2)) {
            nVar.jvP = -1;
        } else {
            nVar.jvP = be.KL(str2);
        }
        if (TextUtils.isEmpty(str3)) {
            nVar.jvQ = -1;
        } else {
            nVar.jvQ = be.KL(str3);
        }
    }

    private static n e(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        n mVar = new m();
        mVar.jvF = be.KL((String) map.get(str + ".subType"));
        a(mVar, (Map) map, str, i, i2, i3);
        String str2 = str + ".layoutItems.componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            int KL = be.KL((String) map.get(str3 + ".type"));
            n nVar = null;
            if (qx(KL)) {
                nVar = a((Map) map, str3, i, i2, i3, i4);
            } else if (qy(KL)) {
                nVar = e(map, str3, i, i2, i3, i4);
            }
            if (nVar == null) {
                return mVar;
            }
            if (nVar.jvR) {
                mVar.jvE.add(nVar);
            }
            i5++;
        }
    }

    public static LinkedList<c> j(String str, String str2, String str3, String str4) {
        LinkedList<c> linkedList = new LinkedList();
        if (TextUtils.isEmpty(str)) {
            return linkedList;
        }
        String str5 = "";
        if (!TextUtils.isEmpty(str)) {
            str = str.replaceAll("\\{\\{.*?\\}\\}", str5);
        }
        Map q = bf.q(str, str2);
        if (q == null) {
            v.w("AdLandingPagesParseHelper", " parse landingpages xml is error ," + str);
            return linkedList;
        }
        int i;
        String str6;
        int KL = be.KL((String) q.get("." + str2 + ".adCanvasInfo.sizeType"));
        int KL2 = be.KL((String) q.get("." + str2 + ".adCanvasInfo.basicRootFontSize"));
        int KL3 = be.KL((String) q.get("." + str2 + ".adCanvasInfo.basicWidth"));
        if (KL2 == 0 && KL == 1) {
            i = jBf;
        } else {
            i = KL2;
        }
        if (KL3 == 0 && KL == 1) {
            KL3 = jBe;
        }
        String str7 = ".adCanvasInfo.PageList.Page";
        if (be.kS(str2) || str7.equals("adCanvasInfo")) {
            str6 = str7;
        } else {
            str6 = "." + str2 + str7;
        }
        int i2 = 0;
        while (true) {
            String str8;
            if (i2 == 0) {
                str8 = str6;
            } else {
                str8 = str6 + i2;
            }
            c cVar = new c();
            cVar.jAU = be.ah((String) q.get(str8 + ".backgroundCover"), "");
            cVar.dCB = be.ah((String) q.get(str8 + ".backgroundColor"), "");
            cVar.jAV = be.KL((String) q.get(new StringBuilder().append(str8).append(".backgroundCover.$isAddBlur").toString())) > 0;
            cVar.id = i2;
            str7 = str8 + ".if";
            if (q.containsKey(str7)) {
                cVar.jvR = "1".equals(q.get(str7));
            } else {
                cVar.jvR = true;
            }
            if (cVar.jvR) {
                String str9 = str8 + ".componentItemList.componentItem";
                int i3 = 0;
                while (true) {
                    n a;
                    if (i3 == 0) {
                        str8 = str9;
                    } else {
                        str8 = str9 + i3;
                    }
                    try {
                        a = a(q, KL, i, KL3, !TextUtils.isEmpty(cVar.dCB) ? Color.parseColor(cVar.dCB) : 0, str8);
                    } catch (Throwable e) {
                        v.e("AdLandingPagesParseHelper", be.e(e));
                        a = a(q, KL, i, KL3, 0, str8);
                    }
                    if (a == null) {
                        break;
                    }
                    if (a.jvR) {
                        if (a.type == 21) {
                            ((g) a).juo = str4;
                            ((g) a).jup = str3;
                        }
                        a(a, q, str8, KL, KL3, i);
                        cVar.jAW.add(a);
                    } else {
                        v.i("AdLandingPagesParseHelper", "comp " + a.toString() + " ifCondition is false");
                    }
                    i3++;
                }
                if (cVar.jAW.size() == 0) {
                    return linkedList;
                }
                linkedList.add(cVar);
            }
            i2++;
        }
    }

    private static n a(Map<String, String> map, int i, int i2, int i3, int i4, String str) {
        int KL = be.KL((String) map.get(str + ".type"));
        if (qx(KL)) {
            try {
                return a((Map) map, str, i, i3, i2, i4);
            } catch (Exception e) {
                return a((Map) map, str, i, i3, i2, 0);
            }
        }
        Object obj;
        if (KL == 101) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return d(map, str, i, i3, i2, i4);
        }
        if (qy(KL)) {
            return e(map, str, i, i3, i2, i4);
        }
        v.e("AdLandingPagesParseHelper", "the type" + KL + " is not client known type");
        return null;
    }

    public static LinkedList<c> c(String str, String str2, String str3, String str4, String str5) {
        String str6 = new String(str);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            v.i("AdLandingPagesParseHelper", "the jsonObject is " + jSONObject.toString());
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str7;
                Object next = keys.next();
                if (next != null && (next instanceof String)) {
                    str7 = (String) next;
                    String string = jSONObject.getString(str7);
                    if (!be.kS(string)) {
                        str7 = str6.replace("{{" + str7 + "}}", "<![CDATA[" + string + "]]>");
                        str6 = str7;
                    }
                }
                str7 = str6;
                str6 = str7;
            }
        } catch (Exception e) {
            v.e("AdLandingPagesParseHelper", "the json is parsed error : " + str);
        }
        return j(str6, str2, str4, str5);
    }

    private static boolean qz(int i) {
        int i2 = i | -16777216;
        return i2 - -16777216 > -1 - i2;
    }

    private static boolean Bl(String str) {
        return be.KL(be.ah((String) bf.q(str, "adCanvasInfo").get(".adCanvasInfo.bizId"), "")) == 1;
    }

    private static boolean a(String str, Context context, boolean z, int i) {
        String str2 = (String) bf.q(str, "adCanvasInfo").get(".adCanvasInfo.shareWebUrl");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (z) {
            try {
                str2 = f(str2, "exp=" + com.tencent.mm.model.c.c.Av().Lr("Sns_Canvas_GameShare_JumpWay") + "_" + i);
            } catch (URISyntaxException e) {
            }
            v.i("AdLandingPagesParseHelper", "canvas jump url " + str2);
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str2);
        intent.putExtra("showShare", true);
        com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }

    private static String f(String str, String... strArr) {
        URI uri = new URI(str);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= 0; i++) {
            stringBuilder.append(strArr[0]).append("&");
        }
        if (stringBuilder.length() <= 1) {
            return str;
        }
        String stringBuilder2;
        StringBuilder deleteCharAt = stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String query = uri.getQuery();
        if (query == null) {
            stringBuilder2 = deleteCharAt.toString();
        } else {
            stringBuilder2 = query + "&" + deleteCharAt.toString();
        }
        return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), stringBuilder2, uri.getFragment()).toString();
    }

    private static boolean aUj() {
        com.tencent.mm.storage.c Ls = com.tencent.mm.model.c.c.Au().Ls("100150");
        if (!Ls.isValid()) {
            return false;
        }
        int i = be.getInt((String) Ls.buX().get("openCanvas"), 0);
        v.i("AdLandingPagesParseHelper", "canOpenGameCanvas abtest=" + i);
        if (i == 1) {
            return true;
        }
        return false;
    }

    public static boolean z(Intent intent, Context context) {
        int i = 0;
        String stringExtra = intent.getStringExtra("sns_landing_pages_xml");
        if (!TextUtils.isEmpty(stringExtra)) {
            if (TextUtils.isEmpty(stringExtra) || !Bm(stringExtra)) {
                v.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[]{stringExtra});
            } else {
                String str = "";
                boolean Bl = Bl(stringExtra);
                if (Bl) {
                    str = com.tencent.mm.model.c.c.Av().Lr("Sns_Canvas_GameShare_JumpWay");
                    int Lq = com.tencent.mm.model.c.c.Av().Lq("Sns_Canvas_GameShare_JumpWay");
                    v.i("AdLandingPagesParseHelper", "abtestvalue = " + Lq);
                    if (Lq != 0) {
                        i = 1;
                    }
                    if (i == 0 && aUj()) {
                        i = 1;
                    }
                } else {
                    i = 1;
                }
                if (i == 0) {
                    return a(stringExtra, context, Bl, intent.getIntExtra("sns_landig_pages_from_source", -1));
                }
                Intent intent2 = new Intent(intent);
                intent2.setClass(context, SnsAdNativeLandingPagesUI.class);
                intent2.putExtra("sns_landing_pages_expid", str);
                context.startActivity(intent2);
                return true;
            }
        }
        return false;
    }

    public static boolean a(azr com_tencent_mm_protocal_c_azr, Activity activity) {
        String str = com_tencent_mm_protocal_c_azr.jYp;
        long longValue = new BigInteger(com_tencent_mm_protocal_c_azr.gID).longValue();
        List list = com_tencent_mm_protocal_c_azr.mWq.mom;
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str) || !Bm(str)) {
                v.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[]{str});
            } else {
                String Lr;
                boolean z;
                String str2 = "";
                boolean Bl = Bl(str);
                if (Bl) {
                    Lr = com.tencent.mm.model.c.c.Av().Lr("Sns_Canvas_GameShare_JumpWay");
                    z = com.tencent.mm.model.c.c.Av().Lq("Sns_Canvas_GameShare_JumpWay") != 0;
                    if (!z && aUj()) {
                        z = true;
                    }
                } else {
                    Lr = str2;
                    z = true;
                }
                if (!z) {
                    return a(str, (Context) activity, Bl, 11);
                }
                com.tencent.mm.plugin.sns.storage.k dd = ad.aSE().dd(longValue);
                Intent intent = new Intent();
                if (dd != null) {
                    intent.putExtra("sns_landing_pages_share_sns_id", dd.aUq());
                    intent.putExtra("sns_landing_pages_ux_info", dd.aUR());
                    intent.putExtra("sns_landing_pages_aid", dd.aTz());
                    intent.putExtra("sns_landing_pages_traceid", dd.aTA());
                }
                if (list != null && list.size() > 0) {
                    intent.putExtra("sns_landing_pages_share_thumb_url", ((aib) list.get(0)).mHP);
                }
                intent.putExtra("sns_landing_pages_expid", Lr);
                intent.putExtra("sns_landig_pages_from_source", 11);
                intent.setClass(activity, SnsAdNativeLandingPagesUI.class);
                intent.putExtra("sns_landing_pages_xml", str);
                intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                activity.startActivity(intent);
                return true;
            }
        }
        return false;
    }

    public static boolean Bm(String str) {
        InputStream inputStream = null;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String name;
        if (jBg == null && jBg == null) {
            jBg = new HashSet();
            try {
                inputStream = aa.getContext().getAssets().open("sns/canvas_valid_type.xml");
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                newPullParser.setInput(inputStream, "UTF-8");
                int i = -1;
                int eventType = newPullParser.getEventType();
                int i2 = -1;
                while (eventType != 1) {
                    int i3;
                    if (eventType == 2) {
                        boolean z;
                        name = newPullParser.getName();
                        if ("canvastype".equals(name)) {
                            eventType = 0;
                            z = false;
                        } else if ("pagetype".equals(name)) {
                            eventType = 1;
                            z = true;
                        } else if ("componenttype".equals(name)) {
                            eventType = 2;
                            z = true;
                        } else if ("subtype".equals(name)) {
                            z = true;
                            eventType = i2;
                        } else {
                            eventType = i2;
                            z = true;
                        }
                        if (!z) {
                            i2 = be.getInt(newPullParser.getAttributeValue(null, "android"), 0) == 1 ? be.getInt(newPullParser.getAttributeValue(null, "val"), -1) : -1;
                            switch (z) {
                                case false:
                                case true:
                                case true:
                                    i = eventType;
                                    continue;
                                case true:
                                    if (!(eventType == -1 || i == -1 || i2 == -1)) {
                                        a aVar = new a();
                                        aVar.jBh = eventType;
                                        aVar.jBi = i;
                                        aVar.jBj = i2;
                                        jBg.add(aVar);
                                        v.i("AdLandingPagesParseHelper", "valid canvas type " + aVar);
                                        break;
                                    }
                            }
                        }
                        i2 = i;
                        i = eventType;
                    } else {
                        i3 = i;
                        i = i2;
                        i2 = i3;
                    }
                    eventType = newPullParser.next();
                    i3 = i2;
                    i2 = i;
                    i = i3;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable e2) {
                v.e("AdLandingPagesParseHelper", be.e(e2));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                v.e("AdLandingPagesParseHelper", be.e(e22));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
            }
        }
        if (jBg == null || jBg.isEmpty()) {
            return false;
        }
        Map q = bf.q(str, "adCanvasInfo");
        if (q == null || q.isEmpty()) {
            v.w("AdLandingPagesParseHelper", "invalid landingpages xml," + str);
            return false;
        }
        a aVar2 = new a();
        aVar2.jBh = 0;
        aVar2.jBi = be.KL((String) q.get(".adCanvasInfo.type"));
        aVar2.jBj = be.KL((String) q.get(".adCanvasInfo.subtype"));
        if (jBg.contains(aVar2)) {
            name = ".adCanvasInfo.PageList.Page";
            int i4 = 0;
            while (true) {
                String str2;
                aVar2.jBh = 1;
                if (i4 == 0) {
                    str2 = name;
                } else {
                    str2 = name + i4;
                }
                if (!q.containsKey(str2 + ".componentItemList.componentItem.type")) {
                    return true;
                }
                aVar2.jBi = be.KL((String) q.get(str2 + ".type"));
                aVar2.jBj = be.KL((String) q.get(str2 + ".subType"));
                if (jBg.contains(aVar2)) {
                    String str3 = str2 + ".componentItemList.componentItem";
                    aVar2.jBh = 2;
                    int i5 = 0;
                    while (true) {
                        if (i5 == 0) {
                            str2 = str3;
                        } else {
                            str2 = str3 + i5;
                        }
                        if (q.containsKey(str2 + ".type")) {
                            aVar2.jBi = be.KL((String) q.get(str2 + ".type"));
                            aVar2.jBj = be.KL((String) q.get(str2 + ".subType"));
                            if (jBg.contains(aVar2)) {
                                i5++;
                            } else {
                                v.i("AdLandingPagesParseHelper", "invalid component type " + aVar2);
                                return false;
                            }
                        }
                        i4++;
                    }
                } else {
                    v.i("AdLandingPagesParseHelper", "invalid page type " + aVar2);
                    return false;
                }
            }
        }
        v.i("AdLandingPagesParseHelper", "invalid canvas type " + aVar2);
        return false;
    }

    public static String w(com.tencent.mm.plugin.sns.storage.k kVar) {
        if (kVar == null) {
            v.e("AdLandingPagesParseHelper", "the snsinfo is null");
            return null;
        } else if (kVar.qC(32)) {
            com.tencent.mm.plugin.sns.storage.c aUS = kVar.aUS();
            if (aUS == null) {
                v.e("AdLandingPagesParseHelper", "the adSnsInfo is null");
                return null;
            }
            b aUm = kVar.aUm();
            if (aUm == null) {
                v.e("AdLandingPagesParseHelper", "the adxml is null");
                return null;
            }
            com.tencent.mm.plugin.sns.storage.a aUo = kVar.aUo();
            if (aUo == null) {
                v.e("AdLandingPagesParseHelper", "the adInfo is null");
                return null;
            } else if (!aUm.jun) {
                v.e("AdLandingPagesParseHelper", "the snsinfo is not a landingpage");
                return null;
            } else if (aUo.juq == null || aUo.juq.size() == 0) {
                v.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
                return null;
            } else {
                String str = aUS.field_adxml;
                LinkedList j = j(str, "adxml", "adId", "");
                String str2 = str;
                for (String str3 : aUo.juq.keySet()) {
                    if (!be.kS(str3)) {
                        String str4 = (String) aUo.juq.get(str3);
                        if (!be.kS(str4)) {
                            String str5;
                            Iterator it = j.iterator();
                            String str6 = null;
                            while (it.hasNext()) {
                                Iterator it2 = ((c) it.next()).jAW.iterator();
                                while (it2.hasNext()) {
                                    n nVar = (n) it2.next();
                                    if ((nVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e) && !be.kS(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e) nVar).eGm) && ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e) nVar).eGm.equals(str3)) {
                                        str5 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e) nVar).eCX;
                                        break;
                                    }
                                }
                                str5 = str6;
                                if (str5 != null) {
                                    break;
                                }
                                str6 = str5;
                            }
                            str5 = str6;
                            if (be.kS(r2)) {
                                str3 = str2;
                                str2 = str3;
                            } else {
                                v.i("AdLandingPagesParseHelper", "old card ext is " + r2 + " and new card ext is " + str4);
                                str3 = str2.replace(r2, str4);
                                try {
                                    str2 = str3.replace(be.KJ(r2), be.KJ(str4));
                                } catch (Exception e) {
                                    v.e("AdLandingPagesParseHelper", "the xml is error");
                                }
                            }
                        }
                    }
                }
                return str2;
            }
        } else {
            v.e("AdLandingPagesParseHelper", "the snsinfo is not a ad");
            return null;
        }
    }
}
