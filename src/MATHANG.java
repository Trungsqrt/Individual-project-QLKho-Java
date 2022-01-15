
public abstract class MATHANG {
	private String item_code, item_name, Manufacturer, date_sale, owncharacteristics;
	private float unit_price, amount, discount, VAT;
	
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getManufacturer() {
		return Manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.Manufacturer = manufacturer;
	}
	public String getDate_sale() {
		return date_sale;
	}
	public void setDate_sale(String date_sale) {
		this.date_sale = date_sale;
	}
	public float getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(float unit_price) {
		this.unit_price = unit_price;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
		
	public float getVAT() {
		return VAT;
	}
	public void setVAT(float VAT) {
		this.VAT = VAT;
	}
	
	public String getOwncharacteristics() {
		return owncharacteristics;
	}
	public void setOwncharacteristics(String owncharacteristics) {
		this.owncharacteristics = owncharacteristics;
	}
	public MATHANG() {
	}
	
	
	//overloading
	public MATHANG(String item_name, String item_code,float amount, float unit_price,float discount, 
			String date_sale, String manufacturer, String owncharacteristics) {
		setItem_name(item_name);
		setItem_code(item_code);
		setAmount(amount);
		setUnit_price(unit_price);
		setDiscount(discount);
		setDate_sale(date_sale);
		setManufacturer(manufacturer);
		setOwncharacteristics(owncharacteristics);
	}
	
	public MATHANG(String item_code, String item_name, String manufacturer,String owncharacteristics, String date_sale, float unit_price,
			float amount, float discount, float VAT) {
		this(item_name, item_code,amount,unit_price,discount,date_sale, manufacturer,owncharacteristics);
		this.VAT = VAT;
		this.discount = discount;
	}
	
	abstract float Cal();

}
