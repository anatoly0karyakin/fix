package fixparser;

import fixparser.adapter.Adapter;
import fixparser.adapter.ReflectiveTypeAdapter;
import fixparser.fix5.MarketDataSnapshotFullRefresh;
import fixparser.stream.Reader;

public class FixParser {
	public static void main(String[] args) {
//		String str = "{name=tolik,age=23}";
//		Gson gson = new Gson();
//		User user = gson.fromJson(str, User.class);
//		System.out.println(user);
		
		FixParser parser = new FixParser();
		
//		String nsoFix = "8=FIX.4.2|9=130|35=D|34=659|49=BROKER04|56=REUTERS|52=20070123-19:09:43|38=1000|59=1|100=N|40=1|11=ORD10001|60=20070123-19:01:17|55=HPQ|54=1|21=2|10=004|";
//		NewSingleOrder nso = parser.fromFix(nsoFix, NewSingleOrder.class);
//		System.out.println(nso);
		
		String mdSnapshotFix = "8=FIX.4.4|9=234|35=W|34=113|49=BTCC-PRO-EXCHANGE-SERVER|52=20140902-09:45:42.282|56=BTCC-FIX-CLIENT|55=XBTCNY|268=8|269=0|270=2920.94|272=20140902|273=09:45:39.052|269=1|270=2921.32|269=2|270=2921.31|272=20140902|273=09:45:39.052|269=5|270=2937.21|272=20140902|273=09:45:39.052|269=7|270=2963.5|272=20140902|273=09:45:39.052|269=8|270=2873|272=20140902|273=09:45:39.052|269=9|270=2911.14|272=20140902|273=09:45:39.052|269=B|271=18628.18|272=20140902|273=09:45:39.052|262=123|10=195";
		MarketDataSnapshotFullRefresh mdW = parser.fromFix(mdSnapshotFix, MarketDataSnapshotFullRefresh.class);
		System.out.println(mdW);
	}
	
	public <T> T fromFix(String json, Class<T> typeOfT) {
		T target = (T) fromFix(new Reader(json), typeOfT);
		return target;
	}
	
	public <T> T fromFix(Reader reader, Class<T> typeOfT) {
		return getAdatper(typeOfT).read(reader.tags());
	}
	
	private <T> Adapter<T> getAdatper(Class<T> typeOfT) {
		return new ReflectiveTypeAdapter<T>(typeOfT);
	}
	
}
