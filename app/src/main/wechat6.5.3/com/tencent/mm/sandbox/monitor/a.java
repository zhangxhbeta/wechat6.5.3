package com.tencent.mm.sandbox.monitor;

import android.content.Intent;
import android.os.Build;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.c;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.a.o;
import com.tencent.mm.a.q;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public final class a {
    static final HashMap<String, Integer> chu;

    static /* synthetic */ void u(String str, byte[] bArr) {
        v.e("MicroMsg.CrashUpload", "doPost : url = " + str + ", data.length = " + bArr.length);
        HttpClient defaultHttpClient = new DefaultHttpClient();
        HttpUriRequest httpPost = new HttpPost(str);
        try {
            HttpEntity byteArrayEntity = new ByteArrayEntity(bArr);
            byteArrayEntity.setContentType("binary/octet-stream");
            httpPost.setEntity(byteArrayEntity);
            String e = be.e(defaultHttpClient.execute(httpPost).getEntity().getContent());
            if (e != null && e.length() > 0) {
                final Map q = bf.q(e, "Response");
                if ("-1000".equalsIgnoreCase((String) q.get(".Response.retCode")) && q.get(".Response.url") != null) {
                    new Timer().schedule(new TimerTask() {
                        public final void run() {
                            Intent intent = new Intent(aa.getContext(), AppUpdaterUI.class);
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.putExtra("intent_extra_desc", (String) q.get(".Response.desc"));
                            intent.putExtra("intent_update_type", TbsLog.TBSLOG_CODE_SDK_INIT);
                            intent.putExtra("intent_extra_download_url", new String[]{(String) q.get(".Response.url")});
                            aa.getContext().startActivity(intent);
                        }
                    }, 500);
                }
            }
            v.d("MicroMsg.CrashUpload", e);
            v.e("MicroMsg.CrashUpload", "doPost: returnConnection = %s", e);
        } catch (Throwable e2) {
            v.a("MicroMsg.CrashUpload", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.CrashUpload", "doPost e type: %s, msg: %s", e2.getClass().getSimpleName(), e2.getMessage());
        }
    }

    static {
        HashMap hashMap = new HashMap(16);
        chu = hashMap;
        hashMap.put("exception", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
        chu.put("anr", Integer.valueOf(CdnLogic.MediaType_FAVORITE_VIDEO));
        chu.put("handler", Integer.valueOf(10003));
        chu.put("sql", Integer.valueOf(10004));
        chu.put("permission", Integer.valueOf(10005));
    }

    public static int bse() {
        File file = new File(t.cng + "crash/");
        if (!file.exists()) {
            v.w("MicroMsg.CrashUpload", "dkcrash checkUpload dir never create ?");
            return -1;
        } else if (file.isFile()) {
            file.delete();
            v.w("MicroMsg.CrashUpload", "dkcrash is the fucking file ??");
            return -1;
        } else {
            String[] list = file.list(new FilenameFilter() {
                public final boolean accept(File file, String str) {
                    return str.endsWith(".crashlog");
                }
            });
            if (list == null || list.length == 0) {
                return -1;
            }
            Pattern compile = Pattern.compile(".");
            for (CharSequence split : list) {
                String[] split2 = compile.split(split);
                if (split2 != null && split2.length > 0) {
                    dw(split2[0], split2.length >= 2 ? split2[1] : SQLiteDatabase.KeyEmpty);
                }
            }
            return 1;
        }
    }

    private static int dw(String str, String str2) {
        String str3 = t.cng + "crash/" + str + "." + str2 + ".crashini";
        long d = be.d(com.tencent.mm.sdk.h.a.dE(str3, "count"));
        long Ni = be.Ni() - be.d(com.tencent.mm.sdk.h.a.dE(str3, "lasttime"));
        String str4 = t.cng + "crash/" + str + "." + str2 + ".crashlog";
        int aQ = e.aQ(str4);
        v.d("MicroMsg.CrashUpload", "dkcrash count:" + d + " t:" + Ni + " len:" + aQ);
        if (aQ < 5242880) {
            byte[] d2 = e.d(str4, 0, -1);
            if (!be.bl(d2)) {
                final int length = d2.length;
                final String toLowerCase = g.m(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(d.lWh), Integer.valueOf(length)}).getBytes()).toLowerCase();
                d2 = q.k(d2);
                final PByteArray pByteArray = new PByteArray();
                c.a(pByteArray, d2, toLowerCase.getBytes());
                final String str5 = str2;
                final String str6 = str;
                com.tencent.mm.sdk.i.e.a(new Runnable() {
                    public final void run() {
                        StringBuilder append = new StringBuilder().append("http://" + aa.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com")).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.lWh)).append("&devicetype=").append(d.cmW).append("&filelength=").append(length).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=").append(be.f((Integer) a.chu.get(str5)));
                        if (!(str6 == null || str6.equals(SQLiteDatabase.KeyEmpty))) {
                            append.append("&username=").append(str6);
                        }
                        v.d("MicroMsg.CrashUpload", "dkcrash sb:" + append.toString());
                        a.u(append.toString(), pByteArray.value);
                    }
                }, "CrashUpload_upload");
            }
        }
        b.deleteFile(str4);
        new com.tencent.mm.sdk.h.a(str3).bH("count", 0);
        com.tencent.mm.sdk.h.a.g(str3, "lasttime", be.Ni());
        return 1;
    }

    public static int a(String str, String str2, a aVar) {
        if (be.kS(aVar.toString())) {
            return -1;
        }
        File file = new File(t.cng + "crash/");
        if (!file.exists()) {
            file.mkdir();
        }
        String str3 = t.cng + "crash/" + str + "." + str2 + ".crashini";
        com.tencent.mm.sdk.h.a.g(str3, "count", be.d(com.tencent.mm.sdk.h.a.dE(str3, "count")) + 1);
        if (be.d(com.tencent.mm.sdk.h.a.dE(str3, "lasttime")) == 0) {
            com.tencent.mm.sdk.h.a.g(str3, "lasttime", be.Ni());
        }
        v.d("MicroMsg.CrashUpload", "crash:[%s] len:[%d]", t.cng + "crash/" + str + "." + str2 + ".crashlog", Integer.valueOf(aVar.toString().length()));
        a(aVar);
        a(str3, aVar);
        return dw(str, str2);
    }

    private static void a(a aVar) {
        if (aVar.nfh) {
            File file = new File(com.tencent.mm.compatible.util.e.cnk);
            if (!file.exists()) {
                file.mkdirs();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (be.ay(file2.lastModified()) > 604800000) {
                        v.i("MicroMsg.CrashUpload", "dealWithSdcardCrash del old file: %s", file2.getPath());
                        file2.delete();
                    }
                }
            }
            v.i("MicroMsg.CrashUpload", "dealWithSdcardCrash %s", com.tencent.mm.compatible.util.e.cnk + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date()) + ".txt");
            a(r0, aVar);
        }
    }

    private static void a(String str, a aVar) {
        if (!new File(str).exists()) {
            int i = aa.getContext().getSharedPreferences("system_config_prefs", 0).getInt("default_uin", 0);
            StringBuilder stringBuilder = new StringBuilder();
            if (i == 0) {
                String dW = be.dW(aa.getContext());
                if (be.kS(dW)) {
                    stringBuilder.append("uin[" + Integer.toString((Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL).hashCode()) + "] ");
                } else {
                    stringBuilder.append("uin[" + dW + "] ");
                }
            } else {
                stringBuilder.append("uin[" + o.getString(i) + "] ");
            }
            stringBuilder.append(v.btc());
            stringBuilder.append(" BRAND:[" + Build.BRAND + "] ");
            String[] rP = p.rP();
            stringBuilder.append("c1[" + rP[0] + "] ");
            stringBuilder.append("c2[" + rP[1] + "] ");
            stringBuilder.append("\n");
            e.e(str, stringBuilder.toString().getBytes());
        }
        if (e.aQ(str) > 10485760) {
            b.deleteFile(str);
        }
        e.e(str, (aVar.toString() + "\n").getBytes());
    }
}
