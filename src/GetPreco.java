import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GetPreco {
	private float usd;
	private float ars;
	private float eur;
	private float gbp;
	private float clp;
	
	private float brlusd;
	private float brlars;
	private float brleur;
	private float brlgbp;
	private float brlclp;
	
	public GetPreco() {
		// DÓLAR PARA REAL
		try {
			Document doc = Jsoup.connect("https://finance.yahoo.com/quote/BRL=X?p=BRL=X&.tsrc=fin-srch").get();
			String usdString = doc.getElementsByClass("Fw(b) Fz(36px) Mb(-4px) D(ib)").text();
			setUsd(Float.parseFloat(usdString.substring(0, usdString.length() - 1) + "f"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// PESO ARGENTINO PARA REAL
		try {
			Document doc = Jsoup.connect("https://finance.yahoo.com/quote/ARSBRL=X?p=ARSBRL=X&.tsrc=fin-srch").get();
			String arsString = doc.getElementsByClass("Fw(b) Fz(36px) Mb(-4px) D(ib)").text();
			setArs(Float.parseFloat(arsString.substring(0, arsString.length() - 1) + "f"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// EURO PARA REAL
		try {
			Document doc = Jsoup.connect("https://finance.yahoo.com/quote/EURBRL=X?p=EURBRL=X&.tsrc=fin-srch").get();
			String eurString = doc.getElementsByClass("Fw(b) Fz(36px) Mb(-4px) D(ib)").text();
			setEur(Float.parseFloat(eurString.substring(0, eurString.length() - 1) + "f"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// LIBRA ESTERLINA PARA REAL
		try {
			Document doc = Jsoup.connect("https://finance.yahoo.com/quote/GBPBRL=X?p=GBPBRL=X&.tsrc=fin-srch").get();
			String gbpString = doc.getElementsByClass("Fw(b) Fz(36px) Mb(-4px) D(ib)").text();
			setGbp(Float.parseFloat(gbpString.substring(0, gbpString.length() - 1) + "f"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// PESO CHILENO PARA REAL
		try {
			Document doc = Jsoup.connect("https://finance.yahoo.com/quote/CLPBRL=X?p=CLPBRL=X&.tsrc=fin-srch").get();
			String clpString = doc.getElementsByClass("Fw(b) Fz(36px) Mb(-4px) D(ib)").text();
			setClp(Float.parseFloat(clpString.substring(0, clpString.length() - 1) + "f"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		// Obter os valores inversos se antera obtia o valor das moedas para real, agora é de real para a moeda
		//
		// REAL PARA DÓLAR
		try {
			Document doc = Jsoup.connect("https://finance.yahoo.com/quote/BRLUSD=X?p=BRLUSD=X&.tsrc=fin-srch").get();
			String usdString = doc.getElementsByClass("Fw(b) Fz(36px) Mb(-4px) D(ib)").text();
			setBrlusd(Float.parseFloat(usdString.substring(0, usdString.length() - 1) + "f"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// REAL PARA PESO ARGENTINO
		try {
			Document doc = Jsoup.connect("https://finance.yahoo.com/quote/BRLARS=X?p=BRLARS=X&.tsrc=fin-srch").get();
			String arsString = doc.getElementsByClass("Fw(b) Fz(36px) Mb(-4px) D(ib)").text();
			setBrlars(Float.parseFloat(arsString.substring(0, arsString.length() - 1) + "f"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// REAL PARA EURO
		try {
			Document doc = Jsoup.connect("https://finance.yahoo.com/quote/BRLEUR=X?p=BRLEUR=X&.tsrc=fin-srch").get();
			String clpString = doc.getElementsByClass("Fw(b) Fz(36px) Mb(-4px) D(ib)").text();
			setBrleur(Float.parseFloat(clpString.substring(0, clpString.length() - 1) + "f"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// REAL PARA LIBRA ESTERLINA
		try {
			Document doc = Jsoup.connect("https://finance.yahoo.com/quote/BRLGBP=X?p=BRLGBP=X&.tsrc=fin-srch").get();
			String clpString = doc.getElementsByClass("Fw(b) Fz(36px) Mb(-4px) D(ib)").text();
			setBrlgbp(Float.parseFloat(clpString.substring(0, clpString.length() - 1) + "f"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// REAL PARA PESO CHILENO
		try {
			Document doc = Jsoup.connect("https://finance.yahoo.com/quote/BRLCLP=X?p=BRLCLP=X&.tsrc=fin-srch").get();
			String clpString = doc.getElementsByClass("Fw(b) Fz(36px) Mb(-4px) D(ib)").text();
			setBrlclp(Float.parseFloat(clpString.substring(0, clpString.length() - 1) + "f"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public float getUsd() {
		return usd;
	}

	public void setUsd(float usd) {
		this.usd = usd;
	}

	public float getArs() {
		return ars;
	}

	public void setArs(float ars) {
		this.ars = ars;
	}

	public float getGbp() {
		return gbp;
	}

	public void setGbp(float gbp) {
		this.gbp = gbp;
	}

	public float getClp() {
		return clp;
	}

	public void setClp(float clp) {
		this.clp = clp;
	}

	public float getEur() {
		return eur;
	}

	public void setEur(float eur) {
		this.eur = eur;
	}

	public float getBrlusd() {
		return brlusd;
	}

	public void setBrlusd(float brlusd) {
		this.brlusd = brlusd;
	}

	public float getBrlars() {
		return brlars;
	}

	public void setBrlars(float brlars) {
		this.brlars = brlars;
	}

	public float getBrleur() {
		return brleur;
	}

	public void setBrleur(float brleur) {
		this.brleur = brleur;
	}

	public float getBrlgbp() {
		return brlgbp;
	}

	public void setBrlgbp(float brlgbp) {
		this.brlgbp = brlgbp;
	}

	public float getBrlclp() {
		return brlclp;
	}

	public void setBrlclp(float brlclp) {
		this.brlclp = brlclp;
	}


}