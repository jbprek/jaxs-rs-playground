package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Detail;
import model.DetailStatus;
import model.Master;
import model.MyValue;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author prekezes.
 */
public class TestJacksonSerialization {
    private static final Logger log = Logger.getGlobal();

    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        System.out.println("A2");
    }

    /*
     * Formats Instant using Java 8  to 8601 format
     */
    @Test
    public void testIso8601Format() {
        Instant t = Instant.now();
        String s = DateTimeFormatter.ISO_INSTANT.format(t);
        System.out.println(s);
        Instant t1 = Instant.parse(s);
        Assert.assertEquals(t, t1);
    }

    @Test
    public void testMyValueMarshall() throws IOException {
        Instant now = Instant.now();
        String nowString = DateTimeFormatter.ISO_INSTANT.format(now);

        MyValue obj = new MyValue();
        obj.age = 150;
        obj.name = "Mathusala";
        obj.date = now;

        MyValue obj1 = new MyValue();
        obj1.age = 150;
        obj1.name = "Mathusala";
        obj1.date = now;

//        System.out.println(mapper.writeValueAsString(obj));
//        System.out.println(mapper.writeValueAsString(obj1));
        Assert.assertEquals(obj, obj1);

        String jsonString = mapper.writeValueAsString(obj);
        String inJson = "{\n" +
                "  \"name\" : \"Mathusala\",\n" +
                "  \"age\" : 150,\n" +
                "  \"date\" : \"" +
                nowString +
                "\"\n" +
                "}";

        MyValue unmarshalled = mapper.readValue(inJson, MyValue.class);

        Assert.assertEquals(obj, unmarshalled);
    }

    @Test
    public void testDetail() throws IOException {
//        ObjectMapper mapper = new ObjectMapper();

        Detail detail = new Detail();
        detail.setId(1L);
        detail.setInfo("info string");
        detail.setStatus(DetailStatus.OFF);
        String detailJson = mapper.writeValueAsString(detail);
        System.out.println(detailJson);
        Detail unmarshalled = mapper.readValue(detailJson, Detail.class);
        Assert.assertEquals(detail,unmarshalled);

        Map<String, Object> map = mapper.convertValue(detail, Map.class);
        System.out.println(map);
    }

    @Test
    public void testMasterDetail() throws IOException {

        Master master = new Master();
        master.setName("Kung Fu Tse");
        master.setCreationTime(Instant.now());

        for (long i = 0; i < 3; i++) {
            Detail detail = new Detail();
            detail.setId(i);
            detail.setInfo("Detail " + i);
            detail.setStatus(DetailStatus.OFF);
            master.getDetailMap().put(i, detail);
        }


        String masterJson = mapper.writeValueAsString(master);
        System.out.println(masterJson);
        Master unmarshalled = mapper.readValue(masterJson, Master.class);
        Assert.assertEquals(master,unmarshalled);

        Map<String, Object> map = mapper.convertValue(master, Map.class);
        System.out.println(map);
    }

}
