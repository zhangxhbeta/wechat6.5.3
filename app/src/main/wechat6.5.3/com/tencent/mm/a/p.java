package com.tencent.mm.a;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class p {
    public static void a(Collection<File> collection, File file) {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 131072));
        for (File file2 : collection) {
            if (file2.exists()) {
                a(file2, zipOutputStream, SQLiteDatabase.KeyEmpty);
            }
        }
        zipOutputStream.close();
    }

    private static void a(File file, ZipOutputStream zipOutputStream, String str) {
        String str2 = str + (str.trim().length() == 0 ? SQLiteDatabase.KeyEmpty : File.separator) + file.getName();
        if (file.isDirectory()) {
            for (File a : file.listFiles()) {
                a(a, zipOutputStream, str2);
            }
            return;
        }
        byte[] bArr = new byte[131072];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 131072);
        zipOutputStream.putNextEntry(new ZipEntry(str2));
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                zipOutputStream.write(bArr, 0, read);
            } else {
                bufferedInputStream.close();
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                return;
            }
        }
    }

    public static String a(File file, boolean z, String str) {
        int i = 0;
        if (str != null) {
            File parentFile = new File(str).getParentFile();
            if (!(parentFile == null || parentFile.exists())) {
                parentFile.mkdirs();
            }
        }
        ArrayList arrayList = new ArrayList();
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return null;
            }
            for (Object add : listFiles) {
                arrayList.add(add);
            }
            if (str == null) {
                str = file.getAbsolutePath() + File.separator + file.getName() + ".zip";
            }
        } else {
            arrayList.add(file);
            if (str == null) {
                str = file.getAbsoluteFile().getParentFile().getAbsolutePath() + File.separator + file.getName() + ".zip";
            }
        }
        File file2 = new File(str);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            a(arrayList, file2);
            if (z) {
                while (i < arrayList.size()) {
                    ((File) arrayList.get(i)).delete();
                    i++;
                }
            }
            return file2.getAbsolutePath();
        } catch (Exception e) {
            return null;
        }
    }
}
