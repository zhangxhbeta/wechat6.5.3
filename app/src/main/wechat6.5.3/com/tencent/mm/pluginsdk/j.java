package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.e.a.jm;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.protocal.c.azi;
import com.tencent.mm.protocal.c.zv;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.storage.at;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Deprecated
public interface j {

    public static class a {
        public static w lxG;
        public static x lxH;
        public static j lxI;
        public static t lxJ;
        public static f lxK;
        public static o lxL;
        public static d lxM;
        public static r lxN;
        public static n lxO;
        public static aa lxP;
        public static ac lxQ;
        public static l lxR;
        public static z lxS;
        public static e lxT;
        public static ag lxU;
        public static m lxV;
        public static c lxW;
        public static g lxX;
        public static b lxY;
        public static i lxZ;

        public static o bmq() {
            if (lxL == null) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
                lxL = new com.tencent.mm.pluginsdk.b.d();
            }
            return lxL;
        }

        public static f bmr() {
            if (lxK == null) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.IPluginEvent.Factory", "get emoji mgr is null, new default");
                lxK = new com.tencent.mm.pluginsdk.b.b();
            }
            return lxK;
        }

        public static r bms() {
            return lxN;
        }

        public static n bmt() {
            if (lxO == null) {
                lxO = new com.tencent.mm.pluginsdk.b.c();
            }
            return lxO;
        }

        public static e bmu() {
            if (lxT == null) {
                lxT = new com.tencent.mm.pluginsdk.b.a();
            }
            return lxT;
        }
    }

    public interface aa {
        String awp();
    }

    public interface ab {
        void Gj(String str);
    }

    public interface ac {
        void a(ab abVar);

        void a(String str, LinkedList<String> linkedList, double d, double d2, String str2, String str3, String str4);

        boolean awy();

        String awz();

        void b(ab abVar);

        boolean bY(String str, String str2);

        LinkedList<String> vH(String str);

        boolean vJ(String str);
    }

    public interface ad {
        void update(int i);
    }

    public interface ae {
        int bmx();

        String[] bmy();

        zv bmz();
    }

    public interface af {
        ad a(Context context, OnCancelListener onCancelListener);

        void aKN();

        ae aKO();

        ad b(Context context, OnCancelListener onCancelListener);

        void c(String str, int i, String str2, String str3);

        ad cs(Context context);

        void ct(Context context);

        void fg(boolean z);

        void o(Context context, Intent intent);

        String yO(String str);
    }

    public interface ag {
        boolean a(Context context, String str, boolean z);

        boolean a(Context context, String str, boolean z, Bundle bundle);

        boolean a(Context context, String str, boolean z, m mVar);

        boolean b(Context context, String str, boolean z, m mVar);

        boolean b(Context context, String str, Object... objArr);
    }

    public interface ah {

        public interface a {
            String bhJ();

            void bhK();

            boolean bhL();
        }
    }

    public static class ai {
        private static af lya;
        public static boolean lyb = false;

        public static void a(af afVar) {
            lya = afVar;
        }

        public static af bmA() {
            return lya;
        }
    }

    public static class aj {
        public static u lyc;
    }

    public static class ak {
        public static h lyd;
        public static c lye;
        public static b lyf;
        public static a lyg;
        public static g lyh;
        public static f lyi;
        public static e lyj;
        public static d lyk;

        public static d bmB() {
            return lyk;
        }
    }

    public static class al {
        public static s lyl;
    }

    public static class am {
        public static a lym;

        public static a bmC() {
            return lym;
        }
    }

    public interface b {
        String iD(String str);

        String iE(String str);
    }

    public interface c {
        boolean a(Context context, com.tencent.mm.pluginsdk.ui.applet.h hVar, com.tencent.mm.pluginsdk.ui.d.b bVar);

        com.tencent.mm.pluginsdk.ui.applet.h r(Context context, String str);
    }

    public interface d {
        boolean ZV();

        boolean ZW();

        String ZX();

        int ZY();

        boolean iT(int i);
    }

    public interface e {
        void a(com.tencent.mm.sdk.h.g.a aVar);

        String aC(List<String> list);

        void aD(List<String> list);

        void avF();

        List<String> avG();

        List<String> avI();

        void b(com.tencent.mm.sdk.h.g.a aVar);

        void bV(String str, String str2);

        void e(List<String> list, List<String> list2);

        String vu(String str);

        String vv(String str);

        List<String> vw(String str);

        List<String> vx(String str);

        List<String> vy(String str);
    }

    public interface f {
        com.tencent.mm.storage.a.c a(String str, String str2, int i, int i2, int i3, String str3, String str4, String str5);

        String a(Context context, WXMediaMessage wXMediaMessage, String str);

        String a(com.tencent.mm.storage.c cVar, String str);

        void a(Context context, at atVar);

        void a(String str, com.tencent.mm.storage.a.c cVar, at atVar);

        boolean a(Context context, com.tencent.mm.storage.a.c cVar, int i, String str);

        boolean a(String str, String str2, long j, String str3, com.tencent.mm.v.d.a aVar);

        boolean aeZ();

        boolean afa();

        ArrayList<com.tencent.mm.storage.a.s> afb();

        ArrayList<String> afc();

        ArrayList<com.tencent.mm.storage.a.u> afd();

        com.tencent.mm.al.f afe();

        com.tencent.mm.storage.ai bn(String str, String str2);

        String bo(String str, String str2);

        com.tencent.mm.storage.a.c c(com.tencent.mm.storage.a.c cVar);

        void d(com.tencent.mm.storage.a.c cVar);

        int e(com.tencent.mm.storage.a.c cVar);

        int[] f(com.tencent.mm.storage.a.c cVar);

        byte[] g(com.tencent.mm.storage.a.c cVar);

        boolean l(Context context, String str, String str2);

        com.tencent.mm.storage.c rd(String str);

        com.tencent.mm.storage.a.c rg(String str);

        String rh(String str);

        boolean ri(String str);

        List<com.tencent.mm.storage.a.c> rj(String str);

        String rk(String str);

        boolean rl(String str);

        ArrayList<String> rm(String str);

        String rn(String str);

        String ro(String str);

        int rp(String str);

        String rq(String str);

        void rr(String str);

        boolean t(ArrayList<com.tencent.mm.storage.a.s> arrayList);

        boolean u(ArrayList<com.tencent.mm.storage.a.u> arrayList);
    }

    public interface g {
        int a(com.tencent.mm.pluginsdk.wallet.b bVar, int i, boolean z);

        void a(jm jmVar, int i);

        void a(jm jmVar, int i, String str);

        boolean a(boolean z, boolean z2, Bundle bundle);

        void anA();

        Map<String, String> anB();

        com.tencent.mm.pluginsdk.wallet.h anC();

        Map<String, String> anD();

        boolean anE();

        boolean anm();

        boolean ann();

        boolean ano();

        void anq();

        com.tencent.mm.pluginsdk.wallet.g ans();

        boolean ant();

        boolean anu();

        void anv();

        boolean anw();

        boolean anx();

        void any();

        void anz();

        void bI(Context context);

        void bK(Context context);
    }

    public interface h {
        boolean Iz();

        boolean aZc();

        String aZd();

        String aZe();

        boolean aZf();

        String aZg();

        String aZh();
    }

    public interface i {
        boolean a(PayInfo payInfo);

        void ah(Context context, String str);

        boolean axT();

        boolean axU();

        boolean axV();

        boolean axW();
    }

    public interface j {
        void a(Context context, boolean z);

        void ai(Context context);

        boolean oO();
    }

    public interface k {
        void Gg(String str);
    }

    public interface l {
        com.tencent.mm.ah.b Rk(String str);

        void a(k kVar);

        boolean aCc();

        boolean aCe();

        int aCs();

        boolean aCt();

        boolean aCu();

        void b(k kVar);

        boolean bj(Context context);

        boolean ce(String str, String str2);

        String cf(String str, String str2);

        int cg(String str, String str2);

        String er(String str);

        boolean hc(String str);

        void wG(String str);

        boolean wH(String str);

        boolean wI(String str);

        List<String> wJ(String str);

        boolean wK(String str);

        boolean wL(String str);

        void wM(String str);

        boolean wN(String str);

        boolean wO(String str);

        void wP(String str);
    }

    public interface m {
        boolean a(Context context, String str, OnDismissListener onDismissListener);

        boolean bv(String str);

        String q(Context context, String str);
    }

    public interface n {
        void a(Context context, String str, String str2, int i, String str3, String str4);

        void a(Context context, String str, String str2, String str3, int i, int i2, ayk com_tencent_mm_protocal_c_ayk, boolean z, boolean z2, String str4);

        void a(Context context, String str, String str2, String str3, int i, int i2, String str4);

        void a(String str, byte[] bArr, String str2, String str3);

        void df(String str, String str2);

        void m(String str, String str2, boolean z);

        void x(String str, String str2, int i);
    }

    public interface o {
        int aNH();

        void aNI();

        boolean aNJ();

        void aNK();

        void aNL();

        boolean aNM();

        String zq(String str);
    }

    public interface p {
        void onDestroy();

        void show();
    }

    public interface q {

        public interface a {
            int Kw();
        }

        public interface b {
            axg Bv(String str);

            boolean a(String str, axg com_tencent_mm_protocal_c_axg);

            void aUB();

            void aUC();

            boolean am(String str, boolean z);

            axg an(String str, boolean z);

            axg b(String str, axg com_tencent_mm_protocal_c_axg);
        }

        public interface c {
            void M(Activity activity);

            void aRT();

            void b(aib com_tencent_mm_protocal_c_aib, View view, int i, com.tencent.mm.storage.ak akVar);

            void c(aib com_tencent_mm_protocal_c_aib, View view, int i, com.tencent.mm.storage.ak akVar);

            void ca(View view);

            void pause();

            Bitmap r(aib com_tencent_mm_protocal_c_aib);

            String s(aib com_tencent_mm_protocal_c_aib);

            void start();
        }

        public interface d {
            Cursor BD(String str);

            ArrayList<Long> aVa();

            void dc(long j);

            boolean qF(int i);
        }

        public interface e {

            public interface a {
                void a(boolean z, boolean z2, String str, boolean z3);

                void b(boolean z, String str, boolean z2);
            }

            void Az(String str);

            void a(int i, String str, a aVar);

            boolean a(a aVar, int i);

            void b(int i, String str, boolean z, int i2);

            Intent e(Intent intent, String str);
        }

        public interface f {
            void a(com.tencent.mm.model.ae aeVar);

            void b(com.tencent.mm.model.ae aeVar);
        }

        public interface g {
            boolean aVj();

            List<String> dg(long j);

            String dh(long j);

            boolean z(String str, long j);
        }

        public interface h {
            boolean a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i);

            void aTe();

            boolean cD(String str, String str2);
        }
    }

    public interface r {
        void F(String str, String str2, String str3);

        void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, long j, String str5);

        void a(Context context, String str, String str2, String str3, int i, String str4, int i2);

        void a(String str, String str2, int i, int i2, String str3, int i3);

        void a(String str, String str2, int i, int i2, String str3, long j);

        boolean bY(Context context);

        void bZ(Context context);

        void m(Context context, String str, String str2);

        void z(String str, int i, int i2);
    }

    public interface s {
        boolean aZj();

        boolean aZk();

        void aZl();

        void aZm();

        void aZp();

        String aZr();

        h aZs();
    }

    public interface t {
        com.tencent.mm.pluginsdk.model.app.f Gh(String str);

        void Gi(String str);

        Bitmap a(String str, int i, float f);

        void ae(LinkedList<String> linkedList);

        com.tencent.mm.pluginsdk.model.app.i bmv();

        Cursor bmw();

        void bv(String str, int i);

        Cursor cQ(int i, int i2);

        void e(com.tencent.mm.pluginsdk.model.app.f fVar);

        void f(com.tencent.mm.pluginsdk.model.app.f fVar);

        void g(com.tencent.mm.pluginsdk.model.app.f fVar);

        Cursor o(int[] iArr);

        Cursor tq(int i);
    }

    public interface u {
        p ap(Context context, String str);
    }

    public interface v {
        void y(String str, String str2, String str3);
    }

    public interface w {
        boolean CB(String str);

        LinkedList<azi> CC(String str);

        void a(v vVar);

        void a(String str, LinkedList<azi> linkedList, String str2, String str3, int i);

        void b(v vVar);

        boolean bad();
    }

    public interface x {
        void a(y yVar);

        void aZS();

        void b(y yVar);

        boolean baj();

        void bak();

        short bap();

        short baq();

        boolean bar();

        void bd(String str, int i);
    }

    public interface y {
        void A(String str, int i, int i2);

        void awP();

        void awQ();

        void awR();

        void awS();

        void awT();

        void awU();

        void bZ(String str, String str2);

        void g(int i, int i2, String str);

        void mq(int i);

        void vT(String str);
    }

    public interface z {
        void n(String str, Bitmap bitmap);

        Bitmap vF(String str);
    }
}
