package com.tencent.pb.common.b;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.pb.common.b.a.a.s;
import com.tencent.pb.common.b.a.a.t;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;
import com.tencent.pb.common.c.g;
import com.tencent.pb.talkroom.sdk.e;
import com.tencent.wecall.talkroom.model.h;
import java.util.Iterator;
import java.util.LinkedList;

public class f {
    private static f ppu = null;
    private int ppv;
    private LinkedList<a> ppw;
    public e ppx;
    private boolean ppy;
    private boolean ppz;

    private class a {
        int mTaskId;
        public String ppA;
        a ppB;
        c ppC;
        final /* synthetic */ f ppD;

        private a(f fVar) {
            this.ppD = fVar;
        }
    }

    private f() {
        this.ppv = 0;
        this.ppw = null;
        this.ppx = null;
        this.ppy = false;
        this.ppz = true;
        this.ppw = new LinkedList();
        this.ppz = true;
    }

    private static t bt(byte[] bArr) {
        try {
            return (t) com.google.a.a.e.a(new t(), bArr, bArr.length);
        } catch (Exception e) {
            c.i("NETCMD", "Exception genReadPackageData" + e.getMessage());
            return null;
        }
    }

    private int a(a aVar, c cVar, String str, int i, byte[] bArr, int i2, int i3, int i4) {
        byte[] bArr2;
        int bLV = bLV();
        byte[] bArr3 = null;
        try {
            s sVar;
            if (bArr.length < 200 || bArr == null || bArr.length >= bArr.length) {
                sVar = new s();
                sVar.of = i;
                sVar.pqY = bLV;
                sVar.userName = com.tencent.pb.b.a.a.bMo();
                sVar.ppV = i4;
            } else {
                sVar = new s();
                sVar.of = i;
                sVar.pqY = bLV;
                sVar.userName = com.tencent.pb.b.a.a.bMo();
                sVar.ppV = i4;
            }
            if (bArr == null) {
                c.i("NETCMD", "body null");
                bArr3 = null;
            } else {
                com.google.a.a.e tVar = new t();
                tVar.pra = sVar;
                tVar.body = bArr;
                bArr3 = com.google.a.a.e.b(tVar);
            }
            bArr2 = bArr3;
        } catch (Exception e) {
            c.i("NetError", "newTaskHelper addTask body null");
            bArr2 = bArr3;
        }
        if (bArr2 == null) {
            c.i("NETCMD", "cmd:" + i + "|body is null");
            return -1;
        } else if (bArr2.length > 61440) {
            c.i("NETCMD", "cmd:" + i + "|body too large");
            return -1;
        } else {
            a aVar2 = new a();
            aVar2.mTaskId = bLV;
            aVar2.ppB = aVar;
            aVar2.ppC = cVar;
            aVar2.ppA = str;
            synchronized (this.ppw) {
                this.ppw.add(aVar2);
            }
            int i5 = 1933;
            switch (i) {
                case 139:
                    i5 = 1918;
                    break;
                case 141:
                    i5 = 1919;
                    break;
                case 143:
                    i5 = 1927;
                    break;
                case 145:
                    i5 = 1931;
                    break;
                case 147:
                    i5 = 1932;
                    break;
                case 181:
                    i5 = 1929;
                    break;
                case 183:
                    i5 = 1928;
                    break;
                case 189:
                    i5 = 1935;
                    break;
                case 211:
                    i5 = 1937;
                    break;
                case 221:
                    i5 = 1938;
                    break;
                case 223:
                    i5 = 1939;
                    break;
            }
            c.d("NETCMD", "CLTSEND|", Integer.valueOf(bLV), Integer.valueOf(i5), str, com.tencent.pb.b.a.a.bMo());
            if (this.ppx != null) {
                this.ppx.a(bLV, i5, bArr2);
            }
            return bLV;
        }
    }

    private int bLV() {
        int i;
        synchronized (this.ppw) {
            this.ppv++;
            i = this.ppv;
        }
        return i;
    }

    public final a yF(int i) {
        a aVar;
        synchronized (this.ppw) {
            Iterator it = this.ppw.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.mTaskId == i) {
                    break;
                }
            }
            aVar = null;
        }
        return aVar;
    }

    public static f bLW() {
        if (ppu == null) {
            synchronized (f.class) {
                if (ppu == null) {
                    ppu = new f();
                }
            }
        }
        return ppu;
    }

    final int a(a aVar, c cVar, int i, String str, byte[] bArr, int i2) {
        if (!this.ppz) {
            c.i("NETCMD", "doSendTask mIsInitSucc is false");
            return -1;
        } else if (this.ppy) {
            c.i("NETCMD", "doSendTask fail: isRefreshing, cmd=" + i + ", cmdTag=" + str);
            return -1;
        } else {
            try {
                return a(aVar, cVar, str, i, bArr, 0, 0, i2);
            } catch (Throwable th) {
                c.i("NETCMD", "Exception doSendTask", th);
                return -1;
            }
        }
    }

    public final int a(a aVar, String str, com.google.a.a.e eVar) {
        try {
            return a(aVar, null, 31, str, com.google.a.a.e.b(eVar), 0);
        } catch (Exception e) {
            c.i("NETCMD", "doSendTask exception:", e);
            return -1;
        }
    }

    public static int bu(byte[] bArr) {
        if (bArr == null) {
            c.i("NETCMD", "CLTNOT onNotify1 data == null ", Integer.valueOf(0));
            h.zJ(-1601);
            if (TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.bPi().gpg) && TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.bPi().pIh)) {
                h.a(com.tencent.wecall.talkroom.model.a.bPi().gLN, com.tencent.wecall.talkroom.model.a.bPi().pIi, "notify", "datanull");
            } else {
                com.tencent.wecall.talkroom.model.a.bPi().pIq.J("notify", "datanull");
            }
            return -1;
        }
        c.d("NETCMD", "CLTNOT onNotify data len=", Integer.valueOf(bArr.length));
        return com.tencent.wecall.talkroom.model.a.bPi().bB(bArr);
    }

    public final void a(a aVar, int i, byte[] bArr) {
        try {
            if (aVar.ppC != null) {
                aVar.ppC.m(i, bArr);
            }
            if (aVar.ppB != null) {
                aVar.ppB.co(aVar.ppA, i);
            }
        } catch (Exception e) {
            c.i("NETCMD", "postRespData", e.getMessage());
        }
        synchronized (this.ppw) {
            this.ppw.remove(aVar);
        }
    }

    public final int n(int i, byte[] bArr) {
        a yF = yF(i);
        if (yF != null || -1000 == i) {
            t bt = bt(bArr);
            if (bt == null || bt.pra == null) {
                String str;
                String str2 = "NETCMD";
                Object[] objArr = new Object[2];
                objArr[0] = " pack.head: ";
                if (bt == null) {
                    str = " pack is null ";
                } else {
                    str = " head is " + bt.pra;
                }
                objArr[1] = str;
                c.i(str2, objArr);
                a(yF, -3, null);
                return -1;
            }
            int i2 = bt.pra.ret;
            int i3 = bt.pra.pqZ;
            String str3 = bt.pra.userName;
            if (com.tencent.pb.common.a.a.poJ) {
                Toast.makeText(d.kzS, "retCode: " + i2 + " debugCode: " + i3, 0).show();
            }
            if (i2 != 0 && yF != null) {
                c.i("NETCMD", "CLTRCV", Integer.valueOf(i), yF.ppA, Integer.valueOf(i2), str3, Integer.valueOf(i3));
            } else if (yF != null) {
                c.d("NETCMD", "CLTRCV", Integer.valueOf(i), yF.ppA, Integer.valueOf(i2), str3, Integer.valueOf(i3));
            }
            byte[] bArr2 = bt.body;
            if (bArr2 != null) {
                a(yF, i2, bArr2);
                return 0;
            }
            a(yF, i2, null);
            return 0;
        }
        c.i("NETCMD", "buf2Resp fail: taskId:" + i + " not found");
        g.s(20007, 3, "-1202");
        return 1;
    }
}
