package com.tencent.tmassistantsdk.channel;

import java.util.ArrayList;

public class TMAssistantSDKChannel {
    public synchronized ArrayList<TMAssistantSDKChannelDataItem> getChannelDataItemList() {
        return new DBOption().queryAll();
    }

    public synchronized long AddDataItem(String str, int i, String str2, int i2, String str3, long j, long j2, int i3, byte[] bArr) {
        return new DBOption().insert(new TMAssistantSDKChannelDataItem(str, i, str2, i2, str3, j, j2, i3, bArr));
    }

    public synchronized boolean delDataItem(long j) {
        boolean z;
        if (j < 0) {
            z = false;
        } else {
            z = new DBOption().delete(j);
        }
        return z;
    }
}
