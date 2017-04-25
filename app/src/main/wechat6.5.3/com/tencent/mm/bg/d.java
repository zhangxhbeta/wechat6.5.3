package com.tencent.mm.bg;

import android.database.AbstractCursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import com.tencent.mm.sdk.platformtools.be;

public final class d extends AbstractCursor {
    private final int columnCount;
    private final String[] columnNames;
    private Object[] data;
    private int rowCount;

    private d(String[] strArr) {
        this.rowCount = 0;
        this.columnNames = strArr;
        this.columnCount = strArr.length;
        this.data = new Object[(this.columnCount * 16)];
    }

    public d(String[] strArr, byte b) {
        this(strArr);
    }

    private Object get(int i) {
        if (i < 0 || i >= this.columnCount) {
            throw new CursorIndexOutOfBoundsException("Requested column: " + i + ", # of columns: " + this.columnCount);
        } else if (this.mPos < 0) {
            throw new CursorIndexOutOfBoundsException("Before first row.");
        } else if (this.mPos < this.rowCount) {
            return this.data[(this.mPos * this.columnCount) + i];
        } else {
            throw new CursorIndexOutOfBoundsException("After last row.");
        }
    }

    public final void addRow(Object[] objArr) {
        if (objArr.length != this.columnCount) {
            throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.length = " + objArr.length);
        }
        int i = this.rowCount;
        this.rowCount = i + 1;
        int i2 = i * this.columnCount;
        i = this.columnCount + i2;
        if (i > this.data.length) {
            Object obj = this.data;
            int length = this.data.length * 2;
            if (length >= i) {
                i = length;
            }
            this.data = new Object[i];
            System.arraycopy(obj, 0, this.data, 0, obj.length);
        }
        System.arraycopy(objArr, 0, this.data, i2, this.columnCount);
    }

    public final int getCount() {
        return this.rowCount;
    }

    public final String[] getColumnNames() {
        return this.columnNames;
    }

    public final String getString(int i) {
        Object obj = get(i);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public final short getShort(int i) {
        Object obj = get(i);
        if (obj == null) {
            return (short) 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).shortValue();
        }
        return Short.parseShort(obj.toString());
    }

    public final int getInt(int i) {
        Object obj = get(i);
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        return be.getInt(obj.toString(), 0);
    }

    public final long getLong(int i) {
        Object obj = get(i);
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        return be.getLong(obj.toString(), 0);
    }

    public final float getFloat(int i) {
        Object obj = get(i);
        if (obj == null) {
            return 0.0f;
        }
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        return be.getFloat(obj.toString(), 0.0f);
    }

    public final double getDouble(int i) {
        Object obj = get(i);
        if (obj == null) {
            return 0.0d;
        }
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        return be.getDouble(obj.toString(), 0.0d);
    }

    public final byte[] getBlob(int i) {
        return (byte[]) get(i);
    }

    public final int getType(int i) {
        return bj(get(i));
    }

    public final boolean isNull(int i) {
        return get(i) == null;
    }

    private static int bj(Object obj) {
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

    public final void fillWindow(int i, CursorWindow cursorWindow) {
        if (i >= 0 && i < getCount()) {
            cursorWindow.acquireReference();
            try {
                int position = getPosition();
                int columnCount = getColumnCount();
                cursorWindow.clear();
                cursorWindow.setStartPosition(i);
                cursorWindow.setNumColumns(columnCount);
                if (moveToPosition(i)) {
                    while (cursorWindow.allocRow()) {
                        int i2 = 0;
                        while (i2 < columnCount) {
                            boolean putNull;
                            switch (bj(get(i2))) {
                                case 0:
                                    putNull = cursorWindow.putNull(i, i2);
                                    break;
                                case 1:
                                    putNull = cursorWindow.putLong(getLong(i2), i, i2);
                                    break;
                                case 2:
                                    putNull = cursorWindow.putDouble(getDouble(i2), i, i2);
                                    break;
                                case 4:
                                    byte[] blob = getBlob(i2);
                                    if (blob == null) {
                                        putNull = cursorWindow.putNull(i, i2);
                                        break;
                                    } else {
                                        putNull = cursorWindow.putBlob(blob, i, i2);
                                        break;
                                    }
                                default:
                                    String string = getString(i2);
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
                                if (!moveToNext()) {
                                }
                            }
                        }
                        i++;
                        if (moveToNext()) {
                        }
                    }
                }
                moveToPosition(position);
            } catch (IllegalStateException e) {
            } finally {
                cursorWindow.releaseReference();
            }
        }
    }
}
