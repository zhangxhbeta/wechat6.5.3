package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.plugin.qqmail.b.h.b;
import com.tencent.mm.plugin.qqmail.b.h.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

public final class f extends h {
    private static final String BOUNDARY = ("WEIXIN" + System.currentTimeMillis());
    private HttpPost iaz;

    private class a implements HttpEntity {
        private File file;
        private String iaA;
        private String iaB;
        final /* synthetic */ f iaC;
        private int length;

        public a(f fVar, String str, String str2, String str3) {
            this.iaC = fVar;
            this.iaA = str;
            this.file = new File(str2);
            this.iaB = str3;
            this.length = (str.length() + ((int) this.file.length())) + str3.length();
        }

        public final boolean isRepeatable() {
            return true;
        }

        public final boolean isChunked() {
            return !isRepeatable();
        }

        public final boolean isStreaming() {
            return !isRepeatable();
        }

        public final long getContentLength() {
            return (long) this.length;
        }

        public final Header getContentType() {
            return new BasicHeader("Content-Type", "multipart/form-data; boundary=----" + f.BOUNDARY);
        }

        public final Header getContentEncoding() {
            return null;
        }

        public final InputStream getContent() {
            throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
        }

        public final void writeTo(OutputStream outputStream) {
            Throwable th;
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeBytes(this.iaA);
            FileInputStream fileInputStream;
            try {
                byte[] bArr = new byte[1024];
                fileInputStream = new FileInputStream(this.file);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            dataOutputStream.write(bArr, 0, read);
                        } else {
                            dataOutputStream.flush();
                            fileInputStream.close();
                            dataOutputStream.writeBytes(this.iaB);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }

        public final void consumeContent() {
            if (isStreaming()) {
                throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
            }
        }
    }

    public final c a(String str, String str2, b bVar, com.tencent.mm.plugin.qqmail.b.h.a aVar) {
        c cVar;
        int i = 0;
        v.d("MicroMsg.HttpClientUtil", "uri=" + str2 + ", " + bVar);
        HttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            String a = a(bVar);
            String str3 = bVar.iaL.filePath;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\r\n");
            stringBuilder.append("------" + BOUNDARY + "--\r\n");
            HttpEntity aVar2 = new a(this, a, str3, stringBuilder.toString());
            this.iaz = new HttpPost(h.b(str, str2, bVar.iaJ));
            this.iaz.setHeader("User-Agent", fWL);
            this.iaz.setHeader("Host", host);
            this.iaz.setHeader("Connection", "Keep-Alive");
            this.iaz.setHeader("Accept-Charset", ProtocolPackage.ServerEncoding);
            this.iaz.setHeader("Cookie", h.y(bVar.iaK));
            this.iaz.setEntity(aVar2);
            HttpResponse execute = defaultHttpClient.execute(this.iaz);
            i = execute.getStatusLine().getStatusCode();
            HttpEntity entity = execute.getEntity();
            str3 = execute.getFirstHeader("set-cookie").getValue();
            cVar = new c(i, h.xZ(str3), EntityUtils.toString(entity));
            v.d("MicroMsg.HttpClientUtil", "uri=" + str2 + ", " + cVar);
        } catch (Throwable e) {
            v.a("MicroMsg.HttpClientUtil", e, "", new Object[0]);
            if (i == 0) {
                i = 503;
            }
            cVar = new c(i, null, null);
        } finally {
            defaultHttpClient.getConnectionManager().shutdown();
        }
        return cVar;
    }

    public final void cancel() {
        v.d("MicroMsg.HttpClientUtil", "cancel conection.");
        if (this.iaz != null && !this.iaz.isAborted()) {
            this.iaz.abort();
        }
    }

    private static String a(b bVar) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : bVar.iaJ.keySet()) {
            String str2;
            stringBuilder.append("------" + BOUNDARY + "\r\n");
            stringBuilder.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n");
            stringBuilder.append("\r\n");
            stringBuilder.append((String) bVar.iaJ.get(str2));
            stringBuilder.append("\r\n");
        }
        File file = new File(bVar.iaL.filePath);
        if (file.isFile()) {
            str2 = file.getName();
            stringBuilder.append("------" + BOUNDARY + "\r\n");
            stringBuilder.append("Content-Disposition: form-data; name=\"" + bVar.iaL.bfh + "\"; filename=\"" + str2 + "\"\r\n");
            stringBuilder.append("\r\n");
            return stringBuilder.toString();
        }
        throw new InvalidParameterException("The path to upload isnot a file.");
    }
}
