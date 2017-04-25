package com.tencent.mm.plugin.music.a.a;

import android.widget.Toast;
import com.tencent.mm.network.t;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.a.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public final class a implements Runnable {
    public com.tencent.mm.ai.a big;
    public boolean eUv = true;
    public boolean fMm;
    public float hDl;
    private long hDm = 307200;
    public b hDn;

    private class a implements Runnable {
        int action;
        final /* synthetic */ a hDo;

        public final void run() {
            if (this.hDo.hDn != null) {
                this.hDo.hDn.nu(this.action);
            }
        }

        a(a aVar, int i) {
            this.hDo = aVar;
            this.action = i;
        }
    }

    public interface b {
        void nu(int i);
    }

    public a(com.tencent.mm.ai.a aVar) {
        this.big = aVar;
        this.fMm = ak.isWifi(aa.getContext());
    }

    public final void start() {
        if (this.eUv) {
            this.eUv = false;
            e.a(this, "music_download_thread");
        }
    }

    public final void run() {
        long j;
        long j2;
        RandomAccessFile randomAccessFile;
        InputStream inputStream;
        t tVar;
        RandomAccessFile randomAccessFile2;
        Throwable th;
        if (!this.eUv) {
            if (ak.isNetworkConnected(aa.getContext())) {
                long j3;
                long j4;
                boolean z;
                String str;
                Object obj;
                PBool pBool;
                String str2;
                String a;
                long j5;
                if (this.fMm) {
                    Object obj2;
                    pBool = new PBool();
                    if (be.kS(this.big.field_songWifiUrl)) {
                        str2 = this.big.field_songWebUrl;
                    } else {
                        str2 = this.big.field_songWifiUrl;
                    }
                    a = h.a(str2, this.big.field_songWapLinkUrl, true, pBool);
                    boolean z2 = pBool.value;
                    j3 = this.big.field_wifiDownloadedLength;
                    j = this.big.field_songWifiFileLength;
                    if (j != 0) {
                        this.hDm = j / 4;
                    }
                    if (j3 < this.hDm) {
                        j4 = this.hDm;
                    } else {
                        j4 = (long) (((float) j3) + (0.15f * ((float) this.big.field_songWifiFileLength)));
                    }
                    if (this.big.field_wifiEndFlag == 1) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    j5 = j;
                    j = j3;
                    z = z2;
                    str = a;
                    obj = obj2;
                    j2 = j5;
                } else {
                    pBool = new PBool();
                    if (be.kS(this.big.field_songWifiUrl)) {
                        str2 = this.big.field_songWebUrl;
                    } else {
                        str2 = this.big.field_songWifiUrl;
                    }
                    a = h.a(str2, this.big.field_songWapLinkUrl, false, pBool);
                    j3 = this.big.field_downloadedLength;
                    j = this.big.field_songFileLength;
                    if (j != 0) {
                        this.hDm = j / 4;
                    }
                    if (j3 < this.hDm) {
                        j4 = this.hDm;
                    } else {
                        j4 = (long) (((float) j3) + (0.15f * ((float) this.big.field_songFileLength)));
                    }
                    j5 = j;
                    j = j3;
                    z = false;
                    str = a;
                    obj = this.big.field_endFlag == 1 ? 1 : null;
                    j2 = j5;
                }
                if (this.hDm < 256000) {
                    this.hDm = 256000;
                    v.i("MicroMsg.Music.MusicDownloadTask", "music firstTimeDownloadSize is less than startPlayLength, update firstTimeDownloadSize");
                }
                File file = new File(h.d(this.big, this.fMm));
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                    }
                    j = 0;
                    j4 = this.hDm;
                    obj = null;
                    v.i("MicroMsg.Music.MusicDownloadTask", "music file delete and create again %d", new Object[]{Long.valueOf(j4)});
                }
                v.i("MicroMsg.Music.MusicDownloadTask", "downloadLength=%d musicFile.Length=%d endRange=%d", new Object[]{Long.valueOf(j), Long.valueOf(file.length()), Long.valueOf(j4)});
                if ((j >= this.hDm && this.hDl == 0.0f) || r10 != null) {
                    v.i("MicroMsg.Music.MusicDownloadTask", "can start play");
                    this.eUv = true;
                    ad.o(new a(this, 1));
                } else if (be.kS(str)) {
                    this.eUv = true;
                    ad.o(new a(this, -2));
                } else {
                    InputStream inputStream2 = null;
                    t a2;
                    try {
                        randomAccessFile = new RandomAccessFile(file, "rws");
                        try {
                            v.i("MicroMsg.Music.MusicDownloadTask", "create connection %s", new Object[]{str});
                            a2 = com.tencent.mm.network.b.a(str, null);
                            try {
                                a2.setRequestMethod("GET");
                                a2.setConnectTimeout(25000);
                                a2.setRequestProperty("Accept-Encoding", "gzip, deflate");
                                if (j4 > j) {
                                    v.d("MicroMsg.Music.MusicDownloadTask", "range : %d-%d", new Object[]{Long.valueOf(j), Long.valueOf(j4)});
                                    a2.setRequestProperty("range", "bytes=" + j + "-" + j4);
                                }
                                if (z || h.wY(str)) {
                                    v.d("MicroMsg.Music.MusicDownloadTask", "set cookie");
                                    a2.setRequestProperty("Cookie", "qqmusic_fromtag=97;qqmusic_uin=1234567;qqmusic_key=;");
                                    a2.setRequestProperty("referer", "stream12.qqmusic.qq.com");
                                }
                                a2.setRequestProperty("user-agent", System.getProperty("http.agent") + " Built-in music  MicroMessenger/" + h.ck(aa.getContext()));
                                if (a2.getResponseCode() == 200 || a2.getResponseCode() == 206) {
                                    v.d("MicroMsg.Music.MusicDownloadTask", "user-agent: " + a2.dmc.getRequestProperty("user-agent"));
                                    long[] xc = xc(a2.getHeaderField("Content-Range"));
                                    v.i("MicroMsg.Music.MusicDownloadTask", "content-range: %s contentLen=%d", new Object[]{r8, Long.valueOf(be.getLong(a2.getHeaderField("Content-Length"), 0))});
                                    if (xc == null) {
                                        v.i("MicroMsg.Music.MusicDownloadTask", "not support range feature");
                                        if (j != 0) {
                                            j = 0;
                                        }
                                        j2 = j4;
                                    } else {
                                        if (j > 0) {
                                            if (j != xc[0]) {
                                                v.e("MicroMsg.Music.MusicDownloadTask", "return http error, need to download again");
                                                nv(-1);
                                                if (j2 == 0 && j > 0) {
                                                    v.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                                    try {
                                                        randomAccessFile.setLength(j);
                                                    } catch (IOException e2) {
                                                    }
                                                    ck(j);
                                                    if (j < 256000) {
                                                        ad.o(new a(this, 1));
                                                    }
                                                } else if (j2 != 0 && j != j2) {
                                                    v.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                                    l(j, j2);
                                                } else if (j2 == 0 || j != j2) {
                                                    v.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                                } else {
                                                    v.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                                    ck(j2);
                                                    if (j < 256000) {
                                                        ad.o(new a(this, 1));
                                                    }
                                                }
                                                try {
                                                    randomAccessFile.close();
                                                } catch (IOException e3) {
                                                }
                                                a2.dmc.disconnect();
                                                this.eUv = true;
                                                v.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                                return;
                                            }
                                        }
                                        j2 = xc[2];
                                    }
                                    if (j2 != 0) {
                                        j3 = j2;
                                    } else {
                                        j3 = 10000000;
                                    }
                                    v.i("MicroMsg.Music.MusicDownloadTask", "fileLen=%d downloadLength=%d", new Object[]{Long.valueOf(j3), Long.valueOf(j)});
                                    randomAccessFile.setLength(j3);
                                    randomAccessFile.seek(j);
                                    InputStream inputStream3 = a2.getInputStream();
                                    try {
                                        byte[] bArr = new byte[4096];
                                        while (!this.eUv) {
                                            int read = inputStream3.read(bArr);
                                            if (read <= 0) {
                                                break;
                                            }
                                            randomAccessFile.write(bArr, 0, read);
                                            j += (long) read;
                                            v.v("MicroMsg.Music.MusicDownloadTask", "update updateCurrentDownloadLength %d %d", new Object[]{Long.valueOf(j), Long.valueOf(j3)});
                                            if (this.fMm) {
                                                this.big.field_wifiDownloadedLength = j;
                                                this.big.field_songWifiFileLength = j3;
                                            } else {
                                                this.big.field_downloadedLength = j;
                                                this.big.field_songFileLength = j3;
                                            }
                                            if (j >= 256000) {
                                                ad.o(new a(this, 1));
                                            }
                                        }
                                        if (j2 == 0 && j > 0) {
                                            v.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                            try {
                                                randomAccessFile.setLength(j);
                                            } catch (IOException e4) {
                                            }
                                            ck(j);
                                            if (j < 256000) {
                                                ad.o(new a(this, 1));
                                            }
                                        } else if (j2 != 0 && j != j2) {
                                            v.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                            l(j, j2);
                                        } else if (j2 == 0 || j != j2) {
                                            v.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                        } else {
                                            v.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                            ck(j2);
                                            if (j < 256000) {
                                                ad.o(new a(this, 1));
                                            }
                                        }
                                        if (inputStream3 != null) {
                                            try {
                                                inputStream3.close();
                                            } catch (IOException e5) {
                                            }
                                        }
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException e6) {
                                        }
                                        a2.dmc.disconnect();
                                        this.eUv = true;
                                        v.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                    } catch (Exception e7) {
                                        inputStream = inputStream3;
                                        tVar = a2;
                                        randomAccessFile2 = randomAccessFile;
                                    } catch (Throwable th2) {
                                        inputStream2 = inputStream3;
                                        th = th2;
                                    }
                                } else {
                                    v.e("MicroMsg.Music.MusicDownloadTask", "wifi music http req error " + a2.getResponseCode());
                                    ad.o(new Runnable(this) {
                                        final /* synthetic */ a hDo;

                                        {
                                            this.hDo = r1;
                                        }

                                        public final void run() {
                                            Toast.makeText(aa.getContext(), aa.getContext().getString(2131233971), 1).show();
                                        }
                                    });
                                    nv(-1);
                                    if (j2 == 0 && j > 0) {
                                        v.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                        try {
                                            randomAccessFile.setLength(j);
                                        } catch (IOException e8) {
                                        }
                                        ck(j);
                                        if (j < 256000) {
                                            ad.o(new a(this, 1));
                                        }
                                    } else if (j2 != 0 && j != j2) {
                                        v.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                        l(j, j2);
                                    } else if (j2 == 0 || j != j2) {
                                        v.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                    } else {
                                        v.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                        ck(j2);
                                        if (j < 256000) {
                                            ad.o(new a(this, 1));
                                        }
                                    }
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException e9) {
                                    }
                                    a2.dmc.disconnect();
                                    this.eUv = true;
                                    v.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                }
                            } catch (Exception e10) {
                                randomAccessFile2 = randomAccessFile;
                                inputStream = null;
                                tVar = a2;
                                try {
                                    nv(-2);
                                    if (j2 != 0 && j > 0) {
                                        v.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                        try {
                                            randomAccessFile2.setLength(j);
                                        } catch (IOException e11) {
                                        }
                                        ck(j);
                                        if (j < 256000) {
                                            ad.o(new a(this, 1));
                                        }
                                    } else if (j2 == 0 && j != j2) {
                                        v.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                        l(j, j2);
                                    } else if (j2 == 0 && j == j2) {
                                        v.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                        ck(j2);
                                        if (j < 256000) {
                                            ad.o(new a(this, 1));
                                        }
                                    } else {
                                        v.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e12) {
                                        }
                                    }
                                    if (randomAccessFile2 != null) {
                                        try {
                                            randomAccessFile2.close();
                                        } catch (IOException e13) {
                                        }
                                    }
                                    if (tVar != null) {
                                        tVar.dmc.disconnect();
                                    }
                                    this.eUv = true;
                                    v.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                } catch (Throwable th3) {
                                    randomAccessFile = randomAccessFile2;
                                    inputStream2 = inputStream;
                                    a2 = tVar;
                                    th = th3;
                                    if (j2 != 0) {
                                    }
                                    if (j2 == 0) {
                                    }
                                    if (j2 == 0) {
                                    }
                                    v.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e14) {
                                        }
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException e15) {
                                        }
                                    }
                                    if (a2 != null) {
                                        a2.dmc.disconnect();
                                    }
                                    this.eUv = true;
                                    v.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                if (j2 != 0 && j > 0) {
                                    v.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                    try {
                                        randomAccessFile.setLength(j);
                                    } catch (IOException e16) {
                                    }
                                    ck(j);
                                    if (j < 256000) {
                                        ad.o(new a(this, 1));
                                    }
                                } else if (j2 == 0 && j != j2) {
                                    v.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                    l(j, j2);
                                } else if (j2 == 0 && j == j2) {
                                    v.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                    ck(j2);
                                    if (j < 256000) {
                                        ad.o(new a(this, 1));
                                    }
                                } else {
                                    v.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                if (a2 != null) {
                                    a2.dmc.disconnect();
                                }
                                this.eUv = true;
                                v.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                throw th;
                            }
                        } catch (Exception e17) {
                            randomAccessFile2 = randomAccessFile;
                            inputStream = null;
                            tVar = null;
                            nv(-2);
                            if (j2 != 0) {
                            }
                            if (j2 == 0) {
                            }
                            if (j2 == 0) {
                            }
                            v.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            if (tVar != null) {
                                tVar.dmc.disconnect();
                            }
                            this.eUv = true;
                            v.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                        } catch (Throwable th5) {
                            th = th5;
                            a2 = null;
                            if (j2 != 0) {
                            }
                            if (j2 == 0) {
                            }
                            if (j2 == 0) {
                            }
                            v.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            if (a2 != null) {
                                a2.dmc.disconnect();
                            }
                            this.eUv = true;
                            v.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                            throw th;
                        }
                    } catch (Exception e18) {
                        randomAccessFile2 = null;
                        inputStream = null;
                        tVar = null;
                        nv(-2);
                        if (j2 != 0) {
                        }
                        if (j2 == 0) {
                        }
                        if (j2 == 0) {
                        }
                        v.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        if (tVar != null) {
                            tVar.dmc.disconnect();
                        }
                        this.eUv = true;
                        v.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    } catch (Throwable th6) {
                        th = th6;
                        randomAccessFile = null;
                        a2 = null;
                        if (j2 != 0) {
                        }
                        if (j2 == 0) {
                        }
                        if (j2 == 0) {
                        }
                        v.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (a2 != null) {
                            a2.dmc.disconnect();
                        }
                        this.eUv = true;
                        v.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                        throw th;
                    }
                }
            } else if (this.big.field_wifiDownloadedLength != 0 && this.big.field_wifiDownloadedLength >= this.hDm && (((float) this.big.field_wifiDownloadedLength) / ((float) this.big.field_songWifiFileLength)) - this.hDl >= 0.15f) {
                v.i("MicroMsg.Music.MusicDownloadTask", "can start play");
                this.eUv = true;
                this.fMm = true;
                ad.o(new a(this, 1));
            } else if (this.big.field_downloadedLength == 0 || this.big.field_downloadedLength < this.hDm || (((float) this.big.field_downloadedLength) / ((float) this.big.field_songFileLength)) - this.hDl < 0.15f) {
                v.i("MicroMsg.Music.MusicDownloadTask", "not connect network");
                this.eUv = true;
                nv(4);
            } else {
                v.i("MicroMsg.Music.MusicDownloadTask", "can start play");
                this.eUv = true;
                this.fMm = false;
                ad.o(new a(this, 1));
            }
        }
    }

    private void nv(int i) {
        ad.o(new a(this, i));
    }

    private void ck(long j) {
        if (this.fMm) {
            this.big.field_wifiDownloadedLength = j;
            i.aDe().t(this.big.field_musicId, j);
            i.aDe().aG(this.big.field_musicId, 1);
            i.aDe().u(this.big.field_musicId, j);
        } else {
            this.big.field_downloadedLength = j;
            i.aDe().v(this.big.field_musicId, j);
            i.aDe().aH(this.big.field_musicId, 1);
            i.aDe().w(this.big.field_musicId, j);
        }
        ad.o(new a(this, 2));
    }

    private void l(long j, long j2) {
        if (this.fMm) {
            this.big.field_wifiDownloadedLength = j;
            i.aDe().t(this.big.field_musicId, j);
            i.aDe().aG(this.big.field_musicId, 0);
            i.aDe().u(this.big.field_musicId, j2);
        } else {
            this.big.field_downloadedLength = j;
            i.aDe().v(this.big.field_musicId, j);
            i.aDe().aH(this.big.field_musicId, 0);
            i.aDe().w(this.big.field_musicId, j2);
        }
        ad.o(new a(this, 3));
    }

    private static long[] xc(String str) {
        if (be.kS(str)) {
            return null;
        }
        try {
            String[] split = str.replace("bytes", "").trim().split("-");
            long longValue = Long.valueOf(split[0]).longValue();
            split = split[1].split("/");
            long longValue2 = Long.valueOf(split[0]).longValue();
            long longValue3 = Long.valueOf(split[1]).longValue();
            return new long[]{longValue, longValue2, longValue3};
        } catch (Exception e) {
            return null;
        }
    }
}
