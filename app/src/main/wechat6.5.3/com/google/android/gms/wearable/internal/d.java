package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.g;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class d implements f {
    private byte[] aDR;
    private Map<String, g> aFa;
    private Uri mUri;

    public d(f fVar) {
        this.mUri = fVar.getUri();
        this.aDR = fVar.getData();
        Map hashMap = new HashMap();
        for (Entry entry : fVar.my().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), ((g) entry.getValue()).jH());
            }
        }
        this.aFa = Collections.unmodifiableMap(hashMap);
    }

    public final byte[] getData() {
        return this.aDR;
    }

    public final Uri getUri() {
        return this.mUri;
    }

    public final /* synthetic */ Object jH() {
        return this;
    }

    public final Map<String, g> my() {
        return this.aFa;
    }

    public final String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder stringBuilder = new StringBuilder("DataItemEntity{ ");
        stringBuilder.append("uri=" + this.mUri);
        stringBuilder.append(", dataSz=" + (this.aDR == null ? "null" : Integer.valueOf(this.aDR.length)));
        stringBuilder.append(", numAssets=" + this.aFa.size());
        if (isLoggable && !this.aFa.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = SQLiteDatabase.KeyEmpty;
            String str2 = str;
            for (Entry entry : this.aFa.entrySet()) {
                stringBuilder.append(str2 + ((String) entry.getKey()) + ": " + ((g) entry.getValue()).getId());
                str2 = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
