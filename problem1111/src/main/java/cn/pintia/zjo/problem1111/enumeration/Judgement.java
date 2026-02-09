package cn.pintia.zjo.problem1111.enumeration;

public enum Judgement {
    Player1Win("Player1 wins."),
    Tie("Tie."),
    Player2Win("Player2 wins."),
    ;
    private String description;

    Judgement(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
