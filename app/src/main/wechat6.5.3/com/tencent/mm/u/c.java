package com.tencent.mm.u;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.a.f;
import com.tencent.mm.a.o;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.acz;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public final class c implements e {
    boolean cxK = false;
    Set<String> cxL = new HashSet();
    f<String, c> cxM = new f(400);
    Stack<h> cxN = new Stack();
    private ap cxO = null;
    private ap cxP = null;
    String cxQ = null;
    f<String, String> cxR = new f(200);
    ah cxS = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ c cxU;
        private long cxV = 0;

        {
            this.cxU = r3;
        }

        public final boolean oU() {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.cxU.cxK && currentTimeMillis - this.cxV > 60000) {
                v.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", Long.valueOf(currentTimeMillis - this.cxV));
                this.cxU.cxK = false;
            }
            if (this.cxU.cxK) {
                this.cxU.cxS.ea(1000);
            } else {
                this.cxV = currentTimeMillis;
                this.cxU.cxK = true;
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < 5 && this.cxU.cxN.size() > 0; i++) {
                    linkedList.add(new arf().JF(((h) this.cxU.cxN.pop()).getUsername()));
                }
                ak.vy().a(new j(linkedList), 0);
            }
            return false;
        }
    }, false);

    private static class c {
        public long cvj;
        public int cxZ;

        private c() {
            this.cvj = 0;
            this.cxZ = 0;
        }
    }

    private class a implements com.tencent.mm.sdk.platformtools.ap.a {
        final /* synthetic */ c cxU;
        public h cxW = null;
        public byte[] cxX = null;

        public a(c cVar, h hVar) {
            this.cxU = cVar;
            this.cxW = hVar;
        }

        public final boolean AZ() {
            ProtocolException e;
            SocketTimeoutException e2;
            IOException e3;
            Exception e4;
            if (this.cxW == null) {
                return false;
            }
            String Bf = this.cxW.Bf();
            String str = SQLiteDatabase.KeyEmpty;
            if (ak.uz()) {
                r1 = new Object[4];
                ak.yW();
                r1[1] = o.getString(com.tencent.mm.model.c.ww());
                r1[2] = Integer.valueOf(com.tencent.mm.sdk.platformtools.ak.getNetTypeForStat(aa.getContext()));
                r1[3] = Integer.valueOf(com.tencent.mm.sdk.platformtools.ak.getStrength(aa.getContext()));
                str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r1);
            }
            v.d("MicroMsg.HttpGetAvatar", "dkreferer dkavatar user: %s referer: %s", this.cxW.getUsername(), str);
            this.cxX = null;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream inputStream = null;
            t a;
            try {
                a = com.tencent.mm.network.b.a(Bf, null);
                try {
                    a.setRequestMethod("GET");
                    a.setRequestProperty("referer", str);
                    a.setConnectTimeout(5000);
                    a.setReadTimeout(5000);
                    if (com.tencent.mm.network.b.a(a) != 0) {
                        v.e("MicroMsg.HttpGetAvatar", "checkHttpConnection failed! url:%s code:%d", Bf, Integer.valueOf(a.getResponseCode()));
                        switch (a.getResponseCode()) {
                            case TencentLocation.ERROR_UNKNOWN /*404*/:
                                g.iuh.a(138, 2, 1, true);
                                break;
                            case 502:
                                g.iuh.a(138, 3, 1, true);
                                break;
                            case 503:
                                g.iuh.a(138, 4, 1, true);
                                break;
                            case 504:
                                g.iuh.a(138, 5, 1, true);
                                break;
                            default:
                                g.iuh.a(138, 6, 1, true);
                                break;
                        }
                        return true;
                    }
                    int contentLength = a.dmc.getContentLength();
                    InputStream inputStream2 = a.getInputStream();
                    if (inputStream2 == null) {
                        try {
                            v.d("MicroMsg.HttpGetAvatar", "getInputStream failed. url:%s", Bf);
                            return true;
                        } catch (ProtocolException e5) {
                            e = e5;
                            inputStream = inputStream2;
                            g.iuh.a(138, 1, 1, true);
                            v.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bf, e.getClass().getSimpleName(), e.getMessage());
                            if (a != null) {
                                try {
                                    a.dmc.disconnect();
                                } catch (Throwable e6) {
                                    v.e("MicroMsg.HttpGetAvatar", "exception:%s", be.e(e6));
                                    v.e("MicroMsg.HttpGetAvatar", "close conn failed : %s", e6.getMessage());
                                    g.iuh.a(138, 9, 1, true);
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (SocketTimeoutException e7) {
                            e2 = e7;
                            inputStream = inputStream2;
                            g.iuh.a(138, 8, 1, true);
                            v.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bf, e2.getClass().getSimpleName(), e2.getMessage());
                            if (a != null) {
                                a.dmc.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (IOException e8) {
                            e3 = e8;
                            inputStream = inputStream2;
                            g.iuh.a(138, 7, 1, true);
                            v.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bf, e3.getClass().getSimpleName(), e3.getMessage());
                            if (a != null) {
                                a.dmc.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (Exception e9) {
                            e4 = e9;
                            inputStream = inputStream2;
                            g.iuh.a(138, 0, 1, true);
                            v.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bf, e4.getClass().getSimpleName(), e4.getMessage());
                            if (a != null) {
                                a.dmc.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        }
                    }
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    this.cxX = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    byteArrayOutputStream = null;
                    a.dmc.disconnect();
                    a = null;
                    inputStream2.close();
                    inputStream = null;
                    if (contentLength > 0) {
                        if (this.cxX.length < contentLength) {
                            g.iuh.a(138, 15, 1, true);
                            v.e("MicroMsg.HttpGetAvatar", "HTTP downloaded length is smaller than Content-Length field. Drop.");
                        }
                    }
                    if (a != null) {
                        a.dmc.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                } catch (ProtocolException e10) {
                    e = e10;
                    g.iuh.a(138, 1, 1, true);
                    v.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bf, e.getClass().getSimpleName(), e.getMessage());
                    if (a != null) {
                        a.dmc.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                } catch (SocketTimeoutException e11) {
                    e2 = e11;
                    g.iuh.a(138, 8, 1, true);
                    v.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bf, e2.getClass().getSimpleName(), e2.getMessage());
                    if (a != null) {
                        a.dmc.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                } catch (IOException e12) {
                    e3 = e12;
                    g.iuh.a(138, 7, 1, true);
                    v.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bf, e3.getClass().getSimpleName(), e3.getMessage());
                    if (a != null) {
                        a.dmc.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                } catch (Exception e13) {
                    e4 = e13;
                    g.iuh.a(138, 0, 1, true);
                    v.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bf, e4.getClass().getSimpleName(), e4.getMessage());
                    if (a != null) {
                        a.dmc.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                }
            } catch (ProtocolException e14) {
                e = e14;
                a = null;
                g.iuh.a(138, 1, 1, true);
                v.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bf, e.getClass().getSimpleName(), e.getMessage());
                if (a != null) {
                    a.dmc.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return true;
            } catch (SocketTimeoutException e15) {
                e2 = e15;
                a = null;
                g.iuh.a(138, 8, 1, true);
                v.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bf, e2.getClass().getSimpleName(), e2.getMessage());
                if (a != null) {
                    a.dmc.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return true;
            } catch (IOException e16) {
                e3 = e16;
                a = null;
                g.iuh.a(138, 7, 1, true);
                v.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bf, e3.getClass().getSimpleName(), e3.getMessage());
                if (a != null) {
                    a.dmc.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return true;
            } catch (Exception e17) {
                e4 = e17;
                a = null;
                g.iuh.a(138, 0, 1, true);
                v.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bf, e4.getClass().getSimpleName(), e4.getMessage());
                if (a != null) {
                    a.dmc.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return true;
            }
        }

        public final boolean Ba() {
            if (!(this.cxW == null || be.kS(this.cxW.getUsername()))) {
                if (be.bl(this.cxX)) {
                    this.cxU.cxL.remove(this.cxW.getUsername());
                    g.iuh.a(138, 10, 1, true);
                } else {
                    if (com.tencent.mm.model.ab.a.csa != null) {
                        com.tencent.mm.model.ab.a.csa.aC(this.cxX.length, 0);
                    }
                    this.cxU.a(new d(this.cxU, this.cxW, this.cxX));
                }
            }
            return false;
        }
    }

    private class b implements com.tencent.mm.sdk.platformtools.ap.a {
        final /* synthetic */ c cxU;
        Bitmap cxY = null;
        String username = null;

        public b(c cVar, String str) {
            this.cxU = cVar;
            this.username = str;
        }

        public final boolean AZ() {
            h hVar = null;
            int i = 0;
            if (be.kS(this.username)) {
                return false;
            }
            String str = this.username;
            if (str == null ? false : str.startsWith("ammURL_")) {
                String str2 = (String) this.cxU.cxR.get(str);
                if (!be.kS(str2)) {
                    h gQ = n.Bo().gQ(str);
                    if (gQ == null || !str.equals(gQ.getUsername())) {
                        Cursor rawQuery = n.Bo().cuX.rawQuery("select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + be.lZ(str2) + "\"", null);
                        if (rawQuery != null) {
                            if (rawQuery.getCount() != 0) {
                                rawQuery.moveToFirst();
                                hVar = new h();
                                hVar.b(rawQuery);
                            }
                            rawQuery.close();
                        }
                        if (!(hVar == null || be.kS(hVar.getUsername()))) {
                            FileOp.p(b.r(hVar.getUsername(), false), b.r(str, false));
                        }
                        hVar = new h();
                        hVar.username = str;
                        hVar.bBY = 3;
                        hVar.cyC = str2;
                        hVar.cyD = str2;
                        hVar.bkU = 3;
                        hVar.aP(true);
                        hVar.bkU = 31;
                        n.Bo().a(hVar);
                    }
                }
            }
            d AX = c.AX();
            if (AX == null) {
                return false;
            }
            if (d.cyd.containsKey(this.username)) {
                i = ((Integer) d.cyd.get(this.username)).intValue();
            }
            if (i != 0) {
                n.Bn();
                Context context = n.getContext();
                if (context != null) {
                    AX.d(this.username, com.tencent.mm.compatible.f.a.decodeResource(context.getResources(), i));
                }
            }
            this.cxY = d.gI(this.username);
            return true;
        }

        public final boolean Ba() {
            if (this.cxY == null) {
                h hVar;
                c cVar = this.cxU;
                String str = this.username;
                v.d("MicroMsg.AvatarService", "avatar service push: %s", str);
                if (be.kS(str)) {
                    hVar = null;
                } else {
                    if (str.equals(cVar.cxQ + "@bottle")) {
                        ak.yW();
                        if (!be.a((Boolean) com.tencent.mm.model.c.vf().get(60, null), false)) {
                            hVar = null;
                        }
                    }
                    if (str.equals(cVar.cxQ)) {
                        ak.yW();
                        if (!be.a((Boolean) com.tencent.mm.model.c.vf().get(59, null), false)) {
                            hVar = null;
                        }
                    }
                    long Nh = be.Nh();
                    c cVar2 = (c) cVar.cxM.get(str);
                    if (cVar2 == null || cVar2.cxZ < 5 || Nh - cVar2.cvj >= 600) {
                        h gF = c.gF(str);
                        if (gF == null) {
                            v.w("MicroMsg.AvatarService", "checkUser block local no need: %s", str);
                            cVar2 = new c();
                            cVar2.cxZ = 5;
                            cVar2.cvj = Nh;
                            cVar.cxM.k(str, cVar2);
                            hVar = null;
                        } else {
                            if (cVar2 == null || Nh - cVar2.cvj > 600) {
                                v.d("MicroMsg.AvatarService", "new user: %s", str);
                                cVar2 = new c();
                                cVar2.cxZ = 1;
                                cVar2.cvj = Nh;
                                cVar.cxM.k(str, cVar2);
                            } else if (cVar2.cxZ < 5) {
                                v.d("MicroMsg.AvatarService", "checkUser: %s tryCount: %d time: %d", str, Integer.valueOf(cVar2.cxZ), Long.valueOf(Nh - cVar2.cvj));
                                cVar2.cxZ++;
                                cVar2.cvj = Nh;
                                cVar.cxM.k(str, cVar2);
                            }
                            hVar = gF;
                        }
                    } else {
                        v.w("MicroMsg.AvatarService", "checkUser block by recentdown: %s", str);
                        hVar = null;
                    }
                }
                if (hVar == null) {
                    cVar.cxL.remove(str);
                } else if (be.kS(hVar.Bf())) {
                    v.w("MicroMsg.AvatarService", "dkhurl [%s] has NO URL flag:%d !", str, Integer.valueOf(hVar.bBY));
                    if (4 == hVar.bBY) {
                        v.w("MicroMsg.AvatarService", "no avatar, do not batch get head image");
                    } else {
                        cVar.cxN.push(hVar);
                        if (cVar.cxN.size() > 5) {
                            cVar.cxS.ea(0);
                        } else {
                            cVar.cxS.ea(1000);
                        }
                    }
                } else {
                    cVar.a(new a(cVar, hVar));
                }
                return false;
            }
            d AX = c.AX();
            if (AX != null) {
                AX.c(this.username, this.cxY);
            }
            this.cxU.cxL.remove(this.username);
            return false;
        }
    }

    private class d implements com.tencent.mm.sdk.platformtools.ap.a {
        Bitmap bitmap = null;
        byte[] buf;
        final /* synthetic */ c cxU;
        h cya = null;

        public d(c cVar, h hVar, byte[] bArr) {
            this.cxU = cVar;
            this.cya = hVar;
            this.buf = bArr;
        }

        public final boolean AZ() {
            if (this.cya == null || be.kS(this.cya.getUsername())) {
                v.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
                g.iuh.a(138, 13, 1, true);
                return false;
            }
            if (c.AX() != null) {
                this.bitmap = d.f(this.cya.getUsername(), this.buf);
                if (this.bitmap == null) {
                    g.iuh.a(138, 14, 1, true);
                }
            }
            i AY = c.AY();
            if (AY == null) {
                return true;
            }
            this.cya.bkU = -1;
            this.cya.Bg();
            AY.a(this.cya);
            return true;
        }

        public final boolean Ba() {
            if (!be.kS(this.cya.getUsername())) {
                d AX = c.AX();
                if (!(AX == null || this.bitmap == null)) {
                    AX.c(this.cya.getUsername(), this.bitmap);
                }
                this.cxU.cxL.remove(this.cya.getUsername());
            }
            return false;
        }
    }

    static /* synthetic */ i AY() {
        return ak.uz() ? n.Bo() : null;
    }

    public c() {
        ak.vy().a(123, (e) this);
        this.cxK = false;
        this.cxQ = k.xF();
    }

    public final Bitmap b(String str, boolean z, int i) {
        Bitmap gH;
        d AX = AX();
        if (AX != null) {
            if (i > 5) {
                gH = d.gH(String.format("%s$$%d", new Object[]{str, Integer.valueOf(i)}));
                if (gH != null) {
                    v.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", Integer.valueOf(i));
                    return gH;
                }
                v.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", Integer.valueOf(i));
            } else {
                gH = null;
            }
            if (gH == null) {
                gH = d.gH(str);
            }
        } else {
            gH = null;
        }
        if (gH != null) {
            if (i <= 5) {
                return gH;
            }
            v.i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", Integer.valueOf(i));
            gH = com.tencent.mm.sdk.platformtools.d.a(gH, false, (float) i);
            AX.c(String.format("%s$$%d", new Object[]{str, Integer.valueOf(i)}), gH);
            return gH;
        } else if (z) {
            return null;
        } else {
            v.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", str);
            if (this.cxL.contains(str)) {
                return null;
            }
            this.cxL.add(str);
            a(new b(this, str));
            return null;
        }
    }

    public final void gD(String str) {
        a(new b(this, str));
    }

    public final void gE(final String str) {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ c cxU;

            public final void run() {
                if (!be.kS(str) && !str.equals(this.cxU.cxQ)) {
                    i AY = c.AY();
                    if (AY != null) {
                        h gQ = AY.gQ(str);
                        if (gQ != null && gQ.getUsername().equals(str)) {
                            boolean z;
                            if (be.Nh() - (((long) gQ.cyF) * 60) > 86400) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                return;
                            }
                            if (be.kS(gQ.Bf())) {
                                v.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", str);
                            } else if (c.AX() != null) {
                                d.t(str, false);
                                d.t(str, true);
                                this.cxU.gD(str);
                            }
                        }
                    }
                }
            }

            public final String toString() {
                return super.toString() + "|checkAvatarExpire";
            }
        });
    }

    static h gF(String str) {
        h gQ = n.Bo().gQ(str);
        if (gQ != null && gQ.getUsername().equals(str)) {
            return gQ;
        }
        ak.yW();
        ab LX = com.tencent.mm.model.c.wH().LX(str);
        if (LX == null || !LX.field_username.equals(str)) {
            return null;
        }
        if (LX.bBY == 4) {
            b.r(str, LX.bBY);
            return null;
        }
        gQ = new h();
        gQ.username = str;
        gQ.bBY = 3;
        ak.yW();
        byte[] Ma = com.tencent.mm.model.c.wH().Ma(str);
        if (be.bl(Ma)) {
            return gQ;
        }
        h a;
        try {
            a = b.a(str, (ais) new ais().az(Ma));
        } catch (Throwable e) {
            v.e("MicroMsg.AvatarService", "exception:%s", be.e(e));
            a = gQ;
        }
        return a;
    }

    public final void cancel() {
        while (this.cxN.size() > 0) {
            this.cxL.remove(this.cxN.pop());
        }
    }

    final int a(com.tencent.mm.sdk.platformtools.ap.a aVar) {
        if (aVar instanceof a) {
            if (this.cxO == null) {
                this.cxO = new ap(1, "getavatar", 2, ak.vA().htb.getLooper());
            }
            return this.cxO.c(aVar);
        }
        if (this.cxP == null) {
            this.cxP = new ap(1, "readsave", 1, ak.vA().htb.getLooper());
        }
        return this.cxP.c(aVar);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar.getType() == 123) {
            if (!(i == 0 && i2 == 0)) {
                g.iuh.a(138, 12, 1, true);
            }
            j jVar = (j) kVar;
            Set hashSet = new HashSet();
            if (jVar.cyI != null) {
                Iterator it = jVar.cyI.iterator();
                while (it.hasNext()) {
                    acz com_tencent_mm_protocal_c_acz = (acz) it.next();
                    String str2 = com_tencent_mm_protocal_c_acz.mDZ.mQy;
                    if (com_tencent_mm_protocal_c_acz.mbY == null || com_tencent_mm_protocal_c_acz.mbY.mQw == null || com_tencent_mm_protocal_c_acz.mbY.mQw.lVU == null) {
                        g.iuh.a(138, 11, 1, true);
                    } else {
                        hashSet.add(str2);
                        h hVar = new h();
                        hVar.username = str2;
                        hVar.bBY = 3;
                        a(new d(this, hVar, com_tencent_mm_protocal_c_acz.mbY.mQw.lVU));
                    }
                }
            }
            if (jVar.cyH != null) {
                Iterator it2 = jVar.cyH.iterator();
                while (it2.hasNext()) {
                    String str3 = ((arf) it2.next()).mQy;
                    if (!hashSet.contains(str3)) {
                        this.cxL.remove(str3);
                    }
                }
            }
            this.cxK = false;
            if (this.cxN.size() > 0) {
                this.cxS.ea(0);
            }
        }
    }

    static d AX() {
        if (ak.uz()) {
            return n.AX();
        }
        return null;
    }

    public final String gG(String str) {
        if (be.kS(str)) {
            return SQLiteDatabase.KeyEmpty;
        }
        String format;
        try {
            format = String.format("%s%x_%s", new Object[]{"ammURL_", Integer.valueOf(str.hashCode()), str.substring(str.length() - 24, str.length() - 4)});
        } catch (Exception e) {
            format = String.format("%s%x_", new Object[]{"ammURL_", Integer.valueOf(str.hashCode())});
        }
        this.cxR.put(format, str);
        return format;
    }
}
