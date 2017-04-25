package com.tencent.mm.sdk.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public abstract class c {
    public long nmb = -1;

    public static class a {
        public String[] bXK;
        public Field[] ddU;
        public String nmc;
        public Map<String, String> nmd = new HashMap();
        public String nme;
    }

    public abstract void b(Cursor cursor);

    public abstract ContentValues py();

    public abstract a tl();

    private static String[] a(Field[] fieldArr) {
        String[] strArr = new String[(fieldArr.length + 1)];
        for (int i = 0; i < fieldArr.length; i++) {
            boolean z;
            strArr[i] = a(fieldArr[i]);
            String str = "getFullColumns failed:" + fieldArr[i].getName();
            if (be.kS(strArr[i])) {
                z = false;
            } else {
                z = true;
            }
            Assert.assertTrue(str, z);
        }
        strArr[fieldArr.length] = "rowid";
        return strArr;
    }

    private static Map<String, String> b(Field[] fieldArr) {
        Map<String, String> hashMap = new HashMap();
        for (Field field : fieldArr) {
            String n = b.n(field.getType());
            if (n == null) {
                v.e("MicroMsg.SDK.IAutoDBItem", "failed identify on column: " + field.getName() + ", skipped");
            } else {
                String a = a(field);
                if (!be.kS(a)) {
                    hashMap.put(a, n);
                }
            }
        }
        return hashMap;
    }

    private static String c(Field[] fieldArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < fieldArr.length) {
            Field field = fieldArr[i];
            String n = b.n(field.getType());
            if (n == null) {
                v.e("MicroMsg.SDK.IAutoDBItem", "failed identify on column: " + field.getName() + ", skipped");
            } else {
                String a = a(field);
                if (!be.kS(a)) {
                    String str;
                    int buC;
                    String str2 = SQLiteDatabase.KeyEmpty;
                    if (field.isAnnotationPresent(e.class)) {
                        str = " default '" + ((e) field.getAnnotation(e.class)).buB() + "' ";
                        buC = ((e) field.getAnnotation(e.class)).buC();
                    } else {
                        str = str2;
                        buC = 0;
                    }
                    stringBuilder.append(a + " " + n + str + (buC == 1 ? " PRIMARY KEY " : SQLiteDatabase.KeyEmpty));
                    stringBuilder.append(i == fieldArr.length + -1 ? SQLiteDatabase.KeyEmpty : ", ");
                }
            }
            i++;
        }
        return stringBuilder.toString();
    }

    public static String a(Field field) {
        if (field == null) {
            return null;
        }
        String name = field.getName();
        if (name == null || name.length() <= 0) {
            return null;
        }
        return name.startsWith("field_") ? name.substring(6) : name;
    }

    public static Field[] o(Class<?> cls) {
        a aVar = new a();
        List linkedList = new LinkedList();
        for (Field field : cls.getDeclaredFields()) {
            int modifiers = field.getModifiers();
            String name = field.getName();
            if (!(name == null || !Modifier.isPublic(modifiers) || Modifier.isFinal(modifiers))) {
                String substring = name.startsWith("field_") ? name.substring(6) : name;
                if (field.isAnnotationPresent(e.class)) {
                    if (((e) field.getAnnotation(e.class)).buC() == 1) {
                        aVar.nmc = substring;
                    }
                } else if (name.startsWith("field_")) {
                }
                if (!be.kS(substring)) {
                    if (substring.equals("rowid")) {
                        Assert.assertTrue("field_rowid reserved by MAutoDBItem, change now!", false);
                    }
                    linkedList.add(field);
                }
            }
        }
        aVar.ddU = (Field[]) linkedList.toArray(new Field[0]);
        aVar.bXK = a(aVar.ddU);
        aVar.nmd = b(aVar.ddU);
        aVar.nme = c(aVar.ddU);
        return aVar.ddU;
    }

    public static boolean a(ContentValues contentValues, Cursor cursor) {
        if (contentValues == null) {
            if (cursor == null) {
                return true;
            }
            return false;
        } else if (cursor == null || cursor.getCount() != 1) {
            return false;
        } else {
            cursor.moveToFirst();
            int columnCount = cursor.getColumnCount();
            int size = contentValues.size();
            if (contentValues.containsKey("rowid")) {
                size--;
            }
            if (cursor.getColumnIndex("rowid") != -1) {
                columnCount--;
            }
            if (size != columnCount) {
                return false;
            }
            try {
                for (Entry key : contentValues.valueSet()) {
                    String str = (String) key.getKey();
                    if (!str.equals("rowid")) {
                        columnCount = cursor.getColumnIndex(str);
                        if (columnCount == -1) {
                            return false;
                        }
                        if (contentValues.get(str) instanceof byte[]) {
                            byte[] bArr = (byte[]) contentValues.get(str);
                            byte[] blob = cursor.getBlob(columnCount);
                            if (!(bArr == null && blob == null)) {
                                if (bArr == null && blob != null) {
                                    size = 0;
                                    if (size != 0) {
                                        return false;
                                    }
                                } else if (bArr == null || blob != null) {
                                    if (bArr.length != blob.length) {
                                        size = 0;
                                    } else {
                                        for (columnCount = 0; columnCount < bArr.length; columnCount++) {
                                            if (bArr[columnCount] != blob[columnCount]) {
                                                size = 0;
                                                break;
                                            }
                                        }
                                    }
                                    if (size != 0) {
                                        return false;
                                    }
                                } else {
                                    size = 0;
                                    if (size != 0) {
                                        return false;
                                    }
                                }
                            }
                            size = 1;
                            if (size != 0) {
                                return false;
                            }
                        } else if (cursor.getString(columnCount) == null && contentValues.get(str) != null) {
                            return false;
                        } else {
                            if (contentValues.get(str) == null) {
                                return false;
                            }
                            if (!contentValues.get(str).toString().equals(cursor.getString(columnCount))) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            } catch (Throwable e) {
                v.a("MicroMsg.SDK.IAutoDBItem", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                return false;
            }
        }
    }
}
