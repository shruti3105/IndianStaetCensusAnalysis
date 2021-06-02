package IndianStateCensusAnalysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser {
    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
    	 int numOfEnteries = 0;
    	try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();           
            while (censusCSVIterator.hasNext()) {
            	numOfEnteries++;
                IndiaCensusCSV censusData = censusCSVIterator.next();
            }
            System.out.println("CensusAnalyserException:"+numOfEnteries);
        }catch (NoSuchFileException e) {
        	if(!csvFilePath.contains(".csv")) {
        		throw new CensusAnalyserException(e.getMessage(),CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
        	}
        }catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }catch(RuntimeException e) {
        	throw new CensusAnalyserException(e.getMessage(),CensusAnalyserException.ExceptionType.NO_SUCH_FILE);
        }
        
    	
    	  return numOfEnteries;
    }
  
}