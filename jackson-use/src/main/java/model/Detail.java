package model;

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
}
