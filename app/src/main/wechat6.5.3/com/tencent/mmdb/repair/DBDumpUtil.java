package com.tencent.mmdb.repair;

import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.support.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DBDumpUtil {
    private static final String TAG = "MMDB.DBDumpUtil";

    public interface ExecuteSqlCallback {
        String preExecute(String str);
    }

    private static native boolean nativeDumpDB(String str, String str2, String str3);

    private static native boolean nativeIsSqlComplete(String str);

    public static boolean doRecoveryDb(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        return doRecoveryDb(sQLiteDatabase, str, str2, str3, null, null, null, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean doRecoveryDb(com.tencent.mmdb.database.SQLiteDatabase r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.util.List<java.lang.String> r18, java.util.List<java.lang.String> r19, com.tencent.mmdb.repair.DBDumpUtil.ExecuteSqlCallback r20, boolean r21) {
        /*
        if (r14 == 0) goto L_0x0008;
    L_0x0002:
        r1 = r14.isOpen();
        if (r1 != 0) goto L_0x0013;
    L_0x0008:
        r1 = "MMDB.DBDumpUtil";
        r2 = "Database is not open";
        com.tencent.mmdb.support.Log.w(r1, r2);
        r1 = 0;
    L_0x0012:
        return r1;
    L_0x0013:
        r1 = nativeDumpDB(r15, r16, r17);
        if (r1 != 0) goto L_0x001b;
    L_0x0019:
        r1 = 0;
        goto L_0x0012;
    L_0x001b:
        r9 = new java.io.BufferedReader;	 Catch:{ FileNotFoundException -> 0x00a7 }
        r1 = new java.io.FileReader;	 Catch:{ FileNotFoundException -> 0x00a7 }
        r0 = r17;
        r1.<init>(r0);	 Catch:{ FileNotFoundException -> 0x00a7 }
        r9.<init>(r1);	 Catch:{ FileNotFoundException -> 0x00a7 }
        r1 = "PRAGMA foreign_keys=OFF;";
        r14.execSQL(r1);
        r14.beginTransaction();
        r3 = 0;
        r2 = 0;
        r4 = 0;
        r6 = 0;
        r1 = 0;
        r10 = new java.util.HashMap;	 Catch:{ IOException -> 0x0203 }
        r10.<init>();	 Catch:{ IOException -> 0x0203 }
        r5 = r1;
    L_0x003b:
        r1 = r9.readLine();	 Catch:{ IOException -> 0x0203 }
        if (r1 == 0) goto L_0x01af;
    L_0x0041:
        if (r5 == 0) goto L_0x00ba;
    L_0x0043:
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0203 }
        r7.<init>();	 Catch:{ IOException -> 0x0203 }
        r6 = r7.append(r6);	 Catch:{ IOException -> 0x0203 }
        r7 = "\n";
        r6 = r6.append(r7);	 Catch:{ IOException -> 0x0203 }
        r1 = r6.append(r1);	 Catch:{ IOException -> 0x0203 }
        r6 = r1.toString();	 Catch:{ IOException -> 0x0203 }
        r1 = ";";
        r1 = r6.endsWith(r1);	 Catch:{ IOException -> 0x0203 }
        if (r1 == 0) goto L_0x003b;
    L_0x0064:
        r1 = nativeIsSqlComplete(r6);	 Catch:{ IOException -> 0x0203 }
        if (r1 == 0) goto L_0x003b;
    L_0x006a:
        r8 = 0;
        r5 = 0;
        r1 = 0;
        if (r19 == 0) goto L_0x0105;
    L_0x006f:
        r7 = r19.size();	 Catch:{ IOException -> 0x0203 }
        if (r7 <= 0) goto L_0x0105;
    L_0x0075:
        r7 = getTableNameFromSql(r6);	 Catch:{ IOException -> 0x0203 }
        r5 = 1;
        r11 = r19.iterator();	 Catch:{ IOException -> 0x0203 }
    L_0x007e:
        r1 = r11.hasNext();	 Catch:{ IOException -> 0x0203 }
        if (r1 == 0) goto L_0x0101;
    L_0x0084:
        r1 = r11.next();	 Catch:{ IOException -> 0x0203 }
        r1 = (java.lang.String) r1;	 Catch:{ IOException -> 0x0203 }
        r1 = r7.equals(r1);	 Catch:{ IOException -> 0x0203 }
        if (r1 == 0) goto L_0x007e;
    L_0x0090:
        r1 = 0;
        r5 = r6;
        r6 = r7;
    L_0x0093:
        if (r1 == 0) goto L_0x012f;
    L_0x0095:
        r1 = "MMDB.DBDumpUtil";
        r7 = "filter table %s";
        r11 = 1;
        r11 = new java.lang.Object[r11];	 Catch:{ IOException -> 0x0203 }
        r12 = 0;
        r11[r12] = r6;	 Catch:{ IOException -> 0x0203 }
        com.tencent.mmdb.support.Log.i(r1, r7, r11);	 Catch:{ IOException -> 0x0203 }
        r6 = r5;
        r5 = r8;
        goto L_0x003b;
    L_0x00a7:
        r1 = move-exception;
        r1 = "MMDB.DBDumpUtil";
        r2 = "SQL file '%s' not found";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r17;
        com.tencent.mmdb.support.Log.w(r1, r2, r3);
        r1 = 0;
        goto L_0x0012;
    L_0x00ba:
        r7 = "INSERT";
        r7 = r1.startsWith(r7);	 Catch:{ IOException -> 0x0203 }
        if (r7 != 0) goto L_0x00cc;
    L_0x00c3:
        r7 = "CREATE TABLE";
        r7 = r1.startsWith(r7);	 Catch:{ IOException -> 0x0203 }
        if (r7 == 0) goto L_0x003b;
    L_0x00cc:
        r5 = ";";
        r5 = r1.endsWith(r5);	 Catch:{ IOException -> 0x0203 }
        if (r5 == 0) goto L_0x00db;
    L_0x00d5:
        r5 = nativeIsSqlComplete(r1);	 Catch:{ IOException -> 0x0203 }
        if (r5 != 0) goto L_0x00fe;
    L_0x00db:
        r5 = android.text.TextUtils.isEmpty(r6);	 Catch:{ IOException -> 0x0203 }
        if (r5 == 0) goto L_0x00e5;
    L_0x00e1:
        r5 = 1;
        r6 = r1;
        goto L_0x003b;
    L_0x00e5:
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0203 }
        r5.<init>();	 Catch:{ IOException -> 0x0203 }
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x0203 }
        r6 = "\n";
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x0203 }
        r1 = r5.append(r1);	 Catch:{ IOException -> 0x0203 }
        r1 = r1.toString();	 Catch:{ IOException -> 0x0203 }
        goto L_0x00e1;
    L_0x00fe:
        r6 = r1;
        goto L_0x006a;
    L_0x0101:
        r1 = r5;
        r5 = r6;
        r6 = r7;
        goto L_0x0093;
    L_0x0105:
        if (r18 == 0) goto L_0x022b;
    L_0x0107:
        r7 = r18.size();	 Catch:{ IOException -> 0x0203 }
        if (r7 <= 0) goto L_0x022b;
    L_0x010d:
        r7 = getTableNameFromSql(r6);	 Catch:{ IOException -> 0x0203 }
        r5 = 0;
        r11 = r18.iterator();	 Catch:{ IOException -> 0x0203 }
    L_0x0116:
        r1 = r11.hasNext();	 Catch:{ IOException -> 0x0203 }
        if (r1 == 0) goto L_0x0226;
    L_0x011c:
        r1 = r11.next();	 Catch:{ IOException -> 0x0203 }
        r1 = (java.lang.String) r1;	 Catch:{ IOException -> 0x0203 }
        r1 = r7.equals(r1);	 Catch:{ IOException -> 0x0203 }
        if (r1 == 0) goto L_0x0116;
    L_0x0128:
        r1 = 1;
        r5 = "";
        r6 = r7;
        goto L_0x0093;
    L_0x012f:
        r1 = "CREATE TABLE";
        r1 = r5.startsWith(r1);	 Catch:{ Exception -> 0x01aa }
        if (r1 == 0) goto L_0x016c;
    L_0x0138:
        r1 = getColumnNamesFromSql(r5);	 Catch:{ Exception -> 0x01aa }
        r1 = buildColumnsString(r1);	 Catch:{ Exception -> 0x01aa }
        r10.put(r6, r1);	 Catch:{ Exception -> 0x01aa }
    L_0x0143:
        r1 = 0;
        if (r20 == 0) goto L_0x014c;
    L_0x0146:
        r0 = r20;
        r1 = r0.preExecute(r5);	 Catch:{ Exception -> 0x01aa }
    L_0x014c:
        r6 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x01aa }
        if (r6 != 0) goto L_0x0223;
    L_0x0152:
        r2 = r2 + 1;
        r14.execSQL(r1);	 Catch:{ Exception -> 0x01aa }
        r1 = r4 + 1;
        r4 = 100;
        if (r1 < r4) goto L_0x0167;
    L_0x015d:
        r14.setTransactionSuccessful();	 Catch:{ Exception -> 0x0221 }
        r14.endTransaction();	 Catch:{ Exception -> 0x0221 }
        r14.beginTransaction();	 Catch:{ Exception -> 0x0221 }
        r1 = 0;
    L_0x0167:
        r6 = 0;
        r5 = r8;
        r4 = r1;
        goto L_0x003b;
    L_0x016c:
        r1 = "INSERT INTO";
        r1 = r5.startsWith(r1);	 Catch:{ Exception -> 0x01aa }
        if (r1 == 0) goto L_0x0143;
    L_0x0175:
        r1 = r10.get(r6);	 Catch:{ Exception -> 0x01aa }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x01aa }
        r7 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x01aa }
        if (r7 != 0) goto L_0x0143;
    L_0x0181:
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01aa }
        r11 = "INSERT INTO ";
        r7.<init>(r11);	 Catch:{ Exception -> 0x01aa }
        r11 = "\"";
        r11 = r7.append(r11);	 Catch:{ Exception -> 0x01aa }
        r6 = r11.append(r6);	 Catch:{ Exception -> 0x01aa }
        r11 = "\"";
        r6.append(r11);	 Catch:{ Exception -> 0x01aa }
        r6 = r7.toString();	 Catch:{ Exception -> 0x01aa }
        r7.append(r1);	 Catch:{ Exception -> 0x01aa }
        r1 = r7.toString();	 Catch:{ Exception -> 0x01aa }
        r5 = r5.replace(r6, r1);	 Catch:{ Exception -> 0x01aa }
        goto L_0x0143;
    L_0x01aa:
        r1 = move-exception;
        r1 = r4;
    L_0x01ac:
        r3 = r3 + 1;
        goto L_0x0167;
    L_0x01af:
        r9.close();	 Catch:{ IOException -> 0x021b }
    L_0x01b2:
        if (r2 <= r3) goto L_0x0218;
    L_0x01b4:
        r1 = r14.inTransaction();
        if (r1 == 0) goto L_0x01bd;
    L_0x01ba:
        r14.setTransactionSuccessful();
    L_0x01bd:
        r1 = r14.inTransaction();
        if (r1 == 0) goto L_0x01c6;
    L_0x01c3:
        r14.endTransaction();
    L_0x01c6:
        if (r21 == 0) goto L_0x01e6;
    L_0x01c8:
        r1 = new java.io.File;
        r0 = r17;
        r1.<init>(r0);
        r4 = r1.exists();
        if (r4 == 0) goto L_0x01d8;
    L_0x01d5:
        r1.delete();
    L_0x01d8:
        r1 = new java.io.File;
        r1.<init>(r15);
        r4 = r1.exists();
        if (r4 == 0) goto L_0x01e6;
    L_0x01e3:
        r1.delete();
    L_0x01e6:
        r1 = "MMDB.DBDumpUtil";
        r4 = "restore : %d , fail:%d ";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r2 = java.lang.Integer.valueOf(r2);
        r5[r6] = r2;
        r2 = 1;
        r3 = java.lang.Integer.valueOf(r3);
        r5[r2] = r3;
        com.tencent.mmdb.support.Log.i(r1, r4, r5);
        r1 = 1;
        goto L_0x0012;
    L_0x0203:
        r1 = move-exception;
        r1 = "MMDB.DBDumpUtil";
        r2 = "I/O error in read sql file ";
        com.tencent.mmdb.support.Log.w(r1, r2);	 Catch:{ all -> 0x0213 }
        r9.close();	 Catch:{ IOException -> 0x021d }
    L_0x0210:
        r1 = 0;
        goto L_0x0012;
    L_0x0213:
        r1 = move-exception;
        r9.close();	 Catch:{ IOException -> 0x021f }
    L_0x0217:
        throw r1;
    L_0x0218:
        r1 = 0;
        goto L_0x0012;
    L_0x021b:
        r1 = move-exception;
        goto L_0x01b2;
    L_0x021d:
        r1 = move-exception;
        goto L_0x0210;
    L_0x021f:
        r2 = move-exception;
        goto L_0x0217;
    L_0x0221:
        r4 = move-exception;
        goto L_0x01ac;
    L_0x0223:
        r1 = r5;
        goto L_0x0152;
    L_0x0226:
        r1 = r5;
        r5 = r6;
        r6 = r7;
        goto L_0x0093;
    L_0x022b:
        r13 = r6;
        r6 = r5;
        r5 = r13;
        goto L_0x0093;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mmdb.repair.DBDumpUtil.doRecoveryDb(com.tencent.mmdb.database.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, com.tencent.mmdb.repair.DBDumpUtil$ExecuteSqlCallback, boolean):boolean");
    }

    public static String buildColumnsString(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (int i = 0; i < arrayList.size(); i++) {
            stringBuilder.append((String) arrayList.get(i));
            if (i != arrayList.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        String stringBuilder2 = stringBuilder.toString();
        System.out.println(stringBuilder2);
        return stringBuilder2;
    }

    public static String getTableNameFromSql(String str) {
        if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        String[] split = str.split("\\s");
        if (split == null || split.length <= 1) {
            return null;
        }
        return split[2].replaceAll("\"", SQLiteDatabase.KeyEmpty);
    }

    public static byte[] readFromFile(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        File file = new File(str);
        if (file.exists()) {
            try {
                int length = (int) file.length();
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[length];
                    if (fileInputStream.read(bArr) != length) {
                        Log.w(TAG, "readFromFile error, size is not equal, path = %s, file length is %d, count is %d", str, Integer.valueOf(length), Integer.valueOf(fileInputStream.read(bArr)));
                        try {
                            fileInputStream.close();
                            return null;
                        } catch (IOException e) {
                            return null;
                        }
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                    return bArr;
                } catch (Exception e3) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    Log.e(TAG, "readFromFile failed!");
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                fileInputStream2 = null;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                Log.e(TAG, "readFromFile failed!");
                return null;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        Log.w(TAG, "readFromFile error, file is not exit, path = %s", str);
        return null;
    }

    public static ArrayList<String> getColumnNamesFromSql(String str) {
        ArrayList<String> arrayList = new ArrayList();
        String[] split = str.substring(str.indexOf("(") + 1, str.lastIndexOf(")")).trim().split(",");
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
            arrayList.add(split[i].substring(0, split[i].indexOf(" ")));
        }
        return arrayList;
    }
}
