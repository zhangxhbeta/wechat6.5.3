package com.tencent.mm.plugin.report.service;

import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.a.q;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.plugin.report.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public enum g implements a {
    ;
    
    private long iui;
    private int iuj;
    private int uin;

    private g(String str) {
        this.iui = 0;
    }

    public static Object a(int i, int[] iArr, int i2, int i3) {
        return b.a(i, iArr, i2, i3);
    }

    private static void c(int i, String str, boolean z, boolean z2) {
        KVReportDataInfo kVReportDataInfo = new KVReportDataInfo();
        kVReportDataInfo.itT = (long) i;
        kVReportDataInfo.value = str;
        kVReportDataInfo.itF = z;
        kVReportDataInfo.itU = z2;
        KVCommCrossProcessReceiver.a(kVReportDataInfo);
    }

    public final void Y(int i, String str) {
        if (c.itp) {
            a(i, str, c.itq, c.itq);
        } else {
            a(i, str, false, false);
        }
    }

    public final void a(int i, String str, boolean z, boolean z2) {
        if (!aa.bto()) {
            c(i, str, z2, z);
        } else if (c.itp) {
            d.a((long) i, str, c.itq, c.itq);
        } else {
            d.a((long) i, str, z, z2);
        }
    }

    public final void h(int i, Object... objArr) {
        if (c.itp) {
            a(i, c.itq, c.itq, objArr);
        } else {
            a(i, false, false, objArr);
        }
    }

    public final void a(int i, boolean z, boolean z2, Object... objArr) {
        String str;
        if (objArr == null || objArr.length <= 0) {
            v.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
            str = SQLiteDatabase.KeyEmpty;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int length = objArr.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                stringBuilder.append(String.valueOf(objArr[i2])).append(',');
            }
            stringBuilder.append(String.valueOf(objArr[length]));
            str = stringBuilder.toString();
        }
        if (com.tencent.mm.sdk.b.b.bsI()) {
            v.v("MicroMsg.ReportManagerKvCheck", "kvTypedStat id:%d [%b,%b] val:%s", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), str);
        }
        if (aa.bto()) {
            d.a((long) i, str, z, z2);
        } else {
            c(i, str, z2, z);
        }
    }

    public final boolean a(int i, com.tencent.mm.ba.a aVar) {
        try {
            aVar.getClass().getField("import_ds_").setInt(aVar, Integer.MAX_VALUE);
            long Ni = be.Ni();
            if (Ni / 86400 != this.iui) {
                try {
                    this.iuj = be.getInt(new SimpleDateFormat("yyyyMMdd").format(new Date()), 0);
                } catch (Exception e) {
                }
            }
            aVar.getClass().getField("ds_").setInt(aVar, this.iuj);
            aVar.getClass().getField("uin_").setLong(aVar, ((long) this.uin) & 4294967295L);
            aVar.getClass().getField("device_").setInt(aVar, 2);
            aVar.getClass().getField("clientVersion_").setInt(aVar, d.lWh);
            aVar.getClass().getField("time_stamp_").setLong(aVar, Ni);
            try {
                byte[] toByteArray = aVar.toByteArray();
                if (!aa.bto()) {
                    v.f("MicroMsg.ReportManagerKvCheck", "not in MM Process");
                    return true;
                } else if (c.itp) {
                    d.a((long) i, toByteArray, c.itq, c.itq);
                    return true;
                } else {
                    d.a((long) i, toByteArray, false, false);
                    return true;
                }
            } catch (IOException e2) {
                v.e("MicroMsg.ReportManagerKvCheck", "pbKVStat LocalReportPb error, %d, %s", Integer.valueOf(i), e2.toString());
                return false;
            }
        } catch (Exception e3) {
            v.e("MicroMsg.ReportManagerKvCheck", "pbKVStat  set values error, %d, %s", Integer.valueOf(i), e3.toString());
            return false;
        }
    }

    public final void d(int i, List<String> list) {
        if (c.itp) {
            a(i, (List) list, c.itq, c.itq);
        } else {
            a(i, (List) list, false, false);
        }
    }

    private static void a(int i, List<String> list, boolean z, boolean z2) {
        String str;
        if (list == null || list.isEmpty()) {
            v.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
            str = SQLiteDatabase.KeyEmpty;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int size = list.size() - 1;
            for (int i2 = 0; i2 < size; i2++) {
                stringBuilder.append((String) list.get(i2)).append(',');
            }
            stringBuilder.append((String) list.get(size));
            str = stringBuilder.toString();
        }
        if (aa.bto()) {
            d.a((long) i, str, z, z2);
        } else {
            c(i, str, z2, z);
        }
    }

    public final void a(long j, long j2, long j3, boolean z) {
        if (j < 0 || j2 < 0 || j3 <= 0) {
            v.e("MicroMsg.ReportManagerKvCheck", "ID %d, key %d, value %d <0", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
        } else if (aa.bto()) {
            d.b(j, j2, j3, z);
        } else {
            StIDKeyDataInfo stIDKeyDataInfo = new StIDKeyDataInfo();
            stIDKeyDataInfo.iuq = j;
            stIDKeyDataInfo.key = j2;
            stIDKeyDataInfo.value = j3;
            stIDKeyDataInfo.itF = z;
            KVCommCrossProcessReceiver.a(stIDKeyDataInfo);
        }
    }

    public static void d(ArrayList<IDKey> arrayList, boolean z) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey iDKey = (IDKey) it.next();
            if (iDKey == null) {
                v.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat info == null return");
                return;
            } else if (iDKey.GetID() < 0 || iDKey.GetKey() < 0) {
                v.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat ID %d, key %d, value %d <0", Long.valueOf(iDKey.GetID()), Long.valueOf(iDKey.GetKey()), Long.valueOf(iDKey.GetValue()));
                return;
            } else if (iDKey.GetValue() <= 0) {
                v.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat ID %d, key %d, value %d <0", Long.valueOf(iDKey.GetID()), Long.valueOf(iDKey.GetKey()), Long.valueOf(iDKey.GetValue()));
                return;
            }
        }
        if (aa.bto()) {
            d.b(arrayList, z);
        } else {
            KVCommCrossProcessReceiver.a(arrayList, z);
        }
    }

    public final void ch(int i, int i2) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(64);
        iDKey.SetKey(i);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(64);
        iDKey2.SetKey(i2);
        iDKey2.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        d(arrayList, false);
    }

    public final void c(int i, int i2, int i3, int i4, boolean z) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(i);
        iDKey.SetKey(i2);
        iDKey.SetValue(i4);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i);
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        d(arrayList, z);
    }

    public final void I(int i, int i2, int i3) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(i);
        iDKey.SetKey(i2);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i);
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        d(arrayList, false);
    }

    public static void aKD() {
        if (aa.bto()) {
            BaseEvent.onSingalCrash(0);
        } else {
            KVCommCrossProcessReceiver.aKx();
        }
    }

    public final void cq(String str, String str2) {
        c(str, str2, null);
    }

    public final void c(String str, String str2, Map<String, Object> map) {
        final String xF = ak.uz() ? k.xF() : null;
        final long currentTimeMillis = System.currentTimeMillis();
        final String str3 = str;
        final String str4 = str2;
        final Map<String, Object> map2 = map;
        e.a(new Runnable(this) {
            final /* synthetic */ g iun;

            public final void run() {
                v.e("MicroMsg.cLog", "[%s] %s", str3, str4);
                try {
                    JSONObject jSONObject;
                    String string = aa.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
                    if (map2 == null) {
                        jSONObject = new JSONObject();
                    } else {
                        jSONObject = new JSONObject(map2);
                    }
                    jSONObject.put("tag", str3).put("info", str4);
                    byte[] bytes = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", d.lWf).put("os_ver", d.cmW).put("report_time", currentTimeMillis)).put("items", new JSONArray().put(jSONObject)).toString().getBytes();
                    String toLowerCase = com.tencent.mm.a.g.m(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(d.lWh), Integer.valueOf(bytes.length)}).getBytes()).toLowerCase();
                    bytes = q.k(bytes);
                    PByteArray pByteArray = new PByteArray();
                    com.tencent.mm.a.c.a(pByteArray, bytes, toLowerCase.getBytes());
                    StringBuilder append = new StringBuilder(FileUtils.S_IRUSR).append("http://").append(string).append("/cgi-bin/mmsupport-bin/stackreport?version=0x26050341&devicetype=").append(d.cmW).append("&filelength=").append(r2).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=110");
                    if (!(xF == null || xF.length() == 0)) {
                        append.append("&username=").append(xF);
                    }
                    String stringBuilder = append.toString();
                    HttpClient defaultHttpClient = new DefaultHttpClient();
                    HttpUriRequest httpPost = new HttpPost(stringBuilder);
                    HttpEntity byteArrayEntity = new ByteArrayEntity(pByteArray.value);
                    byteArrayEntity.setContentType("binary/octet-stream");
                    httpPost.setEntity(byteArrayEntity);
                    v.i("MicroMsg.cLog", "POST returned: " + be.e(defaultHttpClient.execute(httpPost).getEntity().getContent()));
                } catch (Throwable e) {
                    v.a("MicroMsg.ReportManagerKvCheck", e, "Failed to upload cLog.", new Object[0]);
                }
            }
        }, "ReportManager_cLog");
    }

    public final void cW(int i) {
        this.uin = i;
        SmcLogic.setUin((long) i);
    }
}
