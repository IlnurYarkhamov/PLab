import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class task3 {
    public static void main(String[] args) throws IOException {
        String values = getFileContent(args[0]);
        Map<Integer, String> mapValues = new HashMap<>();
        JSONObject jsonObjectValue = new JSONObject(values);
        JSONArray jsonArray = jsonObjectValue.getJSONArray("values");
        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject current = jsonArray.getJSONObject(i);
            int id = (int) current.get("id");
            String value = (String) current.get("value");
            mapValues.put(id, value);
        }
        System.out.println(mapValues);

        String tests = getFileContent(args[1]);
        JSONObject jsonObjectTest = new JSONObject(tests);
        JSONArray testsArray = jsonObjectTest.getJSONArray("tests");
        System.out.println(jsonObjectTest);
        procces(testsArray, mapValues);
        System.out.println(jsonObjectTest);

        PrintWriter printWriter = new PrintWriter(args[2]);
        printWriter.print(jsonObjectTest);
        printWriter.close();

    }

    private static String getFileContent(String path) throws IOException {
        String content = new String(Files.readAllBytes(Path.of(path)));
        return content;
    }
    private static void procces(JSONArray jsonArray, Map<Integer, String> map) {
        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject current = jsonArray.getJSONObject(i);
            String newValue = map.get((int)current.get("id"));
            current.put("value", newValue);
            if(current.has("values")) {
                JSONArray forProcces = current.getJSONArray("values");
                procces(forProcces, map);
            }
        }
    }
}
