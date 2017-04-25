package com.tencent.mm.ae.a.b;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDebug;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class b implements com.tencent.mm.ae.a.c.b {
    public final com.tencent.mm.ae.a.d.b ji(String str) {
        v.d("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data from url:%s", str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(20000);
            if (httpURLConnection == null) {
                v.i("MicroMsg.imageload.DefaultImageDownloader.HttpClientFactory", "open connection failed.");
            }
            if (httpURLConnection.getResponseCode() >= SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD) {
                httpURLConnection.disconnect();
                v.w("MicroMsg.imageload.DefaultImageDownloader.HttpClientFactory", "dz[httpURLConnectionGet 300]");
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            String contentType = httpURLConnection.getContentType();
            byte[] g = e.g(inputStream);
            httpURLConnection.disconnect();
            return new com.tencent.mm.ae.a.d.b(g, contentType);
        } catch (Throwable e) {
            v.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", be.e(e));
            return new com.tencent.mm.ae.a.d.b(null, null);
        } catch (Throwable e2) {
            v.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", be.e(e2));
            return new com.tencent.mm.ae.a.d.b(null, null);
        } catch (Throwable e22) {
            v.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", be.e(e22));
            return new com.tencent.mm.ae.a.d.b(null, null);
        } catch (Throwable e222) {
            v.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", be.e(e222));
            return new com.tencent.mm.ae.a.d.b(null, null);
        } catch (Throwable e2222) {
            v.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", be.e(e2222));
            return new com.tencent.mm.ae.a.d.b(null, null);
        } catch (Throwable e22222) {
            v.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", be.e(e22222));
            return new com.tencent.mm.ae.a.d.b(null, null);
        } catch (Throwable e222222) {
            v.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", be.e(e222222));
            return new com.tencent.mm.ae.a.d.b(null, null);
        }
    }
}
