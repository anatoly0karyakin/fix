package fixparser.fix5.group;

public class MdEntry {
	private char mDEntryType;
	private double mDEntryPx;
	private double mDEntrySize;
	private int mDEntryDate;
	private String mDEntryTime;
	
	public char getmDEntryType() {
		return mDEntryType;
	}
	public void setmDEntryType(char mDEntryType) {
		this.mDEntryType = mDEntryType;
	}
	public double getmDEntryPx() {
		return mDEntryPx;
	}
	public void setmDEntryPx(double mDEntryPx) {
		this.mDEntryPx = mDEntryPx;
	}
	public double getmDEntrySize() {
		return mDEntrySize;
	}
	public void setmDEntrySize(double mDEntrySize) {
		this.mDEntrySize = mDEntrySize;
	}
	public int getmDEntryDate() {
		return mDEntryDate;
	}
	public void setmDEntryDate(int mDEntryDate) {
		this.mDEntryDate = mDEntryDate;
	}
	public String getmDEntryTime() {
		return mDEntryTime;
	}
	public void setmDEntryTime(String mDEntryTime) {
		this.mDEntryTime = mDEntryTime;
	}
	@Override
	public String toString() {
		return "MdEntry [mDEntryType=" + mDEntryType + ", mDEntryPx=" + mDEntryPx + ", mDEntrySize=" + mDEntrySize
				+ ", mDEntryDate=" + mDEntryDate + ", mDEntryTime=" + mDEntryTime + "]";
	}
	
	
	
}
