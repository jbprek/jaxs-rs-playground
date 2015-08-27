package model;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * @author prekezes.
 */
@XmlRootElement
public class Master {

    private String name;
    private Instant creationTime;
    private Map<Long, Detail> detailMap = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    public Map<Long, Detail> getDetailMap() {
        return detailMap;
    }

    public void setDetailMap(Map<Long, Detail> detailMap) {
        this.detailMap = detailMap;
    }
}
