package com.tencent.tmassistantsdk.downloadservice;

import android.text.TextUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HttpClientUtil {
    public static void setProxy(HttpClient httpClient) {
        String netStatus = DownloadHelper.getNetStatus();
        if (!TextUtils.isEmpty(netStatus)) {
            if (netStatus.equalsIgnoreCase("cmwap") || netStatus.equalsIgnoreCase("3gwap") || netStatus.equalsIgnoreCase("uniwap")) {
                httpClient.getParams().setParameter("http.route.default-proxy", new HttpHost("10.0.0.172", 80));
            } else if (netStatus.equalsIgnoreCase("ctwap")) {
                httpClient.getParams().setParameter("http.route.default-proxy", new HttpHost("10.0.0.200", 80));
            }
        }
    }

    public static HttpClient createHttpClient() {
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 4096);
        HttpClientParams.setRedirecting(basicHttpParams, false);
        return new DefaultHttpClient(basicHttpParams);
    }
}
