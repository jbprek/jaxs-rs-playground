package model;

import java.util.Objects;

/**
 * @author prekezes.
 */
public class Detail {
    private Long id;
    private String info;
    private DetailStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public DetailStatus getStatus() {
        return status;
    }

    public void setStatus(DetailStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detail detail = (Detail) o;
        return Objects.equals(id, detail.id) &&
                Objects.equals(info, detail.info) &&
                Objects.equals(status, detail.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, info, status);
    }
}
