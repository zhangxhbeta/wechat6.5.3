package com.tencent.mapsdk.rastercore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.c.e;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.zip.GZIPInputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    private String a;
    private c b;
    private String c;

    public class a {

        static final class a {
            public static final a a = new a();
        }

        public static double a(LatLng latLng, LatLng latLng2) {
            double longitude = latLng.getLongitude();
            double latitude = latLng.getLatitude();
            longitude *= 0.01745329251994329d;
            latitude *= 0.01745329251994329d;
            double longitude2 = latLng2.getLongitude() * 0.01745329251994329d;
            double latitude2 = latLng2.getLatitude() * 0.01745329251994329d;
            double sin = Math.sin(longitude);
            double sin2 = Math.sin(latitude);
            longitude = Math.cos(longitude);
            latitude = Math.cos(latitude);
            double sin3 = Math.sin(longitude2);
            double sin4 = Math.sin(latitude2);
            longitude2 = Math.cos(longitude2);
            latitude2 = Math.cos(latitude2);
            r18 = new double[3];
            double[] dArr = new double[]{longitude * latitude, latitude * sin, sin2};
            dArr[0] = latitude2 * longitude2;
            dArr[1] = latitude2 * sin3;
            dArr[2] = sin4;
            return Math.asin(Math.sqrt((((r18[0] - dArr[0]) * (r18[0] - dArr[0])) + ((r18[1] - dArr[1]) * (r18[1] - dArr[1]))) + ((r18[2] - dArr[2]) * (r18[2] - dArr[2]))) / 2.0d) * 1.27420015798544E7d;
        }

        public static int a(int i, int i2, boolean z) {
            String c = com.tencent.mapsdk.rastercore.tile.a.a.a().c();
            if (TextUtils.isEmpty(c)) {
                return b.a;
            }
            try {
                File file = new File(c + File.separator + "cache.info");
                if (file.exists() && file.isFile()) {
                    InputStream fileInputStream = new FileInputStream(file);
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    String str = "ss_" + i + "_" + i2;
                    Object property = properties.getProperty(z ? str + "_bing" : str, String.valueOf(z ? b.b : b.a));
                    if (!TextUtils.isEmpty(property)) {
                        return Integer.parseInt(property);
                    }
                }
            } catch (Exception e) {
                new StringBuilder("error read file:").append(c).append(" with error:").append(e.getMessage());
            }
            return z ? b.b : b.a;
        }

        public static int a(String str, boolean z) {
            String c = com.tencent.mapsdk.rastercore.tile.a.a.a().c();
            if (TextUtils.isEmpty(c) || TextUtils.isEmpty(str)) {
                return b.a;
            }
            try {
                File file = new File(c + File.separator + "cache.info");
                if (file.exists() && file.isFile()) {
                    InputStream fileInputStream = new FileInputStream(file);
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    String str2 = str + "_style";
                    if (z) {
                        str2 = str2 + "_bing";
                    }
                    Object property = properties.getProperty(str2, "1000");
                    if (!TextUtils.isEmpty(property)) {
                        return Integer.parseInt(property);
                    }
                }
            } catch (Exception e) {
                new StringBuilder("error read file:").append(c).append(" with error:").append(e.getMessage());
            }
            return BaseReportManager.MAX_READ_COUNT;
        }

        public static int a(byte[] bArr) {
            if (bArr != null && bArr.length == 4) {
                return (((bArr[0] & 255) | ((bArr[1] << 8) & 65280)) | ((bArr[2] << 16) & 16711680)) | ((bArr[3] << 24) & -16777216);
            }
            throw new IllegalArgumentException("Four bytes are required for an integer.");
        }

        public static LatLng a(com.tencent.mapsdk.rastercore.b.c cVar) {
            return new LatLng((double) ((float) (57.29577951308232d * ((2.0d * Math.atan(Math.exp((((double) ((float) ((cVar.a() * 180.0d) / 2.003750834E7d))) * 3.141592653589793d) / 180.0d))) - 1.5707963267948966d))), (double) ((float) ((cVar.b() * 180.0d) / 2.003750834E7d)));
        }

        public static com.tencent.mapsdk.rastercore.b.c a(PointF pointF, com.tencent.mapsdk.rastercore.b.c cVar, PointF pointF2, com.tencent.mapsdk.rastercore.b.a aVar) {
            return new com.tencent.mapsdk.rastercore.b.c(cVar.a() - (((double) (pointF.y - pointF2.y)) * aVar.d()), cVar.b() + (((double) (pointF.x - pointF2.x)) * aVar.d()));
        }

        public static com.tencent.mapsdk.rastercore.b.c a(LatLng latLng) {
            if (latLng == null) {
                return null;
            }
            return new com.tencent.mapsdk.rastercore.b.c(((Math.log(Math.tan(((latLng.getLatitude() + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d, (latLng.getLongitude() * 2.003750834E7d) / 180.0d);
        }

        public static com.tencent.mapsdk.rastercore.c.a a(float f, Point point) {
            com.tencent.mapsdk.rastercore.c.a eVar = new e();
            eVar.a(f);
            eVar.a(point);
            return eVar;
        }

        public static com.tencent.mapsdk.rastercore.c.a a(CameraPosition cameraPosition) {
            com.tencent.mapsdk.rastercore.c.a cVar = new com.tencent.mapsdk.rastercore.c.c();
            cVar.a(cameraPosition);
            return cVar;
        }

        public static com.tencent.mapsdk.rastercore.c.a a(LatLngBounds latLngBounds, int i, int i2, int i3) {
            com.tencent.mapsdk.rastercore.c.a bVar = new com.tencent.mapsdk.rastercore.c.b();
            bVar.a(latLngBounds);
            bVar.c(i3);
            bVar.a(i);
            bVar.b(i2);
            return bVar;
        }

        public static a a() {
            return a.a;
        }

        public static void a(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                }
            }
        }

        public static boolean a(int i) {
            String c = com.tencent.mapsdk.rastercore.tile.a.a.a().c();
            if (TextUtils.isEmpty(c) || !a(c)) {
                return false;
            }
            String str = c + File.separator + "cache.info";
            try {
                Properties properties = new Properties();
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    InputStream fileInputStream = new FileInputStream(str);
                    properties.load(fileInputStream);
                    fileInputStream.close();
                }
                properties.put("satellite_version", String.valueOf(i));
                properties.store(new FileOutputStream(str), "mapinfo");
                return true;
            } catch (Exception e) {
                new StringBuilder("error read file:").append(c).append(" with error:").append(e.getMessage());
                return false;
            }
        }

        public static boolean a(int i, int i2, int i3, boolean z) {
            Exception e;
            OutputStream outputStream;
            Throwable th;
            String c = com.tencent.mapsdk.rastercore.tile.a.a.a().c();
            if (TextUtils.isEmpty(c) || !a(c)) {
                return false;
            }
            String str = c + File.separator + "cache.info";
            FileOutputStream fileOutputStream = null;
            try {
                Properties properties = new Properties();
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    InputStream fileInputStream = new FileInputStream(str);
                    properties.load(fileInputStream);
                    fileInputStream.close();
                }
                Object obj = "ss_" + i + "_" + i2;
                if (z) {
                    obj = obj + "_bing";
                }
                properties.put(obj, String.valueOf(i3));
                OutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    properties.store(fileOutputStream2, "mapinfo");
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                    }
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    outputStream = fileOutputStream2;
                    try {
                        new StringBuilder("error read file:").append(c).append(" with error:").append(e.getMessage());
                        if (fileOutputStream != null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (IOException e4) {
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                new StringBuilder("error read file:").append(c).append(" with error:").append(e.getMessage());
                if (fileOutputStream != null) {
                    return false;
                }
                fileOutputStream.close();
                return false;
            }
        }

        public static boolean a(InputStream inputStream) {
            Throwable th;
            FileOutputStream fileOutputStream = null;
            String str = com.tencent.mapsdk.rastercore.tile.a.a.a().c() + "/frontier.dat";
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    fileOutputStream2.write(byteArrayOutputStream.toByteArray());
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e) {
                    }
                    return true;
                } catch (IOException e2) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e3) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                if (fileOutputStream != null) {
                    return false;
                }
                fileOutputStream.close();
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }

        public static boolean a(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                File file = new File(str);
                if (file.exists() && file.isDirectory()) {
                    return true;
                }
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
                return file.mkdirs();
            } catch (Exception e) {
                return false;
            }
        }

        public static boolean a(String str, int i, boolean z) {
            String c = com.tencent.mapsdk.rastercore.tile.a.a.a().c();
            if (!TextUtils.isEmpty(c) && a(c)) {
                String str2 = c + File.separator + "cache.info";
                try {
                    Properties properties = new Properties();
                    File file = new File(str2);
                    if (file.exists() && file.isFile()) {
                        InputStream fileInputStream = new FileInputStream(str2);
                        properties.load(fileInputStream);
                        fileInputStream.close();
                    }
                    Object obj = str + "_style";
                    if (z) {
                        obj = obj + "_bing";
                    }
                    properties.put(obj, String.valueOf(i));
                    properties.store(new FileOutputStream(str2), "mapinfo");
                } catch (Exception e) {
                    new StringBuilder("error read file:").append(c).append(" with error:").append(e.getMessage());
                }
            }
            return false;
        }

        public static int b() {
            String c = com.tencent.mapsdk.rastercore.tile.a.a.a().c();
            if (TextUtils.isEmpty(c)) {
                return 0;
            }
            try {
                File file = new File(c + File.separator + "cache.info");
                if (file.exists() && file.isFile()) {
                    InputStream fileInputStream = new FileInputStream(file);
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    fileInputStream.close();
                    Object property = properties.getProperty("satellite_version", String.valueOf(b.c));
                    if (!TextUtils.isEmpty(property)) {
                        return Integer.parseInt(property);
                    }
                }
            } catch (Exception e) {
                new StringBuilder("error read file:").append(c).append(" with error:").append(e.getMessage());
            }
            return b.c;
        }

        public static int b(String str, boolean z) {
            String c = com.tencent.mapsdk.rastercore.tile.a.a.a().c();
            if (TextUtils.isEmpty(c) || TextUtils.isEmpty(str)) {
                return b.a;
            }
            try {
                File file = new File(c + File.separator + "cache.info");
                if (file.exists() && file.isFile()) {
                    InputStream fileInputStream = new FileInputStream(file);
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    String str2 = str + "_scene";
                    if (z) {
                        str2 = str2 + "_bing";
                    }
                    Object property = properties.getProperty(str2, "0");
                    if (!TextUtils.isEmpty(property)) {
                        return Integer.parseInt(property);
                    }
                }
            } catch (Exception e) {
                new StringBuilder("error read file:").append(c).append(" with error:").append(e.getMessage());
            }
            return 0;
        }

        public static boolean b(String str, int i, boolean z) {
            String c = com.tencent.mapsdk.rastercore.tile.a.a.a().c();
            if (!TextUtils.isEmpty(c) && a(c)) {
                String str2 = c + File.separator + "cache.info";
                try {
                    Properties properties = new Properties();
                    File file = new File(str2);
                    if (file.exists() && file.isFile()) {
                        InputStream fileInputStream = new FileInputStream(str2);
                        properties.load(fileInputStream);
                        fileInputStream.close();
                    }
                    Object obj = str + "_scene";
                    if (z) {
                        obj = obj + "_bing";
                    }
                    properties.put(obj, String.valueOf(i));
                    properties.store(new FileOutputStream(str2), "mapinfo");
                } catch (Exception e) {
                    new StringBuilder("error read file:").append(c).append(" with error:").append(e.getMessage());
                }
            }
            return false;
        }

        public static byte[] b(int i) {
            return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((-16777216 & i) >> 24)};
        }

        public static byte[] b(InputStream inputStream) {
            Closeable byteArrayOutputStream;
            Throwable th;
            byte[] bArr = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr2 = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr2, 0, 4096);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    byteArrayOutputStream.flush();
                    bArr = byteArrayOutputStream.toByteArray();
                    a(byteArrayOutputStream);
                } catch (IOException e) {
                    a(byteArrayOutputStream);
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    a(byteArrayOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                byteArrayOutputStream = bArr;
                a(byteArrayOutputStream);
                return bArr;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                byteArrayOutputStream = bArr;
                th = th4;
                a(byteArrayOutputStream);
                throw th;
            }
            return bArr;
        }

        public static byte[] b(byte[] bArr) {
            if (bArr != null && bArr.length >= 2) {
                int i = 0;
                for (int length = bArr.length - 1; i < length; length--) {
                    byte b = bArr[i];
                    bArr[i] = bArr[length];
                    bArr[length] = b;
                    i++;
                }
            }
            return bArr;
        }

        public static String c() {
            FileInputStream fileInputStream;
            Exception e;
            Throwable th;
            try {
                fileInputStream = new FileInputStream(com.tencent.mapsdk.rastercore.tile.a.a.a().c() + "/frontier.dat");
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            String str = new String(byteArrayOutputStream.toByteArray(), ProtocolPackage.ServerEncoding);
                            try {
                                fileInputStream.close();
                                return str;
                            } catch (IOException e2) {
                                return str;
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        new StringBuilder("frontier.dat is not exist:").append(e.toString());
                        if (fileInputStream != null) {
                            return null;
                        }
                        try {
                            fileInputStream.close();
                            return null;
                        } catch (IOException e4) {
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileInputStream = null;
                new StringBuilder("frontier.dat is not exist:").append(e.toString());
                if (fileInputStream != null) {
                    return null;
                }
                fileInputStream.close();
                return null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
    }

    public interface b {
        void a(int i, int i2, int i3, int i4, int i5, int i6, Bitmap bitmap);
    }

    static class c extends AsyncTask<String, Void, d> {
        private b a;
        private int b;

        public c(b bVar, int i) {
            this.a = bVar;
            this.b = i;
        }

        private d a(String... strArr) {
            Throwable th;
            byte b = (byte) 0;
            d dVar = new d();
            if (strArr != null && strArr.length == 2) {
                int i;
                b.e = com.tencent.mapsdk.rastercore.d.e.z();
                dVar.a = b.e;
                dVar.c = com.tencent.mapsdk.rastercore.d.e.x();
                dVar.d = com.tencent.mapsdk.rastercore.d.e.v();
                dVar.e = com.tencent.mapsdk.rastercore.d.e.u();
                dVar.f = com.tencent.mapsdk.rastercore.d.e.t();
                a aVar = a.a;
                String c = a.c();
                if (d.a(c)) {
                    i = 0;
                } else {
                    String[] b2 = d.c(c);
                    i = !d.a(b2[0]) ? Integer.parseInt(b2[0]) : 0;
                    if (!d.a(b2[1])) {
                        c.a(b2[1]);
                    }
                }
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0] + "&&frontier=" + i).openConnection();
                    httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                    if (httpURLConnection.getResponseCode() == 200) {
                        String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                        if (headerField != null && headerField.length() > 0 && headerField.toLowerCase().contains("gzip")) {
                            b = (byte) 1;
                        }
                        JSONObject jSONObject = new JSONObject(new String(a.b(b != (byte) 0 ? new GZIPInputStream(httpURLConnection.getInputStream()) : httpURLConnection.getInputStream())));
                        if (jSONObject.optInt("error") != 0) {
                            return dVar;
                        }
                        JSONObject optJSONObject = jSONObject.optJSONObject("info");
                        if (optJSONObject == null) {
                            return dVar;
                        }
                        jSONObject = optJSONObject.optJSONObject("raster");
                        if (jSONObject == null) {
                            return dVar;
                        }
                        dVar.a = jSONObject.optInt("style", BaseReportManager.MAX_READ_COUNT);
                        dVar.b = jSONObject.optInt("scene", 0);
                        final int optInt = jSONObject.optInt("version", b.a);
                        aVar = a.a;
                        a.a(dVar.a, dVar.b, optInt, false);
                        aVar = a.a;
                        a.a(strArr[1], dVar.a, false);
                        aVar = a.a;
                        a.b(strArr[1], dVar.b, false);
                        jSONObject = optJSONObject.optJSONObject("world");
                        if (jSONObject == null) {
                            return dVar;
                        }
                        InputStream gZIPInputStream;
                        String[] b3;
                        dVar.d = jSONObject.optInt("style", BaseReportManager.MAX_READ_COUNT);
                        dVar.e = jSONObject.optInt("scene", 0);
                        final int optInt2 = jSONObject.optInt("version", b.b);
                        c = jSONObject.optString("logo");
                        if (c != null && c.trim().length() > 0) {
                            HttpURLConnection httpURLConnection2 = null;
                            try {
                                httpURLConnection = (HttpURLConnection) new URL(c).openConnection();
                                try {
                                    httpURLConnection.setRequestMethod("GET");
                                    httpURLConnection.setConnectTimeout(5000);
                                    if (httpURLConnection.getResponseCode() == 200) {
                                        dVar.g = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                } catch (Exception e) {
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    jSONObject = optJSONObject.optJSONObject("frontier");
                                    if (jSONObject != null) {
                                        c = jSONObject.optString("path");
                                        if (!d.a(c)) {
                                            httpURLConnection = (HttpURLConnection) new URL(c).openConnection();
                                            httpURLConnection.setRequestMethod("GET");
                                            httpURLConnection.setConnectTimeout(5000);
                                            if (httpURLConnection.getResponseCode() == 200) {
                                                gZIPInputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                                                aVar = a.a;
                                                a.a(gZIPInputStream);
                                                aVar = a.a;
                                                c = a.c();
                                                if (!d.a(c)) {
                                                    b3 = d.c(c);
                                                    if (!d.a(b3[1])) {
                                                        c.a(b3[1]);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    aVar = a.a;
                                    a.a(dVar.d, dVar.e, optInt2, true);
                                    aVar = a.a;
                                    a.a(strArr[1], dVar.d, true);
                                    aVar = a.a;
                                    a.b(strArr[1], dVar.e, true);
                                    if (optInt != dVar.c) {
                                        new Thread(this) {
                                            private /* synthetic */ c b;

                                            public final void run() {
                                                com.tencent.mapsdk.rastercore.tile.a.a.a().a(this.b.b, optInt, false);
                                            }
                                        }.start();
                                    }
                                    dVar.c = optInt;
                                    if (optInt2 != com.tencent.mapsdk.rastercore.d.e.t()) {
                                        new Thread(this) {
                                            public final void run() {
                                                com.tencent.mapsdk.rastercore.tile.a.a.a().a(com.tencent.mapsdk.rastercore.d.e.u(), optInt2, true);
                                            }
                                        }.start();
                                    }
                                    dVar.f = optInt2;
                                    return dVar;
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    httpURLConnection2 = httpURLConnection;
                                    th = th3;
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                    }
                                    throw th;
                                }
                            } catch (Exception e2) {
                                httpURLConnection = null;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                jSONObject = optJSONObject.optJSONObject("frontier");
                                if (jSONObject != null) {
                                    c = jSONObject.optString("path");
                                    if (d.a(c)) {
                                        httpURLConnection = (HttpURLConnection) new URL(c).openConnection();
                                        httpURLConnection.setRequestMethod("GET");
                                        httpURLConnection.setConnectTimeout(5000);
                                        if (httpURLConnection.getResponseCode() == 200) {
                                            gZIPInputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                                            aVar = a.a;
                                            a.a(gZIPInputStream);
                                            aVar = a.a;
                                            c = a.c();
                                            if (d.a(c)) {
                                                b3 = d.c(c);
                                                if (d.a(b3[1])) {
                                                    c.a(b3[1]);
                                                }
                                            }
                                        }
                                    }
                                }
                                aVar = a.a;
                                a.a(dVar.d, dVar.e, optInt2, true);
                                aVar = a.a;
                                a.a(strArr[1], dVar.d, true);
                                aVar = a.a;
                                a.b(strArr[1], dVar.e, true);
                                if (optInt != dVar.c) {
                                    /* anonymous class already generated */.start();
                                }
                                dVar.c = optInt;
                                if (optInt2 != com.tencent.mapsdk.rastercore.d.e.t()) {
                                    /* anonymous class already generated */.start();
                                }
                                dVar.f = optInt2;
                                return dVar;
                            } catch (Throwable th4) {
                                th = th4;
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                throw th;
                            }
                        }
                        try {
                            jSONObject = optJSONObject.optJSONObject("frontier");
                            if (jSONObject != null) {
                                c = jSONObject.optString("path");
                                if (d.a(c)) {
                                    httpURLConnection = (HttpURLConnection) new URL(c).openConnection();
                                    httpURLConnection.setRequestMethod("GET");
                                    httpURLConnection.setConnectTimeout(5000);
                                    if (httpURLConnection.getResponseCode() == 200) {
                                        gZIPInputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                                        aVar = a.a;
                                        a.a(gZIPInputStream);
                                        aVar = a.a;
                                        c = a.c();
                                        if (d.a(c)) {
                                            b3 = d.c(c);
                                            if (d.a(b3[1])) {
                                                c.a(b3[1]);
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e3) {
                            new StringBuilder("frontier is already the new:").append(e3.toString());
                        }
                        aVar = a.a;
                        a.a(dVar.d, dVar.e, optInt2, true);
                        aVar = a.a;
                        a.a(strArr[1], dVar.d, true);
                        aVar = a.a;
                        a.b(strArr[1], dVar.e, true);
                        if (optInt != dVar.c) {
                            /* anonymous class already generated */.start();
                        }
                        dVar.c = optInt;
                        if (optInt2 != com.tencent.mapsdk.rastercore.d.e.t()) {
                            /* anonymous class already generated */.start();
                        }
                        dVar.f = optInt2;
                    }
                } catch (Exception e32) {
                    new StringBuilder("check version got error:").append(e32.getMessage());
                }
            }
            return dVar;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((String[]) objArr);
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            d dVar = (d) obj;
            if (dVar != null && this.a != null) {
                this.a.a(dVar.a, dVar.b, dVar.c, dVar.d, dVar.e, dVar.f, dVar.g);
            }
        }
    }

    static class d {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public Bitmap g;

        private d() {
            this.a = BaseReportManager.MAX_READ_COUNT;
            this.b = 0;
            this.c = b.a;
            this.d = BaseReportManager.MAX_READ_COUNT;
            this.e = 0;
            this.f = b.b;
            this.g = null;
        }
    }

    public d(Context context, b bVar, int i, int i2) {
        String a = com.tencent.mapsdk.rastercore.f.a.a(context);
        this.c = context.getPackageName();
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("http://confinfo.map.qq.com/confinfo?apikey=");
        stringBuilder.append(a);
        stringBuilder.append("&scene=in:");
        stringBuilder.append(i);
        stringBuilder.append(",out:");
        stringBuilder.append(i2);
        stringBuilder.append("&type=2");
        this.a = stringBuilder.toString();
        this.b = new c(bVar, i);
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    private static String[] c(String str) {
        String[] strArr = new String[2];
        try {
            JSONObject jSONObject = new JSONObject(str);
            strArr[0] = jSONObject.optString("version");
            strArr[1] = jSONObject.optString("data");
        } catch (JSONException e) {
        }
        return strArr;
    }

    public final void a() {
        this.b.execute(new String[]{this.a, this.c});
    }
}
