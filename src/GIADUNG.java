
public class GIADUNG extends MATHANG {

	public GIADUNG( String item_code,String item_name, float amount, float unit_price, float discount, String date_sale,
			String manufacturer, String owncharacteristics) {
		super(item_code,item_name, amount, unit_price, discount, date_sale, manufacturer, owncharacteristics);
	}

	public float Cal() {
		return( (( getAmount()*getUnit_price() ) * 0.05f)* ((100-getDiscount())/100) );
	}
	
}
