package com.tencent.mm.as.a;

import com.tencent.smtt.sdk.WebView;

public class a {
    public static final int deA = d.kT("dtse");
    public static final int deB = d.kT("ddts");
    public static final int deC = d.kT("tfdt");
    public static final int deD = d.kT("tfhd");
    public static final int deE = d.kT("trex");
    public static final int deF = d.kT("trun");
    public static final int deG = d.kT("sidx");
    public static final int deH = d.kT("moov");
    public static final int deI = d.kT("mvhd");
    public static final int deJ = d.kT("trak");
    public static final int deK = d.kT("mdia");
    public static final int deL = d.kT("minf");
    public static final int deM = d.kT("stbl");
    public static final int deN = d.kT("avcC");
    public static final int deO = d.kT("hvcC");
    public static final int deP = d.kT("esds");
    public static final int deQ = d.kT("moof");
    public static final int deR = d.kT("traf");
    public static final int deS = d.kT("mvex");
    public static final int deT = d.kT("tkhd");
    public static final int deU = d.kT("edts");
    public static final int deV = d.kT("elst");
    public static final int deW = d.kT("mdhd");
    public static final int deX = d.kT("hdlr");
    public static final int deY = d.kT("stsd");
    public static final int deZ = d.kT("pssh");
    public static final int dej = d.kT("ftyp");
    public static final int dek = d.kT("avc1");
    public static final int del = d.kT("avc3");
    public static final int dem = d.kT("hvc1");
    public static final int den = d.kT("hev1");
    public static final int deo = d.kT("s263");
    public static final int dep = d.kT("d263");
    public static final int deq = d.kT("mdat");
    public static final int der = d.kT("mp4a");
    public static final int des = d.kT("wave");
    public static final int det = d.kT("ac-3");
    public static final int deu = d.kT("dac3");
    public static final int dev = d.kT("ec-3");
    public static final int dew = d.kT("dec3");
    public static final int dex = d.kT("dtsc");
    public static final int dey = d.kT("dtsh");
    public static final int dez = d.kT("dtsl");
    public static final int dfA = d.kT("sawb");
    public static final int dfB = d.kT("udta");
    public static final int dfC = d.kT("meta");
    public static final int dfD = d.kT("ilst");
    public static final int dfE = d.kT("mean");
    public static final int dfF = d.kT("name");
    public static final int dfG = d.kT("data");
    public static final int dfH = d.kT("----");
    public static final int dfa = d.kT("sinf");
    public static final int dfb = d.kT("schm");
    public static final int dfc = d.kT("schi");
    public static final int dfd = d.kT("tenc");
    public static final int dfe = d.kT("encv");
    public static final int dff = d.kT("enca");
    public static final int dfg = d.kT("frma");
    public static final int dfh = d.kT("saiz");
    public static final int dfi = d.kT("saio");
    public static final int dfj = d.kT("uuid");
    public static final int dfk = d.kT("senc");
    public static final int dfl = d.kT("pasp");
    public static final int dfm = d.kT("TTML");
    public static final int dfn = d.kT("vmhd");
    public static final int dfo = d.kT("mp4v");
    public static final int dfp = d.kT("stts");
    public static final int dfq = d.kT("stss");
    public static final int dfr = d.kT("ctts");
    public static final int dfs = d.kT("stsc");
    public static final int dft = d.kT("stsz");
    public static final int dfu = d.kT("stco");
    public static final int dfv = d.kT("co64");
    public static final int dfw = d.kT("tx3g");
    public static final int dfx = d.kT("wvtt");
    public static final int dfy = d.kT("stpp");
    public static final int dfz = d.kT("samr");
    private int dfI;
    private long dfJ;
    public long dfK;
    private int type;

    public a(int i, long j, int i2, long j2) {
        this.dfI = i;
        this.dfK = j;
        this.type = i2;
        this.dfJ = j2;
    }

    public final boolean KG() {
        return this.type == deH;
    }

    public final boolean KH() {
        return this.dfI == 0;
    }

    public final long KI() {
        return this.dfK + getSize();
    }

    public final long getSize() {
        if (this.dfJ > 0) {
            return this.dfJ;
        }
        return (long) this.dfI;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("Atom{atomSize=").append(this.dfI).append(", atomLargeSize=").append(this.dfJ).append(", type=");
        int i = this.type;
        return append.append(new String(new byte[]{(byte) ((i >> 24) & WebView.NORMAL_MODE_ALPHA), (byte) ((i >> 16) & WebView.NORMAL_MODE_ALPHA), (byte) ((i >> 8) & WebView.NORMAL_MODE_ALPHA), (byte) (i & WebView.NORMAL_MODE_ALPHA)})).append(", beginPos=").append(this.dfK).append('}').toString();
    }
}
