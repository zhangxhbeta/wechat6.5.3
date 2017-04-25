package com.tencent.mm.at.a;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Locale;

public class c {
    public static final String TAG = c.class.getSimpleName();
    public static SharedPreferences cnm = aa.btk();
    public boolean dkT;
    public int dkU;
    public boolean dkV;
    public boolean dkW;
    public long dkX;
    public int dkY;
    public boolean dkZ;
    public a dla;
    public com.qq.wx.voice.vad.a dlb;
    public a dlc;
    public short[] dld;
    public ac handler;

    public interface a {
        void LO();

        void LP();

        void LQ();

        void a(short[] sArr, int i);
    }

    public static String LV() {
        return String.format(Locale.CHINA, "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s", new Object[]{"sil_time", Integer.valueOf(cnm.getInt("sil_time", 500)), "s_n_ration", Float.valueOf(cnm.getFloat("s_n_ration", 2.5f)), "s_window", Integer.valueOf(cnm.getInt("s_window", 500)), "s_length", Integer.valueOf(cnm.getInt("s_length", 350)), "s_delay_time", Integer.valueOf(cnm.getInt("s_delay_time", 550))});
    }

    public c() {
        this(3500, 16000, cnm.getInt("sil_time", 1000), cnm.getFloat("s_n_ration", 2.5f), cnm.getInt("s_window", 500), cnm.getInt("s_length", 350), cnm.getInt("s_delay_time", 550), true, true);
    }

    private c(int i, int i2, int i3, float f, int i4, int i5, int i6, boolean z, boolean z2) {
        this.dkT = true;
        this.dkU = 3;
        this.dkV = false;
        this.dkW = false;
        this.dkX = 0;
        this.dkY = 3500;
        this.dkZ = false;
        this.handler = new ac(this, Looper.getMainLooper()) {
            final /* synthetic */ c dle;

            public final void handleMessage(Message message) {
                if (message.what == 0 && this.dle.dlc != null) {
                    this.dle.dlc.LQ();
                }
            }
        };
        this.dla = null;
        this.dlb = null;
        this.dkY = 3500;
        this.dlb = new com.qq.wx.voice.vad.a();
        com.qq.wx.voice.vad.a aVar = this.dlb;
        aVar.aHg = aVar.aHh.Init(16000, i3, f, i4, i5);
        if (com.qq.wx.voice.vad.a.DEBUG) {
            System.out.println("EVad Init handle = " + aVar.aHg);
        }
        if ((aVar.aHg == 0 ? 1 : 0) != 1) {
            int i7;
            com.qq.wx.voice.vad.a aVar2 = this.dlb;
            if (aVar2.aHg == 0) {
                i7 = 1;
            } else {
                if (com.qq.wx.voice.vad.a.DEBUG) {
                    System.out.println("EVad Reset handle = " + aVar2.aHg);
                }
                i7 = aVar2.aHh.Reset(aVar2.aHg);
            }
            if (i7 != 1) {
                this.dla = new a(i6 * 16);
                this.dld = new short[4000];
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, 3500);
                this.dkV = true;
                this.dkW = true;
                return;
            }
        }
        throw new b("Init ERROR");
    }
}
