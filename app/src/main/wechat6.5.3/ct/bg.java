package ct;

import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class bg {
    private ByteBuffer a;
    private String b;

    static {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public bg() {
        this(FileUtils.S_IWUSR);
    }

    public bg(int i) {
        this.b = "GBK";
        this.a = ByteBuffer.allocate(i);
    }

    private void a(int i) {
        if (this.a.remaining() < i) {
            try {
                ByteBuffer allocate = ByteBuffer.allocate((this.a.capacity() + i) << 1);
                allocate.put(this.a.array(), 0, this.a.position());
                this.a = allocate;
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }
    }

    private void b(byte b, int i) {
        if (i < 15) {
            this.a.put((byte) ((i << 4) | b));
        } else if (i < FileUtils.S_IRUSR) {
            this.a.put((byte) (b | 240));
            this.a.put((byte) i);
        } else {
            throw new RuntimeException("tag is too large: " + i);
        }
    }

    public final int a(String str) {
        this.b = str;
        return 0;
    }

    public final ByteBuffer a() {
        return this.a;
    }

    public final void a(byte b, int i) {
        a(3);
        if (b == (byte) 0) {
            b((byte) 12, i);
            return;
        }
        b((byte) 0, i);
        this.a.put(b);
    }

    public final void a(int i, int i2) {
        a(6);
        if (i < -32768 || i > 32767) {
            b((byte) 2, i2);
            this.a.putInt(i);
            return;
        }
        a((short) i, i2);
    }

    public final void a(long j, int i) {
        a(10);
        if (j < -2147483648L || j > 2147483647L) {
            b((byte) 3, i);
            this.a.putLong(j);
            return;
        }
        a((int) j, i);
    }

    public final void a(bh bhVar, int i) {
        a(2);
        b((byte) 10, i);
        bhVar.a(this);
        a(2);
        b((byte) 11, 0);
    }

    public final void a(Object obj, int i) {
        int i2 = 1;
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            if (!((Boolean) obj).booleanValue()) {
                i2 = 0;
            }
            a((byte) i2, i);
        } else if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            a(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            a(6);
            b((byte) 4, i);
            this.a.putFloat(floatValue);
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            a(10);
            b((byte) 5, i);
            this.a.putDouble(doubleValue);
        } else if (obj instanceof String) {
            a((String) obj, i);
        } else if (obj instanceof Map) {
            a((Map) obj, i);
        } else if (obj instanceof List) {
            a((List) obj, i);
        } else if (obj instanceof bh) {
            bh bhVar = (bh) obj;
            a(2);
            b((byte) 10, i);
            bhVar.a(this);
            a(2);
            b((byte) 11, 0);
        } else if (obj instanceof byte[]) {
            a((byte[]) obj, i);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            a(8);
            b((byte) 9, i);
            a(zArr.length, 0);
            for (boolean z : zArr) {
                a((byte) (z ? 1 : 0), 0);
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            a(8);
            b((byte) 9, i);
            a(sArr.length, 0);
            for (short a : sArr) {
                a(a, 0);
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            a(8);
            b((byte) 9, i);
            a(iArr.length, 0);
            for (int a2 : iArr) {
                a(a2, 0);
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            a(8);
            b((byte) 9, i);
            a(jArr.length, 0);
            for (long a3 : jArr) {
                a(a3, 0);
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            a(8);
            b((byte) 9, i);
            a(fArr.length, 0);
            for (float f : fArr) {
                a(6);
                b((byte) 4, 0);
                this.a.putFloat(f);
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            a(8);
            b((byte) 9, i);
            a(dArr.length, 0);
            for (double d : dArr) {
                a(10);
                b((byte) 5, 0);
                this.a.putDouble(d);
            }
        } else if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            a(8);
            b((byte) 9, i);
            a(objArr.length, 0);
            for (Object a4 : objArr) {
                a(a4, 0);
            }
        } else if (obj instanceof Collection) {
            a((Collection) obj, i);
        } else {
            throw new RuntimeException("write object error: unsupport type. " + obj.getClass());
        }
    }

    public final void a(String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.b);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > WebView.NORMAL_MODE_ALPHA) {
            b((byte) 7, i);
            this.a.putInt(bytes.length);
            this.a.put(bytes);
            return;
        }
        b((byte) 6, i);
        this.a.put((byte) bytes.length);
        this.a.put(bytes);
    }

    public final void a(Collection collection, int i) {
        a(8);
        b((byte) 9, i);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (Object a : collection) {
                a(a, 0);
            }
        }
    }

    public final void a(Map map, int i) {
        a(8);
        b((byte) 8, i);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    public final void a(short s, int i) {
        a(4);
        if (s < (short) -128 || s > (short) 127) {
            b((byte) 1, i);
            this.a.putShort(s);
            return;
        }
        a((byte) s, i);
    }

    public final void a(byte[] bArr, int i) {
        a(bArr.length + 8);
        b((byte) 13, i);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.a.put(bArr);
    }
}
