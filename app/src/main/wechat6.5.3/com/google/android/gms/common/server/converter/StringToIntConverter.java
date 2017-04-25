package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter implements SafeParcelable, a<String, Integer> {
    public static final b CREATOR = new b();
    final HashMap<String, Integer> apB;
    private final HashMap<Integer, String> apC;
    private final ArrayList<Entry> apD;
    final int mVersionCode;

    public static final class Entry implements SafeParcelable {
        public static final c CREATOR = new c();
        final String apE;
        final int apF;
        final int versionCode;

        Entry(int i, String str, int i2) {
            this.versionCode = i;
            this.apE = str;
            this.apF = i2;
        }

        Entry(String str, int i) {
            this.versionCode = 1;
            this.apE = str;
            this.apF = i;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            c.a(this, parcel);
        }
    }

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.apB = new HashMap();
        this.apC = new HashMap();
        this.apD = null;
    }

    StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.mVersionCode = i;
        this.apB = new HashMap();
        this.apC = new HashMap();
        this.apD = null;
        b(arrayList);
    }

    private void b(ArrayList<Entry> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str = entry.apE;
            int i = entry.apF;
            this.apB.put(str, Integer.valueOf(i));
            this.apC.put(Integer.valueOf(i), str);
        }
    }

    public final /* synthetic */ Object convertBack(Object obj) {
        String str = (String) this.apC.get((Integer) obj);
        return (str == null && this.apB.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
