package com.tencent.mmdb;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;

public class MergeCursor extends AbstractCursor {
    private Cursor mCursor;
    private Cursor[] mCursors;
    private DataSetObserver mObserver = new DataSetObserver() {
        public void onChanged() {
            MergeCursor.this.mPos = -1;
        }

        public void onInvalidated() {
            MergeCursor.this.mPos = -1;
        }
    };

    public MergeCursor(Cursor[] cursorArr) {
        int i = 0;
        this.mCursors = cursorArr;
        this.mCursor = cursorArr[0];
        while (i < this.mCursors.length) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].registerDataSetObserver(this.mObserver);
            }
            i++;
        }
    }

    public int getCount() {
        int i = 0;
        int length = this.mCursors.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.mCursors[i2] != null) {
                i += this.mCursors[i2].getCount();
            }
        }
        return i;
    }

    public boolean onMove(int i, int i2) {
        this.mCursor = null;
        int length = this.mCursors.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.mCursors[i4] != null) {
                if (i2 < this.mCursors[i4].getCount() + i3) {
                    this.mCursor = this.mCursors[i4];
                    break;
                }
                i3 += this.mCursors[i4].getCount();
            }
        }
        if (this.mCursor != null) {
            return this.mCursor.moveToPosition(i2 - i3);
        }
        return false;
    }

    public String getString(int i) {
        return this.mCursor.getString(i);
    }

    public short getShort(int i) {
        return this.mCursor.getShort(i);
    }

    public int getInt(int i) {
        return this.mCursor.getInt(i);
    }

    public long getLong(int i) {
        return this.mCursor.getLong(i);
    }

    public float getFloat(int i) {
        return this.mCursor.getFloat(i);
    }

    public double getDouble(int i) {
        return this.mCursor.getDouble(i);
    }

    public int getType(int i) {
        return this.mCursor.getType(i);
    }

    public boolean isNull(int i) {
        return this.mCursor.isNull(i);
    }

    public byte[] getBlob(int i) {
        return this.mCursor.getBlob(i);
    }

    public String[] getColumnNames() {
        if (this.mCursor != null) {
            return this.mCursor.getColumnNames();
        }
        return new String[0];
    }

    public void deactivate() {
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].deactivate();
            }
        }
        super.deactivate();
    }

    public void close() {
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].close();
            }
        }
        super.close();
    }

    public void registerContentObserver(ContentObserver contentObserver) {
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].registerContentObserver(contentObserver);
            }
        }
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].unregisterContentObserver(contentObserver);
            }
        }
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        int length = this.mCursors.length;
        for (int i = 0; i < length; i++) {
            if (this.mCursors[i] != null) {
                this.mCursors[i].unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public boolean requery() {
        int length = this.mCursors.length;
        int i = 0;
        while (i < length) {
            if (this.mCursors[i] != null && !this.mCursors[i].requery()) {
                return false;
            }
            i++;
        }
        return true;
    }

    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }

    public void registerContentObserver(ContentObserver contentObserver) {
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }
}
