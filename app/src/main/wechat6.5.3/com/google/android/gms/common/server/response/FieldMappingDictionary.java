package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary implements SafeParcelable {
    public static final c CREATOR = new c();
    final HashMap<String, Map<String, Field<?, ?>>> apQ;
    private final ArrayList<Entry> apR = null;
    final String apS;
    final int mVersionCode;

    public static class Entry implements SafeParcelable {
        public static final d CREATOR = new d();
        final ArrayList<FieldMapPair> apT;
        final String className;
        final int versionCode;

        Entry(int i, String str, ArrayList<FieldMapPair> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.apT = arrayList;
        }

        Entry(String str, Map<String, Field<?, ?>> map) {
            this.versionCode = 1;
            this.className = str;
            this.apT = b(map);
        }

        private static ArrayList<FieldMapPair> b(Map<String, Field<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList<FieldMapPair> arrayList = new ArrayList();
            for (String str : map.keySet()) {
                arrayList.add(new FieldMapPair(str, (Field) map.get(str)));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        final HashMap<String, Field<?, ?>> kp() {
            HashMap<String, Field<?, ?>> hashMap = new HashMap();
            int size = this.apT.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = (FieldMapPair) this.apT.get(i);
                hashMap.put(fieldMapPair.apU, fieldMapPair.apV);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel parcel, int i) {
            d.a(this, parcel);
        }
    }

    public static class FieldMapPair implements SafeParcelable {
        public static final b CREATOR = new b();
        final String apU;
        final Field<?, ?> apV;
        final int versionCode;

        FieldMapPair(int i, String str, Field<?, ?> field) {
            this.versionCode = i;
            this.apU = str;
            this.apV = field;
        }

        FieldMapPair(String str, Field<?, ?> field) {
            this.versionCode = 1;
            this.apU = str;
            this.apV = field;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            b.a(this, parcel, i);
        }
    }

    FieldMappingDictionary(int i, ArrayList<Entry> arrayList, String str) {
        this.mVersionCode = i;
        this.apQ = c(arrayList);
        this.apS = (String) w.Z(str);
        ko();
    }

    private static HashMap<String, Map<String, Field<?, ?>>> c(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, Field<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) arrayList.get(i);
            hashMap.put(entry.className, entry.kp());
        }
        return hashMap;
    }

    private void ko() {
        for (String str : this.apQ.keySet()) {
            Map map = (Map) this.apQ.get(str);
            for (String str2 : map.keySet()) {
                ((Field) map.get(str2)).apO = this;
            }
        }
    }

    public final Map<String, Field<?, ?>> X(String str) {
        return (Map) this.apQ.get(str);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.apQ.keySet()) {
            stringBuilder.append(str).append(":\n");
            Map map = (Map) this.apQ.get(str);
            for (String str2 : map.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(map.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel);
    }
}
