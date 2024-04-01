package kuchen;

import verwaltung.Verkaufsobjekt;

public interface Obstkuchen extends Kuchen, Verkaufsobjekt {
    String getObstsorte();
}
