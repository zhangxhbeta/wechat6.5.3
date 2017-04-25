package com.tencent.mm.plugin.order.model;

import android.text.TextUtils;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.e.a.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends g {
    public MallOrderDetailObject hNN;
    private int hNO;

    public h(String str) {
        this(str, null, -1);
    }

    public h(String str, String str2) {
        this(str, str2, -1);
    }

    public h(String str, String str2, int i) {
        this.hNN = null;
        this.hNO = -1;
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        if (!be.kS(str2)) {
            hashMap.put("bill_id", str2);
        }
        if (this.hNO >= 0) {
            this.hNO = i;
        }
        u(hashMap);
    }

    public final int aed() {
        return 108;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hNN = new MallOrderDetailObject();
            MallOrderDetailObject mallOrderDetailObject = this.hNN;
            if (jSONObject != null) {
                try {
                    mallOrderDetailObject.hMC = MallTransactionObject.v(jSONObject);
                } catch (Throwable e) {
                    v.a("MicroMsg.MallOrderDetailObject", e, "", new Object[0]);
                } catch (Throwable e2) {
                    v.a("MicroMsg.MallOrderDetailObject", e2, "", new Object[0]);
                }
                try {
                    b bVar;
                    JSONObject jSONObject2 = jSONObject.getJSONObject("status_section");
                    if (jSONObject2 != null) {
                        bVar = new b();
                        bVar.hML = jSONObject2.optString("last_status_name");
                        bVar.hrm = jSONObject2.optInt("time");
                        bVar.bea = jSONObject2.optString("thumb_url");
                        bVar.gkT = jSONObject2.optString("jump_url");
                        bVar.hMM = jSONObject2.optString("last_status_desc");
                    } else {
                        bVar = null;
                    }
                    mallOrderDetailObject.hMD = bVar;
                } catch (Throwable e22) {
                    v.a("MicroMsg.MallOrderDetailObject", e22, "", new Object[0]);
                } catch (Throwable e222) {
                    v.a("MicroMsg.MallOrderDetailObject", e222, "", new Object[0]);
                }
                try {
                    mallOrderDetailObject.hME = MallOrderDetailObject.t(jSONObject);
                } catch (Throwable e2222) {
                    v.a("MicroMsg.MallOrderDetailObject", e2222, "", new Object[0]);
                } catch (Throwable e22222) {
                    v.a("MicroMsg.MallOrderDetailObject", e22222, "", new Object[0]);
                }
                try {
                    List list;
                    int i2;
                    JSONArray jSONArray = jSONObject.getJSONArray("normal_sections");
                    if (jSONArray == null || jSONArray.length() == 0) {
                        list = null;
                    } else {
                        List arrayList = new ArrayList();
                        i2 = 0;
                        boolean z = false;
                        while (i2 < jSONArray.length()) {
                            boolean z2;
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                            a aVar = new a();
                            aVar.eBV = jSONObject3.optInt("is_bar") != 0;
                            aVar.name = jSONObject3.optString("name");
                            if (TextUtils.isEmpty(aVar.name)) {
                                z2 = aVar.eBV;
                            } else {
                                if (z) {
                                    aVar.eBV = z;
                                }
                                z2 = aVar.eBV;
                                aVar.value = jSONObject3.optString("value");
                                aVar.jumpUrl = jSONObject3.optString("jump_url");
                                aVar.jumpType = jSONObject3.optInt("jump_type");
                                arrayList.add(aVar);
                            }
                            i2++;
                            z = z2;
                        }
                        list = arrayList;
                    }
                    mallOrderDetailObject.hMF = list;
                    list = mallOrderDetailObject.hMF;
                    JSONObject optJSONObject = jSONObject.optJSONObject("evaluate_section");
                    if (optJSONObject != null) {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        a aVar2 = new a();
                        if (optJSONObject.has("value")) {
                            aVar2.value = optJSONObject.optString("value");
                            aVar2.type = 2;
                        } else {
                            aVar2.type = 1;
                        }
                        i2 = optJSONObject.optInt("order", 0);
                        if (i2 >= 0 && i2 <= optJSONObject.length() + 1) {
                            list.add(i2, aVar2);
                        }
                    }
                } catch (Throwable e222222) {
                    v.a("MicroMsg.MallOrderDetailObject", e222222, "", new Object[0]);
                } catch (Throwable e2222222) {
                    v.a("MicroMsg.MallOrderDetailObject", e2222222, "", new Object[0]);
                }
                mallOrderDetailObject.hMI = jSONObject.optString("safeguard_url");
                mallOrderDetailObject.fCO = jSONObject.optString("share_url");
                mallOrderDetailObject.hMK = jSONObject.optInt("modifyTimeStamp");
                if (mallOrderDetailObject.hMD != null && mallOrderDetailObject.hMK <= 0) {
                    mallOrderDetailObject.hMK = mallOrderDetailObject.hMD.hrm;
                }
                if (mallOrderDetailObject.hMC != null) {
                    mallOrderDetailObject.hMJ = mallOrderDetailObject.hMC.hMJ;
                    mallOrderDetailObject.gcD = mallOrderDetailObject.hMC.hNh;
                    mallOrderDetailObject.hMH = mallOrderDetailObject.hMC.hMH;
                    mallOrderDetailObject.hMG = mallOrderDetailObject.hMC.hMG;
                }
            }
        }
    }
}
