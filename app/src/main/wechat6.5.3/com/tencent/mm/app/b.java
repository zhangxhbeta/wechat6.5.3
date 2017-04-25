package com.tencent.mm.app;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.mm.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.RandomAccessFile;

public final class b {
    private static final String aQu = (t.cng + "channel_history.cfg");

    public static void ac(Context context) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        f.dE(context);
        try {
            a bb = a.bb(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir);
            if (!(bb == null || bb.aPT == null)) {
                v.i("MicroMsg.ChannelHistory", "apk external info not null");
                if (bb.aPT.aPW != 0) {
                    f.aPW = bb.aPT.aPW;
                    v.i("MicroMsg.ChannelHistory", "read channelId from apk external");
                }
            }
        } catch (NameNotFoundException e2) {
            v.e("MicroMsg.ChannelHistory", "NameNotFoundException");
        } catch (Exception e3) {
            v.e("MicroMsg.ChannelHistory", "Exception in initChannel, %s", e3.getMessage());
        }
        v.i("MicroMsg.ChannelHistory", "now channel id = %d, proce name = %s", Integer.valueOf(f.aPW), aa.getProcessName());
        if (!of()) {
            try {
                randomAccessFile = new RandomAccessFile(aQu, "rw");
                try {
                    randomAccessFile.write(String.format("%d\n", new Object[]{Integer.valueOf(f.aPW)}).getBytes());
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e4) {
                        v.a("MicroMsg.ChannelHistory", e4, "Close ChannelHistory History file failed.", SQLiteDatabase.KeyEmpty);
                    }
                } catch (Exception e5) {
                    e4 = e5;
                    try {
                        v.a("MicroMsg.ChannelHistory", e4, "Open ChannelHistory History file failed.", SQLiteDatabase.KeyEmpty);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e42) {
                                v.a("MicroMsg.ChannelHistory", e42, "Close ChannelHistory History file failed.", SQLiteDatabase.KeyEmpty);
                            }
                        }
                    } catch (Throwable th) {
                        e42 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e6) {
                                v.a("MicroMsg.ChannelHistory", e6, "Close ChannelHistory History file failed.", SQLiteDatabase.KeyEmpty);
                            }
                        }
                        throw e42;
                    }
                }
            } catch (Exception e7) {
                e42 = e7;
                randomAccessFile = null;
                v.a("MicroMsg.ChannelHistory", e42, "Open ChannelHistory History file failed.", SQLiteDatabase.KeyEmpty);
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (Throwable th2) {
                e42 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e42;
            }
        }
    }

    public static void oe() {
        Throwable e;
        if (of()) {
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(aQu, "rw");
                try {
                    long length = randomAccessFile.length();
                    v.i("MicroMsg.ChannelHistory", "correctChannleIdBySource fileLen:%d  curChannelId:%d", Long.valueOf(length), Integer.valueOf(f.aPW));
                    if (length <= 0) {
                        v.w("MicroMsg.ChannelHistory", "channel history file fileLen <= 0");
                        try {
                            randomAccessFile.close();
                            return;
                        } catch (Throwable e2) {
                            v.a("MicroMsg.ChannelHistory", e2, "Close ChannelHistory History file failed.", SQLiteDatabase.KeyEmpty);
                            return;
                        }
                    }
                    String readLine = randomAccessFile.readLine();
                    int i = f.aPW;
                    int i2 = f.aPW;
                    f.nhU = f.aPW;
                    String str = SQLiteDatabase.KeyEmpty;
                    if (!be.kS(readLine)) {
                        str = str + readLine + ",";
                        i2 = be.getInt(readLine, 0);
                        if (i2 != f.aPW) {
                            f.nhU = i2;
                            v.i("MicroMsg.ChannelHistory", "real correct final channelid: " + f.aPW);
                        }
                    }
                    if (aa.niD) {
                        while (true) {
                            readLine = randomAccessFile.readLine();
                            if (be.kS(readLine)) {
                                break;
                            }
                            str = str + readLine + ",";
                            i2 = be.getInt(readLine, 0);
                        }
                        v.i("MicroMsg.ChannelHistory", "channel list: %s", str);
                        if (i2 != i) {
                            randomAccessFile.seek(length);
                            randomAccessFile.write(String.format("%d\n", new Object[]{Integer.valueOf(i)}).getBytes());
                            v.i("MicroMsg.ChannelHistory", "channelid change from %d to %d", Integer.valueOf(i2), Integer.valueOf(i));
                        }
                    }
                    try {
                        randomAccessFile.close();
                        return;
                    } catch (Throwable e22) {
                        v.a("MicroMsg.ChannelHistory", e22, "Close ChannelHistory History file failed.", SQLiteDatabase.KeyEmpty);
                        return;
                    }
                } catch (Exception e3) {
                    e22 = e3;
                    try {
                        v.a("MicroMsg.ChannelHistory", e22, "Open ChannelHistory History file failed.", SQLiteDatabase.KeyEmpty);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                                return;
                            } catch (Throwable e222) {
                                v.a("MicroMsg.ChannelHistory", e222, "Close ChannelHistory History file failed.", SQLiteDatabase.KeyEmpty);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        e222 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e4) {
                                v.a("MicroMsg.ChannelHistory", e4, "Close ChannelHistory History file failed.", SQLiteDatabase.KeyEmpty);
                            }
                        }
                        throw e222;
                    }
                }
            } catch (Exception e5) {
                e222 = e5;
                randomAccessFile = null;
                v.a("MicroMsg.ChannelHistory", e222, "Open ChannelHistory History file failed.", SQLiteDatabase.KeyEmpty);
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                e222 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e222;
            }
        }
        v.w("MicroMsg.ChannelHistory", "channel history file does not exit!");
    }

    private static boolean of() {
        return new File(aQu).exists();
    }
}
