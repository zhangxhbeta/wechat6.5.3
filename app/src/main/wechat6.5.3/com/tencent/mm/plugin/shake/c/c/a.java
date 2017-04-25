package com.tencent.mm.plugin.shake.c.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.jsapi.br;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public final class a {
    private static SimpleDateFormat eNn = null;

    public static void aNI() {
        v.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
        if (aNJ()) {
            v.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
            if (!aOe()) {
                v.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
                ak.yW();
                c.vf().a(com.tencent.mm.storage.t.a.noo, Boolean.valueOf(false));
                return;
            }
            return;
        }
        v.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
        if (aOe()) {
            ak.yW();
            c.vf().a(com.tencent.mm.storage.t.a.noo, Boolean.valueOf(true));
            v.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
            return;
        }
        v.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
    }

    public static boolean aNJ() {
        if (ak.uz()) {
            boolean booleanValue;
            ak.yW();
            Object obj = c.vf().get(com.tencent.mm.storage.t.a.noo, Boolean.valueOf(false));
            if (obj != null) {
                booleanValue = ((Boolean) obj).booleanValue();
            } else {
                booleanValue = false;
            }
            return booleanValue;
        }
        v.e("MicroMsg.ShakeCardUtil", "acc is not ready");
        return false;
    }

    private static boolean aOe() {
        ak.yW();
        int intValue = ((Integer) c.vf().get(com.tencent.mm.storage.t.a.nop, Integer.valueOf(0))).intValue();
        ak.yW();
        int intValue2 = ((Integer) c.vf().get(com.tencent.mm.storage.t.a.noq, Integer.valueOf(0))).intValue();
        v.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time : " + intValue + " end time : " + intValue2);
        if (intValue <= 0) {
            v.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is " + intValue + " , invalid");
            return false;
        } else if (intValue2 <= 0) {
            v.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil end time  is " + intValue2 + " , invalid");
            return false;
        } else if (intValue >= intValue2) {
            v.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is >= end time, invalid time");
            return false;
        } else {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            v.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time : " + currentTimeMillis);
            if (currentTimeMillis < intValue || currentTimeMillis > intValue2) {
                v.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is not incled in [btime, etime]");
                return false;
            }
            v.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is incled in [btime, etime]");
            return true;
        }
    }

    public static int aOf() {
        ak.yW();
        return ((Integer) c.vf().get(com.tencent.mm.storage.t.a.nov, Integer.valueOf(0))).intValue();
    }

    public static String aOg() {
        ak.yW();
        return (String) c.vf().get(com.tencent.mm.storage.t.a.nou, "");
    }

    public static String aOh() {
        ak.yW();
        return (String) c.vf().get(com.tencent.mm.storage.t.a.nor, "");
    }

    public static String aOi() {
        ak.yW();
        return (String) c.vf().get(com.tencent.mm.storage.t.a.nox, "");
    }

    public static String aOj() {
        ak.yW();
        return (String) c.vf().get(com.tencent.mm.storage.t.a.now, "");
    }

    public static String aOk() {
        ak.yW();
        return (String) c.vf().get(com.tencent.mm.storage.t.a.noA, "");
    }

    public static String aOl() {
        ak.yW();
        return (String) c.vf().get(com.tencent.mm.storage.t.a.noz, "");
    }

    public static boolean pn(int i) {
        return i >= 0 && i <= 5;
    }

    public static int aOm() {
        ak.yW();
        int currentTimeMillis = (int) (System.currentTimeMillis() % 10);
        int nextInt = (new Random((long) c.ww()).nextInt(10) + currentTimeMillis) % 10;
        v.i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:" + nextInt);
        return nextInt;
    }

    public static int po(int i) {
        switch (i) {
            case 1:
                return 10;
            case 2:
                return 30;
            case 3:
                return 60;
            case 4:
                return 120;
            case 5:
                return 240;
            default:
                return 0;
        }
    }

    public static int pp(int i) {
        switch (i) {
            case 1:
                return 20;
            case 2:
                return 30;
            case 3:
                return 60;
            case 4:
                return 90;
            case 5:
                return 120;
            case 6:
                return br.CTRL_INDEX;
            case 7:
                return 180;
            case 8:
                return 240;
            case 9:
                return 300;
            default:
                return 10;
        }
    }

    public static int qv(String str) {
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            v.e("MicroMsg.ShakeCardUtil", "string format error");
        } else {
            try {
                String toUpperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(255, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
            } catch (Exception e) {
                v.e("MicroMsg.ShakeCardUtil", e.toString());
            }
        }
        return rgb;
    }

    public static String ao(long j) {
        long j2 = 1000 * j;
        new GregorianCalendar().setTimeInMillis(j2);
        if (eNn == null) {
            eNn = new SimpleDateFormat("yyyy.MM.dd");
        }
        return eNn.format(new Date(j2));
    }

    public static void p(Context context, String str, String str2) {
        v.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil doCardDetailUI()");
        Intent intent = new Intent();
        intent.putExtra("key_card_id", str);
        intent.putExtra("key_card_ext", str2);
        intent.putExtra("key_from_scene", 15);
        com.tencent.mm.ay.c.b(context, "card", ".ui.CardDetailUI", intent);
    }

    public static boolean aOn() {
        return aNJ() && u.bsU();
    }

    public static void aNK() {
        v.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i = 86400 + currentTimeMillis;
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.nop, Integer.valueOf(currentTimeMillis));
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.noq, Integer.valueOf(i));
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.nor, "");
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.nov, Integer.valueOf(0));
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.nos, Integer.valueOf(1));
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.not, Integer.valueOf(6));
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.nou, "");
        com.tencent.mm.p.c.us().t(262154, true);
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.now, String.valueOf(currentTimeMillis));
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.nox, "hello");
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.noy, "shake card");
    }

    public static void aNL() {
        v.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.nop, Integer.valueOf(0));
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.noq, Integer.valueOf(0));
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.nor, "");
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.nov, Integer.valueOf(0));
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.nos, Integer.valueOf(0));
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.not, Integer.valueOf(0));
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.nou, "");
        com.tencent.mm.p.c.us().t(262154, false);
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.now, "");
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.nox, "");
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.noy, "");
    }
}
