package com.tencent.mm.c.c;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public final class d implements a {
    BlockingQueue<com.tencent.mm.c.b.g.a> aVO = new ArrayBlockingQueue(1024);
    boolean aVP = false;
    String aVQ;
    private com.tencent.qqpinyin.voicerecoapi.a aVY;
    private a aVZ;
    private FileOutputStream mFileOutputStream;

    private final class a implements Runnable {
        final /* synthetic */ d aWa;

        public final void run() {
            while (true) {
                boolean z;
                synchronized (this.aWa) {
                    z = this.aWa.aVP;
                }
                v.d("MicroMsg.SpeexWriter", "ThreadSpeex in: " + z + " queueLen: " + this.aWa.aVO.size());
                if (!z || !this.aWa.aVO.isEmpty()) {
                    try {
                        com.tencent.mm.c.b.g.a aVar = (com.tencent.mm.c.b.g.a) this.aWa.aVO.poll(200, TimeUnit.MILLISECONDS);
                        if (aVar == null) {
                            v.e("MicroMsg.SpeexWriter", "poll byteBuf is null, " + this.aWa.aVQ);
                        } else {
                            this.aWa.a(aVar, 0);
                        }
                    } catch (InterruptedException e) {
                        v.i("MicroMsg.SpeexWriter", "ThreadSpeex poll null");
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final boolean bA(String str) {
        v.i("MicroMsg.SpeexWriter", "initWriter, path: " + str);
        if (str == null) {
            return false;
        }
        this.aVQ = str;
        try {
            this.mFileOutputStream = new FileOutputStream(new File(str));
            this.aVY = new com.tencent.qqpinyin.voicerecoapi.a();
            int bMs = this.aVY.bMs();
            if (bMs == 0) {
                return true;
            }
            v.e("MicroMsg.SpeexWriter", "speexInit failed: " + bMs);
            return false;
        } catch (Exception e) {
            if (this.mFileOutputStream != null) {
                try {
                    this.mFileOutputStream.close();
                } catch (IOException e2) {
                }
            }
            v.e("MicroMsg.SpeexWriter", "Error on init file: ", e);
            return false;
        }
    }

    public final int a(com.tencent.mm.c.b.g.a aVar, int i) {
        if (this.aVY == null || aVar.buf == null || aVar.aUT == 0) {
            v.e("MicroMsg.SpeexWriter", "try write invalid data to file");
            return -1;
        }
        try {
            byte[] E = this.aVY.E(aVar.buf, aVar.aUT);
            if (E == null || E.length <= 0) {
                v.e("MicroMsg.SpeexWriter", "convert failed: " + (E == null ? "outBuffer is null" : "size is zero"));
                return -1;
            }
            v.d("MicroMsg.SpeexWriter", "write to file, len: %d", Integer.valueOf(E.length));
            this.mFileOutputStream.write(E);
            this.mFileOutputStream.flush();
            return E.length;
        } catch (Exception e) {
            v.e("MicroMsg.SpeexWriter", "write to file failed", e);
            return -1;
        }
    }

    public final void pv() {
        v.i("MicroMsg.SpeexWriter", "wait Stop");
        synchronized (this) {
            this.aVP = true;
        }
        if (this.aVZ != null) {
            try {
                e.J(this.aVZ);
                this.aVZ = null;
            } catch (InterruptedException e) {
                v.e("MicroMsg.SpeexWriter", "thread speex interrupted");
            }
        }
        if (this.aVY != null) {
            this.aVY.bMt();
            this.aVY = null;
        }
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (Exception e2) {
                v.e("MicroMsg.SpeexWriter", "close silk file: " + this.aVQ + "msg: " + e2.getMessage());
            }
            this.mFileOutputStream = null;
        }
    }

    public static boolean t(String str, String str2) {
        FileInputStream fileInputStream;
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() <= 0) {
            v.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            v.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex pcmLen = " + file.length());
            try {
                com.tencent.qqpinyin.voicerecoapi.a aVar = new com.tencent.qqpinyin.voicerecoapi.a();
                if (aVar.bMs() != 0) {
                    v.e("MicroMsg.SpeexWriter", "[voiceControl] speexInit fail");
                    aVar.bMt();
                    return false;
                }
                b.deleteFile(str2);
                File file2 = new File(str2);
                file2.createNewFile();
                file2.setReadable(true);
                try {
                    byte[] bArr = new byte[4096];
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read > 0) {
                            byte[] E = aVar.E(bArr, read);
                            if (E == null) {
                                fileInputStream2.close();
                                return false;
                            }
                            try {
                                v.i("MicroMsg.SpeexWriter", "[voiceControl] appendToFile " + com.tencent.mm.a.e.e(str2, E) + ", readLen = " + read);
                            } catch (Exception e) {
                                fileInputStream = fileInputStream2;
                            }
                        } else {
                            fileInputStream2.close();
                            aVar.bMt();
                            v.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex = " + (System.currentTimeMillis() - currentTimeMillis));
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    aVar.bMt();
                    return false;
                }
            } catch (Exception e3) {
                v.e("MicroMsg.SpeexWriter", "[voiceControl] Exception in decodePCMToSpeex, " + e3.getMessage());
                return false;
            }
        }
        v.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
        return false;
    }
}
