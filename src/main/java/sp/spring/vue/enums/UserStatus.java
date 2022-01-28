package sp.spring.vue.enums;

public enum UserStatus {
    NEW(1L, "new"),
    WAITING(2L, "waiting"),
    CONFIRMED(3L, "confirmed");

    private Long id;
    private String name;

    UserStatus(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
