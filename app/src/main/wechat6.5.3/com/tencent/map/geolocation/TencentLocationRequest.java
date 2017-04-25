package com.tencent.map.geolocation;

import android.os.Bundle;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class TencentLocationRequest {
    public static final int REQUEST_LEVEL_ADMIN_AREA = 3;
    public static final int REQUEST_LEVEL_FORMATTED_ADDRESS = 5;
    public static final int REQUEST_LEVEL_GEO = 0;
    public static final int REQUEST_LEVEL_GLOBAL_ADMIN_AREA = 7;
    public static final int REQUEST_LEVEL_NAME = 1;
    public static final int REQUEST_LEVEL_POI = 4;
    private long a;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private long f;
    private int g;
    private String h;
    private Bundle i;

    private TencentLocationRequest() {
    }

    public TencentLocationRequest(TencentLocationRequest tencentLocationRequest) {
        this.a = tencentLocationRequest.a;
        this.b = tencentLocationRequest.b;
        this.d = tencentLocationRequest.d;
        this.e = tencentLocationRequest.e;
        this.f = tencentLocationRequest.f;
        this.g = tencentLocationRequest.g;
        this.c = tencentLocationRequest.c;
        this.h = tencentLocationRequest.h;
        this.i = new Bundle();
        this.i.putAll(tencentLocationRequest.i);
    }

    public static void copy(TencentLocationRequest tencentLocationRequest, TencentLocationRequest tencentLocationRequest2) {
        tencentLocationRequest.a = tencentLocationRequest2.a;
        tencentLocationRequest.b = tencentLocationRequest2.b;
        tencentLocationRequest.d = tencentLocationRequest2.d;
        tencentLocationRequest.e = tencentLocationRequest2.e;
        tencentLocationRequest.f = tencentLocationRequest2.f;
        tencentLocationRequest.g = tencentLocationRequest2.g;
        tencentLocationRequest.c = tencentLocationRequest2.c;
        tencentLocationRequest.h = tencentLocationRequest2.h;
        tencentLocationRequest.i.clear();
        tencentLocationRequest.i.putAll(tencentLocationRequest2.i);
    }

    public static TencentLocationRequest create() {
        TencentLocationRequest tencentLocationRequest = new TencentLocationRequest();
        tencentLocationRequest.a = 10000;
        tencentLocationRequest.b = 1;
        tencentLocationRequest.d = true;
        tencentLocationRequest.e = false;
        tencentLocationRequest.f = Long.MAX_VALUE;
        tencentLocationRequest.g = Integer.MAX_VALUE;
        tencentLocationRequest.c = true;
        tencentLocationRequest.h = SQLiteDatabase.KeyEmpty;
        tencentLocationRequest.i = new Bundle();
        return tencentLocationRequest;
    }

    public final TencentLocationRequest setInterval(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("interval should >= 0");
        }
        this.a = j;
        return this;
    }

    public final TencentLocationRequest setRequestLevel(int i) {
        if (TencentExtraKeys.isAllowedLevel(i)) {
            this.b = i;
            return this;
        }
        throw new IllegalArgumentException("request_level: " + i + " not supported!");
    }

    public final TencentLocationRequest setAllowCache(boolean z) {
        this.d = z;
        return this;
    }

    public final TencentLocationRequest setAllowGPS(boolean z) {
        this.c = z;
        return this;
    }

    public final TencentLocationRequest setAllowDirection(boolean z) {
        this.e = z;
        return this;
    }

    public final TencentLocationRequest setQQ(String str) {
        this.h = str;
        return this;
    }

    public final String getQQ() {
        return this.h;
    }

    public final TencentLocationRequest setPhoneNumber(String str) {
        if (str == null) {
            str = SQLiteDatabase.KeyEmpty;
        }
        this.i.putString("phoneNumber", str);
        return this;
    }

    public final String getPhoneNumber() {
        String string = this.i.getString("phoneNumber");
        if (string == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        return string;
    }

    public final long getInterval() {
        return this.a;
    }

    public final int getRequestLevel() {
        return this.b;
    }

    public final boolean isAllowCache() {
        return this.d;
    }

    public final boolean isAllowGPS() {
        return this.c;
    }

    public final boolean isAllowDirection() {
        return this.e;
    }

    public final Bundle getExtras() {
        return this.i;
    }

    public final String toString() {
        return "TencentLocationRequest {interval=" + this.a + "ms,level=" + this.b + ",allowCache=" + this.d + ",allowGps=" + this.c + ",allowDirection=" + this.e + ",QQ=" + this.h + "}";
    }
}
