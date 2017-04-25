package com.tencent.mm.plugin.c.a.b.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.mm.plugin.c.a.b.a.g.a;
import com.tencent.mm.plugin.c.a.b.h;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public class c {
    public static final String TAG = c.class.getName();
    private static HashMap<String, Long> eqg = new HashMap();
    private static HashMap<String, Long> err;

    static {
        HashMap hashMap = new HashMap();
        err = hashMap;
        hashMap.put(h.eqw, Long.valueOf(1));
        err.put(h.eqx, Long.valueOf(1));
        err.put(h.eqy, Long.valueOf(16));
        err.put(h.eqz, Long.valueOf(16));
        err.put(h.eqA, Long.valueOf(16));
        err.put(h.eqB, Long.valueOf(16));
        eqg.put(h.eqt, Long.valueOf(0));
        eqg.put(h.eqC, Long.valueOf(2));
        eqg.put(h.eqF, Long.valueOf(4));
        eqg.put(h.eqJ, Long.valueOf(8));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean ac(byte[] r12) {
        /*
        r11 = 16;
        r10 = 2;
        r1 = 1;
        r0 = 0;
        r2 = com.tencent.mm.sdk.platformtools.be.bl(r12);
        if (r2 == 0) goto L_0x0014;
    L_0x000b:
        r1 = TAG;
        r2 = "parseBroadcastServiceUuid error. broadcast data is null or nil";
        com.tencent.mm.sdk.platformtools.v.e(r1, r2);
    L_0x0013:
        return r0;
    L_0x0014:
        r2 = r0;
    L_0x0015:
        if (r2 < 0) goto L_0x0013;
    L_0x0017:
        r3 = r12.length;
        if (r2 >= r3) goto L_0x0013;
    L_0x001a:
        r4 = r2 + 1;
        r2 = r12[r2];
        r3 = r4 + r2;
        r5 = r12.length;
        if (r3 <= r5) goto L_0x0042;
    L_0x0023:
        r3 = TAG;
        r5 = "broadcast data len is not enough. offset = %d, current len = %d, broadcast len = %d";
        r6 = 3;
        r6 = new java.lang.Object[r6];
        r4 = java.lang.Integer.valueOf(r4);
        r6[r0] = r4;
        r2 = java.lang.Integer.valueOf(r2);
        r6[r1] = r2;
        r1 = r12.length;
        r1 = java.lang.Integer.valueOf(r1);
        r6[r10] = r1;
        com.tencent.mm.sdk.platformtools.v.w(r3, r5, r6);
        goto L_0x0013;
    L_0x0042:
        if (r2 > 0) goto L_0x0055;
    L_0x0044:
        r3 = TAG;
        r4 = "current part of data's len = %d.";
        r1 = new java.lang.Object[r1];
        r2 = java.lang.Integer.valueOf(r2);
        r1[r0] = r2;
        com.tencent.mm.sdk.platformtools.v.w(r3, r4, r1);
        goto L_0x0013;
    L_0x0055:
        r3 = r4 + 1;
        r4 = r12[r4];
        r2 = r2 + -1;
        switch(r4) {
            case -1: goto L_0x00f0;
            case 0: goto L_0x005e;
            case 1: goto L_0x005e;
            case 2: goto L_0x0060;
            case 3: goto L_0x0060;
            case 4: goto L_0x005e;
            case 5: goto L_0x005e;
            case 6: goto L_0x0118;
            case 7: goto L_0x0118;
            default: goto L_0x005e;
        };
    L_0x005e:
        r2 = r2 + r3;
        goto L_0x0015;
    L_0x0060:
        if (r10 > r2) goto L_0x0099;
    L_0x0062:
        r4 = r3 + 1;
        r3 = r12[r3];
        r5 = r3 & 255;
        r3 = r4 + 1;
        r4 = r12[r4];
        r4 = r4 & 255;
        r4 = r4 << 8;
        r4 = r4 | r5;
        r2 = r2 + -2;
        r5 = "%08x-0000-1000-8000-00805f9b34fb";
        r6 = new java.lang.Object[r1];
        r4 = java.lang.Integer.valueOf(r4);
        r6[r0] = r4;
        r4 = java.lang.String.format(r5, r6);
        r5 = TAG;
        r6 = "find 16-bit broacast service = %s";
        r7 = new java.lang.Object[r1];
        r7[r0] = r4;
        com.tencent.mm.sdk.platformtools.v.d(r5, r6, r7);
        r5 = eqg;
        r4 = r5.containsKey(r4);
        if (r4 == 0) goto L_0x0060;
    L_0x0096:
        r0 = r1;
        goto L_0x0013;
    L_0x0099:
        r2 = r2 + r3;
        goto L_0x0015;
    L_0x009c:
        r4 = r4 + 16;
        r2 = r3 + -16;
        r3 = r2;
    L_0x00a1:
        if (r11 > r3) goto L_0x00ec;
    L_0x00a3:
        r2 = 16;
        r2 = java.nio.ByteBuffer.wrap(r12, r4, r2);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r5 = java.nio.ByteOrder.LITTLE_ENDIAN;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2 = r2.order(r5);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r6 = r2.getLong();	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r8 = r2.getLong();	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2 = new java.util.UUID;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2.<init>(r8, r6);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2 = r2.toString();	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r5 = TAG;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r6 = "find 128-bit broacast service = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r8 = 0;
        r7[r8] = r2;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        com.tencent.mm.sdk.platformtools.v.d(r5, r6, r7);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r5 = eqg;	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        r2 = r5.containsKey(r2);	 Catch:{ IndexOutOfBoundsException -> 0x00d9 }
        if (r2 == 0) goto L_0x009c;
    L_0x00d6:
        r0 = r1;
        goto L_0x0013;
    L_0x00d9:
        r2 = move-exception;
        r5 = "BlueToothDeviceFilter.parseUUID";
        r2 = r2.toString();	 Catch:{ all -> 0x00ea }
        com.tencent.mm.sdk.platformtools.v.e(r5, r2);	 Catch:{ all -> 0x00ea }
        r4 = r4 + 16;
        r2 = r3 + -16;
        r3 = r2;
        goto L_0x00a1;
    L_0x00ea:
        r0 = move-exception;
        throw r0;
    L_0x00ec:
        r2 = r4 + r3;
        goto L_0x0015;
    L_0x00f0:
        r4 = TAG;
        r5 = "Manufacturer Specific Data size = %s";
        r6 = new java.lang.Object[r1];
        r7 = java.lang.Integer.valueOf(r2);
        r6[r0] = r7;
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);
        r4 = TAG;
        r5 = "Manufacturer Specific Data = %s";
        r6 = new java.lang.Object[r1];
        r7 = r3 + r2;
        r7 = java.util.Arrays.copyOfRange(r12, r3, r7);
        r7 = com.tencent.mm.plugin.exdevice.j.b.ak(r7);
        r6[r0] = r7;
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);
        goto L_0x005e;
    L_0x0118:
        r4 = r3;
        r3 = r2;
        goto L_0x00a1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.c.a.b.a.c.ac(byte[]):boolean");
    }

    public static String aJ(long j) {
        for (String str : eqg.keySet()) {
            if (((Long) eqg.get(str)).longValue() == j) {
                return str;
            }
        }
        if (err.containsValue(Long.valueOf(j))) {
            return h.eqt;
        }
        return null;
    }

    public static long a(BluetoothGattService bluetoothGattService) {
        long j = 0;
        if (bluetoothGattService == null) {
            v.e(TAG, "service is null");
            return 0;
        }
        String uuid = bluetoothGattService.getUuid().toString();
        Long l;
        if (!uuid.equalsIgnoreCase(h.eqt) || bluetoothGattService.getCharacteristic(UUID.fromString(h.eqw)) == null) {
            l = (Long) eqg.get(uuid);
            if (l != null) {
                j = l.longValue();
            }
            v.d(TAG, "service uuid = %s, profileType = %d", new Object[]{uuid, Long.valueOf(j)});
            return j;
        }
        List characteristics = bluetoothGattService.getCharacteristics();
        long j2 = 0;
        int i = 0;
        while (i < characteristics.size()) {
            l = (Long) err.get(((BluetoothGattCharacteristic) characteristics.get(i)).getUuid().toString());
            i++;
            j2 = (l == null ? 0 : l.longValue()) | j2;
        }
        v.d(TAG, "wechat service, profileType = %d", new Object[]{Long.valueOf(j2)});
        return j2;
    }

    public static boolean b(BluetoothGattService bluetoothGattService) {
        if (bluetoothGattService == null) {
            v.e(TAG, "service is null");
            return false;
        }
        long a = a(bluetoothGattService);
        BluetoothGattCharacteristic characteristic;
        int properties;
        if (0 != (1 & a)) {
            if (bluetoothGattService == null) {
                v.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.eqw));
            if (characteristic == null) {
                v.e(TAG, "no step measurement characteristic found");
                return false;
            }
            properties = characteristic.getProperties();
            v.d(TAG, "step measurement characteristic properties = %d", new Object[]{Integer.valueOf(properties)});
            if ((properties & 48) == 0 || (properties & 2) == 0) {
                v.e(TAG, "step measurement characteristic has incorrect proterties(%d)", new Object[]{Integer.valueOf(properties)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.eqx));
            if (characteristic != null) {
                properties = characteristic.getProperties();
                if ((properties & 2) == 0 || (properties & 32) == 0) {
                    v.e(TAG, "step target characteristic has incorrect proterties(%d)", new Object[]{Integer.valueOf(properties)});
                    return false;
                }
            }
            return true;
        } else if (0 != (2 & a)) {
            if (bluetoothGattService == null) {
                v.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.eqD));
            if (characteristic == null) {
                v.e(TAG, "weight scale feature characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 2) == 0) {
                v.e(TAG, "weight scale feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.eqE));
            if (characteristic == null) {
                v.e(TAG, "weight measurement characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 32) != 0) {
                return true;
            }
            v.e(TAG, "weight measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32)});
            return false;
        } else if (0 != (4 & a)) {
            if (bluetoothGattService == null) {
                v.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.eqG));
            if (characteristic == null) {
                v.e(TAG, "heart rate measurement characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 16) == 0) {
                v.e(TAG, "heart rate measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(16)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.eqH));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 2) == 0) {
                    v.e(TAG, "heart rate body sensor location characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2)});
                    return false;
                }
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.eqI));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 8) == 0) {
                    v.e(TAG, "heart rate control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(8)});
                    return false;
                }
            }
            return true;
        } else if (0 != (8 & a)) {
            if (bluetoothGattService == null) {
                v.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.eqK));
            if (characteristic == null) {
                v.e(TAG, "blood pressure measurement characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 32) == 0) {
                v.e(TAG, "blood pressure measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.eqM));
            if (characteristic == null) {
                v.e(TAG, "blood pressure feature characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 2) == 0) {
                v.e(TAG, "blood pressure feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.eqL));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 16) == 0) {
                    v.e(TAG, "blood pressure intermediate cuff pressure characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(16)});
                    return false;
                }
            }
            return true;
        } else if (0 == (a & 16)) {
            return false;
        } else {
            if (bluetoothGattService == null) {
                v.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.eqy));
            if (characteristic == null) {
                v.e(TAG, "light color characteristic not found");
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) == 0 || (properties & 16) == 0 || (properties & 2) == 0 || (properties & 8) == 0) {
                v.e(TAG, "light color characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(properties), Integer.valueOf(32)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.eqz));
            if (characteristic == null) {
                v.e(TAG, "light work state characteristic not found");
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) == 0 || (properties & 2) == 0 || (properties & 8) == 0) {
                v.e(TAG, "light work state characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(properties), Integer.valueOf(32)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.eqA));
            if (characteristic == null) {
                v.e(TAG, "light state changed characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 32) == 0) {
                v.e(TAG, "light state changed characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.eqB));
            if (characteristic == null) {
                v.e(TAG, "control point characteristic not found");
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) != 0 && (properties & 8) != 0) {
                return true;
            }
            v.e(TAG, "control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(properties), Integer.valueOf(32)});
            return false;
        }
    }

    public static byte[] a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        boolean z = false;
        if (bluetoothGattCharacteristic == null || bArr == null) {
            v.e(TAG, "characteristic or recvData is null");
            return null;
        }
        long j = 0;
        String uuid = bluetoothGattCharacteristic.getUuid().toString();
        BluetoothGattService service = bluetoothGattCharacteristic.getService();
        if (service != null) {
            j = a(service);
        } else {
            v.e(TAG, "the characteristic has no parent service");
        }
        v.d(TAG, "recv data. uuid = %s, data = %s", new Object[]{uuid, b.ak(bArr)});
        boolean z2;
        int i;
        int i2;
        byte[] aF;
        if (0 != (1 & j) && (uuid.equalsIgnoreCase(f.erT) || uuid.equalsIgnoreCase(f.erU))) {
            f fVar = new f();
            if (bArr.length <= 0 || (bArr[0] & 1) == 0) {
                v.e(f.TAG, "pase step data error");
                z2 = false;
            } else if (uuid == null || !(uuid.equals(f.erT) || uuid.equals(f.erU))) {
                v.e(f.TAG, "uuid is not correct");
                z2 = false;
            } else {
                fVar.eqO = uuid;
                i = 4;
                if ((bArr[0] & 2) != 0) {
                    i = 7;
                }
                if ((bArr[0] & 4) != 0) {
                    i += 3;
                }
                if (i > bArr.length) {
                    v.e(f.TAG, "data len is not enough");
                    z2 = false;
                } else {
                    fVar.erV = 0;
                    i2 = 0;
                    i = 1;
                    while (i2 < 3) {
                        fVar.erV += (bArr[i] & 255) << (i2 * 8);
                        i2++;
                        i++;
                    }
                    if ((bArr[0] & 2) != 0) {
                        fVar.erW = 0;
                        i2 = 0;
                        while (i2 < 3) {
                            fVar.erW += (bArr[i] & 255) << (i2 * 8);
                            i2++;
                            i++;
                        }
                    }
                    if ((bArr[0] & 4) != 0) {
                        fVar.erX = 0;
                        i2 = i;
                        for (i = 0; i < 3; i++) {
                            fVar.erX += (bArr[i2] & 255) << (i * 8);
                            i2++;
                        }
                    }
                    z2 = true;
                }
            }
            if (z2) {
                aF = b.aF(fVar);
                v.d(TAG, "step info. stepCount=%d, stepDistance=%d, stepColarie=%d", new Object[]{Integer.valueOf(fVar.erV), Integer.valueOf(fVar.erW), Integer.valueOf(fVar.erX)});
                return aF;
            }
            v.e(TAG, "parse step data error");
            return null;
        } else if (0 != (2 & j) && (uuid.equalsIgnoreCase(g.eqE) || uuid.equalsIgnoreCase(g.eqD))) {
            g gVar = new g();
            if (uuid == null || uuid.length() <= 0 || bArr == null || bArr.length <= 0) {
                v.e(g.TAG, "characteristicUuid or data is null or nil");
                z2 = false;
            } else {
                gVar.eqO = uuid;
                String str;
                Object[] objArr;
                if (gVar.eqO.equalsIgnoreCase(g.eqD)) {
                    if (4 > bArr.length) {
                        v.e(g.TAG, "weight scale feature characteristic data is a 32bit value, but current value len is %d", new Object[]{Integer.valueOf(bArr.length)});
                        z2 = false;
                    } else {
                        gVar.esa = new com.tencent.mm.plugin.c.a.b.a.g.c();
                        gVar.esa.esg = (bArr[0] & 1) != 0;
                        gVar.esa.esh = (bArr[0] & 2) != 0;
                        gVar.esa.esi = (bArr[0] & 4) != 0;
                        gVar.esa.esj = (byte) ((bArr[0] & 120) >> 3);
                        gVar.esa.esk = (byte) (((bArr[0] & 128) >> 7) + ((bArr[1] & 3) << 1));
                        uuid = g.TAG;
                        str = "timestampSupported = %s, multipleUsersSupported = %s, BMISupported = %s, weightResolution = %d, heightResolution = %d";
                        objArr = new Object[5];
                        objArr[0] = gVar.esa.esg ? "true" : "false";
                        objArr[1] = gVar.esa.esh ? "true" : "false";
                        objArr[2] = gVar.esa.esi ? "true" : "false";
                        objArr[3] = Byte.valueOf(gVar.esa.esj);
                        objArr[4] = Byte.valueOf(gVar.esa.esk);
                        v.d(uuid, str, objArr);
                    }
                } else if (gVar.eqO.equalsIgnoreCase(g.eqE)) {
                    byte b = bArr[0];
                    if ((b & 2) != 0) {
                        i = 10;
                    } else {
                        i = 3;
                    }
                    if ((b & 4) != 0) {
                        i++;
                    }
                    if ((b & 8) != 0) {
                        i += 4;
                    }
                    if (i > bArr.length) {
                        v.e(g.TAG, "data len is not enough for parse. current len = %d, needed len = %d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i)});
                        z2 = false;
                    } else {
                        gVar.esb = new g.b();
                        gVar.esb.esc = (b & 1) != 0;
                        gVar.esb.esd = (bArr[1] & 255) + ((bArr[2] & 255) << 8);
                        if ((b & 2) != 0) {
                            gVar.esb.ese = new a();
                            a aVar = gVar.esb.ese;
                            String str2 = g.TAG;
                            String str3 = "data size = %d, offset = %d, lenght = %d";
                            Object[] objArr2 = new Object[3];
                            objArr2[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                            objArr2[1] = Integer.valueOf(3);
                            objArr2[2] = Integer.valueOf(7);
                            v.d(str2, str3, objArr2);
                            if (bArr == null || bArr.length < 10) {
                                v.e(g.TAG, "data input error");
                            } else {
                                aVar.erl = (bArr[3] & 255) + ((bArr[4] & 255) << 8);
                                aVar.erm = bArr[5] & 255;
                                aVar.ern = bArr[6] & 255;
                                aVar.ero = bArr[7] & 255;
                                aVar.erp = bArr[8] & 255;
                                aVar.erq = bArr[9] & 255;
                                v.d(g.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[]{Integer.valueOf(aVar.erl), Integer.valueOf(aVar.erm), Integer.valueOf(aVar.ern), Integer.valueOf(aVar.ero), Integer.valueOf(aVar.erp), Integer.valueOf(aVar.erq)});
                            }
                            i = 10;
                        } else {
                            i = 3;
                        }
                        if ((b & 4) != 0) {
                            gVar.esb.ere = bArr[i] & 255;
                            i++;
                        }
                        if ((b & 8) != 0) {
                            gVar.esb.esf = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
                            i += 2;
                            gVar.esb.QW = ((bArr[i + 1] & 255) << 8) + (bArr[i] & 255);
                        }
                        uuid = g.TAG;
                        str = "WeightAndHeightUnit = %s, Weight = %d, TimeStamp = %s, UserId = %d, BMI = %d, Height = %d";
                        objArr = new Object[6];
                        objArr[0] = gVar.esb.esc ? "lb&inch" : "kg&meter";
                        objArr[1] = Integer.valueOf(gVar.esb.esd);
                        objArr[2] = gVar.esb.ese == null ? "null" : "object";
                        objArr[3] = Integer.valueOf(gVar.esb.ere);
                        objArr[4] = Integer.valueOf(gVar.esb.esf);
                        objArr[5] = Integer.valueOf(gVar.esb.QW);
                        v.d(uuid, str, objArr);
                    }
                }
                z2 = true;
            }
            if (z2) {
                aF = b.aF(gVar);
                v.d(TAG, "weight info. weight = %d", new Object[]{Integer.valueOf(gVar.esb.esd)});
                return aF;
            }
            v.e(TAG, "parse weight scale data error");
            return null;
        } else if (0 != (4 & j) && (uuid.equalsIgnoreCase(d.eqQ) || uuid.equalsIgnoreCase(d.ers) || uuid.equalsIgnoreCase(d.ert))) {
            d dVar = new d();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                v.e(d.TAG, "characteristicUuid or data is null");
            } else {
                dVar.eqO = uuid;
                int length = bArr.length;
                if (dVar.eqO.equalsIgnoreCase(d.eqQ)) {
                    if (bArr.length < 2) {
                        v.e(d.TAG, "Received data length is not right:" + length);
                    } else {
                        int i3;
                        dVar.erA = new a(dVar);
                        byte b2 = bArr[0];
                        v.d(d.TAG, "flag=" + b2);
                        if ((b2 & 1) == 1 && length >= 3) {
                            v.d(d.TAG, "Value Format = uint16");
                            dVar.erA.erB = (((bArr[2] << 8) & 65280) & 65280) + (bArr[1] & 255);
                            i = 3;
                        } else if (length >= 2) {
                            v.d(d.TAG, "Value Format = uint8");
                            dVar.erA.erB = bArr[1] & 255;
                            i = 2;
                        } else {
                            v.d(d.TAG, "receive data error");
                        }
                        v.v(d.TAG, "Data received from HR " + dVar.erA.erB);
                        if ((b2 & 6) == 4) {
                            v.d(d.TAG, "Sensor Contact feature is supported, but contact is not detected");
                            dVar.erA.erC = 1;
                        } else if ((b2 & 6) == 6) {
                            v.d(d.TAG, "Sensor Contact feature is supported and contact is detected");
                            dVar.erA.erC = 2;
                        } else {
                            v.d(d.TAG, "Sensor Contact feature is not supported in the current connection");
                            dVar.erA.erC = 0;
                        }
                        if ((b2 & 8) == 8 && length >= i + 2) {
                            v.d(d.TAG, "Energy Expend Present");
                            i3 = (bArr[i + 1] << 8) & 65280;
                            dVar.erA.erD = (bArr[i] & 255) + (i3 & 65280);
                            v.v("H7ConnectThread", "energyExp from HR energyExph " + i3 + " " + dVar.erA.erD);
                            i += 2;
                        }
                        if ((b2 & 16) == 16 && length >= i + 2) {
                            v.d(d.TAG, "RR Interval Present");
                            i3 = (bArr[i + 1] & 255) << 8;
                            dVar.erA.erE = (bArr[i] & 255) + (i3 & 65280);
                            v.v(d.TAG, "rrInterval from HR rrIntervalh" + i3 + " " + dVar.erA.erE);
                        }
                    }
                } else if (dVar.eqO.equalsIgnoreCase(d.ers)) {
                    switch (bArr[0]) {
                        case (byte) 0:
                            dVar.erz = "Other";
                            break;
                        case (byte) 1:
                            dVar.erz = "Chest";
                            break;
                        case (byte) 2:
                            dVar.erz = "Wrist";
                            break;
                        case (byte) 3:
                            dVar.erz = "Finger";
                            break;
                        case (byte) 4:
                            dVar.erz = "Hand";
                            break;
                        case (byte) 5:
                            dVar.erz = "Ear Lobe";
                            break;
                        case (byte) 6:
                            dVar.erz = "Foot";
                            break;
                        default:
                            dVar.erz = "Unknown";
                            break;
                    }
                    v.d(d.TAG, "position=" + dVar.erz);
                }
                z = true;
            }
            if (z) {
                return b.aF(dVar);
            }
            v.e(TAG, "parse heart rate data error");
            return null;
        } else if (0 != (8 & j) && (uuid.equalsIgnoreCase(b.eqQ) || uuid.equalsIgnoreCase(b.eqR) || uuid.equalsIgnoreCase(b.eqS))) {
            b bVar = new b();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                v.e(b.TAG, "characteristicUuid or data is null");
            } else {
                bVar.eqO = uuid;
                i = bArr.length;
                byte b3;
                if (bVar.eqO.equalsIgnoreCase(b.eqQ)) {
                    if (i < 7) {
                        v.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.eqY = new b(bVar);
                        b3 = bArr[0];
                        v.d(b.TAG, "flag=" + b3);
                        if ((b3 & 1) != 0) {
                            v.d(b.TAG, "the value unit is kPa.");
                            bVar.eqY.erb = true;
                        } else {
                            v.d(b.TAG, "the value unit is mmHg.");
                            bVar.eqY.erb = false;
                        }
                        bVar.eqY.eri = b.s(bArr, 1);
                        bVar.eqY.erj = b.s(bArr, 3);
                        bVar.eqY.erk = b.s(bArr, 5);
                        i2 = 7;
                        if ((b3 & 2) == 0 || i < 14) {
                            v.d(b.TAG, "TimeStamp not Present.");
                        } else {
                            v.d(b.TAG, "TimeStamp Present.");
                            bVar.eqY.erg.t(bArr, 7);
                            i2 = 14;
                        }
                        if ((b3 & 4) == 0 || i < i2 + 2) {
                            v.d(b.TAG, "PulseRate not Present.");
                        } else {
                            v.d(b.TAG, "PulseRate Present.");
                            bVar.eqY.erd = (int) b.s(bArr, i2);
                            i2 += 2;
                            v.d(b.TAG, "PulseRate =" + bVar.eqY.erd);
                        }
                        if ((b3 & 8) != 0) {
                            v.d(b.TAG, "UserId Present.");
                            i = i2 + 1;
                            bVar.eqY.ere = bArr[i2];
                            v.d(b.TAG, "UserId = " + bVar.eqY.ere);
                        } else {
                            v.d(b.TAG, "UserId not Present.");
                            i = i2;
                        }
                        if ((b3 & 16) != 0) {
                            v.d(b.TAG, "MeasurementStatus Present.");
                            bVar.eqY.erf = (bArr[i] & 255) + (((bArr[i + 1] << 8) & 65280) & 65280);
                            v.d(b.TAG, "MeasurementStatus = " + bVar.eqY.erf);
                        } else {
                            v.d(b.TAG, "MeasurementStatus not Present.");
                        }
                    }
                } else if (bVar.eqO.equalsIgnoreCase(b.eqR)) {
                    if (i < 3) {
                        v.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.eqZ = new a(bVar);
                        b3 = bArr[0];
                        v.d(b.TAG, "flag=" + b3);
                        if ((b3 & 1) != 0) {
                            v.d(b.TAG, "the value unit is kPa.");
                            bVar.eqZ.erb = true;
                        } else {
                            v.d(b.TAG, "the value unit is mmHg.");
                            bVar.eqZ.erb = false;
                        }
                        bVar.eqZ.erc = b.s(bArr, 1);
                        if ((b3 & 2) == 0 || i < 10) {
                            v.d(b.TAG, "TimeStamp not Present.");
                            i2 = 3;
                        } else {
                            v.d(b.TAG, "TimeStamp Present.");
                            bVar.eqZ.erg.t(bArr, 3);
                            i2 = 10;
                        }
                        if ((b3 & 4) == 0 || i < i2 + 2) {
                            v.d(b.TAG, "PulseRate not Present.");
                        } else {
                            v.d(b.TAG, "PulseRate Present.");
                            bVar.eqZ.erd = (int) b.s(bArr, i2);
                            i2 += 2;
                            v.d(b.TAG, "PulseRate =" + bVar.eqZ.erd);
                        }
                        if ((b3 & 8) != 0) {
                            v.d(b.TAG, "UserId Present.");
                            i = i2 + 1;
                            bVar.eqZ.ere = bArr[i2];
                            v.d(b.TAG, "UserId = " + bVar.eqZ.ere);
                        } else {
                            v.d(b.TAG, "UserId not Present.");
                            i = i2;
                        }
                        if ((b3 & 16) != 0) {
                            v.d(b.TAG, "MeasurementStatus Present.");
                            bVar.eqZ.erf = (bArr[i] & 255) + (((bArr[i + 1] << 8) & 65280) & 65280);
                            v.d(b.TAG, "MeasurementStatus = " + bVar.eqZ.erf);
                        } else {
                            v.d(b.TAG, "MeasurementStatus not Present.");
                        }
                    }
                } else if (bVar.eqO.equalsIgnoreCase(b.eqS)) {
                    v.d(b.TAG, "Blood Pressure Feature Characteristic.");
                    if (i < 2) {
                        v.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.era = (((bArr[1] << 8) & 65280) & 65280) + (bArr[0] & 255);
                        v.d(b.TAG, "bloodPressureFeatureParameters=" + bVar.era);
                    }
                }
                z = true;
            }
            if (z) {
                return b.aF(bVar);
            }
            v.e(TAG, "parse blood pressure data error");
            return null;
        } else if (0 == (j & 16) || !(uuid.equalsIgnoreCase(e.erG) || uuid.equalsIgnoreCase(e.erH) || uuid.equalsIgnoreCase(e.erI) || uuid.equalsIgnoreCase(e.erJ))) {
            v.e(TAG, "unknown characteristic uuid = %s", new Object[]{uuid});
            return null;
        } else {
            e eVar = new e();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                v.e(e.TAG, "characteristicUuid or data is null");
            } else {
                eVar.eqO = uuid;
                if (eVar.eqO.equalsIgnoreCase(e.erG)) {
                    if (bArr.length != 3) {
                        v.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.erK = bArr[0];
                        eVar.erL = bArr[1];
                        eVar.erM = bArr[2];
                    }
                } else if (eVar.eqO.equalsIgnoreCase(e.erH)) {
                    if (bArr.length != 1) {
                        v.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.erN = bArr[0];
                    }
                } else if (eVar.eqO.equalsIgnoreCase(e.erI)) {
                    if (bArr.length < 2) {
                        v.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.erO[0] = bArr[0];
                        eVar.erO[1] = bArr[1];
                    }
                } else if (!eVar.eqO.equalsIgnoreCase(e.erJ)) {
                    v.e(e.TAG, "characteristicUuid is incorrect");
                } else if (bArr.length < 4) {
                    v.e(e.TAG, "Data length incorrect");
                } else {
                    eVar.erP = (bArr[0] & 255) + ((bArr[1] << 8) & 255);
                    eVar.erR = bArr[2];
                    eVar.erQ = bArr[3];
                    if (bArr.length > 4) {
                        eVar.erS = new byte[(bArr.length - 4)];
                        System.arraycopy(bArr, 4, eVar.erS, 0, bArr.length - 4);
                    } else {
                        eVar.erS = null;
                    }
                }
                z = true;
            }
            if (z) {
                return b.aF(eVar);
            }
            v.e(TAG, "parse light data error");
            return null;
        }
    }
}
