public class Employee extends Person implements Printable, SeasonHandler{
    private String position;
    private String departmentName;
    private int salary;
    private Season season;

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Employee() {
    }

    public Employee(int id) {
        super(id);
    }

    public Employee(int id, String firstName, String lastName, String email, String position, String departmentName, int salary, Season season) {
        super(id, firstName, lastName, email);
        this.position = position;
        this.departmentName = departmentName;
        this.salary = salary;
        this.season = season;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String PersonInfo() {
        return "Сведения о записи: " + this.getClass().getName() +
            "\n\t"+ (String.valueOf(super.getId()) != null ? "_ID : " + super.getId() : this.hashCode()) +
            (super.lastName != null ? "\n\tФИО : " + super.lastName + " " +  super.firstName: "") +
            (this.departmentName!=null ? "\n\tПодразделение : " + this.departmentName : "") +
            (this.position!=null ? "\n\tДолжность : " + this.position : "") +
            (this.getEmail()!=null ? "\n\temail : " + super.getEmail() : "");
    }

    @Override
    public void sendSMS(String text) {
        System.out.println(this.getClass().getName()+"> Отправка смс сотруднику");
    }

    @Override
    public void Print() {
        System.out.println(
            "{" +
                "\n\t\"ID\" : \"" + (String.valueOf(super.getId()) == null ? "" : super.getId()) + "\"," +
                "\n\t\"ФИО\" : \"" + (super.lastName == null ? "" : super.lastName + " ")  + (super.firstName == null ? "" : super.firstName) + "\"," +
                "\n\t\"Подразделение\" : \"" + (this.departmentName == null ? "" : this.departmentName) + "\"," +
                "\n\t\"Должность\" : \"" + (this.position == null ? "" : this.position) + "\"," +
                "\n\t\"email\" : \"" + (super.getEmail() == null ? "" : super.getEmail()) + "\"," +
            "\n}"
        );
    }

    @Override
    public void favoriteSeason() {
        if (this.season != null) {
            System.out.println("У сотрудника любимое время года: " + this.season.name() +
                    ". Цвет сезона: " + Season.colorName(this.season.getColor()));
        } else {
            System.out.println("Нет данных");
        }
    }
}
