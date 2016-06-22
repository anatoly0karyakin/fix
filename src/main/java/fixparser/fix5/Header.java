package fixparser.fix5;

public class Header {
	private String beginString;
	private int bodyLength;
	private String senderCompID;
	private String targetCompID;
	private int msgSeqNum;

	public String getBeginString() {
		return beginString;
	}

	public void setBeginString(String beginString) {
		this.beginString = beginString;
	}

	public int getBodyLength() {
		return bodyLength;
	}

	public void setBodyLength(int bodyLength) {
		this.bodyLength = bodyLength;
	}

	public String getSenderCompID() {
		return senderCompID;
	}

	public void setSenderCompID(String senderCompID) {
		this.senderCompID = senderCompID;
	}

	public String getTargetCompID() {
		return targetCompID;
	}

	public void setTargetCompID(String targetCompID) {
		this.targetCompID = targetCompID;
	}

	public int getMsgSeqNum() {
		return msgSeqNum;
	}

	public void setMsgSeqNum(int msgSeqNum) {
		this.msgSeqNum = msgSeqNum;
	}

	@Override
	public String toString() {
		return "Header [beginString=" + beginString + ", bodyLength=" + bodyLength + ", senderCompID=" + senderCompID
				+ ", targetCompID=" + targetCompID + ", msgSeqNum=" + msgSeqNum + "]";
	}
	
}
