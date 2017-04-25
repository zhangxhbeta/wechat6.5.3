package com.tencent.mmdb;

public class CrossProcessCursorWrapper extends CursorWrapper implements CrossProcessCursor {
    public CrossProcessCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public void fillWindow(int i, CursorWindow cursorWindow) {
        if (this.mCursor instanceof CrossProcessCursor) {
            ((CrossProcessCursor) this.mCursor).fillWindow(i, cursorWindow);
        } else {
            DatabaseUtils.cursorFillWindow(this.mCursor, i, cursorWindow);
        }
    }

    public CursorWindow getWindow() {
        if (this.mCursor instanceof CrossProcessCursor) {
            return ((CrossProcessCursor) this.mCursor).getWindow();
        }
        return null;
    }

    public boolean onMove(int i, int i2) {
        if (this.mCursor instanceof CrossProcessCursor) {
            return ((CrossProcessCursor) this.mCursor).onMove(i, i2);
        }
        return true;
    }
}
