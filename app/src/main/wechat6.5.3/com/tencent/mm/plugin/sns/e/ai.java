package com.tencent.mm.plugin.sns.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class ai {
    private static String aSX() {
        Context context = aa.getContext();
        if (context == null) {
            v.e("MicroMsg.SnsItemReportHelper", "ERROR Context is null scene");
            return null;
        }
        String str;
        int i = 0;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            int subtype = activeNetworkInfo.getSubtype();
            if (activeNetworkInfo.getType() == 1) {
                i = 1;
            } else if (subtype == 13 || subtype == 15 || subtype == 14) {
                i = 4;
            } else if (subtype == 3 || subtype == 4 || subtype == 5 || subtype == 6 || subtype == 12) {
                i = 3;
            } else if (subtype == 1 || subtype == 2) {
                i = 2;
            } else {
                i = 0;
            }
        } catch (Throwable e) {
            v.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{be.e(e)});
        }
        v.i("MicroMsg.SnsItemReportHelper", "get netType :%d", new Object[]{Integer.valueOf(i)});
        String str2 = "";
        String str3 = "";
        String str4 = "";
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            int i2 = 0;
            ArrayList arrayList = new ArrayList();
            stringBuffer.append(connectionInfo.getSSID());
            stringBuffer2.append(connectionInfo.getBSSID());
            String bssid = connectionInfo.getBSSID();
            arrayList.add(bssid);
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                Collections.sort(scanResults, new Comparator<ScanResult>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((ScanResult) obj2).level - ((ScanResult) obj).level;
                    }
                });
                int i3 = 20;
                for (ScanResult scanResult : scanResults) {
                    if (!(scanResult == null || be.kS(scanResult.BSSID))) {
                        if (!scanResult.BSSID.equals(bssid)) {
                            int i4 = i3 - 1;
                            if (i3 <= 0) {
                                break;
                            }
                            stringBuffer.append("|");
                            stringBuffer.append(be.ma(scanResult.SSID).replace("|", "").replace(" ", ""));
                            stringBuffer2.append("|");
                            stringBuffer2.append(be.ma(scanResult.BSSID).replace("|", "").replace(" ", ""));
                            arrayList.add(scanResult.BSSID);
                            stringBuffer3.append("|");
                            stringBuffer3.append(scanResult.level);
                            i3 = i4;
                        } else {
                            i2 = scanResult.level;
                        }
                    }
                }
            }
            int i5 = i2;
            str2 = stringBuffer.toString();
            str3 = stringBuffer2.toString();
            str4 = i5 + stringBuffer3.toString();
        } catch (Throwable e2) {
            Throwable th = e2;
            str = str3;
            str3 = str2;
            v.e("MicroMsg.SnsItemReportHelper", "getWifiInfo : %s", new Object[]{be.e(th)});
            str2 = str3;
            str3 = str;
        }
        v.d("MicroMsg.SnsItemReportHelper", "get wifi :[%s] [%s] [%s]", new Object[]{str3, str2, str4});
        String str5 = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getNetworkOperatorName();
            } else {
                str = str5;
            }
            str5 = str;
        } catch (Throwable e22) {
            v.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{be.e(e22)});
        }
        v.i("MicroMsg.SnsItemReportHelper", "get ispName: %s", new Object[]{str5});
        String str6 = "";
        String str7 = "";
        String str8 = "";
        String str9 = "";
        try {
            List dT = ak.dT(context);
            int i6 = 0;
            while (i6 < dT.size()) {
                a aVar = (a) dT.get(i6);
                str6 = be.ah(aVar.nka, "");
                str7 = be.ah(aVar.nkb, "");
                if (str8.length() > 0 && !be.kS(aVar.nkd)) {
                    str8 = str8 + "|";
                }
                if (!be.kS(aVar.nkd)) {
                    str8 = str8 + aVar.nkd;
                }
                if (str9.length() > 0 && !be.kS(aVar.nkc)) {
                    str9 = str9 + "|";
                }
                if (be.kS(aVar.nkc)) {
                    str = str9;
                } else {
                    str = str9 + aVar.nkc;
                }
                i6++;
                str9 = str;
            }
            str = str9;
            str9 = str8;
            str8 = str7;
            str7 = str6;
        } catch (Throwable e222) {
            th = e222;
            str = str9;
            str9 = str8;
            str8 = str7;
            str7 = str6;
            v.e("MicroMsg.SnsItemReportHelper", "getNetType : %s", new Object[]{be.e(th)});
        }
        v.d("MicroMsg.SnsItemReportHelper", "mcc:%s mnc:%s cell:%s lac:%s", new Object[]{str7, str8, str9, str});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i).append(",");
        stringBuilder.append(str2.replace(",", " ")).append(",");
        stringBuilder.append(str3.replace(",", " ")).append(",");
        stringBuilder.append(str4.replace(",", " ")).append(",");
        stringBuilder.append(str5.replace(",", " ")).append(",");
        stringBuilder.append(str7.replace(",", " ")).append(",");
        stringBuilder.append(str8.replace(",", " ")).append(",");
        stringBuilder.append(str9.replace(",", " ")).append(",");
        stringBuilder.append(str.replace(",", " "));
        return stringBuilder.toString();
    }

    public static void cT(long j) {
        if (j != 0) {
            k dd = ad.aSE().dd(j);
            if (dd != null && dd.field_type == 1) {
                aic aUD = dd.aUD();
                if (aUD != null) {
                    List list = aUD.mIy;
                    List list2 = dd.aUp().mWq.mom;
                    int min = Math.min(list.size(), list2.size());
                    String str = "";
                    if (min > 0) {
                        str = aSX();
                        if (be.kS(str)) {
                            return;
                        }
                    }
                    String str2 = str;
                    for (int i = 0; i < min; i++) {
                        awr com_tencent_mm_protocal_c_awr = (awr) list.get(i);
                        StringBuffer stringBuffer = new StringBuffer();
                        aib com_tencent_mm_protocal_c_aib = (aib) list2.get(i);
                        stringBuffer.append("||index: " + i);
                        stringBuffer.append("||item poi lat " + com_tencent_mm_protocal_c_awr.mUc + " " + com_tencent_mm_protocal_c_awr.mUd);
                        stringBuffer.append("||item poi accuracy loctype " + com_tencent_mm_protocal_c_awr.aJp + " " + com_tencent_mm_protocal_c_awr.jGV);
                        stringBuffer.append("||item pic lat " + com_tencent_mm_protocal_c_awr.mUa + " " + com_tencent_mm_protocal_c_awr.mUb);
                        stringBuffer.append("||item exitime:" + com_tencent_mm_protocal_c_awr.mUf + " filetime: " + com_tencent_mm_protocal_c_awr.mUg);
                        stringBuffer.append("||item source: " + com_tencent_mm_protocal_c_awr.mUe);
                        stringBuffer.append("||url" + com_tencent_mm_protocal_c_aib.glb);
                        String str3 = com_tencent_mm_protocal_c_aib.glb;
                        if (str3.startsWith("http://mmsns.qpic.cn/mmsns/")) {
                            int lastIndexOf = str3.lastIndexOf("/");
                            if (lastIndexOf > 27 && lastIndexOf < str3.length()) {
                                str3 = str3.substring(27, lastIndexOf);
                            }
                        }
                        v.d("MicroMsg.SnsItemReportHelper", "report:%s", new Object[]{str3 + "," + i.cE(j) + "," + i + "," + be.Nh() + "," + com_tencent_mm_protocal_c_awr.mUe + "," + com_tencent_mm_protocal_c_awr.mUg + "," + com_tencent_mm_protocal_c_awr.mUf + "," + com_tencent_mm_protocal_c_awr.mUb + "," + com_tencent_mm_protocal_c_awr.mUa + "," + com_tencent_mm_protocal_c_awr.mUd + "," + com_tencent_mm_protocal_c_awr.mUc + "," + str2 + "," + com_tencent_mm_protocal_c_awr.aJp + "," + com_tencent_mm_protocal_c_awr.jGV});
                        g.iuh.Y(11985, str);
                    }
                }
            }
        }
    }
}
