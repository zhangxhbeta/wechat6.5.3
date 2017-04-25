package com.tencent.mapsdk.rastercore.tile.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import com.tencent.tencentmap.mapsdk.map.g;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

public final class a {
    private static final ReadWriteLock a = new ReentrantReadWriteLock();
    private static final String d = ("Qmap" + File.separator + "RealTimeMap" + File.separator + "v1");
    private boolean b = false;
    private volatile Context c;

    static class a {
        public static final a a = new a();
    }

    private static int a(int i, int i2) {
        return ((i % 128) * 128) + (i2 % 128);
    }

    public static a a() {
        return a.a;
    }

    private String[] a(com.tencent.mapsdk.rastercore.tile.a aVar, boolean z) {
        int b = aVar.b() / 128;
        int c = aVar.c() / 128;
        int i = b / 10;
        int i2 = c / 10;
        String[] strArr = new String[2];
        StringBuilder stringBuilder = new StringBuilder();
        Object c2 = c();
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        stringBuilder.append(c2);
        stringBuilder.append("/");
        stringBuilder.append(aVar.a());
        stringBuilder.append("/");
        stringBuilder.append(aVar.d());
        stringBuilder.append("/");
        stringBuilder.append(i);
        stringBuilder.append("/");
        stringBuilder.append(i2);
        stringBuilder.append("/");
        if (!z) {
            File file = new File(stringBuilder.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        stringBuilder.append(aVar.d());
        stringBuilder.append("_");
        stringBuilder.append(b);
        stringBuilder.append("_");
        stringBuilder.append(c);
        strArr[0] = stringBuilder.toString() + ".idx";
        strArr[1] = stringBuilder.toString() + ".dat";
        return strArr;
    }

    public final Bitmap a(com.tencent.mapsdk.rastercore.tile.a aVar, StringBuilder stringBuilder) {
        Throwable th;
        Bitmap bitmap = null;
        a.readLock().lock();
        Closeable randomAccessFile;
        try {
            String[] a = a(aVar, true);
            if (a == null || a.length != 2 || a[0].equals("") || Arrays.equals(a, new String[a.length])) {
                a.readLock().unlock();
            } else {
                File file = new File(a[0]);
                if (!file.exists() || file.length() == 0) {
                    a.readLock().unlock();
                } else {
                    int a2 = a(aVar.b(), aVar.c());
                    if (a2 < 0) {
                        a.readLock().unlock();
                    } else {
                        byte[] bArr = new byte[4];
                        try {
                            randomAccessFile = new RandomAccessFile(file, "r");
                            try {
                                randomAccessFile.seek((long) (a2 * 4));
                                randomAccessFile.read(bArr, 0, 4);
                                try {
                                    stringBuilder.append("1,randomIndex.length=" + randomAccessFile.length() + ";");
                                } catch (IOException e) {
                                }
                                com.tencent.mapsdk.rastercore.d.a.a(randomAccessFile);
                                com.tencent.mapsdk.rastercore.d.a.b(bArr);
                                int a3 = com.tencent.mapsdk.rastercore.d.a.a(bArr);
                                if (a3 < 0) {
                                    a.readLock().unlock();
                                } else {
                                    stringBuilder.append("2,iIndex=" + a3 + ";");
                                    File file2 = new File(a[1]);
                                    if (file2.exists()) {
                                        try {
                                            randomAccessFile = new RandomAccessFile(file2, "r");
                                            try {
                                                stringBuilder.append("3,randomCach.length=" + randomAccessFile.length() + ";");
                                                randomAccessFile.seek((long) a3);
                                                randomAccessFile.read(bArr, 0, 4);
                                                com.tencent.mapsdk.rastercore.d.a.b(bArr);
                                                int a4 = com.tencent.mapsdk.rastercore.d.a.a(bArr);
                                                stringBuilder.append("4,iLength=" + a4 + ";");
                                                if (a4 <= 0 || a4 > 2097152) {
                                                    com.tencent.mapsdk.rastercore.d.a.a(randomAccessFile);
                                                    if (g.pAe != null) {
                                                        g.pAe.collectErrorInfo("CacheManager Get Function:dataLength(iLength)=" + a4 + ";tileInfo:x=" + aVar.b() + ",y=" + aVar.c() + ",z=" + aVar.d());
                                                    }
                                                    a.readLock().unlock();
                                                } else {
                                                    byte[] bArr2 = new byte[a4];
                                                    randomAccessFile.read(bArr2, 0, a4);
                                                    com.tencent.mapsdk.rastercore.d.a.a(randomAccessFile);
                                                    stringBuilder.append("5,btyImg.length=" + a4 + ";");
                                                    try {
                                                        bitmap = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
                                                    } catch (Exception e2) {
                                                    }
                                                    stringBuilder.append("6;");
                                                    a.readLock().unlock();
                                                }
                                            } catch (Exception e3) {
                                                com.tencent.mapsdk.rastercore.d.a.a(randomAccessFile);
                                                a.readLock().unlock();
                                                return bitmap;
                                            }
                                        } catch (Exception e4) {
                                            randomAccessFile = bitmap;
                                            com.tencent.mapsdk.rastercore.d.a.a(randomAccessFile);
                                            a.readLock().unlock();
                                            return bitmap;
                                        }
                                    }
                                    a.readLock().unlock();
                                }
                            } catch (Exception e5) {
                                com.tencent.mapsdk.rastercore.d.a.a(randomAccessFile);
                                a.readLock().unlock();
                                return bitmap;
                            } catch (Throwable th2) {
                                th = th2;
                                com.tencent.mapsdk.rastercore.d.a.a(randomAccessFile);
                                throw th;
                            }
                        } catch (Exception e6) {
                            randomAccessFile = bitmap;
                            com.tencent.mapsdk.rastercore.d.a.a(randomAccessFile);
                            a.readLock().unlock();
                            return bitmap;
                        } catch (Throwable th3) {
                            Throwable th4 = th3;
                            randomAccessFile = bitmap;
                            th = th4;
                            com.tencent.mapsdk.rastercore.d.a.a(randomAccessFile);
                            throw th;
                        }
                    }
                }
            }
        } catch (IOException e7) {
            com.tencent.mapsdk.rastercore.d.a.a(randomAccessFile);
            a.readLock().unlock();
        } catch (Throwable th5) {
            a.readLock().unlock();
        }
        return bitmap;
    }

    public final void a(int i) {
        a.writeLock().lock();
        try {
            StringBuilder stringBuilder = new StringBuilder(256);
            Object c = c();
            if (!TextUtils.isEmpty(c)) {
                stringBuilder.append(c);
                stringBuilder.append("/");
                stringBuilder.append(b.a(MapSource.SATELLITE, 0, i));
                Pattern compile = Pattern.compile("/Sate/V\\d+$");
                Pattern compile2 = Pattern.compile("\\d+$");
                File file = new File(stringBuilder.substring(0, stringBuilder.lastIndexOf("/")));
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        if (file2.isDirectory()) {
                            Object absolutePath = file2.getAbsolutePath();
                            if (compile.matcher(absolutePath).find() && Long.parseLong(compile2.matcher(absolutePath).group()) != ((long) i)) {
                                com.tencent.mapsdk.rastercore.f.a.b(absolutePath);
                            }
                        } else {
                            file2.delete();
                        }
                    }
                }
                a.writeLock().unlock();
            }
        } finally {
            a.writeLock().unlock();
        }
    }

    public final void a(int i, int i2, boolean z) {
        a.writeLock().lock();
        try {
            StringBuilder stringBuilder = new StringBuilder(256);
            Object c = c();
            if (!TextUtils.isEmpty(c)) {
                String substring;
                stringBuilder.append(c);
                stringBuilder.append("/");
                stringBuilder.append(b.a(z ? MapSource.BING : MapSource.TENCENT, i, i2));
                Pattern compile = z ? Pattern.compile("/BingGrid/" + e.v() + "/" + e.u() + "/\\d+$") : Pattern.compile("/Grid/" + e.z() + "/" + i + "/\\d+$");
                stringBuilder.substring(0, stringBuilder.lastIndexOf("/"));
                if (z) {
                    substring = stringBuilder.substring(0, stringBuilder.lastIndexOf("/"));
                    substring = substring.substring(0, substring.lastIndexOf("/"));
                } else {
                    substring = stringBuilder.substring(0, stringBuilder.lastIndexOf("/"));
                }
                File file = new File(substring);
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        if (file2.isDirectory()) {
                            String absolutePath = file2.getAbsolutePath();
                            if (compile.matcher(absolutePath).find() && Integer.parseInt(absolutePath.substring(absolutePath.lastIndexOf("/") + 1)) != i2) {
                                com.tencent.mapsdk.rastercore.f.a.b(absolutePath);
                            }
                        } else {
                            file2.delete();
                        }
                    }
                }
                a.writeLock().unlock();
            }
        } finally {
            a.writeLock().unlock();
        }
    }

    public final void a(Context context) {
        this.c = context;
    }

    public final boolean a(byte[] bArr, com.tencent.mapsdk.rastercore.tile.a aVar, StringBuilder stringBuilder) {
        a.writeLock().lock();
        if (this.c == null) {
            return false;
        }
        com.tencent.mapsdk.rastercore.d.a.a();
        int a = com.tencent.mapsdk.rastercore.d.a.a(this.c.getPackageName(), false);
        com.tencent.mapsdk.rastercore.d.a.a();
        int b = com.tencent.mapsdk.rastercore.d.a.b(this.c.getPackageName(), false);
        com.tencent.mapsdk.rastercore.d.a.a();
        if (aVar.l() != com.tencent.mapsdk.rastercore.d.a.a(a, b, false)) {
            a.writeLock().unlock();
            return false;
        } else if (bArr == null) {
            a.writeLock().unlock();
            return false;
        } else {
            int length = bArr.length;
            if (length <= 0) {
                a.writeLock().unlock();
                return false;
            }
            stringBuilder.append("1,iLength:" + length + ";");
            String[] a2 = a(aVar, false);
            if (a2 == null || a2.length != 2 || a2[0].equals("") || Arrays.equals(a2, new String[a2.length])) {
                a.writeLock().unlock();
                return false;
            }
            boolean z;
            RandomAccessFile randomAccessFile;
            File file = new File(a2[1]);
            if (!file.exists()) {
                z = false;
                try {
                    z = file.createNewFile();
                } catch (Exception e) {
                }
                if (!z) {
                    a.writeLock().unlock();
                    return false;
                }
            }
            try {
                randomAccessFile = new RandomAccessFile(file, "rws");
            } catch (Exception e2) {
                randomAccessFile = null;
            }
            if (randomAccessFile == null) {
                a.writeLock().unlock();
                return false;
            }
            long j;
            byte[] b2 = com.tencent.mapsdk.rastercore.d.a.b(length);
            com.tencent.mapsdk.rastercore.d.a.b(b2);
            long j2 = 0;
            try {
                j2 = randomAccessFile.length();
                randomAccessFile.seek(j2);
                randomAccessFile.write(b2);
                randomAccessFile.write(bArr);
                try {
                    stringBuilder.append("2,randomData.length=" + randomAccessFile.length() + ";");
                } catch (IOException e3) {
                }
                randomAccessFile.close();
                j = j2;
            } catch (Exception e4) {
                j = j2;
            }
            try {
                file = new File(a2[0]);
                if (!file.exists()) {
                    z = false;
                    try {
                        z = file.createNewFile();
                    } catch (Exception e5) {
                    }
                    if (!z) {
                        a.writeLock().unlock();
                        return false;
                    }
                }
                try {
                    randomAccessFile = new RandomAccessFile(file, "rws");
                } catch (Exception e6) {
                    randomAccessFile = null;
                }
                if (randomAccessFile == null) {
                    a.writeLock().unlock();
                    return false;
                }
                byte[] bArr2;
                j2 = 0;
                try {
                    j2 = randomAccessFile.length();
                } catch (Exception e7) {
                }
                stringBuilder.append("3,iIndexLength=" + j2 + ";");
                if (j2 == 0) {
                    bArr2 = new byte[65536];
                    Arrays.fill(bArr2, (byte) -1);
                    try {
                        randomAccessFile.write(bArr2);
                    } catch (Exception e8) {
                    }
                    stringBuilder.append(new StringBuilder("4,byteInitIndex.length=65536;").toString());
                }
                a = a(aVar.b(), aVar.c());
                if (a < 0) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e9) {
                    }
                    a.writeLock().unlock();
                    return false;
                }
                try {
                    randomAccessFile.seek((long) (a * 4));
                } catch (Exception e10) {
                }
                try {
                    stringBuilder.append("5,randomIndex.length=" + randomAccessFile.length() + ",iIndexPosition=" + a + ";");
                } catch (IOException e11) {
                }
                bArr2 = com.tencent.mapsdk.rastercore.d.a.b((int) j);
                com.tencent.mapsdk.rastercore.d.a.b(bArr2);
                try {
                    randomAccessFile.write(bArr2);
                    try {
                        stringBuilder.append("6,ICachLength=" + j + ",randomIndex.length=" + randomAccessFile.length() + ";");
                    } catch (IOException e12) {
                    }
                    randomAccessFile.close();
                } catch (Exception e13) {
                }
                a.writeLock().unlock();
                return true;
            } finally {
                a.writeLock().unlock();
            }
        }
    }

    public final boolean b() {
        a.writeLock().lock();
        try {
            com.tencent.mapsdk.rastercore.f.a.b(c());
            return true;
        } finally {
            a.writeLock().unlock();
        }
    }

    @SuppressLint({"NewApi"})
    public final String c() {
        String str;
        Object obj = 1;
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        if (VERSION.SDK_INT >= 23) {
            if (this.c == null) {
                obj = null;
            } else {
                int checkSelfPermission = this.c.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
                int checkSelfPermission2 = this.c.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
                if (!(checkSelfPermission == 0 && checkSelfPermission2 == 0)) {
                    obj = null;
                }
            }
        }
        if (!equals || r0 == null) {
            str = this.c.getFileStreamPath("") + File.separator + d;
        } else {
            try {
                str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + d;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        }
        com.tencent.mapsdk.rastercore.d.a.a(str);
        return str;
    }

    public final void d() {
        StringBuilder stringBuilder = new StringBuilder(256);
        Object c = c();
        if (!TextUtils.isEmpty(c)) {
            stringBuilder.append(c);
            stringBuilder.append("/glGrid");
            String stringBuilder2 = stringBuilder.toString();
            File file = new File(stringBuilder2);
            if (file.isDirectory() && file.exists()) {
                com.tencent.mapsdk.rastercore.f.a.b(stringBuilder2);
            }
        }
    }
}
