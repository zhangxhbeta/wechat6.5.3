package ct;

import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class bf {
    ByteBuffer a;
    String b = "GBK";

    public static class a {
        public byte a;
        public int b;
    }

    public bf(byte[] bArr) {
        this.a = ByteBuffer.wrap(bArr);
    }

    public bf(byte[] bArr, byte b) {
        this.a = ByteBuffer.wrap(bArr);
        this.a.position(4);
    }

    private double a(double d, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 4:
                    return (double) this.a.getFloat();
                case (byte) 5:
                    return this.a.getDouble();
                case (byte) 12:
                    return 0.0d;
                default:
                    throw new RuntimeException("type mismatch.");
            }
        } else if (!z) {
            return d;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    private float a(float f, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 4:
                    return this.a.getFloat();
                case (byte) 12:
                    return 0.0f;
                default:
                    throw new RuntimeException("type mismatch.");
            }
        } else if (!z) {
            return f;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    private static int a(a aVar, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        aVar.a = (byte) (b & 15);
        aVar.b = (b & 240) >> 4;
        if (aVar.b != 15) {
            return 1;
        }
        aVar.b = byteBuffer.get() & WebView.NORMAL_MODE_ALPHA;
        return 2;
    }

    private void a() {
        a aVar = new a();
        do {
            a(aVar, this.a);
            a(aVar.a);
        } while (aVar.a != (byte) 11);
    }

    private void a(byte b) {
        int i = 0;
        int a;
        a aVar;
        switch (b) {
            case (byte) 0:
                this.a.position(this.a.position() + 1);
                return;
            case (byte) 1:
                this.a.position(this.a.position() + 2);
                return;
            case (byte) 2:
                this.a.position(this.a.position() + 4);
                return;
            case (byte) 3:
                this.a.position(this.a.position() + 8);
                return;
            case (byte) 4:
                this.a.position(this.a.position() + 4);
                return;
            case (byte) 5:
                this.a.position(this.a.position() + 8);
                return;
            case (byte) 6:
                i = this.a.get();
                if (i < 0) {
                    i += FileUtils.S_IRUSR;
                }
                this.a.position(i + this.a.position());
                return;
            case (byte) 7:
                this.a.position(this.a.getInt() + this.a.position());
                return;
            case (byte) 8:
                a = a(0, 0, true);
                while (i < (a << 1)) {
                    aVar = new a();
                    a(aVar, this.a);
                    a(aVar.a);
                    i++;
                }
                return;
            case (byte) 9:
                a = a(0, 0, true);
                while (i < a) {
                    aVar = new a();
                    a(aVar, this.a);
                    a(aVar.a);
                    i++;
                }
                return;
            case (byte) 10:
                a();
                return;
            case (byte) 11:
            case (byte) 12:
                return;
            case (byte) 13:
                a aVar2 = new a();
                a(aVar2, this.a);
                if (aVar2.a != (byte) 0) {
                    throw new RuntimeException("skipField with invalid type, type value: " + b + ", " + aVar2.a);
                }
                this.a.position(a(0, 0, true) + this.a.position());
                return;
            default:
                throw new RuntimeException("invalid type.");
        }
    }

    private boolean a(int i) {
        try {
            a aVar = new a();
            while (true) {
                int a = a(aVar, this.a.duplicate());
                if (aVar.a == (byte) 11) {
                    return false;
                }
                if (i <= aVar.b) {
                    break;
                }
                this.a.position(a + this.a.position());
                a(aVar.a);
            }
            return i == aVar.b;
        } catch (BufferUnderflowException e) {
            return false;
        } catch (RuntimeException e2) {
            return false;
        }
    }

    private Object[] b(Object obj, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a < 0) {
                        throw new RuntimeException("size invalid: " + a);
                    }
                    Object[] objArr = (Object[]) Array.newInstance(obj.getClass(), a);
                    for (int i2 = 0; i2 < a; i2++) {
                        objArr[i2] = a(obj, 0, true);
                    }
                    return objArr;
                default:
                    throw new RuntimeException("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    private boolean[] c(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a < 0) {
                        throw new RuntimeException("size invalid: " + a);
                    }
                    boolean[] zArr = new boolean[a];
                    for (int i2 = 0; i2 < a; i2++) {
                        zArr[i2] = a((byte) 0, 0, true) != (byte) 0;
                    }
                    return zArr;
                default:
                    throw new RuntimeException("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    private short[] d(int i, boolean z) {
        short[] sArr = null;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        sArr = new short[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            sArr[i2] = a(sArr[0], 0, true);
                        }
                        break;
                    }
                    throw new RuntimeException("size invalid: " + a);
                default:
                    throw new RuntimeException("type mismatch.");
            }
        } else if (z) {
            throw new RuntimeException("require field not exist.");
        }
        return sArr;
    }

    private int[] e(int i, boolean z) {
        int[] iArr = null;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        iArr = new int[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            iArr[i2] = a(iArr[0], 0, true);
                        }
                        break;
                    }
                    throw new RuntimeException("size invalid: " + a);
                default:
                    throw new RuntimeException("type mismatch.");
            }
        } else if (z) {
            throw new RuntimeException("require field not exist.");
        }
        return iArr;
    }

    private long[] f(int i, boolean z) {
        long[] jArr = null;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        jArr = new long[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            jArr[i2] = a(jArr[0], 0, true);
                        }
                        break;
                    }
                    throw new RuntimeException("size invalid: " + a);
                default:
                    throw new RuntimeException("type mismatch.");
            }
        } else if (z) {
            throw new RuntimeException("require field not exist.");
        }
        return jArr;
    }

    private float[] g(int i, boolean z) {
        float[] fArr = null;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        fArr = new float[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            fArr[i2] = a(fArr[0], 0, true);
                        }
                        break;
                    }
                    throw new RuntimeException("size invalid: " + a);
                default:
                    throw new RuntimeException("type mismatch.");
            }
        } else if (z) {
            throw new RuntimeException("require field not exist.");
        }
        return fArr;
    }

    private double[] h(int i, boolean z) {
        double[] dArr = null;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        dArr = new double[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            dArr[i2] = a(dArr[0], 0, true);
                        }
                        break;
                    }
                    throw new RuntimeException("size invalid: " + a);
                default:
                    throw new RuntimeException("type mismatch.");
            }
        } else if (z) {
            throw new RuntimeException("require field not exist.");
        }
        return dArr;
    }

    public final byte a(byte b, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 0:
                    return this.a.get();
                case (byte) 12:
                    return (byte) 0;
                default:
                    throw new RuntimeException("type mismatch.");
            }
        } else if (!z) {
            return b;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    public final int a(int i, int i2, boolean z) {
        if (a(i2)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 0:
                    return this.a.get();
                case (byte) 1:
                    return this.a.getShort();
                case (byte) 2:
                    return this.a.getInt();
                case (byte) 12:
                    return 0;
                default:
                    throw new RuntimeException("type mismatch.");
            }
        } else if (!z) {
            return i;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    public final long a(long j, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 0:
                    return (long) this.a.get();
                case (byte) 1:
                    return (long) this.a.getShort();
                case (byte) 2:
                    return (long) this.a.getInt();
                case (byte) 3:
                    return this.a.getLong();
                case (byte) 12:
                    return 0;
                default:
                    throw new RuntimeException("type mismatch.");
            }
        } else if (!z) {
            return j;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    public final bh a(bh bhVar, int i, boolean z) {
        bh bhVar2 = null;
        if (a(i)) {
            try {
                bhVar2 = (bh) bhVar.getClass().newInstance();
                a aVar = new a();
                a(aVar, this.a);
                if (aVar.a != (byte) 10) {
                    throw new RuntimeException("type mismatch.");
                }
                bhVar2.a(this);
                a();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } else if (z) {
            throw new RuntimeException("require field not exist.");
        }
        return bhVar2;
    }

    public final Object a(Object obj, int i, boolean z) {
        int i2 = 0;
        if (obj instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i, z));
        }
        if (obj instanceof Boolean) {
            boolean z2;
            if (a((byte) 0, i, z) != (byte) 0) {
                z2 = true;
            }
            return Boolean.valueOf(z2);
        } else if (obj instanceof Short) {
            return Short.valueOf(a((short) 0, i, z));
        } else {
            if (obj instanceof Integer) {
                return Integer.valueOf(a(0, i, z));
            }
            if (obj instanceof Long) {
                return Long.valueOf(a(0, i, z));
            }
            if (obj instanceof Float) {
                return Float.valueOf(a(0.0f, i, z));
            }
            if (obj instanceof Double) {
                return Double.valueOf(a(0.0d, i, z));
            }
            if (obj instanceof String) {
                return a(i, z);
            }
            if (obj instanceof Map) {
                return (HashMap) a(new HashMap(), (Map) obj, i, z);
            } else if (obj instanceof List) {
                List list = (List) obj;
                if (list == null || list.isEmpty()) {
                    return new ArrayList();
                }
                Object[] b = b(list.get(0), i, z);
                if (b == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                while (i2 < b.length) {
                    arrayList.add(b[i2]);
                    i2++;
                }
                return arrayList;
            } else if (obj instanceof bh) {
                return a((bh) obj, i, z);
            } else {
                if (!obj.getClass().isArray()) {
                    throw new RuntimeException("read object error: unsupport type.");
                } else if ((obj instanceof byte[]) || (obj instanceof Byte[])) {
                    return b(i, z);
                } else {
                    if (obj instanceof boolean[]) {
                        return c(i, z);
                    }
                    if (obj instanceof short[]) {
                        return d(i, z);
                    }
                    if (obj instanceof int[]) {
                        return e(i, z);
                    }
                    if (obj instanceof long[]) {
                        return f(i, z);
                    }
                    if (obj instanceof float[]) {
                        return g(i, z);
                    }
                    if (obj instanceof double[]) {
                        return h(i, z);
                    }
                    Object[] objArr = (Object[]) obj;
                    if (objArr != null && objArr.length != 0) {
                        return b(objArr[0], i, z);
                    }
                    throw new RuntimeException("unable to get type of key and value.");
                }
            }
        }
    }

    public final String a(int i, boolean z) {
        byte[] bArr;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            int i2;
            switch (aVar.a) {
                case (byte) 6:
                    i2 = this.a.get();
                    if (i2 < 0) {
                        i2 += FileUtils.S_IRUSR;
                    }
                    bArr = new byte[i2];
                    this.a.get(bArr);
                    try {
                        return new String(bArr, this.b);
                    } catch (UnsupportedEncodingException e) {
                        return new String(bArr);
                    }
                case (byte) 7:
                    i2 = this.a.getInt();
                    if (i2 > 104857600 || i2 < 0 || i2 > this.a.capacity()) {
                        throw new RuntimeException("String too long: " + i2);
                    }
                    bArr = new byte[i2];
                    this.a.get(bArr);
                    try {
                        return new String(bArr, this.b);
                    } catch (UnsupportedEncodingException e2) {
                        return new String(bArr);
                    }
                default:
                    throw new RuntimeException("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    final Map a(Map map, Map map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Entry entry = (Entry) map2.entrySet().iterator().next();
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 8:
                    int a = a(0, 0, true);
                    if (a < 0) {
                        throw new RuntimeException("size invalid: " + a);
                    }
                    for (int i2 = 0; i2 < a; i2++) {
                        map.put(a(key, 0, true), a(value, 1, true));
                    }
                    return map;
                default:
                    throw new RuntimeException("type mismatch.");
            }
        } else if (!z) {
            return map;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    public final short a(short s, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 0:
                    return (short) this.a.get();
                case (byte) 1:
                    return this.a.getShort();
                case (byte) 12:
                    return (short) 0;
                default:
                    throw new RuntimeException("type mismatch.");
            }
        } else if (!z) {
            return s;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    public final byte[] b(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            byte[] bArr;
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a < 0 || a > this.a.capacity()) {
                        throw new RuntimeException("size invalid: " + a);
                    }
                    bArr = new byte[a];
                    for (int i2 = 0; i2 < a; i2++) {
                        bArr[i2] = a(bArr[0], 0, true);
                    }
                    return bArr;
                case (byte) 13:
                    a aVar2 = new a();
                    a(aVar2, this.a);
                    if (aVar2.a != (byte) 0) {
                        throw new RuntimeException("type mismatch, tag: " + i + ", type: " + aVar.a + ", " + aVar2.a);
                    }
                    int a2 = a(0, 0, true);
                    if (a2 < 0 || a2 > this.a.capacity()) {
                        throw new RuntimeException("invalid size, tag: " + i + ", type: " + aVar.a + ", " + aVar2.a + ", size: " + a2);
                    }
                    bArr = new byte[a2];
                    this.a.get(bArr);
                    return bArr;
                default:
                    throw new RuntimeException("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }
}
