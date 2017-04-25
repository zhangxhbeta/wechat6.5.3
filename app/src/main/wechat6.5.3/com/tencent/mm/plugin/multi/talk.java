package com.tencent.mm.plugin.multi;

import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;
import com.tencent.wecall.talkroom.model.i;
import java.util.concurrent.atomic.AtomicInteger;

public class talk {
    public static int hyT = 8000;
    public static int hyU = 20;
    public byte[] field_capInfo = null;
    public int field_localImgHeight = 0;
    public int field_localImgWidth = 0;
    public int field_remoteImgChannel = 0;
    public int field_remoteImgHeight = 0;
    public int field_remoteImgLength = 0;
    public int field_remoteImgWidth = 0;

    public interface a {
        void keep_OnError(int i);

        void keep_OnNotify(int i);

        void keep_OnOpenSuccess();

        void keep_OnReportChannel(String str);

        void keep_OnReportEngineRecv(String str, int i);

        void keep_OnReportEngineSend(String str);
    }

    public native int GetAudioData(byte[] bArr, int i, AtomicInteger atomicInteger, AtomicInteger atomicInteger2);

    public native int GetVoiceActivity(int i);

    public native int IsSilenceFrame();

    public native void OnMembersChanged(int[] iArr);

    public native int Open(a aVar, i iVar, int i, int i2, int i3, long j, int[] iArr, short[] sArr, int i4, int[] iArr2, byte[] bArr, boolean z, int i5);

    public native int SendAudio(byte[] bArr, short s, int i);

    public native int SendVideo(byte[] bArr, short s, int i, int i2, int i3, int i4);

    public native int SetCurrentMicId(int i);

    public native int close();

    public native int getChannelBytes(AtomicInteger atomicInteger, AtomicInteger atomicInteger2);

    public native int getSampleRate(AtomicInteger atomicInteger, AtomicInteger atomicInteger2);

    public native int init(int i, int i2, String str);

    public native int onNetworkChange(int i);

    public native int setAppCmd(int i, byte[] bArr, int i2);

    public native int uninit();

    public native int videoDecode(int[] iArr);

    public native int videoTrans(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr);

    static {
        try {
            if (com.tencent.pb.common.a.a.poK && com.tencent.pb.common.a.a.ppb) {
                com.tencent.pb.common.c.a.l("stlport_shared", d.kzS);
                com.tencent.pb.common.c.a.l("wechatxlog", d.kzS);
                com.tencent.pb.common.c.a.l("voipMain", d.kzS);
            }
        } catch (Throwable th) {
            c.i("loadLibrary: ", th);
        }
    }

    public final int nl(int i) {
        return setAppCmd(i, new byte[]{(byte) 5}, 1);
    }

    public final int bV(int i, int i2) {
        byte[] bArr = new byte[]{(byte) 0};
        bArr[0] = (byte) i2;
        return setAppCmd(i, bArr, 1);
    }
}
