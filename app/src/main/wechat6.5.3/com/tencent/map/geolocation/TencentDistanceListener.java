package com.tencent.map.geolocation;

public interface TencentDistanceListener {
    void onDistanceChanged(TencentLocation tencentLocation, double d, int i, String str);
}
