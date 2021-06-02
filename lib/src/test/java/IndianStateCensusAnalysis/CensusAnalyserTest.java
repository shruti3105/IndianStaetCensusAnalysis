package IndianStateCensusAnalysis;

import static org.junit.Assert.assertEquals;

import  org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {

	private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\Mr_Robot\\Desktop\\Fellowship\\IndianStateCensusAnalyser\\lib\\src\\test\\resources\\IndiaStateCensusData.csv";
	private static final String INDIA_CENSUS_WRONG_CSV_FILE_PATH = "C:\\Users\\eclipse-workspace\\CensusAnalyser\\static\\IndiaStateCensusData.csv";

	private static final String INDIA_CENSUS_WRONG_FILE_TYPE_PATH = "C:\\Users\\AB\\eclipse-workspace\\CensusAnalyser\\static\\IndiaStateCensusData.pdf";
	private static final String INDIA_CENSUS_WRONG_DELIMITER_FILE_PATH = "C:\\Users\\AB\\eclipse-workspace\\CensusAnalyser\\static\\ IndiaStateCensusData.csv";
	private static final String INDIA_CENSUS_WITHOUT_HEADER_FILE_PATH = "C:\\Users\\AB\\eclipse-workspace\\CensusAnalyser\\static\\IndiaStateCensusDataNoHeader.csv";


	private static CensusAnalyser censusAnalyser;
	
	@BeforeClass
	public static void censusAnalyserObject() {
		censusAnalyser = new CensusAnalyser();
	}
    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            assertEquals(29,numOfRecords );
        } catch (CensusAnalyserException e) { }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            @SuppressWarnings("deprecation")
			ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
           assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
    @Test
	public void givenIndiaCensusData_WithWrongFileType_ShouldThrowException() {
		try {

			@SuppressWarnings("deprecation")
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_WRONG_FILE_TYPE_PATH);
		} catch (CensusAnalyserException e) {
			assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE, e.type);
		}

	}
    @Test
	public void givenIndiaCensusData_WithWrongFileDelimiter_ShouldThrowException() {
		try {

			@SuppressWarnings("deprecation")
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_WRONG_DELIMITER_FILE_PATH);
		} catch (CensusAnalyserException e) {
			assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
		}

	}	
    @Test
	public void givenIndiaCensusData_WithWrongFileWithNoHeader_ShouldThrowException() {
		try {

			@SuppressWarnings("deprecation")
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_WITHOUT_HEADER_FILE_PATH);
		} catch (CensusAnalyserException e) {
			assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
		}

	}
}
