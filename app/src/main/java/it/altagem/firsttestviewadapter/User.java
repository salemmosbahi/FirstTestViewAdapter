package it.altagem.firsttestviewadapter;

public class User {
    private long id;
    private String name;

    public User(long pId, String pName) {
        id = pId;
        name = pName;
    }

    public long id() {
        return id;
    }

    public String name() {
        return name;
    }
}
