package sp.spring.vue.enums;

public enum UserType {
    CUSTOMER(1L, "customer"),
    EXPERT(2L, "expert");

    private Long id;
    private String name;

    UserType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
