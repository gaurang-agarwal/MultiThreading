package desingPattern;

public class BuilderPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MobileBuilder moile = new MobileBuilder.BuilderHelper("Sony","XPERIA-Z").setCost("30000").setProcessor("Snapdragon Dual Core").build();
		
		System.out.println(moile);
	}

}

//MobileBuilder is Immutable

class MobileBuilder{
	
	private final String company;
	private final String modelName;
	private final String imeiNo;
	private final String processor;
	private final String RAM;
	private final String cost;
	
	
	private MobileBuilder(BuilderHelper builderHelper) {
		// TODO Auto-generated constructor stub
		this.company=builderHelper.company;
		this.modelName=builderHelper.modelName;
		this.imeiNo=builderHelper.imeiNo;
		this.processor=builderHelper.processor;
		this.RAM=builderHelper.RAM;
		this.cost=builderHelper.cost;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String mobile=company+" Presents "+modelName;
		if(processor!=null)
		{
			mobile+="\n"+processor;
		}
		if(RAM!=null)
		{
			mobile+="\n"+RAM;
		}
		if(cost!=null)
		{
			mobile+="\n"+cost;
		}
		return mobile;
		
	}

	public String getCompany() {
		return company;
	}

	public String getModelName() {
		return modelName;
	}

	public String getImeiNo() {
		return imeiNo;
	}

	public String getProcessor() {
		return processor;
	}

	public String getRAM() {
		return RAM;
	}

	public String getCost() {
		return cost;
	}

	public static class BuilderHelper {
		private final String company;
		private final String modelName;
		private String imeiNo;
		private String processor;
		private String RAM;
		private String cost;

		public BuilderHelper(String company,String modelName)
		{
			if(company==null || modelName==null)
				throw new NullPointerException("Company And Model Cannot be null");
			this.company=company;
			this.modelName=modelName;			
		}		
		
		public BuilderHelper setImeiNo(String imeiNo) {
			this.imeiNo = imeiNo;
			return this;
		}


		public BuilderHelper setProcessor(String processor) {
			this.processor = processor;
			return this;
		}


		public BuilderHelper setRAM(String rAM) {
			RAM = rAM;
			return this;
		}


		public BuilderHelper setCost(String cost) {
			this.cost = cost;
			return this;
		}

		public MobileBuilder build(){
			return new MobileBuilder(this);
		}
		
	}
	
}