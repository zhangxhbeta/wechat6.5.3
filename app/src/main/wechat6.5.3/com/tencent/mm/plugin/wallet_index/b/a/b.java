package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.mm.sdk.platformtools.aa;

public final class b {
    public int gDS;
    public int kXc = 0;
    public String mMessage;

    private b(int i, String str) {
        this.gDS = i;
        this.mMessage = str;
    }

    public static b sw(int i) {
        int i2 = 2131233202;
        int i3 = -1;
        switch (i) {
            case -3000:
                i3 = 100000009;
                break;
            case -2002:
                i3 = 1000000093;
                i2 = 2131233197;
                break;
            case -2001:
                i3 = 100000004;
                i2 = 2131233196;
                break;
            case -1010:
            case -1006:
            case -1003:
            case -1002:
                i2 = 2131233194;
                break;
            case -1005:
            case 1:
                i3 = 100000000;
                i2 = 2131233203;
                break;
            case 0:
                i3 = 0;
                i2 = 2131233201;
                break;
            case 3:
                i2 = 2131233195;
                break;
            case 4:
                i2 = 2131233200;
                break;
            case 7:
            case 103:
                i3 = 103;
                i2 = 2131233198;
                break;
            case 8:
                i2 = 2131233199;
                break;
        }
        b bVar = new b(i3, aa.getContext().getString(i2));
        bVar.kXc = i;
        return bVar;
    }

    public static b al(int i, String str) {
        int i2 = 2131236698;
        int i3 = -1;
        switch (i) {
            case 0:
                i3 = 0;
                i2 = 2131236697;
                break;
            case 1:
            case 100000000:
                i3 = 100000000;
                i2 = 2131236699;
                break;
            case 103:
                i3 = 103;
                i2 = 2131236696;
                break;
            case 105:
                return new b(-1, str);
            case 109:
                i3 = 109;
                i2 = 2131236700;
                break;
            case 110:
                i3 = 110;
                i2 = 2131236702;
                break;
            case 111:
                i3 = 111;
                i2 = 2131236703;
                break;
            case 112:
                i3 = 112;
                i2 = 2131236701;
                break;
            case 113:
                i3 = 113;
                break;
        }
        return new b(i3, aa.getContext().getString(i2));
    }

    public final boolean bhw() {
        return this.gDS == 7 || this.gDS == 103;
    }

    public final boolean isFailure() {
        return ((this.gDS == 0) || bhw()) ? false : true;
    }

    public final String toString() {
        return "IabResult: " + this.mMessage;
    }
}
