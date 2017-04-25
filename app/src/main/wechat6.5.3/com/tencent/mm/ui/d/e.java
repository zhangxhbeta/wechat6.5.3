package com.tencent.mm.ui.d;

import android.content.Context;
import com.tencent.mm.e.a.bj;
import com.tencent.mm.model.a.d;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.au;
import com.tencent.mm.model.av;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class e {

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] nQt = new int[a.bBD().length];

        static {
            try {
                nQt[a.nQv - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                nQt[a.nQw - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                nQt[a.nQx - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                nQt[a.nQy - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                nQt[a.nQz - 1] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                nQt[a.nQA - 1] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                nQt[a.nQB - 1] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                nQt[a.nQC - 1] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                nQt[a.nQu - 1] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                nQt[a.nQD - 1] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                nQt[a.nQE - 1] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                nQt[a.nQF - 1] = 12;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    public enum a {
        ;

        public static int[] bBD() {
            return (int[]) nQG.clone();
        }

        static {
            nQu = 1;
            nQv = 2;
            nQw = 3;
            nQx = 4;
            nQy = 5;
            nQz = 6;
            nQA = 7;
            nQB = 8;
            nQC = 9;
            nQD = 10;
            nQE = 11;
            nQF = 12;
            nQG = new int[]{nQu, nQv, nQw, nQx, nQy, nQz, nQA, nQB, nQC, nQD, nQE, nQF};
        }
    }

    public static com.tencent.mm.pluginsdk.ui.b.a a(Context context, int i, Object[] objArr) {
        boolean z = false;
        String obj;
        String obj2;
        switch (AnonymousClass1.nQt[i - 1]) {
            case 1:
                if (objArr == null || objArr.length != 2) {
                    return null;
                }
                if (objArr[0] != null) {
                    obj = objArr[0].toString();
                } else {
                    obj = null;
                }
                if (objArr[1] != null) {
                    obj2 = objArr[1].toString();
                } else {
                    obj2 = null;
                }
                if (ak.yW().xt().gg(obj) || ak.yW().xt().gg(obj2)) {
                    return new f(context, obj, obj2);
                }
                return null;
            case 2:
                if (objArr == null || objArr.length != 3) {
                    return null;
                }
                String obj3;
                boolean z2;
                obj2 = objArr[0] != null ? objArr[0].toString() : null;
                if (objArr[1] != null) {
                    obj3 = objArr[1].toString();
                } else {
                    obj3 = null;
                }
                if (objArr[2] == null || !(objArr[2] instanceof Boolean)) {
                    z2 = false;
                } else {
                    z2 = ((Boolean) objArr[2]).booleanValue();
                }
                if (ak.yW().xu().gg(obj2) || ak.yW().xu().gg(obj3)) {
                    return new g(context, obj2, obj3, z2);
                }
                return null;
            case 3:
                return new i(context);
            case 4:
                return new l(context);
            case 5:
                return new m(context);
            case 6:
                b bjVar = new bj();
                bjVar.aYQ.context = context;
                com.tencent.mm.sdk.c.a.nhr.z(bjVar);
                return (com.tencent.mm.pluginsdk.ui.b.a) bjVar.aYR.aYS;
            case 7:
                return new h(context);
            case 8:
                return new a(context);
            case 9:
                av.zh();
                au zi = av.zi();
                if (zi != null) {
                    return new j(context, zi);
                }
                return null;
            case 10:
                d ga = f.Aj().ga("4");
                if (ga == null) {
                    return null;
                }
                obj = ga.value;
                if (be.kS(obj) || obj.equals("0")) {
                    return null;
                }
                Object obj4;
                com.tencent.mm.pluginsdk.ui.b.a jVar;
                if (obj.equals("1")) {
                    ak.yW();
                    obj4 = c.vf().get(328195, Boolean.valueOf(false));
                    if (obj4 instanceof Boolean) {
                        z = ((Boolean) obj4).booleanValue();
                    }
                    if (z) {
                        v.i("MicroMsg.BannerManager", "[cpan] banner type bind mobile has clicked.");
                        return null;
                    }
                    av.zh();
                    int zj = av.zj();
                    if (zj == com.tencent.mm.model.av.a.cti || zj == com.tencent.mm.model.av.a.ctj) {
                        v.i("MicroMsg.BannerManager", "already Bind the Mobile");
                        return null;
                    }
                    jVar = new j(context, new au(1, 1, SQLiteDatabase.KeyEmpty));
                    com.tencent.mm.model.a.e.ge("4");
                    return jVar;
                } else if (!obj.equals("2")) {
                    return null;
                } else {
                    ak.yW();
                    obj4 = c.vf().get(328196, Boolean.valueOf(false));
                    if (obj4 instanceof Boolean) {
                        z = ((Boolean) obj4).booleanValue();
                    }
                    if (z) {
                        v.i("MicroMsg.BannerManager", "[cpan] banner type upload contact has clicked.");
                        return null;
                    }
                    av.zh();
                    if (av.zj() == com.tencent.mm.model.av.a.cti) {
                        v.i("MicroMsg.BannerManager", "already upload the Mobile");
                        return null;
                    }
                    jVar = new j(context, new au(2, 1, SQLiteDatabase.KeyEmpty));
                    com.tencent.mm.model.a.e.ge("4");
                    return jVar;
                }
            case 11:
                return new k(context);
            case 12:
                return new n(context);
            default:
                return null;
        }
    }
}
