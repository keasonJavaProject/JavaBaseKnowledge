package com.ongl;

public class SlEmployee implements java.io.Serializable {
  
    private static final long serialVersionUID = 4873217019660076767L;  
  
    private SlDept slDept;  
      
    private String name;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //    也返回name ，用作ongl函数测试
    public String getPackName() {
        return name;
    }

    public SlEmployee() {
    }  
  
    public SlDept getSlDept() {  
        return slDept;  
    }  
  
    public void setSlDept(SlDept slDept) {  
        this.slDept = slDept;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
}  
