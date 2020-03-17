package io.renren.common.em;

public enum ProductTypeEnum {

    type1("1", "type1"),
    type2("2", "type2");
    
    private String id;
    private String label;
    
    private ProductTypeEnum(String id, String label) {
        setId(id);
        setLabel(label);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public String getLabelById(String id) {
        String label = "";
        if(id == null || "".equals(id)) {
            return label;
        }
        
        for (ProductTypeEnum type : ProductTypeEnum.values()) {
            if (type.getId().equals(id)) {
                label = type.getLabel();
                break;
            }
        }
        return label;
    }
}
