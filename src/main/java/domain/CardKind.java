package domain;

public enum CardKind {

    DIAMOND("다이아몬드"),
    HEART("하트"),
    SPADE("스페이드"),
    CLOVER("클로버");

    private final String kind;

    CardKind(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return this.kind;
    }


}
