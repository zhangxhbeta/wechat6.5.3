package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.os.Bundle;
import ct.b.a;
import ct.cb;

public abstract class TencentHttpClientFactory {
    private static TencentHttpClientFactory sCustFact;

    public abstract Bundle getParams();

    public static TencentHttpClientFactory getInstance() {
        return new TencentHttpClientFactory() {
            public final Bundle getParams() {
                return null;
            }
        };
    }

    public static void setTencentHttpClientFactory(TencentHttpClientFactory tencentHttpClientFactory) {
        sCustFact = tencentHttpClientFactory;
    }

    public TencentHttpClient getTencentHttpClient(Context context, Bundle bundle) {
        if (sCustFact != null) {
            return (TencentHttpClient) a.b(sCustFact.getTencentHttpClient(context, sCustFact.getParams()), (Object) "http client should NOT be null");
        }
        return new cb(context, bundle.getString("channelId"));
    }
}
