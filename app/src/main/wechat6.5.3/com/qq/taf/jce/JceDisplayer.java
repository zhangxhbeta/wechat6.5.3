package com.qq.taf.jce;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class JceDisplayer {
    private int _level = 0;
    private StringBuilder sb;

    private void ps(String str) {
        for (int i = 0; i < this._level; i++) {
            this.sb.append('\t');
        }
        if (str != null) {
            this.sb.append(str).append(": ");
        }
    }

    public JceDisplayer(StringBuilder stringBuilder, int i) {
        this.sb = stringBuilder;
        this._level = i;
    }

    public JceDisplayer(StringBuilder stringBuilder) {
        this.sb = stringBuilder;
    }

    public final JceDisplayer display(boolean z, String str) {
        ps(str);
        this.sb.append(z ? 'T' : 'F').append('\n');
        return this;
    }

    public final JceDisplayer displaySimple(boolean z, boolean z2) {
        this.sb.append(z ? 'T' : 'F');
        if (z2) {
            this.sb.append("|");
        }
        return this;
    }

    public final JceDisplayer display(byte b, String str) {
        ps(str);
        this.sb.append(b).append('\n');
        return this;
    }

    public final JceDisplayer displaySimple(byte b, boolean z) {
        this.sb.append(b);
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public final JceDisplayer display(char c, String str) {
        ps(str);
        this.sb.append(c).append('\n');
        return this;
    }

    public final JceDisplayer displaySimple(char c, boolean z) {
        this.sb.append(c);
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public final JceDisplayer display(short s, String str) {
        ps(str);
        this.sb.append(s).append('\n');
        return this;
    }

    public final JceDisplayer displaySimple(short s, boolean z) {
        this.sb.append(s);
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public final JceDisplayer display(int i, String str) {
        ps(str);
        this.sb.append(i).append('\n');
        return this;
    }

    public final JceDisplayer displaySimple(int i, boolean z) {
        this.sb.append(i);
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public final JceDisplayer display(long j, String str) {
        ps(str);
        this.sb.append(j).append('\n');
        return this;
    }

    public final JceDisplayer displaySimple(long j, boolean z) {
        this.sb.append(j);
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public final JceDisplayer display(float f, String str) {
        ps(str);
        this.sb.append(f).append('\n');
        return this;
    }

    public final JceDisplayer displaySimple(float f, boolean z) {
        this.sb.append(f);
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public final JceDisplayer display(double d, String str) {
        ps(str);
        this.sb.append(d).append('\n');
        return this;
    }

    public final JceDisplayer displaySimple(double d, boolean z) {
        this.sb.append(d);
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public final JceDisplayer display(String str, String str2) {
        ps(str2);
        if (str == null) {
            this.sb.append("null\n");
        } else {
            this.sb.append(str).append('\n');
        }
        return this;
    }

    public final JceDisplayer displaySimple(String str, boolean z) {
        if (str == null) {
            this.sb.append("null");
        } else {
            this.sb.append(str);
        }
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public final JceDisplayer display(byte[] bArr, String str) {
        ps(str);
        if (bArr == null) {
            this.sb.append("null\n");
        } else if (bArr.length == 0) {
            this.sb.append(bArr.length).append(", []\n");
        } else {
            this.sb.append(bArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (byte display : bArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
        }
        return this;
    }

    public final JceDisplayer displaySimple(byte[] bArr, boolean z) {
        if (bArr != null && bArr.length != 0) {
            this.sb.append(HexUtil.bytes2HexStr(bArr));
            if (z) {
                this.sb.append("|");
            }
        } else if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public final JceDisplayer display(char[] cArr, String str) {
        ps(str);
        if (cArr == null) {
            this.sb.append("null\n");
        } else if (cArr.length == 0) {
            this.sb.append(cArr.length).append(", []\n");
        } else {
            this.sb.append(cArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (char display : cArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
        }
        return this;
    }

    public final JceDisplayer displaySimple(char[] cArr, boolean z) {
        if (cArr != null && cArr.length != 0) {
            this.sb.append(new String(cArr));
            if (z) {
                this.sb.append("|");
            }
        } else if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public final JceDisplayer display(short[] sArr, String str) {
        ps(str);
        if (sArr == null) {
            this.sb.append("null\n");
        } else if (sArr.length == 0) {
            this.sb.append(sArr.length).append(", []\n");
        } else {
            this.sb.append(sArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (short display : sArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
        }
        return this;
    }

    public final JceDisplayer displaySimple(short[] sArr, boolean z) {
        if (sArr == null || sArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i = 0; i < sArr.length; i++) {
                short s = sArr[i];
                if (i != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(s, false);
            }
            this.sb.append("]");
            if (z) {
                this.sb.append("|");
            }
        }
        return this;
    }

    public final JceDisplayer display(int[] iArr, String str) {
        ps(str);
        if (iArr == null) {
            this.sb.append("null\n");
        } else if (iArr.length == 0) {
            this.sb.append(iArr.length).append(", []\n");
        } else {
            this.sb.append(iArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int display : iArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
        }
        return this;
    }

    public final JceDisplayer displaySimple(int[] iArr, boolean z) {
        if (iArr == null || iArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i = 0; i < iArr.length; i++) {
                int i2 = iArr[i];
                if (i != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(i2, false);
            }
            this.sb.append("]");
            if (z) {
                this.sb.append("|");
            }
        }
        return this;
    }

    public final JceDisplayer display(long[] jArr, String str) {
        ps(str);
        if (jArr == null) {
            this.sb.append("null\n");
        } else if (jArr.length == 0) {
            this.sb.append(jArr.length).append(", []\n");
        } else {
            this.sb.append(jArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (long display : jArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
        }
        return this;
    }

    public final JceDisplayer displaySimple(long[] jArr, boolean z) {
        if (jArr == null || jArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i = 0; i < jArr.length; i++) {
                long j = jArr[i];
                if (i != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(j, false);
            }
            this.sb.append("]");
            if (z) {
                this.sb.append("|");
            }
        }
        return this;
    }

    public final JceDisplayer display(float[] fArr, String str) {
        ps(str);
        if (fArr == null) {
            this.sb.append("null\n");
        } else if (fArr.length == 0) {
            this.sb.append(fArr.length).append(", []\n");
        } else {
            this.sb.append(fArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (float display : fArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
        }
        return this;
    }

    public final JceDisplayer displaySimple(float[] fArr, boolean z) {
        if (fArr == null || fArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i = 0; i < fArr.length; i++) {
                float f = fArr[i];
                if (i != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(f, false);
            }
            this.sb.append("]");
            if (z) {
                this.sb.append("|");
            }
        }
        return this;
    }

    public final JceDisplayer display(double[] dArr, String str) {
        ps(str);
        if (dArr == null) {
            this.sb.append("null\n");
        } else if (dArr.length == 0) {
            this.sb.append(dArr.length).append(", []\n");
        } else {
            this.sb.append(dArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (double display : dArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
        }
        return this;
    }

    public final JceDisplayer displaySimple(double[] dArr, boolean z) {
        if (dArr == null || dArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i = 0; i < dArr.length; i++) {
                double d = dArr[i];
                if (i != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(d, false);
            }
            this.sb.append("[");
            if (z) {
                this.sb.append("|");
            }
        }
        return this;
    }

    public final <K, V> JceDisplayer display(Map<K, V> map, String str) {
        ps(str);
        if (map == null) {
            this.sb.append("null\n");
        } else if (map.isEmpty()) {
            this.sb.append(map.size()).append(", {}\n");
        } else {
            this.sb.append(map.size()).append(", {\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            JceDisplayer jceDisplayer2 = new JceDisplayer(this.sb, this._level + 2);
            for (Entry entry : map.entrySet()) {
                jceDisplayer.display('(', null);
                jceDisplayer2.display(entry.getKey(), null);
                jceDisplayer2.display(entry.getValue(), null);
                jceDisplayer.display(')', null);
            }
            display('}', null);
        }
        return this;
    }

    public final <K, V> JceDisplayer displaySimple(Map<K, V> map, boolean z) {
        if (map == null || map.isEmpty()) {
            this.sb.append("{}");
            if (z) {
                this.sb.append("|");
            }
        } else {
            this.sb.append("{");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 2);
            boolean z2 = true;
            for (Entry entry : map.entrySet()) {
                if (!z2) {
                    this.sb.append(",");
                }
                jceDisplayer.displaySimple(entry.getKey(), true);
                jceDisplayer.displaySimple(entry.getValue(), false);
                z2 = false;
            }
            this.sb.append("}");
            if (z) {
                this.sb.append("|");
            }
        }
        return this;
    }

    public final <T> JceDisplayer display(T[] tArr, String str) {
        ps(str);
        if (tArr == null) {
            this.sb.append("null\n");
        } else if (tArr.length == 0) {
            this.sb.append(tArr.length).append(", []\n");
        } else {
            this.sb.append(tArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (Object display : tArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
        }
        return this;
    }

    public final <T> JceDisplayer displaySimple(T[] tArr, boolean z) {
        if (tArr == null || tArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i = 0; i < tArr.length; i++) {
                Object obj = tArr[i];
                if (i != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(obj, false);
            }
            this.sb.append("]");
            if (z) {
                this.sb.append("|");
            }
        }
        return this;
    }

    public final <T> JceDisplayer display(Collection<T> collection, String str) {
        if (collection != null) {
            return display(collection.toArray(), str);
        }
        ps(str);
        this.sb.append("null\t");
        return this;
    }

    public final <T> JceDisplayer displaySimple(Collection<T> collection, boolean z) {
        if (collection != null) {
            return displaySimple(collection.toArray(), z);
        }
        this.sb.append("[]");
        if (!z) {
            return this;
        }
        this.sb.append("|");
        return this;
    }

    public final <T> JceDisplayer display(T t, String str) {
        if (t == null) {
            this.sb.append("null\n");
        } else if (t instanceof Byte) {
            display(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            display(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            display(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            display(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            display(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            display(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            display(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            display((String) t, str);
        } else if (t instanceof Map) {
            display((Map) t, str);
        } else if (t instanceof List) {
            display((List) t, str);
        } else if (t instanceof JceStruct) {
            display((JceStruct) t, str);
        } else if (t instanceof byte[]) {
            display((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            display((boolean[]) t, str);
        } else if (t instanceof short[]) {
            display((short[]) t, str);
        } else if (t instanceof int[]) {
            display((int[]) t, str);
        } else if (t instanceof long[]) {
            display((long[]) t, str);
        } else if (t instanceof float[]) {
            display((float[]) t, str);
        } else if (t instanceof double[]) {
            display((double[]) t, str);
        } else if (t.getClass().isArray()) {
            display((Object[]) t, str);
        } else {
            throw new JceEncodeException("write object error: unsupport type.");
        }
        return this;
    }

    public final <T> JceDisplayer displaySimple(T t, boolean z) {
        if (t == null) {
            this.sb.append("null\n");
        } else if (t instanceof Byte) {
            displaySimple(((Byte) t).byteValue(), z);
        } else if (t instanceof Boolean) {
            displaySimple(((Boolean) t).booleanValue(), z);
        } else if (t instanceof Short) {
            displaySimple(((Short) t).shortValue(), z);
        } else if (t instanceof Integer) {
            displaySimple(((Integer) t).intValue(), z);
        } else if (t instanceof Long) {
            displaySimple(((Long) t).longValue(), z);
        } else if (t instanceof Float) {
            displaySimple(((Float) t).floatValue(), z);
        } else if (t instanceof Double) {
            displaySimple(((Double) t).doubleValue(), z);
        } else if (t instanceof String) {
            displaySimple((String) t, z);
        } else if (t instanceof Map) {
            displaySimple((Map) t, z);
        } else if (t instanceof List) {
            displaySimple((List) t, z);
        } else if (t instanceof JceStruct) {
            displaySimple((JceStruct) t, z);
        } else if (t instanceof byte[]) {
            displaySimple((byte[]) t, z);
        } else if (t instanceof boolean[]) {
            displaySimple((boolean[]) t, z);
        } else if (t instanceof short[]) {
            displaySimple((short[]) t, z);
        } else if (t instanceof int[]) {
            displaySimple((int[]) t, z);
        } else if (t instanceof long[]) {
            displaySimple((long[]) t, z);
        } else if (t instanceof float[]) {
            displaySimple((float[]) t, z);
        } else if (t instanceof double[]) {
            displaySimple((double[]) t, z);
        } else if (t.getClass().isArray()) {
            displaySimple((Object[]) t, z);
        } else {
            throw new JceEncodeException("write object error: unsupport type.");
        }
        return this;
    }

    public final JceDisplayer display(JceStruct jceStruct, String str) {
        display('{', str);
        if (jceStruct == null) {
            this.sb.append('\t').append("null");
        } else {
            jceStruct.display(this.sb, this._level + 1);
        }
        display('}', null);
        return this;
    }

    public final JceDisplayer displaySimple(JceStruct jceStruct, boolean z) {
        this.sb.append("{");
        if (jceStruct == null) {
            this.sb.append('\t').append("null");
        } else {
            jceStruct.displaySimple(this.sb, this._level + 1);
        }
        this.sb.append("}");
        if (z) {
            this.sb.append("|");
        }
        return this;
    }

    public static void main(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1.2d);
        System.out.println(stringBuilder.toString());
    }
}
