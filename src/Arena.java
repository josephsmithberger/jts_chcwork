import java.util.ArrayList;
import java.util.List;

/*DRIVER*/
public class Arena {
    public static void main(String[] args) {
        // build all districts once
        District d1  = new District(Region.ROCKY_MOUNTAINS, 1,  "Luxury Goods");
        District d2  = new District(Region.ROCKY_MOUNTAINS, 2,  "Defense / Masonry");
        District d3  = new District(Region.GREAT_PLAINS,     3,  "Technology");
        District d4  = new District(Region.WEST_COAST,       4,  "Fishing");
        District d5  = new District(Region.SOUTHWEST,        5,  "Power Generation");
        District d6  = new District(Region.GREAT_LAKES,      6,  "Transportation");
        District d7  = new District(Region.NORTHWEST,        7,  "Lumber");
        District d8  = new District(Region.EAST_COAST,       8,  "Textiles");
        District d9  = new District(Region.MIDWEST,          9,  "Grain");
        District d10 = new District(Region.SOUTH,           10,  "Livestock");
        District d11 = new District(Region.SOUTH,           11,  "Agriculture");
        District d12 = new District(Region.APPALACHIA,      12,  "Mining");

        HungerGames hg74 = new HungerGames(74);
        
        hg74.addTribute(new Tribute(d1,  "Marvel",           17, "M", "Spears"));
        hg74.addTribute(new Tribute(d1,  "Glimmer",          16, "F", "Archery"));
        hg74.addTribute(new Tribute(d2,  "Cato",             18, "M", "Swordsmanship"));
        hg74.addTribute(new Tribute(d2,  "Clove",            15, "F", "Knife‑throwing"));
        hg74.addTribute(new Tribute(d3,  "Chase",            16, "M", "Electronics"));
        hg74.addTribute(new Tribute(d3,  "Maylie",           15, "F", "Traps"));
        hg74.addTribute(new Tribute(d4,  "Max",              17, "M", "Trident"));
        hg74.addTribute(new Tribute(d4,  "Marina",           16, "F", "Nets"));
        hg74.addTribute(new Tribute(d5,  "Foxface",          17, "F", "Strategy"));
        hg74.addTribute(new Tribute(d5,  "Henson",           18, "M", "Ambush"));
        hg74.addTribute(new Tribute(d6,  "Jason",            16, "M", "Throwing Knives"));
        hg74.addTribute(new Tribute(d6,  "Tamora",           16, "F", "Endurance"));
        hg74.addTribute(new Tribute(d7,  "Kristof",          18, "M", "Axes"));
        hg74.addTribute(new Tribute(d7,  "Maple",            14, "F", "Climbing"));
        hg74.addTribute(new Tribute(d8,  "Fuller",           17, "M", "Garrote"));
        hg74.addTribute(new Tribute(d8,  "Savannah",         15, "F", "Sneak"));
        hg74.addTribute(new Tribute(d9,  "Rye",              17, "M", "Scythe"));
        hg74.addTribute(new Tribute(d9,  "Demetria",         16, "F", "Camouflage"));
        hg74.addTribute(new Tribute(d10, "Timmer",           18, "M", "Strength"));
        hg74.addTribute(new Tribute(d10, "Susan",            16, "F", "Knife‑skills"));
        hg74.addTribute(new Tribute(d11, "Thresh",           18, "M", "Strength"));
        hg74.addTribute(new Tribute(d11, "Rue",              12, "F", "Agility"));
        hg74.addTribute(new Tribute(d12, "Peeta Mellark",    16, "M", "Camouflage"));
        hg74.addTribute(new Tribute(d12, "Katniss Everdeen", 16, "F", "Archery"));

        System.out.println(hg74);
    }
}

/* ENUM & VALUE OBJECTS*/
enum Region {
    ROCKY_MOUNTAINS("Rocky Mountains"),
    GREAT_PLAINS("Great Plains"),
    WEST_COAST("West Coast"),
    SOUTHWEST("Southwest"),
    GREAT_LAKES("Great Lakes"),
    NORTHWEST("Northwest"),
    EAST_COAST("East Coast"),
    MIDWEST("Midwest"),
    SOUTH("South"),
    APPALACHIA("Appalachia");

    private final String label;
    Region(String lbl) { label = lbl; }
    public String toString() { return label; }
}

class District {
    private final int number;
    private final Region region;
    private final String industry;

    public District(Region reg, int num, String ind) {
        if (num < 1)  num = 1;
        if (num > 13) num = 13;
        number   = num;
        region   = reg;
        industry = ind;
    }

    public int getNumber()    { return number; }
    public Region getRegion() { return region; }
    public String getIndustry() { return industry; }

    public String toString() {
        return "District " + number + " — " + industry + " (" + region + ")";
    }
}

/*  PEOPLE*/
abstract class Citizen {
    protected String name;
    protected int age;
    protected String gender;

    protected Citizen(String n, int a, String g) {
        name = n;
        age = a;
        gender = g;
    }

    public abstract String description();
}

class CapitalCitizen extends Citizen {
    private String title;

    public CapitalCitizen(String n, int a, String g, String t) {
        super(n, a, g);
        title = t;
    }

    public String description() {
        return title + " " + name + ", " + age + "-year-old " + gender.toLowerCase();
    }
}

class DistrictResident extends Citizen {
    protected District district;

    public DistrictResident(District d, String n, int a, String g) {
        super(n, a, g);
        district = d;
    }

    // make this class concrete
    public String description() {
        return name + ", District " + district.getNumber() + " resident";
    }

    // expose the district number so subclasses (Tribute) can call it
    public int getDistrictNumber() {
        return district.getNumber();
    }
}

class Tribute extends DistrictResident {
    private String skill;

    public Tribute(District d, String n, int a, String g, String s) {
        super(d, n, a, g);
        skill = s;
    }

    public String description() {
        return name + " (" + gender + ", " + age + ") - " + skill;
    }
}

/* HUNGER GAMES EDITION  */
class HungerGames {
    private final int edition;
    private final List<Tribute> tributes = new ArrayList<>();

    public HungerGames(int ed) {
        edition = ed;
    }

    public void addTribute(Tribute t) {
        tributes.add(t);
    }

    public String toString() {
        String result = "\n—  The " + edition + "th Hunger Games  —\n" + "Let the Capitol present this year's tributes! May the odds be EVER in your favor.\n\n";
        int lastDistrict = -1;
        for (Tribute t : tributes) {
            int cur = t.getDistrictNumber();
            if (cur != lastDistrict) {
                result += "District " + cur + ":\n";
                lastDistrict = cur;
            }
            result += "  • " + t.description() + "\n";
        }
        return result;
    }
}