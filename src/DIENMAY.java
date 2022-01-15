
public class DIENMAY extends MATHANG {
	
	
	
	public DIENMAY(String item_code,String item_name,  float amount, float unit_price,float discount, String date_sale,
			String manufacturer, String owncharacteristics) {
		super( item_code,item_name, amount, unit_price,discount, date_sale, manufacturer, owncharacteristics);
	}

	@Override
	float Cal() {
		float tt= (((getAmount()*getUnit_price()) * 0.1f) * ((100-getDiscount())/100)) ;
		return tt;
	}
	
}
