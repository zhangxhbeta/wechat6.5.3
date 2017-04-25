package com.tencent.mm.plugin.freewifi.b;

import android.database.MatrixCursor;
import com.tencent.mm.e.a.ee;
import com.tencent.mm.plugin.freewifi.d.j;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.ahs;
import com.tencent.mm.protocal.c.aht;
import com.tencent.mm.protocal.c.ahu;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    private static final String[] fYg = new String[]{"ssid", "bssid", "rssi", "isWechatWifi", "wechatShopName", "maxApCount", "intervalSeconds"};
    private static final String[] fYh = new String[]{"errcode", "errmsg", "maxApCount", "intervalSeconds"};
    private int fYi;
    private int fYj;
    private long fYk;

    private static class a {
        private static c fYp = new c();
    }

    static /* synthetic */ void a(ee eeVar, MatrixCursor matrixCursor) {
        v.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setResult. errorcode=%d, errmsg=%s", new Object[]{Integer.valueOf(1), null});
        eeVar.bcw.bcy = matrixCursor;
        eeVar.bcw.bcc = 1;
        if (eeVar.bpT != null) {
            eeVar.bpT.run();
        }
    }

    private c() {
        this.fYi = 200;
        this.fYj = 180;
        this.fYk = 0;
    }

    public static c aoL() {
        return a.fYp;
    }

    public final synchronized void a(final ee eeVar) {
        int i = 0;
        synchronized (this) {
            v.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "method getWifiList called. reqMaxApCount=" + aoM() + "; reqIntervalSeconds=" + aoN());
            String[] strArr = eeVar.bcv.bcx;
            if (strArr == null || strArr.length == 0) {
                a(eeVar, 1101, "Args is empty.");
            } else {
                int i2;
                StringBuilder stringBuilder = new StringBuilder();
                for (i2 = 0; i2 < strArr.length; i2++) {
                    stringBuilder.append("args[" + i2 + "] = " + strArr[i2]);
                }
                v.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "args: " + stringBuilder.toString());
                try {
                    if (Integer.valueOf(strArr[0]).intValue() != 1) {
                        a(eeVar, 1103, "Wechant installed currently only supports version 1.");
                    } else if (strArr.length != 3) {
                        a(eeVar, 1104, "Args.length should be 3, but now it is " + strArr.length + ".");
                    } else {
                        try {
                            i2 = Integer.valueOf(strArr[2]).intValue();
                            if (i2 != 1 && i2 != 2) {
                                a(eeVar, 1106, "Args[2] should be integer 1 (from setting) or integer 2 (from background).");
                            } else if (aoO() != 0 && System.currentTimeMillis() - aoO() < ((long) aoN()) && i2 == 2) {
                                a(eeVar, 1109, "Request frequence is out of limit. The time btween two background request should be more than  " + this.fYj + " seconds.");
                            } else if (m.ty(strArr[1])) {
                                a(eeVar, 1105, "Args[1] should be an ap list json string, but now it is empty.");
                            } else {
                                final LinkedList linkedList = new LinkedList();
                                try {
                                    JSONArray jSONArray = new JSONArray(strArr[1]);
                                    if (jSONArray.length() > aoM()) {
                                        a(eeVar, 1110, "jsonArray.length()=" + jSONArray.length() + ". Too many ap. The number of ap requested per time should be between 1 and " + aoM() + ".");
                                    } else if (jSONArray.length() == 0) {
                                        a(eeVar, 1110, "jsonArray.length()=" + jSONArray.length() + ". Too many ap. The number of ap requested per time should be between 1 and " + aoM() + ".");
                                    } else {
                                        while (i < jSONArray.length()) {
                                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                                            aht com_tencent_mm_protocal_c_aht = new aht();
                                            com_tencent_mm_protocal_c_aht.ssid = m.tz(jSONObject.getString("ssid"));
                                            com_tencent_mm_protocal_c_aht.bssid = jSONObject.getString("bssid");
                                            com_tencent_mm_protocal_c_aht.bcb = jSONObject.getInt("rssi");
                                            linkedList.add(com_tencent_mm_protocal_c_aht);
                                            i++;
                                        }
                                        new j(linkedList, i2).b(new e(this) {
                                            final /* synthetic */ c fYo;

                                            public final void a(int i, int i2, String str, k kVar) {
                                                Exception e;
                                                synchronized (this.fYo) {
                                                    ahs apD = ((j) kVar).apD();
                                                    this.fYo.bU(System.currentTimeMillis());
                                                    this.fYo.kW(apD.fYj <= 0 ? 180 : apD.fYj);
                                                    v.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "resp.reqMaxApCount=" + apD.fYi);
                                                    int i3 = apD.fYi <= 0 ? 200 : apD.fYi;
                                                    v.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "_reqMaxApCount = " + i3);
                                                    this.fYo.kV(i3);
                                                    if (i == 0 && i2 == 0) {
                                                        LinkedList linkedList = apD.mHp;
                                                        MatrixCursor matrixCursor = null;
                                                        try {
                                                            MatrixCursor matrixCursor2 = new MatrixCursor(c.fYg);
                                                            try {
                                                                Map hashMap = new HashMap();
                                                                for (int i4 = 0; i4 < linkedList.size(); i4++) {
                                                                    ahu com_tencent_mm_protocal_c_ahu = (ahu) linkedList.get(i4);
                                                                    hashMap.put(com_tencent_mm_protocal_c_ahu.ssid + "-" + com_tencent_mm_protocal_c_ahu.bssid, Integer.valueOf(i4));
                                                                }
                                                                for (int i5 = 0; i5 < linkedList.size(); i5++) {
                                                                    aht com_tencent_mm_protocal_c_aht = (aht) linkedList.get(i5);
                                                                    ahu com_tencent_mm_protocal_c_ahu2 = new ahu();
                                                                    com_tencent_mm_protocal_c_ahu2.ssid = com_tencent_mm_protocal_c_aht.ssid;
                                                                    com_tencent_mm_protocal_c_ahu2.bssid = com_tencent_mm_protocal_c_aht.bssid;
                                                                    com_tencent_mm_protocal_c_ahu2.bcb = com_tencent_mm_protocal_c_aht.bcb;
                                                                    com_tencent_mm_protocal_c_ahu2.mHq = 0;
                                                                    com_tencent_mm_protocal_c_ahu2.mHr = null;
                                                                    com_tencent_mm_protocal_c_ahu2.fXb = 0;
                                                                    com_tencent_mm_protocal_c_ahu2.aYz = null;
                                                                    if (hashMap.get(com_tencent_mm_protocal_c_ahu2.ssid + "-" + com_tencent_mm_protocal_c_ahu2.bssid) != null) {
                                                                        Integer num = (Integer) hashMap.get(com_tencent_mm_protocal_c_ahu2.ssid + "-" + com_tencent_mm_protocal_c_ahu2.bssid);
                                                                        if (linkedList.get(num.intValue()) != null) {
                                                                            com_tencent_mm_protocal_c_ahu2.mHq = ((ahu) linkedList.get(num.intValue())).mHq;
                                                                            com_tencent_mm_protocal_c_ahu2.mHr = ((ahu) linkedList.get(num.intValue())).mHr;
                                                                            com_tencent_mm_protocal_c_ahu2.fXb = ((ahu) linkedList.get(num.intValue())).fXb;
                                                                            com_tencent_mm_protocal_c_ahu2.aYz = ((ahu) linkedList.get(num.intValue())).aYz;
                                                                        }
                                                                    }
                                                                    if (com_tencent_mm_protocal_c_ahu2.fXb == 4 || com_tencent_mm_protocal_c_ahu2.fXb == 31) {
                                                                        matrixCursor2.addRow(new Object[]{com_tencent_mm_protocal_c_ahu2.ssid, com_tencent_mm_protocal_c_ahu2.bssid, Integer.valueOf(com_tencent_mm_protocal_c_ahu2.bcb), Integer.valueOf(com_tencent_mm_protocal_c_ahu2.mHq), com_tencent_mm_protocal_c_ahu2.mHr, Integer.valueOf(this.fYo.aoM()), Integer.valueOf(this.fYo.aoN())});
                                                                        v.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[]{com_tencent_mm_protocal_c_ahu2.ssid, com_tencent_mm_protocal_c_ahu2.bssid, Integer.valueOf(com_tencent_mm_protocal_c_ahu2.bcb), Integer.valueOf(com_tencent_mm_protocal_c_ahu2.mHq), com_tencent_mm_protocal_c_ahu2.mHr, Integer.valueOf(this.fYo.aoM()), Integer.valueOf(this.fYo.aoN())});
                                                                        if (com_tencent_mm_protocal_c_ahu2.mHq == 1 && i2 == 1) {
                                                                            a.fYb.b(com_tencent_mm_protocal_c_ahu2.ssid, com_tencent_mm_protocal_c_ahu2.bssid, com_tencent_mm_protocal_c_ahu2.aYz, com_tencent_mm_protocal_c_ahu2.fXb);
                                                                            v.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cached : ssid=%s, bssid=%s, apKey=%s, protocolType=%d. ", new Object[]{com_tencent_mm_protocal_c_ahu2.ssid, com_tencent_mm_protocal_c_ahu2.bssid, com_tencent_mm_protocal_c_ahu2.aYz, Integer.valueOf(com_tencent_mm_protocal_c_ahu2.fXb)});
                                                                        }
                                                                    } else {
                                                                        matrixCursor2.addRow(new Object[]{com_tencent_mm_protocal_c_ahu2.ssid, com_tencent_mm_protocal_c_ahu2.bssid, Integer.valueOf(com_tencent_mm_protocal_c_ahu2.bcb), Integer.valueOf(0), null, Integer.valueOf(this.fYo.aoM()), Integer.valueOf(this.fYo.aoN())});
                                                                        v.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[]{com_tencent_mm_protocal_c_ahu2.ssid, com_tencent_mm_protocal_c_ahu2.bssid, Integer.valueOf(com_tencent_mm_protocal_c_ahu2.bcb), Integer.valueOf(0), null, Integer.valueOf(this.fYo.aoM()), Integer.valueOf(this.fYo.aoN())});
                                                                    }
                                                                }
                                                                c.a(eeVar, matrixCursor2);
                                                            } catch (Exception e2) {
                                                                e = e2;
                                                                matrixCursor = matrixCursor2;
                                                            }
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            if (matrixCursor != null) {
                                                                matrixCursor.close();
                                                            }
                                                            v.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[]{e});
                                                            this.fYo.a(eeVar, 1108, "cursor exception.");
                                                        }
                                                    } else if (i2 == -30035) {
                                                        this.fYo.a(eeVar, 1110, "Too many ap. The number of ap requested per time should be between 1 and " + this.fYo.aoM() + ".");
                                                    } else {
                                                        this.fYo.a(eeVar, 1121, "Server returns errtype= " + i + ", errcode=" + i2 + ", errMsg=" + m.tA(str) + ".");
                                                    }
                                                }
                                            }
                                        });
                                    }
                                } catch (Exception e) {
                                    a(eeVar, 1105, "Args[1] is not a valid json array value and it should be a string like  [  {    \"ssid\": \"SSID_NAME\",    \"bssid\": \"0e:00:00:00:00:00\",    \"rssi\": -45  }].");
                                }
                            }
                        } catch (Exception e2) {
                            a(eeVar, 1107, "Args[2] is not a valid int value.");
                        }
                    }
                } catch (Exception e3) {
                    a(eeVar, 1102, "Args[0] is not an integer.");
                }
            }
        }
    }

    private void a(ee eeVar, int i, String str) {
        MatrixCursor matrixCursor;
        Exception e;
        v.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setErrorResult. errorcode=%d, errmsg=%s", new Object[]{Integer.valueOf(i), str});
        try {
            matrixCursor = new MatrixCursor(fYh);
            try {
                matrixCursor.addRow(new Object[]{Integer.valueOf(i), str, Integer.valueOf(aoM()), Integer.valueOf(aoN())});
                eeVar.bcw.bcy = matrixCursor;
                eeVar.bcw.bcc = 1;
                if (eeVar.bpT != null) {
                    eeVar.bpT.run();
                }
            } catch (Exception e2) {
                e = e2;
                if (matrixCursor != null) {
                    matrixCursor.close();
                }
                v.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[]{e});
                eeVar.bcw.bcy = null;
                eeVar.bcw.bcc = 1;
                if (eeVar.bpT != null) {
                    eeVar.bpT.run();
                }
            }
        } catch (Exception e3) {
            e = e3;
            matrixCursor = null;
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            v.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[]{e});
            eeVar.bcw.bcy = null;
            eeVar.bcw.bcc = 1;
            if (eeVar.bpT != null) {
                eeVar.bpT.run();
            }
        }
    }

    public final synchronized int aoM() {
        v.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "getReqMaxApCount() returns " + this.fYi);
        return this.fYi;
    }

    public final synchronized void kV(int i) {
        v.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() param reqMaxApCount = " + i);
        this.fYi = i;
        v.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() this.reqMaxApCount = " + this.fYi);
    }

    public final synchronized int aoN() {
        return this.fYj;
    }

    public final synchronized void kW(int i) {
        this.fYj = i;
    }

    private synchronized long aoO() {
        return this.fYk;
    }

    public final synchronized void bU(long j) {
        this.fYk = j;
    }
}
