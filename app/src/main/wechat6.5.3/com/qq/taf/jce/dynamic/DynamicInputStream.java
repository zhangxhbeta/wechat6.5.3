package com.qq.taf.jce.dynamic;

import com.qq.taf.jce.JceDecodeException;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceInputStream.HeadData;
import com.tencent.mars.comm.NetStatusUtil;
import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class DynamicInputStream {
    private ByteBuffer bs;
    private String sServerEncoding = "GBK";

    public DynamicInputStream(ByteBuffer byteBuffer) {
        this.bs = byteBuffer;
    }

    public DynamicInputStream(byte[] bArr) {
        this.bs = ByteBuffer.wrap(bArr);
    }

    public final int setServerEncoding(String str) {
        this.sServerEncoding = str;
        return 0;
    }

    public final JceField read() {
        int i = 0;
        try {
            HeadData headData = new HeadData();
            JceInputStream.readHead(headData, this.bs);
            int i2;
            switch (headData.type) {
                case (byte) 0:
                    return JceField.create(this.bs.get(), headData.tag);
                case (byte) 1:
                    return JceField.create(this.bs.getShort(), headData.tag);
                case (byte) 2:
                    return JceField.create(this.bs.getInt(), headData.tag);
                case (byte) 3:
                    return JceField.create(this.bs.getLong(), headData.tag);
                case (byte) 4:
                    return JceField.create(this.bs.getFloat(), headData.tag);
                case (byte) 5:
                    return JceField.create(this.bs.getDouble(), headData.tag);
                case (byte) 6:
                    i2 = this.bs.get();
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    return readString(headData, i2);
                case (byte) 7:
                    return readString(headData, this.bs.getInt());
                case (byte) 8:
                    int intValue = ((NumberField) read()).intValue();
                    JceField[] jceFieldArr = new JceField[intValue];
                    JceField[] jceFieldArr2 = new JceField[intValue];
                    for (i2 = 0; i2 < intValue; i2++) {
                        jceFieldArr[i2] = read();
                        jceFieldArr2[i2] = read();
                    }
                    return JceField.createMap(jceFieldArr, jceFieldArr2, headData.tag);
                case NetStatusUtil.MOBILE /*9*/:
                    i2 = ((NumberField) read()).intValue();
                    JceField[] jceFieldArr3 = new JceField[i2];
                    while (i < i2) {
                        jceFieldArr3[i] = read();
                        i++;
                    }
                    return JceField.createList(jceFieldArr3, headData.tag);
                case NetStatusUtil.LTE /*10*/:
                    List arrayList = new ArrayList();
                    while (true) {
                        JceField read = read();
                        if (read == null) {
                            return JceField.createStruct((JceField[]) arrayList.toArray(new JceField[0]), headData.tag);
                        }
                        arrayList.add(read);
                    }
                case (byte) 11:
                    return null;
                case (byte) 12:
                    return JceField.createZero(headData.tag);
                case (byte) 13:
                    i = headData.tag;
                    JceInputStream.readHead(headData, this.bs);
                    if (headData.type != (byte) 0) {
                        throw new JceDecodeException("type mismatch, simple_list only support byte, tag: " + i + ", type: " + headData.type);
                    }
                    byte[] bArr = new byte[((NumberField) read()).intValue()];
                    this.bs.get(bArr);
                    return JceField.create(bArr, i);
                default:
                    return null;
            }
        } catch (BufferUnderflowException e) {
            return null;
        }
    }

    private JceField readString(HeadData headData, int i) {
        String str;
        byte[] bArr = new byte[i];
        this.bs.get(bArr);
        try {
            str = new String(bArr, this.sServerEncoding);
        } catch (UnsupportedEncodingException e) {
            str = new String(bArr);
        }
        return JceField.create(str, headData.tag);
    }
}
