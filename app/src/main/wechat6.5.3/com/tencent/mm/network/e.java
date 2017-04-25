package com.tencent.mm.network;

import com.tencent.mm.network.a.b;
import com.tencent.mm.protocal.ac;
import java.util.List;

public interface e {
    boolean BK();

    c BU();

    h BV();

    void BW();

    int a(q qVar, k kVar);

    int a(String str, boolean z, List<String> list);

    void a(int i, String str, int i2, boolean z);

    void a(b bVar);

    void a(n nVar);

    void a(ac acVar);

    void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4);

    void aT(boolean z);

    void aU(boolean z);

    void aV(boolean z);

    void aW(boolean z);

    void cancel(int i);

    void gT(String str);

    void gU(String str);

    int getHostByName(String str, List<String> list);

    String[] getIPsString(boolean z);

    String getIspId();

    String getNetworkServerIp();

    void keepSignalling();

    void reportFailIp(String str);

    void reset();

    void setHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    void setSignallingStrategy(long j, long j2);

    void stopSignalling();
}
