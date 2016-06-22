package fixparser.fix5;

import java.util.List;

import fixparser.fix5.group.MdEntry;

public class MarketDataSnapshotFullRefresh extends Header {
	
	private String mDReqID;
	private String symbol;
	private List<MdEntry> noMDEntries;
	
	@Override
	public String toString() {
		return "MarketDataSnapshotFullRefresh [mDReqID=" + mDReqID + ", symbol=" + symbol + ", noMDEntries="
				+ noMDEntries + "]";
	}
}
