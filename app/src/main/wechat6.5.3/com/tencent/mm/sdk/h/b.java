package com.tencent.mm.sdk.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class b {
    private static final Map<Class<?>, Object> caD = new HashMap();
    private static final Map<Class<?>, Object> caE = new HashMap();
    private static final Map<Class<?>, String> nma = new HashMap();

    static {
        try {
            caD.put(byte[].class, new Object() {
            });
            caD.put(Short.TYPE, new Object() {
            });
            caD.put(Short.class, new Object() {
            });
            caD.put(Boolean.TYPE, new Object() {
            });
            caD.put(Boolean.class, new Object() {
            });
            caD.put(Integer.TYPE, new Object() {
            });
            caD.put(Integer.class, new Object() {
            });
            caD.put(Float.TYPE, new Object() {
            });
            caD.put(Float.class, new Object() {
            });
            caD.put(Double.TYPE, new Object() {
            });
            caD.put(Double.class, new Object() {
            });
            caD.put(Long.TYPE, new Object() {
            });
            caD.put(Long.class, new Object() {
            });
            caD.put(String.class, new Object() {
            });
            caE.put(byte[].class, new Object() {
            });
            caE.put(Short.TYPE, new Object() {
            });
            caE.put(Short.class, new Object() {
            });
            caE.put(Boolean.TYPE, new Object() {
            });
            caE.put(Boolean.class, new Object() {
            });
            caE.put(Integer.TYPE, new Object() {
            });
            caE.put(Integer.class, new Object() {
            });
            caE.put(Float.TYPE, new Object() {
            });
            caE.put(Float.class, new Object() {
            });
            caE.put(Double.TYPE, new Object() {
            });
            caE.put(Double.class, new Object() {
            });
            caE.put(Long.TYPE, new Object() {
            });
            caE.put(Long.class, new Object() {
            });
            caE.put(String.class, new Object() {
            });
            nma.put(byte[].class, "BLOB");
            nma.put(Short.TYPE, "SHORT");
            nma.put(Short.class, "SHORT");
            nma.put(Boolean.TYPE, "INTEGER");
            nma.put(Boolean.class, "INTEGER");
            nma.put(Integer.TYPE, "INTEGER");
            nma.put(Integer.class, "INTEGER");
            nma.put(Float.TYPE, "FLOAT");
            nma.put(Float.class, "FLOAT");
            nma.put(Double.TYPE, "DOUBLE");
            nma.put(Double.class, "DOUBLE");
            nma.put(Long.TYPE, "LONG");
            nma.put(Long.class, "LONG");
            nma.put(String.class, "TEXT");
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static String n(Class<?> cls) {
        return (String) nma.get(cls);
    }

    public static void keep_setBlob(Field field, Object obj, Cursor cursor, int i) {
        try {
            field.set(obj, cursor.getBlob(i));
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void keep_getBlob(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.a(field), (byte[]) field.get(obj));
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void keep_setShort(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Short.TYPE)) {
                field.setShort(obj, cursor.getShort(i));
            } else {
                field.set(obj, Short.valueOf(cursor.getShort(i)));
            }
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void keep_getShort(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.a(field), Short.valueOf(field.getShort(obj)));
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void keep_setBoolean(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Boolean.TYPE)) {
                field.setBoolean(obj, cursor.getInt(i) != 0);
            } else {
                field.set(obj, Integer.valueOf(cursor.getInt(i)));
            }
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void keep_getBoolean(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.a(field), Integer.valueOf(field.getBoolean(obj) ? 1 : 0));
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void keep_setInt(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Integer.TYPE)) {
                field.setInt(obj, cursor.getInt(i));
            } else {
                field.set(obj, Integer.valueOf(cursor.getInt(i)));
            }
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void keep_getInt(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Integer.TYPE)) {
                contentValues.put(c.a(field), Integer.valueOf(field.getInt(obj)));
            } else {
                contentValues.put(c.a(field), (Integer) field.get(obj));
            }
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void keep_setFloat(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Float.TYPE)) {
                field.setFloat(obj, cursor.getFloat(i));
            } else {
                field.set(obj, Float.valueOf(cursor.getFloat(i)));
            }
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void keep_getFloat(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Float.TYPE)) {
                contentValues.put(c.a(field), Float.valueOf(field.getFloat(obj)));
            } else {
                contentValues.put(c.a(field), (Float) field.get(obj));
            }
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void keep_setDouble(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Double.TYPE)) {
                field.setDouble(obj, cursor.getDouble(i));
            } else {
                field.set(obj, Double.valueOf(cursor.getDouble(i)));
            }
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void keep_getDouble(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Double.TYPE)) {
                contentValues.put(c.a(field), Double.valueOf(field.getDouble(obj)));
            } else {
                contentValues.put(c.a(field), (Double) field.get(obj));
            }
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void keep_setLong(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Long.TYPE)) {
                field.setLong(obj, cursor.getLong(i));
            } else {
                field.set(obj, Long.valueOf(cursor.getLong(i)));
            }
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void keep_getLong(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Long.TYPE)) {
                contentValues.put(c.a(field), Long.valueOf(field.getLong(obj)));
            } else {
                contentValues.put(c.a(field), (Long) field.get(obj));
            }
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void keep_setString(Field field, Object obj, Cursor cursor, int i) {
        try {
            field.set(obj, cursor.getString(i));
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void keep_getString(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.a(field), (String) field.get(obj));
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.CursorFieldHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }
}
