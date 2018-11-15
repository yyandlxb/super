package cn.hlvan.pc.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClassifyList implements java.io.Serializable{
    private static final long serialVersionUID = 7703028796232074060L;
    private Integer id;
    @JsonProperty("pId")
    private Integer pId;
    private String name;
    private Boolean nocheck;
    private Boolean open;
    @JsonIgnore
    public Integer getpId() {
        return pId;
    }
    @JsonIgnore
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "ClassifyList{" +
               "id=" + id +
               ", pId=" + pId +
               ", name='" + name + '\'' +
               ", nocheck=" + nocheck +
               ", open=" + open +
               '}';
    }
}
