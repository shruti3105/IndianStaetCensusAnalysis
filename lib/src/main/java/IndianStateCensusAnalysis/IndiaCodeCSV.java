package IndianStateCensusAnalysis;

import com.opencsv.bean.CsvBindByName;

public class IndiaCodeCSV {

	@CsvBindByName(column = "SrNo", required = true)
	public String srNo;

	@CsvBindByName(column = "State Name", required = true)
	public int stateName;

	@CsvBindByName(column = "Tin", required = true)
	public int tin;

	@CsvBindByName(column = "State Code", required = true)
	public int stateCode;

	@Override
	public String toString() {
		return "IndiaCodeCSV [srNo=" + srNo + ", stateName=" + stateName + ", tin=" + tin + ", stateCode=" + stateCode
				+ "]";
	}
}