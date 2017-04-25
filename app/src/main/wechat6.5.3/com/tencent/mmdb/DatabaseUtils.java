package com.tencent.mmdb;

import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.mmdb.database.SQLiteAbortException;
import com.tencent.mmdb.database.SQLiteConstraintException;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDatabase.Arithmetic;
import com.tencent.mmdb.database.SQLiteDatabase.LockedDevice;
import com.tencent.mmdb.database.SQLiteDatabaseCorruptException;
import com.tencent.mmdb.database.SQLiteDiskIOException;
import com.tencent.mmdb.database.SQLiteException;
import com.tencent.mmdb.database.SQLiteFullException;
import com.tencent.mmdb.database.SQLiteProgram;
import com.tencent.mmdb.database.SQLiteStatement;
import com.tencent.mmdb.support.Log;
import com.tencent.mmdb.support.OperationCanceledException;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;

public class DatabaseUtils {
    private static final boolean DEBUG = false;
    private static final char[] DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int EX_HAS_REPLY_HEADER = -128;
    private static final Locale ROOT = new Locale(SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
    public static final int STATEMENT_ABORT = 6;
    public static final int STATEMENT_ATTACH = 3;
    public static final int STATEMENT_BEGIN = 4;
    public static final int STATEMENT_COMMIT = 5;
    public static final int STATEMENT_DDL = 8;
    public static final int STATEMENT_OTHER = 99;
    public static final int STATEMENT_PRAGMA = 7;
    public static final int STATEMENT_SELECT = 1;
    public static final int STATEMENT_UNPREPARED = 9;
    public static final int STATEMENT_UPDATE = 2;
    private static final String TAG = "DatabaseUtils";
    private static Collator mColl = null;

    @Deprecated
    public static class InsertHelper {
        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
        private HashMap<String, Integer> mColumns;
        private final SQLiteDatabase mDb;
        private String mInsertSQL = null;
        private SQLiteStatement mInsertStatement = null;
        private SQLiteStatement mPreparedStatement = null;
        private SQLiteStatement mReplaceStatement = null;
        private final String mTableName;

        public InsertHelper(SQLiteDatabase sQLiteDatabase, String str) {
            this.mDb = sQLiteDatabase;
            this.mTableName = str;
        }

        private void buildSQL() {
            Cursor cursor = null;
            StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
            stringBuilder.append("INSERT INTO ");
            stringBuilder.append(this.mTableName);
            stringBuilder.append(" (");
            CharSequence stringBuilder2 = new StringBuilder(FileUtils.S_IWUSR);
            stringBuilder2.append("VALUES (");
            try {
                cursor = this.mDb.rawQuery("PRAGMA table_info(" + this.mTableName + ")", null);
                this.mColumns = new HashMap(cursor.getCount());
                int i = 1;
                while (cursor.moveToNext()) {
                    String string = cursor.getString(1);
                    String string2 = cursor.getString(4);
                    this.mColumns.put(string, Integer.valueOf(i));
                    stringBuilder.append("'");
                    stringBuilder.append(string);
                    stringBuilder.append("'");
                    if (string2 == null) {
                        stringBuilder2.append("?");
                    } else {
                        stringBuilder2.append("COALESCE(?, ");
                        stringBuilder2.append(string2);
                        stringBuilder2.append(")");
                    }
                    stringBuilder.append(i == cursor.getCount() ? ") " : ", ");
                    stringBuilder2.append(i == cursor.getCount() ? ");" : ", ");
                    i++;
                }
                stringBuilder.append(stringBuilder2);
                this.mInsertSQL = stringBuilder.toString();
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        private SQLiteStatement getStatement(boolean z) {
            if (z) {
                if (this.mReplaceStatement == null) {
                    if (this.mInsertSQL == null) {
                        buildSQL();
                    }
                    this.mReplaceStatement = this.mDb.compileStatement("INSERT OR REPLACE" + this.mInsertSQL.substring(6));
                }
                return this.mReplaceStatement;
            }
            if (this.mInsertStatement == null) {
                if (this.mInsertSQL == null) {
                    buildSQL();
                }
                this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
            }
            return this.mInsertStatement;
        }

        private long insertInternal(ContentValues contentValues, boolean z) {
            long executeInsert;
            this.mDb.beginTransactionNonExclusive();
            try {
                SQLiteProgram statement = getStatement(z);
                statement.clearBindings();
                for (Entry entry : contentValues.valueSet()) {
                    DatabaseUtils.bindObjectToProgram(statement, getColumnIndex((String) entry.getKey()), entry.getValue());
                }
                executeInsert = statement.executeInsert();
                this.mDb.setTransactionSuccessful();
            } catch (SQLException e) {
                Log.e(DatabaseUtils.TAG, "Error inserting " + contentValues + " into table  " + this.mTableName, e);
                return -1;
            } finally {
                this.mDb.endTransaction();
            }
            return executeInsert;
        }

        public int getColumnIndex(String str) {
            getStatement(false);
            Integer num = (Integer) this.mColumns.get(str);
            if (num != null) {
                return num.intValue();
            }
            throw new IllegalArgumentException("column '" + str + "' is invalid");
        }

        public void bind(int i, double d) {
            this.mPreparedStatement.bindDouble(i, d);
        }

        public void bind(int i, float f) {
            this.mPreparedStatement.bindDouble(i, (double) f);
        }

        public void bind(int i, long j) {
            this.mPreparedStatement.bindLong(i, j);
        }

        public void bind(int i, int i2) {
            this.mPreparedStatement.bindLong(i, (long) i2);
        }

        public void bind(int i, boolean z) {
            this.mPreparedStatement.bindLong(i, z ? 1 : 0);
        }

        public void bindNull(int i) {
            this.mPreparedStatement.bindNull(i);
        }

        public void bind(int i, byte[] bArr) {
            if (bArr == null) {
                this.mPreparedStatement.bindNull(i);
            } else {
                this.mPreparedStatement.bindBlob(i, bArr);
            }
        }

        public void bind(int i, String str) {
            if (str == null) {
                this.mPreparedStatement.bindNull(i);
            } else {
                this.mPreparedStatement.bindString(i, str);
            }
        }

        public long insert(ContentValues contentValues) {
            return insertInternal(contentValues, false);
        }

        public long execute() {
            if (this.mPreparedStatement == null) {
                throw new IllegalStateException("you must prepare this inserter before calling execute");
            }
            long executeInsert;
            try {
                executeInsert = this.mPreparedStatement.executeInsert();
                return executeInsert;
            } catch (SQLException e) {
                executeInsert = e;
                Log.e(DatabaseUtils.TAG, "Error executing InsertHelper with table " + this.mTableName, executeInsert);
                return -1;
            } finally {
                this.mPreparedStatement = null;
            }
        }

        public void prepareForInsert() {
            this.mPreparedStatement = getStatement(false);
            this.mPreparedStatement.clearBindings();
        }

        public void prepareForReplace() {
            this.mPreparedStatement = getStatement(true);
            this.mPreparedStatement.clearBindings();
        }

        public long replace(ContentValues contentValues) {
            return insertInternal(contentValues, true);
        }

        public void close() {
            if (this.mInsertStatement != null) {
                this.mInsertStatement.close();
                this.mInsertStatement = null;
            }
            if (this.mReplaceStatement != null) {
                this.mReplaceStatement.close();
                this.mReplaceStatement = null;
            }
            this.mInsertSQL = null;
            this.mColumns = null;
        }
    }

    public static final void writeExceptionToParcel(Parcel parcel, Exception exception) {
        int i;
        int i2;
        if (exception instanceof FileNotFoundException) {
            i = 0;
            i2 = 1;
        } else if (exception instanceof IllegalArgumentException) {
            i2 = 2;
            i = 1;
        } else if (exception instanceof UnsupportedOperationException) {
            i2 = 3;
            i = 1;
        } else if (exception instanceof SQLiteAbortException) {
            i2 = 4;
            i = 1;
        } else if (exception instanceof SQLiteConstraintException) {
            i2 = 5;
            i = 1;
        } else if (exception instanceof SQLiteDatabaseCorruptException) {
            i2 = 6;
            i = 1;
        } else if (exception instanceof SQLiteFullException) {
            i2 = 7;
            i = 1;
        } else if (exception instanceof SQLiteDiskIOException) {
            i2 = 8;
            i = 1;
        } else if (exception instanceof SQLiteException) {
            i2 = 9;
            i = 1;
        } else if (exception instanceof OperationApplicationException) {
            i2 = 10;
            i = 1;
        } else if (exception instanceof OperationCanceledException) {
            i2 = 11;
            i = 0;
        } else {
            parcel.writeException(exception);
            Log.e(TAG, "Writing exception to parcel", exception);
            return;
        }
        parcel.writeInt(i2);
        parcel.writeString(exception.getMessage());
        if (i != 0) {
            Log.e(TAG, "Writing exception to parcel", exception);
        }
    }

    private static final int readExceptionCode(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt != EX_HAS_REPLY_HEADER) {
            return readInt;
        }
        if (parcel.readInt() == 0) {
            Log.e(TAG, "Unexpected zero-sized Parcel reply header.");
        }
        return 0;
    }

    public static final void readExceptionFromParcel(Parcel parcel) {
        int readExceptionCode = readExceptionCode(parcel);
        if (readExceptionCode != 0) {
            readExceptionFromParcel(parcel, parcel.readString(), readExceptionCode);
        }
    }

    public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel parcel) {
        int readExceptionCode = readExceptionCode(parcel);
        if (readExceptionCode != 0) {
            String readString = parcel.readString();
            if (readExceptionCode == 1) {
                throw new FileNotFoundException(readString);
            }
            readExceptionFromParcel(parcel, readString, readExceptionCode);
        }
    }

    public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel parcel) {
        int readExceptionCode = readExceptionCode(parcel);
        if (readExceptionCode != 0) {
            String readString = parcel.readString();
            if (readExceptionCode == 10) {
                throw new OperationApplicationException(readString);
            }
            readExceptionFromParcel(parcel, readString, readExceptionCode);
        }
    }

    private static final void readExceptionFromParcel(Parcel parcel, String str, int i) {
        switch (i) {
            case 2:
                throw new IllegalArgumentException(str);
            case 3:
                throw new UnsupportedOperationException(str);
            case 4:
                throw new SQLiteAbortException(str);
            case 5:
                throw new SQLiteConstraintException(str);
            case 6:
                throw new SQLiteDatabaseCorruptException(str);
            case 7:
                throw new SQLiteFullException(str);
            case 8:
                throw new SQLiteDiskIOException(str);
            case 9:
                throw new SQLiteException(str);
            case 11:
                throw new OperationCanceledException(str);
            default:
                parcel.readException(i, str);
                return;
        }
    }

    public static void bindObjectToProgram(SQLiteProgram sQLiteProgram, int i, Object obj) {
        if (obj == null) {
            sQLiteProgram.bindNull(i);
        } else if ((obj instanceof Double) || (obj instanceof Float)) {
            sQLiteProgram.bindDouble(i, ((Number) obj).doubleValue());
        } else if (obj instanceof Number) {
            sQLiteProgram.bindLong(i, ((Number) obj).longValue());
        } else if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                sQLiteProgram.bindLong(i, 1);
            } else {
                sQLiteProgram.bindLong(i, 0);
            }
        } else if (obj instanceof byte[]) {
            sQLiteProgram.bindBlob(i, (byte[]) obj);
        } else {
            sQLiteProgram.bindString(i, obj.toString());
        }
    }

    public static int getTypeOfObject(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return 4;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return 2;
        }
        if ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
            return 1;
        }
        return 3;
    }

    public static void cursorFillWindow(Cursor cursor, int i, CursorWindow cursorWindow) {
        if (i >= 0 && i < cursor.getCount()) {
            int position = cursor.getPosition();
            int columnCount = cursor.getColumnCount();
            cursorWindow.clear();
            cursorWindow.setStartPosition(i);
            cursorWindow.setNumColumns(columnCount);
            if (cursor.moveToPosition(i)) {
                while (cursorWindow.allocRow()) {
                    int i2 = 0;
                    while (i2 < columnCount) {
                        boolean putNull;
                        switch (cursor.getType(i2)) {
                            case 0:
                                putNull = cursorWindow.putNull(i, i2);
                                break;
                            case 1:
                                putNull = cursorWindow.putLong(cursor.getLong(i2), i, i2);
                                break;
                            case 2:
                                putNull = cursorWindow.putDouble(cursor.getDouble(i2), i, i2);
                                break;
                            case 4:
                                byte[] blob = cursor.getBlob(i2);
                                if (blob == null) {
                                    putNull = cursorWindow.putNull(i, i2);
                                    break;
                                } else {
                                    putNull = cursorWindow.putBlob(blob, i, i2);
                                    break;
                                }
                            default:
                                String string = cursor.getString(i2);
                                if (string == null) {
                                    putNull = cursorWindow.putNull(i, i2);
                                    break;
                                } else {
                                    putNull = cursorWindow.putString(string, i, i2);
                                    break;
                                }
                        }
                        if (putNull) {
                            i2++;
                        } else {
                            cursorWindow.freeLastRow();
                            i++;
                            if (!cursor.moveToNext()) {
                            }
                        }
                    }
                    i++;
                    if (cursor.moveToNext()) {
                    }
                }
            }
            cursor.moveToPosition(position);
        }
    }

    public static void appendEscapedSQLString(StringBuilder stringBuilder, String str) {
        stringBuilder.append('\'');
        if (str.indexOf(39) != -1) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt == '\'') {
                    stringBuilder.append('\'');
                }
                stringBuilder.append(charAt);
            }
        } else {
            stringBuilder.append(str);
        }
        stringBuilder.append('\'');
    }

    public static String sqlEscapeString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        appendEscapedSQLString(stringBuilder, str);
        return stringBuilder.toString();
    }

    public static final void appendValueToSql(StringBuilder stringBuilder, Object obj) {
        if (obj == null) {
            stringBuilder.append("NULL");
        } else if (!(obj instanceof Boolean)) {
            appendEscapedSQLString(stringBuilder, obj.toString());
        } else if (((Boolean) obj).booleanValue()) {
            stringBuilder.append('1');
        } else {
            stringBuilder.append('0');
        }
    }

    public static String concatenateWhere(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return "(" + str + ") AND (" + str2 + ")";
    }

    public static String getCollationKey(String str) {
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        try {
            return new String(collationKeyInBytes, 0, getKeyLen(collationKeyInBytes), "ISO8859_1");
        } catch (Exception e) {
            return SQLiteDatabase.KeyEmpty;
        }
    }

    private static char[] encodeHex(byte[] bArr) {
        int i = 0;
        int length = bArr.length;
        char[] cArr = new char[(length << 1)];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr[i] = DIGITS[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = DIGITS[bArr[i2] & 15];
        }
        return cArr;
    }

    public static String getHexCollationKey(String str) {
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        return new String(encodeHex(collationKeyInBytes), 0, getKeyLen(collationKeyInBytes) * 2);
    }

    private static int getKeyLen(byte[] bArr) {
        if (bArr[bArr.length - 1] != (byte) 0) {
            return bArr.length;
        }
        return bArr.length - 1;
    }

    private static byte[] getCollationKeyInBytes(String str) {
        if (mColl == null) {
            Collator instance = Collator.getInstance();
            mColl = instance;
            instance.setStrength(0);
        }
        return mColl.getCollationKey(str).toByteArray();
    }

    public static void dumpCursor(Cursor cursor) {
        dumpCursor(cursor, System.out);
    }

    public static void dumpCursor(Cursor cursor, PrintStream printStream) {
        printStream.println(">>>>> Dumping cursor " + cursor);
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, printStream);
            }
            cursor.moveToPosition(position);
        }
        printStream.println("<<<<<");
    }

    public static void dumpCursor(Cursor cursor, StringBuilder stringBuilder) {
        stringBuilder.append(">>>>> Dumping cursor " + cursor + "\n");
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, stringBuilder);
            }
            cursor.moveToPosition(position);
        }
        stringBuilder.append("<<<<<\n");
    }

    public static String dumpCursorToString(Cursor cursor) {
        StringBuilder stringBuilder = new StringBuilder();
        dumpCursor(cursor, stringBuilder);
        return stringBuilder.toString();
    }

    public static void dumpCurrentRow(Cursor cursor) {
        dumpCurrentRow(cursor, System.out);
    }

    public static void dumpCurrentRow(Cursor cursor, PrintStream printStream) {
        String[] columnNames = cursor.getColumnNames();
        printStream.println(cursor.getPosition() + " {");
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            String string;
            try {
                string = cursor.getString(i);
            } catch (SQLiteException e) {
                string = "<unprintable>";
            }
            printStream.println("   " + columnNames[i] + '=' + string);
        }
        printStream.println("}");
    }

    public static void dumpCurrentRow(Cursor cursor, StringBuilder stringBuilder) {
        String[] columnNames = cursor.getColumnNames();
        stringBuilder.append(cursor.getPosition() + " {\n");
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            String string;
            try {
                string = cursor.getString(i);
            } catch (SQLiteException e) {
                string = "<unprintable>";
            }
            stringBuilder.append("   " + columnNames[i] + '=' + string + "\n");
        }
        stringBuilder.append("}\n");
    }

    public static String dumpCurrentRowToString(Cursor cursor) {
        StringBuilder stringBuilder = new StringBuilder();
        dumpCurrentRow(cursor, stringBuilder);
        return stringBuilder.toString();
    }

    public static void cursorStringToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorStringToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorStringToInsertHelper(Cursor cursor, String str, InsertHelper insertHelper, int i) {
        insertHelper.bind(i, cursor.getString(cursor.getColumnIndexOrThrow(str)));
    }

    public static void cursorStringToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        contentValues.put(str2, cursor.getString(cursor.getColumnIndexOrThrow(str)));
    }

    public static void cursorIntToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorIntToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorIntToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (cursor.isNull(columnIndex)) {
            contentValues.put(str2, null);
        } else {
            contentValues.put(str2, Integer.valueOf(cursor.getInt(columnIndex)));
        }
    }

    public static void cursorLongToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorLongToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorLongToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (cursor.isNull(columnIndex)) {
            contentValues.put(str2, null);
        } else {
            contentValues.put(str2, Long.valueOf(cursor.getLong(columnIndex)));
        }
    }

    public static void cursorDoubleToCursorValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorDoubleToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorDoubleToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (cursor.isNull(columnIndex)) {
            contentValues.put(str2, null);
        } else {
            contentValues.put(str2, Double.valueOf(cursor.getDouble(columnIndex)));
        }
    }

    public static void cursorRowToContentValues(Cursor cursor, ContentValues contentValues) {
        AbstractWindowedCursor abstractWindowedCursor = cursor instanceof AbstractWindowedCursor ? (AbstractWindowedCursor) cursor : null;
        String[] columnNames = cursor.getColumnNames();
        int length = columnNames.length;
        int i = 0;
        while (i < length) {
            if (abstractWindowedCursor == null || !abstractWindowedCursor.isBlob(i)) {
                contentValues.put(columnNames[i], cursor.getString(i));
            } else {
                contentValues.put(columnNames[i], cursor.getBlob(i));
            }
            i++;
        }
    }

    public static int cursorPickFillWindowStartPosition(int i, int i2) {
        return Math.max(i - (i2 / 3), 0);
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str) {
        return queryNumEntries(sQLiteDatabase, str, null, null);
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        return queryNumEntries(sQLiteDatabase, str, str2, null);
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        return longForQuery(sQLiteDatabase, "select count(*) from " + str + (!TextUtils.isEmpty(str2) ? " where " + str2 : SQLiteDatabase.KeyEmpty), strArr);
    }

    public static boolean queryIsEmpty(SQLiteDatabase sQLiteDatabase, String str) {
        return longForQuery(sQLiteDatabase, new StringBuilder("select exists(select 1 from ").append(str).append(")").toString(), null) == 0;
    }

    public static long longForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            long longForQuery = longForQuery(compileStatement, strArr);
            return longForQuery;
        } finally {
            compileStatement.close();
        }
    }

    public static long longForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        sQLiteStatement.bindAllArgsAsStrings(strArr);
        return sQLiteStatement.simpleQueryForLong();
    }

    public static String stringForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            String stringForQuery = stringForQuery(compileStatement, strArr);
            return stringForQuery;
        } finally {
            compileStatement.close();
        }
    }

    public static String stringForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        sQLiteStatement.bindAllArgsAsStrings(strArr);
        return sQLiteStatement.simpleQueryForString();
    }

    public static void cursorStringToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, cursor.getString(columnIndex));
        }
    }

    public static void cursorLongToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, Long.valueOf(cursor.getLong(columnIndex)));
        }
    }

    public static void cursorShortToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, Short.valueOf(cursor.getShort(columnIndex)));
        }
    }

    public static void cursorIntToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, Integer.valueOf(cursor.getInt(columnIndex)));
        }
    }

    public static void cursorFloatToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, Float.valueOf(cursor.getFloat(columnIndex)));
        }
    }

    public static void cursorDoubleToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex != -1 && !cursor.isNull(columnIndex)) {
            contentValues.put(str, Double.valueOf(cursor.getDouble(columnIndex)));
        }
    }

    public static void createDbFromSqlStatements(Context context, String str, LockedDevice lockedDevice, byte[] bArr, Arithmetic arithmetic, int i, String str2) {
        int i2 = 0;
        SQLiteDatabase openOrCreateDatabase = com.tencent.mmdb.support.Context.openOrCreateDatabase(context, str, lockedDevice, bArr, arithmetic, 0, null, false);
        String[] split = TextUtils.split(str2, ";\n");
        int length = split.length;
        while (i2 < length) {
            Object obj = split[i2];
            if (!TextUtils.isEmpty(obj)) {
                openOrCreateDatabase.execSQL(obj);
            }
            i2++;
        }
        openOrCreateDatabase.setVersion(i);
        openOrCreateDatabase.close();
    }

    public static void createDbFromSqlStatements(Context context, String str, int i, String str2) {
        createDbFromSqlStatements(context, str, LockedDevice.DEFAULT, null, Arithmetic.UNKNOWN, i, str2);
    }

    public static int getSqlStatementType(String str) {
        String trim = str.trim();
        if (trim.length() < 3) {
            return 99;
        }
        trim = trim.substring(0, 3).toUpperCase(ROOT);
        if (trim.equals("SEL")) {
            return 1;
        }
        if (trim.equals("INS") || trim.equals("UPD") || trim.equals("REP") || trim.equals("DEL")) {
            return 2;
        }
        if (trim.equals("ATT")) {
            return 3;
        }
        if (trim.equals("COM")) {
            return 5;
        }
        if (trim.equals("END")) {
            return 5;
        }
        if (trim.equals("ROL")) {
            return 6;
        }
        if (trim.equals("BEG")) {
            return 4;
        }
        if (trim.equals("PRA")) {
            return 7;
        }
        if (trim.equals("CRE") || trim.equals("DRO") || trim.equals("ALT")) {
            return 8;
        }
        if (trim.equals("ANA") || trim.equals("DET")) {
            return 9;
        }
        return 99;
    }

    public static String[] appendSelectionArgs(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0) {
            return strArr2;
        }
        Object obj = new String[(strArr.length + strArr2.length)];
        System.arraycopy(strArr, 0, obj, 0, strArr.length);
        System.arraycopy(strArr2, 0, obj, strArr.length, strArr2.length);
        return obj;
    }

    public static int findRowIdColumnIndex(String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (strArr[i].equals("_id")) {
                return i;
            }
        }
        return -1;
    }
}
