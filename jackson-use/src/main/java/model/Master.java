package model;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author prekezes.
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Master master = (Master) o;
        return Objects.equals(name, master.name) &&
                Objects.equals(creationTime, master.creationTime) &&
                Objects.equals(detailMap, master.detailMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creationTime, detailMap);
    }
}
