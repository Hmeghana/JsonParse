package com.example.meghana.jsonparse;

public class MLAItem {
    String name;
    String constituencyName;
    String party;

    public MLAItem() {
    }

    public MLAItem(String name, String constituencyName, String party) {
        this.name = name;
        this.constituencyName = constituencyName;
        this.party = party;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConstituencyName() {
        return constituencyName;
    }

    public void setConstituencyName(String constituencyName) {
        this.constituencyName = constituencyName;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }
}
