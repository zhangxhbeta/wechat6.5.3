package com.tencent.mm.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MCacheItem implements Parcelable {
    public static final Creator<MCacheItem> CREATOR = new Creator<MCacheItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MCacheItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MCacheItem[i];
        }
    };
    private c caC;

    static class a {
        public static Map<Class<?>, Method> caD = new HashMap();
        public static Map<Class<?>, Method> caE = new HashMap();

        a() {
        }

        static {
            try {
                caD.put(byte[].class, a.class.getMethod("keep_writeByteArray", new Class[]{Parcel.class, Field.class, Object.class}));
                caD.put(Short.TYPE, a.class.getMethod("keep_writeShort", new Class[]{Parcel.class, Field.class, Object.class}));
                caD.put(Short.class, a.class.getMethod("keep_writeShort", new Class[]{Parcel.class, Field.class, Object.class}));
                caD.put(Boolean.TYPE, a.class.getMethod("keep_writeBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
                caD.put(Boolean.class, a.class.getMethod("keep_writeBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
                caD.put(Integer.TYPE, a.class.getMethod("keep_writeInt", new Class[]{Parcel.class, Field.class, Object.class}));
                caD.put(Integer.class, a.class.getMethod("keep_writeInt", new Class[]{Parcel.class, Field.class, Object.class}));
                caD.put(Float.TYPE, a.class.getMethod("keep_writeFloat", new Class[]{Parcel.class, Field.class, Object.class}));
                caD.put(Float.class, a.class.getMethod("keep_writeFloat", new Class[]{Parcel.class, Field.class, Object.class}));
                caD.put(Double.TYPE, a.class.getMethod("keep_writeDouble", new Class[]{Parcel.class, Field.class, Object.class}));
                caD.put(Double.class, a.class.getMethod("keep_writeDouble", new Class[]{Parcel.class, Field.class, Object.class}));
                caD.put(Long.TYPE, a.class.getMethod("keep_writeLong", new Class[]{Parcel.class, Field.class, Object.class}));
                caD.put(Long.class, a.class.getMethod("keep_writeLong", new Class[]{Parcel.class, Field.class, Object.class}));
                caD.put(String.class, a.class.getMethod("keep_writeString", new Class[]{Parcel.class, Field.class, Object.class}));
                caE.put(byte[].class, a.class.getMethod("keep_readByteArray", new Class[]{Parcel.class, Field.class, Object.class}));
                caE.put(Short.TYPE, a.class.getMethod("keep_readShort", new Class[]{Parcel.class, Field.class, Object.class}));
                caE.put(Short.class, a.class.getMethod("keep_readShort", new Class[]{Parcel.class, Field.class, Object.class}));
                caE.put(Boolean.TYPE, a.class.getMethod("keep_readBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
                caE.put(Boolean.class, a.class.getMethod("keep_readBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
                caE.put(Integer.TYPE, a.class.getMethod("keep_readInt", new Class[]{Parcel.class, Field.class, Object.class}));
                caE.put(Integer.class, a.class.getMethod("keep_readInt", new Class[]{Parcel.class, Field.class, Object.class}));
                caE.put(Float.TYPE, a.class.getMethod("keep_readFloat", new Class[]{Parcel.class, Field.class, Object.class}));
                caE.put(Float.class, a.class.getMethod("keep_readFloat", new Class[]{Parcel.class, Field.class, Object.class}));
                caE.put(Double.TYPE, a.class.getMethod("keep_readDouble", new Class[]{Parcel.class, Field.class, Object.class}));
                caE.put(Double.class, a.class.getMethod("keep_readDouble", new Class[]{Parcel.class, Field.class, Object.class}));
                caE.put(Long.TYPE, a.class.getMethod("keep_readLong", new Class[]{Parcel.class, Field.class, Object.class}));
                caE.put(Long.class, a.class.getMethod("keep_readLong", new Class[]{Parcel.class, Field.class, Object.class}));
                caE.put(String.class, a.class.getMethod("keep_readString", new Class[]{Parcel.class, Field.class, Object.class}));
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }

        public static void keep_writeByteArray(Parcel parcel, Field field, Object obj) {
            try {
                parcel.writeByteArray((byte[]) field.get(obj));
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }

        public static void keep_writeShort(Parcel parcel, Field field, Object obj) {
            try {
                parcel.writeInt(field.getShort(obj));
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }

        public static void keep_writeBoolean(Parcel parcel, Field field, Object obj) {
            try {
                parcel.writeInt(field.getBoolean(obj) ? 1 : 0);
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }

        public static void keep_writeInt(Parcel parcel, Field field, Object obj) {
            try {
                parcel.writeInt(field.getInt(obj));
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }

        public static void keep_writeFloat(Parcel parcel, Field field, Object obj) {
            try {
                parcel.writeFloat(field.getFloat(obj));
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }

        public static void keep_writeDouble(Parcel parcel, Field field, Object obj) {
            try {
                parcel.writeDouble(field.getDouble(obj));
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }

        public static void keep_writeLong(Parcel parcel, Field field, Object obj) {
            try {
                parcel.writeLong(field.getLong(obj));
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }

        public static void keep_writeString(Parcel parcel, Field field, Object obj) {
            try {
                parcel.writeString((String) field.get(obj));
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }

        public static void keep_readByteArray(Parcel parcel, Field field, Object obj) {
            try {
                field.set(obj, parcel.createByteArray());
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }

        public static void keep_readShort(Parcel parcel, Field field, Object obj) {
            try {
                field.setShort(obj, (short) parcel.readInt());
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }

        public static void keep_readBoolean(Parcel parcel, Field field, Object obj) {
            try {
                field.setBoolean(obj, parcel.readInt() != 0);
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }

        public static void keep_readInt(Parcel parcel, Field field, Object obj) {
            try {
                field.setInt(obj, parcel.readInt());
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }

        public static void keep_readFloat(Parcel parcel, Field field, Object obj) {
            try {
                field.setFloat(obj, parcel.readFloat());
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }

        public static void keep_readDouble(Parcel parcel, Field field, Object obj) {
            try {
                field.setDouble(obj, parcel.readDouble());
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }

        public static void keep_readLong(Parcel parcel, Field field, Object obj) {
            try {
                field.set(obj, Long.valueOf(parcel.readLong()));
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }

        public static void keep_readString(Parcel parcel, Field field, Object obj) {
            try {
                field.set(obj, parcel.readString());
            } catch (Throwable e) {
                v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
            }
        }
    }

    public MCacheItem(Parcel parcel) {
        this.caC = c(parcel);
    }

    public MCacheItem(c cVar) {
        this.caC = cVar;
    }

    private c c(Parcel parcel) {
        Class cls = Class.forName(parcel.readString());
        try {
            this.caC = (c) cls.newInstance();
        } catch (Exception e) {
        }
        try {
            for (Field type : c.o(cls)) {
                Method method = (Method) a.caE.get(type.getType());
                if (method != null) {
                    try {
                        method.invoke(null, new Object[]{parcel, type, this.caC});
                    } catch (Throwable e2) {
                        v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e2));
                    }
                }
            }
            return this.caC;
        } catch (Throwable e22) {
            v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e22));
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.caC.getClass().getName());
        for (Field type : c.o(this.caC.getClass())) {
            Method method = (Method) a.caD.get(type.getType());
            if (method != null) {
                try {
                    method.invoke(null, new Object[]{parcel, type, this.caC});
                } catch (Throwable e) {
                    v.e("MicroMsg.MCacheItem", "exception:%s", be.e(e));
                }
            }
        }
    }
}
