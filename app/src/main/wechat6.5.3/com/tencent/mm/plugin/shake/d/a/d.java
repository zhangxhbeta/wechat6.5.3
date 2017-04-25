package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.d.a.h.a;
import com.tencent.mm.protocal.c.acp;
import com.tencent.mm.protocal.c.acq;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends k implements j {
    int action;
    final b cQA;
    private e cii;
    private long iQd;

    public d(Collection<a> collection, float f, float f2, int i) {
        this.action = 1;
        this.iQd = 0;
        this.action = 1;
        b.a aVar = new b.a();
        aVar.czn = new acp();
        aVar.czo = new acq();
        aVar.uri = "/cgi-bin/micromsg-bin/ibeaconboardcast";
        aVar.czm = 658;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cQA = aVar.Bv();
        bf zO = bf.zO();
        String ma = be.ma(zO.cvf);
        String ma2 = be.ma(zO.cve);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        acp com_tencent_mm_protocal_c_acp = (acp) this.cQA.czk.czs;
        com_tencent_mm_protocal_c_acp.mDK = be.ma(null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"Beacons\":[");
        if (collection != null) {
            int size = collection.size();
            int i2 = 0;
            for (a aVar2 : collection) {
                stringBuilder.append("{\"UUID\":\"" + aVar2.gjT + "\",\"Location\":{\"Major\":" + aVar2.major + ",\"Minor\":" + aVar2.minor + "},\"Distance\":" + aVar2.cXH + ",\"Extra\":\"\",\"MacAddress\":\"" + aVar2.iQn + "\",\"Rssi\":\"" + aVar2.iQo + "\",\"MeasurePower\":\"" + aVar2.iQp + "\"}");
                if (i2 < size - 1) {
                    stringBuilder.append(",");
                }
                i2++;
            }
        }
        int i3 = 1;
        boolean hasSystemFeature = aa.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if (defaultAdapter != null && defaultAdapter.getState() == 12 && VERSION.SDK_INT >= 18 && hasSystemFeature) {
            i3 = 0;
        }
        stringBuilder.append("],\"Action\":1" + ",\"LBS\":{\"Latitude\":" + f + ",\"Longitude\":" + f2 + ",\"Province\":\"" + ma + "\",\"City\":\"" + ma2 + "\"},\"MachineID\":\"" + p.rK() + "\",\"ZBBeaconState\":\"" + i3 + "\"}");
        com_tencent_mm_protocal_c_acp.hQP = stringBuilder.toString();
        String str = "MicroMsg.NetSceneShakeIbeacon";
        ma = "[oneliang]beaconCollection.size:%d,json:%s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(collection != null ? collection.size() : 0);
        objArr[1] = com_tencent_mm_protocal_c_acp.hQP;
        v.i(str, ma, objArr);
        n.a(2008, f2, f, i);
    }

    public final int getType() {
        return 658;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.iQd = System.currentTimeMillis();
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cii.a(i2, i3, str, this);
        this.iQd = System.currentTimeMillis() - this.iQd;
        g.iuh.h(11497, new Object[]{String.valueOf((int) (((double) (this.iQd / 1000)) + 0.5d)), Integer.valueOf(1), Integer.valueOf((int) this.iQd)});
        int i4;
        String string;
        if (i2 == 0 && i3 == 0) {
            v.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end ok");
            acq com_tencent_mm_protocal_c_acq = (acq) this.cQA.czl.czs;
            try {
                JSONObject jSONObject = new JSONObject(((acp) this.cQA.czk.czs).hQP);
                JSONArray jSONArray = jSONObject.getJSONArray("Beacons");
                int length = jSONArray.length();
                JSONObject jSONObject2 = jSONObject.getJSONObject("LBS");
                i4 = jSONObject.getInt("Action");
                String string2 = jSONObject2.getString("Latitude");
                string = jSONObject2.getString("Longitude");
                if (length > 0) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(0);
                    String string3 = jSONObject3.getString("UUID");
                    jSONObject3 = jSONObject3.getJSONObject("Location");
                    int i5 = jSONObject3.getInt("Major");
                    int i6 = jSONObject3.getInt("Minor");
                    if (com_tencent_mm_protocal_c_acq.mDL.mmL == 0) {
                        String str2 = com_tencent_mm_protocal_c_acq.mDL.gkY;
                        if (i4 == 1 && str2 != null && !str2.equals("") && new JSONObject(str2).getJSONArray("msgs").length() == 0) {
                            g.iuh.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(length), string3, Integer.valueOf(i5), Integer.valueOf(i6), string2, string, Integer.valueOf(2), Integer.valueOf(com_tencent_mm_protocal_c_acq.mDL.mmL)});
                            return;
                        }
                        return;
                    }
                    g.iuh.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(length), string3, Integer.valueOf(i5), Integer.valueOf(i6), string2, string, Integer.valueOf(2), Integer.valueOf(com_tencent_mm_protocal_c_acq.mDL.mmL)});
                    return;
                }
                g.iuh.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(length), "", Integer.valueOf(0), Integer.valueOf(0), string2, string, Integer.valueOf(2), Integer.valueOf(com_tencent_mm_protocal_c_acq.mDL.mmL)});
                return;
            } catch (JSONException e) {
                v.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
                return;
            }
        }
        v.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end not ok");
        try {
            jSONObject3 = new JSONObject(((acp) this.cQA.czk.czs).hQP);
            JSONArray jSONArray2 = jSONObject3.getJSONArray("Beacons");
            i4 = jSONArray2.length();
            jSONObject3 = jSONObject3.getJSONObject("LBS");
            String string4 = jSONObject3.getString("Latitude");
            String string5 = jSONObject3.getString("Longitude");
            if (i4 > 0) {
                JSONObject jSONObject4 = jSONArray2.getJSONObject(0);
                string = jSONObject4.getString("UUID");
                jSONObject4 = jSONObject4.getJSONObject("Location");
                int i7 = jSONObject4.getInt("Major");
                int i8 = jSONObject4.getInt("Minor");
                g.iuh.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(i4), string, Integer.valueOf(i7), Integer.valueOf(i8), string4, string5, Integer.valueOf(1), Integer.valueOf(i3)});
                return;
            }
            g.iuh.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(i4), "", Integer.valueOf(0), Integer.valueOf(0), string4, string5, Integer.valueOf(1), Integer.valueOf(i3)});
        } catch (JSONException e2) {
            v.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
        }
    }
}
