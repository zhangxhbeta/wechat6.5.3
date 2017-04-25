package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.c.r;
import com.google.android.gms.c.s;
import com.google.android.gms.c.x;
import com.google.android.gms.c.y;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SafeParcelResponse extends FastJsonResponse implements SafeParcelable {
    public static final e CREATOR = new e();
    final FieldMappingDictionary apO;
    private final Parcel apW;
    final int apX = 2;
    private int apY;
    private int apZ;
    final int mVersionCode;
    private final String qG;

    SafeParcelResponse(int i, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.mVersionCode = i;
        this.apW = (Parcel) w.Z(parcel);
        this.apO = fieldMappingDictionary;
        if (this.apO == null) {
            this.qG = null;
        } else {
            this.qG = this.apO.apS;
        }
        this.apY = 2;
    }

    private static void a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"").append(x.ag(obj.toString())).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(s.d((byte[]) obj)).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(s.e((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                y.a(stringBuilder, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void a(StringBuilder stringBuilder, Field<?, ?> field, Parcel parcel, int i) {
        boolean[] zArr = null;
        int i2 = 0;
        int a;
        if (field.ki()) {
            stringBuilder.append("[");
            int dataPosition;
            switch (field.kh()) {
                case 0:
                    a = a.a(parcel, i);
                    dataPosition = parcel.dataPosition();
                    if (a != 0) {
                        zArr = parcel.createIntArray();
                        parcel.setDataPosition(a + dataPosition);
                    }
                    a = zArr.length;
                    while (i2 < a) {
                        if (i2 != 0) {
                            stringBuilder.append(",");
                        }
                        stringBuilder.append(Integer.toString(zArr[i2]));
                        i2++;
                    }
                    break;
                case 1:
                    Object[] objArr;
                    a = a.a(parcel, i);
                    dataPosition = parcel.dataPosition();
                    if (a != 0) {
                        int readInt = parcel.readInt();
                        objArr = new BigInteger[readInt];
                        while (i2 < readInt) {
                            objArr[i2] = new BigInteger(parcel.createByteArray());
                            i2++;
                        }
                        parcel.setDataPosition(a + dataPosition);
                    }
                    r.a(stringBuilder, objArr);
                    break;
                case 2:
                    long[] createLongArray;
                    a = a.a(parcel, i);
                    i2 = parcel.dataPosition();
                    if (a != 0) {
                        createLongArray = parcel.createLongArray();
                        parcel.setDataPosition(a + i2);
                    }
                    r.a(stringBuilder, createLongArray);
                    break;
                case 3:
                    float[] createFloatArray;
                    a = a.a(parcel, i);
                    i2 = parcel.dataPosition();
                    if (a != 0) {
                        createFloatArray = parcel.createFloatArray();
                        parcel.setDataPosition(a + i2);
                    }
                    r.a(stringBuilder, createFloatArray);
                    break;
                case 4:
                    double[] createDoubleArray;
                    a = a.a(parcel, i);
                    i2 = parcel.dataPosition();
                    if (a != 0) {
                        createDoubleArray = parcel.createDoubleArray();
                        parcel.setDataPosition(a + i2);
                    }
                    r.a(stringBuilder, createDoubleArray);
                    break;
                case 5:
                    r.a(stringBuilder, a.o(parcel, i));
                    break;
                case 6:
                    a = a.a(parcel, i);
                    i2 = parcel.dataPosition();
                    if (a != 0) {
                        zArr = parcel.createBooleanArray();
                        parcel.setDataPosition(a + i2);
                    }
                    r.a(stringBuilder, zArr);
                    break;
                case 7:
                    r.a(stringBuilder, a.p(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] s = a.s(parcel, i);
                    dataPosition = s.length;
                    for (int i3 = 0; i3 < dataPosition; i3++) {
                        if (i3 > 0) {
                            stringBuilder.append(",");
                        }
                        s[i3].setDataPosition(0);
                        a(stringBuilder, field.kn(), s[i3]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (field.kh()) {
            case 0:
                stringBuilder.append(a.e(parcel, i));
                return;
            case 1:
                stringBuilder.append(a.g(parcel, i));
                return;
            case 2:
                stringBuilder.append(a.f(parcel, i));
                return;
            case 3:
                stringBuilder.append(a.h(parcel, i));
                return;
            case 4:
                stringBuilder.append(a.i(parcel, i));
                return;
            case 5:
                stringBuilder.append(a.j(parcel, i));
                return;
            case 6:
                stringBuilder.append(a.c(parcel, i));
                return;
            case 7:
                stringBuilder.append("\"").append(x.ag(a.k(parcel, i))).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(s.d(a.n(parcel, i))).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(s.e(a.n(parcel, i)));
                stringBuilder.append("\"");
                return;
            case 10:
                Bundle m = a.m(parcel, i);
                Set<String> keySet = m.keySet();
                keySet.size();
                stringBuilder.append("{");
                a = 1;
                for (String str : keySet) {
                    if (a == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(x.ag(m.getString(str))).append("\"");
                    a = 0;
                }
                stringBuilder.append("}");
                return;
            case 11:
                Parcel r = a.r(parcel, i);
                r.setDataPosition(0);
                a(stringBuilder, field.kn(), r);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void a(StringBuilder stringBuilder, Map<String, Field<?, ?>> map, Parcel parcel) {
        HashMap hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            Entry entry2;
            hashMap.put(Integer.valueOf(((Field) entry2.getValue()).kk()), entry2);
        }
        stringBuilder.append('{');
        int b = a.b(parcel);
        Object obj = null;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            entry2 = (Entry) hashMap.get(Integer.valueOf(65535 & readInt));
            if (entry2 != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                String str = (String) entry2.getKey();
                Field field = (Field) entry2.getValue();
                stringBuilder.append("\"").append(str).append("\":");
                if ((field.apP != null ? 1 : null) != null) {
                    switch (field.kh()) {
                        case 0:
                            b(stringBuilder, field, FastJsonResponse.a(field, Integer.valueOf(a.e(parcel, readInt))));
                            break;
                        case 1:
                            b(stringBuilder, field, FastJsonResponse.a(field, a.g(parcel, readInt)));
                            break;
                        case 2:
                            b(stringBuilder, field, FastJsonResponse.a(field, Long.valueOf(a.f(parcel, readInt))));
                            break;
                        case 3:
                            b(stringBuilder, field, FastJsonResponse.a(field, Float.valueOf(a.h(parcel, readInt))));
                            break;
                        case 4:
                            b(stringBuilder, field, FastJsonResponse.a(field, Double.valueOf(a.i(parcel, readInt))));
                            break;
                        case 5:
                            b(stringBuilder, field, FastJsonResponse.a(field, a.j(parcel, readInt)));
                            break;
                        case 6:
                            b(stringBuilder, field, FastJsonResponse.a(field, Boolean.valueOf(a.c(parcel, readInt))));
                            break;
                        case 7:
                            b(stringBuilder, field, FastJsonResponse.a(field, a.k(parcel, readInt)));
                            break;
                        case 8:
                        case 9:
                            b(stringBuilder, field, FastJsonResponse.a(field, a.n(parcel, readInt)));
                            break;
                        case 10:
                            b(stringBuilder, field, FastJsonResponse.a(field, h(a.m(parcel, readInt))));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException("Unknown field out type = " + field.kh());
                    }
                }
                a(stringBuilder, field, parcel, readInt);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new a.a("Overread allowed size end=" + b, parcel);
        }
        stringBuilder.append('}');
    }

    private void b(StringBuilder stringBuilder, Field<?, ?> field, Object obj) {
        if (field.kg()) {
            ArrayList arrayList = (ArrayList) obj;
            stringBuilder.append("[");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    stringBuilder.append(",");
                }
                a(stringBuilder, field.kf(), arrayList.get(i));
            }
            stringBuilder.append("]");
            return;
        }
        a(stringBuilder, field.kf(), obj);
    }

    private static HashMap<String, String> h(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public int describeContents() {
        return 0;
    }

    public final Map<String, Field<?, ?>> kc() {
        return this.apO == null ? null : this.apO.X(this.qG);
    }

    protected final Object kd() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected final boolean ke() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final Parcel kq() {
        switch (this.apY) {
            case 0:
                this.apZ = b.t(this.apW, 20293);
                break;
            case 1:
                break;
        }
        b.u(this.apW, this.apZ);
        this.apY = 2;
        return this.apW;
    }

    public String toString() {
        w.h(this.apO, "Cannot convert to JSON on client side.");
        Parcel kq = kq();
        kq.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        a(stringBuilder, this.apO.X(this.qG), kq);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel, i);
    }
}
