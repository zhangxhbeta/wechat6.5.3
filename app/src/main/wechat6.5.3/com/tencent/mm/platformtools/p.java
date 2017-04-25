package com.tencent.mm.platformtools;

import com.tencent.mm.a.c;
import com.tencent.mm.a.g;
import com.tencent.mm.a.q;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public final class p {
    public static boolean a(final String str, final String str2, final boolean z, boolean z2, int i, final int i2) {
        if (!z2) {
            return a(str, str2, z, i2);
        }
        e.b(new Runnable() {
            public final void run() {
                p.a(str, str2, z, i2);
            }
        }, "StackReportUploader_uploadFileDirect", i);
        return true;
    }

    public static boolean a(String str, String str2, boolean z, boolean z2) {
        return a(str, str2, z, z2, 1, 20003);
    }

    static boolean a(String str, String str2, boolean z, int i) {
        Throwable e;
        if (be.kS(str) || be.kS(str2)) {
            v.e("MicroMsg.StackReportUploader", "uploadFile param err file:%s  user:%s", str, str2);
            return false;
        }
        int aQ = com.tencent.mm.a.e.aQ(str);
        if (aQ <= 0) {
            v.e("MicroMsg.StackReportUploader", "uploadFile err len file:%s len:%d", str, Integer.valueOf(aQ));
            return false;
        } else if (aQ <= 128000) {
            r2 = com.tencent.mm.a.e.d(str, 0, -1);
            boolean a = a(r2, str, str2, i);
            String str3 = "MicroMsg.StackReportUploader";
            String str4 = "uploadFile ret:%b size:%d file:%s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(a);
            objArr[1] = Integer.valueOf(r2 != null ? r2.length : -1);
            objArr[2] = str;
            v.d(str3, str4, objArr);
            if (a && z) {
                com.tencent.mm.a.e.e(new File(str));
            }
            return a;
        } else {
            int i2 = (aQ / 127988) + 1;
            byte[] bArr = new byte[128000];
            int Ni = (int) be.Ni();
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(str);
                int i3 = 0;
                while (i3 < i2) {
                    try {
                        int read = fileInputStream.read(bArr, 12, 127988);
                        if (read < 0) {
                            v.e("MicroMsg.StackReportUploader", "uploadFile read failed file:%s", str);
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                            }
                            return false;
                        }
                        boolean a2;
                        a(Ni, bArr, 0);
                        a(i3, bArr, 4);
                        a(read, bArr, 8);
                        if (read < 127988) {
                            r2 = new byte[(read + 12)];
                            System.arraycopy(bArr, 0, r2, 0, r2.length);
                            a2 = a(r2, str, str2, i);
                        } else {
                            a2 = a(bArr, str, str2, i);
                        }
                        v.d("MicroMsg.StackReportUploader", "uploadFile idx:%d(%d) read:%d ret:%b size:%d file:%s", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(read), Boolean.valueOf(a2), Integer.valueOf(aQ), str);
                        i3++;
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
                if (z) {
                    com.tencent.mm.a.e.e(new File(str));
                }
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                }
                return true;
            } catch (Exception e5) {
                e = e5;
                fileInputStream = null;
                try {
                    v.e("MicroMsg.StackReportUploader", "exception:%s", be.e(e));
                    v.e("MicroMsg.StackReportUploader", "uploadFile read except file:%s", str);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e;
            }
        }
    }

    private static boolean a(int i, byte[] bArr, int i2) {
        if (128000 < i2 + 4) {
            return false;
        }
        bArr[i2] = (byte) ((i >> 24) & WebView.NORMAL_MODE_ALPHA);
        bArr[i2 + 1] = (byte) ((i >> 16) & WebView.NORMAL_MODE_ALPHA);
        bArr[i2 + 2] = (byte) ((i >> 8) & WebView.NORMAL_MODE_ALPHA);
        bArr[i2 + 3] = (byte) (i & WebView.NORMAL_MODE_ALPHA);
        return true;
    }

    private static boolean a(byte[] bArr, String str, String str2, int i) {
        if (be.bl(bArr)) {
            v.e("MicroMsg.StackReportUploader", "read file failed:%s", str);
            return false;
        } else if (bArr.length > 128000) {
            v.e("MicroMsg.StackReportUploader", "file :%s data len error:%d", str, Integer.valueOf(bArr.length));
            return false;
        } else {
            String toLowerCase = g.m(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(d.lWh), Integer.valueOf(bArr.length)}).getBytes()).toLowerCase();
            byte[] k = q.k(bArr);
            if (be.bl(k)) {
                v.e("MicroMsg.StackReportUploader", "zip data failed file:%s", str);
                return false;
            }
            PByteArray pByteArray = new PByteArray();
            c.a(pByteArray, k, toLowerCase.getBytes());
            k = pByteArray.value;
            if (be.bl(k)) {
                v.e("MicroMsg.StackReportUploader", "encrypt data failed file:%s", str);
            }
            String str3 = "http://" + aa.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str3 + "/cgi-bin/mmsupport-bin/stackreport?version=");
            stringBuffer.append(Integer.toHexString(d.lWh));
            stringBuffer.append("&devicetype=");
            stringBuffer.append(d.cmW);
            stringBuffer.append("&filelength=");
            stringBuffer.append(r2);
            stringBuffer.append("&sum=");
            stringBuffer.append(toLowerCase);
            stringBuffer.append("&reporttype=");
            stringBuffer.append(i);
            stringBuffer.append("&reportvalue=");
            stringBuffer.append(be.Ni() + ".0.1");
            if (!(str2 == null || str2.equals(SQLiteDatabase.KeyEmpty))) {
                stringBuffer.append("&username=");
                stringBuffer.append(str2);
            }
            HttpClient defaultHttpClient = new DefaultHttpClient();
            HttpUriRequest httpPost = new HttpPost(stringBuffer.toString());
            try {
                HttpEntity byteArrayEntity = new ByteArrayEntity(k);
                byteArrayEntity.setContentType("binary/octet-stream");
                httpPost.setEntity(byteArrayEntity);
                HttpResponse execute = defaultHttpClient.execute(httpPost);
                if (execute == null || execute.getStatusLine() == null) {
                    v.e("MicroMsg.StackReportUploader", "execute http failed resp null");
                    return false;
                } else if (execute.getStatusLine().getStatusCode() == 200) {
                    return true;
                } else {
                    v.e("MicroMsg.StackReportUploader", "error response code:%d ", Integer.valueOf(execute.getStatusLine().getStatusCode()));
                    return false;
                }
            } catch (Throwable e) {
                v.e("MicroMsg.StackReportUploader", "exception:%s", be.e(e));
                v.d("MicroMsg.StackReportUploader", "execute post failed msg:%s", e.getMessage());
                return false;
            }
        }
    }
}
