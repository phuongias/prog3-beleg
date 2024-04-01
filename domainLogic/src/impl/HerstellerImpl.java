package impl;

import verwaltung.Hersteller;

import java.io.Serializable;
import java.util.Objects;

public class HerstellerImpl implements Hersteller, Serializable {

    private String name;

    public HerstellerImpl(String name) { //Konstrukor
        this.name = name;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) { //Quellen: https://stackoverflow.com/questions/8180430/how-to-override-equals-method-in-java
        if (this == obj) { //ChatGpt
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HerstellerImpl hersteller = (HerstellerImpl) obj;
        return Objects.equals(name, hersteller.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }

}
