package com.tencent.mm.protocal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;
import java.util.Set;

public class JsapiPermissionWrapper implements Parcelable {
    public static final Creator<JsapiPermissionWrapper> CREATOR = new Creator<JsapiPermissionWrapper>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsapiPermissionWrapper(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsapiPermissionWrapper[i];
        }
    };
    public static final JsapiPermissionWrapper lWt = new JsapiPermissionWrapper(1);
    public static final JsapiPermissionWrapper lWu = new JsapiPermissionWrapper(2);
    public static final JsapiPermissionWrapper lWv = new JsapiPermissionWrapper(3);
    public static final JsapiPermissionWrapper lWw = new JsapiPermissionWrapper(4);
    private Set<Integer> lWA;
    public byte[] lWx;
    private int lWy;
    private Set<Integer> lWz;

    public JsapiPermissionWrapper() {
        this.lWx = null;
        this.lWy = 0;
        this.lWx = null;
    }

    public JsapiPermissionWrapper(byte[] bArr) {
        this.lWx = null;
        this.lWy = 0;
        if (bArr == null) {
            this.lWx = null;
        } else {
            this.lWx = bArr;
        }
    }

    public JsapiPermissionWrapper(int i) {
        this.lWx = null;
        this.lWy = 0;
        this.lWy = i;
        this.lWx = new byte[0];
    }

    public final int uB(int i) {
        int i2;
        if (this.lWA == null || !this.lWA.contains(Integer.valueOf(i))) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i2 != 0) {
            return 1;
        }
        if (this.lWz == null || !this.lWz.contains(Integer.valueOf(i))) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i2 != 0) {
            return 0;
        }
        if (this.lWy == 1) {
            if (i != 34 && i != 75) {
                return 1;
            }
            v.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", Integer.valueOf(i));
            return 0;
        } else if (this.lWy == 2) {
            if (i != -3) {
                return 0;
            }
            return 1;
        } else if (this.lWy == 3) {
            if (i != 34 && i != 75 && i != 23) {
                return 1;
            }
            v.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", Integer.valueOf(i));
            return 0;
        } else if (this.lWy == 4) {
            if (i != 34 && i != 75) {
                return 1;
            }
            v.i("MicroMsg.JsapiPermissionWrapper", "hy: on reserved bytes control : %d", Integer.valueOf(i));
            return 0;
        } else if (i == -2 || i == -3) {
            return 1;
        } else {
            if (this.lWx == null || i < 0 || i >= this.lWx.length) {
                return 0;
            }
            return this.lWx[i];
        }
    }

    public final boolean uC(int i) {
        if (uB(i) == 1) {
            return true;
        }
        return false;
    }

    public static boolean brB() {
        return true;
    }

    public String toString() {
        if (this.lWx == null) {
            return "null";
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder(180);
        for (byte append : this.lWx) {
            stringBuilder.append(append);
        }
        String stringBuilder2 = stringBuilder.toString();
        v.d("MicroMsg.JsapiPermissionWrapper", "toString cost %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.lWx);
        parcel.writeInt(this.lWy);
        parcel.writeIntArray(brC());
        parcel.writeIntArray(brD());
    }

    private JsapiPermissionWrapper(Parcel parcel) {
        this.lWx = null;
        this.lWy = 0;
        this.lWx = parcel.createByteArray();
        this.lWy = parcel.readInt();
        p(parcel.createIntArray());
        q(parcel.createIntArray());
    }

    public final void t(Bundle bundle) {
        bundle.putByteArray("jsapi_perm_wrapper_bytes", this.lWx);
        bundle.putInt("jsapi_perm_wrapper_hardcodePermission", this.lWy);
        bundle.putIntArray("jsapi_perm_wrapper_blacklist", brC());
        bundle.putIntArray("jsapi_perm_wrapper_whitelist", brD());
    }

    public final void u(Bundle bundle) {
        this.lWx = bundle.getByteArray("jsapi_perm_wrapper_bytes");
        this.lWy = bundle.getInt("jsapi_perm_wrapper_hardcodePermission");
        p(bundle.getIntArray("jsapi_perm_wrapper_blacklist"));
        q(bundle.getIntArray("jsapi_perm_wrapper_whitelist"));
    }

    private int[] brC() {
        if (this.lWz == null) {
            return new int[0];
        }
        int[] iArr = new int[this.lWz.size()];
        int i = 0;
        for (Integer num : this.lWz) {
            int i2 = i + 1;
            iArr[i] = num == null ? 0 : num.intValue();
            i = i2;
        }
        return iArr;
    }

    public final void p(int[] iArr) {
        if (this.lWz == null) {
            this.lWz = new HashSet();
        } else {
            this.lWz.clear();
        }
        if (iArr != null && iArr.length > 0) {
            for (int valueOf : iArr) {
                this.lWz.add(Integer.valueOf(valueOf));
            }
        }
    }

    private int[] brD() {
        if (this.lWA == null) {
            return new int[0];
        }
        int[] iArr = new int[this.lWA.size()];
        int i = 0;
        for (Integer num : this.lWA) {
            int i2 = i + 1;
            iArr[i] = num == null ? 0 : num.intValue();
            i = i2;
        }
        return iArr;
    }

    public final void q(int[] iArr) {
        if (this.lWA == null) {
            this.lWA = new HashSet();
        } else {
            this.lWA.clear();
        }
        if (iArr != null && iArr.length > 0) {
            for (int valueOf : iArr) {
                this.lWA.add(Integer.valueOf(valueOf));
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JsapiPermissionWrapper)) {
            return false;
        }
        JsapiPermissionWrapper jsapiPermissionWrapper = (JsapiPermissionWrapper) obj;
        if (this.lWx == jsapiPermissionWrapper.lWx) {
            return true;
        }
        if (this.lWx == null || jsapiPermissionWrapper.lWx == null || this.lWx.length != jsapiPermissionWrapper.lWx.length) {
            return false;
        }
        for (int i = 0; i < this.lWx.length; i++) {
            if (this.lWx[i] != jsapiPermissionWrapper.lWx[i]) {
                return false;
            }
        }
        return true;
    }
}
