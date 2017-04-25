package com.tencent.mm.wallet_core.b;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.am;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class g extends k {
    public b cif;
    public e cii;
    public int kNL = 0;
    public String kNM = "";
    public int kNN = 0;
    public String kNO = "";
    public int kNP = 0;
    public String piA = "";
    public boolean piB = false;
    protected String piC;
    public String piy = "";
    public String piz = "";

    public abstract String CX(String str);

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract void a(b bVar, are com_tencent_mm_protocal_c_are);

    public abstract void b(b bVar, are com_tencent_mm_protocal_c_are);

    public abstract int bfq();

    public abstract l c(b bVar);

    public abstract void x(boolean z, boolean z2);

    public void a(c cVar) {
    }

    public final void u(Map<String, String> map) {
        if (map == null) {
            map = new HashMap();
        }
        if (map != null) {
            map.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        am bfP = f.bfP();
        if (bfP != null) {
            v.i("MicroMsg.NetScenePayBase", "location found");
            map.put("province", bfP.bCk);
            map.put("city", bfP.bCl);
            map.put("location_timestamp", bfP.maQ);
            map.put("encrypt_latitude", bfP.maR);
            map.put("encrypt_longitude", bfP.maS);
        }
        x(true, true);
        if (map != null) {
            Object[] toArray = map.keySet().toArray();
            Arrays.sort(toArray);
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            for (Object obj : toArray) {
                String str = (String) map.get(obj);
                if (!be.kS(str)) {
                    if (i != 0) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(obj);
                    stringBuilder.append("=");
                    b(stringBuilder, str);
                    i = true;
                }
            }
            v.d("MicroMsg.NetScenePayBase", "Cmd : " + bfq() + ", req = " + stringBuilder.toString() + " " + toString());
            String CX = CX(stringBuilder.toString());
            stringBuilder.append(i != 0 ? "&" : "");
            stringBuilder.append("WCPaySign");
            stringBuilder.append("=");
            stringBuilder.append(CX);
            a(this.cif, new are().ba(stringBuilder.toString().getBytes()));
        }
        v.i("MicroMsg.NetScenePayBase", "setRequestData getPayCgicmd: %s type: %s this: %s", new Object[]{Integer.valueOf(bfq()), Integer.valueOf(getType()), toString()});
    }

    public void b(StringBuilder stringBuilder, String str) {
        stringBuilder.append(str);
    }

    public final void aa(Map<String, String> map) {
        x(false, false);
        if (map != null) {
            Object[] toArray = map.keySet().toArray();
            Arrays.sort(toArray);
            StringBuilder stringBuilder = new StringBuilder();
            boolean z = false;
            for (Object obj : toArray) {
                String str = (String) map.get(obj);
                if (!be.kS(str)) {
                    if (z) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(obj);
                    stringBuilder.append("=");
                    stringBuilder.append(str);
                    z = true;
                }
            }
            if (com.tencent.mm.sdk.b.b.bsI()) {
                v.d("MicroMsg.NetScenePayBase", "Cmd : " + bfq() + ", wxreq = " + stringBuilder.toString());
            }
            v.d("MicroMsg.NetScenePayBase", "wxreq: " + stringBuilder.toString());
            b(this.cif, new are().ba(stringBuilder.toString().getBytes()));
        }
    }

    public final void a(PayInfo payInfo, Map<String, String> map, Map<String, String> map2) {
        a(payInfo, map, map2, false);
    }

    public final void a(PayInfo payInfo, Map<String, String> map, Map<String, String> map2, boolean z) {
        if (map2 == null) {
            map2 = new HashMap();
        }
        if (payInfo == null) {
            v.e("MicroMsg.NetScenePayBase", "Cmd : " + bfq() + ", payInfo is null");
            map2.put("devicename", Build.MODEL);
            aa(map2);
            return;
        }
        map.put("req_key", payInfo.fTG);
        map.put("partner_id", payInfo.bkj);
        map.put("pay_sign", payInfo.lVB);
        if (payInfo.lVI >= 0) {
            map.put("auto_deduct_flag", payInfo.lVI);
        }
        if (payInfo.bkq > 0) {
            map.put("pay_scene", payInfo.bkq);
        }
        if (payInfo.bkr >= 0) {
            map.put("bindbankscene", payInfo.bkr);
        }
        if (!be.kS(payInfo.lVJ)) {
            map.put("deduct_bank_type", payInfo.lVJ);
        }
        if (!be.kS(payInfo.lVK)) {
            map.put("deduct_bind_serial", payInfo.lVK);
        }
        if (z) {
            map.put("use_touch", "0");
        } else {
            map.put("use_touch", payInfo.lVE);
        }
        map.put("fp_identify_num", payInfo.lVF);
        if (!TextUtils.isEmpty(payInfo.bfs)) {
            map.put("encrypted_pay_info", URLEncoder.encode(payInfo.bfs));
        }
        if (!TextUtils.isEmpty(payInfo.bft)) {
            map.put("encrypted_rsa_sign", URLEncoder.encode(payInfo.bft));
        }
        map2.put("uuid", payInfo.gjT);
        map2.put("appid", payInfo.appId);
        map2.put("appsource", payInfo.kXn);
        map2.put("channel", payInfo.bkh);
        map2.put("devicename", Build.MODEL);
        map2.put("soter_req", payInfo.bjV);
    }

    public final void c(int i, int i2, String str, p pVar) {
        String str2;
        int i3;
        JSONObject jSONObject;
        String optString;
        JSONObject jSONObject2;
        Exception e;
        c cVar;
        Map q;
        Exception exception;
        if (q.dre && 1686 == bfq()) {
            i = 3;
            i2 = -1;
        }
        v.i("MicroMsg.NetScenePayBase", "cgi: %d, rrType %d, rrCgi %s, PayCgicmd %s, errType %d, errCode %d, errMsg %s, this: %s ", new Object[]{Integer.valueOf(getType()), Integer.valueOf(pVar.getType()), pVar.getUri(), Integer.valueOf(bfq()), Integer.valueOf(i), Integer.valueOf(i2), str, toString()});
        l c = c((b) pVar);
        int i4 = c.mDm;
        String str3 = c.mDn;
        int i5 = c.piF;
        String str4 = c.fvD;
        String string = aa.getContext().getString(2131236155);
        JSONObject jSONObject3 = null;
        String b = m.b(c.mDl);
        if (be.kS(b)) {
            v.w("MicroMsg.NetScenePayBase", "hy: respString is null");
            b = str4;
            str2 = string;
            i3 = -10088;
        } else {
            try {
                jSONObject = new JSONObject(b);
                try {
                    this.piC = jSONObject.optString("error_detail_url");
                    int i6 = jSONObject.getInt("retcode");
                    optString = jSONObject.optString("retmsg");
                    try {
                        this.piy = jSONObject.optString("pay_flag");
                        this.piz = jSONObject.optString("return_url");
                        this.piA = jSONObject.optString("wappay_jumped_url");
                        this.kNL = jSONObject.optInt("is_gen_cert");
                        this.kNM = jSONObject.optString("crt_token");
                        this.kNN = jSONObject.optInt("is_hint_crt");
                        JSONObject optJSONObject = jSONObject.optJSONObject("crt_wording");
                        if (optJSONObject != null) {
                            this.kNO = optJSONObject.toString();
                        } else {
                            this.kNO = "";
                        }
                        this.kNP = jSONObject.optInt("is_ignore_crt");
                        if (jSONObject.optInt("del_cert", 0) != 0) {
                            p.bLj();
                            v.i("MicroMsg.NetScenePayBase", "clean token %s", new Object[]{p.bLi()});
                            p.bLj().PP(string);
                        }
                        i3 = i6;
                        b = str4;
                        jSONObject2 = jSONObject;
                        str2 = optString;
                        jSONObject3 = jSONObject2;
                    } catch (Exception e2) {
                        e = e2;
                        v.w("MicroMsg.NetScenePayBase", "hy: json resolve error: error when resolving error code : " + e.toString());
                        i3 = -10089;
                        b = aa.getContext().getString(2131236221);
                        jSONObject2 = jSONObject;
                        str2 = optString;
                        jSONObject3 = jSONObject2;
                        if (com.tencent.mm.sdk.b.b.bsI()) {
                            v.i("MicroMsg.NetScenePayBase", "hy: FOR UNIT TEST: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(bfq()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i4), str3, Integer.valueOf(i5), b, Integer.valueOf(i3), str2, jSONObject3, toString()});
                        }
                        cVar = new c(i, i2, str);
                        if (i == 0) {
                        }
                        v.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
                        q = bf.q(str, "e");
                        if (q == null) {
                            v.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
                            cVar.biS = (String) q.get(".e.Content");
                        } else {
                            if (i2 != -1) {
                            }
                            v.w("MicroMsg.NetScenePayBase", "hy: network error");
                            cVar.biS = aa.getContext().getString(2131236223);
                        }
                        if (jSONObject3 != null) {
                            if (cVar.errType == 0) {
                            }
                            v.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
                        } else {
                            v.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
                        }
                        a(cVar);
                        if (this.piB) {
                            this.cii.a(cVar.errType, cVar.errCode, cVar.biS, this);
                        } else {
                            v.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
                        }
                    }
                } catch (Exception e3) {
                    exception = e3;
                    optString = string;
                    e = exception;
                    v.w("MicroMsg.NetScenePayBase", "hy: json resolve error: error when resolving error code : " + e.toString());
                    i3 = -10089;
                    b = aa.getContext().getString(2131236221);
                    jSONObject2 = jSONObject;
                    str2 = optString;
                    jSONObject3 = jSONObject2;
                    if (com.tencent.mm.sdk.b.b.bsI()) {
                        v.i("MicroMsg.NetScenePayBase", "hy: FOR UNIT TEST: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(bfq()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i4), str3, Integer.valueOf(i5), b, Integer.valueOf(i3), str2, jSONObject3, toString()});
                    }
                    cVar = new c(i, i2, str);
                    if (i == 0) {
                    }
                    v.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
                    q = bf.q(str, "e");
                    if (q == null) {
                        if (i2 != -1) {
                        }
                        v.w("MicroMsg.NetScenePayBase", "hy: network error");
                        cVar.biS = aa.getContext().getString(2131236223);
                    } else {
                        v.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
                        cVar.biS = (String) q.get(".e.Content");
                    }
                    if (jSONObject3 != null) {
                        v.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
                    } else {
                        if (cVar.errType == 0) {
                        }
                        v.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
                    }
                    a(cVar);
                    if (this.piB) {
                        this.cii.a(cVar.errType, cVar.errCode, cVar.biS, this);
                    } else {
                        v.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
                    }
                }
            } catch (Exception e4) {
                exception = e4;
                jSONObject = null;
                optString = string;
                e = exception;
                v.w("MicroMsg.NetScenePayBase", "hy: json resolve error: error when resolving error code : " + e.toString());
                i3 = -10089;
                b = aa.getContext().getString(2131236221);
                jSONObject2 = jSONObject;
                str2 = optString;
                jSONObject3 = jSONObject2;
                if (com.tencent.mm.sdk.b.b.bsI()) {
                    v.i("MicroMsg.NetScenePayBase", "hy: FOR UNIT TEST: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(bfq()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i4), str3, Integer.valueOf(i5), b, Integer.valueOf(i3), str2, jSONObject3, toString()});
                }
                cVar = new c(i, i2, str);
                if (i == 0) {
                }
                v.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
                q = bf.q(str, "e");
                if (q == null) {
                    if (i2 != -1) {
                    }
                    v.w("MicroMsg.NetScenePayBase", "hy: network error");
                    cVar.biS = aa.getContext().getString(2131236223);
                } else {
                    v.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
                    cVar.biS = (String) q.get(".e.Content");
                }
                if (jSONObject3 != null) {
                    v.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
                } else {
                    if (cVar.errType == 0) {
                    }
                    v.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
                }
                a(cVar);
                if (this.piB) {
                    this.cii.a(cVar.errType, cVar.errCode, cVar.biS, this);
                } else {
                    v.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
                }
            }
        }
        if (com.tencent.mm.sdk.b.b.bsI()) {
            v.i("MicroMsg.NetScenePayBase", "hy: FOR UNIT TEST: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(bfq()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i4), str3, Integer.valueOf(i5), b, Integer.valueOf(i3), str2, jSONObject3, toString()});
        }
        cVar = new c(i, i2, str);
        if (i == 0 || i2 != 0) {
            v.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
            q = bf.q(str, "e");
            if (q == null) {
                v.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
                cVar.biS = (String) q.get(".e.Content");
            } else if (i2 != -1 || i2 == -500) {
                v.w("MicroMsg.NetScenePayBase", "hy: network error");
                cVar.biS = aa.getContext().getString(2131236223);
            } else {
                v.w("MicroMsg.NetScenePayBase", "hy: unknown system error");
                cVar.biS = aa.getContext().getString(2131236155);
            }
        } else if (i4 != 0) {
            v.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: plat ret is error");
            cVar.b(BaseReportManager.MAX_READ_COUNT, i4, str3, 1);
        } else if (i5 != 0) {
            v.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: errType is error");
            cVar.b(BaseReportManager.MAX_READ_COUNT, i5, b, 2);
        } else if (i3 != 0) {
            v.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: retCode is error");
            if (i3 == -10089 || i3 == -10088) {
                cVar.b(BaseReportManager.MAX_READ_COUNT, 2, str2, 2);
            } else {
                cVar.b(BaseReportManager.MAX_READ_COUNT, i3, str2, 2);
            }
        } else {
            v.i("MicroMsg.NetScenePayBase", "hy: all's OK");
        }
        if (jSONObject3 != null) {
            v.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
        } else if ((cVar.errType == 0 || cVar.errCode != 0) && !aKe()) {
            v.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
        } else {
            a(cVar.errCode, cVar.biS, jSONObject3);
        }
        a(cVar);
        if (this.piB) {
            v.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
        } else {
            this.cii.a(cVar.errType, cVar.errCode, cVar.biS, this);
        }
    }

    public String axY() {
        return null;
    }

    public boolean aKe() {
        return false;
    }

    public boolean axX() {
        this.czF = be.Nj();
        this.czG = -1;
        this.aGx = -99;
        return false;
    }

    public final int axM() {
        return bfq();
    }

    public final String bLb() {
        return this.piC;
    }

    public boolean aEQ() {
        return true;
    }
}
