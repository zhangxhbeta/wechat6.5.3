package com.tencent.mm.plugin.recovery.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.a.g;
import com.tencent.mm.a.q;
import com.tencent.mm.model.ai;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.recovery.c.b;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    public static c irb;
    private List<a> ira = new LinkedList();
    private SimpleDateFormat irc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    public static class a implements Serializable {
        public String apU;
        public String ird;
        public String ire;

        public final String toString() {
            return "HandleObj{key='" + this.apU + '\'' + ", timestamp=" + this.ird + ", clientVersion=" + this.ire + '}';
        }
    }

    public static c aJX() {
        if (irb == null) {
            irb = new c();
        }
        return irb;
    }

    public final void aJY() {
        ObjectInputStream objectInputStream;
        Throwable e;
        int size;
        File file = new File(com.tencent.mm.loader.stub.a.cnh + "recovery/handle.report");
        if (file.exists()) {
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(file));
                try {
                    this.ira = (List) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                    } catch (IOException e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        b.a("MicroMsg.Recovery.WXRecoveryHandleReporter", e, "loadFromFile", new Object[0]);
                        file.delete();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        if (this.ira == null) {
                            size = this.ira.size();
                            if (size > 1000) {
                                this.ira = this.ira.subList(size + DownloadResult.CODE_UNDEFINED, size);
                            }
                        } else {
                            this.ira = new LinkedList();
                        }
                        b.i("MicroMsg.Recovery.WXRecoveryHandleReporter", "loadFromFile: %s", new Object[]{this.ira.toString()});
                    } catch (Throwable th) {
                        e = th;
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                objectInputStream = null;
                b.a("MicroMsg.Recovery.WXRecoveryHandleReporter", e, "loadFromFile", new Object[0]);
                file.delete();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (this.ira == null) {
                    this.ira = new LinkedList();
                } else {
                    size = this.ira.size();
                    if (size > 1000) {
                        this.ira = this.ira.subList(size + DownloadResult.CODE_UNDEFINED, size);
                    }
                }
                b.i("MicroMsg.Recovery.WXRecoveryHandleReporter", "loadFromFile: %s", new Object[]{this.ira.toString()});
            } catch (Throwable th2) {
                e = th2;
                objectInputStream = null;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                throw e;
            }
        }
        b.i("MicroMsg.Recovery.WXRecoveryHandleReporter", "loadFromFile: file not exist", new Object[0]);
        if (this.ira == null) {
            this.ira = new LinkedList();
        } else {
            size = this.ira.size();
            if (size > 1000) {
                this.ira = this.ira.subList(size + DownloadResult.CODE_UNDEFINED, size);
            }
        }
        b.i("MicroMsg.Recovery.WXRecoveryHandleReporter", "loadFromFile: %s", new Object[]{this.ira.toString()});
    }

    public final void aJZ() {
        ObjectOutputStream objectOutputStream;
        Throwable e;
        File file = new File(com.tencent.mm.loader.stub.a.cnh + "recovery/handle.report");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists() && file.length() > 5242880) {
            file.delete();
        }
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            try {
                objectOutputStream.writeObject(this.ira);
                b.i("MicroMsg.Recovery.WXRecoveryHandleReporter", "saveToFile: %s", new Object[]{this.ira.toString()});
                try {
                    objectOutputStream.close();
                } catch (IOException e2) {
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    b.a("MicroMsg.Recovery.WXRecoveryHandleReporter", e, "saveToFile", new Object[0]);
                    file.delete();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            objectOutputStream = null;
            b.a("MicroMsg.Recovery.WXRecoveryHandleReporter", e, "saveToFile", new Object[0]);
            file.delete();
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        } catch (Throwable th2) {
            e = th2;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            throw e;
        }
    }

    public static void aKa() {
        new File(com.tencent.mm.loader.stub.a.cnh + "recovery/handle.report").delete();
    }

    public final void yB(String str) {
        a aVar = new a();
        aVar.apU = str;
        aVar.ire = "0x26050341";
        aVar.ird = this.irc.format(new Date());
        this.ira.add(aVar);
    }

    public static boolean a(Context context, int i, c cVar) {
        if (cVar.ira.size() == 0) {
            b.i("MicroMsg.Recovery.WXRecoveryHandleReporter", "reportRecoveryLog: handle obj list size zero", new Object[0]);
            return false;
        }
        String A;
        String A2 = ai.cse.A("last_login_uin", "0");
        String A3 = ai.cse.A("login_weixin_username", "");
        if (be.kS(A3)) {
            A = ai.cse.A("login_user_name", "never_login");
        } else {
            A = A3;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String string = context.getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
            JSONArray jSONArray = new JSONArray();
            for (a aVar : cVar.ira) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tag", "test_RecoveryHandle").put("info", aVar.apU).put("deviceUUID", i).put("uin", A2).put("time", aVar.ird).put("cver", aVar.ire);
                jSONArray.put(jSONObject);
            }
            A3 = "android-" + VERSION.SDK_INT;
            byte[] bytes = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", Build.MANUFACTURER + "-" + Build.MODEL).put("os_ver", A3).put("report_time", currentTimeMillis)).put("items", jSONArray).toString().getBytes();
            String toLowerCase = g.m(String.format("weixin#$()%d%d", new Object[]{Integer.decode("0x26050341"), Integer.valueOf(bytes.length)}).getBytes()).toLowerCase();
            bytes = q.k(bytes);
            PByteArray pByteArray = new PByteArray();
            com.tencent.mm.a.c.a(pByteArray, bytes, toLowerCase.getBytes());
            StringBuilder append = new StringBuilder(256).append("http://").append(string).append("/cgi-bin/mmsupport-bin/stackreport?version=0x26050341&devicetype=").append(A3).append("&filelength=").append(r4).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=110");
            if (!(A == null || A.length() == 0)) {
                append.append("&username=").append(A);
            }
            A3 = append.toString();
            HttpClient defaultHttpClient = new DefaultHttpClient();
            HttpUriRequest httpPost = new HttpPost(A3);
            HttpEntity byteArrayEntity = new ByteArrayEntity(pByteArray.value);
            byteArrayEntity.setContentType("binary/octet-stream");
            httpPost.setEntity(byteArrayEntity);
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            A = e(execute.getEntity().getContent());
            b.i("MicroMsg.Recovery.WXRecoveryHandleReporter", "POST returned: %d %s", new Object[]{Integer.valueOf(execute.getStatusLine().getStatusCode()), A});
            if (execute.getStatusLine().getStatusCode() != 200) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            b.a("MicroMsg.Recovery.WXRecoveryHandleReporter", e, "reportRecoveryLog", new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String e(java.io.InputStream r6) {
        /*
        r5 = 0;
        r0 = new java.io.BufferedReader;
        r1 = new java.io.InputStreamReader;
        r1.<init>(r6);
        r0.<init>(r1);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
    L_0x0010:
        r2 = r0.readLine();	 Catch:{ IOException -> 0x002e }
        if (r2 == 0) goto L_0x0043;
    L_0x0016:
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x002e }
        r3.<init>();	 Catch:{ IOException -> 0x002e }
        r2 = r3.append(r2);	 Catch:{ IOException -> 0x002e }
        r3 = "\n";
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x002e }
        r2 = r2.toString();	 Catch:{ IOException -> 0x002e }
        r1.append(r2);	 Catch:{ IOException -> 0x002e }
        goto L_0x0010;
    L_0x002e:
        r0 = move-exception;
        r2 = "MicroMsg.Recovery.WXRecoveryHandleReporter";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0061 }
        com.tencent.recovery.c.b.a(r2, r0, r3, r4);	 Catch:{ all -> 0x0061 }
        r6.close();	 Catch:{ IOException -> 0x0054 }
    L_0x003e:
        r0 = r1.toString();
        return r0;
    L_0x0043:
        r6.close();	 Catch:{ IOException -> 0x0047 }
        goto L_0x003e;
    L_0x0047:
        r0 = move-exception;
        r2 = "MicroMsg.Recovery.WXRecoveryHandleReporter";
        r3 = "";
        r4 = new java.lang.Object[r5];
        com.tencent.recovery.c.b.a(r2, r0, r3, r4);
        goto L_0x003e;
    L_0x0054:
        r0 = move-exception;
        r2 = "MicroMsg.Recovery.WXRecoveryHandleReporter";
        r3 = "";
        r4 = new java.lang.Object[r5];
        com.tencent.recovery.c.b.a(r2, r0, r3, r4);
        goto L_0x003e;
    L_0x0061:
        r0 = move-exception;
        r6.close();	 Catch:{ IOException -> 0x0066 }
    L_0x0065:
        throw r0;
    L_0x0066:
        r1 = move-exception;
        r2 = "MicroMsg.Recovery.WXRecoveryHandleReporter";
        r3 = "";
        r4 = new java.lang.Object[r5];
        com.tencent.recovery.c.b.a(r2, r1, r3, r4);
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recovery.a.c.e(java.io.InputStream):java.lang.String");
    }
}
