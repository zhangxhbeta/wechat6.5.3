package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class f {
    public HashMap<Long, a> fxr = new HashMap();

    public static class a {
        public byte[] aKD;
        public String aZU;
        public int baO;
        public long eqh;
        public long fxs;
        public byte[] fxt;
        public byte[] fxu;
        public boolean fxv;
        public String mURL;
    }

    public final boolean be(long j) {
        if (bf(j) == 2) {
            return true;
        }
        return false;
    }

    public final int bf(long j) {
        if (this.fxr.containsKey(Long.valueOf(j))) {
            return ((a) this.fxr.get(Long.valueOf(j))).baO;
        }
        return 0;
    }

    public final a bg(long j) {
        if (!this.fxr.containsKey(Long.valueOf(j))) {
            bl(j);
        }
        return (a) this.fxr.get(Long.valueOf(j));
    }

    public final a bh(long j) {
        if (this.fxr.containsKey(Long.valueOf(j))) {
            return (a) this.fxr.get(Long.valueOf(j));
        }
        a aVar = new a();
        aVar.fxs = j;
        aVar.fxu = null;
        aVar.aKD = null;
        aVar.fxt = null;
        aVar.aZU = null;
        aVar.mURL = null;
        aVar.baO = 0;
        aVar.fxv = false;
        aVar.eqh = 0;
        this.fxr.put(Long.valueOf(j), aVar);
        return aVar;
    }

    public final boolean bi(long j) {
        v.i("MicroMsg.exdevice.ExdeviceInfoManager", "setDeviceAuthFlag, device id = %d", new Object[]{Long.valueOf(j)});
        a bg = bg(j);
        if (bg == null) {
            v.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            return false;
        }
        bg.fxv = true;
        return true;
    }

    public final boolean bj(long j) {
        v.i("MicroMsg.exdevice.ExdeviceInfoManager", "delDeviceAuthFlag, device id = %d", new Object[]{Long.valueOf(j)});
        a bg = bg(j);
        if (bg == null) {
            v.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            return false;
        }
        bg.fxv = false;
        return true;
    }

    public final boolean bk(long j) {
        v.i("MicroMsg.exdevice.ExdeviceInfoManager", "isDeviceAuthed, device id = %d", new Object[]{Long.valueOf(j)});
        a bg = bg(j);
        if (bg != null) {
            return bg.fxv;
        }
        v.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
        return false;
    }

    private void bl(long j) {
        b sp = ac.ajq().sp(String.valueOf(j));
        if (sp == null) {
            v.e("MicroMsg.exdevice.ExdeviceInfoManager", "get harddevice info from db failed : %d", new Object[]{Long.valueOf(j)});
            return;
        }
        a aVar = new a();
        aVar.fxs = j;
        aVar.fxu = sp.field_authBuf;
        aVar.aKD = sp.field_sessionKey;
        aVar.fxt = sp.field_sessionBuf;
        aVar.aZU = sp.field_brandName;
        aVar.mURL = sp.field_url;
        aVar.baO = 0;
        aVar.fxv = false;
        this.fxr.put(Long.valueOf(j), aVar);
        v.i("MicroMsg.exdevice.ExdeviceInfoManager", "not contains the device info, device id = %d, load from db", new Object[]{Long.valueOf(j)});
    }

    public final byte[] h(long j, int i) {
        if (j < 0) {
            v.e("MicroMsg.exdevice.ExdeviceInfoManager", "device is lower than 0");
            return null;
        }
        a aVar = (a) this.fxr.get(Long.valueOf(j));
        if (aVar == null) {
            bl(j);
            aVar = (a) this.fxr.get(Long.valueOf(j));
        }
        if (aVar == null) {
            return null;
        }
        byte[] bArr;
        switch (i) {
            case 1:
                bArr = aVar.fxu;
                break;
            case 2:
                bArr = aVar.aKD;
                break;
            case 3:
                bArr = aVar.fxt;
                break;
            default:
                bArr = null;
                break;
        }
        return bArr;
    }

    public final void a(long j, byte[] bArr, int i) {
        if (j < 0 || bArr == null || bArr.length == 0) {
            boolean z;
            int i2;
            String str = "MicroMsg.exdevice.ExdeviceInfoManager";
            String str2 = "device id low than 0 or authbuf is null, deviceid = %d, buffer == null : %b, buffer length = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(j);
            if (bArr == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            if (bArr == null) {
                i2 = -1;
            } else {
                i2 = bArr.length;
            }
            objArr[2] = Integer.valueOf(i2);
            v.e(str, str2, objArr);
            return;
        }
        a aVar = (a) this.fxr.get(Long.valueOf(j));
        if (aVar == null) {
            aVar = new a();
            aVar.fxs = j;
        }
        switch (i) {
            case 1:
                aVar.fxu = bArr;
                break;
            case 2:
                aVar.aKD = bArr;
                break;
            case 3:
                aVar.fxt = bArr;
                break;
            default:
                v.e("MicroMsg.exdevice.ExdeviceInfoManager", "unkown buffer type : %d", new Object[]{Integer.valueOf(i)});
                break;
        }
        this.fxr.put(Long.valueOf(j), aVar);
    }
}
