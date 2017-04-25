package com.tencent.mm.plugin.recharge.model;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet.a.a;
import com.tencent.mm.plugin.wallet.a.g;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.protocal.c.aln;
import com.tencent.mm.protocal.c.alo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f extends k implements j {
    public String appId = "";
    public String biS = "";
    private b cif;
    private e cii;
    public String desc = "";
    public int errCode = 0;
    public String hUm = "";
    public boolean imE = false;
    public ArrayList<h> imF;
    public ArrayList<h> imG;
    public a imH;
    public a imI;
    public a imJ;
    public a imK;
    public a imL;
    public g imM;

    public f(String str) {
        this.hUm = str;
        b.a aVar = new b.a();
        aVar.czn = new aln();
        aVar.czo = new alo();
        aVar.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
        aVar.czm = 1571;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aln com_tencent_mm_protocal_c_aln = (aln) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aln.bkM = 0;
        if (!be.kS(this.hUm)) {
            v.i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", new Object[]{this.hUm});
            com_tencent_mm_protocal_c_aln.mMu = String.format("phone=%s", new Object[]{this.hUm});
        }
    }

    public final int getType() {
        return 1571;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetScenePayChargeProxy", "hy: NetScenePayChargeProxy end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.errCode = i3;
        if (i2 == 0 && i3 == 0) {
            try {
                String optString;
                String optString2;
                String optString3;
                JSONObject jSONObject = new JSONObject(((alo) ((b) pVar).czl.czs).mMv);
                v.d("MicroMsg.NetScenePayChargeProxy", "tofutest: json: %s", new Object[]{jSONObject.toString()});
                this.appId = jSONObject.optString("appId");
                this.errCode = jSONObject.optInt("errCode", -1);
                this.biS = jSONObject.optString("errMsg", aa.getContext().getString(2131236221));
                if (this.errCode < 0) {
                    this.imE = true;
                } else {
                    this.imE = false;
                }
                this.desc = jSONObject.optString("desc");
                JSONArray optJSONArray = jSONObject.optJSONArray("productList");
                if (optJSONArray != null) {
                    this.imF = new ArrayList();
                    this.imG = new ArrayList();
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                        h hVar = new h();
                        hVar.desc = jSONObject2.optString("desc", "");
                        hVar.id = jSONObject2.optString(SlookAirButtonFrequentContactAdapter.ID, "");
                        hVar.name = jSONObject2.optString("name", "");
                        hVar.status = jSONObject2.optInt("status", 0);
                        hVar.url = jSONObject2.optString("url", "");
                        hVar.type = jSONObject2.optInt("type");
                        hVar.kHR = jSONObject2.optString("typeName");
                        if (hVar.type == 1) {
                            this.imF.add(hVar);
                        } else {
                            hVar.kHS = jSONObject2.optString("productAttr");
                            this.imG.add(hVar);
                        }
                    }
                } else {
                    this.imF = null;
                    this.imG = null;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("weSim");
                if (optJSONObject != null) {
                    optString = optJSONObject.optString("url");
                    optString2 = optJSONObject.optString("name");
                    if (be.kS(optString) || be.kS(optString2)) {
                        v.w("MicroMsg.NetScenePayChargeProxy", "tf: weSim is missing");
                        this.imK = null;
                    } else {
                        this.imK = new a();
                        this.imK.url = optString;
                        this.imK.name = optString2;
                    }
                }
                optJSONObject = jSONObject.optJSONObject("wxRemind");
                if (optJSONObject != null) {
                    optString = optJSONObject.optString("url");
                    optString2 = optJSONObject.optString("name");
                    if (be.kS(optString) || be.kS(optString2)) {
                        v.w("MicroMsg.NetScenePayChargeProxy", "hy: remind unicom unnecessary element missing");
                    } else {
                        this.imH = new a();
                        this.imH.url = optString;
                        this.imH.name = optString2;
                        optJSONObject = jSONObject.optJSONObject("wxCard");
                        if (optJSONObject != null) {
                            optString = optJSONObject.optString("url");
                            optString2 = optJSONObject.optString("name");
                            if (!be.kS(optString) || be.kS(optString2)) {
                                v.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
                            } else {
                                this.imI = new a();
                                this.imI.url = optString;
                                this.imI.name = optString2;
                                optJSONObject = jSONObject.optJSONObject("wxWt");
                                if (optJSONObject != null) {
                                    optString = optJSONObject.optString("url");
                                    optString2 = optJSONObject.optString("name");
                                    if (!be.kS(optString) || be.kS(optString2)) {
                                        v.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                                    } else {
                                        this.imJ = new a();
                                        this.imJ.url = optString;
                                        this.imJ.name = optString2;
                                        optJSONObject = jSONObject.optJSONObject("banner");
                                        if (optJSONObject == null) {
                                            this.imM = new g();
                                            this.imM.id = optJSONObject.getInt(SlookAirButtonFrequentContactAdapter.ID);
                                            this.imM.name = optJSONObject.optString("name");
                                            this.imM.url = optJSONObject.optString("url");
                                        } else {
                                            this.imM = null;
                                        }
                                        optJSONObject = jSONObject.optJSONObject("headEnter");
                                        if (optJSONObject == null) {
                                            optString3 = optJSONObject.optString("name");
                                            optString2 = optJSONObject.optString("url");
                                            if (!be.kS(optString3) || be.kS(optString2)) {
                                                v.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                                                this.imL = null;
                                            } else {
                                                this.imL = new a();
                                                this.imL.name = optString3;
                                                this.imL.url = optString2;
                                            }
                                        } else {
                                            this.imL = null;
                                        }
                                    }
                                }
                                this.imJ = null;
                                optJSONObject = jSONObject.optJSONObject("banner");
                                if (optJSONObject == null) {
                                    this.imM = null;
                                } else {
                                    this.imM = new g();
                                    this.imM.id = optJSONObject.getInt(SlookAirButtonFrequentContactAdapter.ID);
                                    this.imM.name = optJSONObject.optString("name");
                                    this.imM.url = optJSONObject.optString("url");
                                }
                                optJSONObject = jSONObject.optJSONObject("headEnter");
                                if (optJSONObject == null) {
                                    this.imL = null;
                                } else {
                                    optString3 = optJSONObject.optString("name");
                                    optString2 = optJSONObject.optString("url");
                                    if (be.kS(optString3)) {
                                    }
                                    v.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                                    this.imL = null;
                                }
                            }
                        }
                        this.imI = null;
                        optJSONObject = jSONObject.optJSONObject("wxWt");
                        if (optJSONObject != null) {
                            optString = optJSONObject.optString("url");
                            optString2 = optJSONObject.optString("name");
                            if (be.kS(optString)) {
                            }
                            v.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                        }
                        this.imJ = null;
                        optJSONObject = jSONObject.optJSONObject("banner");
                        if (optJSONObject == null) {
                            this.imM = new g();
                            this.imM.id = optJSONObject.getInt(SlookAirButtonFrequentContactAdapter.ID);
                            this.imM.name = optJSONObject.optString("name");
                            this.imM.url = optJSONObject.optString("url");
                        } else {
                            this.imM = null;
                        }
                        optJSONObject = jSONObject.optJSONObject("headEnter");
                        if (optJSONObject == null) {
                            optString3 = optJSONObject.optString("name");
                            optString2 = optJSONObject.optString("url");
                            if (be.kS(optString3)) {
                            }
                            v.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                            this.imL = null;
                        } else {
                            this.imL = null;
                        }
                    }
                }
                this.imH = null;
                optJSONObject = jSONObject.optJSONObject("wxCard");
                if (optJSONObject != null) {
                    optString = optJSONObject.optString("url");
                    optString2 = optJSONObject.optString("name");
                    if (be.kS(optString)) {
                    }
                    v.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
                }
                this.imI = null;
                optJSONObject = jSONObject.optJSONObject("wxWt");
                if (optJSONObject != null) {
                    optString = optJSONObject.optString("url");
                    optString2 = optJSONObject.optString("name");
                    if (be.kS(optString)) {
                    }
                    v.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                }
                this.imJ = null;
                optJSONObject = jSONObject.optJSONObject("banner");
                if (optJSONObject == null) {
                    this.imM = null;
                } else {
                    this.imM = new g();
                    this.imM.id = optJSONObject.getInt(SlookAirButtonFrequentContactAdapter.ID);
                    this.imM.name = optJSONObject.optString("name");
                    this.imM.url = optJSONObject.optString("url");
                }
                optJSONObject = jSONObject.optJSONObject("headEnter");
                if (optJSONObject == null) {
                    this.imL = null;
                } else {
                    optString3 = optJSONObject.optString("name");
                    optString2 = optJSONObject.optString("url");
                    if (be.kS(optString3)) {
                    }
                    v.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                    this.imL = null;
                }
            } catch (Exception e) {
                v.e("MicroMsg.NetScenePayChargeProxy", "hy: exception occurred when parsing json: %s", new Object[]{e.toString()});
                this.imE = true;
                this.biS = aa.getContext().getString(2131236221);
            }
        } else {
            this.imE = true;
            if (be.kS(str)) {
                str = aa.getContext().getString(2131236155);
            }
            this.biS = str;
        }
        this.cii.a(i2, i3, str, this);
    }
}
