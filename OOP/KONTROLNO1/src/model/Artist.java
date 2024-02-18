package model;
import java.util.ArrayList;

public class Artist extends Person {
    private ArrayList<Manga> mangas;
    private Manga.Style preferredStyle;

    public Artist(String firstName, String lastName, int age, ArrayList<Manga> mangas, Manga.Style preferredStyle) {
        super(firstName, lastName, age);
        this.mangas = new ArrayList<>();
        this.mangas.addAll(mangas);
        this.preferredStyle = preferredStyle;
    }

    public boolean hasOutdatedInfo() {
        int countAll = 0;
        int countPreferredStyle = 0;
        for (int i = 0; i < this.mangas.size(); i++) {
            if (this.mangas.get(i).getStyle() == preferredStyle) {
                countPreferredStyle++;
            }
            countAll++;
        }
        if(countPreferredStyle < countAll/5)
            return true;

        return false;
    }
}
