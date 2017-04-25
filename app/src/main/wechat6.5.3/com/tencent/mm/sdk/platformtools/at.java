package com.tencent.mm.sdk.platformtools;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class at {
    static String[] nkS = new String[]{"sysfs", "rootfs", "binfmt_misc", "anon_inodefs", "bdev", "proc", "cgroup", "tmpfs", "debugfs", "sockfs", "pipefs", "rpc_pipefs", "devpts", "ramfs", "fuseblk", "fusectl", "selinuxfs"};
    static String[] nkT = new String[]{"vfat", "exfat", "fuse", "sdcardfs"};
    static String[] nkU = new String[]{"/mnt/secure", "/mnt/asec", "/mnt/obb", "/dev/mapper", "/data/"};
    static String[] nkV = new String[]{"/dev/block/vold"};

    public static class a {
        public boolean aOO;
        public String nkW;
        public String nkX;
        public String nkY;
        public long nkZ;
        public long nla;
        public long nlb;
        public long nlc;
        a nld;

        public final String toString() {
            return "{DevName=" + this.nkW + ", MountDir=" + this.nkX + ", FileSystem=" + this.nkY + ", TotalBlocks=" + this.nkZ + ", FreeBlocks=" + this.nla + ", AvailableBlocks=" + this.nlb + ", BlockSize=" + this.nlc + ", Shared=" + (this.nld != null) + "}";
        }

        public final boolean equals(Object obj) {
            a aVar = (a) obj;
            if (this.nlc != aVar.nlc) {
                return false;
            }
            long j = this.nkZ - aVar.nkZ;
            long j2 = this.nla - aVar.nla;
            long j3 = this.nlb - aVar.nlb;
            if (Math.abs(j - j2) > 4 || Math.abs(j - j3) > 4 || Math.abs(j2 - j3) > 4) {
                return false;
            }
            return true;
        }
    }

    private static ArrayList<a> btQ() {
        Throwable e;
        Exception e2;
        ArrayList<a> arrayList = new ArrayList();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/mounts"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split("\\s+");
                        if (split == null || split.length < 3) {
                            v.e("MicroMsg.SdcardUtil", "splite failed for line: " + readLine);
                        } else {
                            a aVar = new a();
                            aVar.nkW = split[0];
                            aVar.nkX = split[1];
                            aVar.nkY = split[2];
                            arrayList.add(aVar);
                        }
                    } else {
                        try {
                            break;
                        } catch (Throwable e3) {
                            v.a("MicroMsg.SdcardUtil", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                } catch (Exception e4) {
                    e2 = e4;
                }
            }
            bufferedReader.close();
        } catch (Exception e5) {
            e2 = e5;
            bufferedReader = null;
            try {
                v.e("MicroMsg.SdcardUtil", "parseProcMounts", e2);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e32) {
                        v.a("MicroMsg.SdcardUtil", e32, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                e32 = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e6) {
                        v.a("MicroMsg.SdcardUtil", e6, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
                throw e32;
            }
        } catch (Throwable th2) {
            e32 = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e32;
        }
        return arrayList;
    }

    private static void a(a aVar) {
        try {
            StatFs statFs = new StatFs(aVar.nkX);
            aVar.nlc = (long) statFs.getBlockSize();
            aVar.nlb = (long) statFs.getAvailableBlocks();
            aVar.nkZ = (long) statFs.getBlockCount();
            aVar.nla = (long) statFs.getFreeBlocks();
        } catch (IllegalArgumentException e) {
            v.e("MicroMsg.SdcardUtil", "statFsForStatMountParse", e);
        }
    }

    private static boolean b(a aVar) {
        FileOutputStream fileOutputStream;
        boolean delete;
        IOException e;
        Throwable e2;
        File file = new File(aVar.nkX, "test_writable");
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write("test".getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                delete = file.delete();
                try {
                    fileOutputStream.close();
                } catch (Throwable e3) {
                    v.a("MicroMsg.SdcardUtil", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            } catch (IOException e4) {
                e = e4;
                try {
                    v.e("MicroMsg.SdcardUtil", "createNewFile: " + e.getMessage() + " dir: " + aVar.nkX);
                    if (fileOutputStream == null) {
                        delete = false;
                    } else {
                        try {
                            fileOutputStream.close();
                            delete = false;
                        } catch (Throwable e22) {
                            v.a("MicroMsg.SdcardUtil", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                            delete = false;
                        }
                    }
                    aVar.aOO = delete;
                    return delete;
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e32) {
                            v.a("MicroMsg.SdcardUtil", e32, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    throw e22;
                }
            }
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
            v.e("MicroMsg.SdcardUtil", "createNewFile: " + e.getMessage() + " dir: " + aVar.nkX);
            if (fileOutputStream == null) {
                fileOutputStream.close();
                delete = false;
            } else {
                delete = false;
            }
            aVar.aOO = delete;
            return delete;
        } catch (Throwable th2) {
            e22 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e22;
        }
        aVar.aOO = delete;
        return delete;
    }

    private static a btR() {
        a aVar;
        ArrayList btQ = btQ();
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        Iterator it = btQ.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.nkX.equals(absolutePath)) {
                break;
            }
        }
        aVar = null;
        if (aVar == null) {
            aVar = new a();
            aVar.nkX = absolutePath;
            aVar.nkW = "Unknown";
            aVar.nkY = "Unknown";
        }
        a(aVar);
        return aVar;
    }

    private static a btS() {
        a aVar;
        ArrayList btQ = btQ();
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Iterator it = btQ.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.nkX.equals(absolutePath)) {
                break;
            }
        }
        aVar = null;
        if (aVar == null) {
            aVar = new a();
            aVar.nkX = absolutePath;
            aVar.nkW = "Unknown";
            aVar.nkY = "Unknown";
        }
        a(aVar);
        return aVar;
    }

    public static ArrayList<a> btT() {
        int size;
        ArrayList<a> btQ = btQ();
        int size2 = btQ.size();
        List asList = Arrays.asList(nkT);
        List<String> asList2 = Arrays.asList(nkU);
        List<String> asList3 = Arrays.asList(nkV);
        for (int i = size2 - 1; i >= 0; i--) {
            int i2;
            a aVar = (a) btQ.get(i);
            if (asList.contains(aVar.nkY)) {
                i2 = 0;
                for (String startsWith : asList2) {
                    i2 = aVar.nkX.startsWith(startsWith) | i2;
                }
                if (i2 != 0) {
                    btQ.remove(i);
                    v.d("MicroMsg.SdcardUtil", "Remove with bad mount dir1: " + aVar.nkX);
                } else if (aVar.nkY.equals("fuse") || aVar.nkY.equals("sdcardfs")) {
                    if (aVar.nkW.startsWith("/data/")) {
                        btQ.remove(i);
                        v.d("MicroMsg.SdcardUtil", "Remove with bad mount dir2: " + aVar.nkW);
                    }
                } else if (!(aVar.nkY.equals("fuse") || aVar.nkY.equals("sdcardfs"))) {
                    i2 = 0;
                    for (String startsWith2 : asList3) {
                        i2 = aVar.nkW.startsWith(startsWith2) | i2;
                    }
                    if (i2 == 0) {
                        btQ.remove(i);
                        v.d("MicroMsg.SdcardUtil", "Remove with bad device name: " + aVar.nkW);
                    }
                }
            } else {
                btQ.remove(i);
                v.d("MicroMsg.SdcardUtil", "Remove with filesystem mismatch: " + aVar.nkY);
            }
        }
        String path = Environment.getExternalStorageDirectory().getPath();
        for (size = btQ.size() - 1; size >= 0; size--) {
            aVar = (a) btQ.get(size);
            if (aVar.nkX.equals(path)) {
                btQ.remove(size);
                btQ.add(0, aVar);
                size2 = 1;
                break;
            }
        }
        size2 = 0;
        if (size2 == 0) {
            aVar = new a();
            aVar.nkX = path;
            aVar.nkY = "unknown";
            aVar.nkW = "unknown";
            btQ.add(0, aVar);
        }
        for (size = btQ.size() - 1; size >= 0; size--) {
            aVar = (a) btQ.get(size);
            File file = new File(aVar.nkX);
            if (!file.exists() || !file.isDirectory()) {
                v.d("MicroMsg.SdcardUtil", "Directory verify failed: " + aVar);
                btQ.remove(size);
            }
        }
        for (size = btQ.size() - 1; size >= 0; size--) {
            aVar = (a) btQ.get(size);
            if (!b(aVar)) {
                v.d("MicroMsg.SdcardUtil", "Directory testPermissionForStatMountParse failed: " + aVar);
                btQ.remove(size);
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!btQ.isEmpty()) {
            i2 = btQ.size() - 1;
            a aVar2 = (a) btQ.remove(0);
            while (i2 >= 0) {
                aVar = (a) btQ.get(i2);
                if (aVar2.nkW.equals(aVar.nkW)) {
                    btQ.remove(i2);
                    v.d("MicroMsg.SdcardUtil", "Duplicate with same DevName:" + aVar2.nkW);
                    if (!aVar2.aOO && aVar.aOO) {
                        v.d("MicroMsg.SdcardUtil", "Keep the writable one, discard the unwritable one");
                        i2--;
                        aVar2 = aVar;
                    }
                }
                aVar = aVar2;
                i2--;
                aVar2 = aVar;
            }
            arrayList.add(aVar2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((a) it.next());
        }
        btQ.clear();
        while (!arrayList.isEmpty()) {
            aVar2 = (a) arrayList.remove(0);
            btQ.add(aVar2);
            for (i2 = arrayList.size() - 1; i2 >= 0; i2--) {
                aVar = (a) arrayList.get(i2);
                if (aVar2.equals(aVar)) {
                    v.d("MicroMsg.SdcardUtil", "Duplicate:" + aVar2.toString() + "---" + aVar.toString());
                    arrayList.remove(i2);
                }
            }
        }
        return btQ;
    }

    public static long btU() {
        a btR = btR();
        return btR.nlc * btR.nlb;
    }

    public static long btV() {
        a btS = btS();
        return btS.nlc * btS.nlb;
    }

    public static boolean btW() {
        a aVar;
        boolean z;
        a aVar2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList btQ = btQ();
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        String absolutePath2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        Iterator it = btQ.iterator();
        a aVar3 = null;
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar3 == null && aVar.nkX.equals(absolutePath)) {
                if (aVar2 != null) {
                    aVar3 = aVar;
                    break;
                }
                aVar3 = aVar;
            } else {
                if (aVar2 == null && aVar.nkX.equals(absolutePath2)) {
                    if (aVar3 != null) {
                        aVar2 = aVar;
                        break;
                    }
                }
                aVar = aVar2;
                aVar2 = aVar;
            }
        }
        if (aVar3 != null && aVar2 == null && !be.kS(absolutePath2) && absolutePath2.contains("emulated")) {
            String substring = absolutePath2.substring(absolutePath2.lastIndexOf(47) + 1);
            v.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage multiuser uid[%s][%d]", substring, Integer.valueOf(be.getInt(substring, -1)));
            if (be.getInt(substring, -1) != -1) {
                absolutePath = absolutePath2.substring(0, (absolutePath2.length() - substring.length()) - 1);
                if (!be.kS(absolutePath)) {
                    Iterator it2 = btQ.iterator();
                    while (it2.hasNext()) {
                        aVar = (a) it2.next();
                        if (aVar.nkX.equals(absolutePath)) {
                            break;
                        }
                    }
                }
            }
        }
        aVar = aVar2;
        if (!(aVar3 == null || aVar == null)) {
            a(aVar3);
            a(aVar);
            v.d("MicroMsg.SdcardUtil", "hasUnRemovableStorage stats dataStatMountParse[%s] storageStatMountParse[%s]", aVar3, aVar);
            if ((aVar.nkY.equals("fuse") || aVar.nkY.equals("sdcardfs") || aVar.nkY.equals("esdfs")) && aVar3.nkZ >= aVar.nkZ && aVar.nkZ > 0 && aVar3.nlc >= aVar.nlc && aVar.nlc > 0 && aVar3.nlb >= aVar.nlb) {
                z = true;
                v.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return z;
            }
        }
        z = false;
        v.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return z;
    }

    public static String Kr(String str) {
        String str2 = SQLiteDatabase.KeyEmpty;
        if (be.kS(str)) {
            return str2;
        }
        ArrayList btQ = btQ();
        Iterator it = btQ.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (str.equals(aVar.nkX)) {
                str2 = aVar.nkY;
                break;
            }
        }
        v.i("MicroMsg.SdcardUtil", "getFileSystem[%s] is [%s]", str, str2);
        if (!be.kS(str2) || !str.contains("emulated")) {
            return str2;
        }
        String substring = str.substring(str.lastIndexOf(47) + 1);
        v.i("MicroMsg.SdcardUtil", "getFileSystem multiuser uid[%s][%d]", substring, Integer.valueOf(be.getInt(substring, -1)));
        if (be.getInt(substring, -1) == -1) {
            return str2;
        }
        String substring2 = str.substring(0, (str.length() - substring.length()) - 1);
        if (be.kS(substring2)) {
            return str2;
        }
        Iterator it2 = btQ.iterator();
        while (it2.hasNext()) {
            aVar = (a) it2.next();
            if (substring2.equals(aVar.nkX)) {
                v.i("MicroMsg.SdcardUtil", "getFileSystem[%s] fix[%s] is [%s]", str, substring2, aVar.nkY);
                return aVar.nkY;
            }
        }
        return str2;
    }
}
