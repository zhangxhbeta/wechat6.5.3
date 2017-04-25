package com.tencent.wxop.stat;

import com.tencent.a.a.a.a.h;
import com.tencent.wxop.stat.b.g;
import com.tencent.wxop.stat.b.l;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

final class ak implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ ah pLx;
    final /* synthetic */ ai pMh;

    ak(ai aiVar, List list, ah ahVar) {
        this.pMh = aiVar;
        this.a = list;
        this.pLx = ahVar;
    }

    public final void run() {
        Throwable th;
        ai aiVar = this.pMh;
        List list = this.a;
        ah ahVar = this.pLx;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            list.get(0);
            try {
                int i;
                String str;
                aiVar.pMd.delete(0, aiVar.pMd.length());
                aiVar.pMd.append("[");
                String str2 = "rc4";
                for (i = 0; i < size; i++) {
                    aiVar.pMd.append(list.get(i).toString());
                    if (i != size - 1) {
                        aiVar.pMd.append(",");
                    }
                }
                aiVar.pMd.append("]");
                String stringBuilder = aiVar.pMd.toString();
                int length = stringBuilder.length();
                String str3 = b.bQh() + "/?index=" + aiVar.g;
                aiVar.g++;
                if (b.bPW()) {
                    ai.pLF.bw("[" + str3 + "]Send request(" + length + "bytes), content:" + stringBuilder);
                }
                HttpPost httpPost = new HttpPost(str3);
                httpPost.addHeader("Accept-Encoding", "gzip");
                httpPost.setHeader("Connection", "Keep-Alive");
                httpPost.removeHeaders("Cache-Control");
                HttpHost httpHost = f.gQ(ai.pMf).pKK;
                httpPost.addHeader("Content-Encoding", str2);
                if (httpHost == null) {
                    aiVar.pMb.getParams().removeParameter("http.route.default-proxy");
                } else {
                    if (b.bPW()) {
                        ai.pLF.bz("proxy:" + httpHost.toHostString());
                    }
                    httpPost.addHeader("X-Content-Encoding", str2);
                    aiVar.pMb.getParams().setParameter("http.route.default-proxy", httpHost);
                    httpPost.addHeader("X-Online-Host", b.k);
                    httpPost.addHeader("Accept", "*/*");
                    httpPost.addHeader("Content-Type", "json");
                }
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
                byte[] bytes = stringBuilder.getBytes("UTF-8");
                int length2 = bytes.length;
                if ((length > b.o ? 1 : null) != null) {
                    httpPost.removeHeaders("Content-Encoding");
                    str = str2 + ",gzip";
                    httpPost.addHeader("Content-Encoding", str);
                    if (httpHost != null) {
                        httpPost.removeHeaders("X-Content-Encoding");
                        httpPost.addHeader("X-Content-Encoding", str);
                    }
                    byteArrayOutputStream.write(new byte[4]);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    bytes = byteArrayOutputStream.toByteArray();
                    ByteBuffer.wrap(bytes, 0, 4).putInt(length2);
                    if (b.bPW()) {
                        ai.pLF.bz("before Gzip:" + length2 + " bytes, after Gzip:" + bytes.length + " bytes");
                    }
                }
                httpPost.setEntity(new ByteArrayEntity(g.a(bytes)));
                HttpResponse execute = aiVar.pMb.execute(httpPost);
                HttpEntity entity = execute.getEntity();
                size = execute.getStatusLine().getStatusCode();
                long contentLength = entity.getContentLength();
                if (b.bPW()) {
                    ai.pLF.bw("http recv response status code:" + size + ", content length:" + contentLength);
                }
                if (contentLength <= 0) {
                    ai.pLF.by("Server response no data.");
                    if (ahVar != null) {
                        ahVar.b();
                    }
                    EntityUtils.toString(entity);
                    return;
                }
                if (contentLength > 0) {
                    InputStream content = entity.getContent();
                    DataInputStream dataInputStream = new DataInputStream(content);
                    bytes = new byte[((int) entity.getContentLength())];
                    dataInputStream.readFully(bytes);
                    content.close();
                    dataInputStream.close();
                    Header firstHeader = execute.getFirstHeader("Content-Encoding");
                    if (firstHeader != null) {
                        if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                            bytes = g.b(l.a(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                            bytes = l.a(g.b(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("gzip")) {
                            bytes = l.a(bytes);
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                            bytes = g.b(bytes);
                        }
                    }
                    str = new String(bytes, "UTF-8");
                    if (b.bPW()) {
                        ai.pLF.bw("http get response data:" + str);
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (size == 200) {
                        try {
                            stringBuilder = jSONObject.optString("mid");
                            if (h.c(stringBuilder)) {
                                if (b.bPW()) {
                                    ai.pLF.bw("update mid:" + stringBuilder);
                                }
                                com.tencent.a.a.a.a.g.P(ai.pMf).a(stringBuilder);
                            }
                            if (!jSONObject.isNull("cfg")) {
                                b.a(ai.pMf, jSONObject.getJSONObject("cfg"));
                            }
                            if (!jSONObject.isNull("ncts")) {
                                i = jSONObject.getInt("ncts");
                                length = (int) (((long) i) - (System.currentTimeMillis() / 1000));
                                if (b.bPW()) {
                                    ai.pLF.bw("server time:" + i + ", diff time:" + length);
                                }
                                l.hn(ai.pMf);
                                l.af(ai.pMf, length);
                            }
                        } catch (Throwable th2) {
                            ai.pLF.bx(th2);
                        }
                        if (ahVar != null) {
                            if (jSONObject.optInt("ret") == 0) {
                                ahVar.a();
                            } else {
                                ai.pLF.error("response error data.");
                                ahVar.b();
                            }
                        }
                    } else {
                        ai.pLF.error("Server response error code:" + size + ", error:" + new String(bytes, "UTF-8"));
                        if (ahVar != null) {
                            ahVar.b();
                        }
                    }
                    content.close();
                } else {
                    EntityUtils.toString(entity);
                }
                byteArrayOutputStream.close();
                th2 = null;
                if (th2 != null) {
                    ai.pLF.bQy();
                    if (ahVar != null) {
                        try {
                            ahVar.b();
                        } catch (Throwable th3) {
                            ai.pLF.i(th3);
                        }
                    }
                    if (th2 instanceof OutOfMemoryError) {
                        System.gc();
                        aiVar.pMd = null;
                        aiVar.pMd = new StringBuilder(2048);
                    }
                    f gQ = f.gQ(ai.pMf);
                    gQ.f = (gQ.f + 1) % gQ.a.size();
                }
            } catch (Throwable th4) {
            }
        }
    }
}
