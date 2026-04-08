package lovelyPrasadOrg.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataReader {
    public List<HashMap<String, String>> getDataToMap() throws IOException {
        String jsonPath = System.getProperty("user.dir") + "/src/test/java/lovelyPrasadOrg/data/data.json";
        String jsonContent = FileUtils.readFileToString(new File(jsonPath), StandardCharsets.UTF_8);
        
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
    return data;
    }
}
