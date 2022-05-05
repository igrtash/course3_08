public class Client extends Person implements Printable, SeasonHandler{
    private String companyName;
    private String industry;
    private Season season;

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Client() {
        }

    public Client(int id) {
        super(id);
    }

    public Client(String companyName, String industry) {
        this.companyName = companyName;
        this.industry = industry;
    }

    public Client(int id, String firstName, String lastName, String email, String companyName, String industry, Season season) {
        super(id, firstName, lastName, email);
        this.companyName = companyName;
        this.industry = industry;
        this.season = season;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Override
    public String PersonInfo() {
        return "Сведения о записи: " + this.getClass().getName() +
            (String.valueOf(super.getId()) != null ? "_ID = " + super.getId() : this.hashCode()) +
            (super.lastName != null ? "\n\tФИО = " + super.lastName + " " +  super.firstName: "") +
            (this.getCompanyName()!=null ? "\n\tОрганизация = " + this.getCompanyName() : "") +
            (this.getEmail()!=null ? "\n\temail = " + super.getEmail() : "");
    }

    @Override
    public void Print() {
        System.out.println(
            "<" + this.getClass().getName() + ">" +
                "\n\t<ID>" + (String.valueOf(super.getId()) == null ? "" : super.getId()) + "</ID>" +
                "\n\t<FIRSTNAME>" + (super.firstName == null ? "" : super.firstName) + "</FIRSTNAME>" +
                "\n\t<LASTNAME>" + (super.lastName == null ? "" : super.lastName) + "</LASTNAME>" +
                "\n\t<COMPANY>" + (this.getCompanyName() == null ? "" : this.getCompanyName().replace("\"","&quot;")) + "</COMPANY>" +
                "\n\t<INDUSTRY>" + (this.getIndustry() == null ? "" : this.getIndustry()) + "</INDUSTRY>" +
                "\n\t<EMAIL>" + (this.getEmail() == null ? "" : super.getEmail()) + "</EMAIL>" +
            "\n</" + this.getClass().getName() + ">"
        );
    }

    @Override
    public void favoriteSeason() {
        if (this.season !=null) {
            System.out.println("У клиента любимое время года: " + this.season.name() +
                    ". Возможно ему наврится цвет : " + Season.colorName(this.season.getColor()));
        } else {
            System.out.println("нет сведений о любимом времени года");
        }
    }
}
