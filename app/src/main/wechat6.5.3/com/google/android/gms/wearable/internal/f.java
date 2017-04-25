package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.g;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class f extends com.google.android.gms.common.data.f implements com.google.android.gms.wearable.f {
    private final int aFt;

    public f(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.aFt = i2;
    }

    public final byte[] getData() {
        return getByteArray("data");
    }

    public final Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public final /* synthetic */ Object jH() {
        return new d(this);
    }

    public final Map<String, g> my() {
        Map<String, g> hashMap = new HashMap(this.aFt);
        for (int i = 0; i < this.aFt; i++) {
            c cVar = new c(this.amM, this.ani + i);
            if (cVar.getString("asset_key") != null) {
                hashMap.put(cVar.getString("asset_key"), cVar);
            }
        }
        return hashMap;
    }

    public final String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        byte[] byteArray = getByteArray("data");
        Map my = my();
        StringBuilder stringBuilder = new StringBuilder("DataItemInternal{ ");
        stringBuilder.append("uri=" + getUri());
        stringBuilder.append(", dataSz=" + (byteArray == null ? "null" : Integer.valueOf(byteArray.length)));
        stringBuilder.append(", numAssets=" + my.size());
        if (isLoggable && !my.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = SQLiteDatabase.KeyEmpty;
            String str2 = str;
            for (Entry entry : my.entrySet()) {
                stringBuilder.append(str2 + ((String) entry.getKey()) + ": " + ((g) entry.getValue()).getId());
                str2 = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
