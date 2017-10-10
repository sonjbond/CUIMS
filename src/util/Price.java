package util;

public class Price {

	int sci_price;
	int sta_price;
	int tools_price;
	public Price(){
		sci_price = 500;
		sta_price=100;
		tools_price=200;
	}
	public int getSci_price() {
		return sci_price;
	}
	public int getSta_price() {
		return sta_price;
	}
	public int getTools_price() {
		return tools_price;
	}
	public void UpdatePrice( int sc, int st, int tl ) {
		sci_price = sc;
		sta_price = st;
		tools_price = tl;
	}

}
