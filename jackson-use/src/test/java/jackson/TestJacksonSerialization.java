package jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import model.Detail;
import model.DetailStatus;
import model.MyValue;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.*;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @author prekezes.
 */
public class TestJacksonSerialization {
    private static final Logger log = Logger.getGlobal();


    private static final ObjectMapper mapper = new ObjectMapper();

    static {

        /*
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
// to allow serialization of "empty" POJOs (no properties to serialize)
// (without this setting, an exception is thrown in those cases)
mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

Most JSR-310 types are serialized as numbers (integers or decimals as appropriate) if the SerializationFeature#WRITE_DATES_AS_TIMESTAMPS feature is enabled, and otherwise are serialized in standard ISO-8601 string representation. ISO-8601 specifies formats for representing offset dates and times, zoned dates and times, local dates and times, periods, durations, zones, and more. All JSR-310 types have built-in translation to and from ISO-8601 formats.

Granularity of timestamps is controlled through the companion features SerializationFeature#WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS and DeserializationFeature#READ_DATE_TIMESTAMPS_AS_NANOSECONDS. For serialization, timestamps are
         */
    }

    @BeforeClass
    public static void setup() {
        log.info("A3");
        SimpleModule module = new SimpleModule();
//        module.addSerializer(TestJa)
//        mapper.
    }


    /*
     * Formats Instant using Java 8
     */
    @Test
    public void testIso8601Format() {
        Instant t = Instant.now();
        String s  = DateTimeFormatter.ISO_INSTANT.format(t);
        System.out.println(s);
        Instant t1 = Instant.parse(s);
        Assert.assertEquals(t,t1);
    }


    @Test
    public void testMyValueMarshall() throws JsonProcessingException {
        mapper.findAndRegisterModules();
//        mapper.registerModule(new AfterburnerModule());
//        mapper.registerModule(new JSR310Module());

        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

//        mapper.disable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS);
//        mapper.disable(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS);

        MyValue obj = new MyValue();
        obj.age = 150;
        obj.name = "Mathusala";
        obj.date = Instant.now();

        String jsonString = mapper.writeValueAsString(obj);
        System.out.println(jsonString);
    }

    @Test
    public void testDetailMarshall() throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();

        Detail detail = new Detail();
        detail.setId(1L);
        detail.setInfo("info string");
        detail.setStatus(DetailStatus.OFF);
        String detailJson = mapper.writeValueAsString(detail);
        System.out.println(detailJson);
    }

}
