package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.c.s;
import com.google.android.gms.c.x;
import com.google.android.gms.c.y;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public static class Field<I, O> implements SafeParcelable {
        public static final a CREATOR = new a();
        protected final int apG;
        protected final boolean apH;
        protected final int apI;
        protected final boolean apJ;
        protected final String apK;
        protected final int apL;
        protected final Class<? extends FastJsonResponse> apM;
        protected final String apN;
        FieldMappingDictionary apO;
        a<I, O> apP;
        final int mVersionCode;

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            a aVar = null;
            this.mVersionCode = i;
            this.apG = i2;
            this.apH = z;
            this.apI = i3;
            this.apJ = z2;
            this.apK = str;
            this.apL = i4;
            if (str2 == null) {
                this.apM = null;
                this.apN = null;
            } else {
                this.apM = SafeParcelResponse.class;
                this.apN = str2;
            }
            if (converterWrapper != null) {
                if (converterWrapper.apA != null) {
                    aVar = converterWrapper.apA;
                } else {
                    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
                }
            }
            this.apP = aVar;
        }

        public int describeContents() {
            return 0;
        }

        public final int kf() {
            return this.apG;
        }

        public final boolean kg() {
            return this.apH;
        }

        public final int kh() {
            return this.apI;
        }

        public final boolean ki() {
            return this.apJ;
        }

        public final String kj() {
            return this.apK;
        }

        public final int kk() {
            return this.apL;
        }

        public final Class<? extends FastJsonResponse> kl() {
            return this.apM;
        }

        final String km() {
            return this.apN == null ? null : this.apN;
        }

        public final Map<String, Field<?, ?>> kn() {
            w.Z(this.apN);
            w.Z(this.apO);
            return this.apO.X(this.apN);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.mVersionCode).append('\n');
            stringBuilder.append("                 typeIn=").append(this.apG).append('\n');
            stringBuilder.append("            typeInArray=").append(this.apH).append('\n');
            stringBuilder.append("                typeOut=").append(this.apI).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.apJ).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.apK).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.apL).append('\n');
            stringBuilder.append("       concreteTypeName=").append(km()).append('\n');
            if (this.apM != null) {
                stringBuilder.append("     concreteType.class=").append(this.apM.getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.apP == null ? "null" : this.apP.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            a.a(this, parcel, i);
        }
    }

    public interface a<I, O> {
        I convertBack(O o);
    }

    private Object a(Field field) {
        String kj = field.kj();
        if (field.kl() != null) {
            field.kj();
            w.a(kd() == null, "Concrete field shouldn't be value object: %s", new Object[]{field.kj()});
            field.ki();
            try {
                return getClass().getMethod("get" + Character.toUpperCase(kj.charAt(0)) + kj.substring(1), new Class[0]).invoke(this, new Object[0]);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        field.kj();
        return kd();
    }

    protected static <O, I> I a(Field<I, O> field, Object obj) {
        return field.apP != null ? field.apP.convertBack(obj) : obj;
    }

    private static void a(StringBuilder stringBuilder, Field field, Object obj) {
        if (field.kf() == 11) {
            stringBuilder.append(((FastJsonResponse) field.kl().cast(obj)).toString());
        } else if (field.kf() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(x.ag((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private static void a(StringBuilder stringBuilder, Field field, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                a(stringBuilder, field, obj);
            }
        }
        stringBuilder.append("]");
    }

    public abstract Map<String, Field<?, ?>> kc();

    protected abstract Object kd();

    protected abstract boolean ke();

    public String toString() {
        Map kc = kc();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : kc.keySet()) {
            Field field = (Field) kc.get(str);
            if (field.kh() != 11) {
                field.kj();
                if (ke()) {
                    Object a = a(field, a(field));
                    if (stringBuilder.length() == 0) {
                        stringBuilder.append("{");
                    } else {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\":");
                    if (a != null) {
                        switch (field.kh()) {
                            case 8:
                                stringBuilder.append("\"").append(s.d((byte[]) a)).append("\"");
                                break;
                            case 9:
                                stringBuilder.append("\"").append(s.e((byte[]) a)).append("\"");
                                break;
                            case 10:
                                y.a(stringBuilder, (HashMap) a);
                                break;
                            default:
                                if (!field.kg()) {
                                    a(stringBuilder, field, a);
                                    break;
                                }
                                a(stringBuilder, field, (ArrayList) a);
                                break;
                        }
                    }
                    stringBuilder.append("null");
                }
            } else if (field.ki()) {
                field.kj();
                throw new UnsupportedOperationException("Concrete type arrays not supported");
            } else {
                field.kj();
                throw new UnsupportedOperationException("Concrete types not supported");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
