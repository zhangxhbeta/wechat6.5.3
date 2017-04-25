package com.tencent.map.geolocation;

public interface TencentDistanceAnalysis {
    double getConfidence();

    int getGpsCount();

    int getNetworkCount();
}
