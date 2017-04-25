package com.tencent.mm.pluginsdk.n;

public final class a {
    public static int lFo = 480;
    public static int lFp = 640;
    public int cdg;
    public int cdi;
    public int dhK;
    public String lFA;
    public String lFB;
    public int lFC;
    public int lFD;
    public int lFq;
    public int lFr;
    public int lFs;
    public int lFt;
    public int lFu;
    public int lFv;
    public int lFw;
    public String lFx;
    public String lFy;
    public String lFz;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fps=").append(this.cdg).append('\n');
        stringBuilder.append("width=").append(this.lFr).append('\n');
        stringBuilder.append("height=").append(this.lFq).append('\n');
        stringBuilder.append("bitrate=").append(this.lFs).append('\n');
        stringBuilder.append("rotate=").append(this.cdi).append('\n');
        stringBuilder.append("yuvWidth=").append(this.lFu).append('\n');
        stringBuilder.append("yuvHeight=").append(this.lFt).append('\n');
        stringBuilder.append("x264Speed=").append(this.lFv).append('\n');
        stringBuilder.append("x264Quality=").append(this.lFw).append('\n');
        stringBuilder.append("yuvFile=").append(this.lFx).append('\n');
        stringBuilder.append("pcmFile=").append(this.lFy).append('\n');
        stringBuilder.append("thuFile=").append(this.lFz).append('\n');
        stringBuilder.append("x264File=").append(this.lFA).append('\n');
        stringBuilder.append("mp4File=").append(this.lFB).append('\n');
        stringBuilder.append("videoFrameCnt=").append(this.lFC).append('\n');
        stringBuilder.append("videoLength=").append(this.dhK).append('\n');
        stringBuilder.append("cameraCount=").append(this.lFD).append('\n');
        return stringBuilder.toString();
    }

    public static a boo() {
        a aVar = new a();
        aVar.cdg = 30;
        aVar.cdi = 0;
        aVar.lFt = 640;
        aVar.lFu = 480;
        aVar.lFq = 640;
        aVar.lFr = 480;
        aVar.lFs = 1440000;
        aVar.lFv = 1;
        aVar.lFw = 4;
        aVar.lFx = "/sdcard/1.yuv";
        aVar.lFB = "/sdcard/1.mp4";
        aVar.lFy = "/sdcard/1.pcm";
        aVar.lFA = "/sdcard/1.x264";
        aVar.lFC = 0;
        aVar.dhK = 0;
        aVar.lFD = 0;
        return aVar;
    }

    public static a bop() {
        a aVar = new a();
        aVar.cdg = 30;
        aVar.cdi = 0;
        aVar.lFt = lFp;
        aVar.lFu = lFo;
        aVar.lFq = lFp;
        aVar.lFr = lFo;
        aVar.lFs = 327680;
        aVar.lFv = 4;
        aVar.lFw = 1;
        aVar.lFx = "/sdcard/2.yuv";
        aVar.lFB = "/sdcard/2.mp4";
        aVar.lFy = "/sdcard/2.pcm";
        aVar.lFA = "/sdcard/2.x264";
        aVar.lFC = 0;
        aVar.dhK = 0;
        aVar.lFD = 0;
        return aVar;
    }

    public static a boq() {
        a aVar = new a();
        aVar.cdg = 30;
        aVar.cdi = 0;
        aVar.lFt = lFp;
        aVar.lFu = lFo;
        aVar.lFq = lFp;
        aVar.lFr = lFo;
        aVar.lFs = 327680;
        aVar.lFv = 4;
        aVar.lFw = 1;
        aVar.lFx = "/sdcard/2.yuv";
        aVar.lFB = "/sdcard/2.mp4";
        aVar.lFy = "/sdcard/2.pcm";
        aVar.lFA = "/sdcard/2.x264";
        aVar.lFC = 0;
        aVar.dhK = 0;
        aVar.lFD = 0;
        return aVar;
    }
}
